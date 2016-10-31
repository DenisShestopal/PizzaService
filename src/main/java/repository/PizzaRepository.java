package repository;

import domain.Pizza;

import java.util.List;

public interface PizzaRepository extends  BaseRepository<Pizza>{


   List<Pizza> getPizzas();
//
//   Pizza getPizzaById(Long id);
//
   Pizza findById(Long id);

   Pizza savePizza(Pizza pizza);

}
