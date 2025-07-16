package controller;

import daos.DepartamentoDAO;
import java.util.List;
import models.Departamento;

public class DepartamentoController {

    private final DepartamentoDAO dao;

    public DepartamentoController() {
        dao = new DepartamentoDAO();
    }

    // Cadastrar novo departamento
    public void cadastrarDepartamento(Departamento d) {
        dao.salvar(d);
    }

    // Atualizar um departamento existente
    public void atualizarDepartamento(Departamento d) {
        dao.atualizar(d);
    }

    // Listar todos os departamentos
    public List<Departamento> listarDepartamentos() {
        return dao.listar();
    }

    // Buscar um departamento por ID
    public Departamento buscarDepartamentoPorId(int id) {
        return dao.buscarPorId(id);
    }
    
    public void excluir(int id){
        dao.excluir(id);
    }
    
    public boolean possuiServidoresVinculados(int id){
        return dao.possuiServidoresVinculados(id);
    } 
}
