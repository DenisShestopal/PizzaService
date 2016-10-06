package Repository;

import Domain.Order;

import java.util.List;

public interface OrderRepository {

    Order saveOrder(Order order);

    List<Order> getListOrders();

}
