package com.pv.comunica_if;

import Atendimento.Controller.AnimaisTableModel;
import Atendimento.Controller.ClientesTableModel;
import Atendimento.DAO.AnimalDAO;
import Atendimento.DAO.ClienteDAO;
import Atendimento.Model.Animal;
import Atendimento.Model.Cliente;
import Atendimento.Model.Fisica;
import Atendimento.Model.Juridica;
import Atendimento.view.FormAnimal;
import Atendimento.view.FormCliente;
import Financeiro.Controller.ContaTableModel1;
import Financeiro.Controller.GerenciaProduto;
import Financeiro.Controller.ProdutoTableModel11;
import Financeiro.Controller.ServicoTableModel111;
import Financeiro.DAO.ContaDAO;
import Financeiro.DAO.ItemDAO;
import Financeiro.Model.Conta;
import Financeiro.Model.Item;
import Financeiro.Model.Produto;
import Financeiro.Model.Servico;
import Financeiro.view.FormFinanceiro;
import Financeiro.view.FormProduto;
import Financeiro.view.FormServico;
import Servico.Controller.AgendamentoTableModel;
import Servico.DAO.AgendamentoDAO;
import Servico.DAO.ProfissionalDAO;
import Servico.Model.Agendamento;
import Servico.Model.Profissional;
import Servico.view.FormAgendamento;
import Servico.view.FormProfissional;
import Servico.view.ProfissionalTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class modelo extends javax.swing.JFrame {
private int clique = 0;
private int cliqueAux = 0;
private static boolean autenticado = false;

    private String rota;

    public modelo() {
        clienteDAO = new ClienteDAO();
        clientes = clienteDAO.listarTodosClientes();
        Collections.sort(clientes, Comparator.comparingInt(Cliente::getId));
        animalDAO = new AnimalDAO();
        animais = animalDAO.listarTodosAnimais();
        Collections.sort(animais, Comparator.comparingInt(Animal::getId));
        profissionalDAO = new ProfissionalDAO();
        profissionais = profissionalDAO.listarTodosProfissionais();
        Collections.sort(profissionais, Comparator.comparingInt(Profissional::getId));
        itemDAO = new ItemDAO();
        itens = itemDAO.getAllItens();
        Collections.sort(itens, Comparator.comparingInt(Item::getId));
        contaDAO = new ContaDAO();
        contas = contaDAO.buscarTodasContas();
        Collections.sort(contas, Comparator.comparingInt(Conta::getId));
        agendaDAO = new AgendamentoDAO();
        agendas = agendaDAO.listarTodosAgendamentos();
        Collections.sort(agendas, Comparator.comparingInt(Agendamento::getId));

        initComponents();
        tblDados.getSelectionModel().addListSelectionListener(e -> linhaselecionada());
        configurarTabela();
        EscolhaCPF1.setVisible(false);
        EscolhaCNPJ1.setVisible(false);
        cbFiltro.setVisible(false);
        btnFinalizar.setVisible(false);
        btnCancelar.setVisible(false);
        BD.Conexao.conectar();
    }

    public static void setAutenticado(boolean status) {
        autenticado = status;
    }
 
    private void configurarTabela() {
        if("Animais".equals(rota)){
            atualizarTabelaAnimais();
        }
        else if("Clientes".equals(rota)){
            if (EscolhaCPF1.isSelected()) {
                atualizarTabelaFisica();
            } else if (EscolhaCNPJ1.isSelected()) {
                atualizarTabelaJuridica();
            }
        }
        else if("Produtos".equals(rota)){
            atualizarTabelaProdutos();
        }
        else if("Servicos".equals(rota)){
            atualizarTabelaServico();
        }
        else if("Financeiro".equals(rota)){
            atualizarTabelaConta((String)cbFiltro.getSelectedItem());
        }
        else if("Agendamentos".equals(rota)){
            atualizarTabelaAgendamento((String)cbFiltro.getSelectedItem());
        }
        else if("Profissionais".equals(rota)){
            atualizarTabelaProfissionais();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        BotaoNovo = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BotaoExcluir1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
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

        BotaoExcluir.setText("Editar");
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        BotaoExcluir1.setText("Excluir");
        BotaoExcluir1.setEnabled(false);
        BotaoExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluir1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Pesquisar");

        button1.setLabel("<<");

        button2.setLabel(">>");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setLabel(">");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setLabel("<");

        javax.swing.GroupLayout TelaLayout = new javax.swing.GroupLayout(Tela);
        Tela.setLayout(TelaLayout);
        TelaLayout.setHorizontalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TelaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(TelaLayout.createSequentialGroup()
                                    .addComponent(BotaoNovo)
                                    .addGap(18, 18, 18)
                                    .addComponent(BotaoExcluir)
                                    .addGap(18, 18, 18)
                                    .addComponent(BotaoExcluir1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TelaLayout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        TelaLayout.setVerticalGroup(
            TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaLayout.createSequentialGroup()
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotaoNovo)
                            .addComponent(BotaoExcluir)
                            .addComponent(BotaoExcluir1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void linhaselecionada() {
        int selectedRowIndex = tblDados.getSelectedRow();

        if (selectedRowIndex != -1) {
            BotaoExcluir.setEnabled(true);
            if ("Financeiro".equals(rota)) {
                Conta agendamentoSelecionado = contas.get(selectedRowIndex);

                // Verifica o status do agendamento
                String status = agendamentoSelecionado.getStatusPagamento();

                // Se o status for "Cancelado" ou "Realizado", mantém os botões desabilitados
                if (status.equalsIgnoreCase("Cancelado") || status.equalsIgnoreCase("Efetuado")) {
                    btnFinalizar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                } else {
                    // Caso contrário, habilita os botões
                    btnFinalizar.setEnabled(true);
                    btnCancelar.setEnabled(true);
                }
            } else if ("Agendamentos".equals(rota)) {
                Agendamento agendamentoSelecionado = agendas.get(selectedRowIndex);

                // Verifica o status do agendamento
                String status = agendamentoSelecionado.getStatus();

                // Se o status for "Cancelado" ou "Realizado", mantém os botões desabilitados
                if (status.equalsIgnoreCase("Cancelado") || status.equalsIgnoreCase("Realizada")) {
                    btnFinalizar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                } else {
                    // Caso contrário, habilita os botões
                    btnFinalizar.setEnabled(true);
                    btnCancelar.setEnabled(true);
                }
            }
        } else {
            BotaoExcluir.setEnabled(false);
            btnFinalizar.setEnabled(false);
            btnCancelar.setEnabled(false);
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
        if ("Clientes".equals(rota)) {
            if (EscolhaCPF1.isSelected()) {
                atualizarTabelaFisica();
            } else if (EscolhaCNPJ1.isSelected()) {
                atualizarTabelaJuridica();
            }
        }else if ("Animais".equals(rota)) {
            atualizarTabelaAnimais();
        } else if ("Clientes".equals(rota)) {
            tblDados.setModel(new AnimaisTableModel(animais));
        } else if ("Produtos".equals(rota)) {
            atualizarTabelaProdutos();
        } else if ("Servicos".equals(rota)) {
            atualizarTabelaServico();
        } else if ("Financeiro".equals(rota)) {
            atualizarTabelaConta((String)cbFiltro.getSelectedItem());
        } else if ("Agendamentos".equals(rota)) {
            atualizarTabelaAgendamento((String)cbFiltro.getSelectedItem());
        }else if ("Profissionais".equals(rota)) {
            atualizarTabelaProfissionais();
        }  
        
    }//GEN-LAST:event_formWindowActivated

    private void TelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaMouseClicked
        clique = 0;
    }//GEN-LAST:event_TelaMouseClicked

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
            if ("Produtos".equals(rota)) {
                excluirProduto(aux);
            } else if ("Servicos".equals(rota)) {
                excluirServico(aux);
            } else if ("Profissionais".equals(rota)) {
                excluirProfissional(aux);
            } else if ("Animais".equals(rota)) {
                excluirAnimal(aux);
            } else if ("Clientes".equals(rota)) {
                excluirCliente(aux);
            }
        } else if (response == JOptionPane.NO_OPTION) {
            // Usuário clicou em "Não"
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed

        if ("Financeiro".equals(rota)) {
            FormFinanceiro FormFinanceiro = new FormFinanceiro(this, true, contas, 0, 0, clientes, itens, itemDAO);
            FormFinanceiro.setVisible(true);
        } else if ("Produtos".equals(rota)) {
            FormProduto FormProduto = new FormProduto(this, true, itens, 0, 0);
            FormProduto.setVisible(true);
        } else if ("Servicos".equals(rota)) {
            FormServico FormServico = new FormServico(this, true, itens, 0, 0, profissionais);
            FormServico.setVisible(true);
        } else if ("Agendamentos".equals(rota)) {
            FormAgendamento FormAgendamento = new FormAgendamento(this, true, agendas, 0, 0, clientes, itens);
            FormAgendamento.setVisible(true);
        } else if ("Profissionais".equals(rota)) {
            FormProfissional FormProfissional = new FormProfissional(this, true, profissionais, 0, 0);
            FormProfissional.setVisible(true);
        } else if("Animais".equals(rota)){
            FormAnimal FormAnimal = new FormAnimal(this, true, animais, clientes, 0, 0);
            FormAnimal.setVisible(true);
        } else if("Clientes".equals(rota)){
            FormCliente FormCliente = new FormCliente(this, true, clientes, animais, 0, 0);
            FormCliente.setVisible(true);
        }
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void tblDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadosMouseClicked
        contaClique();
        if (clique == 2) {
            clique = 0;
            int linhaSelecionada = tblDados.getSelectedRow();
            int aux = (int) tblDados.getValueAt(linhaSelecionada, 0);
            if ("Financeiro".equals(rota)) {
                Conta agendamentoSelecionado = contas.get(linhaSelecionada);
                String status = agendamentoSelecionado.getStatusPagamento();
                if (!(status.equalsIgnoreCase("Cancelado") || status.equalsIgnoreCase("Efetuado"))) {
                    FormFinanceiro FormFinanceiro = new FormFinanceiro(this, true, contas, 1, aux, clientes, itens, itemDAO);
                    FormFinanceiro.setVisible(true);
                }
            } else if ("Produtos".equals(rota)) {
                FormProduto FormProduto = new FormProduto(this, true, itens, 1, aux);
                FormProduto.setVisible(true);
            } else if ("Servicos".equals(rota)) {
                FormServico FormServico = new FormServico(this, true, itens, 1, aux, profissionais);
                FormServico.setVisible(true);
            } else if ("Agendamentos".equals(rota)) {
                Agendamento agendamentoSelecionado = agendas.get(linhaSelecionada);
                String status = agendamentoSelecionado.getStatus();
                if (!(status.equalsIgnoreCase("Cancelado") || status.equalsIgnoreCase("Realizada"))) {
                    FormAgendamento FormAgendamento = new FormAgendamento(this, true, agendas, 1, aux, clientes, itens);
                    FormAgendamento.setVisible(true);
                }
            } else if ("Profissionais".equals(rota)) {
                FormProfissional FormProfissional = new FormProfissional(this, true, profissionais, 1, aux);
                FormProfissional.setVisible(true);
            } else if ("Animais".equals(rota)) {
                FormAnimal FormAnimal = new FormAnimal(this, true, animais, clientes, 1, aux);
                FormAnimal.setVisible(true);
            } else if ("Clientes".equals(rota)) {
                FormCliente FormCliente = new FormCliente(this, true, clientes, animais, 1, aux);
                FormCliente.setVisible(true);
            }
        }
    }//GEN-LAST:event_tblDadosMouseClicked

    private void BotaoExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoExcluir1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed
    
    public void RadioButtonSelected(boolean selecao) {
        if (selecao) {
            EscolhaCPF1.setSelected(true);
            EscolhaCNPJ1.setSelected(false);
        }
        if (!selecao) {
            EscolhaCPF1.setSelected(false);
            EscolhaCNPJ1.setSelected(true);
        }
    }

    public void atualizarTabelaFisica() {        
        clientes = clienteDAO.listarTodosClientes();
        Collections.sort(clientes, Comparator.comparingInt(Cliente::getId));
        ArrayList<Cliente> clientesFisica = new ArrayList<>();

        for (Cliente cliente : clientes) {
            if (cliente instanceof Fisica) {
                clientesFisica.add(cliente);
            }
        }

        // Atualiza o modelo da tabela para mostrar apenas clientes do tipo Fisica
        ClientesTableModel modelo = new ClientesTableModel(clientesFisica);
        tblDados.setModel(modelo);
    }

    public void atualizarTabelaJuridica() {
        clientes = clienteDAO.listarTodosClientes();
        Collections.sort(clientes, Comparator.comparingInt(Cliente::getId));
        ArrayList<Cliente> clientesJuridica = new ArrayList<>();

        for (Cliente cliente : clientes) {
            if (cliente instanceof Juridica) {
                clientesJuridica.add(cliente);
            }
        }

        // Atualiza o modelo da tabela para mostrar apenas clientes do tipo Juridica
        ClientesTableModel modelo = new ClientesTableModel(clientesJuridica);
        tblDados.setModel(modelo);
    }
    
    public void atualizarTabelaServico() {
        
        itens = itemDAO.getAllItens();
        Collections.sort(itens, Comparator.comparingInt(Item::getId));
        ArrayList<Item> servicos = new ArrayList<>();

        for (Item servico : itens) {
            if (servico instanceof Servico) {
                servicos.add(servico);
            }
        }

        ServicoTableModel111 modelo = new ServicoTableModel111(servicos);
        tblDados.setModel(modelo);
    }
    
    public void atualizarTabelaProdutos() {
        
        itens = itemDAO.getAllItens();
        Collections.sort(itens, Comparator.comparingInt(Item::getId));
        ArrayList<Item> produtos = new ArrayList<>();

        for (Item produto : itens) {
            if (produto instanceof Produto) {
                produtos.add(produto);
            }
        }

        ProdutoTableModel11 modelo = new ProdutoTableModel11(produtos);
        tblDados.setModel(modelo);
    }
    
    public void atualizarTabelaProfissionais() {

        profissionais = profissionalDAO.listarTodosProfissionais();
        Collections.sort(profissionais, Comparator.comparingInt(Profissional::getId));
        tblDados.setModel(new ProfissionalTableModel(profissionais));

    }
    
    public void atualizarTabelaAgendamento(String status) { 
        agendas = agendaDAO.listarTodosAgendamentos();
        if ("Todos".equals(status)) {
            Collections.sort(agendas, Comparator.comparingInt(Agendamento::getId));
            AgendamentoTableModel modelo = new AgendamentoTableModel(agendas);
            tblDados.setModel(modelo);
        }else if("Cancelados".equals(status)){
            List<Agendamento> agen = new ArrayList<>();
            for(Agendamento a : agendas){
                if(a.getStatus().equals("Cancelado")){
                    agen.add(a);
                }
            }
            Collections.sort(agen, Comparator.comparingInt(Agendamento::getId));
            AgendamentoTableModel modelo = new AgendamentoTableModel(agen);
            tblDados.setModel(modelo);
        }else if("Agendados".equals(status)){
            List<Agendamento> agen = new ArrayList<>();
            for(Agendamento a : agendas){
                if(a.getStatus().equals("Agendado")){
                    agen.add(a);
                }
            }
            Collections.sort(agen, Comparator.comparingInt(Agendamento::getId));
            AgendamentoTableModel modelo = new AgendamentoTableModel(agen);
            tblDados.setModel(modelo);
        }else if("Concluidos".equals(status)){
            List<Agendamento> agen = new ArrayList<>();
            for(Agendamento a : agendas){
                if(a.getStatus().equals("Realizada")){
                    agen.add(a);
                }
            }
            Collections.sort(agen, Comparator.comparingInt(Agendamento::getId));
            AgendamentoTableModel modelo = new AgendamentoTableModel(agen);
            tblDados.setModel(modelo);
        }
        
    }
    
    public void atualizarTabelaConta(String status) {

        contas = contaDAO.buscarTodasContas();

        if ("Todos".equals(status)) {
            Collections.sort(contas, Comparator.comparingInt(Conta::getId));
            ContaTableModel1 modelo = new ContaTableModel1(contas);
            tblDados.setModel(modelo);
        } else if ("Cancelados".equals(status)) {
            List<Conta> cont = new ArrayList<>();
            for (Conta a : contas) {
                if (a.getStatusPagamento().equals("Cancelado")) {
                    cont.add(a);
                }
            }
            Collections.sort(cont, Comparator.comparingInt(Conta::getId));
            ContaTableModel1 modelo = new ContaTableModel1(cont);
            tblDados.setModel(modelo);
        } else if ("Efetuados".equals(status)) {
            List<Conta> cont = new ArrayList<>();
            for (Conta a : contas) {
                if (a.getStatusPagamento().equals("Efetuado")) {
                    cont.add(a);
                }
            }
            Collections.sort(cont, Comparator.comparingInt(Conta::getId));
            ContaTableModel1 modelo = new ContaTableModel1(cont);
            tblDados.setModel(modelo);
        } else if ("Pendentes".equals(status)) {
            List<Conta> cont = new ArrayList<>();
            for (Conta a : contas) {
                if (a.getStatusPagamento().equals("Pendente")) {
                    cont.add(a);
                }
            }
            Collections.sort(cont, Comparator.comparingInt(Conta::getId));
            ContaTableModel1 modelo = new ContaTableModel1(cont);
            tblDados.setModel(modelo);
        }
        
    }
    
    private void atualizarTabelaAnimais() {

        animais = animalDAO.listarTodosAnimais();
        Collections.sort(animais, Comparator.comparingInt(Animal::getId));
        AnimaisTableModel modelo = new AnimaisTableModel(animais);
        tblDados.setModel(modelo);
        
    }
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoExcluir1;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JPanel Tela;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable tblDados;
    // End of variables declaration//GEN-END:variables
    private void excluirProfissional(int indiceProfissional) {
        Profissional profissionalARemover = profissionalDAO.buscarProfissionalPorId(indiceProfissional);
        int idProfissional = profissionalARemover.getId();

        // Verifica se o profissional tem agendamentos associados
        List<Agendamento> agendamentosAssociados = new ArrayList<>();
        for (Agendamento agendamento : agendas) {
            if (agendamento.getProfissional().getId() == idProfissional) {
                if(!agendamento.getStatus().equals("Cancelado")){
                    agendamentosAssociados.add(agendamento);
                }      
            }
        }

        // Se houver agendamentos associados, pergunta ao usuário se deseja cancelar
        if (!agendamentosAssociados.isEmpty()) {
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Existem agendamentos associados a este profissional. Deseja cancelar os agendamentos?",
                    "Confirmar Cancelamento",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
                for (Agendamento agendamento : agendamentosAssociados) {
                    agendamento.setStatus("Cancelado");
                    agendamentoDAO.atualizarAgendamento(agendamento);
                }
            } else {
                return;
            }
        }

        // Verifica se o profissional está associado a serviços que só têm ele como profissional
        List<Item> auxiliar = itemDAO.getAllItens();
        for (Item i : auxiliar) {
            if (i instanceof Servico) {
                Servico servico = (Servico) i;
                if (servico.getProfissional().size() == 1) {
                    for (Profissional profissional : servico.getProfissional()) {
                        if (profissional.getId() == idProfissional) {
                            servico.setAtivo(false);
                            itemDAO.atualizarItem(servico);
                        }
                    }
                } else {
                    List<Profissional> aux = new ArrayList<>();
                    for (Profissional profissional : servico.getProfissional()) {
                        if (!(profissional.getId() == idProfissional)) {
                            aux.add(profissional);
                            
                        }
                    }
                    servico.setProfissional(aux);
                    itemDAO.atualizarItem(servico);
                }
            }
        }

        Profissional rem = profissionalDAO.buscarProfissionalPorId(idProfissional);
        rem.setAtivo(false);
        boolean sucesso = profissionalDAO.atualizarProfissional(rem);
        atualizarTabelaProfissionais();

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Profissional removido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao remover o profissional. Tente novamente.");
        }
    }

    private void excluirAnimal(int indiceAnimal) {
        // Obter o animal a ser removido
        Animal animalARemover = animalDAO.buscarAnimalPorId(indiceAnimal);
        if (animalARemover == null) {
            JOptionPane.showMessageDialog(this, "Animal não encontrado.");
            return;
        }

        // Verificar agendamentos associados ao animal
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        List<Agendamento> agendamentosAssociados = agendamentoDAO.buscarAgendamentosPorAnimal(animalARemover.getId());

        if (!agendamentosAssociados.isEmpty()) {
            // Há agendamentos associados, solicitar confirmação para cancelamento
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Existem agendamentos associados a este animal. Deseja cancelar os agendamentos?",
                    "Confirmar Cancelamento",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                // Cancelar agendamentos
                for (Agendamento agendamento : agendamentosAssociados) {
                    agendamento.setStatus("Cancelado");
                    agendamentoDAO.atualizarAgendamento(agendamento); // Atualizar o status no banco de dados
                }
            } else {
                // Se não quiser cancelar, interrompe a exclusão
                return;
            }
        }

        animalARemover.setAtivo(false);
        animalDAO.atualizarAnimal(animalARemover);

        // Atualiza a tabela de animais
        atualizarTabelaAnimais();

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Animal removido com sucesso.");
    }

    private void excluirCliente(int indiceCliente) {
        Cliente clienteARemover = clienteDAO.buscarClientePorId(indiceCliente);
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ContaDAO contaDAO = new ContaDAO(); // Adicione uma instância para acessar as contas

        // Verifica se o cliente existe
        if (clienteARemover == null) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Busca os agendamentos associados ao cliente diretamente
        List<Agendamento> agendamentos = agendamentoDAO.listarTodosAgendamentos();
        List<Agendamento> agendamentosAssociados = new ArrayList<>();

        // Adiciona os agendamentos do cliente à lista
        for (Agendamento agen : agendamentos) {
            if (agen.getCliente().getId() == clienteARemover.getId()) {
                agendamentosAssociados.add(agen);
            }
        }

        // Verifica se todos os agendamentos estão cancelados
        boolean todosCancelados = true;
        for (Agendamento agendamento : agendamentosAssociados) {
            if (!"Cancelado".equals(agendamento.getStatus())) {
                todosCancelados = false;
                break;
            }
        }

        // Verifica se há contas pendentes
        List<Conta> contasPendentes = contaDAO.buscarTodasContas();
        boolean possuiContasPendentes = false;
        for (Conta conta : contasPendentes) {
            if (conta.getCliente().getId() == clienteARemover.getId()) {
                if (!"Efetuado".equals(conta.getStatusPagamento())) {  // Considerando que "Paga" seja o status de uma conta quitada
                    possuiContasPendentes = true;
                    break;
                }
            }
        }

        // Se houver contas pendentes, mostra mensagem de erro
        if (possuiContasPendentes) {
            JOptionPane.showMessageDialog(this, "O cliente possui contas pendentes. Não é possível excluí-lo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!todosCancelados) {
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Existem agendamentos associados a este Cliente. Deseja cancelar os agendamentos?",
                    "Confirmar Cancelamento",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                for (Agendamento agendamento : agendamentosAssociados) {
                    agendamento.setStatus("Cancelado");
                    agendaDAO.atualizarAgendamento(agendamento); // Atualiza o agendamento no banco de dados
                }
            } else {
                return; // Interrompe a operação de exclusão se o usuário optar por não cancelar os agendamentos
            }
        }

        // Se todos os agendamentos estiverem cancelados, procede com a exclusão
        List<Animal> animaisCliente = clienteDAO.buscarAnimaisPorClienteId(clienteARemover.getId());
        if (animaisCliente != null) {
            for (Animal a : animaisCliente) {
                a.setAtivo(false);
                animalDAO.atualizarAnimal(a);
            }
        }

        clienteARemover.setAtivo(false);
        clienteDAO.atualizarCliente(clienteARemover);

        // Atualiza as tabelas de clientes
        atualizarTabelaFisica();
        atualizarTabelaJuridica();
    }


    private void excluirServico(int indiceServico) {

        // Busca o serviço a ser removido no banco de dados
        Servico servicoARemover = (Servico) itemDAO.getItemById(indiceServico);

        // Verifica se há agendamentos associados ao serviço
        List<Agendamento> agendamentosAssociados = new ArrayList<>();

        for (Agendamento agendamento : agendas) {
            if (agendamento.getServico().equals(servicoARemover)) {
                if(!agendamento.getStatus().equals("Cancelado")){
                   agendamentosAssociados.add(agendamento); 
                }          
            }
        }

        if (!agendamentosAssociados.isEmpty()) {
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Existem agendamentos associados a este serviço. Deseja cancelar os agendamentos?",
                    "Confirmar Cancelamento",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                for (Agendamento agendamento : agendamentosAssociados) {
                    agendamento.setStatus("Cancelado");
                    agendaDAO.atualizarAgendamento(agendamento); // Atualiza o agendamento no banco de dados
                }
            } else {
                return; // Interrompe a operação de exclusão se o usuário optar por não cancelar os agendamentos
            }
        }

        servicoARemover.setAtivo(false);
        // Exclui o serviço no banco de dados
        itemDAO.atualizarItem(servicoARemover);

        // Atualiza a tabela de serviços após a exclusão
        atualizarTabelaServico();

    }

    private void excluirProduto(int indiceProduto) {

        Item produto = itemDAO.getItemById(indiceProduto);
        produto.setAtivo(false);
        itemDAO.atualizarItem(produto);
        atualizarTabelaProdutos();

    }

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

}
