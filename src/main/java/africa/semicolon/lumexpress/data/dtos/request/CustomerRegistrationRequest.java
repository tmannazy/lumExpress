package africa.semicolon.lumexpress.data.dtos.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationRequest {
    private String email;
    private String password;
    private String country;
}
