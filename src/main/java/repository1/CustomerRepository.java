package repository1;

import domain1.Customer;

public interface CustomerRepository {

    Customer findCustomerById(Long id);

    Customer saveCustomer(Customer customer);
}
