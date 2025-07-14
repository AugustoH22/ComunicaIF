package view;

import controller.ServidorController;
import java.awt.CardLayout;
import models.Servidor;

public class Login extends javax.swing.JFrame {

    private final ServidorController sc;
    Servidor user;
    public Login() {
        initComponents();
        sc = new ServidorController();
        CardLayout layout = (CardLayout) tela.getLayout();
        tela.add(telaLogin, "login");
        tela.add(telaAlterarSenha, "senha");
        layout.show(tela, "login");
        setLocationRelativeTo(null);

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tela = new javax.swing.JPanel();
        telaLogin = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Categoria = new javax.swing.JLabel();
        Complemento = new javax.swing.JLabel();
        TextLogin = new javax.swing.JLabel();
        Login = new javax.swing.JTextField();
        TextSenha = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        BotaoEntrar = new javax.swing.JButton();
        telaAlterarSenha = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Categoria1 = new javax.swing.JLabel();
        Complemento1 = new javax.swing.JLabel();
        TextLogin1 = new javax.swing.JLabel();
        TextSenha1 = new javax.swing.JLabel();
        confirmarSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        novaSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tela.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(15, 68, 78));
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);

        Categoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Categoria.setForeground(new java.awt.Color(255, 255, 255));
        Categoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Categoria.setText("Fazer Login");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Complemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Complemento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Complemento.setText("Forneça seu Login e Senha para entrar.");

        TextLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextLogin.setText("Usuário:");

        Login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        TextSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextSenha.setText("Senha:");

        Senha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Senha.setToolTipText("");
        Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SenhaKeyPressed(evt);
            }
        });

        BotaoEntrar.setBackground(new java.awt.Color(15, 68, 78));
        BotaoEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoEntrar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEntrar.setText("Entrar");
        BotaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telaLoginLayout = new javax.swing.GroupLayout(telaLogin);
        telaLogin.setLayout(telaLoginLayout);
        telaLoginLayout.setHorizontalGroup(
            telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(telaLoginLayout.createSequentialGroup()
                .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaLoginLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Complemento))
                    .addGroup(telaLoginLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaLoginLayout.createSequentialGroup()
                                .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(148, 148, 148))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaLoginLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Senha)
                                    .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(BotaoEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        telaLoginLayout.setVerticalGroup(
            telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaLoginLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Complemento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(TextLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BotaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        tela.add(telaLogin, "card2");

        jPanel5.setBackground(new java.awt.Color(15, 68, 78));
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);

        Categoria1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Categoria1.setForeground(new java.awt.Color(255, 255, 255));
        Categoria1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Categoria1.setText("Alterar Senha");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Categoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Categoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Complemento1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Complemento1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Complemento1.setText("Digite uma Nova Senha");

        TextLogin1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextLogin1.setText("Nova Senha:");

        TextSenha1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextSenha1.setText("Confirmar Senha:");

        confirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        confirmarSenha.setToolTipText("");
        confirmarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmarSenhaKeyPressed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(15, 68, 78));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        novaSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        novaSenha.setToolTipText("");

        javax.swing.GroupLayout telaAlterarSenhaLayout = new javax.swing.GroupLayout(telaAlterarSenha);
        telaAlterarSenha.setLayout(telaAlterarSenhaLayout);
        telaAlterarSenhaLayout.setHorizontalGroup(
            telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(telaAlterarSenhaLayout.createSequentialGroup()
                .addGroup(telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaAlterarSenhaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Complemento1))
                    .addGroup(telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAlterarSenhaLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addGroup(telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(confirmarSenha)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(novaSenha)))
                        .addGroup(telaAlterarSenhaLayout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addGroup(telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TextLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(81, 81, 81))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        telaAlterarSenhaLayout.setVerticalGroup(
            telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAlterarSenhaLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Complemento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(TextLogin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(novaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextSenha1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        tela.add(telaAlterarSenha, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SenhaKeyPressed

        // Verifica se a tecla pressionada é o Enter
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Dispara a ação associada ao botão de entrar
            BotaoEntrarActionPerformed(null);
        }
    }//GEN-LAST:event_SenhaKeyPressed

    private void BotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarActionPerformed
        if (("".equals(Login.getText())) || ("".equals(Senha.getText()))) {
            Complemento.setText("Não esqueça de fornecer todas as credenciais para entrar!");
        } else {
            String usuario = Login.getText();
            String senha = Senha.getText();
            boolean Logou = sc.verificarLogin(usuario, senha);
            if (!Logou) {
                Complemento.setText("Usuário ou senha incorretos");
            } else {

                user = sc.buscarPorUsuario(usuario);

                if (user.isPrimeiroLogin()) {
                    System.out.print("Entro no IF");
                    CardLayout layout = (CardLayout) tela.getLayout();
                    layout.show(tela, "senha");

                } else {

                    // Fecha a janela atual
                    this.dispose();

                    // Cria e exibe a nova janela na posição capturada
                    FormPrincipal formPrincipal = new FormPrincipal(user.getCodigo());
                    formPrincipal.setVisible(true);
                }                // Captura a posição da janela atual

            }
        }
    }//GEN-LAST:event_BotaoEntrarActionPerformed

    private void confirmarSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarSenhaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Dispara a ação associada ao botão de entrar
            btnSalvarActionPerformed(null);
        }
    }//GEN-LAST:event_confirmarSenhaKeyPressed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (("".equals(novaSenha.getText())) || ("".equals(confirmarSenha.getText()))) {
            Complemento.setText("Não esqueça de fornecer todas as credenciais para entrar!");
        } else {
            String senha = novaSenha.getText();
            String aux = confirmarSenha.getText();

            if (senha.equals(aux)) {
                
                sc.alterarSenha(user.getUsuario(), senha);

                // Fecha a janela atual
                this.dispose();

                // Cria e exibe a nova janela na posição capturada
                FormPrincipal formPrincipal = new FormPrincipal(user.getCodigo());
                formPrincipal.setVisible(true);

            } else {
                Complemento.setText("Senha digitas são diferentes");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JLabel Categoria;
    private javax.swing.JLabel Categoria1;
    private javax.swing.JLabel Complemento;
    private javax.swing.JLabel Complemento1;
    private javax.swing.JTextField Login;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JLabel TextLogin;
    private javax.swing.JLabel TextLogin1;
    private javax.swing.JLabel TextSenha;
    private javax.swing.JLabel TextSenha1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPasswordField confirmarSenha;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField novaSenha;
    private javax.swing.JPanel tela;
    private javax.swing.JPanel telaAlterarSenha;
    private javax.swing.JPanel telaLogin;
    // End of variables declaration//GEN-END:variables
}
