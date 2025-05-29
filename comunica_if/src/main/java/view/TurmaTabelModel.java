package view;

import controller.TurmaController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Turma;

public class TurmaTabelModel extends AbstractTableModel {
    private final List<Turma> turmas;
    private final String[] colunas = {"Código","Nome", "Curso", "Ano", "Semestre"};

    private TurmaController tc = new TurmaController();
    
    public TurmaTabelModel(List<Turma> turmas) {
        this.turmas=turmas;
    }

    public TurmaTabelModel() {
        turmas = tc.listarTurmas();
    }

    @Override
    public int getRowCount() {
        return turmas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Turma tc = turmas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tc.getCodigo();
            case 1:
                return tc.getNome();
            case 2:
                return tc.getCurso();
            case 3:
                return tc.getAno();
            case 4:
                return tc.getSemestre();                
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}