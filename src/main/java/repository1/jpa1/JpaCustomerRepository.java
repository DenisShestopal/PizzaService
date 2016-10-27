package repository1.jpa1;

import domain1.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository1.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("customerRepository")
public class JpaCustomerRepository implements CustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer findCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return entityManager.merge(customer);
    }
}
