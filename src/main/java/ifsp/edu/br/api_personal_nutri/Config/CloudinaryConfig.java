package ifsp.edu.br.api_personal_nutri.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; // Certifique-se de que esta anotação está presente
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils; // Corrija a importação para usar o pacote correto

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dpcnndbhn",
                "api_key", "592346614122269",
                "api_secret", "4BNvlWNZaicE9uANEJo2yQEidn0"));
    }
}
