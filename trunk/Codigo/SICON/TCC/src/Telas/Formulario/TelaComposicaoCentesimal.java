/*
 * TelaComposicaoCentesimal.java
 *
 * Created on 19 de Agosto de 2008, 22:17
 */

package Telas.Formulario;

import Controller.ControllerComposicaoCentesimal;
import Telas.Componentes.TelaInterna;
import Telas.Tabelas.JTableComposicaoCentesimal;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author  Jonathan
 */
public class TelaComposicaoCentesimal extends TelaAncestral implements InterfacePadraoAcessoOutrasTelas{

    private TelaProduto telaProduto;
    private TelaInterna telaInterna;
    private JDesktopPane telaPrincipal;
    private Integer IdProduto;
    private ControllerComposicaoCentesimal Controller;
    private Vector ListaComposicao;

    /** Creates new form BeanForm */
    public TelaComposicaoCentesimal() {
        initComponents();
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);      
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);          
        super.setTitulo("Composição Centesimal");
        Controller = new ControllerComposicaoCentesimal();
    }    
    
     /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
            if (super.getLocalizacao() == 0) {
                if (Controller.EventoExcluir()) {
                    Excluiu = true;
                } 
            } else if (Controller.EventoExcluir()) { 
                Excluiu = true;
            }
            if (Excluiu) {
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
        return Gravar();
    }  
    
    private boolean Gravar(){
        boolean Gravou = false;
        if (super.VerificaCampos(jpnCadastro,1)) {                                
            if (Controller.EventoAlterar(TelaParaController())) {                    
                JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));             
                Gravou = true;
            } else
                JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));     
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png")); 
        return Gravou;        
    } 

    @Override
    protected void ComportamentoNovo() {
        LimparFormulario(jpnCadastro);  
        IdProduto = 0;
    }

    @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = new ArrayList();
        ListaParametros = setParametros();
        ListaComposicao = (Vector) Controller.EventoPesquisar(ListaParametros);
        if (!(ListaComposicao.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbComposicao.setModel(new JTableComposicaoCentesimal(ListaComposicao)); 
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
        jtfEnergia = new javax.swing.JTextField();
        jlb1Energia = new javax.swing.JLabel();
        jbtProduto = new javax.swing.JButton();
        jlb1Carboidrato = new javax.swing.JLabel();
        jtfCarboidrato = new javax.swing.JTextField();
        jlb1Proteina = new javax.swing.JLabel();
        jtfProteina = new javax.swing.JTextField();
        jlb1Lipideos = new javax.swing.JLabel();
        jtfLipideos = new javax.swing.JTextField();
        jlb1Calcio = new javax.swing.JLabel();
        jtfCalcio = new javax.swing.JTextField();
        jlb1Ferro = new javax.swing.JLabel();
        jtfFerro = new javax.swing.JTextField();
        jlb1VitaminaC = new javax.swing.JLabel();
        jtfVitaminaC = new javax.swing.JTextField();
        jlb1Produto = new javax.swing.JLabel();
        jtfProduto = new javax.swing.JTextField();
        edDescProduto = new javax.swing.JTextField();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtfProteinaPesq = new javax.swing.JTextField();
        jtfFerroPesq = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtfProdutoPesq = new javax.swing.JTextField();
        jbtProduto1 = new javax.swing.JButton();
        jtfEnergiaPesq = new javax.swing.JTextField();
        jtfVitaminaCPesq = new javax.swing.JTextField();
        jtfLipideosPesq = new javax.swing.JTextField();
        jtfCarboidratoPesq = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfCalcioPesq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbComposicao = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jtfEnergia.setColumns(6);
        jtfEnergia.setName("jtfEnergia"); // NOI18N

        jlb1Energia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Energia.setText("* Energia(Kcal)"); // NOI18N
        jlb1Energia.setName("jlb1Energia"); // NOI18N

        jbtProduto.setText("jButton1"); // NOI18N
        jbtProduto.setName("jbtProduto"); // NOI18N
        jbtProduto.setPreferredSize(new java.awt.Dimension(73, 19));
        jbtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtProdutoMousePressed(evt);
            }
        });

        jlb1Carboidrato.setText("* Carboidrato(g)"); // NOI18N
        jlb1Carboidrato.setName("jlb1Carboidrato"); // NOI18N

        jtfCarboidrato.setColumns(6);
        jtfCarboidrato.setName("jtfCarboidrato"); // NOI18N

        jlb1Proteina.setText("* Proteina(g)"); // NOI18N
        jlb1Proteina.setName("jlb1Proteina"); // NOI18N

        jtfProteina.setColumns(6);
        jtfProteina.setName("jtfProteina"); // NOI18N

        jlb1Lipideos.setText("* Lipídeos(g)"); // NOI18N
        jlb1Lipideos.setName("jlb1Lipideos"); // NOI18N

        jtfLipideos.setColumns(6);
        jtfLipideos.setName("jtfLipideos"); // NOI18N

        jlb1Calcio.setText("* Calcio(mg)"); // NOI18N
        jlb1Calcio.setName("jlb1Calcio"); // NOI18N

        jtfCalcio.setColumns(6);
        jtfCalcio.setName("jtfCalcio"); // NOI18N

        jlb1Ferro.setText("* Ferro(mg)"); // NOI18N
        jlb1Ferro.setName("jlb1Ferro"); // NOI18N

        jtfFerro.setColumns(6);
        jtfFerro.setName("jtfFerro"); // NOI18N

        jlb1VitaminaC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1VitaminaC.setText("* Vitamina C(mg)"); // NOI18N
        jlb1VitaminaC.setName("jlb1VitaminaC"); // NOI18N

        jtfVitaminaC.setColumns(6);
        jtfVitaminaC.setName("jtfVitaminaC"); // NOI18N

        jlb1Produto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Produto.setText("* Produto"); // NOI18N
        jlb1Produto.setName("jlb1Produto"); // NOI18N

        jtfProduto.setColumns(6);
        jtfProduto.setName("jtfProduto"); // NOI18N

        edDescProduto.setBackground(new java.awt.Color(204, 204, 204));
        edDescProduto.setFont(new java.awt.Font("Arial", 1, 11));
        edDescProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescProduto.setEnabled(false);
        edDescProduto.setName("edDescProduto"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jlb1Produto))
                    .addComponent(jlb1Proteina, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb1Calcio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb1Energia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jlb1VitaminaC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfVitaminaC, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jtfCalcio, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jtfProteina, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jtfEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlb1Carboidrato)
                            .addComponent(jlb1Ferro)
                            .addComponent(jlb1Lipideos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCarboidrato, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jtfLipideos, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jtfFerro, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edDescProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)))
                .addGap(86, 86, 86))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb1Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtfEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCarboidrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtfProteina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb1Lipideos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLipideos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlb1Ferro, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(jtfFerro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jtfCalcio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb1VitaminaC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfVitaminaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jlb1Proteina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jlb1Energia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jlb1Carboidrato, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jlb1Calcio)
                        .addGap(22, 22, 22)))
                .addGap(49, 49, 49))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 200));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 110));

        jLabel9.setText("Energia(Kcal)"); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Carboidrato(g)"); // NOI18N

        jLabel12.setText("Proteina(g)"); // NOI18N

        jLabel13.setText("Lipídeos(g)"); // NOI18N

        jLabel15.setText("Ferro(mg)"); // NOI18N

        jLabel16.setText("Vitamina C(mg)"); // NOI18N

        jLabel17.setText("Produto"); // NOI18N

        jtfProteinaPesq.setColumns(6);
        jtfProteinaPesq.setName("jtfProteinaPesq"); // NOI18N

        jtfFerroPesq.setColumns(6);
        jtfFerroPesq.setName("jtfFerroPesq"); // NOI18N

        jtfProdutoPesq.setColumns(6);
        jtfProdutoPesq.setName("jtfProdutoPesq"); // NOI18N

        jbtProduto1.setText("jButton1"); // NOI18N
        jbtProduto1.setName("jbtProduto"); // NOI18N
        jbtProduto1.setPreferredSize(new java.awt.Dimension(73, 19));

        jtfEnergiaPesq.setColumns(6);
        jtfEnergiaPesq.setName("jtfEnergiaPesq"); // NOI18N

        jtfVitaminaCPesq.setColumns(6);
        jtfVitaminaCPesq.setName("jtfVitaminaCPesq"); // NOI18N

        jtfLipideosPesq.setColumns(6);
        jtfLipideosPesq.setName("jtfLipideosPesq"); // NOI18N

        jtfCarboidratoPesq.setColumns(6);
        jtfCarboidratoPesq.setName("jtfCarboidratoPesq"); // NOI18N

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Calcio(mg)"); // NOI18N

        jtfCalcioPesq.setColumns(6);
        jtfCalcioPesq.setName("jtfCalcioPesq"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfProteinaPesq))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfFerroPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfVitaminaCPesq)
                    .addComponent(jtfLipideosPesq)
                    .addComponent(jtfEnergiaPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel18)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCalcioPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jtfCarboidratoPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addGap(417, 417, 417))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfCarboidratoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfEnergiaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfProteinaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfCalcioPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfLipideosPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfFerroPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfVitaminaCPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        jpnPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jtbComposicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Produto", "Energia", "Carboidrato", "Proteína", "Lipídeos", "Calcio", "Ferro", "Vitamina C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbComposicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbComposicaoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbComposicao);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jbtProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoMousePressed
    InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoMousePressed

