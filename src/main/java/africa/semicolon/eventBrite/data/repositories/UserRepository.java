package africa.semicolon.eventBrite.data.repositories;

import africa.semicolon.eventBrite.data.models.User;
import africa.semicolon.eventBrite.dtos.requests.LogInUserRequest;
import africa.semicolon.eventBrite.dtos.responses.LogInUserResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
