package ifsp.edu.br.api_personal_nutri.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import ifsp.edu.br.api_personal_nutri.Model.Prato;
import ifsp.edu.br.api_personal_nutri.Repository.PratoRespository;

@RestController
@RequestMapping("/api/personalnutri/pratos")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class PratoController {

    @Autowired
    PratoRespository pratoRespository;

    // GET: Lista de pratos
    @GetMapping
    public List<Prato> getAllPratos() {
        return StreamSupport.stream(pratoRespository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET: Recupera um prato específico por ID
    @GetMapping("/{id_prato}")
    public Prato getPratoById(@PathVariable Long id_prato) {
        return pratoRespository.findById(id_prato).orElse(null);
    }

    // POST: Cria um novo prato
    @PostMapping
    public Prato createPrato(@RequestBody Prato prato) {
        return pratoRespository.save(prato);
    }

    // PUT: Atualiza um prato existente
    @PutMapping("/{id_prato}")
    public Prato updatePrato(@PathVariable Long id_prato, @RequestBody Prato novoPrato) {
        return pratoRespository.findById(id_prato)
                .map(pratoExistente -> {
                    pratoExistente.setNome(novoPrato.getNome());
                    pratoExistente.setLipidios(novoPrato.getLipidios());
                    pratoExistente.setCalorias(novoPrato.getCalorias());
                    pratoExistente.setFibras(novoPrato.getFibras());
                    pratoExistente.setCargaGlicemica(novoPrato.getCargaGlicemica());
                    pratoExistente.setMode(novoPrato.getMode());
                    pratoExistente.setAlimentosSelecionados(novoPrato.getAlimentosSelecionados());
                    return pratoRespository.save(pratoExistente);
                })
                .orElse(null);
    }

    // DELETE: Deleta um prato
    @DeleteMapping("/{id_prato}")
    public void deletePrato(@PathVariable Long id_prato) {
        pratoRespository.deleteById(id_prato);
    }
}
