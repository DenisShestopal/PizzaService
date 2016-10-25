package repository.jpa;

import domain.Pizza;
import org.springframework.transaction.annotation.Transactional;
import repository.PizzaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("pizzaRepository")
public class JpaPizzaRepository implements PizzaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pizza> getPizzas() {
        return null;
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return null;
    }

    @Override
    public Pizza findPizzaById(Long id) {
        return entityManager.find(Pizza.class, id);
    }

    @Override
    @Transactional
    public Pizza save(Pizza pizza) {
        return entityManager.merge(pizza);
    }
}
