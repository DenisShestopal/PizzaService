package repository1;

import domain1.Pizza;

import java.util.List;

public interface PizzaRepository {


   List<Pizza> getPizzas();

   Pizza getPizzaById(Long id);

   Pizza findPizzaById(Long id);

   Pizza savePizza(Pizza pizza);

}
