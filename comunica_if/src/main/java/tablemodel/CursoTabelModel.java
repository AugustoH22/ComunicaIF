package tablemodel;

import controller.CursoController;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Curso;

public class CursoTabelModel extends AbstractTableModel {

    private final List<Curso> cursos;
    private final List<Boolean> selecionados;
    private final String[] colunas = {"Select","Código", "Nome"};

    private CursoController cc = new CursoController();

    public CursoTabelModel(List<Curso> cursos) {
        this.cursos = cursos;
        this.selecionados = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            selecionados.add(false); // Inicialmente todos desmarcados
        }
    }

    public CursoTabelModel() {
        cursos = cc.listarCursos();
        this.selecionados = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            selecionados.add(false);
        }
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
                return selecionados.get(rowIndex);              
            case 1:
                return c.getCodigo();    
            case 2:
                return c.getNome();              
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            selecionados.set(rowIndex, (Boolean) aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    } 
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 0; // Apenas a coluna do checkbox é editável
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class; // Faz aparecer como checkbox
        }
        return String.class;
    }

    // 🔥 Método utilitário para pegar os cursos selecionados
    public List<Curso> getCursosSelecionados() {
        List<Curso> selecionadosCursos = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            if (selecionados.get(i)) {
                selecionadosCursos.add(cursos.get(i));
            }
        }
        return selecionadosCursos;
    }
}
