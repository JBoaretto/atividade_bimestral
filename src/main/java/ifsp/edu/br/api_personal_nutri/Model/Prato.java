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
    private String info;

    @OneToMany(mappedBy = "prato", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Alimento> id_alimentos;

    public Prato() {
    }

    public Prato(Long id_prato, String nome, String info, List<Alimento> id_alimentos) {
        this.id_prato = id_prato;
        this.nome = nome;
        this.info = info;
        this.id_alimentos = id_alimentos;
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
}
