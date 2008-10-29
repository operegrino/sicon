/*
 * TelaFornecedorProduto.java
 *
 * Created on 19 de Agosto de 2008, 23:30
 */

package Telas.Formulario;

import Controller.ControllerFornecedorProduto;
import Telas.Tabelas.JTableFornecedorProduto;
import Telas.Tabelas.JTableFornecedorProdutoCad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaFornecedorProduto extends TelaAncestral implements InterfacePadraoTelaVarias{

    private Integer idFornecedor;
    private Integer idProduto;
    //{idproduto, NOmeProduto, idFornecedor, NomeFornecedor, idTipoTelefone , NOmeTIpoFornecedor, 
    //Codigofornecedor, TempEntrega, idfornecedorproduto  }    
    private Vector ListaProduto;
    private Vector ListaFornecedorProduto;
    private ControllerFornecedorProduto Controller;
    private TelaFornecedor telaFornecedor;
    private TelaProduto telaProduto;
    private Integer PosicaoProd;
    private ArrayList ListaExcluirFornProd;
    private int idFornecedorProduto;

    
    /** Creates new form BeanForm */
    public TelaFornecedorProduto() {
        initComponents();
        IniciarTela();        
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela( this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Fornecedor do Produto");        
        Controller = new ControllerFornecedorProduto();
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);     
        ListaProduto = new Vector();
        ListaFornecedorProduto = new Vector();
        idFornecedor = 0;
        idProduto = 0;
        idFornecedorProduto = 0;
        PosicaoProd = null;
        ListaExcluirFornProd = new ArrayList();
    }    
    
    public void setCamposFornecedor(String Codigo, String Descricao, int Id) {
        jtfFornecedor.setText(Codigo);
        edDescFornecedor.setText(Descricao);
        this.idFornecedor = Id;
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
        if (super.VerificaCampos(jpnCadastro,1)) {
            if (super.Operacao == 0) {                                 
                if (Controller.EventoSalvarTodos(TelaParaController(), ListaExcluirFornProd)) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));             
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png")); 
            } else if (super.Operacao == 1) {
                if (Controller.EventoAlterarTodos(TelaParaController(), ListaExcluirFornProd)) {
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
        LimparFormulario(jpnCadastro); 
        ListaProduto.clear();
        AtualizarJTable(ListaProduto);
    }

    @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = new ArrayList();
        ListaParametros = setParametros();
        ListaFornecedorProduto = (Vector)Controller.EventoPesquisar(ListaParametros);
        if (!(ListaFornecedorProduto.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbFornecedorProduto.setModel(new JTableFornecedorProduto(ListaFornecedorProduto)); 
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnTela = new javax.swing.JPanel();
        jpnCadastro = new javax.swing.JPanel();
        jlb1Fornecedor = new javax.swing.JLabel();
        jtfProduto = new javax.swing.JTextField();
        jbtProduto = new javax.swing.JButton();
        jlbProduto = new javax.swing.JLabel();
        jtfFornecedor = new javax.swing.JTextField();
        jbtFornecedor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jblTipo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbFornecedorProdutoCad = new javax.swing.JTable();
        jtbAdicionar = new javax.swing.JButton();
        jtbExcluir = new javax.swing.JButton();
        jrbEmergencia = new javax.swing.JRadioButton();
        jrbTradicional = new javax.swing.JRadioButton();
        jlbCodigoFornecedor = new javax.swing.JLabel();
        jtfCodigoFornecedor = new javax.swing.JTextField();
        jtfTempoEntrega = new javax.swing.JTextField();
        jlbTempoEntrega = new javax.swing.JLabel();
        edDescFornecedor = new javax.swing.JTextField();
        edDescProduto = new javax.swing.JTextField();
        jbtNovo = new javax.swing.JButton();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtfFornecedorPesq = new javax.swing.JTextField();
        jbtFornecedorPesq = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtfProdutoPesq = new javax.swing.JTextField();
        jbtProdutoPesq = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfCodProdutoFornPesq = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jrbTradicionalPesq = new javax.swing.JRadioButton();
        jrbEmergencialPesq = new javax.swing.JRadioButton();
        jrbTodos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbFornecedorProduto = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jlb1Fornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Fornecedor.setText("* Fornecedor");
        jlb1Fornecedor.setName("jlb1Fornecedor"); // NOI18N

        jtfProduto.setName("jtfProduto"); // NOI18N

        jbtProduto.setText("jButton1");
        jbtProduto.setName("jbtProduto"); // NOI18N
        jbtProduto.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtProdutoMousePressed(evt);
            }
        });

        jlbProduto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbProduto.setText("* Produto");
        jlbProduto.setName("jlb2Produto"); // NOI18N

        jtfFornecedor.setName("jtfFornecedor"); // NOI18N

        jbtFornecedor.setText("jButton1");
        jbtFornecedor.setName("jbtFornecedor"); // NOI18N
        jbtFornecedor.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFornecedorMousePressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(200, 199, 190));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 797, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel6.setText("Produtos");

        jblTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jblTipo.setText("Tipo");
        jblTipo.setName("jblTipo"); // NOI18N

        jtbFornecedorProdutoCad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fornecedor", "Produto", "Tipo"
            }
        ));
        jtbFornecedorProdutoCad.setName("jtbFornecedorProdutoCad"); // NOI18N
        jtbFornecedorProdutoCad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFornecedorProdutoCadMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbFornecedorProdutoCad);

        jtbAdicionar.setText("Adicionar");
        jtbAdicionar.setName("jbtAdicionar"); // NOI18N
        jtbAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbAdicionarMousePressed(evt);
            }
        });

        jtbExcluir.setText("Excluir  ");
        jtbExcluir.setName("jtbExcluir"); // NOI18N
        jtbExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbExcluirMousePressed(evt);
            }
        });
        jtbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbExcluirActionPerformed(evt);
            }
        });

        jrbEmergencia.setBackground(new java.awt.Color(243, 243, 243));
        jrbEmergencia.setText("Emergência");
        jrbEmergencia.setName("jrbEmergencia"); // NOI18N

        jrbTradicional.setBackground(new java.awt.Color(243, 243, 243));
        jrbTradicional.setText("Tradicional");
        jrbTradicional.setName("jrbTradicional"); // NOI18N

        jlbCodigoFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbCodigoFornecedor.setText("* Cod Fornecedor");
        jlbCodigoFornecedor.setName("jlb2CodigoFornecedor"); // NOI18N

        jtfCodigoFornecedor.setName("jtfCodigoFornecedor"); // NOI18N

        jtfTempoEntrega.setName("jtfTempoEntrega"); // NOI18N

        jlbTempoEntrega.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTempoEntrega.setText("Tempo de Entrega");
        jlbTempoEntrega.setName("jlb2TempoEntrega"); // NOI18N

        edDescFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        edDescFornecedor.setEditable(false);
        edDescFornecedor.setFont(new java.awt.Font("Arial", 1, 11));
        edDescFornecedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescFornecedor.setName("edDescFornecedor"); // NOI18N

        edDescProduto.setBackground(new java.awt.Color(204, 204, 204));
        edDescProduto.setEditable(false);
        edDescProduto.setFont(new java.awt.Font("Arial", 1, 11));
        edDescProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescProduto.setName("edDescProduto"); // NOI18N

        jbtNovo.setText("Novo");
        jbtNovo.setName("jtbExcluir"); // NOI18N
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

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb1Fornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbCodigoFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                                            .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jtfCodigoFornecedor))
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jrbTradicional)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jlbTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jrbEmergencia)))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCadastroLayout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtbExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addComponent(jbtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCadastroLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6)
                            .addGap(151, 151, 151)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpnCadastroLayout.createSequentialGroup()
                                    .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
                                .addComponent(edDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtbAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(721, 721, 721))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb1Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                        .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edDescProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbTradicional)
                            .addComponent(jrbEmergencia)))
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jtbAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbExcluir)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 150));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 90));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fornecedor");

        jtfFornecedorPesq.setName("jtfFornecedorPesq"); // NOI18N

        jbtFornecedorPesq.setText("jButton1");
        jbtFornecedorPesq.setName("jbtFornecedorPesq"); // NOI18N
        jbtFornecedorPesq.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtFornecedorPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFornecedorPesqMousePressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("* Produto");

        jtfProdutoPesq.setName("jtfProdutoPesq"); // NOI18N

        jbtProdutoPesq.setText("jButton1");
        jbtProdutoPesq.setName("jbtProdutoPesq"); // NOI18N
        jbtProdutoPesq.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtProdutoPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtProdutoPesqMousePressed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cod Produto For.");

        jtfCodProdutoFornPesq.setName("jtfCodProdutoFornPesq"); // NOI18N

        jLabel13.setText("Tipo");

        jrbTradicionalPesq.setBackground(new java.awt.Color(243, 243, 243));
        buttonGroup1.add(jrbTradicionalPesq);
        jrbTradicionalPesq.setText("Tradicional");
        jrbTradicionalPesq.setName("jrbTradicionalPesq"); // NOI18N

        jrbEmergencialPesq.setBackground(new java.awt.Color(243, 243, 243));
        buttonGroup1.add(jrbEmergencialPesq);
        jrbEmergencialPesq.setText("Emergência");
        jrbEmergencialPesq.setName("jrbEmergencialPesq"); // NOI18N

        jrbTodos.setBackground(new java.awt.Color(243, 243, 243));
        buttonGroup1.add(jrbTodos);
        jrbTodos.setText("Todos");
        jrbTodos.setName("jrbTodos"); // NOI18N
        jrbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jtfCodProdutoFornPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jrbTradicionalPesq)
                        .addGap(3, 3, 3)
                        .addComponent(jrbEmergencialPesq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbTodos)))
                .addContainerGap(1146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodProdutoFornPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jbtFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbTradicionalPesq)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbEmergencialPesq)
                        .addComponent(jrbTodos)))
                .addGap(48, 48, 48))
        );

        jpnPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jtbFornecedorProduto.setBackground(new java.awt.Color(243, 243, 243));
        jtbFornecedorProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fornecedor", "Produto", "Tipo", "Cod. Prod. do Fornecedor", "Tempo de Entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbFornecedorProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFornecedorProdutoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbFornecedorProduto);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jtbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbExcluirActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtbExcluirActionPerformed

