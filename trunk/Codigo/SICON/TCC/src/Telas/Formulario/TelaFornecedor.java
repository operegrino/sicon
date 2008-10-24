/*
 * TelaFornecedor.java
 *
 * Created on 14 de Setembro de 2008, 23:42
 */

package Telas.Formulario;

import Controller.ControllerFornecedor;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
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
public class TelaFornecedor extends TelaAncestral implements InterfacePadraoTelaVarias{
    private TelaContatoFornecedor telaContatoFornecedor;
    private TelaPagamentoFornecedor telaPagamentoFornecedor;
    private TelaFornecedorProduto telaFornecedorProduto;
    private List ListaFornecedor;
    private ControllerFornecedor Controller;
    private JDesktopPane TelaPrincipal;

    /** Creates new form BeanForm */
    public TelaFornecedor() {
        initComponents();
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Fornecedor");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);   
        ListaFornecedor = new ArrayList();
        Controller = new ControllerFornecedor();
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
        ListaFornecedor = Controller.EventoPesquisar(ListaParametros);
        if (!(ListaFornecedor.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        //jtbFornecedor.setModel(new JTableFornecedor(ListaFornecedor)); 
        return Achou;
    }    
    
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
        telaContatoFornecedor.setVisible(true);
        //telaContatoFornecedor.setJTextRetorno(jtfTela);
        //telaContatoFornecedor.setFrameInterno(Frame);
        Frame.add(telaContatoFornecedor);
        TelaPrincipal.add(Frame);
        Frame.setVisible(true);    
    
    }
    
    private void CarregarTelaFornecedor(JInternalFrame TelaInterna) {
        telaPagamentoFornecedor.setVisible(true);
        //telaContatoFornecedor.setJTextRetorno(jtfTela);
        //telaPagamentoFornecedor.setFrameInterno(TelaInterna);
        TelaInterna.add(telaPagamentoFornecedor);
        TelaPrincipal.add(TelaInterna);
        TelaInterna.setVisible(true);  
    }

   private void CarregarTelaProduto(JInternalFrame TelaInterna) {
        telaFornecedorProduto.setVisible(true);
        //telaContatoFornecedor.setJTextRetorno(jtfTela);
        //telaFornecedorProduto.setFrameInterno(TelaInterna);
        TelaInterna.add(telaFornecedorProduto);
        TelaPrincipal.add(TelaInterna);
        TelaInterna.setVisible(true);  
    }
    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
        setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        ArrayList Lista = new ArrayList();
        Lista.add(jtfCodigo.getText());
        Lista.add(jtfRazaoSocial.getText());
        Lista.add(jtfCnpj.getText());
        Lista.add(jtfInscricaoEstadual.getText());
        Lista.add(jtfccm.getText());
        Lista.add(jtfCgc.getText());
        Lista.add(jtfRua.getText());
        Lista.add(jtfNumero.getText());
        Lista.add(jtfBairro.getText());
        Lista.add(jtfCidade.getText());
        Lista.add(jtfCep.getText());
        Lista.add(jtfSite.getText());
        Lista.add(jtfTempoEntrega.getText());
        ArrayList ListaBanco = new ArrayList();
        ListaBanco.add(jtfBanco.getText());
        ListaBanco.add(jtfAgencia.getText());
        ListaBanco.add(jtfContaCorrente.getText());
        ListaBanco.add(jtfContaCorrenteDigito.getText());
        Lista.add(ListaBanco);
        return Lista;
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | idFornecedor
     *    1      | codigo 
     *    2      | razaosocial
     *    3      | cnpj
     *    4      | inscriçãoestadual
     *    5      | ccm
     *    6      | cgc
     *    7      | rua
     *    8      | numero
     *    9      | bairro
     *   10      | cidade
     *   11      | cep
     *   12      | site
     *   13      | tempoentrega
     *   14      | dadosbancarios(ArrayList) --- 0 = banco(id) | 
     *                                           1 = Agencia| 2 = contacorrente | 3 =  COntaCorrenteDigito
     **************************************************************************/        

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        jlb1Codigo = new javax.swing.JLabel();
        jlb1razaoSocial = new javax.swing.JLabel();
        jlb1Cgc = new javax.swing.JLabel();
        jlb1InscricaoEstadual = new javax.swing.JLabel();
        jlb1Cep = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfNumero = new javax.swing.JTextField();
        jtfRazaoSocial = new javax.swing.JTextField();
        jtfCgc = new javax.swing.JTextField();
        jlb1Rua = new javax.swing.JLabel();
        jlb1Numero = new javax.swing.JLabel();
        jlb1Cidade = new javax.swing.JLabel();
        jlb1Ccm = new javax.swing.JLabel();
        jlb1Site = new javax.swing.JLabel();
        jtfInscricaoEstadual = new javax.swing.JTextField();
        jlb1Bairro = new javax.swing.JLabel();
        jtfCidade = new javax.swing.JTextField();
        jtfCep = new javax.swing.JTextField();
        jtfSite = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jpnDIvisao = new javax.swing.JPanel();
        jlbDescBanco = new javax.swing.JLabel();
        jlb1Cnpj = new javax.swing.JLabel();
        jtfCnpj = new javax.swing.JTextField();
        jlb1Banco = new javax.swing.JLabel();
        jtfBanco = new javax.swing.JTextField();
        jlb1Agencia = new javax.swing.JLabel();
        jtfAgencia = new javax.swing.JTextField();
        jtfTempoEntrega = new javax.swing.JTextField();
        jlb1TempoEntrega = new javax.swing.JLabel();
        jtfContaCorrente = new javax.swing.JTextField();
        jlb1ContaCorrente = new javax.swing.JLabel();
        jpnBotoes = new javax.swing.JPanel();
        btContatos = new javax.swing.JButton();
        jbtPagamento = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jtfRua = new javax.swing.JTextField();
        jtfccm = new javax.swing.JTextField();
        jtfContaCorrenteDigito = new javax.swing.JTextField();
        edPerfilDesc = new javax.swing.JTextField();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField23 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbFornecedor = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jlb1Codigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Codigo.setText("* Código"); // NOI18N
        jlb1Codigo.setName("jlb1Codigo"); // NOI18N

        jlb1razaoSocial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1razaoSocial.setText("* Razão Social"); // NOI18N
        jlb1razaoSocial.setName("jlb1razaoSocial"); // NOI18N

        jlb1Cgc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Cgc.setText("CGC"); // NOI18N
        jlb1Cgc.setName("jlb1Cgc"); // NOI18N

        jlb1InscricaoEstadual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1InscricaoEstadual.setText("Inscrição Estadual"); // NOI18N
        jlb1InscricaoEstadual.setName("jlb1InscricaoEstadual"); // NOI18N

        jlb1Cep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Cep.setText("CEP"); // NOI18N
        jlb1Cep.setName("jlb1Cep"); // NOI18N

        jtfCodigo.setName("jtfCodigo"); // NOI18N

        jtfNumero.setName("jtfNumero"); // NOI18N

        jtfRazaoSocial.setName("jtfRazaoSocial"); // NOI18N

        jtfCgc.setName("jtfCgc"); // NOI18N

        jlb1Rua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Rua.setText("Rua"); // NOI18N
        jlb1Rua.setName("jlb1Rua"); // NOI18N

        jlb1Numero.setText("Nº"); // NOI18N
        jlb1Numero.setName("jlb1Numero"); // NOI18N

        jlb1Cidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Cidade.setText("Cidade"); // NOI18N
        jlb1Cidade.setName("jlb1Cidade"); // NOI18N

        jlb1Ccm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Ccm.setText("CCM"); // NOI18N
        jlb1Ccm.setName("jlb1Ccm"); // NOI18N

        jlb1Site.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Site.setText("Site"); // NOI18N
        jlb1Site.setName("jlb1Site"); // NOI18N

        jtfInscricaoEstadual.setName("jtfInscricaoEstadual"); // NOI18N

        jlb1Bairro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Bairro.setText("Bairro"); // NOI18N
        jlb1Bairro.setName("jlb1Bairro"); // NOI18N

        jtfCidade.setName("jtfCidade"); // NOI18N

        jtfCep.setName("jtfCep"); // NOI18N

        jtfSite.setName("jtfSite"); // NOI18N

        jtfBairro.setName("jtfBairro"); // NOI18N

        jpnDIvisao.setBackground(new java.awt.Color(200, 199, 190));
        jpnDIvisao.setName("jpnDIvisao"); // NOI18N
        jpnDIvisao.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jpnDIvisaoLayout = new javax.swing.GroupLayout(jpnDIvisao);
        jpnDIvisao.setLayout(jpnDIvisaoLayout);
        jpnDIvisaoLayout.setHorizontalGroup(
            jpnDIvisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        jpnDIvisaoLayout.setVerticalGroup(
            jpnDIvisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jlbDescBanco.setText("Dados Bancários"); // NOI18N
        jlbDescBanco.setName("jlbDescBanco"); // NOI18N

        jlb1Cnpj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Cnpj.setText(" * CNPJ"); // NOI18N
        jlb1Cnpj.setName("jlb1Cnpj"); // NOI18N

        jtfCnpj.setName("jtfCnpj"); // NOI18N

        jlb1Banco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Banco.setText("Banco"); // NOI18N
        jlb1Banco.setName("jlb1Banco"); // NOI18N

        jtfBanco.setName("jtfBanco"); // NOI18N

        jlb1Agencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Agencia.setText("Agência"); // NOI18N
        jlb1Agencia.setName("jlb1Agencia"); // NOI18N

        jtfAgencia.setName("jtfAgencia"); // NOI18N

        jtfTempoEntrega.setName("jtfTempoEntrega"); // NOI18N

        jlb1TempoEntrega.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1TempoEntrega.setText("Tempo de Entrega"); // NOI18N
        jlb1TempoEntrega.setName("jlb1TempoEntrega"); // NOI18N

        jtfContaCorrente.setName("jtfContaCorrente"); // NOI18N

        jlb1ContaCorrente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1ContaCorrente.setText("C/C"); // NOI18N
        jlb1ContaCorrente.setName("jlb1ContaCorrente"); // NOI18N

        jpnBotoes.setBackground(new java.awt.Color(243, 243, 243));
        jpnBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnBotoes.setName("jpnBotoes"); // NOI18N

        btContatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/contato.PNG"))); // NOI18N
        btContatos.setText("Contatos"); // NOI18N
        btContatos.setToolTipText("\"Adicione telefones e e-mails do fornecedor\""); // NOI18N
        btContatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btContatos.setIconTextGap(1);
        btContatos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btContatosMousePressed(evt);
            }
        });

        jbtPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/pagamento.PNG"))); // NOI18N
        jbtPagamento.setText("Pagamento"); // NOI18N
        jbtPagamento.setToolTipText("Insira as formas de pagamento que o fornecedor disponibilizara"); // NOI18N
        jbtPagamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtPagamento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtPagamentoMousePressed(evt);
            }
        });

        jButton4.setText("Produtos"); // NOI18N
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotoesLayout = new javax.swing.GroupLayout(jpnBotoes);
        jpnBotoes.setLayout(jpnBotoesLayout);
        jpnBotoesLayout.setHorizontalGroup(
            jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btContatos, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jbtPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnBotoesLayout.setVerticalGroup(
            jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtPagamento)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jtfRua.setName("jtfRua"); // NOI18N

        jtfccm.setName("jtfccm"); // NOI18N

        jtfContaCorrenteDigito.setName("jtfContaCorrenteDigito"); // NOI18N

        edPerfilDesc.setBackground(new java.awt.Color(204, 204, 204));
        edPerfilDesc.setEditable(false);
        edPerfilDesc.setFont(new java.awt.Font("Arial", 1, 11));
        edPerfilDesc.setText("dias");
        edPerfilDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edPerfilDesc.setName("edPerfilDesc"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addComponent(jpnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlb1Banco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1razaoSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb1Cnpj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb1Cep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jlb1Cgc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb1Rua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb1Bairro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb1Site, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb1TempoEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jlb1Codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSite, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(jtfCgc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlb1InscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb1Ccm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfccm, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb1Cidade)
                                .addGap(7, 7, 7)
                                .addComponent(jtfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jtfRua, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb1Numero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jtfTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edPerfilDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(682, 682, 682))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jtfBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb1Agencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb1ContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfContaCorrenteDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(694, 694, 694))))
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jpnDIvisao, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap(611, Short.MAX_VALUE))
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jlbDescBanco)
                .addContainerGap())
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1razaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfccm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlb1Ccm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlb1InscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCgc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb1Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb1Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlb1Cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb1Cgc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jlb1Rua, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb1Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb1Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtfSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Site, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edPerfilDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1TempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbDescBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDIvisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Agencia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1ContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContaCorrenteDigito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Banco, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addComponent(jpnBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 170));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        jLabel34.setText("Código"); // NOI18N

        jLabel35.setText("Razão Social"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel2, java.awt.BorderLayout.NORTH);

        jtbFornecedor.setBackground(new java.awt.Color(243, 243, 243));
        jtbFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Razão Social", "CPF", "Tempo de Entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbFornecedor);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void btContatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btContatosMousePressed
