package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.CreateProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.CreateProductResponse;
import africa.semicolon.lumexpress.data.models.Product;

import java.util.List;

public interface ProductService {
    CreateProductResponse create(CreateProductRequest request);

    String updateProductDetails(UpdateProductRequest request);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    String deleteProduct(Long id);
}
