package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.AddProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exceptions.ProductNotFoundException;
import africa.semicolon.lumexpress.services.serviceinterface.ProductService;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    private AddProductRequest request;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("src/main/resources/img/danoMilk.jpg");
        MultipartFile file = new MockMultipartFile("Dano Milk", Files.readAllBytes(path));
        request = AddProductRequest.builder()
                .name("Milk")
                .price(BigDecimal.valueOf(30.00))
                .productCategory("Beverages")
                .quantity(10)
//                .image(file)
                .build();
    }

    @Test
    void create() throws IOException {
        var res = productService.addProduct(request);
        assertThat(res).isNotNull();
        assertThat(res.getProductId()).isGreaterThan(0);
        assertThat(res.getMessage()).isNotNull();
        assertThat(res.getCode()).isEqualTo(201);
    }

    @Test
    void updateProductDetails() {
    }

    @Test
    void getProductByIdTest() throws IOException, ProductNotFoundException {
        AddProductResponse response = productService.addProduct(request);
        var foundProduct = productService.getProductById(response.getProductId());
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getId()).isEqualTo(response.getProductId());
    }

    @Test
    void getAllProductsTest() {
        Page<Product>
    }

    @Test
    void deleteProduct() {
    }
}