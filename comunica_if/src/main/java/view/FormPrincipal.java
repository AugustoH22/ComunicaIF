package view;

import controller.AlunoController;
import controller.CursoController;
import controller.DepartamentoController;
import controller.MensagemController;
import controller.NecessidadeEspecialController;
import controller.PermissaoController;
import controller.ServidorController;
import controller.TurmaController;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import models.Aluno;
import models.Curso;
import models.Departamento;
import models.Mensagem;
import models.NecessidadeEspecial;
import models.Permissao;
import models.Servidor;
import models.Turma;
import observer.MensagemListener;
import tablemodel.AlunoTabelModel;
import tablemodel.CursoTabelModel;
import tablemodel.DepartamentoTabelModel;
import tablemodel.MensagemTabelModel;
import tablemodel.NecessidadeTableModel;
import tablemodel.ServidorTabelModel;
import tablemodel.TurmaAlunoTabelModel;
import tablemodel.TurmaServidorTabelModel;
import tablemodel.TurmaTabelModel;

public class FormPrincipal extends javax.swing.JFrame {

    private int clique = 0;
    private int cliqueAux = 0;
    private static boolean autenticado = false;
    List<Mensagem> mensagens = new ArrayList();
    List<Aluno> alunos = new ArrayList();
    List<Curso> cursos = new ArrayList();
    List<Turma> turmas = new ArrayList();
    private int linhaMouse = -1;
    List<NecessidadeEspecial> necessidades = new ArrayList();
    List<Departamento> departamentos = new ArrayList();
    List<Permissao> permissoes = new ArrayList();
    List<Servidor> servidores = new ArrayList();
    MensagemController mc = new MensagemController();
    AlunoController ac = new AlunoController();
    CursoController cc = new CursoController();
    DepartamentoController dc = new DepartamentoController();
    NecessidadeEspecialController nc = new NecessidadeEspecialController();
    Servidor user;
    PermissaoController pc = new PermissaoController();
    ServidorController sc = new ServidorController();
    TurmaController tc = new TurmaController();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

    private String rota;

    public FormPrincipal() {

        user = sc.buscarServidorPorId(5);
        mensagens = mc.buscarMensagemPorDestinatario(user);
        alunos = ac.listarAlunos();
        cursos = cc.listarCursos();
        turmas = tc.listarTurmas();
        necessidades = nc.listarNecessidades();
        departamentos = dc.listarDepartamentos();
        permissoes = pc.listarPermissoes();
        servidores = sc.listarServidores();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        initComponents();
        tblDados.getSelectionModel().addListSelectionListener(e -> linhaselecionada());
        tblDados.setRowHeight(30);
        configurarTabela();
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);
        btnCadastrarTurma.setVisible(false);
        btnVincularAluno.setVisible(false);
        btnVincularServidor.setVisible(false);
        btnResponder.setEnabled(false);
        btnResponder.setVisible(false);
        BD.Conexao.conectar();

        Runnable callback = this::configurarTabela;

        MensagemListener listener = new MensagemListener(callback);
        listener.start();

        CardLayout layout = (CardLayout) tela.getLayout();
        tela.add(telaListar, "lista");
        tela.add(telaMensagem, "mensagem");

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
        tela = new javax.swing.JPanel();
        telaListar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        BotaoNovo = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        cbCursos = new javax.swing.JComboBox();
        cbTurmas = new javax.swing.JComboBox();
        telaMensagem = new javax.swing.JPanel();
        btnResponder = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        panel1 = new java.awt.Panel();
        remetenteUsuario = new java.awt.Label();
        dataMensagem = new java.awt.Label();
        alunosMensagem = new javax.swing.JLabel();
        ocorrencia = new javax.swing.JLabel();
        remetenteMensagem = new javax.swing.JLabel();
        assuntoMensagem = new javax.swing.JLabel();
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

