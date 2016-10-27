package services;

import domain.Pizza;
import domain.enums.PizzaType;
import repository.PizzaRepository;

public interface PizzaService {

    PizzaRepository getPizzaRepository();

//    Pizza findPizzaById(Long id);

    Pizza getPizzaById(Long id);

    Pizza addPizza(String name, Double price, PizzaType type);
}
