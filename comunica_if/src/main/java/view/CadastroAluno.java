package view;

import controller.AlunoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Aluno;
import models.Curso;
import models.NecessidadeEspecial;
import models.Turma;
import tablemodel.NecessidadeTableModel;

public class CadastroAluno extends javax.swing.JDialog {

    int codigo;
    int modo;
    String nome;
    List<Curso> listaCursos = new ArrayList<>();
    List<Turma> listaTurmas = new ArrayList<>();
    List<NecessidadeEspecial> listaNecessidades = new ArrayList<>();
    List<NecessidadeEspecial> necessidades = new ArrayList<>();
    Aluno a;
    private final AlunoController ac;

    public CadastroAluno(java.awt.Frame parent, boolean modal, int codigo, int modo, List<Curso> cursos, List<Turma> turmas, List<NecessidadeEspecial> necessidades) {
        super(parent, modal);
        initComponents();
        this.codigo = codigo;
        this.modo = modo;
        ac = new AlunoController();

        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);

        if (!necessidades.isEmpty()) {
            listaNecessidades = necessidades;
        }

        if (modo == 1) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbNecessidades = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        tfNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNomeCaretUpdate(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(51, 153, 137));
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Necessidades:");

        cbNecessidades.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbNecessidadesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbNecessidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNecessidadesActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(tfNome))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(cbNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (modo == 0) {
            Aluno aluno = retornaAluno();
            ac.cadastrarAluno(aluno);
        }
        if (modo == 1) {
            Aluno aluno = retornaAluno();
            aluno.setCodigo(codigo);
            ac.atualizarAluno(a);
        }
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tfNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNomeCaretUpdate
        verificarCampos();
    }//GEN-LAST:event_tfNomeCaretUpdate

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            // Verificar se há algum ActionListener no ComboBox antes de removê-lo
            if (cbNecessidades.getActionListeners().length > 0) {
                cbNecessidades.removeActionListener(cbNecessidades.getActionListeners()[0]);
            }

            if (cbNecessidades.getSelectedItem() != null) {
                NecessidadeEspecial necessidadeSelecionada = (NecessidadeEspecial) cbNecessidades.getSelectedItem();

                // Verificar se a necessidade já está na lista 'necessidades'
                boolean necessidadeExiste = false;
                for (NecessidadeEspecial n : necessidades) {
                    if (n.getCodigo() == necessidadeSelecionada.getCodigo()) {
                        necessidadeExiste = true;
                        break;
                    }
                }

                if (!necessidadeExiste) {
                    NecessidadeEspecial novaNecessidade = new NecessidadeEspecial(
                            necessidadeSelecionada.getCodigo(),
                            necessidadeSelecionada.getCodigoNecessidade(),
                            necessidadeSelecionada.getDescricao()
                    );
                    necessidades.add(novaNecessidade);
                }

                // Atualizar a tabela com as necessidades
                jTable2.setModel(new NecessidadeTableModel(necessidades));

                // Atualizar outros componentes visuais se necessário
                verificarCampos(); // Você pode manter ou adaptar essa função conforme sua lógica

                if (!necessidades.isEmpty()) {
                    btnExcluir.setEnabled(true);
                }
            }
        } finally {
            // Adicionar novamente o ActionListener no ComboBox
            if (cbNecessidades.getActionListeners().length > 0) {
                cbNecessidades.addActionListener(cbNecessidades.getActionListeners()[0]);
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        jTable2.setModel(new NecessidadeTableModel(necessidades));
    }//GEN-LAST:event_jTable2AncestorAdded

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            int linhaSelecionada = jTable2.getSelectedRow();
            int codigoSelecionado = (int) jTable2.getValueAt(linhaSelecionada, 0); // Supondo que a coluna 0 é o código

            // Buscar a necessidade correspondente na lista
            NecessidadeEspecial necessidadeParaRemover = null;
            for (NecessidadeEspecial n : necessidades) {
                if (n.getCodigo() == codigoSelecionado) {
                    necessidadeParaRemover = n;
                    break;
                }
            }

            if (necessidadeParaRemover != null) {
                necessidades.remove(necessidadeParaRemover);
                jTable2.setModel(new NecessidadeTableModel(necessidades));
                verificarCampos(); // Se houver validações adicionais

                if (necessidades.isEmpty()) {
                    btnExcluir.setEnabled(false);
                }
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbNecessidadesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbNecessidadesAncestorAdded
        cbNecessidades.removeAll();
        cbNecessidades.addItem("Selecione..."); // ou new NecessidadeEspecial(0, "Selecione...")

        for (NecessidadeEspecial cf : listaNecessidades) {
            cbNecessidades.addItem(cf);
        }

        cbNecessidades.setSelectedIndex(0); // ou -1 se quiser deixar sem nenhum selecionado

    }//GEN-LAST:event_cbNecessidadesAncestorAdded

    private void cbCursosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCursosAncestorAdded

    }//GEN-LAST:event_cbCursosAncestorAdded

    private void cbTurmaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbTurmaAncestorAdded

    }//GEN-LAST:event_cbTurmaAncestorAdded

    private void cbAnoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbAnoAncestorAdded

    }//GEN-LAST:event_cbAnoAncestorAdded

    private void cbSemestreAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbSemestreAncestorAdded

    }//GEN-LAST:event_cbSemestreAncestorAdded

    private void cbNecessidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNecessidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNecessidadesActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            List<Curso> c = new ArrayList<>();
            List<Turma> t = new ArrayList<>();
            List<NecessidadeEspecial> n = new ArrayList<>();

            CadastroAluno dialog = new CadastroAluno(new javax.swing.JFrame(), true, 0, 0, c, t, n);
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
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbNecessidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    public javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void verificarCampos() {
        btnSalvar.setEnabled(!tfNome.getText().trim().isEmpty());
    }

    private Aluno retornaAluno() {

        Aluno aux = new Aluno(0, tfNome.getText(), necessidades);

        return aux;

    }

}
