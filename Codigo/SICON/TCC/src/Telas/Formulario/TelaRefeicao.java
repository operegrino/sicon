/*
 * TelaRefeicao.java
 *
 * Created on 28 de Agosto de 2008, 21:07
 */

package Telas.Formulario;

import Classes.cardapio;
import Controller.ControllerRefeicao;
import Telas.Tabelas.JTableRefeicao;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaRefeicao extends TelaAncestral  implements InterfacePadraoTela {

    private Vector ListaRefeicao;
    private ControllerRefeicao Controller;
    private TelaCardapio telaCardapio;
    private TelaOrdemProducao telaOrdemProducao;
    /** Creates new form BeanForm */
    public TelaRefeicao() {
        initComponents();
        IniciarTela(); 
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Refeição");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);  
        ListaRefeicao = new Vector();
        Controller = new ControllerRefeicao();
    }   
    
    public void SetTelaCardapio(TelaCardapio tela) {
        this.telaCardapio = tela;
    }
    
    public void setTelaOrdemProducao(TelaOrdemProducao tela){
        this.telaOrdemProducao = tela;
    }
    
    /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
            if (super.getLocalizacao() == 0) {
                Controller.EventoSelecionar(RetornaId(jtbRefeicao.getSelectedRow()));
            }
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
        ListaRefeicao = (Vector) Controller.EventoPesquisar(ListaParametros);
        if (!(ListaRefeicao.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbRefeicao.setModel(new JTableRefeicao(ListaRefeicao)); 
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
        jtfRefeicao = new javax.swing.JTextField();
        jlb1Refeicao = new javax.swing.JLabel();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtfRefeicaoPesq = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbRefeicao = new javax.swing.JTable();

        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jtfRefeicao.setName("jtfRefeicao"); // NOI18N

        jlb1Refeicao.setText("* Refeicao");
        jlb1Refeicao.setName("jlb1Refeicao"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlb1Refeicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfRefeicao, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Refeicao))
                .addContainerGap(333, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(200, 150));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 50));

        jtfRefeicaoPesq.setName("jtfRefeicaoPesq"); // NOI18N

        jLabel2.setText("Refeicao");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfRefeicaoPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(155, 155, 155))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jtbRefeicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Refeição"
            }
        ));
        jtbRefeicao.setName("jtbRefeicao"); // NOI18N
        jtbRefeicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbRefeicaoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbRefeicao);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jtbRefeicaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbRefeicaoMousePressed
    if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
            if (super.getTipoVisualizacao() == 0) {
                LimparFormulario(jpnCadastro);
                ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbRefeicao.getSelectedRow())));
                super.ComportamentoSelecionar();
            } else {
                if (telaCardapio != null) {
                    telaCardapio.SetarCamposRefeicao(RetornaId(jtbRefeicao.getSelectedRow()),((Object[])ListaRefeicao.get(jtbRefeicao.getSelectedRow()))[1].toString());
                } else if (telaOrdemProducao != null) {
                    telaOrdemProducao.SetarCamposRefeicao(RetornaId(jtbRefeicao.getSelectedRow()),((Object[])ListaRefeicao.get(jtbRefeicao.getSelectedRow()))[1].toString());      
                }
                super.FechaFrameInterno();
            }
        }    
}//GEN-LAST:event_jtbRefeicaoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb1Refeicao;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbRefeicao;
    private javax.swing.JTextField jtfRefeicao;
    private javax.swing.JTextField jtfRefeicaoPesq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
            setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        ArrayList<String> ListaParametros = new ArrayList<String>();
        if (!(jtfRefeicaoPesq.getText().equals(""))){
            ListaParametros.add("descricao");
            ListaParametros.add(jtfRefeicaoPesq.getText());
        }
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Object[])ListaRefeicao.get(Linha))[0].toString());
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();        
        Lista.add(jtfRefeicao.getText());
        return Lista;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfRefeicao.setText(Objeto.get(1).toString());
    }



}
