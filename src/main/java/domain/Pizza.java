package domain;


import domain.enums.PizzaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "pizzas")
@Entity
@Scope(scopeName = "prototype")
public class Pizza extends BaseEntity {

    @Column(name = "name", length = 32, unique = true)
    private String name;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 32)
    private PizzaType pizzaType;

    public Pizza(String name, Double price, PizzaType pizzaType) {
        this.name = name;
        this.price = price;
        this.pizzaType = pizzaType;
    }
}
