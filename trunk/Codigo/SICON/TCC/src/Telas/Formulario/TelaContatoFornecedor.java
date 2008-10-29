/*
 * TelaContatoFornecedor.java
 *
 * Created on 19 de Agosto de 2008, 22:39
 */

package Telas.Formulario;

import Controller.ControllerContato;
import Telas.Componentes.TelaInterna;
import Telas.Tabelas.JTableContato;
import Telas.Tabelas.JTableEmail;
import Telas.Tabelas.JTableTelefone;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaContatoFornecedor extends TelaAncestral implements InterfacePadraoTelaVarias {

    private TelaFornecedor telaFornecedor;
    private TelaInterna telaInterna;
    private JDesktopPane TelaPrincipal;    
    private Vector ListaTelefone;
    private Vector ListaEmail;
    private Vector ListaTipoTelefone;
    private ControllerContato Controller;
    private Vector ListaContato;
    private ArrayList<Integer> ListaTelefoneExcluir;
    private ArrayList<Integer> ListaEmailExcluir;
    private Integer PosicaoEmail;
    private Integer PosicaoTelefone;
    public Integer IdFornecedor;
    
    /** Creates new form BeanForm */
    public TelaContatoFornecedor() {
        initComponents();       
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnCadastro,this.jpnPesquisa, this.jpnTela);
        super.setTitulo("Contato do Fornecedor");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1); 
        ListaTelefone = new Vector();
        ListaEmail = new Vector();
        ListaTipoTelefone = new Vector();  
        ListaContato = new Vector();
        ListaTelefoneExcluir = new ArrayList();
        ListaEmailExcluir = new ArrayList();
        Controller = new ControllerContato();
        CarregarComboTipoTelefone();
        PosicaoEmail = null;
        PosicaoTelefone = null;
        IdFornecedor = 0;
    }
    
    private void CarregarComboTipoTelefone(){
        Vector Lista = new Vector();
        Lista = Controller.CarregarComboTipoTelefone();
        ListaTipoTelefone = Lista;
        Vector vetor = new Vector();
        for (Iterator<Vector> it = Lista.iterator(); it.hasNext();) {
            Vector object = it.next();
            vetor.add(object.get(1));           
        }
        jcbTipoTelefone.setModel(new DefaultComboBoxModel(vetor));        
    }
    
   
    /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/     
    
   @Override
    protected boolean ComportamentoSalvar() {
        return Gravar();
    }  

    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
            if (super.getLocalizacao() == 0) {
                int Posicao = jtbContato.getSelectedRow();
                if ((Integer)((Vector)ListaContato.get(Posicao)).get(4) == 0) {
                    Controller.EventoExcluirUnicoEmail((Integer)((Vector)ListaContato.get(Posicao)).get(6));
                } else {
                    Controller.EventoExcluirUnicoTelefone((Integer)((Vector)ListaContato.get(Posicao)).get(6));
                }
                this.ComportamentoPesquisar();
            } else {
                if (Controller.EventoExcluir(ListaTelefone, ListaEmail)) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(5), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));     
                    Excluiu = true;
                    this.ComportamentoPesquisar();
                } else {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(6), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));
                }
            }           
        }
        return Excluiu;
    }   
    
    @Override
    protected void ComportamentoNovo() {
        LimparFormulario(jpnPesquisa);  
        ListaEmail.clear();
        ListaTelefone.clear();
        ListaEmailExcluir.clear();
        ListaTelefoneExcluir.clear();
        jtbTelefone.setModel(new JTableTelefone(ListaTelefone));
        jtbEmail.setModel(new JTableEmail(ListaEmail));
        jcbTipoTelefone.setSelectedIndex(0);
    }    
    
    private boolean Gravar(){
        boolean Gravou = false;
        if (super.VerificaCampos(jpnPesquisa, 1)) {
            if (super.Operacao == 0) {                                 
                if (Controller.EventoSalvar((Vector)ListaTelefone, (Vector)ListaEmail)) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));             
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png")); 
            } else if (super.Operacao == 1) {
                if (Controller.EventoAlterar((Vector)ListaTelefone, ListaTelefoneExcluir, (Vector) ListaEmail, ListaEmailExcluir)) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(4), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png")); 
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));                    
                }
            } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));            
        return Gravou;        
    }     
    
   @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = new ArrayList();
        ListaParametros = setParametros();
        ListaContato = (Vector) Controller.EventoPesquisar(ListaParametros);
        if (!(ListaContato.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbContato.setModel(new JTableContato(ListaContato)); 
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
        jpnPesquisa = new javax.swing.JPanel();
        jlb1Fornecedor = new javax.swing.JLabel();
        jlb3Email = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlb2Tipo = new javax.swing.JLabel();
        jlbTel = new javax.swing.JLabel();
        jtfDdd = new javax.swing.JTextField();
        jtfNumero = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfFornecedor = new javax.swing.JTextField();
        jbtFornecedor = new javax.swing.JButton();
        jpnTel = new javax.swing.JPanel();
        jcbTipoTelefone = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTelefone = new javax.swing.JTable();
        jbtExcluirTelefone = new javax.swing.JButton();
        jbtAdicionarTelefone = new javax.swing.JButton();
        jlbENd = new javax.swing.JLabel();
        jpnEnd = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbEmail = new javax.swing.JTable();
        jlb2Numero = new javax.swing.JLabel();
        jbtAdicionarEmail = new javax.swing.JButton();
        jbtExcluirEmail = new javax.swing.JButton();
        edDescFornecedor = new javax.swing.JTextField();
        jlb1Ddd = new javax.swing.JLabel();
        jbtNovoTelefone = new javax.swing.JButton();
        jbtNovoEmail = new javax.swing.JButton();
        jpnCadastro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtfFornecedorPesq = new javax.swing.JTextField();
        jbtFornecedorPesq = new javax.swing.JButton();
        jtfNumTelefonePesq = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfEmailPesq = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbContato = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N

        jlb1Fornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Fornecedor.setText("* Fornecedor");
        jlb1Fornecedor.setName("jlb1Fornecedor"); // NOI18N

        jlb3Email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb3Email.setText("Endereço eletrônico");
        jlb3Email.setName("jlb3Email"); // NOI18N

        jLabel4.setText("* Número");

        jlb2Tipo.setText("Tipo ");
        jlb2Tipo.setName("jlb2Tipo"); // NOI18N

        jlbTel.setText("Telefones");
        jlbTel.setName("jlbTel"); // NOI18N

        jtfDdd.setName("jtfDdd"); // NOI18N

        jtfNumero.setName("jtfNumero"); // NOI18N

        jtfEmail.setName("jtfEmail"); // NOI18N
        jtfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmailActionPerformed(evt);
            }
        });

        jtfFornecedor.setName("jtfFornecedor"); // NOI18N
        jtfFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFornecedorActionPerformed(evt);
            }
        });
        jtfFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfFornecedorFocusLost(evt);
            }
        });

        jbtFornecedor.setText("jButton1");
        jbtFornecedor.setName("jbtFornecedor"); // NOI18N
        jbtFornecedor.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFornecedorMousePressed(evt);
            }
        });

        jpnTel.setBackground(new java.awt.Color(200, 199, 190));
        jpnTel.setName("jpnTel"); // NOI18N
        jpnTel.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jpnTelLayout = new javax.swing.GroupLayout(jpnTel);
        jpnTel.setLayout(jpnTelLayout);
        jpnTelLayout.setHorizontalGroup(
            jpnTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        jpnTelLayout.setVerticalGroup(
            jpnTelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jcbTipoTelefone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comercial", "Residencial", "Celular" }));
        jcbTipoTelefone.setName("jcbTipoTelefone"); // NOI18N
        jcbTipoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoTelefoneActionPerformed(evt);
            }
        });

        jtbTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número", "Tipo"
            }
        ));
        jtbTelefone.setName("jtbTelefone"); // NOI18N
        jtbTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbTelefoneMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTelefone);

        jbtExcluirTelefone.setText("Excluir  ");
        jbtExcluirTelefone.setName("jbtExcluirTelefone"); // NOI18N
        jbtExcluirTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtExcluirTelefoneMousePressed(evt);
            }
        });
        jbtExcluirTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirTelefoneActionPerformed(evt);
            }
        });

        jbtAdicionarTelefone.setText("Adicionar");
        jbtAdicionarTelefone.setName("jbtAdicionarTelefone"); // NOI18N
        jbtAdicionarTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarTelefoneMousePressed(evt);
            }
        });

        jlbENd.setText("E-mails");
        jlbENd.setName("jlbENd"); // NOI18N

        jpnEnd.setBackground(new java.awt.Color(200, 199, 190));
        jpnEnd.setName("jpnEnd"); // NOI18N
        jpnEnd.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jpnEndLayout = new javax.swing.GroupLayout(jpnEnd);
        jpnEnd.setLayout(jpnEndLayout);
        jpnEndLayout.setHorizontalGroup(
            jpnEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        jpnEndLayout.setVerticalGroup(
            jpnEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jtbEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Endereço"
            }
        ));
        jtbEmail.setName("jtbEmail"); // NOI18N
        jtbEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbEmailMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtbEmail);

        jlb2Numero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb2Numero.setText("* Número");
        jlb2Numero.setName("jlb2Numero"); // NOI18N

        jbtAdicionarEmail.setText("Adicionar");
        jbtAdicionarEmail.setName("jbtAdicionarEmail"); // NOI18N
        jbtAdicionarEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarEmailMousePressed(evt);
            }
        });

        jbtExcluirEmail.setText("Excluir  ");
        jbtExcluirEmail.setName("jbtExcluirEmail"); // NOI18N
        jbtExcluirEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtExcluirEmailMousePressed(evt);
            }
        });
        jbtExcluirEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirEmailActionPerformed(evt);
            }
        });

        edDescFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        edDescFornecedor.setEditable(false);
        edDescFornecedor.setFont(new java.awt.Font("Arial", 1, 11));
        edDescFornecedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescFornecedor.setName("edDescFornecedor"); // NOI18N

        jlb1Ddd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Ddd.setText("* DDD");
        jlb1Ddd.setName("jlb2Ddd"); // NOI18N

        jbtNovoTelefone.setText("Novo");
        jbtNovoTelefone.setName("jbtNovoTelefone"); // NOI18N
        jbtNovoTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtNovoTelefoneMousePressed(evt);
            }
        });
        jbtNovoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoTelefoneActionPerformed(evt);
            }
        });

        jbtNovoEmail.setText("Novo");
        jbtNovoEmail.setName("jbtNovoEmail"); // NOI18N
        jbtNovoEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtNovoEmailMousePressed(evt);
            }
        });
        jbtNovoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnPesquisaLayout = new javax.swing.GroupLayout(jpnPesquisa);
        jpnPesquisa.setLayout(jpnPesquisaLayout);
        jpnPesquisaLayout.setHorizontalGroup(
            jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPesquisaLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jpnEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE))
            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addComponent(jlbTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 878, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbENd))
                .addContainerGap())
            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlb3Email, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpnPesquisaLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jlb1Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlb1Ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPesquisaLayout.createSequentialGroup()
                                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPesquisaLayout.createSequentialGroup()
                                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbtExcluirEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtNovoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtAdicionarEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                        .addGap(84, 84, 84))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPesquisaLayout.createSequentialGroup()
                                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbtExcluirTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtNovoTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtAdicionarTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addGap(85, 85, 85))))
                            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfDdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlb2Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlb2Tipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnPesquisaLayout.setVerticalGroup(
            jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb1Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jlbTel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb2Numero)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb2Tipo)
                    .addComponent(jcbTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Ddd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jlbENd))
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtAdicionarTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtNovoTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtExcluirTelefone)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb3Email, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addComponent(jbtAdicionarEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtNovoEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtExcluirEmail))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.CENTER);

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N
        jpnCadastro.setPreferredSize(new java.awt.Dimension(100, 150));
        jpnCadastro.setLayout(new java.awt.BorderLayout());

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

        jtfNumTelefonePesq.setName("jtfNumTelefonePesq"); // NOI18N

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Número Tel.");

        jtfEmailPesq.setName("jtfEmailPesq"); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Endereço eletrônico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumTelefonePesq, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfEmailPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNumTelefonePesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmailPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jpnCadastro.add(jPanel1, java.awt.BorderLayout.NORTH);

        jtbContato.setBackground(new java.awt.Color(243, 243, 243));
        jtbContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fornecedor", "Contato", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        jtbContato.setName("jtbContato"); // NOI18N
        jtbContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbContatoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbContato);

        jpnCadastro.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jcbTipoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoTelefoneActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbTipoTelefoneActionPerformed

