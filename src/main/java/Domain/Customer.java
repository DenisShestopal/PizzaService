package Domain;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Component
@Scope(scopeName = "prototype")
public class Customer {

    /*Fields*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    /*Constructors*/
    public Customer() {

    }

    public Customer(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    /*Methods*/
    /*Getters&Setters*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /*Other methods*/
    public double getCardBalance() {
        if (hasCard()) {
            return card.getBalance();
        }
        throw new RuntimeException("This customer has no card.");
    }

    public boolean hasCard() {
        return (card != null);
    }

    public void increaseAccumulativeCardBalance(double amount) {
        card.increaseCardBalance(amount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        return name != null ? name.equals(customer.name) : customer.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
