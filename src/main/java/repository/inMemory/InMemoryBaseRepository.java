package repository.inMemory;

import domain.BaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;
import repository.BaseRepository;

@Transactional
public abstract class InMemoryBaseRepository<T extends BaseEntity> implements BaseRepository<T> {

    //get type of T by reflection
    @SuppressWarnings("unchecked")
    private final Class<T> genericType =
            (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),
                    InMemoryBaseRepository.class);

    public abstract SessionFactory getSessionFactory();

    @Override
    public T add(T entity) {
        Session session = getSessionFactory().getCurrentSession();

        if (entity.isNew()) {
            session.persist(entity);
        } else session.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        Session session = getSessionFactory().getCurrentSession();
        session.update(entity);
        return entity;
    }

    @Override
    public boolean remove(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        T entity = (T) session.load(genericType, id);

        if (entity != null) {
            session.delete(entity);
            return true;
        }
        return false;
    }

    @Override
    public T findById(Long id) {
        try {
            Session session = getSessionFactory().getCurrentSession();
            return (T) session.load(genericType, id);
        } catch (HibernateException e) {
            Session session = getSessionFactory().openSession();
            return (T) session.load(genericType, id);
        }
    }
}
