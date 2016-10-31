package repository.inMemory;

import domain.Customer;
import domain.Order;
import domain.Pizza;
import infrastructure.annotations.BenchMark;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Repository
@Transactional
public class InMemoryOrderRepository extends InMemoryBaseRepository<Order> implements OrderRepository {

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
        orders = session.createQuery("from Order").list();
        return orders;
    }

    @Override
    public Order findById(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        Order order;

        order = (Order) session.createQuery("select id from domain.Order o where o.id = :orderId")
                    .setParameter("orderId", id)
                    .uniqueResult();

        return order;
    }

    @Override
    public Customer addCustomerToOrder(Customer customer) {
        Session session = getSessionFactory().getCurrentSession();
        return null;
    }

    @Override
    public Map<Pizza, Integer> addPizzasMapToOrder(Map<Pizza, Integer> pizzas) {
        return null;
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

        if (order.isNew()) {
            session.persist(order);
        } else
            session.update(order);
        return order;
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
