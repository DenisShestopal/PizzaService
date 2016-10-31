package repository;

import domain.Customer;

import java.util.List;

public interface CustomerRepository extends BaseRepository<Customer> {

//    Customer findCustomerById(Long id);

//    Customer addCustomer(Customer customer);

    Customer saveCustomer(Customer customer);

    List<Customer> getCustomersList();
}
