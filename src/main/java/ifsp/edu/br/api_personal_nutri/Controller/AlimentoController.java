package ifsp.edu.br.api_personal_nutri.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import ifsp.edu.br.api_personal_nutri.Model.Alimento;
import ifsp.edu.br.api_personal_nutri.Repository.AlimentoRepository;
import ifsp.edu.br.api_personal_nutri.Service.CloudinaryService;

@RestController
@RequestMapping("/api/personalnutri/alimentos")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class AlimentoController {
    @Autowired
    AlimentoRepository alimentoRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    // GET: Lista todos os alimentos do banco de dados
    @GetMapping
    public ResponseEntity<List<Alimento>> getAllAlimentos() {

        List<Alimento> alimentos = StreamSupport.stream(alimentoRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
        return alimentos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(alimentos);
    } // Converter Iterable<Alimento> para List<Alimento>

    // GET: Recupera um alimento específico por ID
    @GetMapping("/{id_alimento}")
    public ResponseEntity<Alimento> getAlimentoById(@PathVariable Long id_alimento) {
        return alimentoRepository.findById(id_alimento)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Cria um novo alimento no banco de dados
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Alimento> createAlimento(
            @RequestPart("nome") String nome,
            @RequestPart("lipidios") double lipidios,
            @RequestPart("calorias") double calorias,
            @RequestPart("fibras") double fibras,
            @RequestPart("carga_glicemica") int cargaGlicemica,
            @RequestPart(value = "recomendacaoSaudavel", required = false) String recomendacaoSaudavel,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem) {

        try {
            if (nome == null || nome.isEmpty() || lipidios < 0 || calorias < 0 || fibras < 0 || cargaGlicemica < 0) {
                return ResponseEntity.badRequest().body(null);
            }

            // Criação do objeto Alimento
            Alimento alimento = new Alimento();
            alimento.setNome(nome);
            alimento.setLipidios(lipidios);
            alimento.setCalorias(calorias);
            alimento.setFibras(fibras);
            alimento.setCarga_glicemica(cargaGlicemica);
            alimento.setRecomendacaoSaudavel(recomendacaoSaudavel);

            // Upload da imagem para o Cloudinary (se presente)
            if (imagem != null && !imagem.isEmpty()) {
                try {
                    String imageUrl = cloudinaryService.uploadImage(imagem);
                    alimento.setCaminhoImagem(imageUrl);
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                }
            }

            // Salva o alimento no banco de dados
            Alimento alimentoSalvo = alimentoRepository.save(alimento);
            return ResponseEntity.status(HttpStatus.CREATED).body(alimentoSalvo); // 201 OK

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // PUT: Atualiza um alimento existente no banco de dados
    @PutMapping("/{id_alimento}")
    public ResponseEntity<Alimento> updateAlimento(@PathVariable Long id_alimento, @RequestBody Alimento novoAlimento) {
        return alimentoRepository.findById(id_alimento).map(alimentoExistente -> {
            alimentoExistente.setNome(novoAlimento.getNome());
            alimentoExistente.setLipidios(novoAlimento.getLipidios());
            alimentoExistente.setCalorias(novoAlimento.getCalorias());
            alimentoExistente.setFibras(novoAlimento.getFibras());
            alimentoExistente.setCarga_glicemica(novoAlimento.getCarga_glicemica());
            Alimento alimentoAtualizado = alimentoRepository.save(alimentoExistente);
            return ResponseEntity.ok(alimentoAtualizado); // 200 OK
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Deleta um alimento específico no banco de dados
    @DeleteMapping("/{id_alimento}")
    public void deleteAlimento(@PathVariable Long id_alimento) {
        alimentoRepository.deleteById(id_alimento);
    }
}
