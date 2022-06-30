package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.models.Event;

public interface EventService {
    Event saveEvent(Event event);
}
