import Domain.Order;
import Repository.PizzaRepository;
import Services.OrderService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringAppRunner {

    public static void main(String ... args){
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");
        //указываем, на основе какой конфигурации спринга работаем

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        PizzaRepository pizzaRepository = (PizzaRepository) context.getBean("pizzaRepository");
        pizzaRepository.getPizzaById(1L);
        System.out.println();

        OrderService orderService = (OrderService) context.getBean("orderService");
        Order order = orderService.placeNewOrder(null, 1L, 2L, 3L);
        System.out.println(order);

        context.close();

    }
}
