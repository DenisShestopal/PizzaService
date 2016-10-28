package repository;

import domain.Order;
import domain.Pizza;

import java.util.List;

public interface OrderRepository {

    Order saveOrder(Order order);

    List<Order> getOrders();

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
