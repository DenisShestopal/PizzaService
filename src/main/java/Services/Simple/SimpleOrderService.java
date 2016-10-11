package Services.Simple;

import Domain.Customer;
import Domain.Order;
import Domain.Pizza;
//import Infrastructure.Context.ApplicationContext;
import Infrastructure.Exceptions.PizzasOutOfBoundException;
import Repository.OrderRepository;
import Services.OrderService;
import Services.PizzaService;
import org.springframework.context.ApplicationContext;
//import Test.infrastructure.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrderService implements OrderService {

    public final OrderRepository orderRepository;
    public final PizzaService pizzaService;
    private ApplicationContext applicationContext;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    @Override
    public OrderRepository getInMemoryOrderRepository() {
        return orderRepository;
    }

    @Override
    public PizzaService getPizzaService() {
        return pizzaService;
    }

    @Override
    public Order placeNewOrder(Customer customer, Long... pizzasId) throws PizzasOutOfBoundException {
        List<Pizza> pizzas = new ArrayList<>();

        if (pizzasId.length < 10) {
            for (Long id : pizzasId) {
                pizzas.add(pizzaService.getPizzaById(id));
            }
        } else {
            throw new PizzasOutOfBoundException();
        }

        Order newOrder = createNewOrder();
        newOrder.setCustomer(customer);
        newOrder.setPizzas(pizzas);

        orderRepository.countOrdersPrice(newOrder);
        orderRepository.countDiscount(newOrder);
        orderRepository.useDiscount(newOrder);
        orderRepository.addOrdersDiscountToCard(newOrder, newOrder.getCustomer());
        orderRepository.saveOrder(newOrder);
        return newOrder;
    }

    Order createNewOrder() {
//        try {
//            return (Order) applicationContext.getBean("order");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
        throw new IllegalArgumentException();
    }

    @Override
    public void countOrdersPrice(Order order) {
        orderRepository.countOrdersPrice(order);
    }

    @Override
    public void countDiscount(Order order) {
        orderRepository.countDiscount(order);
    }

    @Override
    public void useDiscount(Order order) {
        orderRepository.useDiscount(order);
        orderRepository.addOrdersDiscountToCard(order, order.getCustomer());
    }

}
