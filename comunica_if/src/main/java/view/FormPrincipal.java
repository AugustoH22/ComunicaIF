package view;

import controller.AlunoController;
import controller.CursoController;
import controller.DepartamentoController;
import controller.NecessidadeEspecialController;
import controller.PermissaoController;
import controller.ServidorController;
import controller.TurmaController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import models.Aluno;
import models.Curso;
import models.Departamento;
import models.NecessidadeEspecial;
import models.Permissao;
import models.Servidor;
import models.Turma;

public class FormPrincipal extends javax.swing.JFrame {

    private int clique = 0;
    private int cliqueAux = 0;
    private static boolean autenticado = false;
    List<Aluno> alunos = new ArrayList();
    List<Curso> cursos = new ArrayList();
    List<Turma> turmas = new ArrayList();
    List<NecessidadeEspecial> necessidades = new ArrayList();
    List<Departamento> departamentos = new ArrayList();
    List<Permissao> permissoes = new ArrayList();
    List<Servidor> servidores = new ArrayList();
    AlunoController ac = new AlunoController();
    CursoController cc = new CursoController();
    DepartamentoController dc = new DepartamentoController();
    NecessidadeEspecialController nc = new NecessidadeEspecialController();
    PermissaoController pc = new PermissaoController();
    ServidorController sc = new ServidorController();
    TurmaController tc = new TurmaController();

    private String rota;

    public FormPrincipal() {

        alunos = ac.listarAlunos();
        cursos = cc.listarCursos();
        turmas = tc.listarTurmas();
        necessidades = nc.listarNecessidades();
        departamentos = dc.listarDepartamentos();
        permissoes = pc.listarPermissoes();
        servidores = sc.listarServidores();

        initComponents();
        tblDados.getSelectionModel().addListSelectionListener(e -> linhaselecionada());
        configurarTabela();
        cbFiltro.setVisible(false);
        BD.Conexao.conectar();
    }

    public static void setAutenticado(boolean status) {
        autenticado = status;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        Diretorio = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        Tela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        BotaoNovo = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        cbFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnAlunos = new javax.swing.JButton();
        btnCursos = new javax.swing.JButton();
        btnTurmas = new javax.swing.JButton();
        btnNecessidades = new javax.swing.JButton();
        btnServidor = new javax.swing.JButton();
        btnDepartamento = new javax.swing.JButton();
        Categoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(15, 68, 78));

        PanelSuperior.setBackground(new java.awt.Color(225, 225, 225));
        PanelSuperior.setAlignmentX(0.0F);
        PanelSuperior.setAlignmentY(0.0F);

