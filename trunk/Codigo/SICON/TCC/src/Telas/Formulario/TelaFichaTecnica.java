/*
 * TelaFichaTecnica.java
 *
 * Created on 23 de Setembro de 2008, 03:01
 */

package Telas.Formulario;

import Controller.ControllerFichaTecnica;
import Telas.Tabelas.JTableFichaTecnica;
import Telas.Tabelas.JTableFichaTecnicaItens;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaFichaTecnica extends TelaAncestral implements InterfacePadraoTelaVarias{

    private TelaProduto telaProduto;
    private Integer idProduto;
    private Integer idFichaTecnica;
    private Integer Posicao;
    private Vector ListaFichaTecnica;
    private ArrayList ListaProduto;
    private ArrayList ListaProdutoNovo;
    private ArrayList ListaProdutoAlterar;
    private ArrayList ListaProdutoExcluir;
    private ControllerFichaTecnica Controller;
    private TelaCardapio telaCardapio;
    /** Creates new form BeanForm */
    
    public TelaFichaTecnica() {
        initComponents();       
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro , this.jpnTela);
        super.setTitulo("Ficha Técnica");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);
        Controller = new ControllerFichaTecnica();
        idProduto = 0;
        idFichaTecnica = 0;
        ListaProduto = new ArrayList();
        ListaProdutoNovo = new ArrayList();
        ListaProdutoAlterar = new ArrayList();
        ListaProdutoExcluir = new ArrayList();
        ListaFichaTecnica = new Vector(); 
        Posicao = null;
    }    
    
    public void setTelaCardapio(TelaCardapio tela) {
        this.telaCardapio = tela;
    }
    
    /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
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
                if (Controller.EventoSalvaFichaEItens(TelaParaController(), ListaProdutoNovo, ListaProdutoAlterar, ListaProdutoExcluir)) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));             
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png")); 
            } else if (super.Operacao == 1) {
                if (Controller.EventoAlterarFichaEItens(TelaParaController(), ListaProdutoNovo, ListaProdutoAlterar, ListaProdutoExcluir)) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(4), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png")); 
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));                    
                }
           // } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png")); 
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
        ListaFichaTecnica = (Vector)Controller.EventoPesquisar(ListaParametros);
        if (!(ListaFichaTecnica.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbFichaTecnica.setModel(new JTableFichaTecnica(ListaFichaTecnica)); 
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfNomePreparacao = new javax.swing.JTextField();
        jtfPesoBruto = new javax.swing.JTextField();
        jtfPesoLiquido = new javax.swing.JTextField();
        jtfRendimento = new javax.swing.JTextField();
        jtfFatorCorrecao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaModoPreparo = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtfProduto = new javax.swing.JTextField();
        jbtProduto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbFichaTecnicaItens = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jbtExcluir = new javax.swing.JButton();
        jbtAdicionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jlbPesoLiquido = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jlbEnergia = new javax.swing.JLabel();
        jlbLipideo = new javax.swing.JLabel();
        jlbCalcio = new javax.swing.JLabel();
        jlbProteina = new javax.swing.JLabel();
        jlbCarboidrato = new javax.swing.JLabel();
        jlbFerro = new javax.swing.JLabel();
        jlbVitaminaC = new javax.swing.JLabel();
        jlbPesoCru = new javax.swing.JLabel();
        jlbPreco = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jbtNovo = new javax.swing.JButton();
        edDescProduto = new javax.swing.JTextField();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfNomePreparacaoPesq = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfModoPreparoPesq = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfRendimentoPesq = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jtfProdutoPesq = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbFichaTecnica = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("* Nome da Preparação");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Modo de Preparo");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("* Rendimento");

        jLabel8.setText("* Fator Correção");

        jtfNomePreparacao.setName("jtfNomePreparacao"); // NOI18N

        jtfRendimento.setName("jtfRendimento"); // NOI18N

        jtaModoPreparo.setColumns(20);
        jtaModoPreparo.setRows(5);
        jtaModoPreparo.setName("jtaModoPreparo"); // NOI18N
        jScrollPane2.setViewportView(jtaModoPreparo);

        jLabel11.setText("Ingredientes");

        jPanel4.setBackground(new java.awt.Color(200, 199, 190));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jtfProduto.setColumns(10);
        jtfProduto.setName("jtfProduto"); // NOI18N

        jbtProduto.setText("jButton1");
        jbtProduto.setName("jbtProduto"); // NOI18N
        jbtProduto.setPreferredSize(new java.awt.Dimension(73, 21));
        jbtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtProdutoMousePressed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("* Produto");

        jtbFichaTecnicaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Peso bruto", "Peso liquido", "Fator correção"
            }
        ));
        jtbFichaTecnicaItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFichaTecnicaItensMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jtbFichaTecnicaItens);

        jLabel13.setText("* Peso Liquido");

        jbtExcluir.setText("Excluir  ");
        jbtExcluir.setName("jbtExcluir"); // NOI18N
        jbtExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtExcluirMousePressed(evt);
            }
        });
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jbtAdicionar.setText("Adicionar");
        jbtAdicionar.setName("jbtAdicionar"); // NOI18N
        jbtAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Peso Cru");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jlbPesoLiquido.setText("0,00");
        jlbPesoLiquido.setName("jlbPesoLiquido"); // NOI18N
        jPanel1.add(jlbPesoLiquido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 20));

        jLabel17.setText("Per Capita");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jLabel18.setText("Energia");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel19.setText("Carboidrato");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jLabel20.setText("Proteína");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel21.setText("Lipideo");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        jLabel22.setText("Calcio");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLabel23.setText("Ferro");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 20));

        jLabel24.setText("Vit C");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 20));

        jLabel25.setText("Preço");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));

        jlbEnergia.setText("0,00");
        jlbEnergia.setName("jlbEnergia"); // NOI18N
        jPanel1.add(jlbEnergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 20));

        jlbLipideo.setText("0,00");
        jlbLipideo.setName("jlbLipideo"); // NOI18N
        jPanel1.add(jlbLipideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, 20));

        jlbCalcio.setText("0,00");
        jlbCalcio.setName("jlbCalcio"); // NOI18N
        jPanel1.add(jlbCalcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 20));

        jlbProteina.setText("0,00");
        jlbProteina.setName("jlbProteina"); // NOI18N
        jPanel1.add(jlbProteina, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 20));

        jlbCarboidrato.setText("0,00");
        jlbCarboidrato.setName("jlbCarboidrato"); // NOI18N
        jPanel1.add(jlbCarboidrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 20));

        jlbFerro.setText("0,00");
        jlbFerro.setName("jlbFerro"); // NOI18N
        jPanel1.add(jlbFerro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, 20));

        jlbVitaminaC.setText("0,00");
        jlbVitaminaC.setName("jlbVitaminaC"); // NOI18N
        jPanel1.add(jlbVitaminaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 20));

        jlbPesoCru.setText("0,00");
        jlbPesoCru.setName("jlbPesoCru"); // NOI18N
        jPanel1.add(jlbPesoCru, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 90, 20));

        jlbPreco.setText("0,00");
        jlbPreco.setName("jlbPreco"); // NOI18N
        jPanel1.add(jlbPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 20));

        jLabel26.setText("Ficha Técnica");

        jPanel5.setBackground(new java.awt.Color(200, 199, 190));
        jPanel5.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel14.setText("* Peso Bruto");

        jbtNovo.setText("Novo");
        jbtNovo.setName("jbtNovo"); // NOI18N
        jbtNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtNovoMousePressed(evt);
            }
        });
        jbtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoActionPerformed(evt);
            }
        });

        edDescProduto.setBackground(new java.awt.Color(204, 204, 204));
        edDescProduto.setEditable(false);
        edDescProduto.setFont(new java.awt.Font("Arial", 1, 11));
        edDescProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescProduto.setName("edDescProduto"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCadastroLayout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfRendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                            .addComponent(jtfNomePreparacao)))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel14))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(0, 0, 0)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jtfPesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfPesoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfFatorCorrecao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jbtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jbtAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edDescProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)))))
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnCadastroLayout.createSequentialGroup()
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel11))
                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel26))
                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))))
                    .addContainerGap(208, Short.MAX_VALUE)))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jtfNomePreparacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfRendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPesoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFatorCorrecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jbtAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtExcluir))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnCadastroLayout.createSequentialGroup()
                    .addGap(0, 18, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(158, 158, 158)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(325, 325, 325)))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 150));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 110));

        jLabel3.setText("Nome da Preparação");

        jtfNomePreparacaoPesq.setName("jtfNomePreparacaoPesq"); // NOI18N

        jLabel10.setText("Modo de Preparo");

        jtfModoPreparoPesq.setName("jtfModoPreparoPesq"); // NOI18N

        jLabel9.setText("Rendimento");

        jtfRendimentoPesq.setName("jtfRendimentoPesq"); // NOI18N

        jLabel27.setText("Produto");

        jtfProdutoPesq.setColumns(6);
        jtfProdutoPesq.setName("jtfProdutoPesq"); // NOI18N

        jButton3.setText("jButton1");
        jButton3.setPreferredSize(new java.awt.Dimension(73, 19));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfModoPreparoPesq)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfRendimentoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNomePreparacaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfNomePreparacaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfModoPreparoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRendimentoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel2, java.awt.BorderLayout.NORTH);

        jtbFichaTecnica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome da Preparação", "Rendimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbFichaTecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFichaTecnicaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbFichaTecnica);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jbtProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoMousePressed
InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoMousePressed

private void InstaciaTelaProduto(){
    telaProduto = new TelaProduto(); 
    telaProduto.setTipoVisualizacao(1); 
    telaProduto.setTelaFichaTecnica(this);
    super.TituloTela = "Produto";
    telaProduto.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaProduto);
}

public void SetarCamposProduto(Integer Id, String Codigo, String Descricao){
    jtfProduto.setText(Codigo);
    idProduto = Id;
    edDescProduto.setText(Descricao);
}

private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtExcluirActionPerformed

private void jbtAdicionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarMousePressed
    ArrayList Lista = new ArrayList();
    Lista.add(idFichaTecnica); // 0
    Lista.add(idProduto); //1
    Lista.add(edDescProduto.getText());//2
    Lista.add(jtfPesoBruto.getText());//3
    Lista.add(jtfPesoLiquido.getText());//4
    Lista.add(jtfFatorCorrecao.getText()); //5  
    Lista.add(jtfProduto.getText());   //6
    if (Posicao == null) {
        Lista.add(0); // indica se já existe ou se é um novo
        ListaProdutoNovo.add(Lista);
        ListaProduto.add(Lista);
    } else {
        Lista.add(1);
        ListaProdutoAlterar.add(Lista);
        ListaProduto.set(Posicao, Lista);        
    }
    SetaComposicao(Controller.EventoAdicionar(idProduto, new BigDecimal(jtfPesoBruto.getText()), new BigDecimal(jtfPesoLiquido.getText())));
    AtualizaTableItens();
}//GEN-LAST:event_jbtAdicionarMousePressed

