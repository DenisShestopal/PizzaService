package Domain;

import java.util.List;

public class Order {

    private Long id;
    private List<Pizza> pizzas;

    public Order(Long id, List<Pizza> pizzas) {
        this.id = id;
        this.pizzas = pizzas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
