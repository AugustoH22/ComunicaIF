package tablemodel;

import controller.ServidorController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.HistoricoRestrito;
import models.Servidor;

public class HistoricoTabelModel extends AbstractTableModel {

    private final List<HistoricoRestrito> historico;
    private final String[] colunas = {"ID", "", "Remetente", " Assunto", "Data"};

    private ServidorController sc = new ServidorController();

    public HistoricoTabelModel(List<HistoricoRestrito> historico) {
        this.historico = historico;
    }

    @Override
    public int getRowCount() {
        return historico.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HistoricoRestrito hc = historico.get(rowIndex);
        LocalDateTime dataHora = hc.getDataHora();
        Servidor servidor = sc.buscarServidorPorId(hc.getCodServidor());
        // Verifica se a mensagem foi enviada hoje
        boolean enviadaHoje = dataHora.toLocalDate().isEqual(LocalDate.now());

        String dataFormatada;
        LocalDateTime agora = LocalDateTime.now();
        int anoAtual = agora.getYear();

        if (dataHora.toLocalDate().isEqual(LocalDate.now())) {
            // Hoje → só hora e minuto
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
            dataFormatada = dataHora.format(formatoHora);
        } else if (dataHora.getYear() == anoAtual) {
            // Mesmo ano → "04 de jul."
            DateTimeFormatter formatoMesTexto = DateTimeFormatter.ofPattern("dd 'de' MMM");
            dataFormatada = dataHora.format(formatoMesTexto);
        } else {
            // Outro ano → "04/07/2024"
            DateTimeFormatter formatoCompleto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataFormatada = dataHora.format(formatoCompleto);
        }

        switch (columnIndex) {
            case 0:
                return hc.getCodigo();
            case 1:
                return "";
            case 2:
                return servidor.getNome();
            case 3:
                return hc.getOcorrencia();
            case 4:
                return dataFormatada;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
