package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Aluno {
    int codigo;
    String nome;
    List<NecessidadeEspecial> necessidades = new ArrayList<>();
    
    
    public Aluno(){   
    }
    
    public Aluno(int codigo, String nome, List<NecessidadeEspecial> necessidades){
        this.codigo = codigo;
        this.nome = nome;
        this.necessidades = necessidades;
    }

    public List<NecessidadeEspecial> getNecessidades() {
        return necessidades;
    }

    public void setNecessidades(List<NecessidadeEspecial> necessidades) {
        this.necessidades = necessidades;
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
    
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
        return Objects.equals(codigo, aluno.codigo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
}
