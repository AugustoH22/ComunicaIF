package tablemodel;

import controller.NecessidadeEspecialController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.NecessidadeEspecial;

public class NecessidadeTableModel extends AbstractTableModel {
    private final List<NecessidadeEspecial> necessidades;
    private final String[] colunas = {"ID","Código", "Descrição"};

    private NecessidadeEspecialController nc = new NecessidadeEspecialController();
    
    public NecessidadeTableModel(List<NecessidadeEspecial> necessidades) {
        this.necessidades = necessidades;
    }

    public NecessidadeTableModel() {
        necessidades = nc.listarNecessidades();
    }

    @Override
    public int getRowCount() {
        return necessidades.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NecessidadeEspecial nc = necessidades.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return nc.getCodigo();
            case 1:
                return nc.getCodigoNecessidade();    
            case 2:
                return nc.getDescricao();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}