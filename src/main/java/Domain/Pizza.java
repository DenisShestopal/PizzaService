package Domain;


import java.math.BigDecimal;

public class Pizza {

    public enum PizzaType {
        VEGETARIAN, SEA, MEAT
    }

    private Long id;
    private String name;
    private BigDecimal price;
    private PizzaType pizzaType;

    public Pizza(Long id, String name, BigDecimal price, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
    }

    @Override
    public String toString() {
        return "\nPizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzaType=" + pizzaType +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

}
