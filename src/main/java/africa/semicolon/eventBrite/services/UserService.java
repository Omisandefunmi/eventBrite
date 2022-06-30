package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.dtos.requests.CreateEventRequest;
import africa.semicolon.eventBrite.dtos.requests.LogInUserRequest;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.CreateEventResponse;
import africa.semicolon.eventBrite.dtos.responses.LogInUserResponse;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register (RegisterUserRequest request);
    LogInUserResponse logIn(LogInUserRequest request);

    CreateEventResponse addParty(CreateEventRequest request);
}
