package appRunners1;


import domain1.Order;
import domain1.Pizza;
import infrastructure1.exceptions1.PizzasOutOfBoundException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.OrderService;

import java.util.Arrays;

public class SpringAppRunner {

    public static void main(String ... args){
        ConfigurableApplicationContext repoContext = new ClassPathXmlApplicationContext("repoContext.xml");
        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));
        //указываем, на основе какой конфигурации спринга работаем

        ConfigurableApplicationContext appContext =
                new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repoContext);



        OrderService orderService = (OrderService) appContext.getBean("orderService");

        orderService.addPizza("newone", 300.0, Pizza.PizzaType.MEAT);
        orderService.addCustomer("Vasya", "Kyiv", "K18a", true);

        Order order1 = null;
        try {
            order1 = orderService.placeNewOrder(orderService.getCustomerById(1L), 1L, 1L, 1L, 1L, 1L);
        } catch (PizzasOutOfBoundException e) {
            e.printStackTrace();
        }
        order1.pay();
        Order order2 = null;
        try {
            order2 = orderService.placeNewOrder(orderService.getCustomerById(1L), 1L, 1L);
        } catch (PizzasOutOfBoundException e) {
            e.printStackTrace();
        }
        System.out.println("TOTAL: " + order1.getTotalPrice());
        System.out.println("TOTAL: " + order2.getTotalPrice());

        System.out.println(order1);
        System.out.println(order2);

        repoContext.close();
        appContext.close();

    }
}
