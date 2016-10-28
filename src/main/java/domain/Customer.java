package domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Component
@Scope(scopeName = "prototype")
public class Customer extends BaseEntity{

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "card")
    private Card card;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "owner")
    private List<Order> orders;

    @Column(name = "status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private boolean status;

//    private boolean hasCard() {
//        return (card != null);
//    }

//    private void increaseCardBalance(double amount) {
//        card.increaseCardBalance(amount);
//    }

}
