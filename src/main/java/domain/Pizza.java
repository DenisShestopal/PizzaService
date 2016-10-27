package domain;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "pizzas")
@Component
@Scope(scopeName = "prototype")
public class Pizza {

    public enum PizzaType {
        VEGETARIAN, SEA, MEAT
    }

    /*Fields*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 20, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    private PizzaType pizzaType;


    /*Constructors*/
    public Pizza(){

    }

    public Pizza(String name, Double price, PizzaType pizzaType) {
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
    }

    public Pizza(Long id, String name, Double price, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
    }

    /*Getters & Setters*/
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

    @Override
    public String toString() {
        return "\nPizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzaType=" + pizzaType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;

        Pizza pizza = (Pizza) o;

        return id != null ? id.equals(pizza.id) : pizza.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
