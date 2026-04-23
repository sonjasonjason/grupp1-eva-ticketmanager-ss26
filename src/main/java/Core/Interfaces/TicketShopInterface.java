package Core.Interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import Core.Models.Event;

public interface TicketShopInterface {
    List<Event> getAllEvents();
    Event createEvent(String name, String location, LocalDateTime time, int ticketsAvailable);
    Event getEventById(UUID id);
    void updateEvent(Event event);
    void deleteEvent(UUID id);
    void deleteAllEvents();

}
