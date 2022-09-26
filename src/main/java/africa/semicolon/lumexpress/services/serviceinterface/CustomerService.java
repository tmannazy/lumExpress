package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.request.LoginRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.dtos.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest register);

    LoginResponse login(LoginRequest loginRequest);

    String completeProfile(UpdateCustomerDetails updateCustomerDetails);
}
