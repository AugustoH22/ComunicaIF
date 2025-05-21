package models;

public class Enturmacao {
    private int codigo;
    private Turma turma;
    private Aluno aluno;
    private String ano;
    private String semestre;
    
    public Enturmacao() {

    }

    public Enturmacao(int codigo, Turma turma, Aluno aluno, String ano, String semestre) {
        this.codigo = codigo;
        this.turma = turma;
        this.aluno = aluno;
        this.ano = ano;
        this.semestre = semestre;
    }

    // Getters e Setters

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
