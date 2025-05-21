package controller;

import daos.TurmaDAO;
import java.util.List;
import models.Turma;

public class TurmaController {

    private final TurmaDAO dao;

    public TurmaController() {
        dao = new TurmaDAO();
    }

    // Cadastrar nova turma
    public void cadastrarTurma(Turma t) {
        dao.salvar(t);
    }

    // Atualizar turma existente
    public void atualizarTurma(Turma t) {
        dao.atualizar(t);
    }

    // Listar todas as turmas
    public List<Turma> listarTurmas() {
        return dao.listar();
    }

    // Buscar turma por ID
    public Turma buscarTurmaPorId(int id) {
        return dao.buscarPorId(id);
    }
}
