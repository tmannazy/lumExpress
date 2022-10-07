package africa.semicolon.lumexpress.cloud;

import africa.semicolon.lumexpress.services.cloud.CloudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CloudinaryCloudServiceImplTest {

    @Autowired
    private CloudService cloudService;

    private MultipartFile file;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("src/main/resources/img/danoMilk.jpg");
        file = new MockMultipartFile("Dano Milk", Files.readAllBytes(path));
    }

    @Test
    @DisplayName("cloudinary upload test")
    void uploadTest() throws IOException {
        try {
            String res = cloudService.upload(file.getBytes(), null);
            assertThat(res).isNotNull();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}