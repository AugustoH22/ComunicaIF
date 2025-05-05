package models;

import java.util.Objects;

public class Departamento {
    
    Integer id;
    String nome;
    
    public Departamento(){
    }
    
    public Departamento(Integer id, String nome){
        this.id=id;
        this.nome=nome;
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
    
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento departamento)) return false;
        return Objects.equals(id, departamento.id);
    }
        @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
