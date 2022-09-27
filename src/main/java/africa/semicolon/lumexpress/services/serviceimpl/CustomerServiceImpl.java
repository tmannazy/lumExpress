package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.request.LoginRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.dtos.response.LoginResponse;
import africa.semicolon.lumexpress.data.models.Address;
import africa.semicolon.lumexpress.data.models.Cart;
import africa.semicolon.lumexpress.data.models.Customer;
import africa.semicolon.lumexpress.data.repositories.CustomerRepository;
import africa.semicolon.lumexpress.services.serviceinterface.CartService;
import africa.semicolon.lumexpress.services.serviceinterface.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CartService cartService;
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest register) {
        Customer customer = mapper.map(register, Customer.class);
        customer.setCart(new Cart());
        var customerAddress = new Address();
        customerAddress.setCountry(register.getCountry());
        customer.getAddresses().add(customerAddress);
        var savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db::{}", savedCustomer.getEmail());
        System.out.println(savedCustomer);
        return registrationResponseBuilder(savedCustomer);
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
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public String completeProfile(UpdateCustomerDetails customerDetails) {
        return null;
    }

    @Override
    public int numberOfCustomers() {
        return (int) customerRepository.count();
    }
}
