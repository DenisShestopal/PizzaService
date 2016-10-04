import java.util.ArrayList;
import java.util.List;

public class SimpleOrderService {

    public Order placeNewOrder(Customer customer, Integer... pizzasId) {
        List<Pizza> pizzas = new ArrayList<>();

        for (Integer id : pizzasId) {
            pizzas.add(getPizzaById(id));
        }
        Order newOrder = new Order(customer.getId(), pizzas);

        saveOrder(newOrder);
        return newOrder;

    }

    public Pizza getPizzaById(Integer id){
        return new Pizza(1L, "Neapolitana", 33.33, PizzaType.Meat);
    }

    public void saveOrder(Order order){
        System.out.println("Order saved");
    }

}
