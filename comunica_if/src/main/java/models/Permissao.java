package models;

public class Permissao {
    private int codigo;
    private String descricao;

    public Permissao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    // Getters e Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return this.getDescricao();
    }
    
}
