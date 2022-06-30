package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.repositories.UserRepository;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUserTest(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("yunu@gmail.com");
        request.setFirstName("long");
        request.setLastName("hunm");
        request.setPassword("888");

        userService.register(request);
        assertEquals(1, userRepository.count());
    }

}