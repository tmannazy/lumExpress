package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.AddProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exceptions.ProductNotFoundException;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws IOException;

    String updateProductDetails(UpdateProductRequest request);

    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    String deleteProduct(Long id);
}
