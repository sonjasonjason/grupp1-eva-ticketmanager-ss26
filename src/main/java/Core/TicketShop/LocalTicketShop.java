package Core.TicketShop;

import Core.Models.exceptions.TicketException;
import Core.Interfaces.TicketShopInterface;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import Core.Models.Customer;
import Core.Models.Event;
import Core.Models.Ticket;
import Core.Services.CustomerService;
import Core.Services.EventService;
import Core.Services.TicketService;

public class LocalTicketShop implements TicketShopInterface {

    private final EventService eventService;
    private final CustomerService customerService;
    private final TicketService ticketService;

    public LocalTicketShop() {
        this.ticketService = new TicketService();
        this.customerService = new CustomerService(ticketService);
        this.eventService = new EventService(ticketService);
        ticketService.setCustomerService(customerService);
        ticketService.setEventService(eventService);

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

    // Customer operations
    @Override
    public Customer createCustomer(
        String username,
        String email,
        LocalDate dateOfBirth
    ) {
        return customerService.createCustomer(username, email, dateOfBirth);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerService.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerService.deleteCustomer(id);
    }

    @Override
    public void deleteAllCustomers() {
        customerService.deleteAllCustomers();
    }

    // Ticket Operations
    @Override
    public Ticket createTicket(UUID customerId, UUID eventId)
        throws TicketException {
        return ticketService.createTicket(customerId, eventId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @Override
    public Ticket getTicketById(UUID id) throws TicketException {
        return ticketService.getTicketById(id);
    }

    @Override
    public void deleteTicket(UUID id) {
        ticketService.deleteTicket(id);
    }

    @Override
    public void deleteAllTickets() {
        ticketService.deleteAllTickets();
    }

    @Override
    public boolean verifyTicket(UUID id) {
        return ticketService.verifyTicket(id);
    }
}