        Diretorio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Diretorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        LogOut.setBackground(new java.awt.Color(255, 51, 51));
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("LogOut");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        Tela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaMouseClicked(evt);
            }
        });

        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDados);

        BotaoNovo.setText("Novo");
        BotaoNovo.setEnabled(false);
        BotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoActionPerformed(evt);
            }
        });

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        cbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout TelaLayout = new javax.swing.GroupLayout(Tela);
        Tela.setLayout(TelaLayout);
        TelaLayout.setHorizontalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TelaLayout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        TelaLayout.setVerticalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoNovo)
                    .addComponent(BotaoExcluir))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Diretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOut)
                .addContainerGap())
            .addComponent(Tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogOut)
                    .addComponent(Diretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        btnHome.setBackground(new java.awt.Color(23, 130, 53));
        btnHome.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnAlunos.setBackground(new java.awt.Color(23, 130, 56));
        btnAlunos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnAlunos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlunos.setText("Alunos");
        btnAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunosActionPerformed(evt);
            }
        });

        btnCursos.setBackground(new java.awt.Color(23, 130, 56));
        btnCursos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnCursos.setText("Cursos");
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });

        btnTurmas.setBackground(new java.awt.Color(23, 130, 56));
        btnTurmas.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnTurmas.setForeground(new java.awt.Color(255, 255, 255));
        btnTurmas.setText("Turmas");
        btnTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurmasActionPerformed(evt);
            }
        });

        btnNecessidades.setBackground(new java.awt.Color(23, 130, 56));
        btnNecessidades.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnNecessidades.setForeground(new java.awt.Color(255, 255, 255));
        btnNecessidades.setText("Necessidades");
        btnNecessidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNecessidadesActionPerformed(evt);
            }
        });

        btnServidor.setBackground(new java.awt.Color(23, 130, 56));
        btnServidor.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnServidor.setForeground(new java.awt.Color(255, 255, 255));
        btnServidor.setText("Servidor");
        btnServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServidorActionPerformed(evt);
            }
        });

        btnDepartamento.setBackground(new java.awt.Color(23, 130, 56));
        btnDepartamento.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        btnDepartamento.setText("Departamento");
        btnDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        Categoria.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Categoria.setForeground(new java.awt.Color(255, 255, 255));
        Categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Categoria.setText("ComunicaIF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void linhaselecionada() {
        int selectedRowIndex = tblDados.getSelectedRow();

        if (selectedRowIndex != -1) {
            BotaoExcluir.setEnabled(true);
        } else {
            BotaoExcluir.setEnabled(false);
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void btnDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentoActionPerformed
        Diretorio.setText("Departamentos");
        rota = "Departamento";
        cbFiltro.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnDepartamentoActionPerformed

    private void btnServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServidorActionPerformed
        Diretorio.setText("Servidores");
        rota = "Servidor";
        cbFiltro.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnServidorActionPerformed

    private void btnNecessidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNecessidadesActionPerformed
        Diretorio.setText("Necessidades");
        rota = "Necessidades";
        cbFiltro.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnNecessidadesActionPerformed

    private void btnTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmasActionPerformed
        Diretorio.setText("Turmas");
        rota = "Turmas";
        cbFiltro.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;

    }//GEN-LAST:event_btnTurmasActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        Diretorio.setText("Cursos");
        rota = "Cursos";
        cbFiltro.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnCursosActionPerformed

    private void btnAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunosActionPerformed
        Diretorio.setText("Alunos");
        rota = "Alunos";
        cbFiltro.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnAlunosActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

    }//GEN-LAST:event_btnHomeActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed


    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed

    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed

    }//GEN-LAST:event_LogOutActionPerformed

    private void tblDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseClicked
        contaClique();
        if (clique == 2) {
            clique = 0;
            int linhaSelecionada = tblDados.getSelectedRow();
            int aux = (int) tblDados.getValueAt(linhaSelecionada, 0);
            if ("Home".equals(rota)) {

            } else if ("Alunos".equals(rota)) {
                CadastroAluno CadastroAluno = new CadastroAluno(aux, 1, cursos, turmas, necessidades);
                CadastroAluno.setVisible(true);
            } else if ("Cursos".equals(rota)) {
                CadastroCurso CadastroCurso = new CadastroCurso(aux, 1);
                CadastroCurso.setVisible(true);
            } else if ("Turmas".equals(rota)) {
                CadastroTurma CadastroTurma = new CadastroTurma(aux, cursos, 1);
                CadastroTurma.setVisible(true);
            } else if ("Necessidades".equals(rota)) {
                CadastroNecessidade CadastroNecessidade = new CadastroNecessidade(aux, 1);
                CadastroNecessidade.setVisible(true);
            } else if ("Servidor".equals(rota)) {
                CadastroServidor CadastroServidor = new CadastroServidor(aux, departamentos, permissoes, 1);
                CadastroServidor.setVisible(true);
            } else if ("Departamento".equals(rota)) {
                CadastroDepartamento CadastroDepartamento = new CadastroDepartamento(aux, 1);
                CadastroDepartamento.setVisible(true);
            }
        }
    }//GEN-LAST:event_tblDadosMouseClicked

    private void TelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaMouseClicked
        clique = 0;
    }//GEN-LAST:event_TelaMouseClicked

    private void cbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroItemStateChanged

    }//GEN-LAST:event_cbFiltroItemStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JLabel Categoria;
    private javax.swing.JLabel Diretorio;
    private javax.swing.JButton LogOut;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPanel Tela;
    private javax.swing.JButton btnAlunos;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnDepartamento;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNecessidades;
    private javax.swing.JButton btnServidor;
    private javax.swing.JButton btnTurmas;
    private javax.swing.JComboBox cbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblDados;
    // End of variables declaration//GEN-END:variables

    private void contaClique() {
        int linhaSelecionada = tblDados.getSelectedRow();
        if (clique == 0) {
            cliqueAux = linhaSelecionada;
            clique++;
        } else {
            if (cliqueAux == linhaSelecionada) {
                clique++;
            } else {
                clique = 0;
            }
        }
    }

    private void configurarTabela() {
        if (null != rota) {
            switch (rota) {
                case "Home" ->
                    atulizarTabelaHome();
                case "Alunos" ->
                    atulizarTabelaAluno();
                case "Cursos" ->
                    atulizarTabelaCurso();
                case "Turmas" ->
                    atulizarTabelaTurma();
                case "Necessidades" ->
                    atulizarTabelaNecessidade();
                case "Servidor" ->
                    atulizarTabelaServidor();
                case "Departamento" ->
                    atulizarTabelaDepartamento();
                default -> {
                }
            }
        }
    }

    private void atulizarTabelaHome() {

    }

    private void atulizarTabelaAluno() {
        Collections.sort(alunos, Comparator.comparingInt(Aluno::getCodigo));
        tblDados.setModel(new AlunoTabelModel(alunos));
    }

    private void atulizarTabelaCurso() {
        Collections.sort(cursos, Comparator.comparingInt(Curso::getCodigo));
        tblDados.setModel(new CursoTabelModel(cursos));
    }

    private void atulizarTabelaTurma() {
        Collections.sort(turmas, Comparator.comparingInt(Turma::getCodigo));
        tblDados.setModel(new TurmaTabelModel(turmas));
    }

    private void atulizarTabelaNecessidade() {
        Collections.sort(necessidades, Comparator.comparingInt(NecessidadeEspecial::getCodigo));
        tblDados.setModel(new NecessidadeTableModel(necessidades));
    }

    private void atulizarTabelaDepartamento() {
        Collections.sort(departamentos, Comparator.comparingInt(Departamento::getCodigo));
        tblDados.setModel(new DepartamentoTabelModel(departamentos));
    }

    private void atulizarTabelaServidor() {
        Collections.sort(servidores, Comparator.comparingInt(Servidor::getCodigo));
        tblDados.setModel(new ServidorTabelModel(servidores));
    }

}
