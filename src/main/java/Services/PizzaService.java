package Services;

import Domain.Customer;
import Domain.Order;
import Domain.Pizza;
import Repository.PizzaRepository;

public interface PizzaService {

    PizzaRepository getPizzaRepository();

//    Pizza findPizzaById(Long id);

    Pizza getPizzaById(Long id);
}
