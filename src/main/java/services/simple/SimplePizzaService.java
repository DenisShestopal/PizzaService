package services.simple;

import domain.Pizza;
import domain.enums.PizzaType;
import infrastructure.annotations.BenchMark;
import org.springframework.beans.factory.annotation.Qualifier;
import repository.BaseRepository;
import repository.PizzaRepository;
import services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimplePizzaService extends SimpleBaseService<Pizza> implements PizzaService {


    private PizzaRepository pizzaRepository;

    @Autowired(required = true)
    @Qualifier(value = "pizzaRepository")
    public void setPizzaRepository(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public BaseRepository<Pizza> getRepository() {
        return pizzaRepository;
    }

    @Override
    public List<Pizza> getPizzasList() {
        return pizzaRepository.getPizzas();
    }

    //    @Autowired
//    public void setPizzaRepository(PizzaRepository pizzaRepository) {
//        this.pizzaRepository = pizzaRepository;
//    }

//    @Autowired
//    public SimplePizzaService(PizzaRepository pizzaRepository){
//        this.pizzaRepository = pizzaRepository;
//    }
//
//    @Override
//    public PizzaRepository getPizzaRepository() {
//        return pizzaRepository;
//    }
//
//    @Override
//    public Pizza getPizzaById(Long id) {
//        return pizzaRepository.getPizzaById(id);
//    }
//
//    @Override
//    @BenchMark(value = true)
//    public Pizza addPizza(String name, Double price, PizzaType type) {
//        Pizza newPizza = new Pizza();
//        newPizza.setName(name);
//        newPizza.setPrice(price);
//        newPizza.setPizzaType(type);
//        pizzaRepository.savePizza(newPizza);
//        return newPizza;
//    }
}
