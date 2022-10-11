package africa.semicolon.lumexpress.services.serviceimpl;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.exceptions.VerificationTokenException;
import africa.semicolon.lumexpress.services.serviceinterface.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class VerificationTokenServiceImplTest {

    @Autowired
    private VerificationTokenService tokenService;
    private VerificationToken verificationToken;

    @BeforeEach
    void setUp() {
        verificationToken = tokenService.createToken("test@email.com");
    }

    @Test
    void createTokenTest() {
        assertThat(verificationToken).isNotNull();
        assertThat(verificationToken.getToken().length()).isEqualTo(5);
        log.info("token generated>>> {}", verificationToken);
    }

    @Test
    void isValidVerificationTokenTest() throws VerificationTokenException {
        var response = tokenService.isValidVerificationToken(verificationToken.getToken());
        assertThat(verificationToken).isNotNull();
        assertThat(response).isTrue();
    }
}