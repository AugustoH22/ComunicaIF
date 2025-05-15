package view;

import controller.CursoController;
import javax.swing.JOptionPane;
import models.Curso;

/**
 *
 * @author pedro
 */
public class CadastroCurso extends javax.swing.JFrame {

    int codigo;
    String nome;
    boolean superior;
    int modo;
    private final CursoController cc;

    /**
     * Creates new form CadastroCurso
     *
     * @param codigo
     */
    public CadastroCurso(int codigo, String nome, boolean superior, int modo) {
        initComponents();
        this.codigo = codigo;
        this.modo = modo;
        cc = new CursoController();

        btnSalvar.setEnabled(false);
        ensinoSuperior.setEnabled(true);
        ensinoMedio.setEnabled(true);

        if (this.modo == 1) {
            this.nome = nome;
            this.superior = superior;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        ensinoSuperior = new javax.swing.JRadioButton();
        ensinoMedio = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Cursos");

        jLabel9.setText("Nome:");

        tfNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNomeCaretUpdate(evt);
            }
        });

        ensinoSuperior.setSelected(true);
        ensinoSuperior.setText("Ensino Superior");
        ensinoSuperior.setEnabled(false);
        ensinoSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensinoSuperiorActionPerformed(evt);
            }
        });

        ensinoMedio.setText("Ensino Médio");
        ensinoMedio.setToolTipText("");
        ensinoMedio.setEnabled(false);
        ensinoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensinoMedioActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(51, 153, 137));
        btnSalvar.setText("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(76, 23));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ensinoSuperior)
                        .addGap(18, 18, 18)
                        .addComponent(ensinoMedio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ensinoSuperior)
                    .addComponent(ensinoMedio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNomeCaretUpdate
        verificarCampos();
    }//GEN-LAST:event_tfNomeCaretUpdate

    private void ensinoSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensinoSuperiorActionPerformed
        RadioButtonSelected(true);
    }//GEN-LAST:event_ensinoSuperiorActionPerformed

    private void ensinoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensinoMedioActionPerformed
        RadioButtonSelected(false);
    }//GEN-LAST:event_ensinoMedioActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (modo == 0) {
            Curso curso = retornaCurso();
            cc.cadastrarCurso(curso);
        }
        if (modo == 1) {
            Curso curso = retornaCurso();
            cc.editarCurso(codigo, curso);
        }
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroCurso(0, "0", true, 0).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    public javax.swing.JRadioButton ensinoMedio;
    public javax.swing.JRadioButton ensinoSuperior;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private Curso retornaCurso() {
        nome = tfNome.getText();
        int id1 = 0;
        Curso curso = new Curso(id1, nome, superior);
        return curso;
    }

    public void RadioButtonSelected(boolean selecao) {
        if (selecao) {
            ensinoSuperior.setSelected(true);
            ensinoMedio.setSelected(false);
            superior = true;
        }
        if (!selecao) {
            ensinoSuperior.setSelected(false);
            ensinoMedio.setSelected(true);
            superior = false;
        }
    }

    private void verificarCampos() {

        btnSalvar.setEnabled(!tfNome.getText().trim().isEmpty());

    }

}
