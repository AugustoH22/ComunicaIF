package controller;

import daos.HistoricoRestritoDAO;
import java.util.List;
import models.HistoricoRestrito;

public class HistoricoRestritoController {

    private final HistoricoRestritoDAO dao;

    public HistoricoRestritoController() {
        dao = new HistoricoRestritoDAO();
    }

    // Cadastrar novo histórico restrito
    public void registrarHistorico(HistoricoRestrito h) {
        dao.salvar(h);
    }

    // Atualizar histórico restrito existente
    public void atualizarHistorico(HistoricoRestrito h) {
        dao.atualizar(h);
    }

    // Listar todos os históricos restritos
    public List<HistoricoRestrito> listarHistoricos() {
        return dao.listar();
    }

    // Buscar histórico por ID
    public HistoricoRestrito buscarHistoricoPorId(int id) {
        return dao.buscarPorId(id);
    }
}
