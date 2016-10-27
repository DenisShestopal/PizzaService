package domain1;

import domain1.discounts.Discount;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    /*Fields*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
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

    /*Constructors*/
    public Payment() {
    }

    /*Methods*/
    /*Getters&Setters*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Discount getAppliedDiscount() {
        return appliedDiscount;
    }

    public void setAppliedDiscount(Discount appliedDiscount) {
        this.appliedDiscount = appliedDiscount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }


    /*Other Methods*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        if (initialPrice != null ? !initialPrice.equals(payment.initialPrice) : payment.initialPrice != null)
            return false;
        if (appliedDiscount != null ? !appliedDiscount.equals(payment.appliedDiscount) : payment.appliedDiscount != null)
            return false;
        if (discount != null ? !discount.equals(payment.discount) : payment.discount != null) return false;
        if (totalPrice != null ? !totalPrice.equals(payment.totalPrice) : payment.totalPrice != null) return false;
        return dateTime != null ? dateTime.equals(payment.dateTime) : payment.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = initialPrice != null ? initialPrice.hashCode() : 0;
        result = 31 * result + (appliedDiscount != null ? appliedDiscount.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\tInitial price: " + initialPrice + " UAH" +
                "\n\tDiscount: " + discount + " UAH (" + appliedDiscount.getName() + ")" +
                "\n\tIN TOTAL: " + totalPrice + " UAH\n";
    }
}
