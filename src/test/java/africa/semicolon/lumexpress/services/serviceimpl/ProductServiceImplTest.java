package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CreateProductRequest;
import africa.semicolon.lumexpress.services.serviceinterface.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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

    private CreateProductRequest request;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("src/main/resources/img/danoMilk.jpg");
        MultipartFile file = new MockMultipartFile("Dano Milk", Files.readAllBytes(path));
        request = CreateProductRequest.builder()
                .name("Milk")
                .price(BigDecimal.valueOf(30.00))
                .category("Beverages")
                .quantity(10)
                .image(file).build();
    }

    @Test
    void create() {
        var res = productService.create(request);
        assertThat(res).isNotNull();
        assertThat(res.getProductId()).isGreaterThan(0);
        assertThat(res.getMessage()).isNotNull();
        assertThat(res.getCode()).isEqualTo(201);
    }

    @Test
    void updateProductDetails() {
    }

    @Test
    void getProductById() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void deleteProduct() {
    }
}