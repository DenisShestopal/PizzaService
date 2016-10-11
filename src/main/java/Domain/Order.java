package Domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Order {

    private Long id;
    private List<Pizza> pizzas;
    private Customer customer;
    private BigDecimal price;
    private BigDecimal discount;
    private OrderStatus orderStatus;

    public Order(Long id, Customer customer, List<Pizza> pizzas) {
        this.id = id;
        this.pizzas = pizzas;
        this.customer = customer;
        this.price = new BigDecimal("0");
        this.discount = new BigDecimal("0");
        this.orderStatus=OrderStatus.NEW;
    }

    public Order(){

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", pizzas=" + pizzas +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
