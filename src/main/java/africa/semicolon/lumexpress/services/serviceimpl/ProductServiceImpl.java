package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CreateProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.CreateProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.data.repositories.ProductRepository;
import africa.semicolon.lumexpress.services.serviceinterface.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public CreateProductResponse create(CreateProductRequest request) {
        Product product = modelMapper.map(request, Product.class);
        var savedProduct = productRepository.save(product);
        log.info("product saved to db::{}",savedProduct);
        return CreateProductResponse.builder()
                .productId(product.getId())
                .code(201)
                .message(product.getName() + " added to products").build();

    }

    @Override
    public String updateProductDetails(UpdateProductRequest request) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
