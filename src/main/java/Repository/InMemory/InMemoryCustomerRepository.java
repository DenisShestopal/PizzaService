package repository.InMemory;

import domain.Customer;
import repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    /*Fields*/
    private List<Customer> customers = new ArrayList<>();

    /*Public Methods*/
    @Override
    public Customer findCustomerById(Long id) {
        if (customers.size() > 0) {
            for (Customer customer : customers) {
                if (customer.getId().equals(id)) {
                    return customer;
                }
            }
        }
        throw new RuntimeException();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setId(getNextId());
        customers.add(customer);
        return customer;
    }

    private Long getNextId() {
        return Long.valueOf((customers.size() + 1));
    }

}