private void jbtExcluirTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirTelefoneActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtExcluirTelefoneActionPerformed

private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfEmailActionPerformed

private void jbtExcluirEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirEmailActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtExcluirEmailActionPerformed

private void jbtFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFornecedorMousePressed
    InstaciaTelaFornecedor();
}//GEN-LAST:event_jbtFornecedorMousePressed

private void jbtAdicionarTelefoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarTelefoneMousePressed
    AdicionarTelefone();
}//GEN-LAST:event_jbtAdicionarTelefoneMousePressed

private void AdicionarTelefone(){
    Vector Lista = new Vector();
    Lista.add(this.IdFornecedor.toString());
    Lista.add(edDescFornecedor.getText());
    Lista.add(jtfDdd.getText());
    Lista.add(jtfNumero.getText());    
    Lista.add(((Vector)ListaTipoTelefone.get(jcbTipoTelefone.getSelectedIndex())).get(0));
    Lista.add(((Vector)ListaTipoTelefone.get(jcbTipoTelefone.getSelectedIndex())).get(1));     
    if (PosicaoTelefone != null) {
        Lista.add(Integer.parseInt(((Vector)ListaTelefone.get(PosicaoTelefone)).get(6).toString())); // idTelefone                   
        ListaTelefone.set(PosicaoTelefone, Lista);
    } else {
        Lista.add(0);
        ListaTelefone.add(Lista);       
    }
    jbtAdicionarTelefone.setText("Adicionar");
    jtbTelefone.setModel(new JTableTelefone(ListaTelefone));
}

