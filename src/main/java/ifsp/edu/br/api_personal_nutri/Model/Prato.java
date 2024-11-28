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
    // private String info;
    private double lipidios;
    private double calorias;
    private double fibras;
    private double cargaGlicemica;
    private String recomendacaoSaudavel;
    private String imagemUrl;
    private Boolean mode;

    @OneToMany(mappedBy = "prato", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Alimento> alimentosSelecionados;

    public Prato() {
    }

    
    public Prato(Long id_prato, String nome, double lipidios, double calorias, double fibras, double cargaGlicemica,
            String recomendacaoSaudavel, String imagemUrl, Boolean mode, List<Alimento> alimentosSelecionados) {
        this.id_prato = id_prato;
        this.nome = nome;
        this.lipidios = lipidios;
        this.calorias = calorias;
        this.fibras = fibras;
        this.cargaGlicemica = cargaGlicemica;
        this.recomendacaoSaudavel = recomendacaoSaudavel;
        this.imagemUrl = imagemUrl;
        this.mode = mode;
        this.alimentosSelecionados = alimentosSelecionados;
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


    public double getCargaGlicemica() {
        return cargaGlicemica;
    }


    public void setCargaGlicemica(double cargaGlicemica) {
        this.cargaGlicemica = cargaGlicemica;
    }


    public List<Alimento> getAlimentosSelecionados() {
        return alimentosSelecionados;
    }

    public void setAlimentosSelecionados(List<Alimento> alimentosSelecionados) {
        this.alimentosSelecionados = alimentosSelecionados;
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


    // public List<Integer> getIdAlimentos() {
    //     return idAlimentos;
    // }


    // public void setIdAlimentos(List<Integer> idAlimentos) {
    //     this.idAlimentos = idAlimentos;
    // }
    

}
