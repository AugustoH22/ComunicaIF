package view;

import controller.AlunoController;
import controller.MensagemController;
import controller.ServidorController;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import models.Aluno;
import models.Mensagem;
import models.Servidor;

public final class EnvioMensagem extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EnvioMensagem.class.getName());

    private JPopupMenu suggestionsPopupAlunos;
    private JList<Aluno> suggestionsListAlunos;
    private JPopupMenu suggestionsPopup;
    private JList<Servidor> suggestionsList;
    private final List<Servidor> suggestionsServidores = new ArrayList<>();
    private final List<Servidor> servidoresSelecionados = new ArrayList<>();
    private final List<Aluno> alunosSelecionados = new ArrayList<>();
    private final List<Aluno> suggestionsAlunos = new ArrayList<>();
    private final ServidorController sc;
    private final AlunoController ac;
    private final MensagemController mc;
    private List<Servidor> listaServidores = new ArrayList<>();
    private List<Aluno> listaAlunos = new ArrayList<>();
    private final Servidor remetente;

    public EnvioMensagem(Servidor remetente) {
        initComponents();
        this.remetente = remetente;
        mc = new MensagemController();
        sc = new ServidorController();
        ac = new AlunoController();
        listaServidores = sc.listarServidores();
        listaAlunos = ac.listarAlunos();
        chipsPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 5, 5));
        chipsPanelAlunos.setLayout(new WrapLayout(FlowLayout.LEFT, 5, 5));
        suggestionsPopup = new JPopupMenu();
        suggestionsList = new JList<>();
        suggestionsList.setVisibleRowCount(10); 
        suggestionsPopup.add(suggestionsList);
        suggestionsPopupAlunos = new JPopupMenu();
        suggestionsListAlunos = new JList<>();
        suggestionsListAlunos.setVisibleRowCount(10);
        suggestionsPopupAlunos.add(suggestionsListAlunos);
        listarUsuarios();
        listarAlunos();

        rbServidores.setVisible(false);
        rbDepartamentos.setVisible(false);
        btnEnviar.setEnabled(false);

        suggestionsListAlunos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Aluno selecionado = suggestionsListAlunos.getSelectedValue();
                if (selecionado != null) {
                    adicionarChipAlunos(selecionado);  // 🔥 Adiciona o chip
                    barraPesquisaAlunos.setText("");       // 🔥 Limpa o campo de pesquisa
                    suggestionsPopupAlunos.setVisible(false); // 🔥 Esconde o popup
                }
            }
        });

        suggestionsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Servidor selecionado = suggestionsList.getSelectedValue();
                if (selecionado != null) {
                    adicionarChip(selecionado);  // 🔥 Adiciona o chip
                    barraPesquisa.setText("");       // 🔥 Limpa o campo de pesquisa
                    suggestionsPopup.setVisible(false); // 🔥 Esconde o popup
                }
            }
        });
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfAssunto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfOcorrencia = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        chipsPanel = new javax.swing.JPanel();
        barraPesquisa = new javax.swing.JTextField();
        rbServidores = new javax.swing.JRadioButton();
        rbDepartamentos = new javax.swing.JRadioButton();
        chipsPanelAlunos = new javax.swing.JPanel();
        barraPesquisaAlunos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Assunto:");

        jLabel2.setText("Destino:");

        tfAssunto.setMinimumSize(new java.awt.Dimension(64, 33));
        tfAssunto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfAssuntoCaretUpdate(evt);
            }
        });

        jLabel3.setText("Ocorrência:");

        tfOcorrencia.setColumns(20);
        tfOcorrencia.setRows(5);
        tfOcorrencia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfOcorrenciaCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(tfOcorrencia);

        jLabel4.setText("Alunos:");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        chipsPanel.setBackground(new java.awt.Color(255, 255, 255));
        chipsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        chipsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chipsPanelMouseClicked(evt);
            }
        });

        barraPesquisa.setColumns(20);
        barraPesquisa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barraPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barraPesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout chipsPanelLayout = new javax.swing.GroupLayout(chipsPanel);
        chipsPanel.setLayout(chipsPanelLayout);
        chipsPanelLayout.setHorizontalGroup(
            chipsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chipsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        chipsPanelLayout.setVerticalGroup(
            chipsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chipsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rbServidores.setSelected(true);
        rbServidores.setText("Servidores");
        rbServidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbServidoresActionPerformed(evt);
            }
        });

        rbDepartamentos.setText("Departamentos");
        rbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDepartamentosActionPerformed(evt);
            }
        });

        chipsPanelAlunos.setBackground(new java.awt.Color(255, 255, 255));
        chipsPanelAlunos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        chipsPanelAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chipsPanelAlunosMouseClicked(evt);
            }
        });

        barraPesquisaAlunos.setColumns(20);
        barraPesquisaAlunos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barraPesquisaAlunos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barraPesquisaAlunosKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout chipsPanelAlunosLayout = new javax.swing.GroupLayout(chipsPanelAlunos);
        chipsPanelAlunos.setLayout(chipsPanelAlunosLayout);
        chipsPanelAlunosLayout.setHorizontalGroup(
            chipsPanelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chipsPanelAlunosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraPesquisaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        chipsPanelAlunosLayout.setVerticalGroup(
            chipsPanelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chipsPanelAlunosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barraPesquisaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chipsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addComponent(tfAssunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbServidores)
                                .addGap(18, 18, 18)
                                .addComponent(rbDepartamentos))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(chipsPanelAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbServidores)
                    .addComponent(rbDepartamentos))
                .addGap(10, 10, 10)
                .addComponent(chipsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAssunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chipsPanelAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnCancelar))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        Mensagem mensagem = retornaMensagem();
        mc.enviarMensagem(mensagem);
        
        this.dispose();
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
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
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chipsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chipsPanelMouseClicked
        barraPesquisa.requestFocusInWindow();
    }//GEN-LAST:event_chipsPanelMouseClicked

    private void barraPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barraPesquisaKeyReleased
        String texto = barraPesquisa.getText();
        if (texto.isEmpty()) {
            suggestionsPopup.setVisible(false);
            return;
        }

