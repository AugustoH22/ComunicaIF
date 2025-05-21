package controller;

import java.util.List;
import models.Permissao;
import daos.PermissaoDAO;

public class PermissaoController {

    private final PermissaoDAO dao;

    public PermissaoController() {
        dao = new PermissaoDAO();
    }

    // Cadastrar nova permissão
    public void cadastrarPermissao(Permissao p) {
        dao.salvar(p);
    }

    // Atualizar permissão existente
    public void atualizarPermissao(Permissao p) {
        dao.atualizar(p);
    }

    // Listar todas as permissões
    public List<Permissao> listarPermissoes() {
        return dao.listar();
    }

    // Buscar permissão por ID
    public Permissao buscarPermissaoPorId(int id) {
        return dao.buscarPorId(id);
    }
}
