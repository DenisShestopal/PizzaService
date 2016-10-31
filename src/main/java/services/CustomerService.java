package services;

import domain.Customer;

public interface CustomerService extends BaseService<Customer>{

    Customer getCustomerById(Long id);

    void addCustomer(String name, String city, String street, boolean hasCard);


}
