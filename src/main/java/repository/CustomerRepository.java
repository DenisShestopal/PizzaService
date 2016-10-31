package repository;

import domain.Customer;

public interface CustomerRepository extends BaseRepository<Customer> {

//    Customer findCustomerById(Long id);

//    Customer addCustomer(Customer customer);

    Customer saveCustomer(Customer customer);
}