private void jbtNovoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNovoMousePressed
    LimparIngredientes();
    jbtAdicionar.setText("Adicionar");    
}//GEN-LAST:event_jbtNovoMousePressed

private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtNovoActionPerformed

private void jtbFichaTecnicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFichaTecnicaMousePressed
if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
            if (super.getTipoVisualizacao() == 0) {
                LimparFormulario(jpnCadastro);
                idFichaTecnica = RetornaId(jtbFichaTecnica.getSelectedRow());                
                ControllerParaTela(Controller.EventoSelecionar(idFichaTecnica));
                super.ComportamentoSelecionar();
            } else {
                telaCardapio.SetarCamposFicha(RetornaId(jtbFichaTecnica.getSelectedRow()), ((Object[])ListaFichaTecnica.get(jtbFichaTecnica.getSelectedRow()))[1].toString());
                super.FechaFrameInterno();
            }
        }
}//GEN-LAST:event_jtbFichaTecnicaMousePressed

private void jtbFichaTecnicaItensMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFichaTecnicaItensMousePressed
if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
            if (super.getTipoVisualizacao() == 0) {
                LimparIngredientes();
                Posicao = jtbFichaTecnicaItens.getSelectedRow();                
                CarregarInredientes();
                super.ComportamentoSelecionar();
                jbtAdicionar.setText("Salvar");
            }
        }
}//GEN-LAST:event_jtbFichaTecnicaItensMousePressed

private void jbtExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirMousePressed
    int Pos = jtbFichaTecnicaItens.getSelectedRow();
    if (((ArrayList)ListaProduto.get(Pos)).get(7).toString().equals("1")) {
        ListaProdutoExcluir.add((ArrayList)ListaProduto.get(Pos));        
    } 
    SetaComposicao(Controller.EventoExcluirItem(Integer.parseInt(((ArrayList)ListaProduto.get(Pos)).get(1).toString()), 
                                 new BigDecimal(((ArrayList)ListaProduto.get(Pos)).get(3).toString()),
                                 new BigDecimal(((ArrayList)ListaProduto.get(Pos)).get(4).toString())));
    ListaProduto.remove(Pos);
    AtualizaTableItens();
}//GEN-LAST:event_jbtExcluirMousePressed

