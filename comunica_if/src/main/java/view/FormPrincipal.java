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
import tablemodel.AlunoTabelModel;
import tablemodel.CursoTabelModel;
import tablemodel.DepartamentoTabelModel;
import tablemodel.NecessidadeTableModel;
import tablemodel.ServidorTabelModel;
import tablemodel.TurmaAlunoTabelModel;
import tablemodel.TurmaTabelModel;

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
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);
        btnCadastrarTurma.setVisible(false);
        btnVincularAluno.setVisible(false);
        btnVincularServidor.setVisible(false);
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
        Tela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        BotaoNovo = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        cbCursos = new javax.swing.JComboBox();
        cbTurmas = new javax.swing.JComboBox();
        LogOut = new javax.swing.JButton();
        Categoria = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnAlunos = new javax.swing.JButton();
        btnCursos = new javax.swing.JButton();
        btnNecessidades = new javax.swing.JButton();
        btnServidor = new javax.swing.JButton();
        btnDepartamento = new javax.swing.JButton();
        btnTurmas = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        btnCadastrarTurma = new javax.swing.JButton();
        btnVincularAluno = new javax.swing.JButton();
        btnVincularServidor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        PanelSuperior.setBackground(new java.awt.Color(225, 225, 225));
        PanelSuperior.setAlignmentX(0.0F);
        PanelSuperior.setAlignmentY(0.0F);

        Diretorio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Diretorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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

        cbCursos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCursosItemStateChanged(evt);
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

        cbTurmas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTurmasItemStateChanged(evt);
            }
        });
        cbTurmas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbTurmasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout TelaLayout = new javax.swing.GroupLayout(Tela);
        Tela.setLayout(TelaLayout);
        TelaLayout.setHorizontalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TelaLayout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir))
                    .addGroup(TelaLayout.createSequentialGroup()
                        .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TelaLayout.createSequentialGroup()
                                .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        TelaLayout.setVerticalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoNovo)
                    .addComponent(BotaoExcluir))
                .addGap(18, 18, 18))
        );

        LogOut.setBackground(new java.awt.Color(255, 51, 51));
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("LogOut");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Diretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOut)
                .addGap(23, 23, 23))
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addComponent(Tela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        Categoria.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Categoria.setText("ComunicaIF");

        btnHome.setBackground(new java.awt.Color(204, 204, 204));
        btnHome.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.setBorder(null);
        btnHome.setFocusable(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnAlunos.setBackground(new java.awt.Color(204, 204, 204));
        btnAlunos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnAlunos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlunos.setText("Alunos");
        btnAlunos.setBorder(null);
        btnAlunos.setFocusable(false);
        btnAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunosActionPerformed(evt);
            }
        });

        btnCursos.setBackground(new java.awt.Color(204, 204, 204));
        btnCursos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnCursos.setText("Cursos");
        btnCursos.setBorder(null);
        btnCursos.setFocusable(false);
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });

        btnNecessidades.setBackground(new java.awt.Color(204, 204, 204));
        btnNecessidades.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnNecessidades.setForeground(new java.awt.Color(255, 255, 255));
        btnNecessidades.setText("Necessidades");
        btnNecessidades.setBorder(null);
        btnNecessidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNecessidadesActionPerformed(evt);
            }
        });

        btnServidor.setBackground(new java.awt.Color(204, 204, 204));
        btnServidor.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnServidor.setForeground(new java.awt.Color(255, 255, 255));
        btnServidor.setText("Servidor");
        btnServidor.setBorder(null);
        btnServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServidorActionPerformed(evt);
            }
        });

        btnDepartamento.setBackground(new java.awt.Color(204, 204, 204));
        btnDepartamento.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        btnDepartamento.setText("Departamento");
        btnDepartamento.setBorder(null);
        btnDepartamento.setMaximumSize(new java.awt.Dimension(139, 22));
        btnDepartamento.setMinimumSize(new java.awt.Dimension(139, 22));
        btnDepartamento.setPreferredSize(new java.awt.Dimension(139, 22));
        btnDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoActionPerformed(evt);
            }
        });

        btnTurmas.setText("Turmas");
        btnTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurmasActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator8.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator8.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator9.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator9.setForeground(new java.awt.Color(153, 153, 153));

        btnCadastrarTurma.setText("Cadastrar");
        btnCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTurmaActionPerformed(evt);
            }
        });

        btnVincularAluno.setText("Vincular Alunos");
        btnVincularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularAlunoActionPerformed(evt);
            }
        });

        btnVincularServidor.setText("Vincular Servidor");
        btnVincularServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularServidorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnServidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAlunos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTurmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnNecessidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator2)
                                    .addComponent(jSeparator4)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator6)
                                    .addComponent(jSeparator8)
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCadastrarTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVincularAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVincularServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTurmas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarTurma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVincularAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVincularServidor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnDepartamentoActionPerformed

    private void btnServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServidorActionPerformed
        Diretorio.setText("Servidores");
        rota = "Servidor";
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnServidorActionPerformed

    private void btnNecessidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNecessidadesActionPerformed
        Diretorio.setText("Necessidades");
        rota = "Necessidades";
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnNecessidadesActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        Diretorio.setText("Cursos");
        rota = "Cursos";
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnCursosActionPerformed

    private void btnAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunosActionPerformed
        Diretorio.setText("Alunos");
        rota = "Alunos";
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnAlunosActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

    }//GEN-LAST:event_btnHomeActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed

    }//GEN-LAST:event_LogOutActionPerformed

    private void TelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaMouseClicked
        clique = 0;
    }//GEN-LAST:event_TelaMouseClicked

    private void cbCursosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCursosItemStateChanged
        if (cbCursos.getSelectedItem() != null) {
            Curso curso = (Curso) cbCursos.getSelectedItem();
            cbTurmas.removeAllItems();

            if (!turmas.isEmpty()) {
                for (Turma cf : turmas) {
                    if (curso.getCodigo() == cf.getCurso().getCodigo()) {
                        cbTurmas.addItem(cf);
                    }
                }
            }
        }
    }//GEN-LAST:event_cbCursosItemStateChanged

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed

    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        if ("Home".equals(rota)) {

        } else if ("Alunos".equals(rota)) {
            CadastroAluno CadastroAluno = new CadastroAluno(0, 0, cursos, turmas, necessidades);
            CadastroAluno.setVisible(true);
        } else if ("Cursos".equals(rota)) {
            CadastroCurso CadastroCurso = new CadastroCurso(0, 0);
            CadastroCurso.setVisible(true);
        } else if ("Turmas".equals(rota)) {
            CadastroTurma CadastroTurma = new CadastroTurma(0, cursos, 0);
            CadastroTurma.setVisible(true);
        } else if ("Necessidades".equals(rota)) {
            CadastroNecessidade CadastroNecessidade = new CadastroNecessidade(0, 0);
            CadastroNecessidade.setVisible(true);
        } else if ("Servidor".equals(rota)) {
            CadastroServidor CadastroServidor = new CadastroServidor(0, departamentos, permissoes, 0);
            CadastroServidor.setVisible(true);
        } else if ("Departamento".equals(rota)) {
            CadastroDepartamento CadastroDepartamento = new CadastroDepartamento(0, 0);
            CadastroDepartamento.setVisible(true);
        }
    }//GEN-LAST:event_BotaoNovoActionPerformed

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

    private void btnTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmasActionPerformed
        if (btnTurmas.isSelected()) {
            btnCadastrarTurma.setVisible(true);
            btnVincularAluno.setVisible(true);
            btnVincularServidor.setVisible(true);
        } else {
            btnCadastrarTurma.setVisible(false);
            btnVincularAluno.setVisible(false);
            btnVincularServidor.setVisible(false);
        }
    }//GEN-LAST:event_btnTurmasActionPerformed

    private void btnVincularAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularAlunoActionPerformed
        Diretorio.setText("Turmas");
        rota = "TurmaAluno";
        cbCursos.setVisible(true);
        cbTurmas.setVisible(true);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnVincularAlunoActionPerformed

    private void btnVincularServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularServidorActionPerformed
        Diretorio.setText("Turmas");
        rota = "TurmaServidor";
        cbCursos.setVisible(true);
        cbTurmas.setVisible(true);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnVincularServidorActionPerformed

    private void btnCadastrarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarTurmaActionPerformed
        Diretorio.setText("Turmas");
        rota = "Turmas";
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnCadastrarTurmaActionPerformed

    private void cbTurmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTurmasItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurmasItemStateChanged

    private void cbCursosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCursosAncestorAdded

        cbCursos.removeAll();

        if (!cursos.isEmpty()) {
            for (Curso cf : cursos) {
                cbCursos.addItem(cf);
            }
        }

    }//GEN-LAST:event_cbCursosAncestorAdded

    private void cbTurmasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbTurmasAncestorAdded

    }//GEN-LAST:event_cbTurmasAncestorAdded

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
    private javax.swing.JButton btnCadastrarTurma;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnDepartamento;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNecessidades;
    private javax.swing.JButton btnServidor;
    private javax.swing.JToggleButton btnTurmas;
    private javax.swing.JButton btnVincularAluno;
    private javax.swing.JButton btnVincularServidor;
    private javax.swing.JComboBox cbCursos;
    private javax.swing.JComboBox cbTurmas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
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
                case "TurmaAluno" ->
                    atulizarTabelaDepartamento();
                case "TurmaServidor" ->
                    atulizarTabelaDepartamento();
                default -> {
                }
            }
        }
    }

    private void atulizarTabelaHome() {
        int linhaSelecionada = tblDados.getSelectedRow();
        int aux = (int) tblDados.getValueAt(linhaSelecionada, 0);
        AddAluno NewJFrame2 = new AddAluno(aux);
        NewJFrame2.setVisible(true);

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
    
    private void atulizarTabelaTurmaAluno() {
        if (cbTurmas.getSelectedItem() != null) {
            Turma turma = (Turma) cbTurmas.getSelectedItem();
            tblDados.setModel(new TurmaAlunoTabelModel(turma.getCodigo()));
        }     
    }

}
