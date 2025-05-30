package view;

import controller.CursoController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Curso;

public class CursoTabelModel extends AbstractTableModel {

    private final List<Curso> cursos;
    private final String[] colunas = {"Código", "Nome", "Ensino"};

    private CursoController cc = new CursoController();

    public CursoTabelModel(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public CursoTabelModel() {
        cursos = cc.listarCursos();
    }

    @Override
    public int getRowCount() {
        return cursos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Curso cc = cursos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cc.getCodigo();
            case 1:
                return cc.getNome();
            case 2:
                if(cc.isSuperior()){
                   return "Superior"; 
                }else{
                   return "Médio"; 
                }               
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
