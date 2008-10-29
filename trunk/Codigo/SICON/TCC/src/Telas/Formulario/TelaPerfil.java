/*
 * TelaPerfil.java
 *
 * Created on 3 de Agosto de 2008, 00:32
 */

package Telas.Formulario;

import Classes.botao;
import Classes.mensagens;
import Classes.perfil;
import Classes.perfiltela;
import Classes.tela;
import Telas.Componentes.TelaInterna;
import Telas.Tabelas.JTableCargo;
import Telas.Tabelas.JTablePerfil;
import Telas.Tabelas.JTablePerfilTela;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

/**
 *
 * @author  Jonathan
 */
public class TelaPerfil extends TelaAncestral implements InterfacePadraoAcessoOutrasTelas{
    
    private perfil Perfil;
    private TelaUsuario telaUsuario;
    private tela Tela;
    private mensagens Mensagens;
    private ArrayList<Object> ListaPerfil;
    private ArrayList<perfiltela> ListaAcesso;
    private TelaCadastroTela TelaCadastro;
    private perfiltela Acesso;
    private botao Botao;
    //usado para retorno de valor p outra tela
    private JDesktopPane TelaPrincipal;
    private int id;
    private TelaInterna telaInterna;

    /** Creates new form BeanForm */
    public TelaPerfil() {
        initComponents();     
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        Tela = new tela();
        ListaAcesso = new ArrayList<perfiltela>();
        ListaPerfil = new ArrayList<Object>();
        Perfil = new perfil();
        Mensagens = new mensagens();
        Acesso = new perfiltela();
        Botao = new botao();
        super.setTitulo("Perfil");
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);     
    }    
    
    @Override
    public void setDesktopPane(JDesktopPane Pane){
        this.TelaPrincipal = Pane;
    }
    
    public void setTelaUsuario(TelaUsuario tlUsuario) {
        this.telaUsuario = tlUsuario;
    }
    
    
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (Perfil.Excluir()) {
            Excluiu = true;
            JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(5));
        } else {
            JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(6));
        }
        return Excluiu;
    }

    @Override
    protected boolean ComportamentoSalvar() {
        boolean Gravou = false;
        if (super.VerificaCampos(jpnCadastro,1)) {
            if (super.Operacao == 0) { 
                Perfil.LimparClasse();
                TelaParaClasse();
                if (Perfil.Gravar(Operacao)) {
                    Gravou = true;
                    JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(2));
                } else
                    JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(3));
            } else if (super.Operacao == 1) {
                TelaParaClasse();
                if (Perfil.Gravar(Operacao)) {
                    Gravou = true;
                    JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(4));
                } else
                    JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(3));                    
                }
           } else JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(1));
        return Gravou;
        }   

    @Override
    protected void ComportamentoNovo() {
        LimparFormulario(jpnCadastro);
        Perfil.LimparClasse();
        ListaAcesso.clear();
        jtbPerfilTela.setModel(new JTablePerfilTela(ListaAcesso));
    }

    @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = null;
        ListaParametros = setParametros();
        ListaPerfil.clear();
        ListaPerfil = Perfil.Pesquisar(ListaParametros);
        if (!(ListaPerfil.isEmpty())) {
             Achou = true;  
        }
        jtbPerfil.setModel(new JTablePerfil(ListaPerfil));  
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
                setComponenteTable(false);
            }
        };
    }
    

    private void setComponenteTable(boolean b) {
        jtbPerfil.setEnabled(b);
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
        jPanel3 = new javax.swing.JPanel();
        jtfDescricaoPesq = new javax.swing.JTextField();
        jlbDescricao2 = new javax.swing.JLabel();
        jcbAdministradorPesq = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPerfil = new javax.swing.JTable();
        jpnCadastro = new javax.swing.JPanel();
        jtfDescricao = new javax.swing.JTextField();
        jlb1Descricao = new javax.swing.JLabel();
        jcbAdministrador = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlb2Tela = new javax.swing.JLabel();
        jtfTela = new javax.swing.JTextField();
        jbtTela = new javax.swing.JButton();
        jpnBotoes = new javax.swing.JPanel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbPerfilTela = new javax.swing.JTable();
        jbtExcluirAcesso = new javax.swing.JButton();
        jbtAdicionar = new javax.swing.JButton();
        jbtTela1 = new javax.swing.JButton();
        edDescTela = new javax.swing.JTextField();

        jpnTela.setBackground(new java.awt.Color(102, 153, 0));
        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnPesquisa.setBackground(new java.awt.Color(0, 255, 255));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(243, 243, 243));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 400));

        jlbDescricao2.setText("* Descrição");

        jcbAdministradorPesq.setBackground(new java.awt.Color(243, 243, 243));
        jcbAdministradorPesq.setText("Administrador");
        jcbAdministradorPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdministradorPesqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jlbDescricao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbAdministradorPesq)
                    .addComponent(jtfDescricaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDescricao2)
                    .addComponent(jtfDescricaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbAdministradorPesq)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jtbPerfil.setBackground(new java.awt.Color(243, 243, 243));
        jtbPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Perfil", "Administrador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtbPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbPerfilMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPerfil);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));

        jtfDescricao.setName("jtfDescricao"); // NOI18N

        jlb1Descricao.setText("* Descrição");
        jlb1Descricao.setName("jlb1Descricao"); // NOI18N

        jcbAdministrador.setBackground(new java.awt.Color(243, 243, 243));
        jcbAdministrador.setText("Administrador");
        jcbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdministradorActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(610, 2));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel3.setText("Acessos");
        jLabel3.setName("jlbAcessoOutro"); // NOI18N

        jlb2Tela.setText("* Tela");
        jlb2Tela.setName("jlb2Tela"); // NOI18N

        jtfTela.setName("jtfTela"); // NOI18N
        jtfTela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfTelaFocusLost(evt);
            }
        });

        jbtTela.setText("jButton1");
        jbtTela.setName("jbtTela"); // NOI18N
        jbtTela.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtTela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtTelaMousePressed(evt);
            }
        });

        jpnBotoes.setBackground(new java.awt.Color(243, 243, 243));
        jpnBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpnBotoes.setName("jpnBotoes"); // NOI18N

        jCheckBox8.setBackground(new java.awt.Color(243, 243, 243));
        jCheckBox8.setText("Selecionar Todos");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jtbPerfilTela.setBackground(new java.awt.Color(243, 243, 243));
        jtbPerfilTela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tela", "Botão"
            }
        ));
        jScrollPane2.setViewportView(jtbPerfilTela);

        jbtExcluirAcesso.setText("Excluir");
        jbtExcluirAcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtExcluirAcessoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtExcluirAcessoMousePressed(evt);
            }
        });

        jbtAdicionar.setText("Adicionar");
        jbtAdicionar.setName("jbtAdicionar"); // NOI18N
        jbtAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarMousePressed(evt);
            }
        });
        jbtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAdicionarActionPerformed(evt);
            }
        });

        jbtTela1.setText("jButton1");
        jbtTela1.setName("jbtTela"); // NOI18N
        jbtTela1.setPreferredSize(new java.awt.Dimension(73, 21));
        jbtTela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtTela1MousePressed(evt);
            }
        });

        edDescTela.setBackground(new java.awt.Color(204, 204, 204));
        edDescTela.setEditable(false);
        edDescTela.setFont(new java.awt.Font("Arial", 1, 11));
        edDescTela.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescTela.setName("edDescTela"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(732, Short.MAX_VALUE))
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jlb2Tela))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jlb1Descricao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtExcluirAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtAdicionar))
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jtfTela, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jbtTela, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edDescTela, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                            .addComponent(jpnBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbAdministrador)
                                    .addComponent(jtfDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox8)
                        .addGap(155, 155, 155))))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb1Descricao)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbAdministrador)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb2Tela, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edDescTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8)
                    .addComponent(jpnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jbtAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtExcluirAcesso))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jcbAdministradorPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdministradorPesqActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbAdministradorPesqActionPerformed

