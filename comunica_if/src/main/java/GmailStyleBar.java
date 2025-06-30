import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GmailStyleBar extends JFrame {
    private JPanel chipsPanel;
    private JTextField inputField;
    private JPopupMenu suggestionsPopup;
    private JList<String> suggestionsList;

    private List<String> suggestions = List.of("Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel");

    public GmailStyleBar() {
        setTitle("Barra de Pesquisa Estilo Gmail");
        setSize(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel com layout flexível
        chipsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chipsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        chipsPanel.setBackground(Color.WHITE);

        // Campo de entrada
        inputField = new JTextField(15);
        chipsPanel.add(inputField);

        // Popup com sugestões
        suggestionsPopup = new JPopupMenu();
        suggestionsList = new JList<>();
        suggestionsPopup.add(new JScrollPane(suggestionsList));

        // Ação de digitar para buscar
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = inputField.getText();
                if (texto.isEmpty()) {
                    suggestionsPopup.setVisible(false);
                    return;
                }

                // Filtra sugestões
                List<String> filtrados = suggestions.stream()
                        .filter(nome -> nome.toLowerCase().contains(texto.toLowerCase()))
                        .toList();

                if (filtrados.isEmpty()) {
                    suggestionsPopup.setVisible(false);
                    return;
                }

                suggestionsList.setListData(filtrados.toArray(new String[0]));
                suggestionsList.setVisibleRowCount(Math.min(filtrados.size(), 5));

                // Exibe popup
                suggestionsPopup.show(inputField, 0, inputField.getHeight());
                inputField.requestFocus();
            }
        });

        // Clique na sugestão
        suggestionsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String selecionado = suggestionsList.getSelectedValue();
                if (selecionado != null) {
                    adicionarChip(selecionado);
                    inputField.setText("");
                    suggestionsPopup.setVisible(false);
                }
            }
        });

        setLayout(new BorderLayout());
        add(chipsPanel, BorderLayout.NORTH);
    }

    // 🔥 Adiciona o "chip" com nome + botão X
    private void adicionarChip(String nome) {
        JPanel chip = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
        chip.setBackground(new Color(220, 220, 220));
        chip.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        JLabel label = new JLabel(nome);
        JButton btnX = new JButton("X");
        btnX.setMargin(new Insets(1, 4, 1, 4));
        btnX.setFocusable(false);
        btnX.setBorder(BorderFactory.createEmptyBorder());

        btnX.addActionListener(e -> {
            chipsPanel.remove(chip);
            chipsPanel.revalidate();
            chipsPanel.repaint();
        });

        chip.add(label);
        chip.add(btnX);
        chipsPanel.add(chip, chipsPanel.getComponentCount() - 1); // Adiciona antes do campo de texto
        chipsPanel.revalidate();
        chipsPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GmailStyleBar().setVisible(true);
        });
    }
}

