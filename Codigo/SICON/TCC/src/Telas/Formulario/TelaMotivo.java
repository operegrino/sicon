/*
 * TelaMotivo.java
 *
 * Created on 20 de Agosto de 2008, 17:18
 */

package Telas.Formulario;

import Controller.ControllerMotivo;
import Telas.Tabelas.JTableMotivo;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  jonathan
 */
public class TelaMotivo extends TelaAncestral implements InterfacePadraoTela{

    private ControllerMotivo Controller;
    private List ListaMotivo;
    private String idMotivo;
    private TelaAvaliacaoPedido TelaAvaliacao;
    /** Creates new form BeanForm */
    public TelaMotivo() {
        super();
        initComponents();      
        IniciarTela();
    }
    
    public void setAvaliacaoPedido(TelaAvaliacaoPedido tela) {
        this.TelaAvaliacao = tela;
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Motivo");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);  
        ListaMotivo = new ArrayList();
        Controller = new ControllerMotivo();
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
        ListaMotivo = Controller.EventoPesquisar(ListaParametros);
        if (!(ListaMotivo.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbMotivo.setModel(new JTableMotivo(ListaMotivo)); 
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
        jlb1Nome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jcbBaixar = new javax.swing.JCheckBox();
        jpnPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMotivo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jlbNome = new javax.swing.JLabel();
        jtfNomePesq = new javax.swing.JTextField();
        jcbBaixarPesq = new javax.swing.JCheckBox();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jlb1Nome.setText("* Descrição");
        jlb1Nome.setName("jlb1Nome"); // NOI18N

        jtfNome.setName("jtfNome"); // NOI18N

        jcbBaixar.setBackground(new java.awt.Color(243, 243, 243));
        jcbBaixar.setText("Baixar");
        jcbBaixar.setName("jcbBaixar"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jlb1Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jcbBaixar)
                        .addContainerGap())
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                        .addGap(81, 81, 81))))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbBaixar)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 170));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jtbMotivo.setBackground(new java.awt.Color(243, 243, 243));
        jtbMotivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Motivo", "Baixar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbMotivo.setName("jtbMotivo"); // NOI18N
        jtbMotivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbMotivoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbMotivo);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 80));

        jlbNome.setText("Descrição");
        jlbNome.setName("jlbNome"); // NOI18N

        jtfNomePesq.setName("jtfNomePesq"); // NOI18N

        jcbBaixarPesq.setBackground(new java.awt.Color(243, 243, 243));
        jcbBaixarPesq.setText("Baixar");
        jcbBaixarPesq.setName("jcbBaixarPesq"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbBaixarPesq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNomePesq, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomePesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbBaixarPesq)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jtbMotivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMotivoMousePressed
    if ((evt.getClickCount()==1) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbMotivo.getSelectedRow())));
            super.Operacao = 1;
            super.setLocalizacao(1);
            setComportamento(2);     
            super.setComportamentoPanel(2);
        } else {
            idMotivo = String.valueOf(RetornaId(jtbMotivo.getSelectedRow()));
            TelaAvaliacao.getCellColuna().setidBotao(idMotivo, (String)((Object[])ListaMotivo.get(jtbMotivo.getSelectedRow()))[1]);
            super.FechaFrameInterno();
            super.FrameInterno.dispose();
        }
    }    
}//GEN-LAST:event_jtbMotivoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbBaixar;
    private javax.swing.JCheckBox jcbBaixarPesq;
    private javax.swing.JLabel jlb1Nome;
    private javax.swing.JLabel jlbNome;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbMotivo;
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
        ListaParametros.add("baixar");
        if (!(jcbBaixarPesq.isSelected())) {
            ListaParametros.add("1");
        } else ListaParametros.add("0");        
        return ListaParametros;        
    }

    @Override
    public int RetornaId(int Linha) {
        return (Integer)((Object[])ListaMotivo.get(Linha))[0];
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(jtfNome.getText());
        if (jcbBaixar.isSelected()) {
            Lista.add("0");
        } else Lista.add("1");
        return Lista;        
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfNome.setText(Objeto.get(0).toString());
        if (Objeto.get(1).equals("0")) {
            jcbBaixar.setSelected(true);
        } else jcbBaixar.setSelected(false);
    }



}
