/*
 * TelaPagamentoFornecedor.java
 *
 * Created on 19 de Agosto de 2008, 23:02
 */

package Telas.Formulario;

import Controller.ControllerFormaPagamentoFornecedor;
import Telas.Componentes.TelaInterna;
import Telas.Formulario.TelaFornecedor;
import Telas.Tabelas.JTableForma;
import Telas.Tabelas.JTableFormaPagamentoFornecedor;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaPagamentoFornecedor extends TelaAncestral implements InterfacePadraoTelaVarias{

    private JDesktopPane telaPrincipal;
    private TelaFornecedor telaFornecedor;
    private TelaInterna telaInterna;
    public Integer IdFornecedor;
    private TelaFormaPagamento telaFormaPagamento;
    private ArrayList ListaForma;
    private ControllerFormaPagamentoFornecedor Controller;
    private Integer PosicaoForma;
    private Vector ListaPagamentoFornecedor;
    
    /** Creates new form BeanForm */
    public TelaPagamentoFornecedor() {
        initComponents();  
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela( this.jpnCadastro, this.jpnPesquisa, this.jpnTela);
        super.setTitulo("Forma de Pagamento do Fornecedor");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);   
        ListaForma = new ArrayList();
        Controller = new ControllerFormaPagamentoFornecedor();
        PosicaoForma = null;
    }    
    
   /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        boolean Validou = false;
        if ((super.Mensagens.ExibirMensagem(11))==0) {//(JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
            if (super.getLocalizacao() == 0) {            
                if (!(ListaPagamentoFornecedor.isEmpty())){
                    if (jtbPagamentoFornecedor.getSelectedRow() >= 0) {
                        if (Controller.EventoExcluirPeloId(String.valueOf(RetornaId(jtbPagamentoFornecedor.getSelectedRow())))) {
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
        if (super.VerificaCampos(jpnCadastro,1)) {
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
            } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png")); 
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
        ListaPagamentoFornecedor = Controller.EventoPesquisarVector(ListaParametros);
        if (!(ListaPagamentoFornecedor.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbPagamentoFornecedor.setModel(new JTableFormaPagamentoFornecedor(ListaPagamentoFornecedor)); 
        return Achou;
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
        jLabel2 = new javax.swing.JLabel();
        jlb2Forma = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbForma = new javax.swing.JTable();
        jbtAdicionarForma = new javax.swing.JButton();
        jbtExcluirForma = new javax.swing.JButton();
        jtfForma = new javax.swing.JTextField();
        jbtForma = new javax.swing.JButton();
        jtfFornecedor = new javax.swing.JTextField();
        jbtFornecedor = new javax.swing.JButton();
        edDescFornecedor = new javax.swing.JTextField();
        edDescForma = new javax.swing.JTextField();
        jtbNovoForma = new javax.swing.JButton();
        jpnCadastro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPagamentoFornecedor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtfFormaPesq = new javax.swing.JTextField();
        jtfFornecedorPesq = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jbtFormaPesq = new javax.swing.JButton();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N

        jLabel2.setText("* Fornecedor");

        jlb2Forma.setText("* Forma");

        jLabel7.setText("Formas de Pagamentos");

        jPanel3.setBackground(new java.awt.Color(200, 199, 190));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jtbForma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Forma Pagamento"
            }
        ));
        jtbForma.setName("jtbForma"); // NOI18N
        jtbForma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFormaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbForma);

        jbtAdicionarForma.setText("Adicionar");
        jbtAdicionarForma.setName("jbtAdicionarForma"); // NOI18N
        jbtAdicionarForma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarFormaMousePressed(evt);
            }
        });

        jbtExcluirForma.setText("Excluir  ");
        jbtExcluirForma.setName("jbtExcluirForma"); // NOI18N
        jbtExcluirForma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtExcluirFormaMousePressed(evt);
            }
        });
        jbtExcluirForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirFormaActionPerformed(evt);
            }
        });

        jtfForma.setColumns(6);
        jtfForma.setName("jtfForma"); // NOI18N

        jbtForma.setText("jButton1");
        jbtForma.setName("jbtForma"); // NOI18N
        jbtForma.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtForma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFormaMousePressed(evt);
            }
        });

        jtfFornecedor.setColumns(6);
        jtfFornecedor.setName("jtfFornecedor"); // NOI18N

        jbtFornecedor.setText("jButton1");
        jbtFornecedor.setName("jbtFornecedor"); // NOI18N
        jbtFornecedor.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFornecedorMousePressed(evt);
            }
        });

        edDescFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        edDescFornecedor.setEditable(false);
        edDescFornecedor.setFont(new java.awt.Font("Arial", 1, 11));
        edDescFornecedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescFornecedor.setName("edDescFornecedor"); // NOI18N

        edDescForma.setBackground(new java.awt.Color(204, 204, 204));
        edDescForma.setEditable(false);
        edDescForma.setFont(new java.awt.Font("Arial", 1, 11));
        edDescForma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescForma.setName("edDescForma"); // NOI18N

        jtbNovoForma.setText("Novo");
        jtbNovoForma.setName("jtbNovoForma"); // NOI18N
        jtbNovoForma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbNovoFormaMousePressed(evt);
            }
        });
        jtbNovoForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbNovoFormaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnPesquisaLayout = new javax.swing.GroupLayout(jpnPesquisa);
        jpnPesquisa.setLayout(jpnPesquisaLayout);
        jpnPesquisaLayout.setHorizontalGroup(
            jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jlb2Forma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                                .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE))
                            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                                .addComponent(jtfForma, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtForma, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edDescForma, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtExcluirForma, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(jtbNovoForma, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(jbtAdicionarForma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jpnPesquisaLayout.setVerticalGroup(
            jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPesquisaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfFornecedor)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edDescForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jlb2Forma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfForma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPesquisaLayout.createSequentialGroup()
                        .addComponent(jbtAdicionarForma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbNovoForma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtExcluirForma))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(283, 283, 283))
        );

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.CENTER);

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N
        jpnCadastro.setPreferredSize(new java.awt.Dimension(100, 150));
        jpnCadastro.setLayout(new java.awt.BorderLayout());

        jtbPagamentoFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fornecedor", "Forma"
            }
        ));
        jtbPagamentoFornecedor.setName("jtbPagamentoFornecedor"); // NOI18N
        jtbPagamentoFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbPagamentoFornecedorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPagamentoFornecedor);

        jpnCadastro.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 65));

        jLabel6.setText("Forma de Pagamento");

        jtfFormaPesq.setColumns(6);
        jtfFormaPesq.setName("jtfFormaPesq"); // NOI18N

        jtfFornecedorPesq.setColumns(6);
        jtfFornecedorPesq.setName("jtfFornecedorPesq"); // NOI18N

        jLabel3.setText("Fornecedor");

        jButton3.setText("jButton1");
        jButton3.setPreferredSize(new java.awt.Dimension(73, 19));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jbtFormaPesq.setText("jButton1");
        jbtFormaPesq.setName("jbtFormaPesq"); // NOI18N
        jbtFormaPesq.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtFormaPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFormaPesqMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(jtfFormaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtFormaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(559, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfFornecedorPesq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtFormaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfFormaPesq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnCadastro.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jbtExcluirFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirFormaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtExcluirFormaActionPerformed


private void jbtFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFornecedorMousePressed
    InstaciaTelaFornecedor();
}//GEN-LAST:event_jbtFornecedorMousePressed

    private void InstaciaTelaFornecedor(){
        telaFornecedor = new TelaFornecedor(); 
        telaFornecedor.setTelaPagamentoFornecedor(this);
        telaFornecedor.setTipoVisualizacao(1); 
        telaFornecedor.setDesktopPane(telaPrincipal);
        EscreverMetodosAbstratosTelasInternas();
        super.CarregarTelaInterna(telaInterna, "Fornecedor", null);        
        CarregarTelaFornecedor(telaInterna);
            try {
                telaInterna.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }    

  public void CarregarTelaFornecedor(TelaInterna Frame){
        telaFornecedor.setVisible(true);
        //telaPerfil.setJTextRetorno(jtfPerfil);
        //telaContatoFornecedor.setTelaUsuario(this);
        telaFornecedor.setFrameInterno(Frame);
        Frame.add(telaFornecedor);
        telaPrincipal.add(Frame);
        Frame.setVisible(true);     
    } 
  
  public void setarCamposFornecedor(Integer Id, String Codigo, String RazaoSocial){
     if (super.getLocalizacao() == 1){
          jtfFornecedor.setText(Codigo);
          edDescFornecedor.setText(RazaoSocial);    
          this.IdFornecedor = Id;
     } else jtfFornecedorPesq.setText(Codigo);
  }

private void jbtFormaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFormaMousePressed
    InstaciaTelaForma();
}//GEN-LAST:event_jbtFormaMousePressed

private void jtbNovoFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbNovoFormaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtbNovoFormaActionPerformed

private void jbtAdicionarFormaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarFormaMousePressed
    AdicionarForma();
}//GEN-LAST:event_jbtAdicionarFormaMousePressed

