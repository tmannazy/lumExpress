package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.request.LoginRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.dtos.response.LoginResponse;
import africa.semicolon.lumexpress.data.repositories.CustomerRepository;
import africa.semicolon.lumexpress.services.serviceinterface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest register) {
        return null;
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
}
