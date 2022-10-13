package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.services.serviceinterface.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    private CustomerRegistrationRequest request;

    @BeforeEach
    void setUp() {
        request = CustomerRegistrationRequest.builder()
                .email("fiverrlive@gmail.com")
                .password("password-er")
                .country("Nigeria")
                .build();
    }

    @Test
    void registerTest() throws MessagingException {
        CustomerRegistrationResponse res =  customerService.register(request);
        assertThat(res).isNotNull();
        assertThat(res.getMessage()).isNotNull();
        assertThat(res.getUserId()).isGreaterThan(0);
        assertThat(res.getCode()).isEqualTo(201);
    }

    @Test
    void completeProfile() {
    }
}