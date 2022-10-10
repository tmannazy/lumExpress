package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.models.VerificationToken;

public interface VerificationTokenService {
    VerificationToken generateVerificationToken(String userEmail);
}
