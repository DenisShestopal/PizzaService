package domain;

import domain.discounts.Discount;
import domain.enums.DiscountState;
import domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @ElementCollection
    @CollectionTable(name = "pizzas_quantities", joinColumns = @JoinColumn(name = "order_id", nullable = false))
    @MapKeyJoinColumn(name = "pizza_id")
    @Column(name = "quantity", nullable = false)
    private Map<Pizza, Integer> pizzas;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private OrderStatus status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;


//    /*Public Methods*/
//    public void insertPizzas(List<Pizza> pizzas) {
//        for (Pizza pizza : pizzas) {
//            addPizza(pizza);
//        }
//    }
//
//    public void addPizza(Pizza pizza) {
//        int initialQuantity = 0;
//        if (pizzas.containsKey(pizza)) {
//            initialQuantity = pizzas.get(pizza);
//        }
//        pizzas.put(pizza, ++initialQuantity);
//    }
//
//    public void removePizza(Pizza pizza) {
//        if (!pizzas.containsKey(pizza)) {
//            throw new RuntimeException("Such pizza does not exist in order");
//        } else {
//            int initialQuantity = pizzas.get(pizza);
//            if (initialQuantity > 1) {
//                pizzas.put(pizza, --initialQuantity);
//            } else {
//                pizzas.remove(pizza);
//            }
//        }
//    }
//
//    public int getAmountOfPizzas() {
//        int result = 0;
//        for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
//            result += pizza.getValue();
//        }
//        return result;
//    }
//
//    public Pizza getPizzaById(Long id) {
//        for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
//            if ((pizza.getKey().getId()).equals(id)) {
//                return pizza.getKey();
//            }
//        }
//        throw new RuntimeException("Pizza not found.");
//    }
//
//    public void countTotalPrice() {
//        countInitialPrice();
//        countDiscount();
//        setTotalPrice(getInitialPrice() - getDiscount());
//    }
//
//    public void cancel() {
//        status = status.getCancelStatus();
//    }
//
//    public void confirm() {
//        status = status.getNextStatus(status);
//    }
//
//    public void pay() {
//        if (customer.hasCard()) {
//            customer.increaseCardBalance(getTotalPrice());
//        }
//        status = status.getNextStatus(status);
//    }
//
//    public boolean isEmpty() {
//        return (pizzas.size() == 0);
//    }
//
//    /*Private Methods*/
//    private void countInitialPrice() {
//        double result = 0.0;
//        for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
//            result += (pizza.getKey().getPrice() * pizza.getValue());
//        }
//        setInitialPrice(result);
//    }
//
//    private void countDiscount() {
//        double maxDiscount = 0.0;
//        for (Discount discount : activeDiscounts) {
//            if (discount.canBeApplied(this)) {
//                double currentDiscount = discount.getDiscount(this);
//                if (currentDiscount > maxDiscount) {
//                    maxDiscount = currentDiscount;
//                    setAppliedDiscount(discount);
//                }
//            }
//        }
//        setDiscount(maxDiscount);
//    }
//
//    private void removeInactiveDiscounts(Set<Discount> discounts) {
//        for (Discount discount : discounts) {
//            if (discount.getState().equals(DiscountState.INACTIVE)) {
//                discounts.remove(discount);
//            }
//        }
//    }


}
