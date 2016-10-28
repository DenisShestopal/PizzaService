package repository.inMemory;

import domain.Customer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class InMemoryCustomerRepository extends InMemoryBaseRepository<Customer> implements CustomerRepository {

    private List<Customer> customers = new ArrayList<>();
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    /*Public Methods*/
//    @Override
//    public Customer findById(Long id) {
//        if (customers.size() > 0) {
//            for (Customer customer : customers) {
//                if (customer.getId().equals(id)) {
//                    return customer;
//                }
//            }
//        }
//        throw new RuntimeException("no user found");
//    }

//    @Override
//    public Customer addCustomer(Customer customer) {
//        customers.add(customer);
//        return customer;
//    }

//    private Long getNextId() {
//        return Long.valueOf((customers.size() + 1));
//    }

}
