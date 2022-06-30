package africa.semicolon.eventBrite.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class Event {
    @Id
    private String id;
    private String theme;
    private String location;

}
