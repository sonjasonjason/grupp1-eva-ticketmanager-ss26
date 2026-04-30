package Core.Interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import Core.Models.exceptions.TicketException;
import Core.Models.Customer;
import Core.Models.Event;
import Core.Models.Ticket;

public interface TicketShopInterface {
    List<Event> getAllEvents();
    Event createEvent(String name, String location, LocalDateTime time, int ticketsAvailable);
    Event getEventById(UUID id);
    void updateEvent(Event event);
    void deleteEvent(UUID id);
    void deleteAllEvents();

    List<Customer> getAllCustomers();
    Customer createCustomer(String username, String email, LocalDate dateOfBirth);
    Customer getCustomerById(UUID id);
    void updateCustomer(Customer customer);
    void deleteCustomer(UUID id);
    void deleteAllCustomers();

    List<Ticket> getAllTickets();
    Ticket createTicket(UUID customerId, UUID eventId) throws TicketException;
    Ticket getTicketById(UUID id) throws TicketException;
    void deleteTicket(UUID id);
    void deleteAllTickets();
    boolean verifyTicket(UUID id);
}
