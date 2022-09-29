package africa.semicolon.lumexpress.data.dtos.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private BigDecimal price;
    private MultipartFile image;
    private String productCategory;
    private int quantity;
}
