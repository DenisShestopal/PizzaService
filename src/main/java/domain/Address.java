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
@Component
@Table(name = "addresses")
@Scope(scopeName = "prototype")
public class Address extends BaseEntity{

    @Column(name = "city", length = 32)
    private String city;
    @Column(name = "street", length = 32)
    private String street;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private List<Customer> customers;

    @Override
    public String toString() {
        return "\t\tCity: " + city +
                "\n\t\tStreet: " + street + "\n";
    }
}
