import Domain.Order;
import Repository.PizzaRepository;
import Services.OrderService;
import Services.SomeServices.SomeService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringAppRunner {

    public static void main(String ... args){
        ConfigurableApplicationContext repoContext =
                new ClassPathXmlApplicationContext("repoContext.xml");
        //указываем, на основе какой конфигурации спринга работаем

        System.out.println(Arrays.toString(repoContext.getBeanDefinitionNames()));

        ConfigurableApplicationContext appContext =
                new ClassPathXmlApplicationContext(
                        new String[]{"appContext.xml"}, repoContext);

        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

        System.out.println(repoContext.getBean("T1", SomeService.class).getString());
        System.out.println(appContext.getBean("T1", SomeService.class).getString());

        PizzaRepository pizzaRepository = (PizzaRepository) repoContext.getBean("pizzaRepository");
        System.out.println(pizzaRepository.getPizzaById(1L));

        OrderService orderService = (OrderService) appContext.getBean("orderService");
        Order order = orderService.placeNewOrder(null, 1L, 2L, 3L);
        System.out.println(order);

        repoContext.close();
        appContext.close();

    }
}
