package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.LoginRequest;
import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import africa.semicolon.lumexpress.data.repositories.CustomerRepository;
import africa.semicolon.lumexpress.services.serviceinterface.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomerRepository customerRepository;

    private LoginRequest loginRequest;

    @BeforeEach
    @Sql({"src/main/resources/insert.sql"})
    void setUp() {
        var customer = Customer.builder()
                .cart(new Cart())
                .build();
        customer.setEmail("test@yemail.com");
        customer.setFirstName("John");
        customer.setLastName("Odogwu");
        customer.setPassword("password-er");
        customerRepository.save(customer);
        loginRequest = LoginRequest.builder()
                .email("test@yemail.com")
                .password("password-er")
                .build();
    }

    @Test
    void loginTest() {
        var loginResponse = userService.login(loginRequest);
        assertThat(loginResponse).isNotNull();
        assertThat(loginResponse.getCode()).isEqualTo(200);
    }
}