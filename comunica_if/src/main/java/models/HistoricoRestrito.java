package models;

public class HistoricoRestrito {
    private int codigo;
    private String dataHora;
    private String ocorrencia;
    private String anotacao;
    private int codAluno;
    private int codServidor;

    public HistoricoRestrito(int codigo, String dataHora, String ocorrencia, String anotacao, int codAluno, int codServidor) {
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
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
