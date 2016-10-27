package domain;

import domain.discounts.Discount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity{

    @Column(name = "initial_price", nullable = false)
    private Double initialPrice;
    @ManyToOne
    @JoinColumn(name = "discount_name", nullable = false)
    private Discount appliedDiscount;
    @Column(name = "discount", nullable = false)
    private Double discount;
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
    @Column(name = "date_time")
    private LocalDateTime dateTime;

}