private void jrbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodosActionPerformed
    
}//GEN-LAST:event_jrbTodosActionPerformed

private void jbtFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFornecedorMousePressed
    InstaciaTelaFornecedor();
}//GEN-LAST:event_jbtFornecedorMousePressed

private void InstaciaTelaFornecedor(){
    telaFornecedor = new TelaFornecedor(); 
    telaFornecedor.setTipoVisualizacao(1);
    telaFornecedor.setTelaFornecedorProduto(this);
    super.TituloTela = "Fornecedor";
    telaFornecedor.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaFornecedor);
}

public void setarTelaFornecedor(TelaFornecedor Fornecedor) {
    this.telaFornecedor = Fornecedor;
}

public void SetarCamposFornecedor(String Id, String Codigo, String Descricao){
    if (super.getLocalizacao() == 1) {
        jtfFornecedor.setText(Codigo);
        idFornecedor = Integer.parseInt(Id);
        edDescFornecedor.setText(Descricao);
    } else {
        jtfFornecedorPesq.setText(Codigo);
    }
}

private void jbtProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoMousePressed
    InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoMousePressed

private void jtbAdicionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbAdicionarMousePressed
    if ((super.VerificaCampos(jpnCadastro, 1)) & (super.VerificaCampos(jpnCadastro, 2))) {
        Vector Lista = new Vector();
        Lista.add(idProduto);
        Lista.add(edDescProduto.getText());
        Lista.add(idFornecedor);
        Lista.add(edDescFornecedor.getText()); 
        if (jrbTradicional.isSelected()) {
            Lista.add(1);
            Lista.add("Tradicional");
        } else  {
            Lista.add(2);
            Lista.add("Emergência");
        }
        Lista.add(jtfCodigoFornecedor.getText());
        Lista.add(jtfTempoEntrega.getText());
        Lista.add(idFornecedorProduto);
        if (PosicaoProd == null) {
            ListaProduto.add(Lista);  
        } else ListaProduto.set(PosicaoProd, Lista);  
        AtualizarJTable(ListaProduto);         
    }    
}//GEN-LAST:event_jtbAdicionarMousePressed

