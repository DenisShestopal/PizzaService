package Services;

import Domain.Pizza;
import Infrastructure.InitialContext;
import Repository.PizzaRepository;

public class SimplePizzaService implements PizzaService {

    private PizzaRepository pizzaRepository;

    public SimplePizzaService(PizzaRepository pizzaRepository){
        //InitialContext context = new InitialContext();
        //this.pizzaRepository = (PizzaRepository) context.getInstance("pizzaRepository");
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza findPizzaById(Long id){
        return pizzaRepository.find(id);
    }
}
