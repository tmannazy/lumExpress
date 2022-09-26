package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.services.serviceinterface.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerServiceImplTest {
//    @Autowired
    private CustomerService customerService;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        CustomerRegistrationRequest request = CustomerRegistrationRequest
                .builder()
                .email("test@gmail.com")
                .password("password-er")
                .country("Nigeria")
                .build();
        CustomerRegistrationResponse response =
                CustomerRegistrationResponse
                        .builder()
                        .code(200)
                        .message("Successfully registered")
                        .build();
//        CustomerRegistrationResponse response;
        customerService.register(request);
        assertEquals(200, response.getCode());
    }

    @Test
    void login() {
    }

    @Test
    void completeProfile() {
    }
}