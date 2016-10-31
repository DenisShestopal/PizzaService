package domain;

import domain.discounts.Discount;
import domain.enums.PaymentStatus;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "payments")
@Scope(scopeName = "prototype")
public class Payment extends BaseEntity{

    @Column(name = "initial_price")
    private Double initialPrice;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "status")
    private PaymentStatus status;

}
