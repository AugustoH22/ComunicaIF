package models;

import java.time.LocalDateTime;

public class HistoricoRestrito {
    private int codigo;
    private LocalDateTime dataHora;
    private String ocorrencia;
    private String anotacao;
    private int codAluno;
    private int codServidor;

    public HistoricoRestrito(int codigo, LocalDateTime dataHora, String ocorrencia, String anotacao, int codAluno, int codServidor) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.ocorrencia = ocorrencia;
        this.anotacao = anotacao;
        this.codAluno = codAluno;
        this.codServidor = codServidor;
    }

    // Getters e Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
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
}
