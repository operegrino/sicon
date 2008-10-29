/*
 * TelaProduto.java
 *
 * Created on 19 de Agosto de 2008, 23:18
 */

package Telas.Formulario;

import Classes.Funcoes;
import Classes.composicaocentesimal;
import Controller.ControllerProduto;
import Telas.Componentes.TelaInterna;
import Telas.Tabelas.JTableProduto;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaProduto extends TelaAncestral implements InterfacePadraoTelaVarias{

    /** Creates new form BeanForm */
    //usado para retorno de valor p outra tela
    private TelaComposicaoCentesimal telaComposicaoCentesimal;
    private ControllerProduto Controller;
    private Vector ListaUnidadeEmbalagem;
    private Vector ListaUnidadeEstoque;
    private Integer idComposicao;
    private Vector  ListaProduto;
    private Integer idProduto;
    private TelaFornecedorProduto telaFornecedorProduto;
    private TelaFichaTecnica telaFichaTecnica;
    private TelaMovimentacao telaEstoque;
    private TelaProduto telaProduto;
    private TelaSaldoEstoque telaSaldoEstoque;
    private TelaOrdemProducao telaOrdemProducao;
    private TelaPedido telaPedido;
    private TelaFornecedor telaFornecedor;
    
    
    public TelaProduto() {
        initComponents();
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnCadastro, this.jpnPesquisa, this.jpnTela);
        super.setTitulo("Produto");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);           
        Controller = new ControllerProduto();
        ListaUnidadeEmbalagem = new Vector();
        ListaUnidadeEstoque = new Vector();
        idComposicao = null;
        ListaProduto = new Vector();
        CarregarCombosUnidades();
    }  
    
    public void CarregaListasUnidades(){
        ListaUnidadeEmbalagem = Controller.EventoRetornaTodasUnidades();
        ListaUnidadeEstoque = Controller.EventoRetornaTodasUnidades();
    }
    
    public void CarregarCombosUnidades(){
        CarregaListasUnidades();
        Vector v = new Vector();
        for (Iterator<Object[]> it = ListaUnidadeEmbalagem.iterator(); it.hasNext();) {
            Object[] object = it.next();
            v.add(object[1]);
        }
        jcbunidadeEmbalagem.setModel(new DefaultComboBoxModel(v));
        jcbunidadeEstoque.setModel(new DefaultComboBoxModel(v));
    }
    
     /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
            if (super.getLocalizacao() == 0) {
                if (Controller.EventoExcluir(RetornaId(jtbProduto.getSelectedRow()))) {
                    Excluiu = true;
                } 
            } else if (Controller.EventoExcluir()) { 
                Excluiu = true;
            }
            if (Excluiu) {
                JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(5), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));     
                Excluiu = true;
                this.ComportamentoPesquisar();
            } else {
                JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(6), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));                
            }                 
        }
        return Excluiu;
    }

    @Override
    protected boolean ComportamentoSalvar() {
        return Gravar();
    }  
    
    private boolean Gravar(){
        boolean Gravou = false;
        if (super.VerificaCampos(jpnCadastro,1)) {
            if (super.Operacao == 0) {                                 
                if (Controller.EventoSalvar(TelaParaController())) {
                    idComposicao = Controller.RetornaIdComposicao();
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));             
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png")); 
            } else if (super.Operacao == 1) {
                if (Controller.EventoAlterar(TelaParaController())) {
                    idComposicao = Controller.RetornaIdComposicao();
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(4), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png")); 
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));                    
                }
            } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png")); 
        return Gravou;        
    } 

    @Override
    protected void ComportamentoNovo() {
        LimparFormulario(jpnPesquisa);     
        jcbunidadeEmbalagem.setSelectedIndex(0);
        jcbunidadeEstoque.setSelectedIndex(0);
        idProduto = null;
        idComposicao = null;
    }

    @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = new ArrayList();
        ListaParametros = setParametros();
        ListaProduto = (Vector) Controller.EventoPesquisar(ListaParametros);
        if (!(ListaProduto.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbProduto.setModel(new JTableProduto(ListaProduto)); 
        return Achou;
    }    
    
    @Override
    public void setDesktopPane(JDesktopPane Pane) {
        super.TelaPrincipal = Pane;
    }    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnTela = new javax.swing.JPanel();
        jpnPesquisa = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfEstoqueMinimo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jtfQtdeEmbalagem = new javax.swing.JTextField();
        jcbAlimentar = new javax.swing.JCheckBox();
        jcbunidadeEstoque = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcbunidadeEmbalagem = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jtfTemperaturaEntrega = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfValor = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jbtComposicao = new javax.swing.JButton();
        jpnCadastro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProduto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfCodigoProdPesq = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfDescricaoPesq = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbAlimentarPesq = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jtfEstoquePesq = new javax.swing.JTextField();
        jtfValorPesq = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfFornecedorPesq = new javax.swing.JTextField();
        jbtFornecedorPesq = new javax.swing.JButton();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnCadastro"); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("* Código"); // NOI18N

        jtfDescricao.setName("jtfDescricao"); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("* Descrição"); // NOI18N

        jtfCodigo.setName("jtfCodigo"); // NOI18N

        jLabel8.setText("Unidade"); // NOI18N

        jtfEstoqueMinimo.setName("jtfEstoqueMinimo"); // NOI18N

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Quantidade da Embalagem"); // NOI18N

        jtfQtdeEmbalagem.setName("jtfQtdeEmbalagem"); // NOI18N

        jcbAlimentar.setBackground(new java.awt.Color(243, 243, 243));
        jcbAlimentar.setText("Alimentar"); // NOI18N
        jcbAlimentar.setName("jcbAlimentar"); // NOI18N

        jcbunidadeEstoque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KG" }));
        jcbunidadeEstoque.setName("jcbunidadeEstoque"); // NOI18N
        jcbunidadeEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbunidadeEstoqueActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Estoque Mínimo"); // NOI18N

        jLabel10.setText("Unidade"); // NOI18N

        jcbunidadeEmbalagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KG" }));
        jcbunidadeEmbalagem.setName("jcbunidadeEmbalagem"); // NOI18N

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Temperatura de Entrega"); // NOI18N

        jtfTemperaturaEntrega.setName("jtfTemperaturaEntrega"); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("* Valor"); // NOI18N

        jtfValor.setName("jtfValor"); // NOI18N

        jPanel8.setBackground(new java.awt.Color(243, 243, 243));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbtComposicao.setText("Composição"); // NOI18N
        jbtComposicao.setToolTipText("insira a composição centesimal caso for alimento"); // NOI18N
        jbtComposicao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtComposicao.setIconTextGap(2);
        jbtComposicao.setName("jbtComposicao"); // NOI18N
        jbtComposicao.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jbtComposicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtComposicaoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtComposicao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtComposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnPesquisaLayout = new javax.swing.GroupLayout(jpnPesquisa);
        jpnPesquisa.setLayout(jpnPesquisaLayout);
        jpnPesquisaLayout.setHorizontalGroup(
            jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(2, 2, 2)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEstoqueMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jtfValor, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jtfQtdeEmbalagem, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jtfTemperaturaEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAlimentar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPesquisaLayout.createSequentialGroup()
                                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(11, 11, 11)
                                        .addComponent(jcbunidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(11, 11, 11)
                                        .addComponent(jcbunidadeEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(229, 229, 229))))
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                .addGap(188, 188, 188))
        );
        jpnPesquisaLayout.setVerticalGroup(
            jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbAlimentar)))
                .addGap(10, 10, 10)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfQtdeEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTemperaturaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbunidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbunidadeEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.CENTER);

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnPesquisa"); // NOI18N
        jpnCadastro.setPreferredSize(new java.awt.Dimension(100, 150));
        jpnCadastro.setLayout(new java.awt.BorderLayout());

        jtbProduto.setBackground(new java.awt.Color(243, 243, 243));
        jtbProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Valor", "Estoque Mínimo", "Alimentar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbProduto.setName("jtbProduto"); // NOI18N
        jtbProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbProdutoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbProduto);

        jpnCadastro.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Código"); // NOI18N

        jtfCodigoProdPesq.setName("jtfCodigoProdPesq"); // NOI18N
        jtfCodigoProdPesq.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descrição"); // NOI18N

        jtfDescricaoPesq.setName("jtfDescricaoPesq"); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Valor"); // NOI18N

        jcbAlimentarPesq.setBackground(new java.awt.Color(243, 243, 243));
        jcbAlimentarPesq.setText("Alimentar"); // NOI18N
        jcbAlimentarPesq.setName("jcbAlimentarPesq"); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Estoque Mínimo"); // NOI18N

        jtfEstoquePesq.setName("jtfEstoquePesq"); // NOI18N

        jtfValorPesq.setName("jtfValorPesq"); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Fornecedor");

        jtfFornecedorPesq.setName("jtfFornecedorPesq"); // NOI18N

        jbtFornecedorPesq.setText("jButton1");
        jbtFornecedorPesq.setName("jbtFornecedorPesq"); // NOI18N
        jbtFornecedorPesq.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtFornecedorPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFornecedorPesqMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoProdPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDescricaoPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(jcbAlimentarPesq)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfValorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEstoquePesq, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(314, 314, 314))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfDescricaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodigoProdPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbAlimentarPesq)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfValorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfEstoquePesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );

        jpnCadastro.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jcbunidadeEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbunidadeEstoqueActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbunidadeEstoqueActionPerformed

private void jbtComposicaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtComposicaoMousePressed
    InstaciaTelaComposicao();

}//GEN-LAST:event_jbtComposicaoMousePressed

private void InstaciaTelaComposicao(){
    telaComposicaoCentesimal = new TelaComposicaoCentesimal(); 
    telaComposicaoCentesimal.setTipoVisualizacao(1); 
    telaComposicaoCentesimal.Selecionar(idProduto);
    super.TituloTela = "Composição Centesimal";
    telaComposicaoCentesimal.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaComposicaoCentesimal);
}

public void setarComposicao(TelaComposicaoCentesimal composicao) {
    this.telaComposicaoCentesimal = composicao;
}

public void setTelaFornecedorProduto(TelaFornecedorProduto tela){
        this.telaFornecedorProduto = tela;
}

public void setTelaMovimentacao(TelaMovimentacao tela){
        this.telaEstoque = tela;
}

public void setTelaFichaTecnica(TelaFichaTecnica tela){
        this.telaFichaTecnica = tela;
}

public void setTelaSaldoEstoque(TelaSaldoEstoque tela){
        this.telaSaldoEstoque = tela;
}

public void setTelaOrdemProducao(TelaOrdemProducao tela) {
    this.telaOrdemProducao = tela;
}

public void setTelaPedido(TelaPedido tela) {
    this.telaPedido = tela;
}

