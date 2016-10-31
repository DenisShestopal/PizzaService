package repository.inMemory;

import domain.Payment;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import repository.PaymentRepository;

@Transactional
public class InMemoryPaymentRepository extends InMemoryBaseRepository<Payment> implements PaymentRepository{
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
