package services;

import domain.Customer;
import domain.Order;
import domain.Pizza;
import domain.enums.PizzaType;
import infrastructure.exceptions.PizzasOutOfBoundException;
import repository.OrderRepository;

import java.util.List;
import java.util.Map;
//import test1.infrastructure.ApplicationContext;

public interface OrderService extends BaseService<Order>{
    Order placeNewOrder(Customer customer, Map<Pizza, Integer> pizzas) throws PizzasOutOfBoundException;

    List<Order> getOrders();

}
