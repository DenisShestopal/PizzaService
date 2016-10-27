package repository.inMemory;

import domain.Order;
import domain.Pizza;
import infrastructure.annotations.BenchMark;
import repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private List<Order> listOrders = new ArrayList<>();

    @Override
    public List<Order> getListOrders() {
        return listOrders;
    }

    @Override
    public Order getOrderById(Long id) {
        for (Order order : listOrders) {
            if (order.getId() == id) {
                return order;
            }
        }
        throw new RuntimeException("Order's id not found");
    }

    @Override
    public Order confirmOrderById(Long id) {
        Order order = getOrderById(id);
        order.confirm();
        return order;
    }

    @Override
    public Order payOrderById(Long id) {
        Order order = getOrderById(id);
        order.pay();
        return order;
    }

    @Override
    public Order cancelOrderById(Long id) {
        Order order = getOrderById(id);
        order.cancel();
        return order;
    }

    @Override
    public Order addPizzaByOrderId(Long orderId, Pizza pizza) {
        Order order = getOrderById(orderId);
        order.addPizza(pizza);
        return order;
    }

    @Override
    public Order removePizzaByOrderId(Long orderId, Pizza pizza) {
        Order order = getOrderById(orderId);
        order.removePizza(pizza);
        return order;
    }

    public Integer getOrdersNumber(){
        return listOrders.size();
    }

    private long getNextId() {
        return (listOrders.size() + 1);
    }

    @BenchMark(value = true)
    @Override
    public Order saveOrder(Order order) {
        order.setId(getNextId());
        listOrders.add(order);
        order.confirm();
        return order;
    }
}
