package repository;

import domain.BaseEntity;

public interface BaseRepository<T extends BaseEntity> {

    T add(T entity);

    T update(T entity);

    boolean remove(Long id);

    T findById(Long id);
}
