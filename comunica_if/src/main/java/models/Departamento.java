package models;

import java.util.Objects;

public class Departamento {

    int codigo;
    String nome;

    public Departamento() {
    }

    public Departamento(int id, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof Departamento departamento)) {
            return false;
        }
        return Objects.equals(codigo, departamento.codigo);
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
