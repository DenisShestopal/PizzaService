package Repository.InMemory;

import Domain.Order;
import Infrastructure.Annotations.BenchMark;
import Repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {

    private List<Order> listOrders = new ArrayList<>();

    @Override
    public List<Order> getListOrders() {
        return listOrders;
    }

    @BenchMark(value = true)
    @Override
    public Order saveOrder(Order order){
        listOrders.add(order);
        return order;
    }

}
