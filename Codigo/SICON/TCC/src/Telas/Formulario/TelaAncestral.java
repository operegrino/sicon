/*
 * TelaAncestral.java
 *
 * Created on 11 de Julho de 2008, 19:58
 */

package Telas.Formulario;

import Classes.Funcoes;
import Classes.mensagens;
import Telas.Componentes.TelaInterna;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author  Jonathan
 */
public class TelaAncestral extends javax.swing.JPanel {
    
    protected JTextField jtfRetorno;
    //indica se o usuario está¡ na tela de pesquisa ou na tela de cadastro
    protected int Localizacao;    
    //se é alteração ou se é inserção
    protected int Operacao;
    //Panels da tela
    protected JPanel jpnPesquisa, jpnCadastro, jpnTela;
    //se está sendo aberto atraves do menu ou atraves de um botão para retornar um valor;
    public int TipoVisualizacao;
    protected Funcoes funcoes;
    protected TelaInterna FrameInterno;
    
    //Controle de Acesso dos botões
    private boolean HabilitaVoltar;
    private boolean HabilitaNovo;
    private boolean HabilitaExcluir;
    private boolean HabilitaPesquisar;
    private boolean HabilitaSalvar;

    /** Creates new form TelaAncestral */
    public TelaAncestral() {
        initComponents();
        TipoVisualizacao = 0;
        funcoes = new Funcoes();
    }
    
    public void setHabilitaVoltar(boolean acesso){
        this.HabilitaVoltar = acesso;
    }
    
    public int getLocalizacao() {
        return this.Localizacao;
    }
    
    public void setLocalizacao(int Local) {
        this.Localizacao = Local;
    }
    
    public void DesabilitaBotoesAncestral(){
        this.HabilitaNovo = false;
        this.btNovo.setEnabled(false);        
        this.HabilitaVoltar = false;
        this.btVoltar.setEnabled(false);
        this.HabilitaSalvar = false;
        this.btSalvar.setEnabled(false);
        this.HabilitaPesquisar = false;
        this.btPesquisar.setEnabled(false);
        this.HabilitaExcluir = false;
        this.btExcluir.setEnabled(false);
    }
    
    public void HabilitaBotoesAncestral(){
        this.HabilitaNovo = true;
        this.btNovo.setEnabled(true);        
        this.HabilitaVoltar = true;
        this.btVoltar.setEnabled(true);
        this.HabilitaSalvar = true;
        this.btSalvar.setEnabled(true);
        this.HabilitaPesquisar = true;
        this.btPesquisar.setEnabled(true);
        this.HabilitaExcluir = true;
        this.btExcluir.setEnabled(true);
    }    
    
    public void setHabilitaNovo(boolean acesso){
        this.HabilitaNovo = acesso;
    }
    
    public void setHabilitaExcluir(boolean acesso){
        this.HabilitaExcluir = acesso;
    }
    
    public void setHabilitaPesquisar(boolean acesso){
        this.HabilitaPesquisar = acesso;
    }
    
    public void setHabilitaSalvar(boolean acesso){
        this.HabilitaSalvar = acesso;
    }
    
    public void setPanelFilha(JPanel pnPesquisa, JPanel pnCadastro, JPanel pnTela){
        jpnPesquisa = pnPesquisa;
        jpnCadastro = pnCadastro;
        jpnTela = pnTela;
    }
    /* 
     *  Objetivo     : Setar qual é a operação vigente. 0 = inserção, 1 = alteração;
     *  
     *  Data Criação : 16/07/08 
     */
    private void setOperacao(int Ope) {
        this.Operacao = Ope;
    }
    
    public void setFrameInterno(TelaInterna Frame){
        this.FrameInterno = Frame;
    }
    
    protected void FechaFrameInterno(){
        this.FrameInterno.dispose();
    }
    
    public void setJTextRetorno(JTextField Retorno){
        this.jtfRetorno = Retorno;
    }
    
