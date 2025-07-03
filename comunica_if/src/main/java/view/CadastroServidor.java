package view;

import controller.ServidorController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Departamento;
import models.Permissao;
import models.Servidor;


public class CadastroServidor extends javax.swing.JFrame {

    int codigo;
    int modo;
    String nome;
    String usuario;
    List<Departamento> listaDepartamento = new ArrayList<>();
    List<Permissao> listaPermissao = new ArrayList<>();
    private final ServidorController sc;

    public CadastroServidor(int codigo, List<Departamento> listaDepartamento, List<Permissao> listaPermissao, int modo) {
        initComponents();
        this.codigo = codigo;
        this.modo = modo;
        sc = new ServidorController();
        
        if(!listaDepartamento.isEmpty()){
            this.listaDepartamento = listaDepartamento;
        }
        
        if(!listaPermissao.isEmpty()){
            this.listaPermissao = listaPermissao;
        }

        btnSalvar.setEnabled(false);

        if (this.modo == 1) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbPermissao = new javax.swing.JComboBox();
        cbDepartamento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Necessidades");

        jLabel9.setText("Nome:");

        tfNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNomeCaretUpdate(evt);
            }
        });

        jLabel10.setText("Usuário:");

        tfUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfUsuarioCaretUpdate(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(76, 23));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(72, 25));
        btnCancelar.setMinimumSize(new java.awt.Dimension(72, 25));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbPermissao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPermissaoItemStateChanged(evt);
            }
        });
        cbPermissao.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbPermissaoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        cbDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepartamentoItemStateChanged(evt);
            }
        });
        cbDepartamento.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbDepartamentoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel7.setText("Departamento:");

        jLabel8.setText("Permissão:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfNome)
            .addComponent(tfUsuario)
            .addComponent(cbDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cbPermissao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNomeCaretUpdate
        verificarCampos();
    }//GEN-LAST:event_tfNomeCaretUpdate

    private void cbDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepartamentoItemStateChanged
        verificarCampos();
    }//GEN-LAST:event_cbDepartamentoItemStateChanged

    private void cbDepartamentoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbDepartamentoAncestorAdded
        if (modo == 0) {
            cbDepartamento.removeAll();

            if (!listaDepartamento.isEmpty()) {
                for (Departamento cf : listaDepartamento) {
                    cbDepartamento.addItem(cf);
                }
            }
        }
    }//GEN-LAST:event_cbDepartamentoAncestorAdded

    private void cbPermissaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPermissaoItemStateChanged
        verificarCampos();
    }//GEN-LAST:event_cbPermissaoItemStateChanged

    private void cbPermissaoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbPermissaoAncestorAdded
        if (modo == 0) {
            cbPermissao.removeAll();

            if (!listaPermissao.isEmpty()) {
                for (Permissao cf : listaPermissao) {
                    cbPermissao.addItem(cf);
                }
            }
        }
    }//GEN-LAST:event_cbPermissaoAncestorAdded

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (modo == 0) {
            Servidor servidor = retornaServidor();
            sc.cadastrarServidor(servidor);
        }
        if (modo == 1) {
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

    private void tfUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfUsuarioCaretUpdate
       verificarCampos();
    }//GEN-LAST:event_tfUsuarioCaretUpdate

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            List<Departamento> listaDepartamento1 = new ArrayList<>();
            List<Permissao> listaPermissao1 = new ArrayList<>();
            new CadastroServidor(0, listaDepartamento1, listaPermissao1, 0).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbDepartamento;
    private javax.swing.JComboBox cbPermissao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField tfNome;
    public javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    private Servidor retornaServidor() {
        nome = tfNome.getText();
        usuario = tfUsuario.getText();
        System.out.print(usuario);
        Departamento departamento = (Departamento) cbDepartamento.getSelectedItem();
        Permissao permissao = (Permissao) cbPermissao.getSelectedItem();
        int id1 = 0;

        Servidor servidor = new Servidor(id1, nome, usuario, "123456", departamento, permissao);

        return servidor;
    }

    private void verificarCampos() {

        boolean camposPreenchidos = !tfNome.getText().trim().isEmpty()
                && !tfUsuario.getText().trim().isEmpty()
                && cbDepartamento.getSelectedItem() != null
                && cbPermissao.getSelectedItem() != null;

        // Habilita o botão "Salvar" somente quando todas as condições são atendidas
        btnSalvar.setEnabled(camposPreenchidos);

    }

}
