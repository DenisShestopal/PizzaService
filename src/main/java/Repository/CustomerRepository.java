package repository;

import domain.Customer;

public interface CustomerRepository {

    Customer findCustomerById(Long id);

    Customer saveCustomer(Customer customer);
}
