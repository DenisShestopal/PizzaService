package services;

import domain.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T add(T entity);

    T update(T entity);

    boolean remove(Long id);

    T getById(Long id);
}
