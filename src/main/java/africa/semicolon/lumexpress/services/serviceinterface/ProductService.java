package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.semicolon.lumexpress.data.dtos.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exceptions.ProductNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws IOException;

    UpdateProductResponse updateProductDetails(Long productId, JsonPatch patch) throws ProductNotFoundException;

    Product getProductById(Long id) throws ProductNotFoundException;

    Page<Product> getAllProducts(GetAllItemsRequest request);

    String deleteProduct(Long id);
}