private void jbtExcluirAcessoMousePressed(java.awt.event.ActionEvent evt) {                                                     
        
}
private void jtbPerfilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPerfilMousePressed
if ((evt.getClickCount()==1) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            LimparFormulario(jpnCadastro);
            Perfil.LerClasse(RetornaId(jtbPerfil.getSelectedRow()));
            super.Operacao = 1;
            super.setLocalizacao(1);
            setComportamento(2); 
            setComportamentoPanel(2);
            ClasseParaTela();
        } else {
            Perfil.LerClasse(RetornaId(jtbPerfil.getSelectedRow()));
            telaUsuario.SetarCamposPerfil(Perfil.getIdperfil().toString(), Perfil.getNome());
            telaUsuario.HabilitaForm();            
            super.FechaFrameInterno();
          }
    }
}//GEN-LAST:event_jtbPerfilMousePressed

private void jcbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdministradorActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbAdministradorActionPerformed

private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jCheckBox8ActionPerformed

private void jbtTelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtTelaMousePressed
    /*TelaCadastro = new TelaCadastroTela();
    TelaCadastro.setTipoVisualizacao(1);
    JInternalFrame TelaInterna = new JInternalFrame();
    //TelaInterna = super.CarregarTelaInterna("Tela");
    CarregarTela(TelaInterna);
    //super.BloqueiaTela();
        try {
            TelaInterna.setSelected(true);
            //telaAuxiliar = new TelaAuxiliar(telaCargo, jtfPesqDescricao2);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }  */
 TelaCadastro = new TelaCadastroTela(this);
    TelaCadastro.setTipoVisualizacao(1);
    EscreverMetodosAbstratosTelasInternas();
    super.CarregarTelaInterna(telaInterna, "Tela", null);      
    CarregarTela(telaInterna);
    //super.BloqueiaTela();
        try {
            telaInterna.setSelected(true);
            //telaAuxiliar = new TelaAuxiliar(telaCargo, jtfPesqDescricao2);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
}//GEN-LAST:event_jbtTelaMousePressed