private void jbtAdicionarEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarEmailMousePressed
    AdicionarEmail();
}//GEN-LAST:event_jbtAdicionarEmailMousePressed

private void jtbContatoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbContatoMousePressed
  if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {    
      Selecionar(((Vector)ListaContato.get(jtbContato.getSelectedRow())).get(0).toString());
  }
}//GEN-LAST:event_jtbContatoMousePressed

private void jbtExcluirTelefoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirTelefoneMousePressed
    if (Integer.parseInt(((Vector)ListaTelefone.get(jtbTelefone.getSelectedRow())).get(6).toString()) != 0) {
        ListaTelefoneExcluir.add(Integer.parseInt(((Vector)ListaTelefone.get(jtbTelefone.getSelectedRow())).get(6).toString()));
    }
    ListaTelefone.remove(jtbTelefone.getSelectedRow());
    jtbTelefone.setModel(new JTableTelefone(ListaTelefone));
}//GEN-LAST:event_jbtExcluirTelefoneMousePressed

private void jbtExcluirEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirEmailMousePressed
    if (Integer.parseInt(((Vector)ListaEmail.get(jtbEmail.getSelectedRow())).get(6).toString()) != 0) {
        ListaEmailExcluir.add(Integer.parseInt(((Vector)ListaEmail.get(jtbEmail.getSelectedRow())).get(6).toString()));
    }
    ListaEmail.remove(jtbEmail.getSelectedRow());
    jtbEmail.setModel(new JTableEmail(ListaEmail));    
}//GEN-LAST:event_jbtExcluirEmailMousePressed

