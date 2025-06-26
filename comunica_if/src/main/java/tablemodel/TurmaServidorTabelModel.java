package tablemodel;

import controller.AlunoController;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Aluno;

public class TurmaServidorTabelModel extends AbstractTableModel {
    private final List<Aluno> alunos;
    private final List<Boolean> selecionados;
    private final String[] colunas = {"Select","Código","Nome"};

    private AlunoController ac = new AlunoController();
    
    public TurmaServidorTabelModel(List<Aluno> alunos) {
        this.alunos=alunos;
        this.selecionados = new ArrayList<>();
        for (int i = 0; i < alunos.size(); i++) {
            selecionados.add(false); // Inicialmente todos desmarcados
        }
    }

    public TurmaServidorTabelModel() {
        alunos = ac.listarAlunos();
        this.selecionados = new ArrayList<>();
        for (int i = 0; i < alunos.size(); i++) {
            selecionados.add(false); // Inicialmente todos desmarcados
        }
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno ac = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return selecionados.get(rowIndex);
            case 1:
                return ac.getCodigo();
            case 2:
                return ac.getNome();
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
    public List<Aluno> getAlunosSelecionados() {
        List<Aluno> selecionadosAlunos = new ArrayList<>();
        for (int i = 0; i < alunos.size(); i++) {
            if (selecionados.get(i)) {
                selecionadosAlunos.add(alunos.get(i));
            }
        }
        return selecionadosAlunos;
    }
}