// 🔥 Correto: use a lista 'suggestions' para fazer o stream
        List<Servidor> filtrados = suggestionsServidores.stream()
                .filter(servidor -> servidor.getUsuario().toLowerCase().contains(texto.toLowerCase()))
                .limit(10) // 🔥 Limita a no máximo 10 sugestões
                .toList();

        if (filtrados.isEmpty()) {
            suggestionsPopup.setVisible(false);
            return;
        }

        suggestionsList.setListData(filtrados.toArray(Servidor[]::new));
        suggestionsList.setVisibleRowCount(Math.min(filtrados.size(), 10));

// 🔥 Mostra o popup logo abaixo do JTextField
        suggestionsPopup.show(barraPesquisa, 0, barraPesquisa.getHeight());
        barraPesquisa.requestFocus();


    }//GEN-LAST:event_barraPesquisaKeyReleased

    private void rbServidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbServidoresActionPerformed
        RadioButtonSelected(true);
    }//GEN-LAST:event_rbServidoresActionPerformed

    private void rbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDepartamentosActionPerformed
        RadioButtonSelected(false);
    }//GEN-LAST:event_rbDepartamentosActionPerformed

    private void barraPesquisaAlunosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barraPesquisaAlunosKeyReleased
        String texto = barraPesquisaAlunos.getText();
        if (texto.isEmpty()) {
            suggestionsPopupAlunos.setVisible(false);
            return;
        }

// 🔥 Correto: use a lista 'suggestions' para fazer o stream
        List<Aluno> filtrados = suggestionsAlunos.stream()
                .filter(aluno -> aluno.getNome().toLowerCase().contains(texto.toLowerCase()))
                .limit(10) // 🔥 Limita a no máximo 10 sugestões
                .toList();

        if (filtrados.isEmpty()) {
            suggestionsPopupAlunos.setVisible(false);
            return;
        }

        suggestionsListAlunos.setListData(filtrados.toArray(Aluno[]::new));
        suggestionsListAlunos.setVisibleRowCount(Math.min(filtrados.size(), 10));

