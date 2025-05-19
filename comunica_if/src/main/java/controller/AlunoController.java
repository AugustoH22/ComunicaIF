/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.List;
import models.Aluno;
import daos.AlunoDAO;

public class AlunoController {
    private final AlunoDAO dao = new AlunoDAO();
    public void cadastrarAluno(Aluno a) { dao.salvar(a); }

}
