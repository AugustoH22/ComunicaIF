package controller;

import daos.EnturmacaoDAO;
import java.util.List;
import models.Enturmacao;

public class EnturmacaoController {

    private EnturmacaoDAO dao = new EnturmacaoDAO();

    public void registrarEnturmacao(Enturmacao e) {
        dao.salvar(e);
    }

    public List<Enturmacao> listarEnturmacoes() {
        return dao.listar();
    }
    
    public Enturmacao buscarEnturmacaoPorId(int id) {
        Enturmacao item = dao.getItemById(id);
        return item;
    }
}
