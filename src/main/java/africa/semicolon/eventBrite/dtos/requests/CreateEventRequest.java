package africa.semicolon.eventBrite.dtos.requests;

import lombok.Data;

@Data
public class CreateEventRequest {
    private String eventName;
    private String eventLocation;
    private String creatorEmail;
}