// 🔥 Mostra o popup logo abaixo do JTextField
        suggestionsPopupAlunos.show(barraPesquisaAlunos, 0, barraPesquisaAlunos.getHeight());
        barraPesquisaAlunos.requestFocus();
    }//GEN-LAST:event_barraPesquisaAlunosKeyReleased

    private void chipsPanelAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chipsPanelAlunosMouseClicked
        barraPesquisaAlunos.requestFocusInWindow();
    }//GEN-LAST:event_chipsPanelAlunosMouseClicked

    private void tfAssuntoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfAssuntoCaretUpdate
       verificaCampos();
    }//GEN-LAST:event_tfAssuntoCaretUpdate

    private void tfOcorrenciaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfOcorrenciaCaretUpdate
       verificaCampos();
    }//GEN-LAST:event_tfOcorrenciaCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Servidor remetente = new Servidor();
        java.awt.EventQueue.invokeLater(() -> new EnvioMensagem(remetente).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraPesquisa;
    private javax.swing.JTextField barraPesquisaAlunos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JPanel chipsPanel;
    private javax.swing.JPanel chipsPanelAlunos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDepartamentos;
    private javax.swing.JRadioButton rbServidores;
    private javax.swing.JTextField tfAssunto;
    private javax.swing.JTextArea tfOcorrencia;
    // End of variables declaration//GEN-END:variables

    public void RadioButtonSelected(boolean selecao) {
        if (selecao) {
            rbServidores.setSelected(true);
            rbDepartamentos.setSelected(false);
        }
        if (!selecao) {
            rbServidores.setSelected(false);
            rbDepartamentos.setSelected(true);
        }
    }

    public void listarUsuarios() {

        suggestionsServidores.removeAll(suggestionsServidores);
        
        if (!listaServidores.isEmpty()) {
            for (Servidor cf : listaServidores) {
                if (!servidoresSelecionados.isEmpty()) {                  
                    System.out.print("IF Servidores Selecionados");
                    for (Servidor aux : servidoresSelecionados) {
                        if (!(aux.getCodigo() == cf.getCodigo())) {
                            suggestionsServidores.add(cf);
                        }
                    }
                }else{
                    suggestionsServidores.add(cf);
                }
            }
        }
    }

    public void listarAlunos() {
        
        suggestionsAlunos.removeAll(suggestionsAlunos);

        if (!listaAlunos.isEmpty()) {
            for (Aluno cf : listaAlunos) {
                if (!alunosSelecionados.isEmpty()) {                   
                    System.out.print("IF Servidores Selecionados");
                    for (Aluno aux : alunosSelecionados) {
                        if (!(aux.getCodigo() == cf.getCodigo())) {
                            suggestionsAlunos.add(cf);
                        }
                    }
                }else{
                    suggestionsAlunos.add(cf);
                }
            }
        }
    }

    private void adicionarChip(Servidor s) {
        JPanel chip = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
        chip.setBackground(new Color(220, 220, 220));
        chip.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel label = new JLabel(s.getUsuario());
        JButton btnX = new JButton("X");
        btnX.setMargin(new Insets(1, 4, 1, 4));
        btnX.setFocusable(false);
        btnX.setBorder(BorderFactory.createEmptyBorder());

        servidoresSelecionados.add(s);
        verificaCampos();
        System.out.print(servidoresSelecionados);
        listarUsuarios();

        btnX.addActionListener(e -> {
            chipsPanel.remove(chip);
            servidoresSelecionados.remove(s);
            verificaCampos();
            listarAlunos();
            chipsPanel.revalidate();
            chipsPanel.repaint();
            System.out.print(servidoresSelecionados);
        });

        chip.add(label);
        chip.add(btnX);
        chipsPanel.add(chip, chipsPanel.getComponentCount() - 1); // Adiciona antes do campo de texto
        chipsPanel.revalidate();
        chipsPanel.repaint();
    }

    private void adicionarChipAlunos(Aluno a) {
        JPanel chipAlunos = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
        chipAlunos.setBackground(new Color(220, 220, 220));
        chipAlunos.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel label = new JLabel(a.getNome());
        JButton btnX = new JButton("X");
        btnX.setMargin(new Insets(1, 4, 1, 4));
        btnX.setFocusable(false);
        btnX.setBorder(BorderFactory.createEmptyBorder());
        
        alunosSelecionados.add(a);
        verificaCampos();
        listarAlunos();

        btnX.addActionListener(e -> {
            chipsPanelAlunos.remove(chipAlunos);
            alunosSelecionados.remove(a);
            verificaCampos();
            listarAlunos();
            chipsPanelAlunos.revalidate();
            chipsPanelAlunos.repaint();
        });

        chipAlunos.add(label);
        chipAlunos.add(btnX);
        chipsPanelAlunos.add(chipAlunos, chipsPanelAlunos.getComponentCount() - 1); // Adiciona antes do campo de texto
        chipsPanelAlunos.revalidate();
        chipsPanelAlunos.repaint();
    }
    
    
    private void verificaCampos(){
        
        boolean campo = !servidoresSelecionados.isEmpty()
                && !alunosSelecionados.isEmpty()
                && !tfAssunto.getText().trim().isEmpty()
                && !tfOcorrencia.getText().trim().isEmpty();
        
        btnEnviar.setEnabled(campo);
    }
    
    private Mensagem retornaMensagem(){
        
        LocalDateTime data = LocalDateTime.now();
        
        Mensagem mensagem = new Mensagem(0, tfOcorrencia.getText(),tfAssunto.getText(), remetente, servidoresSelecionados, alunosSelecionados, data);
        
        return mensagem;
        
    }

}
