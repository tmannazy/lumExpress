package africa.semicolon.lumexpress.data.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vendor extends LumExpressUser{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
    private Store store;
}
