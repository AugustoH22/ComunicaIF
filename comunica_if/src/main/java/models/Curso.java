package models;

public class Curso {

    private int codigo;
    private String nome;
    private boolean superior;

    public Curso() {
    }

    public Curso(int codigo, String nome, boolean superior) {
        this.codigo = codigo;
        this.nome = nome;
        this.superior = superior;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSuperior() {
        return superior;
    }

    public void setSuperior(boolean superior) {
        this.superior = superior;
    }
}
