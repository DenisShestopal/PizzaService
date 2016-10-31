package services.simple;

import domain.Customer;
import domain.Order;
import domain.Pizza;
//import infrastructure.context.ApplicationContext;
import domain.enums.PizzaType;
import infrastructure.exceptions.PizzasOutOfBoundException;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.PizzaRepository;
import services.CustomerService;
import services.OrderService;
import services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
//import test1.infrastructure.ApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleOrderService implements OrderService {

    @Autowired(required = true)
    public OrderRepository orderRepository;
    @Autowired(required = true)
    public PizzaService pizzaService;
    @Autowired(required = true)
    public CustomerService customerService;
    public List<Pizza> pizzas;
    @Autowired(required = true)
    public PizzaRepository pizzaRepository;
    @Autowired(required = true)
    public CustomerRepository customerRepository;

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
        customerRepository.saveCustomer(customer);
        Order order = new Order(customer, pizzas);
        orderRepository.saveOrder(order);
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
