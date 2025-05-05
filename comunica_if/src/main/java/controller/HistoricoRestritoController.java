/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import daos.HistoricoRestritoDAO;
import java.util.List;
import models.HistoricoRestrito;

class HistoricoRestritoController {
    private HistoricoRestritoDAO dao = new HistoricoRestritoDAO();
    public void registrarHistorico(HistoricoRestrito h) { dao.salvar(h); }
    public List<HistoricoRestrito> listarHistoricos() { return dao.listar(); }
}