private void jtbProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProdutoMousePressed
    if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbProduto.getSelectedRow())));
            super.ComportamentoSelecionar();
        } else {
            int Posicao = jtbProduto.getSelectedRow();   
            if (telaComposicaoCentesimal != null) {
                this.telaComposicaoCentesimal.setCamposProduto(Integer.parseInt(((Vector)ListaProduto.get(Posicao)).get(0).toString()), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString());                
            } else if (telaFornecedorProduto != null) {
                this.telaFornecedorProduto.SetarCamposProduto(Integer.parseInt(((Vector)ListaProduto.get(Posicao)).get(0).toString()), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString());                
            } else if (telaFichaTecnica != null) {
                this.telaFichaTecnica.SetarCamposProduto(Integer.parseInt(((Vector)ListaProduto.get(Posicao)).get(0).toString()), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString());                                
            } else if (telaEstoque != null) {
                this.telaEstoque.SetarCamposProduto(Integer.parseInt(((Vector)ListaProduto.get(Posicao)).get(0).toString()), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString());                                
            } else if (telaSaldoEstoque != null) {
                this.telaSaldoEstoque.SetarCamposProduto(Integer.parseInt(((Vector)ListaProduto.get(Posicao)).get(0).toString()), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString());                                    
            } else if (telaOrdemProducao != null) {
                this.telaOrdemProducao.SetarCamposProduto(Integer.parseInt(((Vector)ListaProduto.get(Posicao)).get(0).toString()), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString()); 
            } else if (telaPedido != null) {
                this.telaPedido.SetarCamposProduto(((Vector)ListaProduto.get(Posicao)).get(0).toString(), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString()); 
            }    
            super.FechaFrameInterno();            
          }
    }    
}//GEN-LAST:event_jtbProdutoMousePressed

private void jbtFornecedorPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFornecedorPesqMousePressed
InstaciaTelaFornecedor();
}//GEN-LAST:event_jbtFornecedorPesqMousePressed

private void InstaciaTelaFornecedor(){
    telaFornecedor = new TelaFornecedor(); 
    telaFornecedor.setTipoVisualizacao(1); 
    telaFornecedor.setTelaProduto(this);
    super.TituloTela = "Fornecedor";
    telaFornecedor.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaFornecedor);
}

