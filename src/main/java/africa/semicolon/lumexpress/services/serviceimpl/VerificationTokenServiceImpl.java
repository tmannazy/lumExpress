package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.services.serviceinterface.VerificationTokenService;
import africa.semicolon.lumexpress.utils.LumExpressUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {
    @Override
    public VerificationToken generateVerificationToken(String userEmail) {
        String tokenString = LumExpressUtils.generateToken();
        return VerificationToken.builder()
                .userEmail(userEmail)
                .token(tokenString)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(5))

                .build();
    }
}
