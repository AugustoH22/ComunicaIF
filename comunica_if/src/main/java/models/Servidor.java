package models;

import java.util.Objects;

public class Servidor {
    
    int codigo;
    String nome;
    Departamento departamento;
    Permissao permissao;
    
    public Servidor(){
    }
    
    public Servidor(int codigo, String nome, Departamento departamento, Permissao permissao){
        this.codigo = codigo;
        this.nome = nome;
        this.departamento = departamento;
        this.permissao = permissao;
    }

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servidor servidor)) return false;
        return Objects.equals(codigo, servidor.codigo);
    }
}
