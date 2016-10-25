package Repository;

import Domain.Customer;
import Domain.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository {

    Order saveOrder(Order order);

    List<Order> getListOrders();

//    void countOrdersPrice(Order order);
//
//    void countDiscount(Order order);
//
//    BigDecimal maxPizzaPriceInorder(Order order);

//    void useDiscount(Order order);

//    void addOrdersDiscountToCard(Order order, Customer customer);

    Order getOrderById(long id);

    void payOrderById(long id);

    void cancelOrderById(long id);

}
