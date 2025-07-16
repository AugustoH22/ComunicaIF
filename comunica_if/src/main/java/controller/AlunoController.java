package controller;

import models.Aluno;
import daos.AlunoDAO;

import java.util.List;
import models.NecessidadeEspecial;

public class AlunoController {

    private final AlunoDAO dao;

    public AlunoController() {
        dao = new AlunoDAO();
    }

    // Cadastrar novo aluno com suas necessidades
    public void cadastrarAluno(Aluno a) {
        dao.salvar(a);
    }

    // Atualizar aluno e suas necessidades
    public void atualizarAluno(Aluno a) {
        dao.atualizar(a);
    }

    // Listar todos os alunos
    public List<Aluno> listarAlunos() {
        return dao.listar();
    }

    // Buscar aluno por ID
    public Aluno buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    // Buscar somente as necessidades de um aluno
    public List<NecessidadeEspecial> buscarNecessidadesDoAluno(int alunoId) {
        return dao.buscarNecessidadesDoAluno(alunoId);
    }
    
    public List<Aluno> listarAlunosSemTurma() {
        return dao.listarAlunosSemTurma();
    }
    
    public void desativarAluno(int a) {
        dao.desativar(a);
    }

}
