//package repository.jpa;
//
//import domain.Order;
//import domain.Pizza;
//import org.springframework.transaction.annotation.Transactional;
//import repository.OrderRepository;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.ArrayList;
//import java.util.List;
//
//public class JpaOrderRepository implements OrderRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private List<Order> listOrders = new ArrayList<>();
//
//    @Override
//    public Order getOrderById(Long id) {
//        return entityManager.find(Order.class, id);
//    }
//
//    @Override
//    @Transactional
//    public Order saveOrder(Order order) {
//        return entityManager.merge(order);
//    }
//
//    @Override
//    @Transactional
//    public Order confirmOrderById(Long id) {
//        Order order = entityManager.find(Order.class, id);
//        order.confirm();
//        return order;
//    }
//
//    @Override
//    @Transactional
//    public Order payOrderById(Long id) {
//        Order order = entityManager.find(Order.class, id);
//        order.pay();
//        return order;
//    }
//
//    @Override
//    @Transactional
//    public Order cancelOrderById(Long id) {
//        Order order = entityManager.find(Order.class, id);
//        order.cancel();
//        return order;
//    }
//
//    @Override
//    @Transactional
//    public Order addPizzaByOrderId(Long orderId, Pizza pizza) {
//        Order order = entityManager.find(Order.class, orderId);
//        order.addPizza(pizza);
//        return order;
//    }
//
//    @Override
//    @Transactional
//    public Order removePizzaByOrderId(Long orderId, Pizza pizza) {
//        Order order = entityManager.find(Order.class, orderId);
//        order.removePizza(pizza);
//        return order;
//    }
//
//    @Override
//    public Integer getOrdersNumber() {
//        return 0;
//    }
//
//    @Override
//    public List<Order> getListOrders() {
//        return listOrders;
//    }
//}

