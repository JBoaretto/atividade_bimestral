package ifsp.edu.br.api_personal_nutri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiPersonalNutriApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPersonalNutriApplication.class, args);

		// Nessa branch, trabalharemos o JPA
		System.out.println("Teste");
	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("http://localhost:5173");
		}
	}
}