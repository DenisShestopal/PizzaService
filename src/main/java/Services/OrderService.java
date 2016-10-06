package Services;

import Domain.Customer;
import Domain.Order;
import Repository.OrderRepository;

public interface OrderService {
    Order placeNewOrder(Customer customer, Long... pizzasId);

    OrderRepository getInMemoryOrderRepository();


    PizzaService getPizzaService();

}
