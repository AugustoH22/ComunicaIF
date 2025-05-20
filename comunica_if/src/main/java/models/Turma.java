package models;

import java.util.Objects;

public class Turma {
    
    int id;
    String nome;
    Curso curso;
    String ano;
    String semestre;

    
    public Turma(){ 
    }
    
    public Turma(int id, String nome, Curso curso, String ano, String semestre){
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.ano = ano;
        this.semestre = semestre;
        
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getId() {
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
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma turma)) return false;
        return Objects.equals(id, turma.id);
    }  
}
