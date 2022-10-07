package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.services.serviceinterface.VerificationTokenService;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {
    @Override
    public VerificationToken generateToken() {
        return null;
    }
}