private void jtbNovoFormaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNovoFormaMousePressed
    jtfForma.setText("");
    edDescForma.setText("");
    PosicaoForma = null;
}//GEN-LAST:event_jtbNovoFormaMousePressed

private void jtbFormaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFormaMousePressed
  if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
      PosicaoForma = jtbForma.getSelectedRow();
      setarCamposForma(((ArrayList)ListaForma.get(PosicaoForma)).get(0).toString(), ((ArrayList)ListaForma.get(PosicaoForma)).get(1).toString());
      jbtAdicionarForma.setText("Salvar");    
  }
}//GEN-LAST:event_jtbFormaMousePressed

private void jbtExcluirFormaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirFormaMousePressed
    ExcluirForma();
}//GEN-LAST:event_jbtExcluirFormaMousePressed

private void jtbPagamentoFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPagamentoFornecedorMousePressed
    if ((evt.getClickCount()==1) & (evt.getButton()== MouseEvent.BUTTON1)) {
        Selecionar(((Vector)ListaPagamentoFornecedor.get(jtbPagamentoFornecedor.getSelectedRow())).get(0).toString());
    }
}//GEN-LAST:event_jtbPagamentoFornecedorMousePressed

private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
    InstaciaTelaFornecedor();
}//GEN-LAST:event_jButton3MousePressed

