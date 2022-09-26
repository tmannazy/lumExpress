package africa.semicolon.lumexpress.data.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends LumExpressUser {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Set<Address> address;
}
