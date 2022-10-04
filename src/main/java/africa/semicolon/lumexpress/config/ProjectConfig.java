package africa.semicolon.lumexpress.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Value("${cloudinary.cloud_name}")
    private String CLOUD_NAME;
    @Value("${cloudinary.api_key}")
    private String API_KEY;
    @Value("${cloudinary.api_secret}")
    private String API_SECRET;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", CLOUD_NAME,
                        "api_key", API_KEY,
                        "api_secret", API_SECRET,
                        "secure", true));
    }
}