private void jbtFormaPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFormaPesqMousePressed
    InstaciaTelaForma();
}//GEN-LAST:event_jbtFormaPesqMousePressed

public void Selecionar(String id) {
        ControllerParaTela(Controller.EventoSelecionar(Integer.parseInt(id)));                    
        super.ComportamentoSelecionar();   
}
private void ExcluirForma(){
    ListaForma.remove(jtbForma.getSelectedRow());
    jtbForma.setModel(new JTableForma(ListaForma));
}
private void AdicionarForma(){
    if (super.VerificaCampos(jpnCadastro, 2)){
        ArrayList Lista = new ArrayList();
        Lista.add(jtfForma.getText());
        Lista.add(edDescForma.getText());
        if (PosicaoForma == null){
            ListaForma.add(Lista);
        } else
            ListaForma.set(PosicaoForma, Lista);        
        jtbForma.setModel(new JTableForma(ListaForma));
        jbtAdicionarForma.setText("Adicionar");
    } else 
        JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));         
}
    private void InstaciaTelaForma(){
        telaFormaPagamento = new TelaFormaPagamento(); 
        telaFormaPagamento.setTelaPagamentoFornecedor(this);
        telaFormaPagamento.setTipoVisualizacao(1); 
        telaFormaPagamento.setDesktopPane(telaPrincipal);
        EscreverMetodosAbstratosTelasInternas();
        super.CarregarTelaInterna(telaInterna, "Forma Pagamento", null);        
        CarregarTelaForma(telaInterna);
            try {
                telaInterna.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }    

  public void CarregarTelaForma(TelaInterna Frame){
        telaFormaPagamento.setVisible(true);
        //telaPerfil.setJTextRetorno(jtfPerfil);
        //telaContatoFornecedor.setTelaUsuario(this);
        telaFormaPagamento.setFrameInterno(Frame);
        Frame.add(telaFormaPagamento);
        telaPrincipal.add(Frame);
        Frame.setVisible(true);     
    } 
  
  public void setarCamposForma(String Codigo, String Descricao){
      if (super.getLocalizacao() == 1) {
          jtfForma.setText(Codigo);
          edDescForma.setText(Descricao);   
      } else jtfFormaPesq.setText(Codigo);
  }    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edDescForma;
    private javax.swing.JTextField edDescFornecedor;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtAdicionarForma;
    private javax.swing.JButton jbtExcluirForma;
    private javax.swing.JButton jbtForma;
    private javax.swing.JButton jbtFormaPesq;
    private javax.swing.JButton jbtFornecedor;
    private javax.swing.JLabel jlb2Forma;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbForma;
    private javax.swing.JButton jtbNovoForma;
    private javax.swing.JTable jtbPagamentoFornecedor;
    private javax.swing.JTextField jtfForma;
    private javax.swing.JTextField jtfFormaPesq;
    private javax.swing.JTextField jtfFornecedor;
    private javax.swing.JTextField jtfFornecedorPesq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDesktopPane(JDesktopPane Pane) {
        this.telaPrincipal = Pane;
    }

    @Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Função setArrayselecionar não desenvolvida");
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
        if (!(jtfFornecedorPesq.getText().equals(""))) {
            ListaParametros.add("fornecedor");
            ListaParametros.add(jtfFornecedorPesq.getText());
        }
        if (!(jtfFormaPesq.getText().equals(""))) {
            ListaParametros.add("forma");
            ListaParametros.add(jtfFormaPesq.getText());
        }
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Vector)ListaPagamentoFornecedor.get(Linha)).get(4).toString());
    }

    @Override
    public void setComportamentoTable(boolean Comportamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList ListaEnviada = new ArrayList();
        ListaEnviada.add(jtfFornecedor.getText());
        ListaEnviada.add(ListaForma);
        return ListaEnviada;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfFornecedor.setText(Objeto.get(0).toString());
        edDescFornecedor.setText(Objeto.get(1).toString());
        ListaForma = ((ArrayList)Objeto.get(2));
        jtbForma.setModel(new JTableForma(ListaForma));
    }



}
