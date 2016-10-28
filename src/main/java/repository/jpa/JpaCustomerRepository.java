//package repository.jpa;
//
//import domain.Customer;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import repository.CustomerRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//@Repository("customerRepository")
//public class JpaCustomerRepository implements CustomerRepository{
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Customer findCustomerById(Long id) {
//        return entityManager.find(Customer.class, id);
//    }
//
//    @Override
//    @Transactional
//    public Customer addCustomer(Customer customer) {
//        return entityManager.merge(customer);
//    }
//}
