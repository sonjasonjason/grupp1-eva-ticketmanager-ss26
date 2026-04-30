package Core.Models.exceptions;

public class CustomerException extends RuntimeException {
    public static final String customerUnder18 = "User has to be 18 years old";
    public static final String invalidEmail = "Invalid email";
    public static final String customerDoesNotExist = "Customer does not exist";
    public static final String ticketsBoughtCantBeUpdated = "The bought tickets of a customer can't be updated";

    public CustomerException(String message) {
        super(message);
    }

    public static CustomerException customerUnder18() {
        return new CustomerException(customerUnder18);
    }

    public static CustomerException invalidEmail() {
        return new CustomerException(invalidEmail);
    }

    public static CustomerException customerDoesNotExist(){
        return new CustomerException(customerDoesNotExist);
    }

    public static CustomerException ticketsBoughtCantBeUpdated(){
        return new CustomerException(ticketsBoughtCantBeUpdated);
    }
}