    public void setTipoVisualizacao(int Tipo) {
        TipoVisualizacao = Tipo;
    }
    
    public int getTipoVisualizacao() {
        return TipoVisualizacao;
    }
    
    protected void setTitulo(String Titulo) {
        jlbTitulo.setText(Titulo);
    }    
    public Container getPanelAncestralCriado() {
        return jpnAncestral;
    }
    
    protected void CarregarTelaInterna(TelaInterna interna, String titulo){
        interna.setTitle(titulo);
        interna.setResizable(true);
        interna.setClosable(true);
        interna.setMaximizable(false);
        interna.setIconifiable(false);
        interna.setSize(700,600);
        interna.setLocation(Funcoes.CentralizarFrame(interna.getSize()));
        //return jifTela;
    }
    
       /* 
        * Objetivo     : Indicar quais botões serão habilitados e qual aba será
        *                Habilitada;
        * Data Criação : 08/07/08 
        */  
        public void setComportamento(int Comportamento) {        
        switch (Comportamento) {
            // botão pesquisar/voltar/excluir pressionado
             case  0: { 
                if (HabilitaVoltar) { 
                   btVoltar.setEnabled(false);
                }
                if (HabilitaNovo) { 
                    btNovo.setEnabled(true);
                }
                if (HabilitaSalvar) { 
                    btSalvar.setEnabled(false);
                }
                if (HabilitaExcluir) { 
                    btExcluir.setEnabled(true);
                }
                if (HabilitaPesquisar) { 
                    btPesquisar.setEnabled(true);
                }
                break;
            } 
            // botão novo pressionado
            case  1: { 
                if (HabilitaVoltar) { 
                    btVoltar.setEnabled(true);
                }
                if (HabilitaNovo) { 
                    btNovo.setEnabled(false);
                }
                if (HabilitaSalvar) { 
                    btSalvar.setEnabled(true);
                }
                if (HabilitaExcluir) { 
                    btExcluir.setEnabled(false);
                }
                if (HabilitaPesquisar) { 
                    btPesquisar.setEnabled(false);
                }
                break;
            }   
            // botão salvar/selecionar(duplo clique na jtable) pressionado
            case  2: { 
                if (HabilitaVoltar) { 
                    btVoltar.setEnabled(true);
                }
                if (HabilitaNovo) { 
                    btNovo.setEnabled(true);
                }
                if (HabilitaSalvar) { 
                    btSalvar.setEnabled(true);
                }
                if (HabilitaExcluir) { 
                    btExcluir.setEnabled(true);
                }
                if (HabilitaPesquisar) { 
                    btPesquisar.setEnabled(false);
                }
                break;
            }   
            //Comportamento inicial da tela;
            case 3: {
                if (HabilitaVoltar) { 
                    btVoltar.setEnabled(false);
                }
                if (HabilitaNovo) { 
                    btNovo.setEnabled(true);
                }
                if (HabilitaSalvar) { 
                    btSalvar.setEnabled(false);
                }
                if (HabilitaExcluir) { 
                    btExcluir.setEnabled(false);
                }
                if (HabilitaPesquisar) { 
                    btPesquisar.setEnabled(true);
                }
                break;                
            }
            case 4 : {
                //Todos os botÃµes desabilitados
                if (HabilitaVoltar) { 
                    btVoltar.setEnabled(false);
                }
                if (HabilitaNovo) { 
                    btNovo.setEnabled(false);
                }
                if (HabilitaSalvar) { 
                    btSalvar.setEnabled(false);
                }
                if (HabilitaExcluir) { 
                    btExcluir.setEnabled(false);
                }
                if (HabilitaPesquisar) { 
                    btPesquisar.setEnabled(false);
                }
                break;                  
            }            
        }
    }
        
public void DesabilitaForm() {
        setComportamento(4);
        int Cont = 0;
        switch (this.Localizacao) {
            case 0 : {
                int ContPanel = 0;
                while (jpnPesquisa.getComponentCount() > ContPanel) {                    
                    if (jpnPesquisa.getComponent(ContPanel) instanceof JPanel ) {
                        while (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponentCount() > Cont) {
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JTextField) {
                                ((JTextField)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(false);                        
                            } else
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JTextArea) {
                                ((JTextArea)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(false);                        
                            } else
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JComboBox) {
                                ((JComboBox)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(false);
                            } 
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JButton) {
                                ((JButton)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(false);
                            }
                        Cont++;    
                        }
                    ContPanel = jpnPesquisa.getComponentCount();
                    }
                ContPanel++;
                }  
            break;           
            } 
            case 1 : {
                while (jpnCadastro.getComponentCount() > Cont) {
                    if (jpnCadastro.getComponent(Cont) instanceof JTextField) {
                        ((JTextField)jpnCadastro.getComponent(Cont)).setEnabled(false);                        
                    } else
                    if (jpnCadastro.getComponent(Cont) instanceof JTextArea) {
                        ((JTextArea)jpnCadastro.getComponent(Cont)).setEnabled(false);                        
                    } else
                    if (jpnCadastro.getComponent(Cont) instanceof JComboBox) {
                        ((JComboBox)jpnCadastro.getComponent(Cont)).setEnabled(false);
                    } 
                    Cont++;
                }                
            }
        }
    }

