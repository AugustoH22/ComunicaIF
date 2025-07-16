package controller;

import daos.CursoDAO;
import java.util.List;
import models.Curso;

public class CursoController {

    private final CursoDAO dao;

    public CursoController() {
        dao = new CursoDAO();
    }

    public void cadastrarCurso(Curso c) {
        dao.salvar(c);
    }

    // Atualizar curso existente
    public void editarCurso(Curso c) {
        dao.atualizar(c);
    }

    // Listar todos os cursos
    public List<Curso> listarCursos() {
        return dao.listar();
    }

    // Buscar um curso por código
    public Curso buscarCursoPorId(int codigo) {
        return dao.buscarPorId(codigo);
    }
    
    public void excluir(int id){
        dao.excluir(id);
    }
    
    public boolean existeTurmaVinculada(int id){
        return dao.existeTurmaVinculada(id);
    }
}
