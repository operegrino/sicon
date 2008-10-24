/*
 * TelaUsuario.java
 *
 * Created on 16 de Julho de 2008, 15:53
 */

package Telas.Formulario;

import Classes.mensagens;
import Classes.usuario;
import Telas.Tabelas.JTableCargo;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import Classes.Funcoes;
import Classes.cargo;
import Classes.perfil;
import Controller.ControllerUsuario;
import Telas.Componentes.TelaInterna;
import Telas.Tabelas.JTableUsuario;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;


/**
 *
 * @author  Jonathan
 */
public class TelaUsuario extends TelaAncestral implements InterfacePadraoAcessoOutrasTelas, InterfacePadraoAcessoOutrasTelasPesquisa{
    
    //private TelaAuxiliar telaAuxiliar;
    private TelaCargo telaCargo;
    private mensagens Mensagens;    
    private List ListaUsuario;
    public JDesktopPane TelaPrincipal;
    private TelaPerfil telaPerfil;
    private TelaInterna telaInterna;
    //TelaCargo telaCargo;
    
    private ControllerUsuario Controller;

    /** Creates new form BeanForm */
    public TelaUsuario() {
        initComponents();     
    }
    
    @Override
    public void IniciarTela() {
        super.setTitulo("Usuário");
        Controller = new ControllerUsuario();
        setPanelTela(jpnPesquisa, jpnCadastro, jpnTelas);
        setComportamentoPanel(0);
        setComportamentoPanel(1);  
        super.setComportamento(3);   
    }    
    
    public void SetarCamposPerfil(String Id, String Descricao){
        if (super.getLocalizacao() == 0) {
            jtfPerfilPesq.setText(String.valueOf(Id));
        } else {
            jtfPerfil.setText(String.valueOf(Id));
            edPerfilDesc.setText(Descricao);            
        }
    }
    
    public void SetarCamposCargo(String Id, String Descricao){
        if (Localizacao == 0) {
            jtfCargoPesq.setText(String.valueOf(Id));
        } else {
            jtfCargo.setText(String.valueOf(Id));
            edCargoDesc.setText(Descricao);
        }
    }
    