telaContatoFornecedor = new TelaContatoFornecedor();
    telaContatoFornecedor.setTipoVisualizacao(1);
    JInternalFrame TelaInterna = new JInternalFrame();
    //TelaInterna = super.CarregarTelaInterna("Tela");
    //CarregarTela(TelaInterna);
    //super.BloqueiaTela();
        try {
            TelaInterna.setSelected(true);
            //telaAuxiliar = new TelaAuxiliar(telaCargo, jtfPesqDescricao2);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_btContatosMousePressed

private void jbtPagamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtPagamentoMousePressed
telaPagamentoFornecedor = new TelaPagamentoFornecedor();
    telaPagamentoFornecedor.setTipoVisualizacao(1);
    JInternalFrame TelaInterna = new JInternalFrame();
    //TelaInterna = super.CarregarTelaInterna("Forma de Pagamento do Fornecedor");
    //CarregarTelaFornecedor(TelaInterna);
    //super.BloqueiaTela();
        try {
            TelaInterna.setSelected(true);
            //telaAuxiliar = new TelaAuxiliar(telaCargo, jtfPesqDescricao2);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jbtPagamentoMousePressed

private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
telaFornecedorProduto = new TelaFornecedorProduto();
    telaFornecedorProduto.setTipoVisualizacao(1);
    JInternalFrame TelaInterna = new JInternalFrame();
    //TelaInterna = super.CarregarTelaInterna("Fonecedor do Produto");
    //CarregarTelaProduto(TelaInterna);
    //super.BloqueiaTela();
        try {
            TelaInterna.setSelected(true);
            //telaAuxiliar = new TelaAuxiliar(telaCargo, jtfPesqDescricao2);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButton4MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btContatos;
    private javax.swing.JTextField edPerfilDesc;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JButton jbtPagamento;
    private javax.swing.JLabel jlb1Agencia;
    private javax.swing.JLabel jlb1Bairro;
    private javax.swing.JLabel jlb1Banco;
    private javax.swing.JLabel jlb1Ccm;
    private javax.swing.JLabel jlb1Cep;
    private javax.swing.JLabel jlb1Cgc;
    private javax.swing.JLabel jlb1Cidade;
    private javax.swing.JLabel jlb1Cnpj;
    private javax.swing.JLabel jlb1Codigo;
    private javax.swing.JLabel jlb1ContaCorrente;
    private javax.swing.JLabel jlb1InscricaoEstadual;
    private javax.swing.JLabel jlb1Numero;
    private javax.swing.JLabel jlb1Rua;
    private javax.swing.JLabel jlb1Site;
    private javax.swing.JLabel jlb1TempoEntrega;
    private javax.swing.JLabel jlb1razaoSocial;
    private javax.swing.JLabel jlbDescBanco;
    private javax.swing.JPanel jpnBotoes;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnDIvisao;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbFornecedor;
    private javax.swing.JTextField jtfAgencia;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfBanco;
    private javax.swing.JTextField jtfCep;
    private javax.swing.JTextField jtfCgc;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfCnpj;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfContaCorrente;
    private javax.swing.JTextField jtfContaCorrenteDigito;
    private javax.swing.JTextField jtfInscricaoEstadual;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRazaoSocial;
    private javax.swing.JTextField jtfRua;
    private javax.swing.JTextField jtfSite;
    private javax.swing.JTextField jtfTempoEntrega;
    private javax.swing.JTextField jtfccm;
    // End of variables declaration//GEN-END:variables

  

}
