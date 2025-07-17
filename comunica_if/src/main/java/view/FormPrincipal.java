package view;

import controller.AlunoController;
import controller.CursoController;
import controller.DepartamentoController;
import controller.HistoricoRestritoController;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import models.HistoricoRestrito;
import models.Mensagem;
import models.NecessidadeEspecial;
import models.Permissao;
import models.Servidor;
import models.Turma;
import observer.IsativoListener;
import observer.MensagemListener;
import tablemodel.AlunoTabelModel;
import tablemodel.CursoTabelModel;
import tablemodel.DepartamentoTabelModel;
import tablemodel.MensagemEnviadaTabelModel;
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
    List<HistoricoRestrito> vazio = new ArrayList();
    MensagemController mc = new MensagemController();
    AlunoController ac = new AlunoController();
    CursoController cc = new CursoController();
    DepartamentoController dc = new DepartamentoController();
    NecessidadeEspecialController nc = new NecessidadeEspecialController();
    Servidor user;
    PermissaoController pc = new PermissaoController();
    ServidorController sc = new ServidorController();
    TurmaController tc = new TurmaController();
    HistoricoRestritoController hc = new HistoricoRestritoController();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    String permissao;
    Mensagem abrirMensagem;

    private String rota = "Home";

    public FormPrincipal() {

        initComponents();
        setLocationRelativeTo(null);

        if (!autenticado) {
            configurarTelaLogin();
        } else {
            inicializarSistema();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        telaPrincipal = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        Diretorio = new javax.swing.JLabel();
        tela = new javax.swing.JPanel();
        telaResposta = new javax.swing.JPanel();
        jPanel3 = new view.RoundedPanel();
        btnVoltar = new javax.swing.JButton();
        btnResponder = new javax.swing.JButton();
        scrollPane1 = new javax.swing.JScrollPane();
        panel1 = new java.awt.Panel();
        remetenteUsuario = new java.awt.Label();
        dataMensagem = new java.awt.Label();
        remetenteMensagem = new javax.swing.JLabel();
        assuntoMensagem = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ocorrencia = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        alunosMensagem = new javax.swing.JTextArea();
        telaMensagem = new javax.swing.JPanel();
        panelMensagem = new view.RoundedPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMensagens = new javax.swing.JTable();
        telaListarPrincipal = new javax.swing.JPanel();
        telaListar = new view.RoundedPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        BotaoNovo = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        cbCursos = new javax.swing.JComboBox();
        cbTurmas = new javax.swing.JComboBox();
        btnHistorico = new javax.swing.JButton();
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
        btnEnviadas = new javax.swing.JButton();
        linha4 = new javax.swing.JSeparator();
        telaLogin = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Categoria1 = new javax.swing.JLabel();
        Complemento = new javax.swing.JLabel();
        TextLogin = new javax.swing.JLabel();
        Login = new javax.swing.JTextField();
        TextSenha = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        BotaoEntrar = new javax.swing.JButton();
        telaAlterarSenha = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Categoria2 = new javax.swing.JLabel();
        Complemento1 = new javax.swing.JLabel();
        TextLogin1 = new javax.swing.JLabel();
        TextSenha1 = new javax.swing.JLabel();
        confirmarSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        novaSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ComunicaIF");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel6.setLayout(new java.awt.CardLayout());

        telaPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        telaPrincipal.setForeground(new java.awt.Color(153, 153, 153));

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

        btnResponder.setText("Responder");
        btnResponder.setFocusable(false);
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        scrollPane1.setMaximumSize(new java.awt.Dimension(900, 900));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setMaximumSize(new java.awt.Dimension(900, 900));
        panel1.setPreferredSize(new java.awt.Dimension(0, 0));

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

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        alunosMensagem.setColumns(20);
        alunosMensagem.setRows(5);
        alunosMensagem.setBorder(null);
        jScrollPane4.setViewportView(alunosMensagem);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dataMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remetenteMensagem)
                            .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assuntoMensagem))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assuntoMensagem)
                .addGap(15, 15, 15)
                .addComponent(dataMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(remetenteMensagem)
                .addGap(12, 12, 12)
                .addComponent(remetenteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 702, Short.MAX_VALUE)
                .addComponent(btnResponder)
                .addGap(17, 17, 17))
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnResponder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout telaRespostaLayout = new javax.swing.GroupLayout(telaResposta);
        telaResposta.setLayout(telaRespostaLayout);
        telaRespostaLayout.setHorizontalGroup(
            telaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaRespostaLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addContainerGap())
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

        panelMensagem.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 880, 690));

        javax.swing.GroupLayout telaMensagemLayout = new javax.swing.GroupLayout(telaMensagem);
        telaMensagem.setLayout(telaMensagemLayout);
        telaMensagemLayout.setHorizontalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMensagemLayout.createSequentialGroup()
                .addComponent(panelMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addContainerGap())
        );
        telaMensagemLayout.setVerticalGroup(
            telaMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMensagemLayout.createSequentialGroup()
                .addComponent(panelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        tela.add(telaMensagem, "card7");

        telaListarPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        telaListarPrincipal.setPreferredSize(new java.awt.Dimension(890, 722));
        telaListarPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaListarPrincipalMouseClicked(evt);
            }
        });

        telaListar.setBackground(new java.awt.Color(255, 255, 255));
        telaListar.setPreferredSize(new java.awt.Dimension(900, 695));
        telaListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telaListarMouseClicked(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

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

        BotaoNovo.setText("Cadastrar");
        BotaoNovo.setEnabled(false);
        BotaoNovo.setFocusable(false);
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

        btnHistorico.setText("Histórico");
        btnHistorico.setEnabled(false);
        btnHistorico.setFocusable(false);
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telaListarLayout = new javax.swing.GroupLayout(telaListar);
        telaListar.setLayout(telaListarLayout);
        telaListarLayout.setHorizontalGroup(
            telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaListarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(telaListarLayout.createSequentialGroup()
                        .addComponent(btnHistorico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoExcluir))
                    .addGroup(telaListarLayout.createSequentialGroup()
                        .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoNovo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        telaListarLayout.setVerticalGroup(
            telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaListarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoNovo)
                    .addComponent(cbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(telaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoExcluir)
                    .addComponent(btnHistorico))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout telaListarPrincipalLayout = new javax.swing.GroupLayout(telaListarPrincipal);
        telaListarPrincipal.setLayout(telaListarPrincipalLayout);
        telaListarPrincipalLayout.setHorizontalGroup(
            telaListarPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
            .addGroup(telaListarPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(telaListarPrincipalLayout.createSequentialGroup()
                    .addComponent(telaListar, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        telaListarPrincipalLayout.setVerticalGroup(
            telaListarPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
            .addGroup(telaListarPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(telaListarPrincipalLayout.createSequentialGroup()
                    .addComponent(telaListar, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 25, Short.MAX_VALUE)))
        );

        tela.add(telaListarPrincipal, "card7");

        LogOut.setBackground(new java.awt.Color(255, 51, 51));
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("LogOut");
        LogOut.setFocusable(false);
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
                .addGap(18, 18, 18))
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addComponent(tela, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addGroup(PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Diretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelSuperiorLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(LogOut)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Categoria.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Categoria.setText("ComunicaIF");

        btnHome.setBackground(new java.awt.Color(204, 204, 204));
        btnHome.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("   Home");
        btnHome.setToolTipText("");
        btnHome.setAutoscrolls(true);
        btnHome.setBorder(null);
        btnHome.setFocusable(false);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnAlunos.setText("   Alunos");
        btnAlunos.setBorder(null);
        btnAlunos.setFocusable(false);
        btnAlunos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnCursos.setText("   Cursos");
        btnCursos.setBorder(null);
        btnCursos.setFocusable(false);
        btnCursos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnNecessidades.setText("   Necessidades");
        btnNecessidades.setBorder(null);
        btnNecessidades.setFocusable(false);
        btnNecessidades.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnServidor.setText("   Servidor");
        btnServidor.setBorder(null);
        btnServidor.setFocusable(false);
        btnServidor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnDepartamento.setText("   Departamento");
        btnDepartamento.setBorder(null);
        btnDepartamento.setFocusable(false);
        btnDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnTurmas.setText("   Turmas");
        btnTurmas.setBorder(null);
        btnTurmas.setContentAreaFilled(false);
        btnTurmas.setFocusable(false);
        btnTurmas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        btnCadastrarTurma.setText("Turmas");
        btnCadastrarTurma.setBorder(null);
        btnCadastrarTurma.setFocusable(false);
        btnCadastrarTurma.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCadastrarTurmaMouseMoved(evt);
            }
        });
        btnCadastrarTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastrarTurmaMouseExited(evt);
            }
        });
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
        btnVincularAluno.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnVincularAlunoMouseMoved(evt);
            }
        });
        btnVincularAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVincularAlunoMouseExited(evt);
            }
        });
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
        btnVincularServidor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnVincularServidorMouseMoved(evt);
            }
        });
        btnVincularServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVincularServidorMouseExited(evt);
            }
        });
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

        btnEnviadas.setBackground(new java.awt.Color(204, 204, 204));
        btnEnviadas.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        btnEnviadas.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviadas.setText("   Enviadas");
        btnEnviadas.setToolTipText("");
        btnEnviadas.setAutoscrolls(true);
        btnEnviadas.setBorder(null);
        btnEnviadas.setFocusable(false);
        btnEnviadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEnviadas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEnviadasMouseMoved(evt);
            }
        });
        btnEnviadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviadasMouseExited(evt);
            }
        });
        btnEnviadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviadasActionPerformed(evt);
            }
        });

        linha4.setBackground(new java.awt.Color(204, 204, 204));
        linha4.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout telaPrincipalLayout = new javax.swing.GroupLayout(telaPrincipal);
        telaPrincipal.setLayout(telaPrincipalLayout);
        telaPrincipalLayout.setHorizontalGroup(
            telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPrincipalLayout.createSequentialGroup()
                .addGroup(telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addGroup(telaPrincipalLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastrarTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVincularAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addGroup(telaPrincipalLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(linha2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(linha1)))))
                    .addGroup(telaPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Categoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNovaMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(telaPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(telaPrincipalLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnVincularServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                            .addComponent(linha3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(telaPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(linha4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        telaPrincipalLayout.setVerticalGroup(
            telaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(telaPrincipalLayout.createSequentialGroup()
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
                .addGap(0, 0, 0)
                .addComponent(btnEnviadas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(linha4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.add(telaPrincipal, "card2");

        jPanel4.setBackground(new java.awt.Color(15, 68, 78));
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);

        Categoria1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Categoria1.setForeground(new java.awt.Color(255, 255, 255));
        Categoria1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Categoria1.setText("Fazer Login");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Categoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Categoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Complemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Complemento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
                .addGap(413, 413, 413)
                .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Senha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Complemento, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(BotaoEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(414, Short.MAX_VALUE))
        );
        telaLoginLayout.setVerticalGroup(
            telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaLoginLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(Complemento)
                .addGap(40, 40, 40)
                .addComponent(TextLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BotaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        jPanel6.add(telaLogin, "card2");

        jPanel5.setBackground(new java.awt.Color(15, 68, 78));
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);

        Categoria2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Categoria2.setForeground(new java.awt.Color(255, 255, 255));
        Categoria2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Categoria2.setText("Alterar Senha");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Categoria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Categoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Complemento1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Complemento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
                .addGap(413, 413, 413)
                .addGroup(telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(novaSenha)
                    .addComponent(confirmarSenha)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Complemento1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                .addContainerGap(415, Short.MAX_VALUE))
        );
        telaAlterarSenhaLayout.setVerticalGroup(
            telaAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAlterarSenhaLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(Complemento1)
                .addGap(40, 40, 40)
                .addComponent(TextLogin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(novaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextSenha1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        jPanel6.add(telaAlterarSenha, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (autenticado) {
            configurarTabela();
        }
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        }
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        }
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        }
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        }
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(true);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(true);
            clique = 0;
        }

    }//GEN-LAST:event_btnAlunosActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Diretorio.setText("Home");
        rota = "Home";

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "teste");

        configurarTabela();
        corBotao();

        clique = 0;
    }//GEN-LAST:event_btnHomeActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed

        autenticado = false;

        CardLayout layout = (CardLayout) jPanel6.getLayout();
        layout.show(jPanel6, "login");
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
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
        } else {
            btnCadastrarTurma.setVisible(false);
            btnVincularAluno.setVisible(false);
            btnVincularServidor.setVisible(false);
            linha1.setVisible(false);
            linha2.setVisible(false);
            linha3.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        }
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        }
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

        if (permissao.equals("Administrador")) {
            BotaoNovo.setEnabled(true);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(true);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        } else {
            BotaoNovo.setEnabled(true);
            BotaoNovo.setVisible(false);
            BotaoExcluir.setEnabled(false);
            BotaoExcluir.setVisible(false);
            btnHistorico.setEnabled(false);
            btnHistorico.setVisible(false);
            clique = 0;
        }
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
                        case "Alunos" -> {
                            CadastroAluno CadastroAluno = new CadastroAluno(new javax.swing.JFrame(), true, aux, 1, necessidades);
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
                    CadastroAluno CadastroAluno = new CadastroAluno(new javax.swing.JFrame(), true, 0, 0, necessidades);
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
                        AddAluno AddAluno = new AddAluno(new javax.swing.JFrame(), true, turma.getCodigo());
                        AddAluno.setVisible(true);
                    }
                }
                case "TurmaServidor" -> {
                    if (cbTurmas.getSelectedItem() != null) {
                        Turma turma = (Turma) cbTurmas.getSelectedItem();
                        AddServidor AddServidor = new AddServidor(new javax.swing.JFrame(), true, turma.getCodigo());
                        AddServidor.setVisible(true);
                    }
                }
                default -> {
                }
            }
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        int linhaSelecionada = tblDados.getSelectedRow();
        int aux = (int) tblDados.getValueAt(linhaSelecionada, 0);
        clique = 0;

        int response = JOptionPane.showConfirmDialog(
                this,
                "Deseja mesmo excluir?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            if (null != rota) {
                switch (rota) {
                    case "Alunos" ->
                        excluirAluno(aux);
                    case "Cursos" ->
                        excluirCurso(aux);
                    case "Turmas" ->
                        excluirTurma(aux);
                    case "Necessidades" ->
                        excluirNecessidade(aux);
                    case "Servidor" ->
                        excluirServidor(aux);
                    case "Departamento" ->
                        excluirDepartamento(aux);
                    case "TurmaAluno" ->
                        excluirAlunoTurma(aux);
                    case "TurmaServidor" ->
                        excluirServidorTurma(aux);
                    default -> {
                    }
                }
            }
        } else if (response == JOptionPane.NO_OPTION) {
            // Usuário clicou em "Não"
        }

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
        cbCursos.removeAllItems();

        if (!cursos.isEmpty()) {
            for (Curso cf : cursos) {
                cbCursos.addItem(cf);
            }
        }
    }//GEN-LAST:event_cbCursosAncestorAdded

    private void cbTurmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTurmasItemStateChanged
        configurarTabela();
    }//GEN-LAST:event_cbTurmasItemStateChanged

    private void cbTurmasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbTurmasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTurmasAncestorAdded

    private void telaListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaListarMouseClicked
        clique = 0;
    }//GEN-LAST:event_telaListarMouseClicked

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        EnvioMensagem EnvioMensagem1 = new EnvioMensagem(new javax.swing.JFrame(), true, user, 1, abrirMensagem.getCodigo());
        EnvioMensagem1.setVisible(true);
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

        int linhaSelecionada = tbMensagens.rowAtPoint(evt.getPoint());
        if (linhaSelecionada == -1) {
            return;
        }
        int aux = (int) tbMensagens.getValueAt(linhaSelecionada, 0);
        if (null != rota) {
            switch (rota) {
                case "Home" -> {
                    if (aux >= 0) {
                        mostrarMensagem(aux);
                    }
                }
                case "Enviadas" -> {
                    if (aux >= 0) {
                        mostrarMensagemEnviada(aux);
                    }
                }
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
        EnvioMensagem EnvioMensagem1 = new EnvioMensagem(new javax.swing.JFrame(), true, user, 0, 0);
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

    private void telaListarPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telaListarPrincipalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telaListarPrincipalMouseClicked

    private void SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SenhaKeyPressed

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

                autenticado = true;
                user = sc.buscarPorUsuario(usuario);

                if (user.isPrimeiroLogin()) {
                    System.out.print("Entro no IF");
                    CardLayout layout = (CardLayout) jPanel6.getLayout();
                    layout.show(jPanel6, "senha");

                } else {

                    CardLayout layout = (CardLayout) jPanel6.getLayout();
                    layout.show(jPanel6, "principal");

                    inicializarSistema();
                    rota = "Home";
                    corBotao();
                    configurarTabela();
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

                CardLayout layout = (CardLayout) jPanel6.getLayout();
                layout.show(jPanel6, "principal");

                inicializarSistema();
                rota = "Home";
                corBotao();
                configurarTabela();

            } else {
                Complemento.setText("Senha digitas são diferentes");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCadastrarTurmaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarTurmaMouseMoved
        if (!"Turmas".equals(rota)) {
            btnCadastrarTurma.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }
    }//GEN-LAST:event_btnCadastrarTurmaMouseMoved

    private void btnCadastrarTurmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarTurmaMouseExited
        btnCadastrarTurma.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnCadastrarTurmaMouseExited

    private void btnVincularAlunoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVincularAlunoMouseMoved
        if (!"TurmaAluno".equals(rota)) {
            btnVincularAluno.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }
    }//GEN-LAST:event_btnVincularAlunoMouseMoved

    private void btnVincularAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVincularAlunoMouseExited
        btnVincularAluno.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnVincularAlunoMouseExited

    private void btnVincularServidorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVincularServidorMouseMoved
        if (!"TurmaServidor".equals(rota)) {
            btnVincularServidor.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }
    }//GEN-LAST:event_btnVincularServidorMouseMoved

    private void btnVincularServidorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVincularServidorMouseExited
        btnVincularServidor.setBackground(new Color(204, 204, 204));
        corBotao();
    }//GEN-LAST:event_btnVincularServidorMouseExited

    private void btnEnviadasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviadasMouseMoved
        if (!"Enviadas".equals(rota)) {
            btnEnviadas.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }
    }//GEN-LAST:event_btnEnviadasMouseMoved

    private void btnEnviadasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviadasMouseExited
        if (!"Enviadas".equals(rota)) {
            btnEnviadas.setBackground(new Color(190, 190, 190));
        } else {
            corBotao();
        }
    }//GEN-LAST:event_btnEnviadasMouseExited

    private void btnEnviadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviadasActionPerformed
        Diretorio.setText("Mensagem Enviadas");
        rota = "Enviadas";

        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "teste");

        configurarTabela();
        corBotao();

        clique = 0;
    }//GEN-LAST:event_btnEnviadasActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        int linhaSelecionada = tblDados.getSelectedRow();
        int aux = (int) tblDados.getValueAt(linhaSelecionada, 0);
        clique = 0;


        vazio = hc.listarPorAluno(aux);
        
        
        if (vazio.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Aluno não Possui Histórico!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            BotaoExcluir.setEnabled(false);
            btnHistorico.setEnabled(false);

        } else {
            HistoricoAluno HistoricoAluno = new HistoricoAluno(new javax.swing.JFrame(), true, aux);
            HistoricoAluno.setVisible(true);
        }


    }//GEN-LAST:event_btnHistoricoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JLabel Categoria;
    private javax.swing.JLabel Categoria1;
    private javax.swing.JLabel Categoria2;
    private javax.swing.JLabel Complemento;
    private javax.swing.JLabel Complemento1;
    private javax.swing.JLabel Diretorio;
    private javax.swing.JButton LogOut;
    private javax.swing.JTextField Login;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JLabel TextLogin;
    private javax.swing.JLabel TextLogin1;
    private javax.swing.JLabel TextSenha;
    private javax.swing.JLabel TextSenha1;
    private javax.swing.JTextArea alunosMensagem;
    private javax.swing.JLabel assuntoMensagem;
    private javax.swing.JButton btnAlunos;
    private javax.swing.JButton btnCadastrarTurma;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnDepartamento;
    private javax.swing.JButton btnEnviadas;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNecessidades;
    private javax.swing.JButton btnNovaMensagem;
    private javax.swing.JButton btnResponder;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnServidor;
    private javax.swing.JToggleButton btnTurmas;
    private javax.swing.JButton btnVincularAluno;
    private javax.swing.JButton btnVincularServidor;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbCursos;
    private javax.swing.JComboBox cbTurmas;
    private javax.swing.JPasswordField confirmarSenha;
    private java.awt.Label dataMensagem;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
    private javax.swing.JSeparator linha4;
    private javax.swing.JPasswordField novaSenha;
    private javax.swing.JTextArea ocorrencia;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panelMensagem;
    private javax.swing.JLabel remetenteMensagem;
    private java.awt.Label remetenteUsuario;
    private javax.swing.JScrollPane scrollPane1;
    public javax.swing.JTable tbMensagens;
    public javax.swing.JTable tblDados;
    private javax.swing.JPanel tela;
    private javax.swing.JPanel telaAlterarSenha;
    private javax.swing.JPanel telaListar;
    private javax.swing.JPanel telaListarPrincipal;
    private javax.swing.JPanel telaLogin;
    private javax.swing.JPanel telaMensagem;
    private javax.swing.JPanel telaPrincipal;
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
                case "Enviadas" ->
                    setBotaoAtivo(btnEnviadas);
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
                case "Enviadas" ->
                    atulizarTabelaEnviadas();
                default -> {
                }
            }
        }
    }

    public void linhaselecionada() {
        int selectedRowIndex = tblDados.getSelectedRow();

        if (selectedRowIndex != -1) {
            BotaoExcluir.setEnabled(true);
            if (rota.equals("Alunos")) {
                btnHistorico.setEnabled(true);
            }
        } else {
            BotaoExcluir.setEnabled(false);
            btnHistorico.setEnabled(false);
        }
    }

    private void atulizarTabelaHome() {

        mensagens = mc.buscarMensagemPorDestinatario(user);
        mensagens.sort(Comparator.comparing(Mensagem::getDataHoraCriacao).reversed());
        tbMensagens.setModel(new MensagemTabelModel(mensagens));
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

        btnResponder.setEnabled(true);
        btnResponder.setVisible(true);

    }

    private void atulizarTabelaAluno() {
        long t1 = System.currentTimeMillis();
        alunos = ac.listarAlunos();
        System.out.println("Tempo busca: " + (System.currentTimeMillis() - t1) + " ms");
        Collections.sort(alunos, Comparator.comparingInt(Aluno::getCodigo));
        System.out.println("Tempo ordem: " + (System.currentTimeMillis() - t1) + " ms");
        tblDados.setModel(new AlunoTabelModel(alunos));
        ocultarColuna(tblDados, 0);
        tblDados.setShowVerticalLines(true);
        ((JScrollPane) tblDados.getParent().getParent()).setColumnHeaderView(tblDados.getTableHeader());
        System.out.println("Tempo configurar tabela: " + (System.currentTimeMillis() - t1) + " ms");
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

        abrirMensagem = mc.buscarMensagemPorId(aux);
        Servidor remetente = abrirMensagem.getRemetente();
        LocalDateTime data = abrirMensagem.getDataHoraCriacao();
        List<Aluno> alunosAux = abrirMensagem.getAlunos();

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
        System.out.print(abrirMensagem.getAssunto());
        assuntoMensagem.setText(abrirMensagem.getAssunto());
        remetenteMensagem.setText(abrirMensagem.getAssunto());
        System.out.print(nomeRemetente);
        remetenteMensagem.setText(nomeRemetente);
        remetenteUsuario.setText(emailRemetente);
        dataMensagem.setText(dataFormatada + " " + tempoRelativo);
        alunosMensagem.setText(auxAlunos);
        ocorrencia.setText(abrirMensagem.getTexto());

        // Exibe o painel da mensagem
        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "mensagem");

        System.out.println("Assunto JLabel: " + remetenteMensagem.getText());
        System.out.println("Remetente JLabel: " + remetenteMensagem.getText());
    }

    private void setBotaoAtivo(JButton ativo) {
        JButton[] botoes = {btnHome, btnAlunos, btnCursos, btnDepartamento, btnServidor, btnNecessidades, btnVincularAluno, btnVincularServidor, btnCadastrarTurma, btnEnviadas};
        for (JButton b : botoes) {
            b.setBackground(b == ativo ? new Color(170, 170, 170) : new Color(204, 204, 204));
        }
    }

    private void configurarVisibilidadeComponentes() {
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
        btnHistorico.setEnabled(false);
        btnHistorico.setVisible(false);
    }

    private void configurarTextAreas() {
        ocorrencia.setLineWrap(true);
        ocorrencia.setWrapStyleWord(true);
        ocorrencia.setEditable(false);

        alunosMensagem.setLineWrap(true);
        alunosMensagem.setWrapStyleWord(true);
        alunosMensagem.setEditable(false);
    }

    private void inicializarSistema() {

        // Carregando dados do sistema
        mensagens = mc.buscarMensagemPorDestinatario(user);
        alunos = ac.listarAlunos();
        cursos = cc.listarCursos();
        turmas = tc.listarTurmas();
        necessidades = nc.listarNecessidades();
        departamentos = dc.listarDepartamentos();
        permissoes = pc.listarPermissoes();
        servidores = sc.listarServidores();

        // Estilização básica
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane1.setBorder(null);
        scrollPane1.getViewport().setBorder(null);

        // Configurar tabelas e eventos
        tblDados.getSelectionModel().addListSelectionListener(e -> linhaselecionada());
        tbMensagens.getSelectionModel().addListSelectionListener(e -> linhaselecionada());
        ((JScrollPane) tbMensagens.getParent().getParent()).setColumnHeaderView(null);
        tblDados.setRowHeight(30);
        tbMensagens.setRowHeight(40);

        configurarTabela();
        configurarVisibilidadeComponentes();
        configurarTextAreas();
        BD.Conexao.conectar();

        // Listener para mensagens em tempo real
        Runnable callback = this::configurarTabela;
        Runnable callbackAtivo = this::configurarTabela;
        MensagemListener listener = new MensagemListener(callback);
        listener.start();
        IsativoListener listenerAtivo = new IsativoListener(callbackAtivo);
        listenerAtivo.start();

        // Exibir painel inicial
        CardLayout layout = (CardLayout) tela.getLayout();
        tela.add(telaListarPrincipal, "lista");
        tela.add(telaResposta, "mensagem");
        tela.add(telaMensagem, "teste");
        layout.show(tela, "teste");

        // Customizações
        corBotao();
        Diretorio.setText("Home");
        permissao = user.getPermissao().getDescricao();
    }

    private void configurarTelaLogin() {
        CardLayout layout = (CardLayout) jPanel6.getLayout();
        jPanel6.add(telaLogin, "login");
        jPanel6.add(telaAlterarSenha, "senha");
        jPanel6.add(telaPrincipal, "principal");
        layout.show(jPanel6, "login"); // Corrigido: jPanel6, não "tela"
    }

    private void excluirDepartamento(int codigo) {
        if (dc.possuiServidoresVinculados(codigo)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Existem Servidores Vinculados a esse Departamento!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            dc.excluir(codigo);
            configurarTabela();
        }
    }

    private void excluirNecessidade(int codigo) {
        nc.excluir(codigo);
        configurarTabela();
    }

    private void excluirCurso(int codigo) {
        if (cc.existeTurmaVinculada(codigo)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Existem Turmas Vinculadas a esse Curso!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            cc.excluir(codigo);
            configurarTabela();
        }
    }

    private void excluirTurma(int codigo) {
        if (tc.possuiVinculoComAlunoOuServidor(codigo)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Existem Servidores e/ou Alunos Vinculados a essa Turma!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            tc.excluir(codigo);
            configurarTabela();
        }
    }

    private void excluirAlunoTurma(int codigo) {
        Turma t = (Turma) cbTurmas.getSelectedItem();
        List<Aluno> a = new ArrayList<>();
        Aluno al = ac.buscarPorId(codigo);
        a.add(al);
        tc.removerAlunoTurma(t, a);
        configurarTabela();
    }

    private void excluirServidorTurma(int codigo) {
        Turma t = (Turma) cbTurmas.getSelectedItem();
        List<Servidor> s = new ArrayList<>();
        Servidor sl = sc.buscarServidorPorId(codigo);
        s.add(sl);
        tc.removerServidorTurma(t, s);
        configurarTabela();
    }

    private void excluirAluno(int aux) {
        int response = JOptionPane.showConfirmDialog(
                this,
                "O aluno será removido de todos os Vinculos!",
                "Deseja continuar?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            ac.desativarAluno(aux);
        } else if (response == JOptionPane.NO_OPTION) {
            // Usuário clicou em "Não"
        }
    }

    private void excluirServidor(int aux) {

        Servidor s = sc.buscarServidorPorId(aux);
        Permissao p = pc.buscarPermissaoPorId(1);

        if (s.getPermissao().getDescricao().equals(p.getDescricao())) {

            JOptionPane.showMessageDialog(
                    this,
                    "Não pode excluir um Administrador!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

        } else {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "O servidor será removido de todos os Vinculos!",
                    "Deseja continuar?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                sc.inativarServidor(aux);
            } else if (response == JOptionPane.NO_OPTION) {
                // Usuário clicou em "Não"
            }
        }
    }

    public void isAtivo() {

        if (!user.isAtivo()) {

            autenticado = false;

            JOptionPane.showMessageDialog(
                    this,
                    "Sua Conta foi Desativada!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            CardLayout layout = (CardLayout) jPanel6.getLayout();
            layout.show(jPanel6, "login");
        }
    }

    private void atulizarTabelaEnviadas() {
        mensagens = mc.procurarPorRemetente(user);
        mensagens.sort(Comparator.comparing(Mensagem::getDataHoraCriacao).reversed());
        tbMensagens.setModel(new MensagemEnviadaTabelModel(mensagens));
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

        btnResponder.setEnabled(false);
        btnResponder.setVisible(false);
    }

    private void mostrarMensagemEnviada(int aux) {

        abrirMensagem = mc.buscarMensagemPorId(aux);
        List<Servidor> destinatarios = abrirMensagem.getDestinatarios();
        LocalDateTime data = abrirMensagem.getDataHoraCriacao();
        List<Aluno> alunosAux = abrirMensagem.getAlunos();

        // Formatando os destinatários
        String nomesDestinatarios = destinatarios.stream()
                .map(Servidor::getNome)
                .collect(Collectors.joining(", "));

        String usuariosDestinatarios = destinatarios.stream()
                .map(s -> "<" + s.getUsuario() + ">")
                .collect(Collectors.joining(", "));

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
        assuntoMensagem.setText(abrirMensagem.getAssunto());
        remetenteMensagem.setText(nomesDestinatarios);         // agora exibe nomes dos DESTINATÁRIOS
        remetenteUsuario.setText(usuariosDestinatarios);       // e os "e-mails"/usuários também
        dataMensagem.setText(dataFormatada + " " + tempoRelativo);
        alunosMensagem.setText(auxAlunos);
        ocorrencia.setText(abrirMensagem.getTexto());

        // Exibe o painel da mensagem
        CardLayout layout = (CardLayout) tela.getLayout();
        layout.show(tela, "mensagem");

        System.out.println("Assunto JLabel: " + assuntoMensagem.getText());
        System.out.println("Destinatários JLabel: " + remetenteMensagem.getText());
    }

}
