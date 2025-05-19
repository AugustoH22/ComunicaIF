/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author augustobraga
 */
public class Enturmacao {
    private int codigo;
    private int codTurma;
    private int codAluno;
    private String ano;
    private String semestre;

    public Enturmacao(int codigo, int codTurma, int codAluno, String ano, String semestre) {
        this.codigo = codigo;
        this.codTurma = codTurma;
        this.codAluno = codAluno;
        this.ano = ano;
        this.semestre = semestre;
    }

    // Getters e Setters

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

}
