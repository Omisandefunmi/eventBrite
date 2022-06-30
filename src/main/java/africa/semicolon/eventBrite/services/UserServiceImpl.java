package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.models.Event;
import africa.semicolon.eventBrite.data.models.User;
import africa.semicolon.eventBrite.data.repositories.UserRepository;
import africa.semicolon.eventBrite.dtos.requests.CreateEventRequest;
import africa.semicolon.eventBrite.dtos.requests.LogInUserRequest;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.CreateEventResponse;
import africa.semicolon.eventBrite.dtos.responses.LogInUserResponse;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;
import africa.semicolon.eventBrite.exceptions.LogInException;
import africa.semicolon.eventBrite.exceptions.RegisterUserException;
import africa.semicolon.eventBrite.exceptions.UserDoesNotExistException;
import africa.semicolon.eventBrite.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserRepository userRepository;
//    Example of Constructor Injection
//    public UserServiceImpl(@Autowired UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) throw new RegisterUserException("User already exists!!!");
        User user = new User();
        Mapper.map(request, user);
        RegisterUserResponse response = new RegisterUserResponse();
        User savedUser = userRepository.save(user);
        Mapper.map(savedUser, response);
        return response;

    }

    public LogInUserResponse logIn(LogInUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new LogInException("User not correct"));
        LogInUserResponse logInResponse = new LogInUserResponse();
        if (request.getPassword().equals(user.getPassword())) {
            Mapper.map(user, logInResponse);
        }
        return logInResponse;
    }

    @Override
    public CreateEventResponse addParty(CreateEventRequest request) {
        Optional <User> optionalUser = userRepository.findByEmail(request.getCreatorEmail());
        if(optionalUser.isEmpty()) throw new UserDoesNotExistException(request.getCreatorEmail()+" does not exist");
        User foundUser = optionalUser.get();
        Event event = new Event();
        event.setLocation(request.getEventLocation());
        event.setTheme(request.getEventName());
        Event savedEvent = eventService.saveEvent(event);
        foundUser.getEvents().add(savedEvent);
        userRepository.save(foundUser);

        CreateEventResponse response = new CreateEventResponse();
        response.setPartyName(savedEvent.getTheme());
        response.setCreatedBy(foundUser.getFirstName());
        response.setLocation(savedEvent.getLocation());
        return response;
    }

    private boolean isEmailAlreadyExist(String email) {
        return userRepository.existsByEmail(email);
    }
}