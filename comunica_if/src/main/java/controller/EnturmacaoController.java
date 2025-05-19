package controller;

import daos.EnturmacaoDAO;
import java.util.List;
import models.Enturmacao;

public class EnturmacaoController {

    private final EnturmacaoDAO dao = new EnturmacaoDAO();

    public void registrarEnturmacao(Enturmacao e) {
        dao.salvar(e);
    }
    
}
