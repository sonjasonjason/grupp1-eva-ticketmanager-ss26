package Core.TicketShop;

import Core.Interfaces.TicketShopInterface;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import Core.Models.Event;
import Core.Services.EventService;

public class LocalTicketShop implements TicketShopInterface {

    private final EventService eventService;

    public LocalTicketShop() {
        this.eventService = new EventService();
    }

    // Event operations
    @Override
    public Event createEvent(
            String name,
            String location,
            LocalDateTime time,
            int tickets
    ) {
        return eventService.createEvent(name, location, time, tickets);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Override
    public Event getEventById(UUID id) {
        return eventService.getEventById(id);
    }

    @Override
    public void updateEvent(Event event) {
        eventService.updateEvent(event);
    }

    @Override
    public void deleteEvent(UUID id) {
        eventService.deleteEvent(id);
    }

    @Override
    public void deleteAllEvents() {
        eventService.deleteAllEvents();
    }

}
