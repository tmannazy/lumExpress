package africa.semicolon.lumexpress.data.dtos.request;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    @NotNull
    private MultipartFile image;
    private String name;
    private BigDecimal price;
    private String productCategory;
    private int quantity;
}
