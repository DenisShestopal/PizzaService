//import domain.Customer;
//import domain.Order;
//import infrastructure.context.ApplicationContext;
//import infrastructure.context.contexts;
//import infrastructure.config.JavaConfig;
//import services.OrderService;
//
//public class AppRunner {
//
//    public static void main(String[] args) {
//                System.out.println("Pizza Service");
//        contexts context = new ApplicationContext(new JavaConfig());
//
//        Customer customer = new Customer();
//        OrderService orderService = context.getBean("orderService");
//        Order order = null;
//        try {
//            order = new Order();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        System.out.println(order);
//    }
//}
