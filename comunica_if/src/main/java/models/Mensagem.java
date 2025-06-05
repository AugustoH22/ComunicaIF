package models;

import java.io.Serializable;

public class  Mensagem implements Serializable{

    private int codigo;
    private String titulo;
    private String texto;
    private int codServidorRemetente;
    private int codServidorDestinatario;
    private String dataHoraCriacao;

    public Mensagem(int codigo, String titulo, String texto, int remetente, int destinatario, String dataHora) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.texto = texto;
        this.codServidorRemetente = remetente;
        this.codServidorDestinatario = destinatario;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCodServidorRemetente() {
        return codServidorRemetente;
    }

    public void setCodServidorRemetente() {
        this.codServidorRemetente = codServidorRemetente;
    }

    public int getCodServidorDestinatario() {
        return codServidorDestinatario;
    }

    public void setCodServidorDestinatario() {
        this.codServidorDestinatario = codServidorDestinatario;
    }

    public String getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(String dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public void setCodServidorDestinatario(int codDestinatario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
