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
import java.awt.Shape;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
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

    private CadastroNecessidade telaNecessidade = null;
    private int clique = 0;
    private Shape shape;
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

    private String rota = "Home";

    public FormPrincipal(int u) {

        user = sc.buscarServidorPorId(u);
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
        setLocationRelativeTo(null);

        scrollPane1.setBorder(null);
        scrollPane1.getViewport().setBorder(null);

        tblDados.getSelectionModel().addListSelectionListener(e -> linhaselecionada());
        tbMensagens.getSelectionModel().addListSelectionListener(e -> linhaselecionada());
        ((JScrollPane) tbMensagens.getParent().getParent()).setColumnHeaderView(null);
        tblDados.setRowHeight(30);
        tbMensagens.setRowHeight(40);
        configurarTabela();
        cbCursos.setVisible(false);
        cbTurmas.setVisible(false);
        btnCadastrarTurma.setVisible(false);
        btnVincularAluno.setVisible(false);
        btnVincularServidor.setVisible(false);
        linha1.setVisible(false);
        linha2.setVisible(false);
        linha3.setVisible(false);
        btnResponder.setEnabled(false);
        btnResponder.setVisible(true);
        BD.Conexao.conectar();

        Runnable callback = this::configurarTabela;

        MensagemListener listener = new MensagemListener(callback);
        listener.start();

        CardLayout layout = (CardLayout) tela.getLayout();
        tela.add(telaListar, "lista");
        tela.add(telaResposta, "mensagem");
        tela.add(telaMensagem, "teste");
        layout.show(tela, "teste");
        corBotao();
        Diretorio.setText("Home");

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
        telaResposta = new javax.swing.JPanel();
        jPanel3 = new view.RoundedPanel();
        btnVoltar = new javax.swing.JButton();
        btnResponder = new javax.swing.JButton();
        scrollPane1 = new javax.swing.JScrollPane();
        panel1 = new java.awt.Panel();
        remetenteUsuario = new java.awt.Label();
        dataMensagem = new java.awt.Label();
        alunosMensagem = new javax.swing.JLabel();
        ocorrencia = new javax.swing.JLabel();
        remetenteMensagem = new javax.swing.JLabel();
        assuntoMensagem = new javax.swing.JLabel();
        telaMensagem = new javax.swing.JPanel();
        panelMensagem = new view.RoundedPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMensagens = new javax.swing.JTable();
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
        btnNovaMensagem = new RoundedButton("Escrever");
        linha3 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        linha2 = new javax.swing.JSeparator();
        linha1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        PanelSuperior.setBackground(new java.awt.Color(204, 204, 204));
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

        telaListar.setBackground(new java.awt.Color(204, 204, 204));
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
                .addGap(0, 30, Short.MAX_VALUE))
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

        telaResposta.setBackground(new java.awt.Color(204, 204, 204));
        telaResposta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaRespostaMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 685));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(0, 0));

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
                        .addComponent(remetenteMensagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dataMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assuntoMensagem)
                            .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alunosMensagem)
                            .addComponent(ocorrencia))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(alunosMensagem)
                .addGap(50, 50, 50)
                .addComponent(ocorrencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollPane1.setViewportView(panel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 782, Short.MAX_VALUE)
                        .addComponent(btnResponder)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(scrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResponder)
                .addContainerGap())
        );

        javax.swing.GroupLayout telaRespostaLayout = new javax.swing.GroupLayout(telaResposta);
        telaResposta.setLayout(telaRespostaLayout);
        telaRespostaLayout.setHorizontalGroup(
            telaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        telaRespostaLayout.setVerticalGroup(
            telaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaRespostaLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        tela.add(telaResposta, "card7");

        telaMensagem.setBackground(new java.awt.Color(204, 204, 204));
        telaMensagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaMensagemMouseClicked(evt);
            }
        });

        panelMensagem.setBackground(new java.awt.Color(255, 255, 255));
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

        panelMensagem.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 900, 660));

        javax.swing.GroupLayout telaMensagemLayout = new javax.swing.GroupLayout(telaMensagem);
        telaMensagem.setLayout(telaMensagemLayout);
        telaMensagemLayout.setHorizontalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        telaMensagemLayout.setVerticalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMensagemLayout.createSequentialGroup()
                .addComponent(panelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
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
                .addComponent(tela, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        btnHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHomeMouseMoved(evt);
            }
        });
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
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
        btnAlunos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAlunosMouseMoved(evt);
            }
        });
        btnAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlunosMouseExited(evt);
            }
        });
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
        btnCursos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCursosMouseMoved(evt);
            }
        });
        btnCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCursosMouseExited(evt);
            }
        });
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
        btnNecessidades.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNecessidadesMouseMoved(evt);
            }
        });
        btnNecessidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNecessidadesMouseExited(evt);
            }
        });
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
        btnServidor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnServidorMouseMoved(evt);
            }
        });
        btnServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServidorMouseExited(evt);
            }
        });
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
        btnDepartamento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDepartamentoMouseMoved(evt);
            }
        });
        btnDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDepartamentoMouseExited(evt);
            }
        });
        btnDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoActionPerformed(evt);
            }
        });

        btnTurmas.setBackground(new java.awt.Color(204, 204, 204));
        btnTurmas.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnTurmas.setForeground(new java.awt.Color(255, 255, 255));
        btnTurmas.setText("Turmas");
        btnTurmas.setBorder(null);
        btnTurmas.setContentAreaFilled(false);
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

        btnCadastrarTurma.setBackground(new java.awt.Color(204, 204, 204));
        btnCadastrarTurma.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnCadastrarTurma.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarTurma.setText("Cadastrar");
        btnCadastrarTurma.setBorder(null);
        btnCadastrarTurma.setFocusable(false);
        btnCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTurmaActionPerformed(evt);
            }
        });

        btnVincularAluno.setBackground(new java.awt.Color(204, 204, 204));
        btnVincularAluno.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnVincularAluno.setForeground(new java.awt.Color(255, 255, 255));
        btnVincularAluno.setText("Alunos");
        btnVincularAluno.setBorder(null);
        btnVincularAluno.setFocusable(false);
        btnVincularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularAlunoActionPerformed(evt);
            }
        });

        btnVincularServidor.setBackground(new java.awt.Color(204, 204, 204));
        btnVincularServidor.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnVincularServidor.setForeground(new java.awt.Color(255, 255, 255));
        btnVincularServidor.setText("Servidores");
        btnVincularServidor.setBorder(null);
        btnVincularServidor.setFocusPainted(false);
        btnVincularServidor.setFocusable(false);
        btnVincularServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularServidorActionPerformed(evt);
            }
        });

        btnNovaMensagem.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnNovaMensagem.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaMensagem.setText("Escrever");
        btnNovaMensagem.setFocusable(false);
        btnNovaMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaMensagemActionPerformed(evt);
            }
        });

        linha3.setBackground(new java.awt.Color(204, 204, 204));
        linha3.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator10.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator10.setForeground(new java.awt.Color(153, 153, 153));

        linha2.setBackground(new java.awt.Color(204, 204, 204));
        linha2.setForeground(new java.awt.Color(180, 180, 180));

        linha1.setBackground(new java.awt.Color(204, 204, 204));
        linha1.setForeground(new java.awt.Color(180, 180, 180));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastrarTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVincularAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(linha2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(linha1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Categoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNovaMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnVincularServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                            .addComponent(linha3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNovaMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnNecessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(linha1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVincularAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(linha2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVincularServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(linha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        corBotao();

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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
        corBotao();

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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
        corBotao();

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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
        corBotao();

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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
        corBotao();

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "teste");

        configurarTabela();
        corBotao();

        BotaoNovo.setEnabled(true);
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.setVisible(true);
        clique = 0;
    }//GEN-LAST:event_btnHomeActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed

        this.dispose();

        Login Login = new Login();
        Login.setVisible(true);
    }//GEN-LAST:event_LogOutActionPerformed

    private void telaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaMouseClicked
        clique = 0;
    }//GEN-LAST:event_telaMouseClicked

    private void btnTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmasActionPerformed
        if (btnTurmas.isSelected()) {
            btnCadastrarTurma.setVisible(true);
            btnVincularAluno.setVisible(true);
            btnVincularServidor.setVisible(true);
            linha1.setVisible(true);
            linha2.setVisible(true);
            linha3.setVisible(true);
            btnTurmas.setBackground(new Color(204, 204, 204));
        } else {
            btnCadastrarTurma.setVisible(false);
            btnVincularAluno.setVisible(false);
            btnVincularServidor.setVisible(false);
            linha1.setVisible(false);
            linha2.setVisible(false);
            linha3.setVisible(false);
        }
    }//GEN-LAST:event_btnTurmasActionPerformed

    private void btnVincularAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularAlunoActionPerformed
        Diretorio.setText("Turmas");
        rota = "TurmaAluno";
        cbCursos.setVisible(true);
        cbTurmas.setVisible(true);

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "lista");

        configurarTabela();
        corBotao();

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
            if (null != rota) {
                {
                    switch (rota) {
                        case "Home" ->

                            mostrarMensagem(aux);
                        case "Alunos" -> {
                            CadastroAluno CadastroAluno = new CadastroAluno(new javax.swing.JFrame(), true, aux, 1, cursos, turmas, necessidades);
                            CadastroAluno.setVisible(true);
                        }
                        case "Cursos" -> {
                            CadastroCurso CadastroCurso = new CadastroCurso(new javax.swing.JFrame(), true, aux, 1);
                            CadastroCurso.setVisible(true);
                        }
                        case "Turmas" -> {
                            CadastroTurma CadastroTurma = new CadastroTurma(new javax.swing.JFrame(), true, aux, cursos, 1);
                            CadastroTurma.setVisible(true);
                        }
                        case "Necessidades" -> {
                            CadastroNecessidade CadastroNecessidade = new CadastroNecessidade(new javax.swing.JFrame(), true, aux, 1);
                            CadastroNecessidade.setVisible(true);
                        }
                        case "Servidor" -> {
                            CadastroServidor CadastroServidor = new CadastroServidor(new javax.swing.JFrame(), true, aux, departamentos, permissoes, 1);
                            CadastroServidor.setVisible(true);
                        }
                        case "Departamento" -> {
                            CadastroDepartamento CadastroDepartamento = new CadastroDepartamento(new javax.swing.JFrame(),
                                    true, aux, 1);
                            CadastroDepartamento.setVisible(true);
                        }
                        default -> {
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblDadosMouseClicked

    private void tblDadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseExited
        linhaMouse = -1;
        tblDados.repaint();
    }//GEN-LAST:event_tblDadosMouseExited

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        if (null != rota)

            switch (rota) {
                case "Alunos" -> {
                    CadastroAluno CadastroAluno = new CadastroAluno(new javax.swing.JFrame(), true, 0, 0, cursos, turmas, necessidades);
                    CadastroAluno.setVisible(true);
                }
                case "Cursos" -> {
                    CadastroCurso CadastroCurso = new CadastroCurso(new javax.swing.JFrame(), true, 0, 0);
                    CadastroCurso.setVisible(true);
                }
                case "Turmas" -> {
                    CadastroTurma CadastroTurma = new CadastroTurma(new javax.swing.JFrame(), true, 0, cursos, 0);
                    CadastroTurma.setVisible(true);
                }
                case "Necessidades" -> {
                    CadastroNecessidade CadastroNecessidade = new CadastroNecessidade(new javax.swing.JFrame(), true, 0, 0);
                    CadastroNecessidade.setVisible(true);
                }
                case "Servidor" -> {
                    CadastroServidor CadastroServidor = new CadastroServidor(new javax.swing.JFrame(), true, 0, departamentos, permissoes, 0);
                    CadastroServidor.setVisible(true);
                }
                case "Departamento" -> {
                    CadastroDepartamento CadastroDepartamento = new CadastroDepartamento(new javax.swing.JFrame(),
                            true, 0, 0);
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

    private void telaRespostaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaRespostaMouseClicked
        clique = 0;
    }//GEN-LAST:event_telaRespostaMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "teste");
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void telaMensagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaMensagemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telaMensagemMouseClicked

    private void tbMensagensMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMensagensMouseExited
        linhaMouse = -1;
        tbMensagens.repaint();

    }//GEN-LAST:event_tbMensagensMouseExited

    private void tbMensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMensagensMouseClicked

        int linhaSelecionada = tbMensagens.getSelectedRow();
        int aux = (int) tbMensagens.getValueAt(linhaSelecionada, 0);
        if (null != rota) {
            switch (rota) {
                case "Home" ->
                    mostrarMensagem(aux);
                default -> {
                }
            }
        }


    }//GEN-LAST:event_tbMensagensMouseClicked

    private void tbMensagensMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMensagensMouseMoved
        int linha = tbMensagens.rowAtPoint(evt.getPoint());
        if (linha != linhaMouse) {
            linhaMouse = linha;
            tbMensagens.repaint();
        }

    }//GEN-LAST:event_tbMensagensMouseMoved

    private void btnNovaMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaMensagemActionPerformed
        EnvioMensagem1 EnvioMensagem1 = new EnvioMensagem1(user);
        EnvioMensagem1.setVisible(true);
    }//GEN-LAST:event_btnNovaMensagemActionPerformed

    private void btnHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseMoved
        if (!"Home".equals(rota)) {
            btnHome.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }
    }//GEN-LAST:event_btnHomeMouseMoved

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnHome.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnAlunosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlunosMouseMoved
        if (!"Alunos".equals(rota)) {
            btnAlunos.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }

    }//GEN-LAST:event_btnAlunosMouseMoved

    private void btnAlunosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlunosMouseExited
        btnAlunos.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnAlunosMouseExited

    private void btnCursosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCursosMouseMoved
        if (!"Cursos".equals(rota)) {
            btnCursos.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }

    }//GEN-LAST:event_btnCursosMouseMoved

    private void btnCursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCursosMouseExited
        btnCursos.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnCursosMouseExited

    private void btnServidorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServidorMouseMoved
        if (!"Servidor".equals(rota)) {
            btnServidor.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }

    }//GEN-LAST:event_btnServidorMouseMoved

    private void btnServidorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServidorMouseExited
        btnServidor.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnServidorMouseExited

    private void btnDepartamentoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepartamentoMouseMoved
        if (!"Departamento".equals(rota)) {
            btnDepartamento.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }


    }//GEN-LAST:event_btnDepartamentoMouseMoved

    private void btnDepartamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepartamentoMouseExited
        btnDepartamento.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnDepartamentoMouseExited

    private void btnNecessidadesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNecessidadesMouseMoved
        if (!"Necessidades".equals(rota)) {
            btnNecessidades.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }

    }//GEN-LAST:event_btnNecessidadesMouseMoved

    private void btnNecessidadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNecessidadesMouseExited
        btnNecessidades.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnNecessidadesMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormPrincipal(0).setVisible(true);
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
    private javax.swing.JButton btnNovaMensagem;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSeparator linha1;
    private javax.swing.JSeparator linha2;
    private javax.swing.JSeparator linha3;
    private javax.swing.JLabel ocorrencia;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panelMensagem;
    private javax.swing.JLabel remetenteMensagem;
    private java.awt.Label remetenteUsuario;
    private javax.swing.JScrollPane scrollPane1;
    public javax.swing.JTable tbMensagens;
    public javax.swing.JTable tblDados;
    private javax.swing.JPanel tela;
    private javax.swing.JPanel telaListar;
    private javax.swing.JPanel telaMensagem;
    private javax.swing.JPanel telaResposta;
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

    private void corBotao() {
        if (null != rota) {
            switch (rota) {
                case "Home" ->
                    setBotaoAtivo(btnHome);
                case "Alunos" ->
                    setBotaoAtivo(btnAlunos);
                case "Cursos" ->
                    setBotaoAtivo(btnCursos);
                case "Necessidades" ->
                    setBotaoAtivo(btnNecessidades);
                case "Servidor" ->
                    setBotaoAtivo(btnServidor);
                case "Departamento" ->
                    setBotaoAtivo(btnDepartamento);
                case "TurmaAluno" ->
                    setBotaoAtivo(btnVincularAluno);
                case "TurmaServidor" ->
                    setBotaoAtivo(btnVincularServidor);
                case "Turmas" ->
                    setBotaoAtivo(btnCadastrarTurma);

                default -> {
                }
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

        long t1 = System.currentTimeMillis();
        mensagens = mc.buscarMensagemPorDestinatario(user);
        System.out.println("Tempo busca: " + (System.currentTimeMillis() - t1) + " ms");
        mensagens.sort(Comparator.comparing(Mensagem::getDataHoraCriacao).reversed());
        System.out.println("Tempo Ordenação: " + (System.currentTimeMillis() - t1) + " ms");
        tbMensagens.setModel(new MensagemTabelModel(mensagens));
        System.out.println("Tempo setmodel: " + (System.currentTimeMillis() - t1) + " ms");
        ((JScrollPane) tbMensagens.getParent().getParent()).setColumnHeaderView(null);
        tbMensagens.setFillsViewportHeight(true);
        tbMensagens.setBackground(Color.WHITE);
        ((JViewport) tblDados.getParent()).setBackground(tblDados.getBackground());
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
        System.out.println("Tempo sombra: " + (System.currentTimeMillis() - t1) + " ms");

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

    private void setBotaoAtivo(JButton ativo) {
        JButton[] botoes = {btnHome, btnAlunos, btnCursos, btnDepartamento, btnServidor, btnNecessidades, btnVincularAluno, btnVincularServidor, btnCadastrarTurma};
        for (JButton b : botoes) {
            b.setBackground(b == ativo ? new Color(170, 170, 170) : new Color(204, 204, 204));
        }
    }

}
