package services;

import domain1.Customer;

public interface CustomerService {

    Customer getCustomerById(Long id);

    void addCustomer(String name, String city, String street, boolean hasCard);


}
