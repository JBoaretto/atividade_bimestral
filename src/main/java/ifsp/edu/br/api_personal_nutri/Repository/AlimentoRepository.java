package ifsp.edu.br.api_personal_nutri.Repository;

import org.springframework.data.repository.CrudRepository;

import ifsp.edu.br.api_personal_nutri.Model.Alimento;

public interface AlimentoRepository extends CrudRepository<Alimento, Long>{
    // Pegar o nome e a imagem de certo alimento para mostrar na tela inicial do app
}
