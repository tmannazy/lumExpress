package africa.semicolon.lumexpress.data.dtos.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsRequest {
    private int numberOfProductsPerPage;
    private int pageNumber;
}
