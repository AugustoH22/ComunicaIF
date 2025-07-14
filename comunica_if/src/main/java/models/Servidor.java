package models;

import java.util.Objects;

public class Servidor {
    
    int codigo;
    String nome;
    String usuario;
    String senha;
    Departamento departamento;
    Permissao permissao;
    boolean primeiroLogin;
    
    public Servidor(){
    }
    
    public Servidor(int codigo, String nome, String usuario, String senha, Departamento departamento, Permissao permissao, boolean primeiroLogin){
        this.codigo = codigo;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.departamento = departamento;
        this.permissao = permissao;
        this.primeiroLogin = primeiroLogin;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public boolean isPrimeiroLogin() {
        return primeiroLogin;
    }

    public void setPrimeiroLogin(boolean primeiroLogin) {
        this.primeiroLogin = primeiroLogin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servidor servidor)) return false;
        return Objects.equals(codigo, servidor.codigo);
    }
    
    @Override
    public String toString() {
        return this.getUsuario();
    }
}
