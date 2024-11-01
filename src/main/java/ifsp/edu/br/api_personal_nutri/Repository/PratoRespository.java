package ifsp.edu.br.api_personal_nutri.Repository;

import org.springframework.data.repository.CrudRepository;

import ifsp.edu.br.api_personal_nutri.Model.Prato;

public interface PratoRespository extends CrudRepository<Prato, Long>{
    // Pegar o nome e a imagem de certo alimento para mostrar na tela inicial do app
}
