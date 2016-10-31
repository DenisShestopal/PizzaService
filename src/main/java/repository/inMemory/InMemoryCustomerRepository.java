package repository.inMemory;

import domain.Customer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
@Transactional
public class InMemoryCustomerRepository extends InMemoryBaseRepository<Customer> implements CustomerRepository {

    private List<Customer> customers = new ArrayList<>();
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getCustomersList() {
        Session session = getSessionFactory().getCurrentSession();
        customers = session.createQuery("from Customer").list();
        return customers;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Session session = getSessionFactory().getCurrentSession();

        if (customer.isNew()) {
            session.persist(customer);
        } else
            session.update(customer);
        return customer;
    }

}
