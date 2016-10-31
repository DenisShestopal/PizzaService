package domain;


import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "customers")
@Scope(scopeName = "prototype")
public class Customer extends BaseEntity{

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Card> cards;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

    @Column(name = "status", length = 20, nullable = false)
    private boolean status;

    public Customer() {
        this.name = "Unknown User";
        this.status = true;
        this.addresses = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

}