public void CarregarInredientes(){
    jtfProduto.setText(((ArrayList)ListaProduto.get(Posicao)).get(6).toString());
    edDescProduto.setText(((ArrayList)ListaProduto.get(Posicao)).get(2).toString());
    jtfPesoBruto.setText(((ArrayList)ListaProduto.get(Posicao)).get(3).toString());
    jtfPesoLiquido.setText(((ArrayList)ListaProduto.get(Posicao)).get(4).toString());
    jtfFatorCorrecao.setText(((ArrayList)ListaProduto.get(Posicao)).get(5).toString());
    idProduto = Integer.parseInt(((ArrayList)ListaProduto.get(Posicao)).get(1).toString());
}
    @Override
    public void setDesktopPane(JDesktopPane Pane) {
        super.setDesktopPane(Pane);
    }

    @Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CarregarTela(JInternalFrame Frame) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        if (!(jtfNomePreparacaoPesq.getText().trim().equals(""))){
            ListaParametros.add("nomepreparacao");
            ListaParametros.add(jtfNomePreparacaoPesq.getText());
        }
        if (!(jtfRendimentoPesq.getText().trim().equals(""))){
            ListaParametros.add("rendimento");
            ListaParametros.add(jtfRendimentoPesq.getText());
        }
        if (!(jtfModoPreparoPesq.getText().trim().equals(""))){
            ListaParametros.add("modopreparo");
            ListaParametros.add(jtfModoPreparoPesq.getText());
        }
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return (Integer.parseInt(((Object[])ListaFichaTecnica.get(Linha))[0].toString()));
    }

    @Override
    public void setComportamentoTable(boolean Comportamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(jtfNomePreparacao.getText());
        Lista.add(jtaModoPreparo.getText());
        Lista.add(jtfRendimento.getText());
        return Lista;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        idFichaTecnica = Integer.parseInt(Objeto.get(0).toString());
        jtfNomePreparacao.setText(Objeto.get(14).toString());
        jtaModoPreparo.setText(Objeto.get(1).toString());
        jtfRendimento.setText(Objeto.get(2).toString());
        SetaComposicao(Objeto.subList(3, 13));
        //jlbPreco.setText(Objeto.get(12).toString());
        ListaProduto = (ArrayList)Objeto.get(13);
        AtualizaTableItens();
    }
    
    private void SetaComposicao(List<Object> Objeto) {
        jlbEnergia.setText(Objeto.get(0).toString());
        jlbCarboidrato.setText(Objeto.get(1).toString());
        jlbProteina.setText(Objeto.get(2).toString());
        jlbLipideo.setText(Objeto.get(3).toString());
        jlbCalcio.setText(Objeto.get(4).toString());
        jlbFerro.setText(Objeto.get(5).toString());
        jlbVitaminaC.setText(Objeto.get(6).toString());
        jlbPesoCru.setText(Objeto.get(7).toString());
        jlbPesoLiquido.setText(Objeto.get(8).toString());
        jlbPreco.setText(Objeto.get(9).toString());
    }    
  
private void AtualizaTableItens(){
    jtbFichaTecnicaItens.setModel(new JTableFichaTecnicaItens(ListaProduto));
}

private void LimparIngredientes(){
    jtfProduto.setText("");
    edDescProduto.setText("");
    jtfPesoBruto.setText("");
    jtfPesoLiquido.setText("");
    jtfFatorCorrecao.setText("");
    Posicao = null;
    idProduto = 0;
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edDescProduto;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtAdicionar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtNovo;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JLabel jlbCalcio;
    private javax.swing.JLabel jlbCarboidrato;
    private javax.swing.JLabel jlbEnergia;
    private javax.swing.JLabel jlbFerro;
    private javax.swing.JLabel jlbLipideo;
    private javax.swing.JLabel jlbPesoCru;
    private javax.swing.JLabel jlbPesoLiquido;
    private javax.swing.JLabel jlbPreco;
    private javax.swing.JLabel jlbProteina;
    private javax.swing.JLabel jlbVitaminaC;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTextArea jtaModoPreparo;
    private javax.swing.JTable jtbFichaTecnica;
    private javax.swing.JTable jtbFichaTecnicaItens;
    private javax.swing.JTextField jtfFatorCorrecao;
    private javax.swing.JTextField jtfModoPreparoPesq;
    private javax.swing.JTextField jtfNomePreparacao;
    private javax.swing.JTextField jtfNomePreparacaoPesq;
    private javax.swing.JTextField jtfPesoBruto;
    private javax.swing.JTextField jtfPesoLiquido;
    private javax.swing.JTextField jtfProduto;
    private javax.swing.JTextField jtfProdutoPesq;
    private javax.swing.JTextField jtfRendimento;
    private javax.swing.JTextField jtfRendimentoPesq;
    // End of variables declaration//GEN-END:variables

}
