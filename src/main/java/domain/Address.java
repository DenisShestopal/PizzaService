package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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

}
