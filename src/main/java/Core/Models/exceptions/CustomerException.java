package Core.Models.exceptions;

public class CustomerException extends RuntimeException {
    public static final String customerDoesNotExist = "Customer doesn't exist.";
    public static final String underAgeCustomer = "User has to be 18 years old";
    public static final String invalidEmail = "Invalid email";

    public CustomerException(String message) {
        super(message);
    }

    public static CustomerException customerDoesNotExist() {
        return new CustomerException(customerDoesNotExist);
    }

    public static CustomerException underAgeCustomer() {
        return new CustomerException(underAgeCustomer);
    }

    public static CustomerException invalidEmail() {
        return new CustomerException(invalidEmail);
    }

}
