package africa.semicolon.lumexpress.data.repositories;

import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    void findByEmailTest() {
        var customer = Customer.builder()
                .cart(new Cart())
                .build();
                customer.setEmail("test@yemail.com");
        customer.setFirstName("John");
        customer.setLastName("Odogwu");
        customer.setPassword("password-er");
        var savedCustomer = customerRepository.save(customer);
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isGreaterThan(0);
        assertThat(customerRepository.findByEmail(savedCustomer.getEmail())).isNotNull();
    }
}