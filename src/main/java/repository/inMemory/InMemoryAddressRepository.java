package repository.inMemory;

import domain.Address;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import repository.AddressRepository;

@Transactional
public class InMemoryAddressRepository extends InMemoryBaseRepository<Address> implements AddressRepository{

    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
