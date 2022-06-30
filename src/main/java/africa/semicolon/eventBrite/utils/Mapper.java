package africa.semicolon.eventBrite.utils;

import africa.semicolon.eventBrite.data.models.User;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.LogInUserResponse;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        return user;
    }

    public static void map(RegisterUserRequest request, User user) {
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
    }

    public static void map(User savedUser, RegisterUserResponse response) {
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm a")
                .format(savedUser.getLocalDateTime()));
    }
    public static void map(User user, LogInUserResponse response){
        response.setFirstName(user.getFirstName());
        response.setMessage("Welcome back, " + response.getFirstName().toUpperCase() + "!!");
    }
}
