package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.models.Event;
import africa.semicolon.eventBrite.data.repositories.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventServiceImplTest {
    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void addNewEvent(){
       Event event = new Event();

       Event savedEvent = eventRepository.save(event);
       assertEquals(1, eventRepository.count());

    }

}