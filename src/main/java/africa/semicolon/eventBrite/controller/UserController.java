package africa.semicolon.eventBrite.controller;


import africa.semicolon.eventBrite.dtos.requests.CreateEventRequest;
import africa.semicolon.eventBrite.dtos.requests.LogInUserRequest;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.ApiResponse;
import africa.semicolon.eventBrite.dtos.responses.LogInUserResponse;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;
import africa.semicolon.eventBrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
   public ResponseEntity <?> register(@RequestBody RegisterUserRequest request){
       try {
           var serviceResponse = userService.register(request);
           ApiResponse response = new ApiResponse(true, serviceResponse);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
       }
       catch (Exception ex){
           ApiResponse response = new ApiResponse(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);}
    }

    @PostMapping("/login")
  public  LogInUserResponse login(@RequestBody LogInUserRequest request){
        return userService.logIn(request);
    }

    @PostMapping("/createEvent")
    public ResponseEntity <?> createEvent(@RequestBody CreateEventRequest request){
        try {
            var serviceResponse = userService.addParty(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, CREATED);
        }catch (Exception ex){
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, BAD_REQUEST);
        }
    }

}
