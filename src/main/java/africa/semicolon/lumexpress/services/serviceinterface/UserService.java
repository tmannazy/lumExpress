package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.LoginRequest;
import africa.semicolon.lumexpress.data.dtos.response.LoginResponse;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);

}
