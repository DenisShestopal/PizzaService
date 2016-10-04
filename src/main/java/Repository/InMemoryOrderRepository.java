package Repository;

import Domain.Order;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository{

    private List<Order> listOrders = new ArrayList<>();

    public List<Order> getListOrders() {
        return listOrders;
    }

    @Override
    public Order saveOrder(Order order){
        listOrders.add(order);
        return order;
    }

}