private void jtbComposicaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbComposicaoMousePressed
    if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            Selecionar(RetornaId(jtbComposicao.getSelectedRow()));
        } else {
            /*int Posicao = jtbProduto.getSelectedRow();           
            this.telaComposicaoCentesimal.setCamposProduto(Integer.parseInt(((Vector)ListaProduto.get(Posicao)).get(0).toString()), ((Vector)ListaProduto.get(Posicao)).get(1).toString(), ((Vector)ListaProduto.get(Posicao)).get(2).toString());
            super.FechaFrameInterno();    */        
          }
    }    
}//GEN-LAST:event_jtbComposicaoMousePressed

    public void Selecionar(int id){
        ControllerParaTela(Controller.EventoSelecionar(id));
        super.ComportamentoSelecionar();    
    }
    
private void InstaciaTelaProduto(){
    telaProduto = new TelaProduto(); 
    telaProduto.setTipoVisualizacao(1); 
    telaProduto.setarComposicao(this);
    super.CriarTelaInterna(telaProduto);
}

public void setCamposProduto(Integer Produto, String CodigoProduto, String DescProduto) {
    this.IdProduto = Produto;
    jtfProduto.setText(CodigoProduto);
    edDescProduto.setText(DescProduto);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edDescProduto;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JButton jbtProduto1;
    private javax.swing.JLabel jlb1Calcio;
    private javax.swing.JLabel jlb1Carboidrato;
    private javax.swing.JLabel jlb1Energia;
    private javax.swing.JLabel jlb1Ferro;
    private javax.swing.JLabel jlb1Lipideos;
    private javax.swing.JLabel jlb1Produto;
    private javax.swing.JLabel jlb1Proteina;
    private javax.swing.JLabel jlb1VitaminaC;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbComposicao;
    private javax.swing.JTextField jtfCalcio;
    private javax.swing.JTextField jtfCalcioPesq;
    private javax.swing.JTextField jtfCarboidrato;
    private javax.swing.JTextField jtfCarboidratoPesq;
    private javax.swing.JTextField jtfEnergia;
    private javax.swing.JTextField jtfEnergiaPesq;
    private javax.swing.JTextField jtfFerro;
    private javax.swing.JTextField jtfFerroPesq;
    private javax.swing.JTextField jtfLipideos;
    private javax.swing.JTextField jtfLipideosPesq;
    private javax.swing.JTextField jtfProduto;
    private javax.swing.JTextField jtfProdutoPesq;
    private javax.swing.JTextField jtfProteina;
    private javax.swing.JTextField jtfProteinaPesq;
    private javax.swing.JTextField jtfVitaminaC;
    private javax.swing.JTextField jtfVitaminaCPesq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
        setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        ArrayList ListaParametros = new ArrayList();
        if (!(jtfProdutoPesq.getText().equals(""))){
            ListaParametros.add("produto");
            ListaParametros.add(jtfProdutoPesq.getText());
        } 
        if (!(jtfEnergiaPesq.getText().equals(""))) {
            ListaParametros.add("energia");
            ListaParametros.add(jtfEnergiaPesq.getText().replace(",", "."));
        }
        if (!(jtfCarboidratoPesq.getText().equals(""))){
            ListaParametros.add("carboidrato");
            ListaParametros.add(jtfCarboidratoPesq.getText().replace(",", "."));
        }
        if (!(jtfProteinaPesq.getText().equals(""))){
            ListaParametros.add("proteina");
            ListaParametros.add(jtfProteinaPesq.getText().replace(",", "."));
        }
        if (!(jtfLipideosPesq.getText().equals(""))){
            ListaParametros.add("lipideos");
            ListaParametros.add(jtfLipideosPesq.getText().replace(",", "."));
        }
        if (!(jtfCalcioPesq.getText().equals(""))){
            ListaParametros.add("calcio");
            ListaParametros.add(jtfCalcioPesq.getText().replace(",", "."));
        }
        if (!(jtfFerroPesq.getText().equals(""))){
            ListaParametros.add("ferro");
            ListaParametros.add(jtfFerroPesq.getText().replace(",", "."));
        }
        if (!(jtfVitaminaCPesq.getText().equals(""))){
            ListaParametros.add("vitaminac");
            ListaParametros.add(jtfVitaminaCPesq.getText().replace(",", "."));
        }
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Vector)ListaComposicao.get(Linha)).get(0).toString());
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(IdProduto);
        Lista.add(jtfEnergia.getText());
        Lista.add(jtfCarboidrato.getText());
        Lista.add(jtfProteina.getText());
        Lista.add(jtfLipideos.getText());
        Lista.add(jtfCalcio.getText());
        Lista.add(jtfFerro.getText());
        Lista.add(jtfVitaminaC.getText());
        return Lista;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfProduto.setText(Objeto.get(0).toString());
        edDescProduto.setText(Objeto.get(1).toString());
        jtfEnergia.setText(String.valueOf(Objeto.get(2)));
        jtfCarboidrato.setText(String.valueOf(Objeto.get(3)));
        jtfProteina.setText(String.valueOf(Objeto.get(4)));
        jtfLipideos.setText(String.valueOf(Objeto.get(5)));
        jtfCalcio.setText(String.valueOf(Objeto.get(6)));
        jtfFerro.setText(String.valueOf(Objeto.get(7)));
        jtfVitaminaC.setText(String.valueOf(Objeto.get(8)));
    }



    @Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CarregarTela(TelaInterna Frame) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
