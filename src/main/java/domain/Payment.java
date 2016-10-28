package domain;

import domain.discounts.Discount;
import domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

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
    @Column(name = "discount", nullable = false)
    private Double discount;
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "status")
    private PaymentStatus status;

}
