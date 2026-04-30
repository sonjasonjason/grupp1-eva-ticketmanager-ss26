package Core.Interfaces;

import Core.Models.exceptions.TicketException;
import java.util.List;
import java.util.UUID;
import Core.Models.Ticket;

public interface TicketServiceInterface {
    Ticket createTicket(UUID customerId, UUID eventId)
        throws IllegalArgumentException, TicketException;
    Ticket getTicketById(UUID id) throws TicketException;
    List<Ticket> getAllTickets();
    void deleteTicket(UUID id) throws IllegalArgumentException;
    void deleteAllTickets();
    boolean verifyTicket(UUID id);
}
