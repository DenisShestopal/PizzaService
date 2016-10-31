package services;

import domain.Pizza;
import domain.enums.PizzaType;
import repository.PizzaRepository;

import java.util.List;

public interface PizzaService extends BaseService<Pizza>{

//    PizzaRepository getPizzaRepository();
//
////    Pizza findPizzaById(Long id);
//
//    Pizza getPizzaById(Long id);
//
//    Pizza addPizza(String name, Double price, PizzaType type);

    List<Pizza> getPizzasList();
}
