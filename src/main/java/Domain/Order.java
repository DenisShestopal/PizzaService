package Domain;

import java.util.List;

public class Order {

    private Long id;
    private List<Pizza> pizzas;
    private Customer customer;

    public Order(Long id, Customer customer, List<Pizza> pizzas) {
        this.id = id;
        this.pizzas = pizzas;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", pizzas=" + pizzas +
                '}';
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
