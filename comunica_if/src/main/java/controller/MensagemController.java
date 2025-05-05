
package controller;

import daos.MensagemDAO;
import java.util.List;
import models.Mensagem;

class MensagemController {
    private MensagemDAO dao = new MensagemDAO();
    public void enviarMensagem(Mensagem m) { dao.salvar(m); }
    public List<Mensagem> listarMensagens() { return dao.listar(); }
}