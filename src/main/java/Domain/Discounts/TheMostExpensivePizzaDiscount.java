package Domain.Discounts;

import Domain.Order;
import Domain.Pizza;
import Infrastructure.Utils.Utils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TheMostExpensivePizzaDiscount extends  Discount {

    private final static int MIN_AMOUNT_OF_PIZZAS = 4;
    private final static int PIZZA_PRICE_PERCENTAGE = 30;

    @Override
    public boolean canBeApplied(Order order) {
        this.order = order;
        return isEnoughPizzasInOrder();
    }

    @Override
    public double getDiscount(Order order) {
        Map<Pizza, Integer> theMostExpensivePizzas = getTheMostExpensivePizzas();
        double discount = 0;
        for (Map.Entry<Pizza, Integer> pizza : theMostExpensivePizzas.entrySet()) {
            discount += (Utils.getPercentageOfNumber(pizza.getKey().getPrice(), PIZZA_PRICE_PERCENTAGE)) * pizza.getValue();
        }
        return discount;
    }

    private boolean isEnoughPizzasInOrder() {
        return (order.getAmountOfPizzas() > MIN_AMOUNT_OF_PIZZAS);
    }

    private Map<Pizza, Integer> getTheMostExpensivePizzas() {
        if (isEmpty()) {
            throw new RuntimeException("Order is empty.");
        } else {
            Map<Pizza, Integer> result = new HashMap<>();
            double maxPrice = 0.0;
            Map<Pizza, Integer> pizzas = getPizzasFromOrder();
            for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
                Pizza currentPizza = pizza.getKey();
                if (currentPizza.getPrice() > maxPrice) {
                    maxPrice = currentPizza.getPrice();
                }
            }
            for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
                if (pizza.getKey().getPrice() == maxPrice) {
                    result.put(pizza.getKey(), pizza.getValue());
                }
            }
            return result;
        }
    }

    private boolean isEmpty() {
        return order.isEmpty();
    }

    private Pizza getPizzaInOrderById(Long id) {
        return order.getPizzaById(id);
    }

    private Map<Pizza, Integer> getPizzasFromOrder() {
        return order.getPizzas();
    }


}
