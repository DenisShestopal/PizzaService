package services.simple;

import domain.BaseEntity;
import domain.Customer;
import domain.Order;
import domain.Pizza;
//import infrastructure.context.ApplicationContext;
import domain.enums.PizzaType;
import infrastructure.exceptions.PizzasOutOfBoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BaseRepository;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.PizzaRepository;
import services.BaseService;
import services.CustomerService;
import services.OrderService;
import services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
//import test1.infrastructure.ApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SimpleOrderService extends SimpleBaseService<Order> implements OrderService {

    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private CustomerService customerService;
    private List<Pizza> pizzas;
    private PizzaRepository pizzaRepository;
    private CustomerRepository customerRepository;

    @Autowired
    @Qualifier(value = "orderRepository")
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    @Qualifier(value = "pizzaService")
    public void setPizzaService(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Autowired
    @Qualifier(value = "customerService")
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    @Qualifier(value = "pizzaRepository")
    public void setPizzaRepository(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Autowired
    @Qualifier(value = "customerRepository")
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public BaseRepository<Order> getRepository() {
        return orderRepository;
    }

    //    @Autowired
//    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, CustomerService customerService) {
//        this.orderRepository = orderRepository;
//        this.pizzaService = pizzaService;
//        this.customerService = customerService;
//    }

//    @Override
//    public OrderRepository getInMemoryOrderRepository() {
//        return orderRepository;
//    }
//
//    @Override
//    public PizzaService getPizzaService() {
//        return pizzaService;
//    }

    @Override
    public Order placeNewOrder(Customer customer, Map<Pizza, Integer> pizzas){
        Order order = new Order(customer, pizzas);
//        orderRepository.saveOrder(order);
        customerRepository.saveCustomer(customer);

        orderRepository.add(order);
        return order;
    }


//    @Override
//    public Order placeNewOrder(Customer customer, Long... pizzasId) throws PizzasOutOfBoundException {
//        Map<Pizza, Integer> pizzas = new HashMap<>();
//
//        if (pizzasId.length < 10) {
//            List<Pizza> pizzasList = new ArrayList<>();
//            for (Long id : pizzasId) {
//                pizzasList.add(getPizzaById(id));
//            }
//            Order newOrder = createNewOrder();
//            newOrder.setCustomer(customer);
//            newOrder.insertPizzas(pizzasList);
//            newOrder.countTotalPrice();
//            orderRepository.saveOrder(newOrder);
//            return newOrder;
//        } else {
//            throw new PizzasOutOfBoundException();
//        }
//    }


//    Order createNewOrder() {
//        throw new IllegalArgumentException();
//    }
//
//    @Override
//    public Pizza getPizzaById(Long id) {
//        return pizzaService.getPizzaById(id);
//    }
//
//    @Override
//    public Pizza addPizzaToOrderById(Long orderId, Long pizzaId) {
//        Pizza pizza = getPizzaById(pizzaId);
//        orderRepository.addPizzaByOrderId(orderId, pizza);
//        return pizza;
//    }
//
//    @Override
//    public Pizza removePizzaToOrderById(Long orderId, Long pizzaId) {
//        Pizza pizza = getPizzaById(pizzaId);
//        orderRepository.removePizzaByOrderId(orderId, pizza);
//        return pizza;
//    }
//
//    @Override
//    public Customer getCustomerById(Long id) {
//        return customerService.getCustomerById(id);
//    }
//
//    @Override
//    public void saveOrder(Order newOrder) {
//        orderRepository.saveOrder(newOrder);
//    }
//
//    @Override
//    public Integer getNumberOfOrders() {
//        return orderRepository.getOrdersNumber();
//    }
//
//    @Override
//    public void addPizza(String name, Double price, PizzaType type) {
//        pizzaService.addPizza(name, price, type);
//    }
//
//    @Override
//    public void addCustomer(String name, String city, String street, boolean hasCard) {
//        customerService.addCustomer(name, city, street, hasCard);
//    }
//
//    @Override
//    public void payOrderById(Long id) {
//        orderRepository.payOrderById(id);
//    }
//
//    @Override
//    public void cancelOrderById(Long id) {
//        orderRepository.cancelOrderById(id);
//    }
//
//    @Override
//    public Double getTotalOrderPriceById(Long id) {
//        return orderRepository.getOrderById(id).getTotalPrice();
//    }


}
