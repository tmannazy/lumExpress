package africa.semicolon.lumexpress.data.dtos.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemsRequest {
    private int numberOfItemsPerPage;
    private int pageNumber;
}
