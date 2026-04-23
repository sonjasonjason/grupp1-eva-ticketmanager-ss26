package Core.Services;

import Core.Models.exceptions.CustomerException;
import Core.Models.exceptions.EventException;
import Core.Models.exceptions.TicketException;
import Core.Interfaces.TicketServiceInterface;
import java.util.*;
import Core.Models.Ticket;

public class TicketService implements TicketServiceInterface {

    private final Map<UUID, Ticket> ticketsById = new HashMap<>();
    private CustomerService customerService;
    private EventService eventService;

    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    public void setEventService(EventService eventService){
        this.eventService = eventService;
    }

    @Override
    public Ticket createTicket(UUID customerId, UUID eventId) throws TicketException, EventException, CustomerException {

        //TODO

        return null;
    }

    @Override
    public Ticket getTicketById(UUID id) throws TicketException {

        //TODO

        return null;
    }

    @Override
    public List<Ticket> getAllTickets() {

        //TODO

        return null;
    }

    @Override
    public void deleteTicket(UUID id) throws IllegalArgumentException {

        //TODO

    }

    @Override
    public void deleteAllTickets() {

        //TODO

    }

    private void validateTicket(Ticket ticket) throws TicketException, CustomerException, EventException {

        //TODO

    }

    @Override
    public boolean verifyTicket(UUID id) {

        //TODO

        return false;
    }

}
