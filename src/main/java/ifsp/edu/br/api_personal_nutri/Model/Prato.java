package ifsp.edu.br.api_personal_nutri.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prato;
    private String nome;
    private String info; // ????????????????
    private String recomendacaoSaudavel;
    private String imagemUrl;
    private Boolean mode;

    @OneToMany(mappedBy = "prato", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Alimento> id_alimentos;

    public Prato() {
    }

    public Prato(Long id_prato, String nome, String info, String recomendacaoSaudavel, String imagemUrl,
            List<Alimento> id_alimentos, Boolean mode) {
        this.id_prato = id_prato;
        this.nome = nome;
        this.info = info;
        this.recomendacaoSaudavel = recomendacaoSaudavel;
        this.imagemUrl = imagemUrl;
        this.id_alimentos = id_alimentos;
        this.mode = mode;
    }

    public Long getId_prato() {
        return id_prato;
    }

    public void setId_prato(Long id_prato) {
        this.id_prato = id_prato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Alimento> getId_alimentos() {
        return id_alimentos;
    }

    public void setId_alimentos(List<Alimento> id_alimentos) {
        this.id_alimentos = id_alimentos;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getRecomendacaoSaudavel() {
        return recomendacaoSaudavel;
    }

    public void setRecomendacaoSaudavel(String recomendacaoSaudavel) {
        this.recomendacaoSaudavel = recomendacaoSaudavel;
    }

    public Boolean getMode() {
        return mode;
    }

    public void setMode(Boolean mode) {
        this.mode = mode;
    }

}
