package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class  Mensagem implements Serializable{

    private int codigo;
    private String assunto;
    private String texto;
    private Servidor remetente;
    private List<Servidor> destinatarios = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private LocalDate dataHoraCriacao;

    public Mensagem(int codigo, String texto, String assunto, Servidor remetente, List<Servidor> destinatarios, List<Aluno> alunos, LocalDate dataHora) {
        this.codigo = codigo;
        this.texto = texto;
        this.assunto = assunto;
        this.remetente = remetente;
        this.destinatarios = destinatarios;
        this.alunos = alunos;
        this.dataHoraCriacao = dataHora;
    }
    
    public Mensagem(){
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAssunto(String assunto){
        this.assunto = assunto;
    }

    public String getAssunto() {
        return assunto;
    }

    public Servidor getRemetente() {
        return remetente;
    }

    public void setRemetente(Servidor remetente) {
        this.remetente = remetente;
    }

    public List<Servidor> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<Servidor> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public LocalDate getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDate dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

}
