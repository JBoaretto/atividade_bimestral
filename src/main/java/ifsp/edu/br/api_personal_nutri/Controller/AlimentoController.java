package ifsp.edu.br.api_personal_nutri.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import ifsp.edu.br.api_personal_nutri.Model.Alimento;

@RestController
@RequestMapping("/api/personalnutri/alimentos")
public class AlimentoController {

    // Lista fictícia de alimentos para simular o banco de dados
    private List<Alimento> listaAlimentos = new ArrayList<>();

    // GET: Lista de alimentos
    @GetMapping
    public List<Alimento> getTodosAlimentos() {
        return listaAlimentos;
    }

    // GET: Recupera um alimento específico por ID
    @GetMapping("/{id_alimento}")
    public Alimento getAlimentoById(@PathVariable int id_alimento) {
        return listaAlimentos.stream()
                .filter(alimento -> alimento.getId_alimento() == id_alimento)
                .findFirst()
                .orElse(null);
    }

    // POST: Cria um novo alimento
    @PostMapping
    public Alimento createAlimento(@RequestBody Alimento alimento) {
        listaAlimentos.add(alimento);
        return alimento;
    }

    // PUT: Atualiza um alimento existente
    @PutMapping("/{id_alimento}")
    public Alimento updateAlimento(@PathVariable int id_alimento, @RequestBody Alimento novoAlimento) {
        Alimento alimentoExistente = listaAlimentos.stream()
                .filter(alimento -> alimento.getId_alimento() == id_alimento)
                .findFirst()
                .orElse(null);

        if (alimentoExistente != null) {
            alimentoExistente.setNome(novoAlimento.getNome());
            alimentoExistente.setLipidios(novoAlimento.getLipidios());
            alimentoExistente.setCalorias(novoAlimento.getCalorias());
            alimentoExistente.setFibras(novoAlimento.getFibras());
            alimentoExistente.setCarga_glicemica(novoAlimento.getCarga_glicemica());
        }
        return alimentoExistente;
    }

    // DELETE: Deleta um alimento
    @DeleteMapping("/{id_alimento}")
    public void deleteAlimento(@PathVariable int id_alimento) {
        listaAlimentos.removeIf(alimento -> alimento.getId_alimento() == id_alimento);
    }
}
