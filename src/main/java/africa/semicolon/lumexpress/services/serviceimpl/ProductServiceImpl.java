package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.cloud.CloudService;
import africa.semicolon.lumexpress.data.dtos.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.AddProductResponse;
import africa.semicolon.lumexpress.data.models.Category;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.data.repositories.ProductRepository;
import africa.semicolon.lumexpress.exceptions.ProductNotFoundException;
import africa.semicolon.lumexpress.services.serviceinterface.ProductService;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CloudService cloudService;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public AddProductResponse addProduct(AddProductRequest request) throws IOException {
        Product product = modelMapper.map(request, Product.class);
        product.getCategories().add(Category.valueOf(request.getProductCategory().toUpperCase()));
        var imageUrl = cloudService.upload(request.getImage().getBytes(), ObjectUtils.emptyMap());
        product.setImageURL(imageUrl);
        var savedProduct = productRepository.save(product);
        log.info("cloudinary image url::{}", imageUrl);
        log.info("product saved to db::{}", savedProduct);
        return buildCreateProductResponse(savedProduct);
    }

    private AddProductResponse buildCreateProductResponse(Product savedProduct) {
        return AddProductResponse.builder()
                .productId(savedProduct.getId())
                .code(201)
                .message(savedProduct.getName() + " added to products").build();
    }

    @Override
    public String updateProductDetails(UpdateProductRequest request) {
        return null;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
//        Optional<Product> foundProduct = productRepository.findById(id);
//        if (foundProduct.isEmpty()) {
//            throw new ProductNotFoundException(
//                    String.format("product with id %d not found.", id));
//        }
//        return foundProduct.get();

        return productRepository.findById(id).orElseThrow(()->
                new ProductNotFoundException(String.format("product with id %d not found.", id)));
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