private void jtbFornecedorProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFornecedorProdutoMousePressed
    if ((evt.getClickCount() == 2) && (evt.getButton() == 1)) {
        ListaExcluirFornProd.clear();
        ListaProduto.clear();
        Selecionar(RetornaId(jtbFornecedorProduto.getSelectedRow()));        
    }
}//GEN-LAST:event_jtbFornecedorProdutoMousePressed

public void Selecionar(int idFor) {        
        ControllerParaTela(Controller.EventoSelecionarTodos(idFor));
        idFornecedor = idFor;
        AtualizarJTable(ListaProduto);
        super.ComportamentoSelecionar();
}
private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtNovoActionPerformed

private void jbtNovoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNovoMousePressed
    LimparProduto();
    idProduto = 0;
    idFornecedorProduto = 0;
}//GEN-LAST:event_jbtNovoMousePressed

private void jtbFornecedorProdutoCadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFornecedorProdutoCadMousePressed
    if ((evt.getClickCount() == 2) && (evt.getButton() == 1)) {
        PosicaoProd = jtbFornecedorProdutoCad.getSelectedRow();        
        jtbAdicionar.setText("Salvar");
        CarregarCamposProduto(PosicaoProd);
    }    
}//GEN-LAST:event_jtbFornecedorProdutoCadMousePressed

