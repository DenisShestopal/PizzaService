package Repository.InMemory;

import Domain.Customer;
import Domain.Order;
import Domain.Pizza;
import Infrastructure.Annotations.BenchMark;
import Repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private List<Order> listOrders = new ArrayList<>();

    @Override
    public List<Order> getListOrders() {
        return listOrders;
    }

    @BenchMark(value = true)
    @Override
    public Order saveOrder(Order order) {
        order.setId(getNextId());
        listOrders.add(order);
        return order;
    }

//    @Override
//    public void countOrdersPrice(Order order) {
//        Map<Pizza, Integer> pizzas = order.getPizzas();
//        Double price = 0.0;
//        for (Pizza pizza : pizzas.entrySet()) {
//            price = price.add(pizza.getPrice());
//        }
//        order.setPrice(price);
//    }
//
//    @Override
//    public void countDiscount(Order order) {
//        List<Pizza> pizzas = order.getPizzas();
//        BigDecimal discount = new BigDecimal("0");
//        if (pizzas.size() > 4) {
//            discount = maxPizzaPriceInorder(order).multiply(new BigDecimal("0.7"));
//        }
//        order.setDiscount(discount);
//    }

//    @Override
//    public BigDecimal maxPizzaPriceInorder(Order order) {
//        List<Pizza> pizzas = order.getPizzas();
//        BigDecimal price = new BigDecimal("0");
//        for (Pizza pizza : pizzas) {
//            if (pizza.getPrice().compareTo(price) == 1)
//                price = pizza.getPrice();
//        }
//        return price;
//    }

//    @Override
//    public void useDiscount(Order order) {
//        order.setPrice(order.getPrice()
//                .subtract(order.getDiscount())
//                .subtract(order.getCustomer().getDiscount().multiply(new BigDecimal("0.1"))));
//    }

//    @Override
//    public void addOrdersDiscountToCard(Order order, Customer customer) {
//        customer.setDiscount(order.getDiscount());
//    }

    @Override
    public Order getOrderById(long id) {
        for (Order order : listOrders) {
            if (order.getId() == id) {
                return order;
            }
        }
        throw new RuntimeException("Such order id does not exist.");
    }

    @Override
    public void payOrderById(long id) {
        Order order = getOrderById(id);
        order.pay();
    }

    @Override
    public void cancelOrderById(long id) {
        Order order = getOrderById(id);
        order.cancel();
    }

    private long getNextId() {
        return (listOrders.size() + 1);
    }
}
