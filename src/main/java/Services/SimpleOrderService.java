package Services;

import Domain.Customer;
import Domain.Order;
import Repository.InMemoryOrderRepository;
import Domain.Pizza;
import Repository.InMemoryPizzaRepository;
import Repository.OrderRepository;
import Repository.PizzaRepository;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrderService implements OrderService{

    public final OrderRepository orderRepository;
    public final PizzaService pizzaService;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
    }


    @Override
    public Order placeNewOrder(Customer customer, Long... pizzasId) {
        List<Pizza> pizzas = new ArrayList<>();
        for (Long id : pizzasId) {
            pizzas.add(pizzaService.findPizzaById(id));
        }

        Order newOrder = new Order(1L, pizzas);
        saveOrder(newOrder);
        return newOrder;
    }

    public void saveOrder(Order newOrder){
        orderRepository.saveOrder(newOrder);
        System.out.println("Repository.InMemoryOrderRepository saved");
    }



}
