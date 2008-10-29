/*
 * TelaMovimentacao.java
 *
 * Created on 21 de Agosto de 2008, 23:31
 */

package Telas.Formulario;

import Classes.Funcoes;
import Controller.ControllerMovimento;
import Telas.Tabelas.JTableMotivo;
import Telas.Tabelas.JTableMovimento;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author  Jonathan
 */
public class TelaMovimentacao extends TelaAncestral implements InterfacePadraoAcessoOutrasTelasPesquisa {

    private int idMovimento;
    private int idProduto;
    private int idUnidade;
    private int idOperacao;
    private ControllerMovimento Controller;
    private Vector ListaMovimentacao;
    private Vector ListaUnidade;
    private Vector ListaOperacao;
    private TelaProduto telaProduto;
    
    /** Creates new form BeanForm */
    public TelaMovimentacao() {
        initComponents();
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Movimentação do estoque");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);   
        idMovimento = 0;
        idProduto = 0;
        idUnidade = 0;
        idOperacao = 0;
        Controller = new ControllerMovimento();
        ListaMovimentacao = new Vector();
        CarregarCombos();
    }    
    
    private void CarregarCombos(){
        ListaUnidade = Controller.CarregarComboUnidade();
        ListaOperacao = Controller.CarregarComboOperacao();
        Vector v = new Vector();
        for (Iterator<Object[]> it = ListaUnidade.iterator(); it.hasNext();) {
            Object[] object = it.next();
            v.add(object[1]);     
        }
        jcbUnidade.setModel(new DefaultComboBoxModel(v));
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        v3.add("");
        for (Iterator<Object[]> it = ListaOperacao.iterator(); it.hasNext();) {
            Object[] object = it.next();
            v2.add(object[1]);   
            v3.add(object[1]);   
        }     
        jcbOperacaoPesq.setModel(new DefaultComboBoxModel(v3));
        jcbOperacao.setModel(new DefaultComboBoxModel(v2));
    }
    
/*************************************************************************
*     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
**************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        boolean Validou = false;
        if ((super.Mensagens.ExibirMensagem(11))==0) {//(JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
            if (super.getLocalizacao() == 0) {            
                if (!(ListaMovimentacao.isEmpty())){
                    if (jtbMovimentacao.getSelectedRow() >= 0) {
                        Controller.EventoSelecionar(Integer.parseInt(String.valueOf(RetornaId(jtbMovimentacao.getSelectedRow()))));
                        if (Controller.EventoExcluir()) {
                            super.Mensagens.ExibirMensagem(5);
                        } else super.Mensagens.ExibirMensagem(3);
                    } else super.Mensagens.ExibirMensagem(14);                
                } else super.Mensagens.ExibirMensagem(13);//JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(6), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));
            } else 
            if (Controller.EventoExcluir()) {
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
        boolean Gravou = false;
        //if (super.VerificaCampos(jpnCadastro,1)) {
            if (super.Operacao == 0) {                                 
                if (Controller.EventoSalvar(TelaParaController())) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));             
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png")); 
            } else if (super.Operacao == 1) {
                if (Controller.EventoAlterar(TelaParaController())) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(4), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png")); 
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));                    
                }
            //} else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png")); 
        return Gravou;
        }   

    @Override
    protected void ComportamentoNovo() {
        LimparFormulario(jpnCadastro);      
    }

    @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = new ArrayList();
        ListaParametros = setParametros();
        ListaMovimentacao = (Vector) Controller.EventoPesquisar(ListaParametros);
        if (!(ListaMovimentacao.isEmpty())){
            Achou = true;
        } else super.Mensagens.ExibirMensagem(7);             
        jtbMovimentacao.setModel(new JTableMovimento(ListaMovimentacao)); 
        return Achou;
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
        jpnCadastro = new javax.swing.JPanel();
        jlb1Data = new javax.swing.JLabel();
        MaskFormatter Mask = null;
        try{
            Mask = new MaskFormatter("##/##/####");
        } catch (java.text.ParseException ex){}
        jftData = new javax.swing.JFormattedTextField(Mask);
        jlbMovimento = new javax.swing.JLabel();
        jtfQtde = new javax.swing.JTextField();
        jlb1Qtde = new javax.swing.JLabel();
        jlbMInimo = new javax.swing.JLabel();
        jlb1Produto = new javax.swing.JLabel();
        jlbOperacao = new javax.swing.JLabel();
        jcbOperacao = new javax.swing.JComboBox();
        jlb1Motivo = new javax.swing.JLabel();
        jtfMotivo = new javax.swing.JTextField();
        jtfProduto = new javax.swing.JTextField();
        jbtProduto = new javax.swing.JButton();
        jcbUnidade = new javax.swing.JComboBox();
        edDescProduto = new javax.swing.JTextField();
        edDescMinimo = new javax.swing.JTextField();
        edMovimento = new javax.swing.JTextField();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MaskFormatter Mask2 = null;
        try{
            Mask2 = new MaskFormatter("##/##/####");
        } catch (java.text.ParseException ex){}
        jftDataPesq = new javax.swing.JFormattedTextField(Mask2);
        jLabel10 = new javax.swing.JLabel();
        jtfQtdePesq = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jcbOperacaoPesq = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jtfMotivoPesq = new javax.swing.JTextField();
        jtfProdutoPesq = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMovimentacao = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jlb1Data.setText("* Data");
        jlb1Data.setName("jlb1Data"); // NOI18N

        jftData.setName("jftData"); // NOI18N

        jlbMovimento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbMovimento.setText("Nº. Movimento");
        jlbMovimento.setName("jlbMovimento"); // NOI18N

        jtfQtde.setName("jtfQtde"); // NOI18N
        jtfQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQtdeActionPerformed(evt);
            }
        });

        jlb1Qtde.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Qtde.setText("* Qtde");
        jlb1Qtde.setName("jlb1Qtde"); // NOI18N

        jlbMInimo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbMInimo.setText("Min");
        jlbMInimo.setName("jlbMInimo"); // NOI18N

        jlb1Produto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Produto.setText("* Produto");
        jlb1Produto.setName("jlb1Produto"); // NOI18N

        jlbOperacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbOperacao.setText("Operação");
        jlbOperacao.setName("jlbOperacao"); // NOI18N

        jcbOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Saída" }));
        jcbOperacao.setName("jcbOperacao"); // NOI18N

        jlb1Motivo.setText("* MOtivo");
        jlb1Motivo.setName("jlb1Motivo"); // NOI18N

        jtfMotivo.setName("jtfMotivo"); // NOI18N
        jtfMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMotivoActionPerformed(evt);
            }
        });

        jtfProduto.setName("jtfProduto"); // NOI18N

        jbtProduto.setText("jButton1");
        jbtProduto.setName("jbtProduto"); // NOI18N
        jbtProduto.setPreferredSize(new java.awt.Dimension(4, 19));
        jbtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbtProdutoMouseReleased(evt);
            }
        });

        jcbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Saída" }));
        jcbUnidade.setName("jcbUnidade"); // NOI18N

        edDescProduto.setBackground(new java.awt.Color(204, 204, 204));
        edDescProduto.setEditable(false);
        edDescProduto.setFont(new java.awt.Font("Arial", 1, 11));
        edDescProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescProduto.setName("edDescProduto"); // NOI18N

        edDescMinimo.setBackground(new java.awt.Color(204, 204, 204));
        edDescMinimo.setEditable(false);
        edDescMinimo.setFont(new java.awt.Font("Arial", 1, 11));
        edDescMinimo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescMinimo.setName("edDescMinimo"); // NOI18N

        edMovimento.setBackground(new java.awt.Color(204, 204, 204));
        edMovimento.setEditable(false);
        edMovimento.setFont(new java.awt.Font("Arial", 1, 11));
        edMovimento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edMovimento.setName("edMovimento"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbMovimento)
                    .addComponent(jlb1Produto)
                    .addComponent(jlbMInimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Qtde)
                    .addComponent(jlbOperacao)
                    .addComponent(jlb1Motivo)
                    .addComponent(jlb1Data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edDescMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                            .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfQtde)
                                .addComponent(jcbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jcbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edMovimento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jftData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addComponent(jtfMotivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(127, 127, 127))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb1Data, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb1Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMInimo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edDescMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb1Qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb1Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 200));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        jLabel9.setText(" Produto");

        jLabel4.setText(" Data");

        jftDataPesq.setName("jftDataPesq"); // NOI18N

        jLabel10.setText(" Qtde");

        jtfQtdePesq.setName("jtfQtdePesq"); // NOI18N
        jtfQtdePesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQtdePesqActionPerformed(evt);
            }
        });

        jLabel13.setText("Operação");

        jcbOperacaoPesq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Saída" }));
        jcbOperacaoPesq.setName("jcbOperacaoPesq"); // NOI18N

        jLabel18.setText(" Motivo");

        jtfMotivoPesq.setName("jtfMotivoPesq"); // NOI18N
        jtfMotivoPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMotivoPesqActionPerformed(evt);
            }
        });

        jtfProdutoPesq.setName("jtfProdutoPesq"); // NOI18N

        jButton8.setText("jButton1");
        jButton8.setPreferredSize(new java.awt.Dimension(4, 19));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfQtdePesq, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbOperacaoPesq, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jftDataPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtfMotivoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfQtdePesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftDataPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbOperacaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMotivoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jtbMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nº do Movimento", "Data", "Produto", "Qtde", "Operação", "Motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbMovimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbMovimentacaoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbMovimentacao);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jtfQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQtdeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfQtdeActionPerformed

private void jtfMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMotivoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfMotivoActionPerformed

private void jtfQtdePesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQtdePesqActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfQtdePesqActionPerformed

private void jtfMotivoPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMotivoPesqActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfMotivoPesqActionPerformed

private void jbtProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoMouseReleased
    InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoMouseReleased

private void jButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MousePressed
    InstaciaTelaProduto();
}//GEN-LAST:event_jButton8MousePressed

private void jtbMovimentacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMovimentacaoMousePressed
    if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbMovimentacao.getSelectedRow())));
            super.ComportamentoSelecionar();
        } else {
            
        }    
    }
}//GEN-LAST:event_jtbMovimentacaoMousePressed

private void InstaciaTelaProduto(){
    telaProduto = new TelaProduto(); 
    telaProduto.setTipoVisualizacao(1);
    telaProduto.setTelaMovimentacao(this);
    super.TituloTela = "Produto";
    telaProduto.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaProduto);
}

public void SetarCamposProduto(Integer Id, String Codigo, String Descricao){
    if (super.getLocalizacao() == 1) {
        jtfProduto.setText(Codigo);
        idProduto = Id;    
        edDescProduto.setText(Descricao);
    } else {
        jtfProdutoPesq.setText(Codigo);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edDescMinimo;
    private javax.swing.JTextField edDescProduto;
    private javax.swing.JTextField edMovimento;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JComboBox jcbOperacao;
    private javax.swing.JComboBox jcbOperacaoPesq;
    private javax.swing.JComboBox jcbUnidade;
    private javax.swing.JFormattedTextField jftData;
    private javax.swing.JFormattedTextField jftDataPesq;
    private javax.swing.JLabel jlb1Data;
    private javax.swing.JLabel jlb1Motivo;
    private javax.swing.JLabel jlb1Produto;
    private javax.swing.JLabel jlb1Qtde;
    private javax.swing.JLabel jlbMInimo;
    private javax.swing.JLabel jlbMovimento;
    private javax.swing.JLabel jlbOperacao;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbMovimentacao;
    private javax.swing.JTextField jtfMotivo;
    private javax.swing.JTextField jtfMotivoPesq;
    private javax.swing.JTextField jtfProduto;
    private javax.swing.JTextField jtfProdutoPesq;
    private javax.swing.JTextField jtfQtde;
    private javax.swing.JTextField jtfQtdePesq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDesktopPane(JDesktopPane Pane) {
        super.setDesktopPane(Pane);
    }

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
         setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        ArrayList<String> ListaParametros = new ArrayList<String>();
        if (!(jtfProdutoPesq.getText().equals(""))){
            ListaParametros.add("produto");
            ListaParametros.add(jtfProdutoPesq.getText());            
        }
        if (!(jftDataPesq.getText().trim().equals("/  /"))){
            ListaParametros.add("data");
            ListaParametros.add(jftDataPesq.getText());
        }
        if (jcbOperacaoPesq.getSelectedIndex() == 1){
            ListaParametros.add("operacao");
            ListaParametros.add("1");
        }
        if (jcbOperacaoPesq.getSelectedIndex() == 2){
            ListaParametros.add("operacao");
            ListaParametros.add("2");
        }
        if (!(jtfQtdePesq.getText().equals(""))){
            ListaParametros.add("Quantidade");
            ListaParametros.add(jtfQtdePesq.getText());
        }
        if (!(jtfMotivoPesq.getText().equals(""))){
            ListaParametros.add("Motivo");
            ListaParametros.add(jtfMotivoPesq.getText());
        }
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Vector)ListaMovimentacao.get(Linha)).get(0).toString());
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        setIdUnidade();
        setIdOperacao();
        ArrayList Lista = new ArrayList();
        Lista.add(idMovimento);
        Lista.add(idProduto);
        Lista.add(jtfQtde.getText());
        Lista.add(idUnidade);
        Lista.add(idOperacao);
        Lista.add(jftData.getText());
        Lista.add(jtfMotivo.getText());
        return Lista;
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | idMovimento
     *    1      | idProduto     || ArrayList (idProduto, Codigo, NomeProduto, EstoqueMinimo) 
     *    2      | Quantidade
     *    3      | idUnidadeMedida
     *    4      | idOperacao
     *    5      | dataOperacao
     *    6      | MotivoOperacao
     **************************************************************************/    

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        edMovimento.setText(Objeto.get(0).toString());
        idMovimento = Integer.parseInt(Objeto.get(0).toString());
        jftData.setText(Objeto.get(5).toString());
        jtfProduto.setText(((ArrayList)Objeto.get(1)).get(1).toString());
        idProduto = Integer.parseInt(((ArrayList)Objeto.get(1)).get(0).toString());
        edDescProduto.setText(((ArrayList)Objeto.get(1)).get(2).toString());
        edDescMinimo.setText(((ArrayList)Objeto.get(1)).get(3).toString());
        int pos = Funcoes.RetornaPosicaoVectordeObjectLista(ListaOperacao, 0, Objeto.get(4));        
        jcbOperacao.setSelectedIndex(pos);
        idOperacao = Integer.parseInt(Objeto.get(4).toString());
        pos = Funcoes.RetornaPosicaoVectordeObjectLista(ListaUnidade, 0, Objeto.get(3)); 
        jcbUnidade.setSelectedIndex(pos);
        idUnidade = Integer.parseInt(Objeto.get(3).toString());
        jtfQtde.setText(Objeto.get(2).toString());
        jtfMotivo.setText(Objeto.get(6).toString());
        
    }

    @Override
    public void setComponenteTable(boolean Acesso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void setIdUnidade(){
        idUnidade = (Integer)((Object[])ListaUnidade.get(jcbUnidade.getSelectedIndex()))[0];
    }
    
    public void setIdOperacao(){
        idOperacao = (Integer)((Object[])ListaOperacao.get(jcbOperacao.getSelectedIndex()))[0];
    }    

}
