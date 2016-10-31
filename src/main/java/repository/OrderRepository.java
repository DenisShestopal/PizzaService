package repository;

import domain.Customer;
import domain.Order;
import domain.Pizza;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends BaseRepository<Order>{

    Order saveOrder(Order order);

    List<Order> getOrders();

    Customer addCustomerToOrder(Customer customer);

    Map<Pizza, Integer> addPizzasMapToOrder(Map<Pizza, Integer> pizzas);

}
