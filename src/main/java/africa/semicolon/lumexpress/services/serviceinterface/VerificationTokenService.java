package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.exceptions.VerificationTokenException;

public interface VerificationTokenService {
    VerificationToken createToken(String userEmail);

    boolean isValidVerificationToken(String token) throws VerificationTokenException;

}
