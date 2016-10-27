package domain;

import domain.discounts.Discount;
import domain.discounts.DiscountState;
import domain.enums.OrderStatus;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @Transient
    private Set<Discount> activeDiscounts;

    public Order(Set<Discount> discounts) {
        status = OrderStatus.NEW;
        pizzas = new HashMap<>();
        payment = new Payment();
        removeInactiveDiscounts(discounts);
        activeDiscounts = discounts;
    }

    public Order(){

    }

    public Order(Map<Pizza, Integer> pizzas, Customer customer, Set<Discount> activeDiscounts) {
        this.pizzas = pizzas;
        this.customer = customer;
        this.activeDiscounts = activeDiscounts;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("ORDER #" + id + ":\n");
        info.append("CUSTOMER:\n" + customer);
        info.append("PIZZAS:\n");
        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
            info.append("\t" + entry.getKey().getName() + ": " + entry.getValue() + "x");
            info.append("\n\t----------\n");
        }
        info.append("\n");
        info.append("PAYMENT:\n" + payment);
        return info.toString();
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return id != null ? id.equals(order.id) : order.id == null;

    }

    /*Getters & Setters*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Map<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getInitialPrice() {
        return payment.getInitialPrice();
    }

    private void setInitialPrice(double initialPrice) {
        payment.setInitialPrice(initialPrice);
    }

    public Discount getAppliedDiscount() {
        return payment.getAppliedDiscount();
    }

    private void setAppliedDiscount(Discount appliedDiscount) {
        payment.setAppliedDiscount(appliedDiscount);
    }

    public double getDiscount() {
        return payment.getDiscount();
    }

    private void setDiscount(double discount) {
        payment.setDiscount(discount);
    }

    public double getTotalPrice() {
        return payment.getTotalPrice();
    }

    private void setTotalPrice(double totalPrice) {
        payment.setTotalPrice(totalPrice);
    }

    /*Public Methods*/
    public void insertPizzas(List<Pizza> pizzas) {
        for (Pizza pizza : pizzas) {
            addPizza(pizza);
        }
    }

    public void addPizza(Pizza pizza) {
        int initialQuantity = 0;
        if (pizzas.containsKey(pizza)) {
            initialQuantity = pizzas.get(pizza);
        }
        pizzas.put(pizza, ++initialQuantity);
    }

    public void removePizza(Pizza pizza) {
        if (!pizzas.containsKey(pizza)) {
            throw new RuntimeException("Such pizza does not exist in order");
        } else {
            int initialQuantity = pizzas.get(pizza);
            if (initialQuantity > 1) {
                pizzas.put(pizza, --initialQuantity);
            } else {
                pizzas.remove(pizza);
            }
        }
    }

    public int getAmountOfPizzas() {
        int result = 0;
        for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
            result += pizza.getValue();
        }
        return result;
    }

    public Pizza getPizzaById(Long id) {
        for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
            if ((pizza.getKey().getId()).equals(id)) {
                return pizza.getKey();
            }
        }
        throw new RuntimeException("Pizza not found.");
    }

    public void countTotalPrice() {
        countInitialPrice();
        countDiscount();
        setTotalPrice(getInitialPrice() - getDiscount());
    }

    public void cancel() {
        status = status.getCancelStatus();
    }

    public void confirm() {
        status = status.getNextStatus(status);
    }

    public void pay() {
        if (customer.hasCard()) {
            customer.increaseCardBalance(getTotalPrice());
        }
        status = status.getNextStatus(status);
    }

    public boolean isEmpty() {
        return (pizzas.size() == 0);
    }

    /*Private Methods*/
    private void countInitialPrice() {
        double result = 0.0;
        for (Map.Entry<Pizza, Integer> pizza : pizzas.entrySet()) {
            result += (pizza.getKey().getPrice() * pizza.getValue());
        }
        setInitialPrice(result);
    }

    private void countDiscount() {
        double maxDiscount = 0.0;
        for (Discount discount : activeDiscounts) {
            if (discount.canBeApplied(this)) {
                double currentDiscount = discount.getDiscount(this);
                if (currentDiscount > maxDiscount) {
                    maxDiscount = currentDiscount;
                    setAppliedDiscount(discount);
                }
            }
        }
        setDiscount(maxDiscount);
    }

    private void removeInactiveDiscounts(Set<Discount> discounts) {
        for (Discount discount : discounts) {
            if (discount.getState().equals(DiscountState.INACTIVE)) {
                discounts.remove(discount);
            }
        }
    }


}
