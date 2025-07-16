package controller;

import daos.NecessidadeEspecialDAO;
import java.util.List;
import models.NecessidadeEspecial;

public class NecessidadeEspecialController {

    private final NecessidadeEspecialDAO dao;

    public NecessidadeEspecialController() {
        dao = new NecessidadeEspecialDAO();
    }

    // Cadastrar nova necessidade especial
    public void cadastrarNecessidade(NecessidadeEspecial n) {
        dao.salvar(n);
    }

    // Atualizar uma necessidade existente
    public void atualizarNecessidade(NecessidadeEspecial n) {
        dao.atualizar(n);
    }

    // Listar todas as necessidades especiais
    public List<NecessidadeEspecial> listarNecessidades() {
        return dao.listar();
    }

    // Buscar necessidade especial por ID
    public NecessidadeEspecial buscarPorId(int id) {
        return dao.buscarPorId(id);
    }
    
    public void excluir(int id){
        dao.excluir(id);
    }
    
}
