/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConnectionFactory;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Filme;
import model.bean.Produto;
import model.bean.Sala;
import model.bean.Sessao;
import model.dao.FilmeDAO;
import model.dao.ProdutoDAO;
import model.dao.SalaDAO;
import model.dao.SessaoDAO;

/**
 *
 * @author JVict
 */
public class ViewMenu extends javax.swing.JFrame {

    private Object formatter;

    /**
     * Creates new form ViewMenu
     */
    public ViewMenu() {
        initComponents();
        jPanelDefault.setVisible(true);
        jPanelFilmes.setVisible(false);
        jPanelSalas.setVisible(false);
        jPanelSessoes.setVisible(false);
        jPanelProdutos.setVisible(false);
        jPanelClientes.setVisible(false);

        carregaCBoxF();
        carregaCBoxS();

    }

    public void readJTableFilmes() {
        DefaultTableModel modeloFilmes = (DefaultTableModel) jTableFilmes.getModel();
        modeloFilmes.setNumRows(0);
        FilmeDAO fdao = new FilmeDAO();
        for (Filme f : fdao.readFilmes()) {
            modeloFilmes.addRow(new Object[]{
                f.getIdFilme(),
                f.getTitulo(),
                f.getDiretor(),
                f.getGenero(),
                f.getIdioma(),
                f.getDuracao()
            });
        }
    }
    
    public void readJTableProdutos() {
        DefaultTableModel modeloProdutos = (DefaultTableModel) jTableProduto.getModel();
        modeloProdutos.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        for (Produto p : pdao.readProduto()) {
            modeloProdutos.addRow(new Object[]{
                p.getIdProduto(),
                p.getNomeProduto(),
                p.getPreco(),
                p.getPontosProd()
            });
        }
    }

    public void readJTableSala() {
        DefaultTableModel modeloSala = (DefaultTableModel) jTableSalas.getModel();
        modeloSala.setNumRows(0);
        SalaDAO sdao = new SalaDAO();
        for (Sala s : sdao.readSala()) {
            modeloSala.addRow(new Object[]{
                s.getIdSala(),
                s.getNumero(),
                s.getCapacidade()
            });
        }
    }

    public void readJTableSessao() {
        DefaultTableModel modeloSessao = (DefaultTableModel) jTableSessao.getModel();
        modeloSessao.setNumRows(0);
        SessaoDAO sedao = new SessaoDAO();
        for (Sessao se : sedao.readSessao()) {
            modeloSessao.addRow(new Object[]{
                se.getIdSessao(),
                se.getFilme(),
                se.getSala(),
                se.getData(),
                se.getHorario(),
                se.getValorIngresso(),
                se.getIngressosDisponiveis()
            });
        }
    }

    public void readJTableForSearchFilmes(String titulo) {
        DefaultTableModel modeloFilmes = (DefaultTableModel) jTableFilmes.getModel();
        modeloFilmes.setNumRows(0);
        FilmeDAO bdao = new FilmeDAO();
        for (Filme f : bdao.searchFilmes(titulo)) {
            modeloFilmes.addRow(new Object[]{
                f.getIdFilme(),
                f.getTitulo(),
                f.getDiretor(),
                f.getGenero(),
                f.getIdioma(),
                f.getDuracao()
            });
        }
    }

    public void readJTableForSearchSalas(int numero) {
        DefaultTableModel modeloSala = (DefaultTableModel) jTableSalas.getModel();
        modeloSala.setNumRows(0);
        SalaDAO sdao = new SalaDAO();
        for (Sala s : sdao.searchSala(numero)) {
            modeloSala.addRow(new Object[]{
                s.getIdSala(),
                s.getNumero(),
                s.getCapacidade()
            });
        }
    }

    public void readJTableForSearchSessao(String filme) {
        DefaultTableModel modeloSessao = (DefaultTableModel) jTableSessao.getModel();
        modeloSessao.setNumRows(0);
        SessaoDAO sedao = new SessaoDAO();
        for (Sessao se : sedao.searchSessao(filme)) {
            modeloSessao.addRow(new Object[]{
                se.getIdSessao(),
                se.getFilme(),
                se.getSala(),
                se.getData(),
                se.getHorario(),
                se.getValorIngresso(),
                se.getIngressosDisponiveis()
            });
        }
    }

    public void carregaCBoxF() {
        FilmeDAO fdao = new FilmeDAO();
        for (Filme f : fdao.readFilmes()) {
            jComboBoxFilmes.addItem(f);

        }
    }

