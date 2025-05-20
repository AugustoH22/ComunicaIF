package models;

import java.util.Objects;

public class Departamento {
    
    Integer codigo;
    String nome;
    
    public Departamento(){
    }
    
    public Departamento(Integer id, String nome){
        this.codigo=codigo;
        this.nome=nome;
    }

    public Integer getId() {
        return codigo;
    }

    public void setId(Integer id) {
        this.codigo=codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento departamento)) return false;
        return Objects.equals(codigo, departamento.codigo);
    }
        @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

}
