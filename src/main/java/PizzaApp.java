import Domain.Customer;
import Domain.Order;
import Infrastructure.ApplicationContext;
import Infrastructure.Context;
import Infrastructure.JavaConfig;
import Repository.InMemoryOrderRepository;
import Repository.PizzaRepository;
import Services.OrderService;
import Services.SimpleOrderService;

public class PizzaApp {

    public static void main(String[] args) {
        Customer customer = new Customer(1L, "Vasya Pupkin");
//        InMemoryOrderRepository order;
//
//        SimpleOrderService orderService = new SimpleOrderService();
//        System.out.println(order.toString());

        Context context = new ApplicationContext(new JavaConfig());
        PizzaRepository pizzaRepository = context.getBean("pizzaRepository");
        System.out.println(pizzaRepository.find(1L));

        OrderService orderService = context.getBean("orderService");
        Order order = orderService.placeNewOrder(customer, 1L, 2L, 3L);
        System.out.println(order);

    }
}
