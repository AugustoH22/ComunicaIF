package controller;

import daos.ServidorDAO;
import java.util.List;
import models.Servidor;

public class ServidorController {

    private final ServidorDAO dao;

    public ServidorController() {
        dao = new ServidorDAO();
    }

    // Cadastrar novo servidor
    public void cadastrarServidor(Servidor s) {
        dao.salvar(s);
    }

    // Atualizar servidor existente
    public void atualizarServidor(Servidor s) {
        dao.atualizar(s);
    }

    // Listar todos os servidores
    public List<Servidor> listarServidores() {
        return dao.listar();
    }

    // Buscar servidor por ID
    public Servidor buscarServidorPorId(int id) {
        return dao.buscarPorId(id);
    }
}
