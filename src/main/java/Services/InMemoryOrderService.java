import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleOrderService {

    private List<Order> listOrders;
    private static Map<Long, Pizza> pizzas;

    static{
        pizzas.put(1L, new Pizza(1L, "Sea", 33.33, PizzaType.Sea));
        pizzas.put(1L, new Pizza(2L, "Vagatarian", 44.44, PizzaType.Vegetarian));
        pizzas.put(1L, new Pizza(3L, "Meat", 55.55, PizzaType.Meat));
    }


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
