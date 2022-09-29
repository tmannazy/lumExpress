package africa.semicolon.lumexpress.data.dtos.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse {
    private Long productId;
    private String message;
    private int code;
}