    public void HabilitaForm() {
        int Cont = 0;
        switch (this.Localizacao) {
            case 0 : {
                int ContPanel = 0;
                while (jpnPesquisa.getComponentCount() > ContPanel) {                    
                    if (jpnPesquisa.getComponent(ContPanel) instanceof JPanel ) {
                        while (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponentCount() > Cont) {
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JTextField) {
                                ((JTextField)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(true);                        
                            } else
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JTextArea) {
                                ((JTextArea)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(true);                        
                            } else
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JComboBox) {
                                ((JComboBox)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(true);
                            } 
                            if (((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont) instanceof JButton) {
                                ((JButton)((JPanel)jpnPesquisa.getComponent(ContPanel)).getComponent(Cont)).setEnabled(true);
                            }
                        Cont++;    
                        }
                    ContPanel = jpnPesquisa.getComponentCount();
                    }
                ContPanel++;
                }  
            setComportamento(3);
            break;           
            } 
            case 1 : {
                while (jpnCadastro.getComponentCount() > Cont) {
                    if (jpnCadastro.getComponent(Cont) instanceof JTextField) {
                        ((JTextField)jpnCadastro.getComponent(Cont)).setEnabled(true);                        
                    } else
                    if (jpnCadastro.getComponent(Cont) instanceof JTextArea) {
                        ((JTextArea)jpnCadastro.getComponent(Cont)).setEnabled(true);                        
                    } else
                    if (jpnCadastro.getComponent(Cont) instanceof JComboBox) {
                        ((JComboBox)jpnCadastro.getComponent(Cont)).setEnabled(true);
                    } 
                    Cont++;
                } 
             if (this.Operacao == 0) {
                 setComportamento(1);
             } else setComportamento(2);
            }
        }        
    }
        
        
    protected void setComportamentoPanel(int Operacao) {
        if (Operacao == 0) {
            this.jpnTela.remove(jpnPesquisa);
            this.jpnTela.remove(jpnCadastro);
        } else 
        if (Operacao == 1) {
            this.jpnTela.add(jpnPesquisa, java.awt.BorderLayout.CENTER);
            this.jpnTela.remove(jpnCadastro);    
        } else
        if (Operacao == 2) {
            this.jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);            
            this.jpnTela.remove(jpnPesquisa);
        }        
        jpnTela.revalidate();
        jpnTela.repaint();        
    }
        
