package services;

import domain1.Customer;
import domain1.Order;
import domain1.Pizza;
import infrastructure1.exceptions1.PizzasOutOfBoundException;
import repository1.OrderRepository;
//import test1.infrastructure1.ApplicationContext;

public interface OrderService {
    Order placeNewOrder(Customer customer, Long... pizzasId) throws PizzasOutOfBoundException;

    OrderRepository getInMemoryOrderRepository();

    PizzaService getPizzaService();

    Pizza getPizzaById(Long id);

    Pizza addPizzaToOrderById(Long orderId, Long pizzaId);

    Pizza removePizzaToOrderById(Long orderId, Long pizzaId);

    Customer getCustomerById(Long id);

    void saveOrder(Order newOrder);

    Integer getNumberOfOrders();

    void addPizza(String name, Double price, Pizza.PizzaType type);

    void addCustomer(String name, String city, String street, boolean hasCard);

    void payOrderById(Long id);

    void cancelOrderById(Long id);

    Double getTotalOrderPriceById(Long id);

}
