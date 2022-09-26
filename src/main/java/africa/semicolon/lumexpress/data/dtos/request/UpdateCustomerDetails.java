package africa.semicolon.lumexpress.data.dtos.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerDetails {
    private String firstName;
    private String lastName;
    private String customerId;
    private String phoneNumber;
    private String imageURL;
}
