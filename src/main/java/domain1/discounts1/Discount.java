package domain1.discounts;

import domain1.Order;

import javax.persistence.*;

@Entity
@Table(name = "discounts")
public abstract class Discount {

    /*Fields*/
    @Id
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state", nullable = false)
    private DiscountState state;
    @Transient
    protected Order order;

    /*Constructors*/
    public Discount() {
        name = this.getClass().getSimpleName();
        state = DiscountState.ACTIVE;
    }

    /*Abstract Methods*/
    public abstract boolean canBeApplied(Order order);

    public abstract double getDiscount(Order order);

    /*Public Methods*/
    public void changeState() {
        state = state.reverseState();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscountState getState() {
        return state;
    }

    public void setState(DiscountState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;

        Discount discount = (Discount) o;

        return name != null ? name.equals(discount.name) : discount.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Discount name: " + name +
                "\nDiscount state: " + state.name() + "\n";
    }
}
