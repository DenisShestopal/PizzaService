package services;

import domain1.Pizza;
import repository1.PizzaRepository;

public interface PizzaService {

    PizzaRepository getPizzaRepository();

//    Pizza findPizzaById(Long id);

    Pizza getPizzaById(Long id);

    Pizza addPizza(String name, Double price, Pizza.PizzaType type);
}
