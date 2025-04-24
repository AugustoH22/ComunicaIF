/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Objects;

/**
 *
 * @author pedro
 */
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
