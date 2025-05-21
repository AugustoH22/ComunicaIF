package models;

import java.util.Objects;

public class Turma {
    
    int codigo;
    String nome;
    Curso curso;
    String ano;
    String semestre;

    
    public Turma(){ 
    }
    
    public Turma(int codigo, String nome, Curso curso, String ano, String semestre){
        this.codigo = codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
        return Objects.hashCode(codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma turma)) return false;
        return Objects.equals(codigo, turma.codigo);
    }  
}
