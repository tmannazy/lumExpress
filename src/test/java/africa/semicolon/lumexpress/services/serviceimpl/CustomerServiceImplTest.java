package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.repositories.CustomerRepository;
import africa.semicolon.lumexpress.services.serviceinterface.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    private CustomerRegistrationRequest request;

    @BeforeEach
    void setUp() {
        request = CustomerRegistrationRequest.builder()
                .email("test@gmail.com")
                .password("password-er")
                .country("Nigeria")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        CustomerRegistrationResponse res =  customerService.register(request);
        assertEquals(200, res.getCode());
        assertThat(res).isNotNull();
        assertThat(res.getMessage()).isNotNull();
        assertThat(res.getUserId()).isGreaterThan(0);
        assertThat(res.getCode()).isEqualTo(200);
//        assertEquals(1, customerService.numberOfCustomers());
    }

    @Test
    void login() {
    }

    @Test
    void completeProfile() {
    }
}