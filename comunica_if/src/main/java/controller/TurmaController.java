package controller;

import daos.TurmaDAO;
import java.util.List;
import models.Aluno;
import models.Servidor;
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
    
    public void addAlunoTurma(int t, List<Aluno> a){
        dao.adicionarAlunosNaTurma(t, a);
    }
    
    public void removerAlunoTurma(Turma t, List<Aluno> a){
        dao.removerAlunosDaTurma(t.getCodigo(), a);
    }
    
    public void removerTodosAlunosTurma(Turma t){
        dao.removerTodosAlunosDaTurma(t.getCodigo());
    }
    
    public void addServidorTurma(int t, List<Servidor> s){
        dao.adicionarServidoresNaTurma(t, s);
    }
    
    public void removerServidorTurma(Turma t, List<Servidor> s){
        dao.removerServidoresDaTurma(t.getCodigo(), s);
    }
    
    public void removerTodosServidoresTurma(Turma t){
        dao.removerTodosServidoresDaTurma(t.getCodigo());
    }
    
    public List<Aluno> listarAlunos(int t){
        return dao.listarAlunosDaTurma(t);
    }
    
    public List<Servidor> listarServidores(Turma t){
        return dao.listarServidoresDaTurma(t.getCodigo());
    }
}
