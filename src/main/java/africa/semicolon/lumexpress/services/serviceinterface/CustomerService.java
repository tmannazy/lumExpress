package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.lumexpress.data.dtos.request.LoginRequest;
import africa.semicolon.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.lumexpress.data.dtos.response.LoginResponse;

import javax.mail.MessagingException;


public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest register) throws MessagingException;

    String completeProfile(UpdateCustomerDetails updateCustomerDetails);

    int numberOfCustomers();
}
