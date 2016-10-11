package Infrastructure;

import Domain.Pizza;
import org.springframework.beans.factory.FactoryBean;

import java.math.BigDecimal;

public class MyFactoryBean implements FactoryBean<Pizza>{
    @Override
    public Pizza getObject() throws Exception {
        return new Pizza(1L, "new Pizza", new BigDecimal("44.44"), Pizza.PizzaType.MEAT);
    }

    @Override
    public Class<?> getObjectType() {
        return Pizza.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
