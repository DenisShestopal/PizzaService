package services;

import domain.Customer;
import domain.Order;
import domain.Pizza;
import domain.enums.PizzaType;
import infrastructure.exceptions.PizzasOutOfBoundException;
import repository.OrderRepository;

import java.util.Map;
//import test1.infrastructure.ApplicationContext;

public interface OrderService extends BaseService<Order>{
    Order placeNewOrder(Customer customer, Map<Pizza, Integer> pizzas) throws PizzasOutOfBoundException;

//    OrderRepository getInMemoryOrderRepository();
//
//    PizzaService getPizzaService();

//    Pizza getPizzaById(Long id);

//    Pizza addPizzaToOrderById(Long orderId, Long pizzaId);
//
//    Pizza removePizzaToOrderById(Long orderId, Long pizzaId);
//
//    Customer getCustomerById(Long id);
//
//    void saveOrder(Order newOrder);
//
//    Integer getNumberOfOrders();
//
//    void addPizza(String name, Double price, PizzaType type);
//
//    void addCustomer(String name, String city, String street, boolean hasCard);
//
//    void payOrderById(Long id);
//
//    void cancelOrderById(Long id);
//
//    Double getTotalOrderPriceById(Long id);

}
