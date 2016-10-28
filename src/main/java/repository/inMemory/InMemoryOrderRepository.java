package repository.inMemory;

import domain.Order;
import domain.Pizza;
import infrastructure.annotations.BenchMark;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class InMemoryOrderRepository extends InMemoryBaseRepository implements OrderRepository {

    private List<Order> orders = new ArrayList<>();
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> getOrders() {
        Session session = getSessionFactory().getCurrentSession();
        orders = session.createQuery("from orders").list();
        return orders;
    }

    @Override
    public Order findById(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        Order order;

        if (doesExistById(id))
            order = (Order) session.createQuery("select id from domain.Order o where o.id = :orderId")
                    .setParameter("orderId", id)
                    .uniqueResult();
        else
            throw new RuntimeException("No such order found");

        return order;
    }

//    @Override
//    public Order confirmOrderById(Long id) {
//        Order order = getOrderById(id);
//        order.confirm();
//        return order;
//    }
//
//    @Override
//    public Order payOrderById(Long id) {
//        Order order = getOrderById(id);
//        order.pay();
//        return order;
//    }
//
//    @Override
//    public Order cancelOrderById(Long id) {
//        Order order = getOrderById(id);
//        order.cancel();
//        return order;
//    }
//
//    @Override
//    public Order addPizzaByOrderId(Long orderId, Pizza pizza) {
//        Order order = getOrderById(orderId);
//        order.addPizza(pizza);
//        return order;
//    }
//
//    @Override
//    public Order removePizzaByOrderId(Long orderId, Pizza pizza) {
//        Order order = getOrderById(orderId);
//        order.removePizza(pizza);
//        return order;
//    }

    //    public Integer getOrdersNumber(){
//        return orders.size();
//    }
//
//    private long getNextId() {
//        return (orders.size() + 1);
//    }
//
    @Override
    public Order saveOrder(Order order) {
        Session session = getSessionFactory().getCurrentSession();

        if (doesExistById(order.getId())) {
            session.update(order);
            return order;
        } else
            throw new RuntimeException("No such order found");
    }

    public boolean doesExistById(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        try {
            session.createQuery("select id from domain.Order o where o.id = :orderId")
                    .setParameter("orderId", id)
                    .uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
