package tablemodel;

import controller.CursoController;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Curso;

public class CursoTabelModel extends AbstractTableModel {

    private final List<Curso> cursos;
    private final String[] colunas = {"Código", "Nome"};

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
        Curso c = cursos.get(rowIndex);
        switch (columnIndex) {             
            case 0:
                return c.getCodigo();    
            case 1:
                return c.getNome();              
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    

}
