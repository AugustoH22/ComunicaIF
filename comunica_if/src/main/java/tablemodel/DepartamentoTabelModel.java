package tablemodel;

import controller.DepartamentoController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Departamento;

public class DepartamentoTabelModel extends AbstractTableModel {
    private final List<Departamento> departamentos;
    private final String[] colunas = {"Id","Nome"};

    private DepartamentoController dc = new DepartamentoController();
    
    public DepartamentoTabelModel(List<Departamento> departamentos) {
        this.departamentos=departamentos;
    }

    public DepartamentoTabelModel() {
        departamentos = dc.listarDepartamentos();
    }

    @Override
    public int getRowCount() {
        return departamentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Departamento dc = departamentos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dc.getCodigo();
            case 1:
                return dc.getNome();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}