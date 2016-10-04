public class AppRunner {

    public static void main(String[] args) {
        Customer customer = new Customer(1L, "Vasya Pupkin");
        Order order;

        SimpleOrderService orderService = new SimpleOrderService();
        order = orderService.placeNewOrder(customer, 1, 2, 3);
        System.out.println(order.toString());
    }
}