private void jtbExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbExcluirMousePressed
    if (Integer.parseInt(((Vector)ListaProduto.get(jtbFornecedorProdutoCad.getSelectedRow())).get(8).toString()) != 0){
        ListaExcluirFornProd.add(Integer.parseInt(((Vector)ListaProduto.get(jtbFornecedorProdutoCad.getSelectedRow())).get(8).toString()));
    }
    ListaProduto.remove(jtbFornecedorProdutoCad.getSelectedRow());
    AtualizarJTable(ListaProduto);
}//GEN-LAST:event_jtbExcluirMousePressed

private void jbtFornecedorPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFornecedorPesqMousePressed
    InstaciaTelaFornecedor();
}//GEN-LAST:event_jbtFornecedorPesqMousePressed

private void jbtProdutoPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoPesqMousePressed
    InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoPesqMousePressed

public void CarregarCamposProduto(int Pos) {
    idProduto = Integer.parseInt(((Vector)ListaProduto.get(Pos)).get(0).toString());
    idFornecedorProduto = Integer.parseInt(((Vector)ListaProduto.get(Pos)).get(8).toString());
    jtfProduto.setText(((Vector)ListaProduto.get(Pos)).get(9).toString());
    edDescProduto.setText(((Vector)ListaProduto.get(Pos)).get(3).toString());
    jtfCodigoFornecedor.setText(((Vector)ListaProduto.get(Pos)).get(6).toString());
    jtfTempoEntrega.setText(((Vector)ListaProduto.get(Pos)).get(7).toString());
    if ((Integer.parseInt(((Vector)ListaProduto.get(Pos)).get(4).toString())) == 1){
        jrbTradicional.setSelected(true);
    } else {
        jrbEmergencia.setSelected(true);
    }
}
public void LimparProduto(){
    jtfProduto.setText("");
    edDescProduto.setText("");
    jtfCodigoFornecedor.setText("");
    jtfTempoEntrega.setText("");
    jrbTradicional.setSelected(true);
    PosicaoProd = null;
}
private void AtualizarJTable(Vector vetor){
    jtbFornecedorProdutoCad.setModel(new JTableFornecedorProdutoCad((vetor)));
}

private void InstaciaTelaProduto(){
    telaProduto = new TelaProduto(); 
    telaProduto.setTipoVisualizacao(1); 
    telaProduto.setTelaFornecedorProduto(this);
    super.TituloTela = "Produto";
    telaProduto.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaProduto);
}

