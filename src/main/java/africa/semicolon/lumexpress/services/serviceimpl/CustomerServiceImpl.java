package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.request.EmailNotificationRequest;
import africa.semicolon.lumexpress.data.dtos.request.LoginRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.dtos.response.LoginResponse;
import africa.semicolon.lumexpress.data.models.Address;
import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.data.repositories.CustomerRepository;
import africa.semicolon.lumexpress.services.notification.EmailNotificationService;
import africa.semicolon.lumexpress.services.serviceinterface.CartService;
import africa.semicolon.lumexpress.services.serviceinterface.CustomerService;
import africa.semicolon.lumexpress.services.serviceinterface.VerificationTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CartService cartService;
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper();

    private final VerificationTokenService verificationTokenService;

    private final EmailNotificationService emailNotificationService;
    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest register) throws MessagingException {
        Customer customer = mapper.map(register, Customer.class);
        customer.setCart(new Cart());
        setCustomerAddress(register, customer);
        var savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db::{}", savedCustomer.getEmail());
        var token = verificationTokenService.createToken(savedCustomer.getEmail());
        emailNotificationService.sendHtmlMail(buildEmailNotificationRequest(token));
        System.out.println(savedCustomer);
        return registrationResponseBuilder(savedCustomer);
    }

    private EmailNotificationRequest buildEmailNotificationRequest(VerificationToken verificationToken) {
        var email = getEmailTemplate();
        String mail = null;
        if (email != null) {
            mail = String.format(email, verificationToken.getUserEmail(),
                    "http://localhost:8080/" + verificationToken.getToken());
        }
        return EmailNotificationRequest.builder()
                .userEmail(verificationToken.getUserEmail())
                .mailContent(mail)
                .build();
    }

    private String getEmailTemplate(){
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("src/main/resources/welcome.txt"))) {
            return bufferedReader.lines().collect(Collectors.joining());
        } catch (IOException err) {
            err.printStackTrace();
        }
        return null;
    }

    private void setCustomerAddress(CustomerRegistrationRequest register, Customer customer) {
        var customerAddress = new Address();
        customerAddress.setCountry(register.getCountry());
        customer.getAddresses().add(customerAddress);
    }

    private CustomerRegistrationResponse registrationResponseBuilder(Customer customer) {
        return CustomerRegistrationResponse.builder()
                .message("Welcome! Your registration is successful")
                .code(201)
                .userId(customer.getId())
                .build();
    }

    /*
    * TODO
    * 1. Register on Cloudinary
    * 2. Create a Mailjet Account
    *
    * */

    @Override
    public String completeProfile(UpdateCustomerDetails customerDetails) {
        return null;
    }

    @Override
    public int numberOfCustomers() {
        return (int) customerRepository.count();
    }
}
