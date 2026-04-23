package Core.Services;

import Core.Models.Customer;
import Core.Models.exceptions.CustomerException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    public Customer createCustomer(String username, String email, LocalDate dateOfBirth) {


        Customer newCustomer = new Customer(UUID.randomUUID(), username, email, dateOfBirth);

        validateCustomer(newCustomer);

        customers.add(newCustomer);

        return new Customer(newCustomer.getId(), username, email, dateOfBirth);
    }

    private void validateCustomer(Customer customer) {

        if (customer.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))) {

            throw CustomerException.underAgeCustomer();
        }

        if (!customer.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            throw CustomerException.invalidEmail();
        }
    }

    public Customer getCustomerById(UUID id) {

        var customerOpt = customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();

        if  (customerOpt.isEmpty()) {
            throw CustomerException.customerDoesNotExist();
        }

        return customerOpt.get();
    }

    public void updateCustomer(Customer customer) {

        var updateCustomer = getCustomerById(customer.getId());

        validateCustomer(customer);

        updateCustomer.setUsername(customer.getUsername());
        updateCustomer.setEmail(customer.getEmail());
        updateCustomer.setDateOfBirth(customer.getDateOfBirth());
    }

    public void deleteCustomer(UUID id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void deleteAllCustomers() {
        customers.clear();
    }
}
