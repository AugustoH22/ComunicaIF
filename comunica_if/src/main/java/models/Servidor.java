package models;

import java.util.Objects;

public class Servidor {
    
    Integer id;
    String nome;
    Departamento departamento;
    Permissao permissao;
    
    public Servidor(){
    }
    
    public Servidor(Integer id, String nome, Departamento departamento, Permissao permissao){
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.permissao = permissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servidor servidor)) return false;
        return Objects.equals(id, servidor.id);
    }
}
