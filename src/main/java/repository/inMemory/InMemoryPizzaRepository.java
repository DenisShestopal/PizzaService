package repository.inMemory;

import domain.Pizza;
import domain.enums.PizzaType;
import repository.PizzaRepository;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPizzaRepository implements PizzaRepository {

    private List<Pizza> pizzas = new ArrayList<>();

    @PostConstruct
    public void init(){
        pizzas.add(new Pizza(1L, "Vegetarian", 33.33, PizzaType.VEGETARIAN));
        pizzas.add(new Pizza(2L, "Sea", 44.44, PizzaType.SEA));
        pizzas.add(new Pizza(3L, "Meat", 55.55, PizzaType.MEAT));
    }

    @Override
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public Pizza findPizzaById(Long id) {
        return pizzas.get(id.intValue());
    }

    @Override
    public Pizza getPizzaById(Long id) {
        for (Pizza pizza : pizzas) {
            if (pizza.getId() == id) {
                return pizza;
            }
        }
        return (new Pizza(1L, "Vegetarian", 33.33, PizzaType.VEGETARIAN));
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
        pizza.setId(Long.valueOf(pizzas.size() + 1));
        pizzas.add(pizza);
        return pizza;
    }
}
