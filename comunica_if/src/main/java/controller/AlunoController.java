package controller;

import models.Aluno;
import daos.AlunoDAO;

import java.sql.SQLException;
import java.util.List;
import models.NecessidadeEspecial;

public class AlunoController {

    private final AlunoDAO dao;

    public AlunoController() {
        dao = new AlunoDAO();
    }

    // Cadastrar novo aluno com suas necessidades
    public int cadastrarAluno(Aluno a) {
        try {
            return dao.salvar(a);
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
        return 0;
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
}
