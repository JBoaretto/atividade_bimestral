package ifsp.edu.br.api_personal_nutri.Model;

public class Alimento {
    private int id_alimento;
    private String nome;
    private double lipidios;
    private double calorias;
    private double fibras;
    private int carga_glicemica;

    public Alimento(){

    }

    public Alimento(int id_alimento, String nome, double lipidios, double calorias, double fibras, int carga_glicemica) {
        this.id_alimento = id_alimento;
        this.nome = nome;
        this.lipidios = lipidios;
        this.calorias = calorias;
        this.fibras = fibras;
        this.carga_glicemica = carga_glicemica;
    }

    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
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

    public int getCarga_glicemica() {
        return carga_glicemica;
    }

    public void setCarga_glicemica(int carga_glicemica) {
        this.carga_glicemica = carga_glicemica;
    }

    

}
