package africa.semicolon.lumexpress.data.dtos.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private Long productId;
    private BigDecimal price;
    private int quantity;
    private String description;
}
