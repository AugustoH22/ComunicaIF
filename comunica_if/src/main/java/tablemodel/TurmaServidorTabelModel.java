package tablemodel;

import controller.TurmaController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Servidor;

public class TurmaServidorTabelModel extends AbstractTableModel {
    private final List<Servidor> servidores;
    private final String[] colunas = {"Código","Nome"};

    private final TurmaController tc = new TurmaController();
    
    public TurmaServidorTabelModel(int t) {
        this.servidores = tc.listarServidores(t);
    }

    @Override
    public int getRowCount() {
        return servidores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servidor ac = servidores.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> ac.getCodigo();
            case 1 -> ac.getNome();
            default -> null;
        };
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

}