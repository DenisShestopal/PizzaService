package Services.Simple;

import Domain.Customer;
import Domain.Order;
import Domain.Pizza;
import Repository.OrderRepository;
import Services.OrderService;
import Services.PizzaService;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrderService implements OrderService {

    public final OrderRepository orderRepository;
    public final PizzaService pizzaService;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
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
    public Order placeNewOrder(Customer customer, Long... pizzasId) {
        List<Pizza> pizzas = new ArrayList<>();

        for (Long id : pizzasId) {
            pizzas.add(pizzaService.getPizzaById(id));
        }
        Order newOrder = new Order(1L, customer, pizzas);

        orderRepository.saveOrder(newOrder);
        return newOrder;
    }

//    public void saveOrder(Order newOrder){
//        orderRepository.saveOrder(newOrder);
//        System.out.println("Repository.InMemory.InMemoryOrderRepository saved");
//    }



}
