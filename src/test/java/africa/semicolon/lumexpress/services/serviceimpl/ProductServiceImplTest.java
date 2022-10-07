package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dtos.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.models.Product;
import africa.semicolon.lumexpress.exceptions.ProductNotFoundException;
import africa.semicolon.lumexpress.services.serviceinterface.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.ReplaceOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    private AddProductRequest request;
    private AddProductResponse response;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("src/main/resources/img/danoMilk.jpg");
        MultipartFile file = new MockMultipartFile("Dano Milk", Files.readAllBytes(path));
        request = buildProductRequest(file);
        response = productService.addProduct(request);
    }

    @Test
    void addProductTest() throws IOException {
        assertThat(response).isNotNull();
        assertThat(response.getProductId()).isGreaterThan(0);
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getCode()).isEqualTo(201);
    }

    @Test
    void updateProductDetailsTest() throws ProductNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        UpdateProductResponse updateResponse = null;
        try {
        JsonNode value = mapper.readTree("1000.00");
//            JsonNode value = mapper.readTree("\"eggs\"");
            JsonPatch patch = new JsonPatch(List.of(new ReplaceOperation(new JsonPointer("/price"), value)));
//            JsonPatch patch = new JsonPatch(List.of(new ReplaceOperation(new JsonPointer("/name"), value)));
//        JsonPatch patch = JsonPatch.fromJson(value);
//        UpdateProductRequest updateRequest = buildUpdateRequest();
            updateResponse = productService.updateProductDetails(1L, patch);
            log.info("updated product:: {}", updateResponse);
        } catch (Exception err) {
            err.printStackTrace();
        }
        assertThat(updateResponse).isNotNull();
//        assertThat(productService.getProductById(1L).getPrice()).isEqualTo(BigDecimal.valueOf(40.00));
//        assertThat(productService.getProductById(1L).getName()).isEqualTo("eggs");
        assertThat(productService.getProductById(1L).getName()).isEqualTo("milk");
        assertThat(updateResponse.getStatusCode()).isEqualTo(200);
    }

    @Test
    void getProductByIdTest() throws IOException, ProductNotFoundException {
        var foundProduct = productService.getProductById(response.getProductId());
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getId()).isEqualTo(response.getProductId());
    }

    @Test
    void getAllProductsTest() throws IOException {
        productService.addProduct((request));
        var getItemsRequest = buildGetItemsRequest();
        Page<Product> productsPage = productService.getAllProducts(getItemsRequest);
        log.info("page contents::{}", productsPage);
        assertThat(productsPage).isNotNull();
        assertThat(productsPage.getTotalElements()).isGreaterThan(0);
    }

    @Test
    void deleteProduct() {
    }

    private AddProductRequest buildProductRequest(MultipartFile file) {
        return AddProductRequest.builder()
                .name("Milk")
                .price(BigDecimal.valueOf(30.00))
                .productCategory("Beverages")
                .quantity(10)
                .image(file)
                .build();
    }

    private UpdateProductRequest buildUpdateRequest() {
        return UpdateProductRequest.builder()
                .price(BigDecimal.valueOf(40.00))
                .quantity(11)
                .productId(1L)
                .description("From the rarest breed in the North")
                .build();
    }

    private GetAllItemsRequest buildGetItemsRequest() {
        return GetAllItemsRequest
                .builder()
                .numberOfItemsPerPage(8)
                .pageNumber(1)
                .build();
    }
}