    public void carregaCBoxS() {
        SalaDAO sdao = new SalaDAO();
        for (Sala s : sdao.readSala()) {
            jComboBoxSalas.addItem(s);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelLateral = new javax.swing.JPanel();
        jButtonFilmes = new javax.swing.JButton();
        jButtonSalas = new javax.swing.JButton();
        jButtonSessoes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonAjuda = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonProdutos = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelFilmes = new javax.swing.JPanel();
        jButtonCadastrarFilmes = new javax.swing.JButton();
        jButtonAtualizarFilmes = new javax.swing.JButton();
        jButtonExcluirFilmes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilmes = new javax.swing.JTable();
        txtBuscaFilmes = new javax.swing.JTextField();
        jButtonBuscarFilmes = new javax.swing.JButton();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiretor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonVoltarFilmes = new javax.swing.JButton();
        jPanelSalas = new javax.swing.JPanel();
        jButtonCadastrarSalas = new javax.swing.JButton();
        jButtonAtualizarSalas = new javax.swing.JButton();
        jButtonExcluirSalas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSalas = new javax.swing.JTable();
        txtBuscaSalas = new javax.swing.JTextField();
        jButtonBuscarSalas = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCapacidade = new javax.swing.JTextField();
        jButtonVoltarSalas = new javax.swing.JButton();
        jPanelSessoes = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonCadastroSessao = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButtonAtualizaSessao = new javax.swing.JButton();
        txtData = new javax.swing.JTextField();
        jButtonExcluiSessao = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButtonVendaIngresso = new javax.swing.JButton();
        txtHorario = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSessao = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtBuscaSessao = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jButtonBuscaSessoes = new javax.swing.JButton();
        jComboBoxSalas = new javax.swing.JComboBox<Object>();
        jComboBoxFilmes = new javax.swing.JComboBox<Object>();
        jButtonVoltarSessao = new javax.swing.JButton();
        txtQtdIngresso = new javax.swing.JTextField();
        jPanelDefault = new javax.swing.JPanel();
        jPanelClientes = new javax.swing.JPanel();
        jButtonCadastrarCLientes = new javax.swing.JButton();
        jButtonAtualizarCLientes = new javax.swing.JButton();
        jButtonExcluirCLientes = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        txtBuscaCliente = new javax.swing.JTextField();
        jButtonBuscarCliente = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButtonVoltarCLientes = new javax.swing.JButton();
        jPanelProdutos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButtonCadastroProduto = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtBuscaProduto = new javax.swing.JTextField();
        jButtonAtualizaProduto = new javax.swing.JButton();
        txtPontosProduto = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        jButtonBuscaProdutos = new javax.swing.JButton();
        jButtonExcluProduto = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButtonVendaProdutos = new javax.swing.JButton();
        jButtonVoltarProduto = new javax.swing.JButton();
        txtPreçoProduto = new javax.swing.JTextField();
        jPanelVendaProduto = new javax.swing.JPanel();

        jTextField5.setText("jTextField2");

        jLabel6.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(-5, -25));
        setName("CinePlus"); // NOI18N
        setResizable(false);

        jPanelLateral.setBackground(new java.awt.Color(204, 204, 255));

        jButtonFilmes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonFilmes.setText("Filmes");
        jButtonFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmesActionPerformed(evt);
            }
        });

        jButtonSalas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonSalas.setText("Salas");
        jButtonSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalasActionPerformed(evt);
            }
        });

        jButtonSessoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonSessoes.setText("Sessões");
        jButtonSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSessoesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Menu");

        jButtonAjuda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonAjuda.setText("Ajuda");
        jButtonAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjudaActionPerformed(evt);
            }
        });

        jButtonSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonProdutos.setText("Produtos");
        jButtonProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutosActionPerformed(evt);
            }
        });

        jButtonClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.setMaximumSize(new java.awt.Dimension(83, 23));
        jButtonClientes.setMinimumSize(new java.awt.Dimension(83, 23));
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLateralLayout = new javax.swing.GroupLayout(jPanelLateral);
        jPanelLateral.setLayout(jPanelLateralLayout);
        jPanelLateralLayout.setHorizontalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonSalas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonSessoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelLateralLayout.createSequentialGroup()
                .addGroup(jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLateralLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLateralLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(jButtonClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButtonFilmes)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalas)
                .addGap(18, 18, 18)
                .addComponent(jButtonSessoes)
                .addGap(18, 18, 18)
                .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAjuda)
                .addGap(4, 4, 4)
                .addComponent(jButtonSair)
                .addContainerGap())
        );

        jPanelPrincipal.setLayout(new javax.swing.OverlayLayout(jPanelPrincipal));

        jButtonCadastrarFilmes.setText("Cadastrar");
        jButtonCadastrarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarFilmesActionPerformed(evt);
            }
        });

        jButtonAtualizarFilmes.setText("Atualizar");
        jButtonAtualizarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarFilmesActionPerformed(evt);
            }
        });

        jButtonExcluirFilmes.setText("Excluir");
        jButtonExcluirFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirFilmesActionPerformed(evt);
            }
        });

        jTableFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Título", "Diretor", "Gênero", "Idioma", "Duração"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFilmesMouseClicked(evt);
            }
        });
        jTableFilmes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableFilmesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFilmes);
        if (jTableFilmes.getColumnModel().getColumnCount() > 0) {
            jTableFilmes.getColumnModel().getColumn(5).setHeaderValue("Duração");
        }

        jButtonBuscarFilmes.setText("Buscar");
        jButtonBuscarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFilmesActionPerformed(evt);
            }
        });

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        jLabel3.setText("Titulo:");

        jLabel4.setText("Diretor:");

        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });

        jLabel5.setText("Gênero:");

        jLabel7.setText("Idioma:");

        jLabel8.setText("Duração:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Filmes");

        jButtonVoltarFilmes.setText("Voltar");
        jButtonVoltarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarFilmesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFilmesLayout = new javax.swing.GroupLayout(jPanelFilmes);
        jPanelFilmes.setLayout(jPanelFilmesLayout);
        jPanelFilmesLayout.setHorizontalGroup(
            jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFilmesLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanelFilmesLayout.createSequentialGroup()
                        .addGap(0, 185, Short.MAX_VALUE)
                        .addComponent(jButtonCadastrarFilmes)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtualizarFilmes)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluirFilmes)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonVoltarFilmes)
                        .addContainerGap())
                    .addGroup(jPanelFilmesLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelFilmesLayout.createSequentialGroup()
                        .addComponent(txtBuscaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscarFilmes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFilmesLayout.createSequentialGroup()
                        .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFilmesLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDuracao))
                            .addGroup(jPanelFilmesLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiretor))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFilmesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTitulo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFilmesLayout.createSequentialGroup()
                                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdioma)
                                    .addComponent(txtGenero))))
                        .addGap(230, 230, 230))))
        );
        jPanelFilmesLayout.setVerticalGroup(
            jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarFilmes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanelFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrarFilmes)
                    .addComponent(jButtonAtualizarFilmes)
                    .addComponent(jButtonExcluirFilmes)
                    .addComponent(jButtonVoltarFilmes))
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelFilmes);

        jButtonCadastrarSalas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCadastrarSalas.setText("Cadastrar");
        jButtonCadastrarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarSalasActionPerformed(evt);
            }
        });

        jButtonAtualizarSalas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonAtualizarSalas.setText("Atualizar");
        jButtonAtualizarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarSalasActionPerformed(evt);
            }
        });

        jButtonExcluirSalas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonExcluirSalas.setText("Excluir");
        jButtonExcluirSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirSalasActionPerformed(evt);
            }
        });

        jTableSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Número da Sala", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSalasMouseClicked(evt);
            }
        });
        jTableSalas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableSalasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSalas);
        if (jTableSalas.getColumnModel().getColumnCount() > 0) {
            jTableSalas.getColumnModel().getColumn(0).setResizable(false);
            jTableSalas.getColumnModel().getColumn(1).setResizable(false);
            jTableSalas.getColumnModel().getColumn(2).setResizable(false);
        }

        txtBuscaSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaSalasActionPerformed(evt);
            }
        });

        jButtonBuscarSalas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonBuscarSalas.setText("Buscar");
        jButtonBuscarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarSalasActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setText("Salas");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Número:");

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Capacidade:");

        txtCapacidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadeActionPerformed(evt);
            }
        });

        jButtonVoltarSalas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonVoltarSalas.setText("Voltar");
        jButtonVoltarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarSalasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSalasLayout = new javax.swing.GroupLayout(jPanelSalas);
        jPanelSalas.setLayout(jPanelSalasLayout);
        jPanelSalasLayout.setHorizontalGroup(
            jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSalasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCadastrarSalas)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtualizarSalas)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluirSalas)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVoltarSalas)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSalasLayout.createSequentialGroup()
                        .addGroup(jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addGroup(jPanelSalasLayout.createSequentialGroup()
                                .addComponent(txtBuscaSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBuscarSalas)
                                .addGap(43, 43, 43)))
                        .addContainerGap())
                    .addGroup(jPanelSalasLayout.createSequentialGroup()
                        .addGroup(jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelSalasLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 257, Short.MAX_VALUE))))
        );
        jPanelSalasLayout.setVerticalGroup(
            jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSalasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarSalas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrarSalas)
                    .addComponent(jButtonAtualizarSalas)
                    .addComponent(jButtonExcluirSalas)
                    .addComponent(jButtonVoltarSalas))
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelSalas);

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel12.setText("Sessões");

        jLabel13.setText("Filme:");

        jButtonCadastroSessao.setText("Cadastrar");
        jButtonCadastroSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroSessaoActionPerformed(evt);
            }
        });

        jLabel14.setText("Sala:");

        jButtonAtualizaSessao.setText("Atualizar");
        jButtonAtualizaSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaSessaoActionPerformed(evt);
            }
        });

        jButtonExcluiSessao.setText("Excluir");
        jButtonExcluiSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluiSessaoActionPerformed(evt);
            }
        });

        jLabel15.setText("Data:");

        jButtonVendaIngresso.setText("Vender Ingresso");
        jButtonVendaIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaIngressoActionPerformed(evt);
            }
        });

        jTableSessao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código da Sessão", "Filme", "Sala", "Data", "Horario", "Valor/Ingresso", "Ingressos Disponiveis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSessao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSessaoMouseClicked(evt);
            }
        });
        jTableSessao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSessaoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableSessao);
        if (jTableSessao.getColumnModel().getColumnCount() > 0) {
            jTableSessao.getColumnModel().getColumn(2).setResizable(false);
            jTableSessao.getColumnModel().getColumn(4).setResizable(false);
            jTableSessao.getColumnModel().getColumn(4).setHeaderValue("Horario");
            jTableSessao.getColumnModel().getColumn(5).setResizable(false);
            jTableSessao.getColumnModel().getColumn(5).setHeaderValue("Valor/Ingresso");
            jTableSessao.getColumnModel().getColumn(6).setResizable(false);
            jTableSessao.getColumnModel().getColumn(6).setHeaderValue("Ingressos Disponiveis");
        }

        jLabel16.setText("Horário:");

        jLabel17.setText("Valor:");

        txtBuscaSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaSessaoActionPerformed(evt);
            }
        });

        jButtonBuscaSessoes.setText("Buscar");
        jButtonBuscaSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaSessoesActionPerformed(evt);
            }
        });

        jComboBoxFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxFilmesMouseClicked(evt);
            }
        });
        jComboBoxFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFilmesActionPerformed(evt);
            }
        });

        jButtonVoltarSessao.setText("Voltar");
        jButtonVoltarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarSessaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSessoesLayout = new javax.swing.GroupLayout(jPanelSessoes);
        jPanelSessoes.setLayout(jPanelSessoesLayout);
        jPanelSessoesLayout.setHorizontalGroup(
            jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSessoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSessoesLayout.createSequentialGroup()
                        .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSessoesLayout.createSequentialGroup()
                                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSessoesLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 51, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSessoesLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHorario)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelSessoesLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelSessoesLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane3)
                            .addGroup(jPanelSessoesLayout.createSequentialGroup()
                                .addComponent(txtBuscaSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBuscaSessoes)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelSessoesLayout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jButtonCadastroSessao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAtualizaSessao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExcluiSessao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVoltarSessao)))
                        .addContainerGap())
                    .addGroup(jPanelSessoesLayout.createSequentialGroup()
                        .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelSessoesLayout.createSequentialGroup()
                                .addComponent(jButtonVendaIngresso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQtdIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelSessoesLayout.setVerticalGroup(
            jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSessoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(11, 11, 11)
                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVendaIngresso)
                    .addComponent(txtQtdIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscaSessoes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastroSessao)
                    .addComponent(jButtonAtualizaSessao)
                    .addComponent(jButtonExcluiSessao)
                    .addComponent(jButtonVoltarSessao))
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelSessoes);

        javax.swing.GroupLayout jPanelDefaultLayout = new javax.swing.GroupLayout(jPanelDefault);
        jPanelDefault.setLayout(jPanelDefaultLayout);
        jPanelDefaultLayout.setHorizontalGroup(
            jPanelDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        jPanelDefaultLayout.setVerticalGroup(
            jPanelDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(jPanelDefault);

        jButtonCadastrarCLientes.setText("Cadastrar");
        jButtonCadastrarCLientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarCLientesActionPerformed(evt);
            }
        });

        jButtonAtualizarCLientes.setText("Atualizar");
        jButtonAtualizarCLientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarCLientesActionPerformed(evt);
            }
        });

        jButtonExcluirCLientes.setText("Excluir");
        jButtonExcluirCLientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirCLientesActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF", "Nascimento", "Pontos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jTableClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableClientesKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableClientes);

        jButtonBuscarCliente.setText("Buscar");
        jButtonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarClienteActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel18.setText("Nome:");

        jLabel19.setText("CPF:");

        txtNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNascimentoActionPerformed(evt);
            }
        });

        jLabel20.setText("Data de Nascimento:");

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel23.setText("Clientes");

        jButtonVoltarCLientes.setText("Voltar");
        jButtonVoltarCLientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarCLientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCadastrarCLientes)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtualizarCLientes)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluirCLientes)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonVoltarCLientes)
                        .addContainerGap())
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscarCliente)
                        .addContainerGap(151, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClientesLayout.createSequentialGroup()
                        .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelClientesLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelClientesLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome)))
                        .addGap(16, 16, 16))))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(31, 31, 31)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrarCLientes)
                    .addComponent(jButtonAtualizarCLientes)
                    .addComponent(jButtonExcluirCLientes)
                    .addComponent(jButtonVoltarCLientes))
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelClientes);

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Produto", "Preço", "Pontos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoMouseClicked(evt);
            }
        });
        jTableProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableProdutoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTableProduto);

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel21.setText("Produtos");

        jLabel24.setText("Preço:");

        jButtonCadastroProduto.setText("Cadastrar");
        jButtonCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroProdutoActionPerformed(evt);
            }
        });

        jLabel25.setText("Pontuação:");

        txtBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaProdutoActionPerformed(evt);
            }
        });

        jButtonAtualizaProduto.setText("Atualizar");
        jButtonAtualizaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaProdutoActionPerformed(evt);
            }
        });

        txtPontosProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPontosProdutoActionPerformed(evt);
            }
        });

        jButtonBuscaProdutos.setText("Buscar");
        jButtonBuscaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaProdutosActionPerformed(evt);
            }
        });

        jButtonExcluProduto.setText("Excluir");
        jButtonExcluProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluProdutoActionPerformed(evt);
            }
        });

        jLabel27.setText("Produto:");

        jButtonVendaProdutos.setText("Vender Produto");
        jButtonVendaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaProdutosActionPerformed(evt);
            }
        });

        jButtonVoltarProduto.setText("Voltar");
        jButtonVoltarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarProdutoActionPerformed(evt);
            }
        });

        txtPreçoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreçoProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProdutosLayout = new javax.swing.GroupLayout(jPanelProdutos);
        jPanelProdutos.setLayout(jPanelProdutosLayout);
        jPanelProdutosLayout.setHorizontalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProdutosLayout.createSequentialGroup()
                        .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jButtonCadastroProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAtualizaProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExcluProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(jButtonVoltarProduto))
                            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPreçoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPontosProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jButtonVendaProdutos)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanelProdutosLayout.createSequentialGroup()
                        .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProduto))
                            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProdutosLayout.createSequentialGroup()
                        .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                                .addComponent(txtBuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBuscaProdutos)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanelProdutosLayout.setVerticalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(10, 10, 10)
                .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreçoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtPontosProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jButtonVendaProdutos))
                .addGap(18, 18, 18)
                .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscaProdutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastroProduto)
                    .addComponent(jButtonAtualizaProduto)
                    .addComponent(jButtonExcluProduto)
                    .addComponent(jButtonVoltarProduto))
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelProdutos);

        javax.swing.GroupLayout jPanelVendaProdutoLayout = new javax.swing.GroupLayout(jPanelVendaProduto);
        jPanelVendaProduto.setLayout(jPanelVendaProdutoLayout);
        jPanelVendaProdutoLayout.setHorizontalGroup(
            jPanelVendaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelVendaProdutoLayout.setVerticalGroup(
            jPanelVendaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(jPanelVendaProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmesActionPerformed
        // TODO add your handling code here:
        jPanelFilmes.setVisible(true);
        jPanelSalas.setVisible(false);
        jPanelSessoes.setVisible(false);
        
        txtTitulo.setText("");
        txtDiretor.setText("");
        txtGenero.setText("");
        txtIdioma.setText("");
        txtDuracao.setText("");
        
        readJTableFilmes();
    }//GEN-LAST:event_jButtonFilmesActionPerformed

    private void jButtonSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalasActionPerformed
        // TODO add your handling code here:
        jPanelSalas.setVisible(true);
        jPanelFilmes.setVisible(false);
        jPanelSessoes.setVisible(false);
        
        txtBuscaSalas.setText("");
        txtNumero.setText("");
        txtCapacidade.setText("");
        
        readJTableSala();
    }//GEN-LAST:event_jButtonSalasActionPerformed

    private void jButtonSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSessoesActionPerformed
        // TODO add your handling code here:
        jPanelSessoes.setVisible(true);
        jPanelFilmes.setVisible(false);
        jPanelSalas.setVisible(false);
        
        txtBuscaSessao.setText("");
        txtData.setText("");
        txtHorario.setText("");
        txtValor.setText("");
        txtQtdIngresso.setText("");
        
        readJTableSessao();
    }//GEN-LAST:event_jButtonSessoesActionPerformed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void jButtonCadastrarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarFilmesActionPerformed
        // TODO add your handling code here:
        String textoTitulo = txtTitulo.getText();
        String textoDiretor = txtDiretor.getText();
        String textoGenero = txtGenero.getText();
        String textoIdioma = txtIdioma.getText();
        String textoDuracao = txtDuracao.getText();
        String textoVazio = "";
        
        
        if(textoGenero.equals(textoVazio) || textoIdioma.equals(textoVazio) || textoDuracao.equals(textoVazio) || textoTitulo.equals(textoVazio) || textoDiretor.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Filme f = new Filme();
        FilmeDAO daoFilme = new FilmeDAO();
        f.setTitulo(txtTitulo.getText());
        f.setDiretor(txtDiretor.getText());
        f.setGenero(txtGenero.getText());
        f.setIdioma(txtIdioma.getText());
        f.setDuracao(Integer.parseInt(txtDuracao.getText()));
        daoFilme.createFilme(f);
        jComboBoxFilmes.removeAllItems();
        carregaCBoxF();
        readJTableFilmes();
        txtTitulo.setText("");
        txtDiretor.setText("");
        txtGenero.setText("");
        txtIdioma.setText("");
        txtDuracao.setText("");
        }
    }//GEN-LAST:event_jButtonCadastrarFilmesActionPerformed

    private void jButtonExcluirFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirFilmesActionPerformed
        // TODO add your handling code here:
        if (jTableFilmes.getSelectedRow() != -1) {
            Filme f = new Filme();
            FilmeDAO dao = new FilmeDAO();

            f.setIdFilme((int) jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 0));
            dao.deleteFilme(f);

            readJTableFilmes();

            txtTitulo.setText("");
            txtDiretor.setText("");
            txtGenero.setText("");
            txtIdioma.setText("");
            txtDuracao.setText("");
            
            jComboBoxFilmes.removeAllItems();
            carregaCBoxF();
        }
    }//GEN-LAST:event_jButtonExcluirFilmesActionPerformed

    private void jButtonCadastrarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarSalasActionPerformed
        // TODO add your handling code here:
        String textoNumero = txtNumero.getText();
        String textoCapacidade = txtCapacidade.getText();
        String textoVazio = "";
        
        
        if(textoNumero.equals(textoVazio) || textoCapacidade.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Sala s = new Sala();
        SalaDAO daoSala = new SalaDAO();
        s.setNumero(Integer.parseInt(txtNumero.getText()));
        s.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
        daoSala.createSala(s);
        readJTableSala();
        jComboBoxSalas.removeAllItems();
        carregaCBoxS();
        }

    }//GEN-LAST:event_jButtonCadastrarSalasActionPerformed

    private void jButtonBuscaSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaSessoesActionPerformed
        // TODO add your handling code here:
        String textoBuscaSe = txtBuscaSessao.getText();
        String textoVazio = "";
        
        
        if(textoBuscaSe.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "O campo de busca não pode estar vazio!");
        }else{
        readJTableForSearchSessao(txtBuscaSessao.getText());
        }
    }//GEN-LAST:event_jButtonBuscaSessoesActionPerformed

    private void jButtonVendaIngressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaIngressoActionPerformed
        // TODO add your handling code here:
        String textoData = txtData.getText();
        String textoHorario = txtHorario.getText();
        String textoValor = txtValor.getText();
        String textoValorI = txtQtdIngresso.getText();
        String textoVazio = "";
        
        
        if(textoData.equals(textoVazio) || textoHorario.equals(textoVazio) || textoValor.equals(textoVazio) || textoValorI.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "O campo de quantidade de ingressos esta vazio!");
        }else{
        Sessao se = new Sessao();
        SessaoDAO daoSessao = new SessaoDAO();
        int ingressosD = ((int) jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 6));
        int compraIng = (Integer.parseInt(txtQtdIngresso.getText()));
        se.setIngressosDisponiveis(ingressosD);
        se.setIngVendido(compraIng);
        se.setIdSessao((int) jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 0));

            try {
                daoSessao.vendaIngresso(se);
            } catch (SQLException ex) {
                Logger.getLogger(ViewMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        readJTableSessao();
        }
    }//GEN-LAST:event_jButtonVendaIngressoActionPerformed

    private void txtCapacidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadeActionPerformed

    private void jButtonVoltarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarFilmesActionPerformed
        // TODO add your handling code here:
        jPanelDefault.setVisible(true);
        jPanelFilmes.setVisible(false);
        jPanelSalas.setVisible(false);
        jPanelSessoes.setVisible(false);
    }//GEN-LAST:event_jButtonVoltarFilmesActionPerformed

    private void jButtonVoltarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarSessaoActionPerformed
        // TODO add your handling code here:
        jPanelDefault.setVisible(true);
        jPanelFilmes.setVisible(false);
        jPanelSalas.setVisible(false);
        jPanelSessoes.setVisible(false);
    }//GEN-LAST:event_jButtonVoltarSessaoActionPerformed

    private void jButtonVoltarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarSalasActionPerformed
        // TODO add your handling code here:
        jPanelDefault.setVisible(true);
        jPanelFilmes.setVisible(false);
        jPanelSalas.setVisible(false);
        jPanelSessoes.setVisible(false);
    }//GEN-LAST:event_jButtonVoltarSalasActionPerformed

    private void jTableFilmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilmesMouseClicked
        // TODO add your handling code here:
        if (jTableFilmes.getSelectedRow() != -1) {
            txtTitulo.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 1).toString());
            txtDiretor.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 2).toString());
            txtGenero.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 3).toString());
            txtIdioma.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 4).toString());
            txtDuracao.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTableFilmesMouseClicked

    private void jButtonBuscarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFilmesActionPerformed
        // TODO add your handling code here:
        String textoBuscaF = txtBuscaFilmes.getText();
        String textoVazio = "";
        
        
        if(textoBuscaF.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "O campo de busca não pode estar vazio!");
        }else{
        readJTableForSearchFilmes(txtBuscaFilmes.getText());
        }
    }//GEN-LAST:event_jButtonBuscarFilmesActionPerformed

    private void jTableFilmesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFilmesKeyReleased
        // TODO add your handling code here:
        if (jTableFilmes.getSelectedRow() != -1) {
            txtTitulo.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 1).toString());
            txtDiretor.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 2).toString());
            txtGenero.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 3).toString());
            txtIdioma.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 4).toString());
            txtDuracao.setText(jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jTableFilmesKeyReleased

    private void jButtonAtualizarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarFilmesActionPerformed
        // TODO add your handling code here:
        String textoTitulo = txtTitulo.getText();
        String textoDiretor = txtDiretor.getText();
        String textoGenero = txtGenero.getText();
        String textoIdioma = txtIdioma.getText();
        String textoDuracao = txtDuracao.getText();
        String textoVazio = "";
        
        
        if(textoGenero.equals(textoVazio) || textoIdioma.equals(textoVazio) || textoDuracao.equals(textoVazio) || textoTitulo.equals(textoVazio) || textoDiretor.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Filme f = new Filme();
        FilmeDAO daoFilme = new FilmeDAO();
        f.setTitulo(txtTitulo.getText());
        f.setDiretor(txtDiretor.getText());
        f.setGenero(txtGenero.getText());
        f.setIdioma(txtIdioma.getText());
        f.setDuracao(Integer.parseInt(txtDuracao.getText()));
        f.setIdFilme((int) jTableFilmes.getValueAt(jTableFilmes.getSelectedRow(), 0));
        daoFilme.updateFilme(f);

        jComboBoxFilmes.removeAllItems();
        carregaCBoxF();
        readJTableFilmes();

        txtTitulo.setText("");
        txtDiretor.setText("");
        txtGenero.setText("");
        txtIdioma.setText("");
        txtDuracao.setText("");
        }
    }//GEN-LAST:event_jButtonAtualizarFilmesActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void jButtonAtualizarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarSalasActionPerformed
        // TODO add your handling code here:
        String textoNumero = txtNumero.getText();
        String textoCapacidade = txtCapacidade.getText();
        String textoVazio = "";
        
        
        if(textoNumero.equals(textoVazio) || textoCapacidade.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Sala s = new Sala();
        SalaDAO daoSala = new SalaDAO();
        s.setNumero(Integer.parseInt(txtNumero.getText()));
        s.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
        s.setIdSala((int) jTableSalas.getValueAt(jTableSalas.getSelectedRow(), 0));
        daoSala.updateSala(s);

        jComboBoxSalas.removeAllItems();
        carregaCBoxS();
        readJTableSala();
        }
    }//GEN-LAST:event_jButtonAtualizarSalasActionPerformed

    private void jButtonExcluirSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirSalasActionPerformed
        // TODO add your handling code here:
        if (jTableSalas.getSelectedRow() != -1) {
            Sala s = new Sala();
            SalaDAO sdao = new SalaDAO();

            s.setIdSala((int) jTableSalas.getValueAt(jTableSalas.getSelectedRow(), 0));
            sdao.deleteSala(s);

            readJTableSala();
            jComboBoxSalas.removeAllItems();
            carregaCBoxS();
        }
    }//GEN-LAST:event_jButtonExcluirSalasActionPerformed

    private void jButtonBuscarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarSalasActionPerformed
        // TODO add your handling code here:
        String textoBuscaSa = txtBuscaSalas.getText();
        String textoVazio = "";
        
        
        if(textoBuscaSa.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "O campo de busca não pode estar vazio!");
        }else{
        readJTableForSearchSalas(Integer.parseInt(txtBuscaSalas.getText()));
        }
    }//GEN-LAST:event_jButtonBuscarSalasActionPerformed

    private void jComboBoxFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFilmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFilmesActionPerformed

    private void jComboBoxFilmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxFilmesMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxFilmesMouseClicked

    private void jButtonCadastroSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroSessaoActionPerformed
        // TODO add your handling code here:
        String textoData = txtData.getText();
        String textoHorario = txtHorario.getText();
        String textoValor = txtValor.getText();
        String textoVazio = "";
        
        
        if(textoData.equals(textoVazio) || textoHorario.equals(textoVazio) || textoValor.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Sessao se = new Sessao();
        Filme f = (Filme) jComboBoxFilmes.getSelectedItem();
        Sala s = (Sala) jComboBoxSalas.getSelectedItem();
        SessaoDAO daoSessao = new SessaoDAO();
        se.setFilme(f.getTitulo());
        se.setSala(s.getNumero());
        se.setData((String) (txtData.getText()));
        se.setHorario((String) (txtHorario.getText()));
        se.setValorIngresso(Integer.parseInt(txtValor.getText()));
        se.setIngressosDisponiveis(s.getCapacidade());
        daoSessao.createSessao(se);
        readJTableSessao();
        }
    }//GEN-LAST:event_jButtonCadastroSessaoActionPerformed

    private void jButtonAtualizaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaSessaoActionPerformed
        // TODO add your handling code here:
        String textoData = txtData.getText();
        String textoHorario = txtHorario.getText();
        String textoValor = txtValor.getText();
        String textoVazio = "";
        
        
        if(textoData.equals(textoVazio) || textoHorario.equals(textoVazio) || textoValor.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Sessao se = new Sessao();
        Filme f = (Filme) jComboBoxFilmes.getSelectedItem();
        Sala s = (Sala) jComboBoxSalas.getSelectedItem();
        SessaoDAO daoSessao = new SessaoDAO();
        se.setFilme(f.getTitulo());
        se.setSala(s.getNumero());
        se.setData((String) (txtData.getText()));
        se.setHorario((String) (txtHorario.getText()));
        se.setValorIngresso(Integer.parseInt(txtValor.getText()));
        se.setIngressosDisponiveis((int) jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 6));
        se.setIdSessao((int) jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 0));

        daoSessao.updateSessao(se);
        readJTableSessao();
        }
    }//GEN-LAST:event_jButtonAtualizaSessaoActionPerformed

    private void jButtonExcluiSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluiSessaoActionPerformed
        // TODO add your handling code here:
        if (jTableSessao.getSelectedRow() != -1) {
            Sessao se = new Sessao();
            SessaoDAO sedao = new SessaoDAO();

            se.setIdSessao((int) jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 0));
            sedao.deleteSessão(se);

            readJTableSessao();
        }
    }//GEN-LAST:event_jButtonExcluiSessaoActionPerformed

    private void jTableSessaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSessaoMouseClicked
        // TODO add your handling code here:
        if (jTableSessao.getSelectedRow() != -1) {
            jComboBoxFilmes.setSelectedItem(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 1).toString());
            jComboBoxSalas.setSelectedItem(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 2).toString());
            txtData.setText(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 3).toString());
            txtHorario.setText(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 4).toString());
            txtValor.setText(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 5).toString());

        }
    }//GEN-LAST:event_jTableSessaoMouseClicked

    private void jTableSessaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSessaoKeyReleased
        // TODO add your handling code here:
        if (jTableSessao.getSelectedRow() != -1) {
            jComboBoxFilmes.setSelectedItem(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 1).toString());
            jComboBoxSalas.setSelectedItem(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 2).toString());
            txtData.setText(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 3).toString());
            txtHorario.setText(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 4).toString());
            txtValor.setText(jTableSessao.getValueAt(jTableSessao.getSelectedRow(), 5).toString());

        }
    }//GEN-LAST:event_jTableSessaoKeyReleased

    private void txtBuscaSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaSalasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaSalasActionPerformed

    private void jTableSalasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSalasKeyPressed
        // TODO add your handling code here:
        if (jTableSalas.getSelectedRow() != -1) {
            txtNumero.setText(jTableSalas.getValueAt(jTableSalas.getSelectedRow(), 1).toString());
            txtCapacidade.setText(jTableSalas.getValueAt(jTableSalas.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_jTableSalasKeyPressed

    private void jTableSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSalasMouseClicked
        // TODO add your handling code here:
        if (jTableSalas.getSelectedRow() != -1) {
            txtNumero.setText(jTableSalas.getValueAt(jTableSalas.getSelectedRow(), 1).toString());
            txtCapacidade.setText(jTableSalas.getValueAt(jTableSalas.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_jTableSalasMouseClicked

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjudaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ainda estamos trabalhando nisso, para qualquer dúvida entre em contato no email");
    }//GEN-LAST:event_jButtonAjudaActionPerformed

    private void txtBuscaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaSessaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaSessaoActionPerformed

    private void jButtonProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutosActionPerformed
        // TODO add your handling code here:
        jPanelFilmes.setVisible(false);
        jPanelSalas.setVisible(false);
        jPanelSessoes.setVisible(false);
        jPanelClientes.setVisible(false);
        jPanelDefault.setVisible(false);
        jPanelProdutos.setVisible(true);
        
        
        txtPontosProduto.setText("");
        txtPreçoProduto.setText("");
        txtProduto.setText("");
        
        readJTableProdutos();
    }//GEN-LAST:event_jButtonProdutosActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonCadastrarCLientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarCLientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarCLientesActionPerformed

    private void jButtonAtualizarCLientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarCLientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAtualizarCLientesActionPerformed

    private void jButtonExcluirCLientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirCLientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirCLientesActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jTableClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableClientesKeyReleased

    private void jButtonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarClienteActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNascimentoActionPerformed

    private void jButtonVoltarCLientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarCLientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarCLientesActionPerformed

    private void jTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoMouseClicked
        // TODO add your handling code here:
        if (jTableProduto.getSelectedRow() != -1) {
            txtProduto.setText(jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 1).toString());
            txtPreçoProduto.setText(jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 2).toString());
            txtPontosProduto.setText(jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_jTableProdutoMouseClicked

    private void jTableProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableProdutoKeyReleased
        // TODO add your handling code here:
        if (jTableProduto.getSelectedRow() != -1) {
            txtProduto.setText(jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 1).toString());
            txtPreçoProduto.setText(jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 2).toString());
            txtPontosProduto.setText(jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_jTableProdutoKeyReleased

    private void jButtonCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroProdutoActionPerformed
        // TODO add your handling code here:
        String textoProduto = txtProduto.getText();
        String textoPreco = txtPreçoProduto.getText();
        String textoPontos = txtPontosProduto.getText();
        String textoVazio = "";
        
        
        if(textoProduto.equals(textoVazio) || textoPreco.equals(textoVazio) || textoPontos.equals(textoVazio) || textoPontos.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Produto p = new Produto();
        ProdutoDAO daoProduto = new ProdutoDAO();
        p.setNomeProduto(textoProduto);
        p.setPontosProd(Integer.parseInt(textoPontos));
        p.setPreco(Float.parseFloat(textoPreco));
        daoProduto.createProduto(p);
        readJTableProdutos();
        txtProduto.setText("");
        txtPreçoProduto.setText("");
        txtPontosProduto.setText("");
        }
    }//GEN-LAST:event_jButtonCadastroProdutoActionPerformed

    private void txtBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaProdutoActionPerformed

    private void jButtonAtualizaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaProdutoActionPerformed
        // TODO add your handling code here:
        String textoProduto = txtProduto.getText();
        String textoPreco = txtPreçoProduto.getText();
        String textoPontos = txtPontosProduto.getText();
        String textoVazio = "";
        
        if(textoProduto.equals(textoVazio) || textoPreco.equals(textoVazio) || textoPontos.equals(textoVazio)){
            JOptionPane.showMessageDialog(null, "Os campos de texto não podem estar vazio!");
        }else{
        Produto p = new Produto();
        ProdutoDAO daoProduto = new ProdutoDAO();
        p.setNomeProduto(txtProduto.getText());
        p.setPontosProd(Integer.parseInt(txtPontosProduto.getText()));
        p.setPreco(Float.parseFloat(txtPontosProduto.getText()));
        p.setIdProduto((int) jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 0));
        daoProduto.updateProduto(p);

        readJTableProdutos();
        }
    }//GEN-LAST:event_jButtonAtualizaProdutoActionPerformed

    private void jButtonBuscaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscaProdutosActionPerformed

    private void jButtonExcluProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluProdutoActionPerformed
        // TODO add your handling code here:
        if (jTableProduto.getSelectedRow() != -1) {
            Produto p = new Produto();
            ProdutoDAO pdao = new ProdutoDAO();

            p.setIdProduto((int) jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 0));
            pdao.deleteProduto(p);

            readJTableProdutos();
        }
    }//GEN-LAST:event_jButtonExcluProdutoActionPerformed

    private void jButtonVendaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVendaProdutosActionPerformed

    private void jButtonVoltarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarProdutoActionPerformed

    private void txtPreçoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreçoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreçoProdutoActionPerformed

    private void txtPontosProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPontosProdutoActionPerformed
        // TODO add your handling code here:]
    }//GEN-LAST:event_txtPontosProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAjuda;
    private javax.swing.JButton jButtonAtualizaProduto;
    private javax.swing.JButton jButtonAtualizaSessao;
    private javax.swing.JButton jButtonAtualizarCLientes;
    private javax.swing.JButton jButtonAtualizarFilmes;
    private javax.swing.JButton jButtonAtualizarSalas;
    private javax.swing.JButton jButtonBuscaProdutos;
    private javax.swing.JButton jButtonBuscaSessoes;
    private javax.swing.JButton jButtonBuscarCliente;
    private javax.swing.JButton jButtonBuscarFilmes;
    private javax.swing.JButton jButtonBuscarSalas;
    private javax.swing.JButton jButtonCadastrarCLientes;
    private javax.swing.JButton jButtonCadastrarFilmes;
    private javax.swing.JButton jButtonCadastrarSalas;
    private javax.swing.JButton jButtonCadastroProduto;
    private javax.swing.JButton jButtonCadastroSessao;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonExcluProduto;
    private javax.swing.JButton jButtonExcluiSessao;
    private javax.swing.JButton jButtonExcluirCLientes;
    private javax.swing.JButton jButtonExcluirFilmes;
    private javax.swing.JButton jButtonExcluirSalas;
    private javax.swing.JButton jButtonFilmes;
    private javax.swing.JButton jButtonProdutos;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalas;
    private javax.swing.JButton jButtonSessoes;
    private javax.swing.JButton jButtonVendaIngresso;
    private javax.swing.JButton jButtonVendaProdutos;
    private javax.swing.JButton jButtonVoltarCLientes;
    private javax.swing.JButton jButtonVoltarFilmes;
    private javax.swing.JButton jButtonVoltarProduto;
    private javax.swing.JButton jButtonVoltarSalas;
    private javax.swing.JButton jButtonVoltarSessao;
    private javax.swing.JComboBox<Object> jComboBoxFilmes;
    private javax.swing.JComboBox<Object> jComboBoxSalas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelDefault;
    private javax.swing.JPanel jPanelFilmes;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JPanel jPanelSalas;
    private javax.swing.JPanel jPanelSessoes;
    private javax.swing.JPanel jPanelVendaProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableFilmes;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JTable jTableSalas;
    private javax.swing.JTable jTableSessao;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtBuscaCliente;
    private javax.swing.JTextField txtBuscaFilmes;
    private javax.swing.JTextField txtBuscaProduto;
    private javax.swing.JTextField txtBuscaSalas;
    private javax.swing.JTextField txtBuscaSessao;
    private javax.swing.JTextField txtCapacidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPontosProduto;
    private javax.swing.JTextField txtPreçoProduto;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtdIngresso;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
