package domain;


import domain.enums.DiscountState;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "cards")
@Entity
@Scope(scopeName = "prototype")
public class Card extends BaseEntity{

    private final static int PERCENTAGE_LIMIT = 30;
    private final static int CARD_PERCENTAGE = 10;

    @Column(name = "balance", nullable = false)
    private Double balance;

//    @OneToOne(mappedBy = "cards")
//    private Customer customer;

    @Column(name = "discount")
    private Integer cardDiscount;

    @Column(name = "status")
    private DiscountState status;

    public Card() {
        this.balance = 0.0;
        this.cardDiscount = CARD_PERCENTAGE;
        this.status = DiscountState.ACTIVE;
    }

}