   /* 
    * Objetivo     : Verificar se os campos obrigatórios foram preenchidos.
    *                Está validação é feita atraves da JLabel, se tiver * e o nome
    *                for o mesmo nome do COmponente então verifica.
    *                Valida Componentes : JTextField, JTextarea.
    * Data Criação : 08/07/08 
    */  
    protected boolean VerificaCampos(JPanel jpnDados, int Identificacao) {
        boolean LimpouTudo = true;
        int contLabel = 0;
        int contDados = 0;
        int IdentificadorCampo = 0;
        String NomeLabel = "";
        String NomeComponente = "";
        while (jpnDados.getComponentCount() > contLabel) {
            if (jpnDados.getComponent(contLabel) instanceof JLabel) {
                if (((JLabel)jpnDados.getComponent(contLabel)).getText().contains("*")) {
                    NomeLabel = ((JLabel)jpnDados.getComponent(contLabel)).getName().toString().trim();
                    IdentificadorCampo = Integer.parseInt(NomeLabel.substring(3,4));
                    if (Identificacao == IdentificadorCampo) {                 
                        while (jpnDados.getComponentCount() > contDados) {
                            //JTextField
                            if (jpnDados.getComponent(contDados) instanceof JTextField) {
                                NomeComponente = ((JTextField)jpnDados.getComponent(contDados)).getName().toString();
                                if (NomeLabel.substring(4, NomeLabel.length()).equals(
                                    NomeComponente.substring(3, NomeComponente.length()))) {
                                    if (((JTextField)jpnDados.getComponent(contDados)).getText().trim().equals("")) {
                                        LimpouTudo = false;
                                        DestacaComponenteVazio(((JLabel)jpnDados.getComponent(contLabel)));
                                    } else NormalizaComponenteVazio(((JLabel)jpnDados.getComponent(contLabel)));
                                }
                            }
                            //JTextArea
                            if (jpnDados.getComponent(contDados) instanceof JTextArea) {
                                NomeComponente = ((JTextArea)jpnDados.getComponent(contDados)).getName().toString();
                                if (NomeLabel.substring(3, NomeLabel.length()).equals(
                                    NomeComponente.substring(3, NomeComponente.length()))) {
                                    if (((JTextField)jpnDados.getComponent(contDados)).getText().trim().equals("")) {
                                        LimpouTudo = false;
                                        DestacaComponenteVazio(((JLabel)jpnDados.getComponent(contLabel)));
                                    } else NormalizaComponenteVazio(((JLabel)jpnDados.getComponent(contLabel)));
                                }
                            }
                            contDados +=1;
                    }    
                  }
                }
            }
            contDados = 0;
            contLabel +=1;
        }
        return LimpouTudo;
    }
   /* 
    * Objetivo     : Destacar a cor da Jlabel que representa o campo que não foi
    *                preenchido.                
    * Data Criação : 08/07/08 
    */      
    protected void DestacaComponenteVazio(JLabel jlbMudar) {
        jlbMudar.setForeground(Color.RED);        
    } 
    
    protected void NormalizaComponenteVazio(JLabel jlbNormalizar){
       jlbNormalizar.setForeground(Color.BLACK);
    }
    
