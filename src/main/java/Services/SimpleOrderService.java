package Services;

import Domain.Customer;
import Repository.InMemoryOrderRepository;
import Domain.Pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryOrderService implements OrderService{

    private List<InMemoryOrderRepository> listOrders;
    private static Map<Long, Pizza> pizzas = new HashMap<>();

    static{
        pizzas.put(1L, new Pizza(1L, "Sea", 33.33, Pizza.PizzaType.Sea));
        pizzas.put(1L, new Pizza(2L, "Vagatarian", 44.44, Pizza.PizzaType.Vegetarian));
        pizzas.put(1L, new Pizza(3L, "Meat", 55.55, Pizza.PizzaType.Meat));
    }


    public InMemoryOrderRepository placeNewOrder(Customer customer, Integer... pizzasId) {
        List<Pizza> pizzas = new ArrayList<>();

        for (Integer id : pizzasId) {
            pizzas.add(getPizzaById(id));
        }
        InMemoryOrderRepository newOrder = new InMemoryOrderRepository(customer.getId(), pizzas);

        saveOrder(newOrder);
        return newOrder;

    }

    public Pizza getPizzaById(Integer id){
        return new Pizza(1L, "Neapolitana", 33.33, Pizza.PizzaType.Meat);
    }

    public void saveOrder(InMemoryOrderRepository order){
        System.out.println("Repository.InMemoryOrderRepository saved");
    }

}
