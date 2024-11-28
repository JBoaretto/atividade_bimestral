package ifsp.edu.br.api_personal_nutri.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alimento;
    private String nome;
    private double lipidios;
    private double calorias;
    private double fibras;
    private int cargaGlicemica;
    private String recomendacaoSaudavel;
    private String imagemUrl;
    private Boolean mode;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "prato_fk")
    private Prato prato;

    public Alimento() {
    }

    public Alimento(Long id_alimento, String nome, double lipidios, double calorias, double fibras, int cargaGlicemica,
            String recomendacaoSaudavel, String imagemUrl, Boolean mode) {
        this.id_alimento = id_alimento;
        this.nome = nome;
        this.lipidios = lipidios;
        this.calorias = calorias;
        this.fibras = fibras;
        this.cargaGlicemica = cargaGlicemica;
        this.recomendacaoSaudavel = recomendacaoSaudavel;
        this.imagemUrl = imagemUrl;
        this.mode = mode;
    }

    public Long getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(Long id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLipidios() {
        return lipidios;
    }

    public void setLipidios(double lipidios) {
        this.lipidios = lipidios;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getFibras() {
        return fibras;
    }

    public void setFibras(double fibras) {
        this.fibras = fibras;
    }

    public int getCargaGlicemica() {
        return cargaGlicemica;
    }

    public void setCargaGlicemica(int cargaGlicemica) {
        this.cargaGlicemica = cargaGlicemica;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
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
