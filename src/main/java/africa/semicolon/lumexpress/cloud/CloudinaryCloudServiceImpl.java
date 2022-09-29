package africa.semicolon.lumexpress.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
@Primary
@AllArgsConstructor
//@NoArgsConstructor
public class CloudinaryCloudServiceImpl implements CloudService{
//    @Value("${cloudinary.cloud.name}")
//    private String CLOUD_NAME;
//    @Value("${cloudinary.api.key}")
//    private String API_KEY;
//    @Value("${cloudinary.api.secret}")
//    private String API_SECRET;
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name","dtuaqn9i5",
            "api_key", "511864444268847",
            "api_secret", "4UArLBr2t-S9e2RrxO4MEf0H_2w",
            "secure", true));

    @Override
    public String upload(byte[] imageBytes, Map<?, ?> map) throws IOException {
        var uploadResponse = cloudinary.uploader()
                .upload(imageBytes, ObjectUtils.emptyMap());
        return uploadResponse.get("url").toString();
    }
}