private void jbtNovoTelefoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNovoTelefoneMousePressed
    LimparCamposTelefone();
    PosicaoTelefone = null;
    jbtAdicionarTelefone.setText("Adicionar");
}//GEN-LAST:event_jbtNovoTelefoneMousePressed

private void LimparCamposTelefone(){
    jtfDdd.setText("");
    jtfNumero.setText("");
    jcbTipoTelefone.setSelectedIndex(0);
}
private void jbtNovoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoTelefoneActionPerformed
    
}//GEN-LAST:event_jbtNovoTelefoneActionPerformed

private void jbtNovoEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNovoEmailMousePressed
    LimparCamposEmail();
    PosicaoEmail = null;
    jbtAdicionarEmail.setText("Adicionar");
}//GEN-LAST:event_jbtNovoEmailMousePressed

private void LimparCamposEmail(){
    jtfEmail.setText("");
}


private void jbtNovoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoEmailActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtNovoEmailActionPerformed

private void jtbTelefoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTelefoneMousePressed
  if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
      SetarCamposTelefone();
      jbtAdicionarTelefone.setText("Salvar");    
  }
}//GEN-LAST:event_jtbTelefoneMousePressed

private void jtbEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbEmailMousePressed
    SetarCamposEmail();
    jbtAdicionarEmail.setText("Salvar");
}//GEN-LAST:event_jtbEmailMousePressed

