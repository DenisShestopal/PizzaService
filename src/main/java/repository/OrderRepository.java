package repository;

import domain.Customer;
import domain.Order;
import domain.Pizza;

import java.util.List;
import java.util.Map;

public interface OrderRepository {

    Order saveOrder(Order order);

    List<Order> getOrders();

    Customer addCustomerToOrder(Customer customer);

    Map<Pizza, Integer> addPizzasMapToOrder(Map<Pizza, Integer> pizzas);

//    Order addPizzaByOrderId(Long orderId, Pizza pizza);

//    Order getOrderById(Long id);

//    Order payOrderById(Long id);
//
//    Order cancelOrderById(Long id);
//
//    Order confirmOrderById(Long id);
//
//    Order removePizzaByOrderId(Long orderId, Pizza pizza);
//
//    Integer getOrdersNumber();
}
