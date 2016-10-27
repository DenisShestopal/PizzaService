package domain.discounts;

import domain.BaseEntity;
import domain.Order;
import domain.enums.DiscountState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discounts")
public abstract class Discount extends BaseEntity{
//    @Id
//    @Column(name = "name", nullable = false, length = 20)
//    private String name;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state", nullable = false)
    private DiscountState state;
    @Transient
    protected Order order;

    /*Abstract Methods*/
    public abstract boolean canBeApplied(Order order);

    public abstract double getDiscount(Order order);

}
