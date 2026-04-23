package Core.Models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Ticket {

    private final UUID id;
    private final LocalDate dateOfPurchase;
    private final UUID customerId;
    private final UUID eventId;

    public Ticket(
            UUID id,
            LocalDate dateOfPurchase,
            UUID customerId,
            UUID eventId
    ) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.customerId = customerId;
        this.eventId = eventId;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getEventId() {
        return eventId;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, dateOfPurchase, customerId, eventId);
    }

    @Override
    public boolean equals(Object objectToCompare){
        if (this == objectToCompare) return true;
        if(objectToCompare == null || getClass() != objectToCompare.getClass()) return false;
        Ticket ticketToCompare = (Ticket) objectToCompare;
        return ticketToCompare.getId().equals(this.getId()) &&
                ticketToCompare.getDateOfPurchase().equals(this.getDateOfPurchase()) &&
                ticketToCompare.getCustomerId().equals(this.getCustomerId()) &&
                ticketToCompare.getEventId().equals(this.getEventId());
    }


}
