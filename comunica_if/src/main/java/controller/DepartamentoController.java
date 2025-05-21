/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import daos.DepartamentoDAO;
import java.util.List;
import models.Departamento;

class DepartamentoController {
    private final DepartamentoDAO dao = new DepartamentoDAO();
    public void cadastrarDepartamento(Departamento d) { dao.salvar(d); }
    public List<Departamento> listarDepartamentos() { return dao.listar(); }
}
