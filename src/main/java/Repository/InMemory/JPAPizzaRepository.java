package Repository.InMemory;

import Domain.Pizza;
import Repository.PizzaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("pizzaRepository")
public class JPAPizzaRepository implements PizzaRepository {

    private EntityManager em;

    @Override
    public List<Pizza> getPizzas() {
        return null;
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return null;
    }

    @Override
    public Pizza find(Long id) {
        return em.find(Pizza.class, id);
    }
}
