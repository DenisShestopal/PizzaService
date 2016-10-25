


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringAppRunner {

    public static void main(String ... args){
        ConfigurableApplicationContext repoContext = new ClassPathXmlApplicationContext("repoContext.xml");
        //указываем, на основе какой конфигурации спринга работаем

        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));

        ConfigurableApplicationContext appContext =
                new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repoContext);

//        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));
//
//        OrderService orderService = (OrderService) appContext.getBean("orderService");
//        orderService.setApplicationContext(appContext);
//
//        Order order = null;
//        try {
//            order = orderService.placeNewOrder(new Customer(1L, "Vasiliy", new Address()), 1L, 2L, 3L, 3L, 3L);
//        } catch (PizzasOutOfBoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(order);
//        System.out.println("Orders price = " + order.getInitialPrice());
//        System.out.println("added to the card: " + order.getDiscount());

        repoContext.close();
        appContext.close();

    }
}