   /* 
    * Objetivo     : Limpar os dados do formulario
    *                Limpa Componentes : JTextField, JTextArea;
    * Data Criação : 08/07/08 
    */      
    protected void LimparFormulario(JPanel jpnDados) {
        int cont = 0;
        while (jpnDados.getComponentCount() > cont) {
            if (jpnDados.getComponent(cont) instanceof JTextField) {
                ((JTextField)jpnDados.getComponent(cont)).setText("");
            } else if (jpnDados.getComponent(cont) instanceof JScrollPane) {
                    for (Component obj: ((JScrollPane)jpnDados.getComponent(cont)).getComponents()) {
                        if (obj instanceof JTextArea) {
                            ((JTextArea)obj).setText("");
                        }
                    }                   
                } else if ((jpnDados.getComponent(cont) instanceof JCheckBox)) {
                    ((JCheckBox)jpnDados.getComponent(cont)).setSelected(false);
                }          
            cont +=1;   
            }
        }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnAncestral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tbAncestral = new javax.swing.JToolBar();
        btVoltar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        jlbTitulo = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jpnAncestral.setBackground(new java.awt.Color(243, 243, 243));
        jpnAncestral.setLayout(new java.awt.BorderLayout());
        add(jpnAncestral, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tbAncestral.setBackground(new java.awt.Color(243, 243, 243));
        tbAncestral.setFloatable(false);
        tbAncestral.setRollover(true);

        btVoltar.setBackground(new java.awt.Color(243, 243, 243));
        btVoltar.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\voltar.png"));
        btVoltar.setText("Voltar"); // NOI18N
        btVoltar.setFocusable(false);
        btVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        tbAncestral.add(btVoltar);

        btNovo.setBackground(new java.awt.Color(243, 243, 243));
        btNovo.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\novo.png"));
        btNovo.setText("Novo"); // NOI18N
        btNovo.setFocusable(false);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        tbAncestral.add(btNovo);

        btSalvar.setBackground(new java.awt.Color(243, 243, 243));
        btSalvar.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\save.png"));
        btSalvar.setText("Salvar"); // NOI18N
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        tbAncestral.add(btSalvar);

        btExcluir.setBackground(new java.awt.Color(243, 243, 243));
        btExcluir.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));
        btExcluir.setText("Excluir"); // NOI18N
        btExcluir.setFocusable(false);
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        tbAncestral.add(btExcluir);

        btPesquisar.setBackground(new java.awt.Color(243, 243, 243));
        btPesquisar.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));
        btPesquisar.setText("Pesquisar"); // NOI18N
        btPesquisar.setFocusable(false);
        btPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        tbAncestral.add(btPesquisar);
        tbAncestral.add(jSeparator2);

        jPanel1.add(tbAncestral, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(243, 243, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 30));

        jlbTitulo.setFont(new java.awt.Font("Arial", 1, 14));
        jlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitulo.setText("Titulo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
   setComportamento(0);
   setComportamentoPanel(1);
   this.Localizacao = 0;
}//GEN-LAST:event_btVoltarActionPerformed

private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
    setComportamento(1);
    setComportamentoPanel(2);
    ComportamentoNovo();
    setOperacao(0);
    this.Localizacao = 1;    
}//GEN-LAST:event_btNovoActionPerformed

    protected void ComportamentoNovo(){        
        //Sobreescrever na classe filha;
    }
private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    if (ComportamentoSalvar()) {
        setComportamento(2);   
        setOperacao(1);
        this.Localizacao = 1;            
    }
}//GEN-LAST:event_btSalvarActionPerformed

    protected boolean ComportamentoSalvar() {
        return true;    
    }
private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
    if (ComportamentoPesquisar()) {
        setComportamento(0);
    } else setComportamento(3);   
    this.Localizacao = 0;    
}//GEN-LAST:event_btPesquisarActionPerformed

    protected boolean ComportamentoPesquisar() {
        //Sobreescrever na classe filha;
        return true;
    }
private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
    if (ComportamentoExcluir()) {
        setComportamento(0);    
        setComportamentoPanel(1);
        setOperacao(0);
        this.Localizacao = 0;  
    }
}//GEN-LAST:event_btExcluirActionPerformed
     
     protected boolean ComportamentoExcluir() {
        //Sobreescrever na classe filha;
         return false;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btExcluir;
    public javax.swing.JButton btNovo;
    public javax.swing.JButton btPesquisar;
    public javax.swing.JButton btSalvar;
    public javax.swing.JButton btVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpnAncestral;
    public javax.swing.JToolBar tbAncestral;
    // End of variables declaration//GEN-END:variables

}
