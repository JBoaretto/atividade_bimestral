package ifsp.edu.br.api_personal_nutri.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @SuppressWarnings("unchecked")
    public String uploadImage(MultipartFile file) throws IOException {
        Map<String, Object> uploadResult = (Map<String, Object>) cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("resource_type", "auto"));
        return uploadResult.get("url").toString(); // Retorna a URL da imagem armazenada
    }
}
