package services.simple;

import domain1.Pizza;
import infrastructure1.annotations1.BenchMark;
import repository1.PizzaRepository;
import services.PizzaService;
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

    @Override
    @BenchMark(value = true)
    public Pizza addPizza(String name, Double price, Pizza.PizzaType type) {
        Pizza newPizza = new Pizza();
        newPizza.setName(name);
        newPizza.setPrice(price);
        newPizza.setPizzaType(type);
        pizzaRepository.savePizza(newPizza);
        return newPizza;
    }
}
