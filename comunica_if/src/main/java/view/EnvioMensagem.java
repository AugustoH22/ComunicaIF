package view;

import controller.AlunoController;
import controller.HistoricoRestritoController;
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
import models.HistoricoRestrito;
import models.Mensagem;
import models.Servidor;

public final class EnvioMensagem extends javax.swing.JDialog {

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
    private final HistoricoRestritoController hc;
    private List<Servidor> listaServidores = new ArrayList<>();
    private List<Aluno> listaAlunos = new ArrayList<>();
    private final Servidor remetente;
    private final int codigo;
    private final int modo;

    public EnvioMensagem(java.awt.Frame parent, boolean modal, Servidor remetente, int modo, int codigo) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.remetente = remetente;
        this.modo = modo;
        this.codigo = codigo;
        mc = new MensagemController();
        sc = new ServidorController();
        ac = new AlunoController();
        hc = new HistoricoRestritoController();
        listaServidores = sc.listarServidores();
        listaServidores.remove(this.remetente);
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
        tfOcorrencia.setLineWrap(true);          // Quebra linhas automaticamente
        tfOcorrencia.setWrapStyleWord(true);

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

        if (this.modo == 1) {
            Mensagem m = mc.buscarMensagemPorId(this.codigo);
            tfAssunto.setText(m.getAssunto());
            adicionarChip(m.getRemetente());
            for (Aluno cf : m.getAlunos()) {
                adicionarChipAlunos(cf);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfAssunto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfOcorrencia = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        chipsPanel = new javax.swing.JPanel();
        barraPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chipsPanelAlunos = new javax.swing.JPanel();
        barraPesquisaAlunos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tfAssunto.setBackground(new java.awt.Color(204, 204, 204));
        tfAssunto.setText(" Assunto");
        tfAssunto.setBorder(null);
        tfAssunto.setMinimumSize(new java.awt.Dimension(64, 33));
        tfAssunto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfAssuntoCaretUpdate(evt);
            }
        });
        tfAssunto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAssuntoFocusLost(evt);
            }
        });
        tfAssunto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfAssuntoMouseClicked(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tfOcorrencia.setBackground(new java.awt.Color(204, 204, 204));
        tfOcorrencia.setColumns(20);
        tfOcorrencia.setRows(5);
        tfOcorrencia.setText("  Ocorrência");
        tfOcorrencia.setBorder(null);
        tfOcorrencia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfOcorrenciaCaretUpdate(evt);
            }
        });
        tfOcorrencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfOcorrenciaFocusLost(evt);
            }
        });
        tfOcorrencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfOcorrenciaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tfOcorrencia);

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

        chipsPanel.setBackground(new java.awt.Color(204, 204, 204));
        chipsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chipsPanelMouseClicked(evt);
            }
        });

        barraPesquisa.setBackground(new java.awt.Color(204, 204, 204));
        barraPesquisa.setColumns(20);
        barraPesquisa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barraPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barraPesquisaKeyReleased(evt);
            }
        });

        jLabel1.setText("Para:");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout chipsPanelLayout = new javax.swing.GroupLayout(chipsPanel);
        chipsPanel.setLayout(chipsPanelLayout);
        chipsPanelLayout.setHorizontalGroup(
            chipsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chipsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(barraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        chipsPanelLayout.setVerticalGroup(
            chipsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chipsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chipsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chipsPanelAlunos.setBackground(new java.awt.Color(204, 204, 204));
        chipsPanelAlunos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        chipsPanelAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chipsPanelAlunosMouseClicked(evt);
            }
        });

        barraPesquisaAlunos.setBackground(new java.awt.Color(204, 204, 204));
        barraPesquisaAlunos.setColumns(20);
        barraPesquisaAlunos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        barraPesquisaAlunos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barraPesquisaAlunosKeyReleased(evt);
            }
        });

        jLabel2.setText("Alunos:");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout chipsPanelAlunosLayout = new javax.swing.GroupLayout(chipsPanelAlunos);
        chipsPanelAlunos.setLayout(chipsPanelAlunosLayout);
        chipsPanelAlunosLayout.setHorizontalGroup(
            chipsPanelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chipsPanelAlunosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraPesquisaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        chipsPanelAlunosLayout.setVerticalGroup(
            chipsPanelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chipsPanelAlunosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(chipsPanelAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barraPesquisaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chipsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addComponent(chipsPanelAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(tfAssunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnCancelar))
                .addGap(10, 10, 10)
                .addComponent(chipsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tfAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(chipsPanelAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        Mensagem mensagem = retornaMensagem();
        salvaHistorico();
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

    private void tfAssuntoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfAssuntoMouseClicked
        String aux = tfAssunto.getText();
        if (aux.equals(" Assunto")) {
            tfAssunto.setText("");
        }
    }//GEN-LAST:event_tfAssuntoMouseClicked

    private void tfAssuntoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAssuntoFocusLost
        String aux = tfAssunto.getText();
        if (aux.equals("")) {
            tfAssunto.setText(" Assunto");
        }
    }//GEN-LAST:event_tfAssuntoFocusLost

    private void tfOcorrenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfOcorrenciaMouseClicked
        String aux = tfOcorrencia.getText();
        if (aux.equals("  Ocorrência")) {
            tfOcorrencia.setText("");
        }
    }//GEN-LAST:event_tfOcorrenciaMouseClicked

    private void tfOcorrenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOcorrenciaFocusLost
        String aux = tfOcorrencia.getText();
        if (aux.equals("")) {
            tfOcorrencia.setText("  Ocorrência");
        }
    }//GEN-LAST:event_tfOcorrenciaFocusLost

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        barraPesquisa.requestFocusInWindow();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        barraPesquisaAlunos.requestFocusInWindow();
    }//GEN-LAST:event_jLabel2MouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new EnvioMensagem(new javax.swing.JFrame(), true, remetente, 0, 0).setVisible(true));
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField tfAssunto;
    private javax.swing.JTextArea tfOcorrencia;
    // End of variables declaration//GEN-END:variables

    public void listarUsuarios() {
        suggestionsServidores.clear();

        for (Servidor cf : listaServidores) {
            boolean existe = servidoresSelecionados.stream()
                    .anyMatch(aux -> aux.getCodigo() == (cf.getCodigo()));

            if (!existe) {
                suggestionsServidores.add(cf);
            }
        }
    }

    public void listarAlunos() {
        suggestionsAlunos.clear();

        for (Aluno cf : listaAlunos) {
            boolean existe = alunosSelecionados.stream()
                    .anyMatch(aux -> aux.getCodigo() == cf.getCodigo());

            if (!existe) {
                suggestionsAlunos.add(cf);
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

    private void verificaCampos() {

        boolean campo = !servidoresSelecionados.isEmpty()
                && !alunosSelecionados.isEmpty()
                && !tfAssunto.getText().trim().isEmpty()
                && !tfOcorrencia.getText().trim().isEmpty();

        btnEnviar.setEnabled(campo);
    }

    private Mensagem retornaMensagem() {

        LocalDateTime data = LocalDateTime.now();

        Mensagem mensagem = new Mensagem(0, tfOcorrencia.getText(), tfAssunto.getText(), remetente, servidoresSelecionados, alunosSelecionados, data);

        return mensagem;

    }

    private void salvaHistorico() {

        LocalDateTime data = LocalDateTime.now();

        if (!alunosSelecionados.isEmpty()) {
            for (Aluno a : alunosSelecionados) {
                HistoricoRestrito historico = new HistoricoRestrito(0, data, tfAssunto.getText(), tfOcorrencia.getText(), a.getCodigo(), remetente.getCodigo());
                hc.registrarHistorico(historico);
            }
        }
        
    }

}
