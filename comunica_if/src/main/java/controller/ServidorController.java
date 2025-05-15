
package controller;

import daos.ServidorDAO;
import java.util.List;
import models.Servidor;

public class ServidorController {
    private ServidorDAO dao = new ServidorDAO();
    public void cadastrarServidor(Servidor s) { dao.salvar(s); }
    public List<Servidor> listarServidores() { return dao.listar(); }
}
