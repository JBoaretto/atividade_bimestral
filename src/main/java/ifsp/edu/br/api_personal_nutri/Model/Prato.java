package ifsp.edu.br.api_personal_nutri.Model;

import java.util.List;

public class Prato {
    private int id_prato;
    private String nome;
    private String info;
    private List<Integer> id_alimentos;

    public Prato() {
    }

    public Prato(int id_prato, String nome, String info, List<Integer> id_alimentos) {
        this.id_prato = id_prato;
        this.nome = nome;
        this.info = info;
        this.id_alimentos = id_alimentos;
    }

    public int getId_prato() {
        return id_prato;
    }

    public void setId_prato(int id_prato) {
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

    public List<Integer> getId_alimentos() {
        return id_alimentos;
    }

    public void setId_alimentos(List<Integer> id_alimentos) {
        this.id_alimentos = id_alimentos;
    }
}
