package Services.Simple;

import Domain.Pizza;
import Repository.PizzaRepository;
import Services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimplePizzaService implements PizzaService {

    private PizzaRepository pizzaRepository;

//    @Autowired
//    public void setPizzaRepository(PizzaRepository pizzaRepository) {
//        this.pizzaRepository = pizzaRepository;
//    }

    @Autowired
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
