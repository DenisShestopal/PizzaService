package Repository;

import Domain.Order;

public interface OrderRepository {

    Order saveOrder(Order order);

}