    /** Creates new form BeanForm */
    @Override
    public void setDesktopPane(JDesktopPane Pane){
        TelaPrincipal = Pane;
    }
    
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (Controller.EventoExcluir()) {
            JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(5));
            Excluiu = true;
        } else {
            JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(6));
        }
        return Excluiu;
    }

    @Override
    protected boolean ComportamentoSalvar() {
        boolean Gravou = false;
        if (super.VerificaCampos(jpnCadastro,1)) {
            if (super.Operacao == 0) {                                 
                if (Controller.EventoSalvar(TelaParaController())) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2));
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3));
            } else if (super.Operacao == 1) {
                if (Controller.EventoAlterar(TelaParaController())) {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(4));
                    Gravou = true;
                } else
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3));                    
                }
            } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1));
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
        ListaUsuario = Controller.EventoPesquisar2(ListaParametros);
        if (!(ListaUsuario.isEmpty())){
            Achou = true;
        }
        jtbUsuario.setModel(new JTableUsuario(ListaUsuario)); 
        return Achou;
    }

    @Override
    public ArrayList<String> setParametros() {        
        ArrayList<String> ListaParametros = new ArrayList<String>();        
        if (!(jtfUsuarioPesq.getText().trim().isEmpty())) {
            ListaParametros.add("nomeusuario");
            ListaParametros.add(jtfUsuarioPesq.getText().toString());
        }
        if (!(jtfPerfilPesq.getText().trim().isEmpty())) {
            ListaParametros.add("perfil");
            ListaParametros.add(jtfUsuarioPesq.getText().toString());            
        }
        if (!(jtfCargoPesq.getText().trim().isEmpty())) {
            ListaParametros.add("cargo");
            ListaParametros.add(jtfUsuarioPesq.getText().toString());            
        }
        if (!(jtfLoginPesq.getText().trim().isEmpty())) {
            ListaParametros.add("login");
            ListaParametros.add(jtfUsuarioPesq.getText().toString());            
        }
        
        
        return ListaParametros;            
    }
    
  public void CarregarTelaPerfil(TelaInterna Frame){
    telaPerfil.setVisible(true);
    //telaPerfil.setJTextRetorno(jtfPerfil);
    telaPerfil.setTelaUsuario(this);
    telaPerfil.setFrameInterno(Frame);
    Frame.add(telaPerfil);
    TelaPrincipal.add(Frame);
    Frame.setVisible(true);     
}    
    
    
    /*@Override
    public void TelaParaClasse() {
        Usuario.setNomeusuario(jtfUsuario.getText());
        Usuario.Perfil.LerClasse(Integer.parseInt(jtfPerfil.getText()));
        Usuario.Cargo.LerClasse(Integer.parseInt(jtfCargo.getText()));
        Usuario.setLogin(jtfLogin.getText());
        Usuario.setSenha(Funcoes.CharToString(jpfSenha.getPassword()));
    }
    
    @Override
    public void ClasseParaTela() {
        jtfUsuario.setText(Usuario.getNomeusuario());
        jtfPerfil.setText(String.valueOf(Usuario.Perfil.getIdperfil()));
        edPerfilDesc.setText(Usuario.Perfil.getNome());
        jtfCargo.setText(String.valueOf(Usuario.Cargo.getIdcargo()));        
        edCargoDesc.setText(Usuario.Cargo.getDescricao());
        jtfLogin.setText(Usuario.getLogin());
        jpfSenha.setText(Usuario.getSenha());
    }*/

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnTelas = new javax.swing.JPanel();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfUsuarioPesq = new javax.swing.JTextField();
        jlbDescricao4 = new javax.swing.JLabel();
        jlbDescricao5 = new javax.swing.JLabel();
        jlbDescricao8 = new javax.swing.JLabel();
        jtfLoginPesq = new javax.swing.JTextField();
        jtfPerfilPesq = new javax.swing.JTextField();
        jbtPerfilPesq = new javax.swing.JButton();
        jtfCargoPesq = new javax.swing.JTextField();
        jbtCargoPesq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbUsuario = new javax.swing.JTable();
        jpnCadastro = new javax.swing.JPanel();
        jlb1Usuario = new javax.swing.JLabel();
        edCargoDesc = new javax.swing.JTextField();
        jlb1Perfil = new javax.swing.JLabel();
        jtfPerfil = new javax.swing.JTextField();
        jbtPerfil = new javax.swing.JButton();
        jlb1Cargo = new javax.swing.JLabel();
        jtfCargo = new javax.swing.JTextField();
        jbtCargo = new javax.swing.JButton();
        jlb1Login = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jlb1Senha = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        edPerfilDesc = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();

        jpnTelas.setName("jpnTelas"); // NOI18N
        jpnTelas.setLayout(new java.awt.BorderLayout());

        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 100));

        jLabel1.setText("Usuario");

        jtfUsuarioPesq.setName("jtfUsuario"); // NOI18N

        jlbDescricao4.setText("Perfil(+)");
        jlbDescricao4.setName("jlbUsuario"); // NOI18N

        jlbDescricao5.setText("Cargo(+)");
        jlbDescricao5.setName("jlbUsuario"); // NOI18N

        jlbDescricao8.setText("Login");
        jlbDescricao8.setName("jlbUsuario"); // NOI18N

        jtfLoginPesq.setName("jtfUsuario"); // NOI18N

        jtfPerfilPesq.setName("jtfPerfilPesq"); // NOI18N
        jtfPerfilPesq.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPerfilPesqFocusLost(evt);
            }
        });

        jbtPerfilPesq.setText("jButton1");
        jbtPerfilPesq.setName("jbtPerfilPesq"); // NOI18N
        jbtPerfilPesq.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtPerfilPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtPerfilPesqMousePressed(evt);
            }
        });

        jtfCargoPesq.setName("jtfTela"); // NOI18N
        jtfCargoPesq.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCargoPesqFocusLost(evt);
            }
        });

        jbtCargoPesq.setText("jButton1");
        jbtCargoPesq.setName("jbtCargoPesq"); // NOI18N
        jbtCargoPesq.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtCargoPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtCargoPesqMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbDescricao4)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUsuarioPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtfPerfilPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jbtPerfilPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbDescricao5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCargoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jbtCargoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbDescricao8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfLoginPesq)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUsuarioPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbDescricao4)
                        .addComponent(jbtPerfilPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfPerfilPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbDescricao5)
                        .addComponent(jbtCargoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfCargoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbDescricao8))
                    .addComponent(jtfLoginPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jtbUsuario.setBackground(new java.awt.Color(243, 243, 243));
        jtbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Cargo", "Perfil", "Login"
            }
        ));
        jtbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbUsuarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbUsuario);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTelas.add(jpnPesquisa, java.awt.BorderLayout.CENTER);

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlb1Usuario.setText("* Usuário");
        jlb1Usuario.setName("jlb1Usuario"); // NOI18N
        jpnCadastro.add(jlb1Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        edCargoDesc.setBackground(new java.awt.Color(204, 204, 204));
        edCargoDesc.setFont(new java.awt.Font("Arial", 1, 11));
        edCargoDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edCargoDesc.setName("edCargoDesc"); // NOI18N
        jpnCadastro.add(edCargoDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 420, -1));

        jlb1Perfil.setText("* Perfil");
        jlb1Perfil.setName("jlb1Perfil"); // NOI18N
        jpnCadastro.add(jlb1Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jtfPerfil.setName("jtfPerfil"); // NOI18N
        jtfPerfil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPerfilFocusLost(evt);
            }
        });
        jpnCadastro.add(jtfPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 80, -1));

        jbtPerfil.setText("jButton1");
        jbtPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtPerfilMousePressed(evt);
            }
        });
        jpnCadastro.add(jbtPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 20, 20));

        jlb1Cargo.setText("* Cargo");
        jlb1Cargo.setName("jlb1Cargo"); // NOI18N
        jpnCadastro.add(jlb1Cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jtfCargo.setName("jtfUsuario"); // NOI18N
        jtfCargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCargoFocusLost(evt);
            }
        });
        jpnCadastro.add(jtfCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 80, -1));

        jbtCargo.setText("...");
        jbtCargo.setName("jbtCargo"); // NOI18N
        jbtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCargoActionPerformed(evt);
            }
        });
        jpnCadastro.add(jbtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 20, 20));

        jlb1Login.setText("* Login");
        jlb1Login.setName("jlb1Login"); // NOI18N
        jpnCadastro.add(jlb1Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jtfLogin.setName("jtfUsuario"); // NOI18N
        jpnCadastro.add(jtfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 180, -1));

        jlb1Senha.setText("* Senha");
        jlb1Senha.setName("jlb1Senha"); // NOI18N
        jpnCadastro.add(jlb1Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jtfUsuario.setName("jtfUsuario"); // NOI18N
        jpnCadastro.add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 530, -1));

        edPerfilDesc.setBackground(new java.awt.Color(204, 204, 204));
        edPerfilDesc.setEditable(false);
        edPerfilDesc.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        edPerfilDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edPerfilDesc.setName("edPerfilDesc"); // NOI18N
        jpnCadastro.add(edPerfilDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 420, -1));

        jpfSenha.setText("jPasswordField1");
        jpfSenha.setName("jpfSenha"); // NOI18N
        jpnCadastro.add(jpfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 180, -1));

        jpnTelas.add(jpnCadastro, java.awt.BorderLayout.PAGE_END);

        getPanelAncestralCriado().add(jpnTelas, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jbtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCargoActionPerformed
    InstanciaCargo();
}//GEN-LAST:event_jbtCargoActionPerformed

