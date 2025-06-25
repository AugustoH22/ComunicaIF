package tablemodel;

import controller.MensagemController;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Mensagem;

public class MensagemTabelModel extends AbstractTableModel {
    private final List<Mensagem> mensagens;
    private final String[] colunas = {"Data","Assunto"};

    private MensagemController mc = new MensagemController();
    
    public MensagemTabelModel(List<Mensagem> mensagens) {
        this.mensagens=mensagens;
    }

    public MensagemTabelModel() {
        mensagens = mc.listarMensagens();
    }

    @Override
    public int getRowCount() {
        return mensagens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mensagem mc = mensagens.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mc.getCodigo();
            case 1:
                return mc.getTexto();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}