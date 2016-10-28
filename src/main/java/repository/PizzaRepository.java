package repository;

import domain.Pizza;

import java.util.List;

public interface PizzaRepository {


   List<Pizza> getPizzas();
//
//   Pizza getPizzaById(Long id);
//
   Pizza findById(Long id);

   Pizza savePizza(Pizza pizza);

}