private void jbtPerfilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtPerfilMousePressed
    InstaciaTelaPerfil();
}//GEN-LAST:event_jbtPerfilMousePressed


private void EscreverMetodosAbstratosTelasInternas(){
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

private void InstaciaTelaPerfil(){
    telaPerfil = new TelaPerfil(); 
    telaPerfil.setTipoVisualizacao(1); 
    EscreverMetodosAbstratosTelasInternas();
    super.CarregarTelaInterna(telaInterna, "Perfil");        
    CarregarTelaPerfil(telaInterna);
        try {
            telaInterna.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
            setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public int RetornaId(int Linha) {
        return ((Integer)((Vector)ListaUsuario.get(Linha)).get(4));   
    }

private void FecharInternalFrame(javax.swing.event.InternalFrameEvent evt) {
    this.HabilitaForm();    
} 

private void jtfPerfilPesqFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPerfilPesqFocusLost

}//GEN-LAST:event_jtfPerfilPesqFocusLost

private void jbtPerfilPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtPerfilPesqMousePressed
    InstaciaTelaPerfil();      

}//GEN-LAST:event_jbtPerfilPesqMousePressed

private void jtfCargoPesqFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCargoPesqFocusLost
// TODO add your handling code here:
}//GEN-LAST:event_jtfCargoPesqFocusLost

