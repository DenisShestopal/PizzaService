package repository.inMemory;

import domain.Card;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import repository.BaseRepository;
import repository.CardRepository;

@Transactional
public class InMemoryCardRepository extends InMemoryBaseRepository<Card> implements CardRepository {

    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
