package repository.inMemory;

import domain.Order;
import domain.Pizza;
import domain.enums.PizzaType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import repository.PizzaRepository;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
@Transactional
public class InMemoryPizzaRepository extends InMemoryBaseRepository<Pizza> implements PizzaRepository {

    private List<Pizza> pizzas = new ArrayList<>();
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pizza> getPizzas() {
        Session session = getSessionFactory().getCurrentSession();
        pizzas = session.createQuery("from pizzas").list();
        return pizzas;
    }

    @Override
    public Pizza findById(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        Pizza pizza;

        if (doesExistById(id))
            pizza = (Pizza) session.createQuery("select id from domain.Pizza o where o.id = :pizzaId")
                    .setParameter("pizzaId", id)
                    .uniqueResult();
        else
            throw new RuntimeException("No such pizza found");

        return pizza;
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
//        pizza.setId(Long.valueOf(pizzas.size() + 1));
        pizzas.add(pizza);
        return pizza;
    }

    public boolean doesExistById(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        try {
            session.createQuery("select id from domain.Pizza o where o.id = :pizzaId")
                    .setParameter("pizzaId", id)
                    .uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
