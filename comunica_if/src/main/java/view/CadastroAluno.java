package view;

import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CadastroAluno extends javax.swing.JDialog {

    
       
    public CadastroAluno() {


 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BotaoCancelar = new javax.swing.JButton();
        BotaoSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbProfissionais = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        cbProfissionais1 = new javax.swing.JComboBox();
        cbProfissionais2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbProfissionais3 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        tfDescricao.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfDescricaoCaretUpdate(evt);
            }
        });

        jLabel3.setText("Curso:");

        jLabel5.setText("Turma:");

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.setToolTipText("");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        BotaoSalvar.setText("Salvar");
        BotaoSalvar.setToolTipText("");
        BotaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Necessidades:");

        cbProfissionais.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbProfissionaisAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Especialidade"
            }
        ));
        jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTable2);

        btnExcluir.setText("Remover");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        cbProfissionais1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbProfissionais1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        cbProfissionais2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbProfissionais2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel6.setText("Ano:");

        cbProfissionais3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbProfissionais3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbProfissionais2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbProfissionais1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cbProfissionais3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbProfissionais, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 441, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BotaoSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoCancelar)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProfissionais1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31))
                    .addComponent(cbProfissionais3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProfissionais2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(cbProfissionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCancelar)
                    .addComponent(BotaoSalvar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this,
                "Deseja sair sem salvar?",
                "Sair sem salvar?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        // Ação baseada na resposta do usuário
        if (response == JOptionPane.YES_OPTION) {
            this.dispose();
        } else if (response == JOptionPane.NO_OPTION) {
            // Usuário clicou em "Não"
        }
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
       
    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void tfDescricaoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfDescricaoCaretUpdate
         
    }//GEN-LAST:event_tfDescricaoCaretUpdate

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
       
    }//GEN-LAST:event_jTable2AncestorAdded

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbProfissionaisAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbProfissionaisAncestorAdded
     
    }//GEN-LAST:event_cbProfissionaisAncestorAdded

    private void cbProfissionais1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbProfissionais1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProfissionais1AncestorAdded

    private void cbProfissionais2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbProfissionais2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProfissionais2AncestorAdded

    private void cbProfissionais3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbProfissionais3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProfissionais3AncestorAdded


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                CadastroAluno dialog = new CadastroAluno();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox cbProfissionais;
    private javax.swing.JComboBox cbProfissionais1;
    private javax.swing.JComboBox cbProfissionais2;
    private javax.swing.JComboBox cbProfissionais3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    public javax.swing.JTextField tfDescricao;
    // End of variables declaration//GEN-END:variables

   
    
  


    private boolean isPrecoValido(String text) {
        try {
            // Remove o símbolo de moeda e substitui a vírgula por ponto para conversão
            String precoSemCifrao = text.replace("R$ ", "").trim().replace(",", ".");

            // Tenta converter para double
            double preco = Double.parseDouble(precoSemCifrao);

            // Verifica se o preço é maior que zero
            return preco > 0;
        } catch (NumberFormatException e) {
            return false; // Retorna falso se a conversão falhar
        }
    }
    
    public class PrecoDocumento extends DocumentFilter {

        private final JTextField textField;
        private static final String CURRENCY_SYMBOL = "R$ ";
        private static final int MAX_DIGITS = 9; // Limite de dígitos: 7 para reais e 2 para centavos

        public PrecoDocumento(JTextField textField, String valor) {
            this.textField = textField;
        
            
        }

        private void setPrecoInicial(String preco) {
            this.textField.setText(CURRENCY_SYMBOL + preco);
        }

        private void setCaretPosition(int position) {
            int safePosition = Math.min(position, textField.getText().length());
            textField.setCaretPosition(safePosition);
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            // Permite apenas números
            if (!string.matches("\\d")) {
                return;
            }

            // Impede inserção se o número máximo de dígitos for excedido
            String currentText = textField.getText().replace(CURRENCY_SYMBOL, "").replace(",", "");
            if (currentText.length() >= MAX_DIGITS) {
                return;
            }

            // Adiciona o novo dígito ao final
            StringBuilder newText = new StringBuilder(currentText);
            newText.append(string);

            // Formata o texto para exibir como valor monetário
            String formattedText = formatCurrency(newText.toString());

            super.replace(fb, 0, textField.getText().length(), formattedText, attr);

            // Ajusta o cursor para estar sempre após o símbolo de moeda e antes dos zeros
            SwingUtilities.invokeLater(() -> setCaretPosition(CURRENCY_SYMBOL.length()));
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            // Permite apenas números
            if (text != null && !text.matches("\\d*")) {
                return;
            }

            // Obtém o texto atual sem o símbolo de moeda e vírgula
            String currentText = textField.getText().replace(CURRENCY_SYMBOL, "").replace(",", "");
            StringBuilder newText = new StringBuilder(currentText);

            // Evita tentativa de substituir fora do comprimento da string
            if (offset > newText.length()) {
                return;
            }

            newText.replace(Math.max(0, offset), Math.min(newText.length(), offset + length), text != null ? text : "");

            if (newText.length() > MAX_DIGITS) {
                return; // Impede substituição se exceder o número máximo de dígitos
            }

            // Formata o texto para exibir como valor monetário
            String formattedText = formatCurrency(newText.toString());

            super.replace(fb, 0, textField.getText().length(), formattedText, attrs);

            // Ajusta o cursor para estar sempre após o símbolo de moeda e antes dos zeros
            SwingUtilities.invokeLater(() -> setCaretPosition(CURRENCY_SYMBOL.length()));
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            if (offset < CURRENCY_SYMBOL.length()) {
                SwingUtilities.invokeLater(() -> setCaretPosition(CURRENCY_SYMBOL.length()));
                return; // Impede a remoção do símbolo de moeda
            }

            // Obtém o texto atual sem o símbolo de moeda e vírgula
            String currentText = textField.getText().replace(CURRENCY_SYMBOL, "").replace(",", "");
            StringBuilder newText = new StringBuilder(currentText);

            // Evita tentativa de remoção fora do comprimento da string
            if (newText.length() > 0 && offset - CURRENCY_SYMBOL.length() < newText.length()) {
                newText.deleteCharAt(newText.length() - 1); // Remove o último dígito
            }

            // Formata o texto para exibir como valor monetário
            String formattedText = formatCurrency(newText.toString());

            super.replace(fb, 0, textField.getText().length(), formattedText, null);

            // Ajusta o cursor para estar sempre após o símbolo de moeda e antes dos zeros
            SwingUtilities.invokeLater(() -> setCaretPosition(CURRENCY_SYMBOL.length()));
        }

        private String formatCurrency(String value) {
            // Remove zeros à esquerda, se houver
            value = value.replaceFirst("^0+(?!$)", "");

            // Preenche com zeros à esquerda, se necessário, para garantir pelo menos 3 dígitos
            while (value.length() < 3) {
                value = "0" + value;
            }

            // Insere a vírgula para centavos
            String formattedValue = value.substring(0, value.length() - 2) + "," + value.substring(value.length() - 2);
            return CURRENCY_SYMBOL + formattedValue;
        }

        private boolean isValid(String text) {
            String numberPart = text.replace(CURRENCY_SYMBOL, "").replace(",", ""); // Remove o símbolo de moeda para validação

            if (numberPart.isEmpty() || numberPart.equals(" ")) {
                return true; // Permitir apenas o símbolo de moeda
            }

            return numberPart.matches("\\d*"); // Permite apenas números
        }
    }
    
}
