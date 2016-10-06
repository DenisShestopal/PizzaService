package Repository.InMemory;

import Domain.Pizza;
import Infrastructure.Annotations.PostCreate;
import Repository.PizzaRepository;


import java.util.ArrayList;
import java.util.List;



public class InMemoryPizzaRepository implements PizzaRepository {


    private List<Pizza> pizzas = new ArrayList<>();

    @PostCreate
    public void init(){
        pizzas.add(new Pizza(1L, "Vegetarian", 33.33, Pizza.PizzaType.Vegetarian));
        pizzas.add(new Pizza(2L, "Sea", 44.44, Pizza.PizzaType.Sea));
        pizzas.add(new Pizza(3L, "Meat", 55.55, Pizza.PizzaType.Meat));
    }

    @Override
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public Pizza find(Long id) {
        return pizzas.get(id.intValue());
    }

    @Override
    public Pizza getPizzaById(Long id) {
        for (Pizza pizza : pizzas) {
            if (pizza.getId() == id) {
                return pizza;
            }
        }
        return (new Pizza(1L, "Vegetarian", 33.33, Pizza.PizzaType.Vegetarian));
// throw new IllegalArgumentException();
    }
}
