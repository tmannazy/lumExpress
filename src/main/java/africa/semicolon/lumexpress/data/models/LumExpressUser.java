package africa.semicolon.lumexpress.data.models;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LumExpressUser {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String imageURL;
}
