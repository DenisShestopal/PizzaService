package domain;


import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "cards")
@Component
@Scope(scopeName = "prototype")
public class Card extends BaseEntity{

    @Column(name = "balance", nullable = false)
    private double balance;
    @OneToOne(mappedBy = "card")
    private Customer customer;

   /* *//*Other methods*//*
    void increaseCardBalance(double amount) {
        balance += amount;
    }*/

}
