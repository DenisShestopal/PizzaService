package services.simple;

import domain.BaseEntity;
import repository.BaseRepository;
import services.BaseService;

public abstract class SimpleBaseService<T extends BaseEntity> implements BaseService<T>{

    public abstract BaseRepository<T> getRepository();

    @Override
    public T add(T entity) {
        return getRepository().add(entity);
    }

    @Override
    public T update(T entity){
        return getRepository().update(entity);
    }

    @Override
    public boolean remove(Long id) {
        return getRepository().remove(id);
    }

    @Override
    public T getById(Long id) {
        return getRepository().findById(id);
    }
}
