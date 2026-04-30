package Core.Services;

import Core.Models.exceptions.CustomerException;
import Core.Models.exceptions.EventException;
import Core.Models.exceptions.TicketException;
import Core.Interfaces.TicketServiceInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        
        Ticket ticket = new Ticket(UUID.randomUUID(), LocalDate.now(), customerId, eventId);
        validateTicket(ticket);
        customerService.addTicketToCustomer(ticket);
        eventService.ticketSoldForEvent(ticket);
        ticketsById.put(ticket.getId(), ticket);

        return ticket;
    }

    @Override
    public Ticket getTicketById(UUID id) throws TicketException {

        if (ticketsById.get(id) == null){
            throw TicketException.ticketDoesNotExist();
        }
        
        return ticketsById.get(id);
    }

    @Override
    public List<Ticket> getAllTickets() {

        List<Ticket> tickets = new ArrayList<>(ticketsById.values());

        return tickets;
    }

    @Override
    public void deleteTicket(UUID id) throws IllegalArgumentException {

        if (id == null){
            throw new IllegalArgumentException("Ticket ID cannot be null");
        }
        ticketsById.remove(id);

    }

    @Override
    public void deleteAllTickets() {

        ticketsById.clear();

    }

    private void validateTicket(Ticket ticket) throws TicketException, CustomerException, EventException {

        if (ticket.getCustomerId() == null){
            throw CustomerException.customerDoesNotExist();
        }
        if (ticket.getEventId() == null){
            throw EventException.eventDoesNotExist();
        }
        if (customerService.getCustomerById(ticket.getCustomerId()).getTicketsBought().size() == 5){
            throw TicketException.maximumNumberOfTickets();
        }
        if (!eventService.getEventById(ticket.getEventId()).hasAvailableTickets()){
            throw TicketException.noTicketsAvailable();
        }

    }

    @Override
    public boolean verifyTicket(UUID id) {

        //TODO

        return false;
    }

}
