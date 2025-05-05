package models;

import java.util.Objects;


public class Aluno {
    Integer id;
    String nome;
    
    
    public Aluno(){   
    }
    
    public Aluno(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return id;
    }

    public void setCodigo(Integer codigo) {
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
        if (!(o instanceof Aluno aluno)) return false;
        return Objects.equals(id, aluno.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
