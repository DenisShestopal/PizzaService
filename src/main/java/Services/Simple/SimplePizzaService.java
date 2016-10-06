package Services.Simple;

import Domain.Pizza;
import Repository.PizzaRepository;
import Services.PizzaService;

public class SimplePizzaService implements PizzaService {

    private PizzaRepository pizzaRepository;

    public SimplePizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public PizzaRepository getPizzaRepository() {
        return pizzaRepository;
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return pizzaRepository.getPizzaById(id);
    }
}
