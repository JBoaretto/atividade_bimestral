package ifsp.edu.br.api_personal_nutri.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import ifsp.edu.br.api_personal_nutri.Model.Alimento;
import ifsp.edu.br.api_personal_nutri.Repository.AlimentoRepository;

@RestController
@RequestMapping("/api/personalnutri/alimentos")
public class AlimentoController {
    @Autowired
    AlimentoRepository alimentoRepository;

    // GET: Lista todos os alimentos do banco de dados
    @GetMapping
    public List<Alimento> getAllAlimentos() {
        return StreamSupport.stream(alimentoRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    } // Converter Iterable<Alimento> para List<Alimento>

    // GET: Recupera um alimento específico por ID
    @GetMapping("/{id_alimento}")
    public Alimento getAlimentoById(@PathVariable Long id_alimento) {
        return alimentoRepository.findById(id_alimento).orElse(null);
    }

    // POST: Cria um novo alimento no banco de dados
    @PostMapping
    public Alimento createAlimento(@RequestBody Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    // PUT: Atualiza um alimento existente no banco de dados
    @PutMapping("/{id_alimento}")
    public Alimento updateAlimento(@PathVariable Long id_alimento, @RequestBody Alimento novoAlimento) {
        return alimentoRepository.findById(id_alimento).map(alimentoExistente -> {
            alimentoExistente.setNome(novoAlimento.getNome());
            alimentoExistente.setLipidios(novoAlimento.getLipidios());
            alimentoExistente.setCalorias(novoAlimento.getCalorias());
            alimentoExistente.setFibras(novoAlimento.getFibras());
            alimentoExistente.setCarga_glicemica(novoAlimento.getCarga_glicemica());
            return alimentoRepository.save(alimentoExistente);
        }).orElse(null);
    }

    // DELETE: Deleta um alimento específico no banco de dados
    @DeleteMapping("/{id_alimento}")
    public void deleteAlimento(@PathVariable Long id_alimento) {
        alimentoRepository.deleteById(id_alimento);
    }
}