private void AoSairCampoTela() {
    if (!(jtfTela.getText().trim().equals(""))) {
        Tela.LerClasse(Integer.parseInt(jtfTela.getText())); 
        edDescTela.setText(Tela.getTitulotela());    
        ExcluirCheckBox();
        CarregaCheckBoxBotoes(Tela);
    }
}

private void jtfTelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTelaFocusLost
    AoSairCampoTela();

}//GEN-LAST:event_jtfTelaFocusLost

private void jbtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAdicionarActionPerformed
  
}//GEN-LAST:event_jbtAdicionarActionPerformed

private void jbtAdicionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarMousePressed
    if (VerificaCampos(jpnCadastro, 2)) {
        ArrayList<perfiltela> ListaAcessoInterno = new ArrayList<perfiltela>();
        ArrayList<botao> ListaBotao = new ArrayList<botao>();
        tela Tel = new tela();
        Tel.LerClasse(Tela.getIdtela());
        ListaBotao = CarregaBotoesSelecionados();
        int cont = 0;
        while (ListaBotao.size() > cont){
             perfiltela aces = new perfiltela();
             if (Perfil.getIdperfil() != null) {
                 aces.setIdperfil(Perfil);
             }
             aces.setIdtela(Tel);
             aces.setbotao(ListaBotao.get(cont));
             //ListaAcessoInterno.add(aces);
             ListaAcesso.add(aces);
             cont = cont + 1;
        }   
        jtbPerfilTela.setModel(new JTablePerfilTela(ListaAcesso));
    } else {
        JOptionPane.showMessageDialog(null, Mensagens.RetornaMensagem(1));         
    }
        
    
}//GEN-LAST:event_jbtAdicionarMousePressed

private void jbtTela1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtTela1MousePressed
// TODO add your handling code here:
}//GEN-LAST:event_jbtTela1MousePressed

private void jbtExcluirAcessoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirAcessoMouseExited
// TODO add your handling code here:
}//GEN-LAST:event_jbtExcluirAcessoMouseExited

private void jbtExcluirAcessoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirAcessoMousePressed
    RemoverListaAcesso(jtbPerfilTela.getSelectedRow());
    jtbPerfilTela.setModel(new JTablePerfilTela(ListaAcesso));
}//GEN-LAST:event_jbtExcluirAcessoMousePressed

public void RemoverListaAcesso(int linha){
    /*int
    while () */
    int cont = 0;
    int Tela = ((perfiltela)ListaAcesso.get(linha)).getIdtela().getIdtela();
    while (ListaAcesso.size() > cont) {        
        if (((perfiltela)ListaAcesso.get(cont)).getIdtela().getIdtela().equals(Tela)) {
            ListaAcesso.remove(cont);
            if (cont != 0) {
                cont--;
            }
        } else cont++;
    }
    
   /* for (Iterator<perfiltela> it = ListaAcesso.iterator(); it.hasNext();){
        perfiltela pt = it.next();        
        if (pt.getIdtela().getIdtela().equals(Tela)) {
            ListaAcesso.remove(pt);
        }
    }*/
    
}

