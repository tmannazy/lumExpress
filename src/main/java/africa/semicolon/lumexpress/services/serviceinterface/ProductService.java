package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws IOException;

    UpdateProductResponse updateProductDetails(UpdateProductRequest request) throws ProductNotFoundException;

    Product getProductById(Long id) throws ProductNotFoundException;

    Page<Product> getAllProducts(GetAllItemsRequest request);

    String deleteProduct(Long id);
}
