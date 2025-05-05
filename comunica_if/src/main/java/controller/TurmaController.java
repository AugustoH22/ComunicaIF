/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import daos.TurmaDAO;
import java.util.List;
import models.Turma;

class TurmaController {
    private TurmaDAO dao = new TurmaDAO();
    public void cadastrarTurma(Turma t) { dao.salvar(t); }
    public List<Turma> listarTurmas() { return dao.listar(); }
}
