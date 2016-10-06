package Repository;

import Domain.Pizza;

import java.util.List;

public interface PizzaRepository {


   List<Pizza> getPizzas();

   Pizza getPizzaById(Long id);

   Pizza find(Long id);

//   List<Pizza> getPizzasList();

}
