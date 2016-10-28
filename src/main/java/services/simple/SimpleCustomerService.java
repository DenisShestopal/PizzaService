package services.simple;

import domain.Card;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CustomerRepository;
import services.CustomerService;

public class SimpleCustomerService implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public SimpleCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

//    @Override
//    public void addCustomer(String name, String city, String street, boolean hasCard) {
//        Customer newCustomer = new Customer();
//        newCustomer.setName(name);
////        newCustomer.setAddress(new Address(city, street));
//        if (hasCard) {
//            Card card = new Card();
//            newCustomer.setCard(card);//TODO refactor
//        }
//        customerRepository.addCustomer(newCustomer);
//    }


    @Override
    public void addCustomer(String name, String city, String street, boolean hasCard) {

    }
}