public void setarTelaProduto(TelaProduto telaProduto) {
    this.telaProduto = telaProduto;
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField edDescFornecedor;
    private javax.swing.JTextField edDescProduto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jblTipo;
    private javax.swing.JButton jbtFornecedor;
    private javax.swing.JButton jbtFornecedorPesq;
    private javax.swing.JButton jbtNovo;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JButton jbtProdutoPesq;
    private javax.swing.JLabel jlb1Fornecedor;
    private javax.swing.JLabel jlbCodigoFornecedor;
    private javax.swing.JLabel jlbProduto;
    private javax.swing.JLabel jlbTempoEntrega;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JRadioButton jrbEmergencia;
    private javax.swing.JRadioButton jrbEmergencialPesq;
    private javax.swing.JRadioButton jrbTodos;
    private javax.swing.JRadioButton jrbTradicional;
    private javax.swing.JRadioButton jrbTradicionalPesq;
    private javax.swing.JButton jtbAdicionar;
    private javax.swing.JButton jtbExcluir;
    private javax.swing.JTable jtbFornecedorProduto;
    private javax.swing.JTable jtbFornecedorProdutoCad;
    private javax.swing.JTextField jtfCodProdutoFornPesq;
    private javax.swing.JTextField jtfCodigoFornecedor;
    private javax.swing.JTextField jtfFornecedor;
    private javax.swing.JTextField jtfFornecedorPesq;
    private javax.swing.JTextField jtfProduto;
    private javax.swing.JTextField jtfProdutoPesq;
    private javax.swing.JTextField jtfTempoEntrega;
    // End of variables declaration//GEN-END:variables

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
        ArrayList ListaParametros = new ArrayList();
        if (!(jtfFornecedorPesq.getText().trim().equals(""))) {
            ListaParametros.add("fornecedor");
            ListaParametros.add(jtfFornecedorPesq.getText());
        } 
        if (!(jtfProdutoPesq.getText().trim().equals(""))) {
            ListaParametros.add("produto");
            ListaParametros.add(jtfProdutoPesq.getText());
        }
        if (!(jtfCodProdutoFornPesq.getText().trim().equals(""))) {
            ListaParametros.add("codigoprodforn");
            ListaParametros.add(jtfCodProdutoFornPesq.getText());
        } 
        if (jrbTradicionalPesq.isSelected()) {
            ListaParametros.add("tipo");
            ListaParametros.add("1");           
        } else if (jrbEmergencialPesq.isSelected()) {
            ListaParametros.add("tipo");
            ListaParametros.add("2");           
        }
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return (Integer)((Vector)ListaFornecedorProduto.get(Linha)).get(0);
    }

    @Override
    public void setComportamentoTable(boolean Comportamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ArrayList RetornaArrayListaProd() {
        int cont = 0;
        ArrayList ListaSup = new ArrayList();        
        while (ListaProduto.size() > cont) {
            ArrayList Lista = new ArrayList();
            //{idproduto, NOmeProduto, idFornecedor, NomeFornecedor, idTipoTelefone , NOmeTIpoFornecedor, Codigofornecedor, TempEntrega  }            
            Lista.add(((Vector)ListaProduto.get(cont)).get(2)); // 0 idfornecedor
            Lista.add(((Vector)ListaProduto.get(cont)).get(0)); // 1 idproduto
            Lista.add(((Vector)ListaProduto.get(cont)).get(4)); // 2 idTipoFornecedor
            Lista.add(((Vector)ListaProduto.get(cont)).get(6)); // 3 codigo fornecedor produto
            Lista.add(((Vector)ListaProduto.get(cont)).get(7)); // 4 tempo entrega  
            Lista.add(((Vector)ListaProduto.get(cont)).get(8)); // 5 idfornecedorproduto             
            ListaSup.add(Lista);        
            cont++;
        }
        return ListaSup;
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(0);
        ArrayList ListaForn = new ArrayList();
        ListaForn.add(idFornecedor);
        Lista.add(ListaForn);
        ArrayList ListaProd = new ArrayList();
        ListaProd = RetornaArrayListaProd(); 
        Lista.add(ListaProd);  
        return Lista;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        if (!(Objeto.isEmpty())) {
            idFornecedor = Integer.parseInt(((ArrayList)Objeto.get(0)).get(1).toString());
            jtfFornecedor.setText(((ArrayList)Objeto.get(0)).get(1).toString());
            edDescFornecedor.setText(((ArrayList)Objeto.get(0)).get(2).toString());
            Vector vetor = new Vector();
            for (Iterator<ArrayList> it = ((ArrayList)Objeto.get(1)).iterator(); it.hasNext();) {
                ArrayList object = it.next();
                Vector Lista = new Vector();
                Lista.add(object.get(7)); // 0 idproduto
                Lista.add(object.get(8)); // 1 descricaoProduto
                Lista.add(((ArrayList)Objeto.get(0)).get(0).toString()); // 2 idFonrecedor
                Lista.add(object.get(0)); // 3 descFonrecedor
                Lista.add(object.get(1)); // 4 idTipoFornecedor
                Lista.add(object.get(6)); // 5 desTipoFornecedor
                Lista.add(object.get(3)); // 6 codigo fornecedor produto
                Lista.add(object.get(4)); // 7 tempoentrega
                Lista.add(object.get(5)); // 8 idfornecedorproduto
                Lista.add(object.get(2)); // 9 codigo produto
                ListaProduto.add(Lista);   
            }   
        }
    }

}
