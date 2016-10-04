package Repository;

import Domain.Pizza;

import java.util.HashMap;
import java.util.Map;


public class InMemoryPizzaRepository implements PizzaRepository {

    private Map<Long, Pizza> pizzas = new HashMap<>();
    {
        pizzas.put(1L, new Pizza(1L, "Vegetarian", 33.33,Pizza.PizzaType.Vegetarian));
        pizzas.put(2L, new Pizza(2L, "Sea", 44.44,Pizza.PizzaType.Sea));
        pizzas.put(3L, new Pizza(3L, "Meat", 55.55,Pizza.PizzaType.Meat));
    }

    @Override
    public Pizza find(Long id) {
        return pizzas.get(id);
    }
}
