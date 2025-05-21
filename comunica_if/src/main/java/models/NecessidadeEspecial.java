/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author augustobraga
 */
public class NecessidadeEspecial {
    private int codigo;
    private String codigoNecessidade;
    private String descricao;
    
    public NecessidadeEspecial() {
        
    }

    public NecessidadeEspecial(int codigo, String codigoNecessidade, String descricao) {
        this.codigo = codigo;
        this.codigoNecessidade = codigoNecessidade;
        this.descricao = descricao;
    }

    // Getters e Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigoNecessidade() {
        return codigoNecessidade;
    }

    public void setCodigoNecessidade(String codigoNecessidade) {
        this.codigoNecessidade = codigoNecessidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