private void jtfFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfFornecedorFocusLost
    AoSairCampoFornecedor();
}//GEN-LAST:event_jtfFornecedorFocusLost

private void jtfFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFornecedorActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfFornecedorActionPerformed

private void jbtFornecedorPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFornecedorPesqMousePressed
    InstaciaTelaFornecedor();
}//GEN-LAST:event_jbtFornecedorPesqMousePressed

private void AoSairCampoFornecedor() {
    ArrayList Lista = Controller.EventoSairCampoFornecedor(jtfFornecedor.getText());
    setCamposFornecedor((Integer)Lista.get(0), Lista.get(1).toString(), Lista.get(2).toString());    
}
private void SetarCamposEmail(){
   PosicaoEmail = jtbEmail.getSelectedRow();
   jtfEmail.setText(((Vector)ListaEmail.get(PosicaoEmail)).get(3).toString());
}
private void SetarCamposTelefone(){
    PosicaoTelefone = jtbTelefone.getSelectedRow();
    jtfDdd.setText(((Vector)ListaTelefone.get(PosicaoTelefone)).get(2).toString());
    jtfNumero.setText(((Vector)ListaTelefone.get(PosicaoTelefone)).get(3).toString());
    jcbTipoTelefone.setSelectedIndex(Integer.parseInt(((Vector)ListaTelefone.get(PosicaoTelefone)).get(4).toString()) - 1);    
    
}
public void Selecionar(String CodigoFornecedor){
    ArrayList Lista = new ArrayList();
    Lista.add("fornecedor");
    Lista.add(CodigoFornecedor);
    LimparFormulario(jpnPesquisa);   
    LimparTodasListas();
    ListaContato = (Vector) Controller.EventoPesquisar(Lista);
    ControllerParaTelaVector(ListaContato);
    super.ComportamentoSelecionar();  
}

private void LimparTodasListas(){
    ListaTelefone.clear();
    ListaEmailExcluir.clear();
    ListaTelefoneExcluir.clear();
    ListaEmail.clear();
}
private void AdicionarEmail(){
    Vector Lista = new Vector();
    Lista.add(this.IdFornecedor.toString());
    Lista.add(edDescFornecedor.getText());
    Lista.add("");
    Lista.add(jtfEmail.getText());
    Lista.add(0);
    Lista.add("Email");
    if (PosicaoEmail != null) {
        Lista.add(Integer.parseInt(((Vector)ListaEmail.get(PosicaoEmail)).get(6).toString())); // idEmail          
        ListaEmail.set(PosicaoEmail, Lista);                 
    } else {
        Lista.add(0); // idEmail
        ListaEmail.add(Lista);        
    }   
    jtbEmail.setModel(new JTableEmail(ListaEmail));
}

