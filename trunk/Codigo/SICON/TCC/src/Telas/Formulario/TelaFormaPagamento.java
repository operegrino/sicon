/*
 * TelaFormaPagamento.java
 *
 * Created on 22 de Agosto de 2008, 00:16
 */

package Telas.Formulario;

import Controller.ControllerFormaPagamento;
import Telas.Tabelas.JTableFormaPagamento;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaFormaPagamento extends TelaAncestral implements InterfacePadraoTela{

    private ControllerFormaPagamento Controller;
    private TelaPagamentoFornecedor telaPagamentoFornecedor;
    private JDesktopPane telaPrincipal;
    List ListaFormaPagamento;
    
    /** Creates new form BeanForm */
    public TelaFormaPagamento() {
        initComponents();   
        IniciarTela();
    }
    
    @Override
    public void IniciarTela(){
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Forma de Pagamento");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);      
        ListaFormaPagamento = new ArrayList();
        Controller = new ControllerFormaPagamento();
    }
    
    
    
    public void setTelaPagamentoFornecedor(TelaPagamentoFornecedor Tela){
        this.telaPagamentoFornecedor = Tela;
    }
    
    public void setDesktopPane(JDesktopPane tela) {
        this.telaPrincipal = tela;
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
        ListaFormaPagamento = Controller.EventoPesquisar(ListaParametros);
        if (!(ListaFormaPagamento.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbFormaPagamento.setModel(new JTableFormaPagamento(ListaFormaPagamento)); 
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
        jtfNome = new javax.swing.JTextField();
        jlb1Nome = new javax.swing.JLabel();
        jcbOperacao = new javax.swing.JCheckBox();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNomePesq = new javax.swing.JTextField();
        jcbOperacaoPesq = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbFormaPagamento = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jtfNome.setName("jtfNome"); // NOI18N

        jlb1Nome.setText("* Nome");
        jlb1Nome.setName("jlb1Nome"); // NOI18N

        jcbOperacao.setBackground(new java.awt.Color(243, 243, 243));
        jcbOperacao.setText("Operação bancária");
        jcbOperacao.setName("jcbOperacao"); // NOI18N
        jcbOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOperacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jlb1Nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jcbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                        .addGap(129, 129, 129))))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb1Nome)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbOperacao)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 170));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 60));

        jLabel2.setText("Nome");

        jtfNomePesq.setName("jtfNomePesq"); // NOI18N

        jcbOperacaoPesq.setBackground(new java.awt.Color(243, 243, 243));
        jcbOperacaoPesq.setText("Operação bancária");
        jcbOperacaoPesq.setName("jcbOperacaoPesq"); // NOI18N
        jcbOperacaoPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOperacaoPesqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbOperacaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomePesq, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNomePesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbOperacaoPesq)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jtbFormaPagamento.setBackground(new java.awt.Color(243, 243, 243));
        jtbFormaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Descrição", "Dados Bancários"
            }
        ));
        jtbFormaPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFormaPagamentoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbFormaPagamento);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jcbOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOperacaoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbOperacaoActionPerformed

private void jcbOperacaoPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOperacaoPesqActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbOperacaoPesqActionPerformed

private void jtbFormaPagamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFormaPagamentoMousePressed
if ((evt.getClickCount()==1) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbFormaPagamento.getSelectedRow())));
            super.Operacao = 1;
            setComportamento(2);   
            super.setLocalizacao(1);
            super.setComportamentoPanel(2);
        } else {
            int Posicao = jtbFormaPagamento.getSelectedRow();
            this.telaPagamentoFornecedor.setarCamposForma(((Object[])ListaFormaPagamento.get(Posicao))[0].toString(), ((Object[])ListaFormaPagamento.get(Posicao))[1].toString());            
            super.FechaFrameInterno();
          }
    }
}//GEN-LAST:event_jtbFormaPagamentoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbOperacao;
    private javax.swing.JCheckBox jcbOperacaoPesq;
    private javax.swing.JLabel jlb1Nome;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbFormaPagamento;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNomePesq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
            setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        ArrayList ListaParametros = new ArrayList();        
        if (!(jtfNomePesq.getText().trim().equals(""))){
            ListaParametros.add("nome");
            ListaParametros.add(jtfNomePesq.getText());            
        } 
        ListaParametros.add("operacaobancaria");
        if (!(jcbOperacaoPesq.isSelected())) {
            ListaParametros.add("0");
        } else ListaParametros.add("1");        
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return (Integer)((Object[])ListaFormaPagamento.get(Linha))[0];
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(jtfNome.getText());
        if (jcbOperacao.isSelected()) {
            Lista.add("0");
        } else Lista.add("1");
        return Lista;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfNome.setText(Objeto.get(0).toString());
        if (Objeto.get(1).equals("0")) {
            jcbOperacao.setSelected(true);
        } else jcbOperacao.setSelected(false);
    }

}
