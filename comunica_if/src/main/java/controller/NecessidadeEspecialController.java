/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import daos.NecessidadeEspecialDAO;
import java.util.List;
import models.NecessidadeEspecial;

public class NecessidadeEspecialController {
    private NecessidadeEspecialDAO dao = new NecessidadeEspecialDAO();
    public void cadastrarNecessidade(NecessidadeEspecial n) { dao.salvar(n); }
    public List<NecessidadeEspecial> listarNecessidades() { return dao.listar(); }
}
