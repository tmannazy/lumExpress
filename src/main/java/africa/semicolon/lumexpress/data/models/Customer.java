package africa.semicolon.lumexpress.data.models;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends LumExpressUser {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "cart_id")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Cart cart;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Set<Address> addresses = new HashSet<>();
}
