package ifsp.edu.br.api_personal_nutri.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import ifsp.edu.br.api_personal_nutri.Model.Prato;
import ifsp.edu.br.api_personal_nutri.Repository.PratoRespository;

@RestController
@RequestMapping("/api/personalnutri/pratos")
public class PratoController {
    @Autowired
    PratoRespository pratoRespository;

    // Lista fictícia de pratos para simular o banco de dados
    private List<Prato> listaPratos = new ArrayList<>();

    // GET: Lista de pratos
    @GetMapping
    public List<Prato> getAllPratos() {
        return listaPratos;
    }

    // GET: Recupera um prato específico por ID
    @GetMapping("/{id_prato}")
    public Prato getPratoById(@PathVariable int id_prato) {
        return listaPratos.stream()
                .filter(prato -> prato.getId_prato() == id_prato)
                .findFirst()
                .orElse(null);
    }

    // POST: Cria um novo prato
    @PostMapping
    public Prato createPrato(@RequestBody Prato prato) {
        listaPratos.add(prato);
        return prato;
    }

    // PUT: Atualiza um prato existente
    @PutMapping("/{id_prato}")
    public Prato updatePrato(@PathVariable int id_prato, @RequestBody Prato novoPrato) {
        Prato pratoExistente = listaPratos.stream()
                .filter(prato -> prato.getId_prato() == id_prato)
                .findFirst()
                .orElse(null);

        if (pratoExistente != null) {
            pratoExistente.setNome(novoPrato.getNome());
            pratoExistente.setInfo(novoPrato.getInfo());
            pratoExistente.setId_alimentos(novoPrato.getId_alimentos());
        }
        return pratoExistente;
    }

    // DELETE: Deleta um prato
    @DeleteMapping("/{id_prato}")
    public void deletePrato(@PathVariable int id_prato) {
        listaPratos.removeIf(prato -> prato.getId_prato() == id_prato);
    }
}
