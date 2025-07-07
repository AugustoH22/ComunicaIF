package controller;

import daos.MensagemDAO;
import java.util.List;
import models.Mensagem;
import models.Servidor;

public class MensagemController {

    private final MensagemDAO dao;

    public MensagemController() {
        dao = new MensagemDAO();
    }

    // Enviar nova mensagem
    public void enviarMensagem(Mensagem m) {
        dao.salvar(m);
    }
    
    // Listar todas as mensagens
    public List<Mensagem> listarMensagens() {
        return dao.listar();
    }

    // Buscar mensagem por ID
    public Mensagem buscarMensagemPorId(int id) {
        return dao.buscarPorId(id);
    }
    
    public List<Mensagem> buscarMensagemPorDestinatario(Servidor s){
        return dao.procurarPorDestinatario(s);
    }
}
