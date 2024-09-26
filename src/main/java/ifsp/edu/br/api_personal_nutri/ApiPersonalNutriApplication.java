package ifsp.edu.br.api_personal_nutri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiPersonalNutriApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPersonalNutriApplication.class, args);

		// Nessa branch, trabalharemos o JPA
		System.out.println("Teste");
	}

}