private void jbtCargoPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCargoPesqMousePressed
    InstanciaCargo();            
}//GEN-LAST:event_jbtCargoPesqMousePressed

    public void InstanciaCargo(){
        telaCargo = new TelaCargo(); 
        telaCargo.setTipoVisualizacao(1); 
        EscreverMetodosAbstratosTelasInternas();
        super.CarregarTelaInterna(telaInterna, "Cargo");        
        CarregarTela(telaInterna);
            try {
                telaInterna.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }
private void jtbUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbUsuarioMousePressed
if ((evt.getClickCount()==1) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            LimparFormulario(jpnCadastro);
            ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbUsuario.getSelectedRow())));
            super.Operacao = 1;
            setComportamento(2); 
            setComportamentoPanel(2);
            super.setLocalizacao(1);
        }
    }
}//GEN-LAST:event_jtbUsuarioMousePressed

private void jtfPerfilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPerfilFocusLost
    if (!(jtfPerfil.getText().isEmpty())){
        edPerfilDesc.setText(Controller.RetornaDescricaoPerfil(Integer.parseInt(jtfPerfil.getText())));
    }
}//GEN-LAST:event_jtfPerfilFocusLost

private void jtfCargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCargoFocusLost
    String Descricao;
    if (!(jtfCargo.getText().isEmpty())){    
        Descricao = Controller.RetornaDescricaoCargo(Integer.parseInt(jtfCargo.getText()));
        if (Descricao != null) {
            edCargoDesc.setText(Controller.RetornaDescricaoCargo(Integer.parseInt(jtfCargo.getText())));
        } else { 
            JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(8));
            edCargoDesc.setText("");
            jtfCargo.setText("");
        }
    }
}//GEN-LAST:event_jtfCargoFocusLost

    @Override
public void CarregarTela(TelaInterna Frame){
    telaCargo.setVisible(true);
    //telaCargo.setJTextRetorno(jtfCargo);    
    telaCargo.SetTelaUsuario(this);
    telaCargo.setFrameInterno(Frame);
    Frame.add(telaCargo);
    TelaPrincipal.add(Frame);
    Frame.setVisible(true);     
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edCargoDesc;
    private javax.swing.JTextField edPerfilDesc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCargo;
    private javax.swing.JButton jbtCargoPesq;
    private javax.swing.JButton jbtPerfil;
    private javax.swing.JButton jbtPerfilPesq;
    private javax.swing.JLabel jlb1Cargo;
    private javax.swing.JLabel jlb1Login;
    private javax.swing.JLabel jlb1Perfil;
    private javax.swing.JLabel jlb1Senha;
    private javax.swing.JLabel jlb1Usuario;
    private javax.swing.JLabel jlbDescricao4;
    private javax.swing.JLabel jlbDescricao5;
    private javax.swing.JLabel jlbDescricao8;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTelas;
    private javax.swing.JTable jtbUsuario;
    private javax.swing.JTextField jtfCargo;
    private javax.swing.JTextField jtfCargoPesq;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfLoginPesq;
    private javax.swing.JTextField jtfPerfil;
    private javax.swing.JTextField jtfPerfilPesq;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JTextField jtfUsuarioPesq;
    // End of variables declaration//GEN-END:variables



    @Override
    public void setComponenteTable(boolean Acesso) {
        jtbUsuario.setEnabled(Acesso);
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList ListaUsuarioTela = new ArrayList();
        //primeiro campo para o id;
        ListaUsuarioTela.add(jtfUsuario.getText());        
        ListaUsuarioTela.add(jtfPerfil.getText());
        ListaUsuarioTela.add(jtfCargo.getText());
        ListaUsuarioTela.add(jtfLogin.getText());
        ListaUsuarioTela.add(Funcoes.CharToString(jpfSenha.getPassword())); 
        return ListaUsuarioTela;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfUsuario.setText((String)Objeto.get(0));
        jtfPerfil.setText(String.valueOf(((Integer)Objeto.get(1))));
        jtfCargo.setText(String.valueOf(((Integer)Objeto.get(2))));
        jtfLogin.setText((String)Objeto.get(3));
        jpfSenha.setText((String)Objeto.get(4));
    }

}
