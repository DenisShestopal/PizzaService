//package infrastructure.config;
//
//import repository1.inMemory1.InMemoryOrderRepository;
//import repository1.inMemory1.InMemoryPizzaRepository;
//import services.simple.SimpleOrderService;
//import services.simple.SimplePizzaService;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class JavaConfig implements configs1 {
//
//    private Map<String, Class<?>> classes = new HashMap<>();
//    {
//        classes.put("pizzaRepository", InMemoryPizzaRepository.class);
//        classes.put("orderRepository", InMemoryOrderRepository.class);
//        classes.put("orderService", SimpleOrderService.class);
//        classes.put("pizzaService", SimplePizzaService.class);
//    }
//
//    @Override
//    public Class<?> getImpl(String name) {
//        return classes.get(name);
//    }
//}
