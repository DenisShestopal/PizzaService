package Infrastructure.Config;

import Repository.InMemory.InMemoryOrderRepository;
import Repository.InMemory.InMemoryPizzaRepository;
import Services.Simple.SimpleOrderService;
import Services.Simple.SimplePizzaService;

import java.util.HashMap;
import java.util.Map;

public class JavaConfig implements Config {

    private Map<String, Class<?>> classes = new HashMap<>();
    {
        classes.put("pizzaRepository", InMemoryPizzaRepository.class);
        classes.put("orderRepository", InMemoryOrderRepository.class);
        classes.put("orderService", SimpleOrderService.class);
        classes.put("pizzaService", SimplePizzaService.class);
    }

    @Override
    public Class<?> getImpl(String name) {
        return classes.get(name);
    }
}
