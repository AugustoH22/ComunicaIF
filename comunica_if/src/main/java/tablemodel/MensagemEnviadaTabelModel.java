package tablemodel;

import controller.MensagemController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import models.Mensagem;
import models.Servidor;

public class MensagemEnviadaTabelModel extends AbstractTableModel {

    private final List<Mensagem> mensagens;
    private final String[] colunas = {"ID", "", "Destinatário", " Assunto", "Data"};

    private MensagemController mc = new MensagemController();

    public MensagemEnviadaTabelModel(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public MensagemEnviadaTabelModel() {
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
        LocalDateTime dataHora = mc.getDataHoraCriacao();

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
                return mc.getCodigo();
            case 1:
                return "";
            case 2:
                List<Servidor> destinatarios = mc.getDestinatarios();
                if (destinatarios == null || destinatarios.isEmpty()) {
                    return "(sem destinatário)";
                }

                int limite = 1;
                String nomes = destinatarios.stream()
                        .limit(limite)
                        .map(s -> s.getNome())
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("");

                if (destinatarios.size() > limite) {
                    nomes += " e outros";
                }

                return nomes;
            case 3:
                return mc.getAssunto();
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
