package domain;

import domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@Scope(scopeName = "prototype")
public class Order extends BaseEntity{

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKeyJoinColumn(name = "pizza_id")
    @CollectionTable(name = "pizzas_quantities",
            joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "quantity")
    private Map<Pizza, Integer> pizzas;

    @OneToOne
    @JoinColumn(name = "owner")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = true)
    private OrderStatus status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name="orderDiscount")
    private Integer orderDiscount;

    @Column(name="date")
    private LocalDateTime dateTime;

    public Order(Customer customer, Map<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
        this.customer = customer;
        this.dateTime = LocalDateTime.now();
        this.payment = new Payment();
        this.orderDiscount = 0;
    }

}
