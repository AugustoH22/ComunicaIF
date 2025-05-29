package view;

import controller.ServidorController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Servidor;

public class ServidorTabelModel extends AbstractTableModel {
    private final List<Servidor> servidores;
    private final String[] colunas = {"Código","Nome", "Departamento", "Permissão"};

    private ServidorController sc = new ServidorController();
    
    public ServidorTabelModel(List<Servidor> servidores) {
        this.servidores=servidores;
    }

    public ServidorTabelModel() {
        servidores = sc.listarServidores();
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
        Servidor sc = servidores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sc.getId();
            case 1:
                return sc.getNome();
            case 2:
                return sc.getDepartamento();
            case 3:
                return sc.getPermissao();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}