public void SetarCamposFornecedor(String Id, String Codigo, String Descricao){
    if (super.getLocalizacao() == 0) {
        jtfFornecedorPesq.setText(String.valueOf(Codigo));                
    } //else //jtfRefeicaoPesq.setText(String.valueOf(Id));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtComposicao;
    public javax.swing.JButton jbtFornecedorPesq;
    private javax.swing.JCheckBox jcbAlimentar;
    private javax.swing.JCheckBox jcbAlimentarPesq;
    private javax.swing.JComboBox jcbunidadeEmbalagem;
    private javax.swing.JComboBox jcbunidadeEstoque;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbProduto;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCodigoProdPesq;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfDescricaoPesq;
    private javax.swing.JTextField jtfEstoqueMinimo;
    private javax.swing.JTextField jtfEstoquePesq;
    public javax.swing.JTextField jtfFornecedorPesq;
    private javax.swing.JTextField jtfQtdeEmbalagem;
    private javax.swing.JTextField jtfTemperaturaEntrega;
    private javax.swing.JTextField jtfValor;
    private javax.swing.JTextField jtfValorPesq;
    // End of variables declaration//GEN-END:variables


    @Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*@Override
    public void CarregarTela(TelaInterna Frame) {
        telaComposicaoCentesimal.setVisible(true);
        //telaComposicaoCentesimal.setJTextRetorno(jtfTela);
       // telaComposicaoCentesimal.setFrameInterno(Frame);
        Frame.add(telaComposicaoCentesimal);
        TelaPrincipal.add(Frame);
        Frame.setVisible(true);    

    }*/

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
            setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);        
    }

    @Override
    public ArrayList<String> setParametros() {
        ArrayList ListaParametros = new ArrayList();
        if (!(jtfCodigoProdPesq.getText().equals(""))){
            ListaParametros.add("produto");
            ListaParametros.add(jtfCodigoProdPesq.getText());
        } 
        if (!(jtfDescricaoPesq.getText().equals(""))) {
            ListaParametros.add("descricao");
            ListaParametros.add(jtfDescricaoPesq.getText());
        }
        if (!(jtfFornecedorPesq.getText().equals(""))) {
            ListaParametros.add("fornecedor");
            ListaParametros.add(jtfFornecedorPesq.getText());
        }        
        if (!(jtfValorPesq.getText().equals(""))){
            ListaParametros.add("valor");
            ListaParametros.add(jtfValorPesq.getText().replace(",", "."));
        }
        if (!(jtfEstoquePesq.getText().equals(""))) {
            ListaParametros.add("estoque");
            ListaParametros.add(jtfEstoquePesq.getText());
        }
        if (jcbAlimentarPesq.isSelected()) {
            ListaParametros.add("alimentar");
            ListaParametros.add("true");
        } else {
            ListaParametros.add("alimentar");
            ListaParametros.add("false");
        }   
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return (Integer)((Vector)ListaProduto.get(Linha)).get(0);
    }


    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList ListaRetorno = new ArrayList();
        ListaRetorno.add(""); // id
        ListaRetorno.add(jtfCodigo.getText());
        ListaRetorno.add(jtfDescricao.getText());
        ListaRetorno.add(jtfValor.getText());
        ListaRetorno.add(jtfEstoqueMinimo.getText());
        ListaRetorno.add(jtfQtdeEmbalagem.getText());
        ListaRetorno.add(jtfTemperaturaEntrega.getText());
        if (jcbAlimentar.isSelected()) {
            ListaRetorno.add(0);
        } else ListaRetorno.add(1);        
        ListaRetorno.add(idComposicao);
        ListaRetorno.add(RetornaIdUnidadeEmbalagem());
        ListaRetorno.add(RetornaIdUnidadeEstoque());   
        return ListaRetorno;
    }

    private Integer RetornaIdUnidadeEstoque(){
        return (Integer)((Object[])ListaUnidadeEstoque.get(jcbunidadeEstoque.getSelectedIndex()))[0];
    }
    
    private Integer RetornaIdUnidadeEmbalagem(){
        return (Integer)((Object[])ListaUnidadeEmbalagem.get(jcbunidadeEmbalagem.getSelectedIndex()))[0];
    }
    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        idProduto = Integer.parseInt(Objeto.get(0).toString());
        jtfCodigo.setText(Objeto.get(1).toString());
        jtfDescricao.setText(Objeto.get(2).toString());
        jtfValor.setText(String.valueOf(Objeto.get(3)));
        jtfEstoqueMinimo.setText(String.valueOf(Objeto.get(4)));
        jtfQtdeEmbalagem.setText(String.valueOf(Objeto.get(5)));
        jtfTemperaturaEntrega.setText(String.valueOf(Objeto.get(6)));
        if (Integer.parseInt(Objeto.get(7).toString()) == 0) {
            jcbAlimentar.setSelected(true);
        } else jcbAlimentar.setSelected(false);        
        idComposicao = Integer.parseInt(Objeto.get(8).toString());
        int pos = Funcoes.RetornaPosicaoVectordeObjectLista(ListaUnidadeEmbalagem, 0, Objeto.get(9));
        jcbunidadeEmbalagem.setSelectedIndex(pos);
        jcbunidadeEstoque.setSelectedIndex(Funcoes.RetornaPosicaoVectordeObjectLista(ListaUnidadeEstoque, 0, Objeto.get(10)));       
    }

    @Override
    public void CarregarTela(JInternalFrame Frame) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComportamentoTable(boolean Comportamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
