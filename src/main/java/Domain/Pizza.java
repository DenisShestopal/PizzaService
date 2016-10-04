package Repository;

public class InMemoryPizzaRepository {

    private Long id;
    private String name;
    private Double price;
    private PizzaType pizzaType;

    public InMemoryPizzaRepository(Long id, String name, Double price, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public static enum PizzaType {
        Vegetarian, Sea, Meat
    }
}
