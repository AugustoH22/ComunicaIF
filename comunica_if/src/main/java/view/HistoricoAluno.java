/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.HistoricoRestritoController;
import controller.ServidorController;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import models.HistoricoRestrito;
import models.Servidor;
import tablemodel.HistoricoTabelModel;

/**
 *
 * @author augustobraga
 */
public class HistoricoAluno extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HistoricoAluno.class.getName());
    private int linhaMouse = -1;
    private HistoricoRestrito historico;
    private final HistoricoRestritoController hc;
    private final ServidorController sc;
    private final int codigo;
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    List<HistoricoRestrito> historicoAluno;

    public HistoricoAluno(java.awt.Frame parent, boolean modal, int codigo) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.codigo = codigo;
        hc = new HistoricoRestritoController();
        sc = new ServidorController();       
        CardLayout layout = (CardLayout) tela.getLayout();
        tela.add(telaResposta, "mensagem");
        tela.add(telaMensagem, "teste");
        layout.show(tela, "teste");
        tbMensagens.setRowHeight(40);
        atulizarTabelaHome();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tela = new javax.swing.JPanel();
        telaResposta = new javax.swing.JPanel();
        jPanel3 = new view.RoundedPanel();
        btnVoltar = new javax.swing.JButton();
        scrollPane1 = new javax.swing.JScrollPane();
        panel1 = new java.awt.Panel();
        remetenteUsuario = new java.awt.Label();
        dataMensagem = new java.awt.Label();
        remetenteMensagem = new javax.swing.JLabel();
        assuntoMensagem = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ocorrencia = new javax.swing.JTextArea();
        telaMensagem = new javax.swing.JPanel();
        panelMensagem = new view.RoundedPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMensagens = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaMouseClicked(evt);
            }
        });
        tela.setLayout(new java.awt.CardLayout());

        telaResposta.setBackground(new java.awt.Color(204, 204, 204));
        telaResposta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaRespostaMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 695));

        btnVoltar.setText("Voltar");
        btnVoltar.setFocusable(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        scrollPane1.setBorder(null);
        scrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane1.setMaximumSize(new java.awt.Dimension(900, 900));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setMaximumSize(new java.awt.Dimension(900, 900));

        remetenteUsuario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        remetenteUsuario.setForeground(new java.awt.Color(204, 204, 204));
        remetenteUsuario.setName(""); // NOI18N
        remetenteUsuario.setText("<remetente@gmail.com>");

        dataMensagem.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dataMensagem.setForeground(new java.awt.Color(51, 51, 51));
        dataMensagem.setName(""); // NOI18N
        dataMensagem.setText("dia., XX de XXX., XX:XX (há X dias)");

        remetenteMensagem.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        remetenteMensagem.setText("Assunto");

        assuntoMensagem.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        assuntoMensagem.setText("Assunto");

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ocorrencia.setColumns(20);
        ocorrencia.setRows(5);
        ocorrencia.setText("Ocorrência");
        ocorrencia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ocorrencia.setCaretColor(new java.awt.Color(255, 255, 255));
        ocorrencia.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(ocorrencia);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remetenteMensagem)
                            .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assuntoMensagem))
                        .addContainerGap(821, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assuntoMensagem)
                .addGap(12, 12, 12)
                .addComponent(dataMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(remetenteMensagem)
                .addGap(12, 12, 12)
                .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrollPane1.setViewportView(panel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout telaRespostaLayout = new javax.swing.GroupLayout(telaResposta);
        telaResposta.setLayout(telaRespostaLayout);
        telaRespostaLayout.setHorizontalGroup(
            telaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaRespostaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        telaRespostaLayout.setVerticalGroup(
            telaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaRespostaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tela.add(telaResposta, "card7");

        telaMensagem.setBackground(new java.awt.Color(204, 204, 204));
        telaMensagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaMensagemMouseClicked(evt);
            }
        });

        panelMensagem.setBackground(new java.awt.Color(255, 255, 255));
        panelMensagem.setPreferredSize(new java.awt.Dimension(900, 695));
        panelMensagem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setForeground(new java.awt.Color(255, 51, 0));

        tbMensagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbMensagens.setGridColor(new java.awt.Color(204, 204, 204));
        tbMensagens.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbMensagens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbMensagens.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tbMensagensMouseMoved(evt);
            }
        });
        tbMensagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMensagensMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbMensagensMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(tbMensagens);

        panelMensagem.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 910, 690));

        btnSair.setText("Voltar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telaMensagemLayout = new javax.swing.GroupLayout(telaMensagem);
        telaMensagem.setLayout(telaMensagemLayout);
        telaMensagemLayout.setHorizontalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMensagemLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSair)
                    .addComponent(panelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        telaMensagemLayout.setVerticalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMensagemLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tela.add(telaMensagem, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "teste");
        atulizarTabelaHome();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void telaRespostaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaRespostaMouseClicked
    }//GEN-LAST:event_telaRespostaMouseClicked

    private void tbMensagensMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMensagensMouseMoved
        int linha = tbMensagens.rowAtPoint(evt.getPoint());
        if (linha != linhaMouse) {
            linhaMouse = linha;
            tbMensagens.repaint();
        }
    }//GEN-LAST:event_tbMensagensMouseMoved

    private void tbMensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMensagensMouseClicked

        int linhaSelecionada = tbMensagens.rowAtPoint(evt.getPoint());
        if (linhaSelecionada == -1) {
            return;
        }
        int aux = (int) tbMensagens.getValueAt(linhaSelecionada, 0);

        if (aux >= 0) {
            mostrarMensagem(aux);
        }


    }//GEN-LAST:event_tbMensagensMouseClicked

    private void tbMensagensMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMensagensMouseExited
        linhaMouse = -1;
        tbMensagens.repaint();
    }//GEN-LAST:event_tbMensagensMouseExited

    private void telaMensagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaMensagemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telaMensagemMouseClicked

    private void telaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaMouseClicked

    }//GEN-LAST:event_telaMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            HistoricoAluno dialog = new HistoricoAluno(new javax.swing.JFrame(), true, 0);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assuntoMensagem;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVoltar;
    private java.awt.Label dataMensagem;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea ocorrencia;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panelMensagem;
    private javax.swing.JLabel remetenteMensagem;
    private java.awt.Label remetenteUsuario;
    private javax.swing.JScrollPane scrollPane1;
    public javax.swing.JTable tbMensagens;
    private javax.swing.JPanel tela;
    private javax.swing.JPanel telaMensagem;
    private javax.swing.JPanel telaResposta;
    // End of variables declaration//GEN-END:variables

    private void mostrarMensagem(int aux) {

        historico = hc.buscarHistoricoPorId(aux);
        Servidor remetente = sc.buscarServidorPorId(historico.getCodServidor());
        LocalDateTime data = historico.getDataHora();

        // Formatando o remetente
        String nomeRemetente = remetente.getNome();
        String usuarioRemetente = remetente.getUsuario(); // Ex: "joao"
        String emailRemetente = "<" + usuarioRemetente + ">";

        // Formatando a data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd 'de' MMM', 'HH:mm", new Locale("pt", "BR"));
        String dataFormatada = data.format(formatter);

        // Cálculo de tempo relativo
        long dias = ChronoUnit.DAYS.between(data.toLocalDate(), LocalDate.now());
        String tempoRelativo = dias == 0 ? "(hoje)" : dias == 1 ? "(há 1 dia)" : "(há " + dias + " dias)";

        assuntoMensagem.setText(historico.getOcorrencia());
        remetenteMensagem.setText(nomeRemetente);
        remetenteUsuario.setText(emailRemetente);
        dataMensagem.setText(dataFormatada + " " + tempoRelativo);
        ocorrencia.setText(historico.getAnotacao());

        // Exibe o painel da mensagem
        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "mensagem");

    }

    private void atulizarTabelaHome() {

        historicoAluno = hc.listarPorAluno(codigo);
        historicoAluno.sort(Comparator.comparing(HistoricoRestrito::getDataHora).reversed());
        tbMensagens.setModel(new HistoricoTabelModel(historicoAluno));
        ((JScrollPane) tbMensagens.getParent().getParent()).setColumnHeaderView(null);
        tbMensagens.setFillsViewportHeight(true);
        tbMensagens.setBackground(Color.WHITE);
        ocultarColuna(tbMensagens, 0);                    // Oculta ID
        setColunaLarguraFixa(tbMensagens, 1, 10);         // Texto com largura mínima
        setColunaLarguraFixa(tbMensagens, 2, 145);        // Data
        setColunaLarguraFixa(tbMensagens, 4, 100);        // Outra coluna

        tbMensagens.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        tbMensagens.setShowVerticalLines(false);
        tbMensagens.setShowHorizontalLines(true);
        tbMensagens.setIntercellSpacing(new Dimension(0, 1)); // controla o espaçamento entre células

        // Renderer padrão (sem borda lateral)
        TableCellRenderer rendererCentro = criarSombraRenderer(false, false);

        // Com borda esquerda (última coluna, por exemplo)
        TableCellRenderer rendererEsquerda = criarSombraRenderer(true, false);

        // Com borda direita (primeira coluna visível, por exemplo)
        TableCellRenderer rendererDireita = criarSombraRenderer(false, true);

        tbMensagens.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tbMensagens.getColumnModel().getColumn(2).setCellRenderer(rendererCentro);
        tbMensagens.getColumnModel().getColumn(3).setCellRenderer(rendererCentro);
        tbMensagens.getColumnModel().getColumn(4).setCellRenderer(rendererDireita);


    }
    
     private void setColunaLarguraFixa(JTable tabela, int coluna, int largura) {
        TableColumn col = tabela.getColumnModel().getColumn(coluna);
        col.setMinWidth(largura);
        col.setMaxWidth(largura);
        col.setPreferredWidth(largura);
        col.setResizable(false);
    }

    private void ocultarColuna(JTable tabela, int coluna) {
        setColunaLarguraFixa(tabela, coluna, 0);
    }

    private TableCellRenderer criarSombraRenderer(boolean esquerda, boolean direita) {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column
                );

                if (row == linhaMouse && !isSelected) {
                    label.setBackground(new Color(255, 255, 255));

                    int left = esquerda ? 1 : 0;
                    int right = direita ? 1 : 0;

                    label.setBorder(BorderFactory.createMatteBorder(1, left, 2, right, new Color(200, 200, 200)));
                } else {
                    label.setBackground(Color.WHITE);
                    label.setBorder(BorderFactory.createEmptyBorder());
                }

                return label;
            }
        };
    }

}
