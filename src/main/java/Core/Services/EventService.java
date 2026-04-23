package Core.Services;

import Core.Interfaces.EventServiceInterface;
import Core.Models.Event;
import Core.Models.exceptions.EventException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventService implements EventServiceInterface {

    List<Event> events =  new ArrayList<>();

    public Event createEvent(String name, String location, LocalDateTime time, int ticketsAvailable) throws EventException {

        Event event = new Event(UUID.randomUUID(), name, location, time, ticketsAvailable);
        events.add(event);

        return new Event(event.getId(), name, location, time, ticketsAvailable);
        //return event;
    }

    @Override
    public Event getEventById(UUID id) {

        var eventOpt = this.events.stream().filter(event -> event.getId().equals(id)).findFirst();

        if (eventOpt.isEmpty()) {
            throw EventException.eventDoesNotExist();
        }

        return eventOpt.get();
    }

    @Override
    public void updateEvent(Event event) throws EventException {

        validateUpdatedEvent(event);

        var existingEvent = getEventById(event.getId());

        existingEvent.setName(event.getName());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setTime(event.getTime());
        existingEvent.setTicketsAvailable(event.getTicketsAvailable().get());
    }

    private void validateUpdatedEvent(Event event){

        var existingEvent = getEventById(event.getId());

        if (event.getTime().isBefore(LocalDateTime.now())) {
            throw EventException.cantSetEventTimeIntoPast();
        }

        if (event.getTicketsAvailable().get() < existingEvent.getTicketsAvailable().get()) {
            throw EventException.shouldNotReduceAvailableTicketsWithUpdate();
        }
    }


    @Override
    public void deleteEvent(UUID id) {

        this.events.removeIf(event -> event.getId().equals(id));

    }

    @Override
    public List<Event> getAllEvents() {

        return this.events;
    }

    @Override
    public void deleteAllEvents() {

        this.events.clear();
    }


}
