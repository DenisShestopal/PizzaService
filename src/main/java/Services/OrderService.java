package Services;

import Domain.Customer;
import Domain.Order;
import Infrastructure.Exceptions.PizzasOutOfBoundException;
import Repository.OrderRepository;

public interface OrderService {
    Order placeNewOrder(Customer customer, Long... pizzasId) throws PizzasOutOfBoundException;

    OrderRepository getInMemoryOrderRepository();

    PizzaService getPizzaService();

    void countOrdersPrice(Order order);

    void countDiscount(Order order);

    void useDiscount(Order order);

}
