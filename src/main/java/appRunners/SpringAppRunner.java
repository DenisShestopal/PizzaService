package appRunners;


import domain.Customer;
import domain.Order;
import domain.Pizza;
import domain.enums.PizzaType;
import infrastructure.exceptions.PizzasOutOfBoundException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CustomerService;
import services.OrderService;
import services.PizzaService;
import services.simple.SimpleOrderService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringAppRunner {

    public static void main(String... args) {
        ConfigurableApplicationContext repoContext = new ClassPathXmlApplicationContext("repoContext.xml");
        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));
        //указываем, на основе какой конфигурации спринга работаем

        ConfigurableApplicationContext appContext =
                new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repoContext);


        Customer customer = new Customer();
        Map<Pizza, Integer> pizzas = new HashMap<>();

        {
            Pizza pizza1 = new Pizza("Pizza #1", 30.00, PizzaType.MEAT);
            Pizza pizza2 = new Pizza("Pizza #2", 40.00, PizzaType.SEA);
            Pizza pizza3 = new Pizza("Pizza #3", 50.00, PizzaType.VEGETARIAN);

            pizzas.put(pizza1, 1);
            pizzas.put(pizza2, 2);
            pizzas.put(pizza3, 3);
        }

        PizzaService pizzaService = (PizzaService) appContext.getBean("pizzaService");
        CustomerService customerService = (CustomerService) appContext.getBean("customerService");
        OrderService orderService = (OrderService) appContext.getBean("orderService");
        Order order = new Order(customer, pizzas);


        pizzaService.add(new Pizza("Pizza #1", 30.00, PizzaType.MEAT));
        pizzaService.add(new Pizza("Pizza #2", 40.00, PizzaType.SEA));
        pizzaService.add(new Pizza("Pizza #3", 50.00, PizzaType.VEGETARIAN));
        customerService.add(customer);
//        orderService.add(order);

        List<Pizza> pizzasList = pizzaService.getPizzasList();
        for (Pizza pizza : pizzasList) {
            System.out.println("pizzas: " + pizza.toString());
        }

        List<Customer> customers = customerService.getCustomersList();
        for (Customer customer1 : customers) {
            System.out.println("Customer: " + customer1.toString());
        }

        List<Order> orders = orderService.getOrders();
        for (Order order1 : orders) {
            System.out.println("1+" + order1.toString());
        }

//        OrderService simpleOrderService = (OrderService) appContext.getBean("orderService");
////        System.out.println(appContext.getBean("orderService").toString());
//        try {
//            simpleOrderService.placeNewOrder(customer, pizzas);
//        } catch (PizzasOutOfBoundException e) {
//            e.printStackTrace();
//        }


        repoContext.close();
        appContext.close();

    }
}
