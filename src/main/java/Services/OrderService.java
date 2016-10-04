package Services;

import Domain.Customer;
import Domain.Order;

public interface OrderService {
    Order placeNewOrder(Customer customer, Long... pizzasId);
}
