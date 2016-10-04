import Domain.Customer;
import Repository.InMemoryOrderRepository;
import Services.InMemoryOrderService;

public class AppRunner {

    public static void main(String[] args) {
        Customer customer = new Customer(1L, "Vasya Pupkin");
        InMemoryOrderRepository order;

        InMemoryOrderService orderService = new InMemoryOrderService();
        order = orderService.placeNewOrder(customer, 1, 2, 3);
        System.out.println(order.toString());
    }
}
