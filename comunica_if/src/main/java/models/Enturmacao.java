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
    private int codTurma;
    private int codAluno;
    private int codServidor;
    private int semestre;

    public Enturmacao(int codTurma, int codAluno, int codServidor, int semestre) {
        this.codTurma = codTurma;
        this.codAluno = codAluno;
        this.codServidor = codServidor;
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

    public int getCodServidor() {
        return codServidor;
    }

    public void setCodServidor(int codServidor) {
        this.codServidor = codServidor;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
