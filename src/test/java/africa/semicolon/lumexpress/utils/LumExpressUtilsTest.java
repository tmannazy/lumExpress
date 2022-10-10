package africa.semicolon.lumexpress.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LumExpressUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateTokenTest() {
        String token = LumExpressUtils.generateToken();
        log.info("token>>> {}", token);
        assertThat(token).isNotNull();
        assertThat(token.length()).isEqualTo(5);
    }
}