private void InstaciaTelaFornecedor(){
    telaFornecedor = new TelaFornecedor(); 
    telaFornecedor.setTipoVisualizacao(1); 
    EscreverMetodosAbstratosTelasInternas();
    super.CarregarTelaInterna(telaInterna, "Fornecedor", null);        
    CarregarTelaFornecedor(telaInterna);
        try {
            telaInterna.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void setCamposFornecedor(Integer Forn, String CodigoFornecedor, String DescFornecedor) {
    if (super.getLocalizacao() == 1) {
        this.IdFornecedor = Forn;
        jtfFornecedor.setText(CodigoFornecedor);
        edDescFornecedor.setText(DescFornecedor);
    } else jtfFornecedorPesq.setText(CodigoFornecedor);
}

    
  public void CarregarTelaFornecedor(TelaInterna Frame){
    telaFornecedor.setVisible(true);
    //telaPerfil.setJTextRetorno(jtfPerfil);
    telaFornecedor.setTelaContatoFornecedor(this);
    telaFornecedor.setFrameInterno(Frame);
    Frame.add(telaFornecedor);
    TelaPrincipal.add(Frame);
    Frame.setVisible(true);     
} 
  
    private void EscreverMetodosAbstratosTelasInternas() {
        telaInterna = new TelaInterna(){

            @Override
            public void EventoFechar() {
                HabilitaForm();               
            }

            @Override
            public void EventoAbrir() {
                DesabilitaForm();
            }
        };
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edDescFornecedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtAdicionarEmail;
    private javax.swing.JButton jbtAdicionarTelefone;
    private javax.swing.JButton jbtExcluirEmail;
    private javax.swing.JButton jbtExcluirTelefone;
    private javax.swing.JButton jbtFornecedor;
    private javax.swing.JButton jbtFornecedorPesq;
    private javax.swing.JButton jbtNovoEmail;
    private javax.swing.JButton jbtNovoTelefone;
    private javax.swing.JComboBox jcbTipoTelefone;
    private javax.swing.JLabel jlb1Ddd;
    private javax.swing.JLabel jlb1Fornecedor;
    private javax.swing.JLabel jlb2Numero;
    private javax.swing.JLabel jlb2Tipo;
    private javax.swing.JLabel jlb3Email;
    private javax.swing.JLabel jlbENd;
    private javax.swing.JLabel jlbTel;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnEnd;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTel;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbContato;
    private javax.swing.JTable jtbEmail;
    private javax.swing.JTable jtbTelefone;
    private javax.swing.JTextField jtfDdd;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEmailPesq;
    private javax.swing.JTextField jtfFornecedor;
    private javax.swing.JTextField jtfFornecedorPesq;
    private javax.swing.JTextField jtfNumTelefonePesq;
    private javax.swing.JTextField jtfNumero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDesktopPane(JDesktopPane Pane) {
        this.TelaPrincipal = Pane;
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
        if (!(jtfFornecedorPesq.getText().equals(""))){
            ListaParametros.add("fornecedor");
            ListaParametros.add(jtfFornecedorPesq.getText());
        } 
        if (!(jtfNumTelefonePesq.getText().equals(""))) {
            ListaParametros.add("telefone");
            ListaParametros.add(jtfNumTelefonePesq.getText());
        }
        if (!(jtfEmailPesq.getText().equals(""))){
            ListaParametros.add("email");
            ListaParametros.add(jtfEmailPesq.getText());
        }
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setComportamentoTable(boolean Comportamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList ListaController = new ArrayList();
        ListaController.add(jtfFornecedor.getText());
        ListaController.add(edDescFornecedor.getText());
        ListaController.add(ListaTelefone);
        ListaController.add(ListaEmail);
        return ListaController;
    }

    @Override
    public void ControllerParaTela(ArrayList Objeto) {
        for (Iterator<Vector> it = Objeto.iterator(); it.hasNext();) {
            Vector object = it.next();
            if (Integer.parseInt(object.get(4).toString()) == 0) {
                ListaEmail.add(object);
            } else ListaTelefone.add(object);
        }
    }
    
    public void ControllerParaTelaVector(List Objeto) {
        for (Iterator<Vector> it = Objeto.iterator(); it.hasNext();) {
            Vector object = it.next();
            if (Integer.parseInt(object.get(4).toString()) == 0) {
                ListaEmail.add(object);
            } else ListaTelefone.add(object);
        } 
        if ((!(Objeto.isEmpty())) && (jtbContato.getSelectedRow() > 0)){
            this.IdFornecedor = (Integer)((Vector)ListaContato.get(jtbContato.getSelectedRow())).get(0);
            jtfFornecedor.setText(((Vector)ListaContato.get(jtbContato.getSelectedRow())).get(7).toString());
            edDescFornecedor.setText(((Vector)ListaContato.get(jtbContato.getSelectedRow())).get(1).toString());
        }
        jtbTelefone.setModel(new JTableTelefone(ListaTelefone));
        jtbEmail.setModel(new JTableEmail(ListaEmail));        
    }

}
