package africa.semicolon.lumexpress.data.repositories;

import africa.semicolon.lumexpress.data.models.VerificationToken;
import africa.semicolon.lumexpress.exceptions.VerificationTokenException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class VerificationTokenRepositoryTest {
    @Autowired
    private VerificationTokenRepository tokenRepository;

    private VerificationToken verificationToken;

    @BeforeEach
    void setUp() {
        verificationToken = VerificationToken.builder()
                .token("12345")
                .userEmail("test@email.com")
                .build();
    }

    @Test
    void findByUserEmailTest() throws VerificationTokenException {
        tokenRepository.save(verificationToken);
        var foundToken = tokenRepository.findByUserEmail("test@email.com")
                     .orElseThrow(() -> new VerificationTokenException("token not found"));
        log.info("found token::: {}", foundToken);
        assertThat(foundToken).isNotNull();
        assertThat(foundToken.getToken())
                .isEqualTo(verificationToken.getToken());
    }

    @Test
    void findByTokenTest() {
    }
}