private ArrayList<botao> CarregaBotoesSelecionados(){
    ArrayList<botao> ListaBotoes = new ArrayList<botao>();
    int cont = 0;
    while (jpnBotoes.getComponentCount() > cont) {
        if (jpnBotoes.getComponent(cont) instanceof JCheckBox) {
            if (((JCheckBox)jpnBotoes.getComponent(cont)).isSelected()){
                for (Iterator<botao> it = Tela.getbotaoCollection().iterator(); it.hasNext();) {
                    botao object = it.next();
                    if (object.getTitulobotao().equals(((JCheckBox)jpnBotoes.getComponent(cont)).getText())){
                        ListaBotoes.add(object);
                    }
                }
            }
        }
        cont = cont + 1;
    }
    return ListaBotoes;    
}

private void CarregaCheckBoxBotoes(tela Tela) {
    int cont = 0;
    for (Iterator<botao> it = Tela.getbotaoCollection().iterator(); it.hasNext();) {
        botao Botao = new botao();
        Botao = it.next();    
        CriarCheckBox(Botao, cont);
        cont =+ 1;
    }
    jpnBotoes.repaint();
    jpnBotoes.revalidate();
}

private void CriarCheckBox(botao Botao, int Numero) {
    JCheckBox check = new JCheckBox();
    check.setName("Check" + String.valueOf(Numero));
    check.setText(Botao.getTitulobotao());
    check.setToolTipText(Botao.getDescricaobotao());
    jpnBotoes.add(check);
    check.setVisible(true);
}

private void ExcluirCheckBox() {
    int cont = 0;
    //int Total = 
    while (jpnBotoes.getComponentCount() > cont) {
        jpnBotoes.remove(cont);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edDescTela;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtAdicionar;
    private javax.swing.JButton jbtExcluirAcesso;
    private javax.swing.JButton jbtTela;
    private javax.swing.JButton jbtTela1;
    private javax.swing.JCheckBox jcbAdministrador;
    private javax.swing.JCheckBox jcbAdministradorPesq;
    private javax.swing.JLabel jlb1Descricao;
    private javax.swing.JLabel jlb2Tela;
    private javax.swing.JLabel jlbDescricao2;
    private javax.swing.JPanel jpnBotoes;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbPerfil;
    private javax.swing.JTable jtbPerfilTela;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfDescricaoPesq;
    private javax.swing.JTextField jtfTela;
    // End of variables declaration//GEN-END:variables
    

    
    
    @Override
    public ArrayList<String> setParametros() {
        ArrayList<String> ListaParametros = new ArrayList<String>();
        if (!(jtfDescricaoPesq.getText().trim().isEmpty())) {
            ListaParametros.add("nome");
            ListaParametros.add(jtfDescricaoPesq.getText().toString());
        }
        return ListaParametros;   
    }

    public void TelaParaClasse() {
        Perfil.setNome(jtfDescricao.getText());
        if (jcbAdministrador.isSelected() == true) {
          Perfil.setAdministrador(true);
        } else Perfil.setAdministrador(false);
        Perfil.setPerfiltelaCollection(null);
        Perfil.setPerfiltelaCollection(ListaAcesso);
    }

    public void ClasseParaTela() {
        jtfDescricao.setText(Perfil.getNome());
        jcbAdministrador.setSelected(Perfil.getAdministrador());
        SetArraySelecionar();
        jtbPerfilTela.setModel(new JTablePerfilTela(ListaAcesso));
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Vector)ListaPerfil.get(Linha)).get(2).toString()); 
    }

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
        super.setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public void SetArraySelecionar() {
     ListaAcesso.clear();
     for (Iterator<perfiltela> it = Perfil.getPerfiltelaCollection().iterator(); it.hasNext();) {
        perfiltela object = it.next();
        ListaAcesso.add(object);
     }
    }
    
    public void SetarCamposVindoDaTelaCadastroTela(int id, String Descricao) {
        jtfTela.setText(String.valueOf(id));
        edDescTela.setText(Descricao);
        AoSairCampoTela();
    }


    @Override
    public ArrayList<Object> TelaParaController() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CarregarTela(TelaInterna Frame) {
        TelaCadastro.setVisible(true);
        TelaCadastro.setJTextRetorno(jtfTela);
        //TelaCadastro.setFrameInterno(Frame);
        Frame.add(TelaCadastro);
        TelaCadastro.setFrameInterno(Frame);         
        TelaPrincipal.add(Frame);
        Frame.setVisible(true);   
    }

}
