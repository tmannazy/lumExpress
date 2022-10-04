package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.cloud.CloudService;
import africa.semicolon.lumexpress.data.dtos.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.models.Category;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.data.repositories.ProductRepository;
import africa.semicolon.lumexpress.exceptions.ProductNotFoundException;
import africa.semicolon.lumexpress.services.serviceinterface.ProductService;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
    public UpdateProductResponse updateProductDetails(UpdateProductRequest request) throws ProductNotFoundException {
        var foundProduct = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(
                        String.format("product with id %d not found", request.getProductId())
                ));
        foundProduct.setPrice(request.getPrice());
//        foundProduct
        foundProduct.setQuantity(request.getQuantity());

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
    public Page<Product> getAllProducts(GetAllItemsRequest request) {
        Pageable pageSpecs = PageRequest.of(request.getPageNumber() -1, request.getNumberOfItemsPerPage());
        return productRepository.findAll(pageSpecs);
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
