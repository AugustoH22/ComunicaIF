/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import daos.CursoDAO;
import java.util.List;
import models.Curso;

public class CursoController {
    private CursoDAO dao = new CursoDAO();
    public void cadastrarCurso(Curso c) { dao.salvar(c); }
    public void editarCurso(int codigo, Curso c){dao.editar(codigo,c);}
    public List<Curso> listarCursos() { return dao.listar(); }
}
