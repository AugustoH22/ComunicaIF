package view;

import controller.AlunoController;
import controller.EnturmacaoController;
import controller.TurmaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Curso;
import models.Enturmacao;
import models.NecessidadeEspecial;
import models.Turma;

public class CadastroAluno extends javax.swing.JDialog {

    int codigo;
    int modo;
    String nome;
    List<Curso> listaCursos = new ArrayList<>();
    List<Turma> listaTurmas = new ArrayList<>();
    List<NecessidadeEspecial> listaNecessidades = new ArrayList<>();
    List<NecessidadeEspecial> necessidades = new ArrayList<>();
    String ano;
    String semestre;
    private final AlunoController ac;
    private final EnturmacaoController ec;

    public CadastroAluno(int codigo, int modo, List<Curso> cursos, List<Turma> turmas, List<NecessidadeEspecial> necessidades) {
        initComponents();
        this.codigo = codigo;
        this.modo = modo;
        ac = new AlunoController();
        ec = new EnturmacaoController();

        btnSalvar.setEnabled(false);

        if (!cursos.isEmpty() && !turmas.isEmpty() && !necessidades.isEmpty()) {
            listaCursos = cursos;
            listaTurmas = turmas;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbNecessidades = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        cbCursos = new javax.swing.JComboBox();
        cbTurma = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbAno = new javax.swing.JComboBox();
        cbSemestre = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        tfNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNomeCaretUpdate(evt);
            }
        });

        jLabel3.setText("Curso:");

        jLabel5.setText("Turma:");

        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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

        cbCursos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbCursosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        cbTurma.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbTurmaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel6.setText("Ano:");

        jLabel7.setText("Semestre:");

        cbAno.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbAnoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        cbSemestre.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbSemestreAncestorAdded(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbAno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cbSemestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(cbNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(23, 23, 23))
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
 
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tfNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNomeCaretUpdate
       //  verificarCampos();
    }//GEN-LAST:event_tfNomeCaretUpdate

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
      jTable2.setModel(new NecessidadeTableModel(necessidades));
    }//GEN-LAST:event_jTable2AncestorAdded

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbNecessidadesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbNecessidadesAncestorAdded
        if (modo == 0) {
            cbNecessidades.removeAll();

            if (!listaNecessidades.isEmpty()) {
                for (NecessidadeEspecial cf : listaNecessidades) {
                    cbNecessidades.addItem(cf);
                }
            }
        }
    }//GEN-LAST:event_cbNecessidadesAncestorAdded

    private void cbCursosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCursosAncestorAdded
        if (modo == 0) {
            cbCursos.removeAll();

            if (!listaCursos.isEmpty()) {
                for (Curso cf : listaCursos) {
                    cbCursos.addItem(cf);
                }
            }
        }
    }//GEN-LAST:event_cbCursosAncestorAdded

    private void cbTurmaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbTurmaAncestorAdded
        if (modo == 0) {
            cbTurma.removeAll();

            if (!listaTurmas.isEmpty()) {
                for (Turma cf : listaTurmas) {
                    cbTurma.addItem(cf);
                }
            }
        }
    }//GEN-LAST:event_cbTurmaAncestorAdded

    private void cbAnoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbAnoAncestorAdded
        List<String> listaAnos = new ArrayList<>();
        listaAnos.add("1° Ano");
        listaAnos.add("2° Ano");
        listaAnos.add("3° Ano");

        if (modo == 0) {
            cbAno.removeAll();

            if (!listaAnos.isEmpty()) {
                for (String cf : listaAnos) {
                    cbAno.addItem(cf);
                }
            }
        }
    }//GEN-LAST:event_cbAnoAncestorAdded

    private void cbSemestreAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbSemestreAncestorAdded
        List<String> listaSemestre = new ArrayList<>();
        listaSemestre.add("1° Semestre");
        listaSemestre.add("2° Semestre");

        if (modo == 0) {
            cbSemestre.removeAll();

            if (!listaSemestre.isEmpty()) {
                for (String cf : listaSemestre) {
                    cbSemestre.addItem(cf);
                }
            }
        }
    }//GEN-LAST:event_cbSemestreAncestorAdded

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            List<Curso> c = new ArrayList<>();
            List<Turma> t = new ArrayList<>();
            List<NecessidadeEspecial> n = new ArrayList<>();
            
            CadastroAluno dialog = new CadastroAluno(0,0,c,t,n);
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
    private javax.swing.JComboBox cbAno;
    private javax.swing.JComboBox cbCursos;
    private javax.swing.JComboBox cbNecessidades;
    private javax.swing.JComboBox cbSemestre;
    private javax.swing.JComboBox cbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    public javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void verificarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
