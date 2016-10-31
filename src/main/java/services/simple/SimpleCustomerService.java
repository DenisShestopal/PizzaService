package services.simple;

import domain.Card;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.BaseRepository;
import repository.CustomerRepository;
import services.CustomerService;

@Service
public class SimpleCustomerService extends SimpleBaseService <Customer> implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired(required = true)
    @Qualifier(value = "customerRepository")
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public SimpleCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public BaseRepository<Customer> getRepository() {
        return customerRepository;
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
