package controller;

import daos.EnturmacaoDAO;
import models.Enturmacao;

public class EnturmacaoController {

    private final EnturmacaoDAO dao;

    public EnturmacaoController() {
        dao = new EnturmacaoDAO();
    }

    public void registrarEnturmacao(Enturmacao e) {
        dao.salvar(e);
    }

    public void atualizarEnturmacao(Enturmacao e) {
        dao.atualizar(e);
    }

    public Enturmacao buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

}
