package africa.semicolon.lumexpress.data.dtos.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationResponse {
    private Long userId;
    private String message;
    private int code;
}