        tela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaMouseClicked(evt);
            }
        });
        tela.setLayout(new java.awt.CardLayout());

        telaListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaListarMouseClicked(evt);
            }
        });

        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblDadosMouseMoved(evt);
            }
        });
        tblDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDadosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblDadosMouseExited(evt);
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

        javax.swing.GroupLayout telaListarLayout = new javax.swing.GroupLayout(telaListar);
        telaListar.setLayout(telaListarLayout);
        telaListarLayout.setHorizontalGroup(
            telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaListarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaListarLayout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir))
                    .addGroup(telaListarLayout.createSequentialGroup()
                        .addGroup(telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaListarLayout.createSequentialGroup()
                                .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        telaListarLayout.setVerticalGroup(
            telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaListarLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoNovo)
                    .addComponent(BotaoExcluir))
                .addGap(18, 18, 18))
        );

        tela.add(telaListar, "card7");

        telaMensagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaMensagemMouseClicked(evt);
            }
        });

        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        scrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        scrollPane1.setName(""); // NOI18N

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        remetenteUsuario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        remetenteUsuario.setForeground(new java.awt.Color(204, 204, 204));
        remetenteUsuario.setName(""); // NOI18N
        remetenteUsuario.setText("<remetente@gmail.com>");

        dataMensagem.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dataMensagem.setForeground(new java.awt.Color(51, 51, 51));
        dataMensagem.setName(""); // NOI18N
        dataMensagem.setText("dia., XX de XXX., XX:XX (há X dias)");

        alunosMensagem.setText("Alunos");

        ocorrencia.setText("Ocorrência");
        ocorrencia.setToolTipText("");

        remetenteMensagem.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        remetenteMensagem.setText("Assunto");

        assuntoMensagem.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        assuntoMensagem.setText("Assunto");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(assuntoMensagem)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(remetenteMensagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
                                .addComponent(dataMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(alunosMensagem)
                            .addComponent(ocorrencia))
                        .addContainerGap(298, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(assuntoMensagem)
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remetenteMensagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(alunosMensagem)
                .addGap(31, 31, 31)
                .addComponent(ocorrencia)
                .addContainerGap(397, Short.MAX_VALUE))
        );

        scrollPane1.add(panel1);

        javax.swing.GroupLayout telaMensagemLayout = new javax.swing.GroupLayout(telaMensagem);
        telaMensagem.setLayout(telaMensagemLayout);
        telaMensagemLayout.setHorizontalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMensagemLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaMensagemLayout.createSequentialGroup()
                        .addGap(757, 757, 757)
                        .addComponent(btnResponder)
                        .addGap(5, 25, Short.MAX_VALUE))
                    .addGroup(telaMensagemLayout.createSequentialGroup()
                        .addGroup(telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoltar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        telaMensagemLayout.setVerticalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMensagemLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResponder)
                .addGap(18, 18, 18))
        );

        tela.add(telaMensagem, "card7");

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
                .addComponent(tela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        btnNecessidades.setFocusable(false);
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
        btnServidor.setFocusable(false);
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
        btnDepartamento.setFocusable(false);
        btnDepartamento.setMaximumSize(new java.awt.Dimension(139, 22));
        btnDepartamento.setMinimumSize(new java.awt.Dimension(139, 22));
        btnDepartamento.setPreferredSize(new java.awt.Dimension(139, 22));
        btnDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoActionPerformed(evt);
            }
        });

        btnTurmas.setText("Turmas");
        btnTurmas.setFocusable(false);
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
        btnCadastrarTurma.setFocusable(false);
        btnCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTurmaActionPerformed(evt);
            }
        });

        btnVincularAluno.setText("Vincular Alunos");
        btnVincularAluno.setFocusable(false);
        btnVincularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularAlunoActionPerformed(evt);
            }
        });

        btnVincularServidor.setText("Vincular Servidor");
        btnVincularServidor.setFocusPainted(false);
        btnVincularServidor.setFocusable(false);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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


    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        configurarTabela();
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
        Diretorio.setText("Home");
        rota = "Home";
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);

        configurarTabela();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnHomeActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed

    }//GEN-LAST:event_LogOutActionPerformed

    private void telaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaMouseClicked
        clique = 0;
    }//GEN-LAST:event_telaMouseClicked

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
        BotaoNovo.setText("Adicionar");
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
        BotaoNovo.setText("Adicionar");
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
        BotaoNovo.setText("Novo");
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnCadastrarTurmaActionPerformed

    private void tblDadosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseMoved
        int linha = tblDados.rowAtPoint(evt.getPoint());
        if (linha != linhaMouse) {
            linhaMouse = linha;
            tblDados.repaint();
        }
    }//GEN-LAST:event_tblDadosMouseMoved

    private void tblDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseClicked
        contaClique();
        if (clique == 2) {
            clique = 0;
            int linhaSelecionada = tblDados.getSelectedRow();
            int aux = (int) tblDados.getValueAt(linhaSelecionada, 0);
            if (null != rota) switch (rota) {
                case "Home" -> mostrarMensagem(aux);
                case "Alunos" -> {
                    CadastroAluno CadastroAluno = new CadastroAluno(aux, 1, cursos, turmas, necessidades);
                    CadastroAluno.setVisible(true);
                }
                case "Cursos" -> {
                    CadastroCurso CadastroCurso = new CadastroCurso(aux, 1);
                    CadastroCurso.setVisible(true);
                }
                case "Turmas" -> {
                    CadastroTurma CadastroTurma = new CadastroTurma(aux, cursos, 1);
                    CadastroTurma.setVisible(true);
                }
                case "Necessidades" -> {
                    CadastroNecessidade CadastroNecessidade = new CadastroNecessidade(aux, 1);
                    CadastroNecessidade.setVisible(true);
                }
                case "Servidor" -> {
                    CadastroServidor CadastroServidor = new CadastroServidor(aux, departamentos, permissoes, 1);
                    CadastroServidor.setVisible(true);
                }
                case "Departamento" -> {
                    CadastroDepartamento CadastroDepartamento = new CadastroDepartamento(aux, 1);
                    CadastroDepartamento.setVisible(true);
                }
                default -> {
                }
            }
        }
    }//GEN-LAST:event_tblDadosMouseClicked

    private void tblDadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseExited
        linhaMouse = -1;
        tblDados.repaint();
    }//GEN-LAST:event_tblDadosMouseExited

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        if (null != rota) switch (rota) {
            case "Home" -> {
                EnvioMensagem EnvioMensagem = new EnvioMensagem(user);
                EnvioMensagem.setVisible(true);
            }
            case "Alunos" -> {
                CadastroAluno CadastroAluno = new CadastroAluno(0, 0, cursos, turmas, necessidades);
                CadastroAluno.setVisible(true);
            }
            case "Cursos" -> {
                CadastroCurso CadastroCurso = new CadastroCurso(0, 0);
                CadastroCurso.setVisible(true);
            }
            case "Turmas" -> {
                CadastroTurma CadastroTurma = new CadastroTurma(0, cursos, 0);
                CadastroTurma.setVisible(true);
            }
            case "Necessidades" -> {
                CadastroNecessidade CadastroNecessidade = new CadastroNecessidade(0, 0);
                CadastroNecessidade.setVisible(true);
            }
            case "Servidor" -> {
                CadastroServidor CadastroServidor = new CadastroServidor(0, departamentos, permissoes, 0);
                CadastroServidor.setVisible(true);
            }
            case "Departamento" -> {
                CadastroDepartamento CadastroDepartamento = new CadastroDepartamento(0, 0);
                CadastroDepartamento.setVisible(true);
            }
            case "TurmaAluno" -> {
                if (cbTurmas.getSelectedItem() != null) {
                    Turma turma = (Turma) cbTurmas.getSelectedItem();
                    AddAluno AddAluno = new AddAluno(turma.getCodigo());
                    AddAluno.setVisible(true);
                }
            }
            case "TurmaServidor" -> {
                if (cbTurmas.getSelectedItem() != null) {
                    Turma turma = (Turma) cbTurmas.getSelectedItem();
                    AddServidor AddServidor = new AddServidor(turma.getCodigo());
                    AddServidor.setVisible(true);
                }
            }
            default -> {
            }
        }
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoExcluirActionPerformed

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

    private void cbCursosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCursosAncestorAdded
        cbCursos.removeAll();

        if (!cursos.isEmpty()) {
            for (Curso cf : cursos) {
                cbCursos.addItem(cf);
            }
        }
    }//GEN-LAST:event_cbCursosAncestorAdded

    private void cbTurmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTurmasItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurmasItemStateChanged

    private void cbTurmasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbTurmasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurmasAncestorAdded

    private void telaListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaListarMouseClicked
        clique = 0;
    }//GEN-LAST:event_telaListarMouseClicked

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResponderActionPerformed

    private void telaMensagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaMensagemMouseClicked
        clique = 0;
    }//GEN-LAST:event_telaMensagemMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");
    }//GEN-LAST:event_btnVoltarActionPerformed

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
    private javax.swing.JLabel alunosMensagem;
    private javax.swing.JLabel assuntoMensagem;
    private javax.swing.JButton btnAlunos;
    private javax.swing.JButton btnCadastrarTurma;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnDepartamento;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNecessidades;
    private javax.swing.JButton btnResponder;
    private javax.swing.JButton btnServidor;
    private javax.swing.JToggleButton btnTurmas;
    private javax.swing.JButton btnVincularAluno;
    private javax.swing.JButton btnVincularServidor;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbCursos;
    private javax.swing.JComboBox cbTurmas;
    private java.awt.Label dataMensagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel ocorrencia;
    private java.awt.Panel panel1;
    private javax.swing.JLabel remetenteMensagem;
    private java.awt.Label remetenteUsuario;
    private java.awt.ScrollPane scrollPane1;
    public javax.swing.JTable tblDados;
    private javax.swing.JPanel tela;
    private javax.swing.JPanel telaListar;
    private javax.swing.JPanel telaMensagem;
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
                    atulizarTabelaTurmaAluno();
                case "TurmaServidor" ->
                    atulizarTabelaServidorAluno();
                default -> {
                }
            }
        }
    }

    public void linhaselecionada() {
        int selectedRowIndex = tblDados.getSelectedRow();

        if (selectedRowIndex != -1) {
            BotaoExcluir.setEnabled(true);
        } else {
            BotaoExcluir.setEnabled(false);
        }
    }

    private void atulizarTabelaHome() {
        mensagens = mc.buscarMensagemPorDestinatario(user);
        mensagens.sort(Comparator.comparing(Mensagem::getDataHoraCriacao).reversed());
        tblDados.setModel(new MensagemTabelModel(mensagens));
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(null);
        ocultarColuna(tblDados, 0);                    // Oculta ID
        setColunaLarguraFixa(tblDados, 1, 10);         // Texto com largura mínima
        setColunaLarguraFixa(tblDados, 2, 145);        // Data
        setColunaLarguraFixa(tblDados, 4, 100);        // Outra coluna

        tblDados.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        tblDados.setShowVerticalLines(false);
        tblDados.setShowHorizontalLines(true);
        tblDados.setIntercellSpacing(new Dimension(0, 1)); // controla o espaçamento entre células

        // Renderer padrão (sem borda lateral)
        TableCellRenderer rendererCentro = criarSombraRenderer(false, false);

        // Com borda esquerda (última coluna, por exemplo)
        TableCellRenderer rendererEsquerda = criarSombraRenderer(true, false);

        // Com borda direita (primeira coluna visível, por exemplo)
        TableCellRenderer rendererDireita = criarSombraRenderer(false, true);
        
        tblDados.getColumnModel().getColumn(4).setCellRenderer(rendererDireita);
        tblDados.getColumnModel().getColumn(1).setCellRenderer(rendererEsquerda);
        tblDados.getColumnModel().getColumn(0).setCellRenderer(rendererCentro);
        tblDados.getColumnModel().getColumn(2).setCellRenderer(rendererCentro);


    }

    private void atulizarTabelaAluno() {
        alunos = ac.listarAlunos();
        Collections.sort(alunos, Comparator.comparingInt(Aluno::getCodigo));
        tblDados.setModel(new AlunoTabelModel(alunos));
        ocultarColuna(tblDados, 0);
        tblDados.setShowVerticalLines(true);
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
    }

    private void atulizarTabelaCurso() {
        cursos = cc.listarCursos();
        Collections.sort(cursos, Comparator.comparingInt(Curso::getCodigo));
        tblDados.setModel(new CursoTabelModel(cursos));
        ocultarColuna(tblDados, 0);
        tblDados.setShowVerticalLines(true);
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
    }

    private void atulizarTabelaTurma() {
        turmas = tc.listarTurmas();
        Collections.sort(turmas, Comparator.comparingInt(Turma::getCodigo));
        tblDados.setModel(new TurmaTabelModel(turmas));
        ocultarColuna(tblDados, 0);
        tblDados.setShowVerticalLines(true);
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
    }

    private void atulizarTabelaNecessidade() {
        necessidades = nc.listarNecessidades();
        Collections.sort(necessidades, Comparator.comparingInt(NecessidadeEspecial::getCodigo));
        tblDados.setModel(new NecessidadeTableModel(necessidades));
        ocultarColuna(tblDados, 0);
        tblDados.setShowVerticalLines(true);
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
    }

    private void atulizarTabelaDepartamento() {
        departamentos = dc.listarDepartamentos();
        Collections.sort(departamentos, Comparator.comparingInt(Departamento::getCodigo));
        tblDados.setModel(new DepartamentoTabelModel(departamentos));
        ocultarColuna(tblDados, 0);
        tblDados.setShowVerticalLines(true);
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
    }

    private void atulizarTabelaServidor() {
        servidores = sc.listarServidores();
        Collections.sort(servidores, Comparator.comparingInt(Servidor::getCodigo));
        tblDados.setModel(new ServidorTabelModel(servidores));
        ocultarColuna(tblDados, 0);
        tblDados.setShowVerticalLines(true);
        setColunaLarguraFixa(tblDados, 4, 120);
        tblDados.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
    }

    private void atulizarTabelaTurmaAluno() {
        if (cbTurmas.getSelectedItem() != null) {
            Turma turma = (Turma) cbTurmas.getSelectedItem();
            tblDados.setModel(new TurmaAlunoTabelModel(turma.getCodigo()));
            ocultarColuna(tblDados, 0);
            tblDados.setShowVerticalLines(true);
            ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
        }
    }

    private void atulizarTabelaServidorAluno() {
        if (cbTurmas.getSelectedItem() != null) {
            Turma turma = (Turma) cbTurmas.getSelectedItem();
            tblDados.setModel(new TurmaServidorTabelModel(turma.getCodigo()));
            ocultarColuna(tblDados, 0);
            tblDados.setShowVerticalLines(true);
            ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
        }
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
                    label.setBackground(new Color(230, 230, 230));

                    int left = esquerda ? 1 : 0;
                    int right = direita ? 1 : 0;

                    label.setBorder(BorderFactory.createMatteBorder(1, left, 2, right, new Color(180, 180, 180)));
                } else {
                    label.setBackground(Color.WHITE);
                    label.setBorder(BorderFactory.createEmptyBorder());
                }

                return label;
            }
        };
    }

    private void mostrarMensagem(int aux) {

        Mensagem mensagem = mc.buscarMensagemPorId(aux);
        Servidor remetente = mensagem.getRemetente();
        LocalDateTime data = mensagem.getDataHoraCriacao();
        List<Aluno> alunosAux = mensagem.getAlunos();

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

        // Formatando lista de alunos
        String auxAlunos = alunosAux.stream()
                .map(Aluno::getNome)
                .collect(Collectors.joining(", "));

        // Setando nos labels
        System.out.print(mensagem.getAssunto());
        assuntoMensagem.setText(mensagem.getAssunto());
        remetenteMensagem.setText(mensagem.getAssunto());
        System.out.print(nomeRemetente);
        remetenteMensagem.setText(nomeRemetente);
        remetenteUsuario.setText(emailRemetente);
        dataMensagem.setText(dataFormatada + " " + tempoRelativo);
        alunosMensagem.setText(auxAlunos);
        ocorrencia.setText(mensagem.getTexto());

        // Exibe o painel da mensagem
        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "mensagem");

        System.out.println("Assunto JLabel: " + remetenteMensagem.getText());
        System.out.println("Remetente JLabel: " + remetenteMensagem.getText());
    }

}
