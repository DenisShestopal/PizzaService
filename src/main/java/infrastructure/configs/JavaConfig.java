//package infrastructure.config;
//
//import repository.inMemory.InMemoryOrderRepository;
//import repository.inMemory.InMemoryPizzaRepository;
//import services.simple.SimpleOrderService;
//import services.simple.SimplePizzaService;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class JavaConfig implements configs {
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
