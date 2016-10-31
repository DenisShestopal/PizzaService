package domain;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "addresses")
@Scope(scopeName = "prototype")
public class Address extends BaseEntity{

    @Column(name = "city", length = 32)
    private String city;
    @Column(name = "street", length = 32)
    private String street;

}
