/*
 * TelaFornecedor.java
 *
 * Created on 14 de Setembro de 2008, 23:42
 */

package Telas.Formulario;

import Controller.ControllerFornecedor;
import Telas.Componentes.TelaInterna;
import Telas.Tabelas.JTableFornecedor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author  Jonathan
 */
public class TelaFornecedor extends TelaAncestral implements InterfacePadraoAcessoOutrasTelas{
    private TelaContatoFornecedor telaContatoFornecedor;
    private TelaPagamentoFornecedor telaPagamentoFornecedor;
    private TelaFornecedorProduto telaFornecedorProduto;
    private TelaComposicaoCentesimal telaComposicaoCentesimal;
    private List ListaFornecedor;
    private ControllerFornecedor Controller;
    private TelaInterna telaInterna;
    private Integer IdFornecedor;
    private TelaPedido telaPedido;
    private TelaProduto telaProduto;
    private TelaImportacao telaImportacao;

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
        IdFornecedor = 0;
    } 
    
    public void setTelaComposicao(TelaComposicaoCentesimal tela) {
        this.telaComposicaoCentesimal = tela;
    }
    
    public void setTelaContatoFornecedor(TelaContatoFornecedor tela) {
        this.telaContatoFornecedor = tela;
    }
    
    public void setTelaPagamentoFornecedor(TelaPagamentoFornecedor tela) {
        this.telaPagamentoFornecedor = tela;
    }
    
    public void setTelaFornecedorProduto(TelaFornecedorProduto tela){
        this.telaFornecedorProduto = tela;
    }
    
    public void setTelaPedido(TelaPedido tela){
        this.telaPedido = tela;
    }        

    public void setTelaProduto(TelaProduto tela) {
        this.telaProduto = tela;
    }    
    
    public void setTelaImportacao(TelaImportacao tela) {
        this.telaImportacao = tela;
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
        return Gravar();
    }
    
    private boolean Gravar(){
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
        jtbFornecedor.setModel(new JTableFornecedor(ListaFornecedor)); 
        return Achou;
    }    
    
 @Override
    public void setDesktopPane(JDesktopPane Pane) {
        super.TelaPrincipal = Pane;
    }

    @Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        ArrayList ListaParametros = new ArrayList();
        if (!(jtfCodigoPesq.getText().trim().equals(""))) {
            ListaParametros.add("codigo");
            ListaParametros.add(jtfCodigoPesq.getText());
        } 
        if (!(jtfRazaoSocialPesq.getText().trim().equals(""))) {
            ListaParametros.add("RazaoSocial");
            ListaParametros.add(jtfRazaoSocialPesq.getText());
        }          
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return (Integer)((Object[])ListaFornecedor.get(Linha))[4];  
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(jtfCodigo.getText());
        Lista.add(jtfRazaoSocial.getText());
        Lista.add(jftCnpj.getText().substring(0, 2) + jftCnpj.getText().substring(3, 6) 
                  + jftCnpj.getText().substring(7, 10) + jftCnpj.getText().substring(11, 15)
                  + jftCnpj.getText().substring(16, 18));
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
     *    0      | codigo 
     *    1      | razaosocial
     *    2      | cnpj
     *    3      | inscriçãoestadual
     *    4      | ccm
     *    5      | cgc
     *    6      | rua
     *    7      | numero
     *    8      | bairro
     *    9      | cidade
     *   10      | cep
     *   11      | site
     *   12      | tempoentrega
     *   13      | dadosbancarios(ArrayList) --- 0 = banco(id) | 
     *                                           1 = Agencia| 2 = contacorrente | 3 =  COntaCorrenteDigito
     *   14      | idFornecedor
     **************************************************************************/        

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfCodigo.setText(Objeto.get(0).toString());
        jtfRazaoSocial.setText(Objeto.get(1).toString());
        jftCnpj.setText(Objeto.get(2).toString());
        jtfInscricaoEstadual.setText(Objeto.get(3).toString());
        jtfccm.setText(Objeto.get(4).toString());
        jtfCgc.setText(Objeto.get(5).toString());
        jtfRua.setText(Objeto.get(6).toString());
        jtfNumero.setText(Objeto.get(7).toString());
        jtfBairro.setText(Objeto.get(8).toString());
        jtfCidade.setText(Objeto.get(9).toString());
        jtfCep.setText(Objeto.get(10).toString());
        jtfSite.setText(Objeto.get(11).toString());
        jtfTempoEntrega.setText(Objeto.get(12).toString());
        jtfBanco.setText(((ArrayList)Objeto.get(13)).get(0).toString());
        jtfAgencia.setText(((ArrayList)Objeto.get(13)).get(1).toString());
        jtfContaCorrente.setText(((ArrayList)Objeto.get(13)).get(2).toString());
        jtfContaCorrenteDigito.setText(((ArrayList)Objeto.get(13)).get(3).toString());     
        IdFornecedor = (Integer)Objeto.get(14);
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
        jlb1RazaoSocial = new javax.swing.JLabel();
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
        jbtProduto = new javax.swing.JButton();
        jtfRua = new javax.swing.JTextField();
        jtfccm = new javax.swing.JTextField();
        jtfContaCorrenteDigito = new javax.swing.JTextField();
        try {
            MaskFormatter msk = new MaskFormatter("##.###.###/####-##");
            jftCnpj = new javax.swing.JFormattedTextField(msk);
            jlbDias = new javax.swing.JLabel();
            jpnPesquisa = new javax.swing.JPanel();
            jPanel2 = new javax.swing.JPanel();
            jtfRazaoSocialPesq = new javax.swing.JTextField();
            jLabel34 = new javax.swing.JLabel();
            jtfCodigoPesq = new javax.swing.JTextField();
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

            jlb1RazaoSocial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jlb1RazaoSocial.setText("* Razão Social"); // NOI18N
            jlb1RazaoSocial.setName("jlb1RazaoSocial"); // NOI18N

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
                .addGap(0, 766, Short.MAX_VALUE)
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
            btContatos.setToolTipText("Adicione telefones e e-mails do fornecedor"); // NOI18N
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

            jbtProduto.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\icone_carrinho.PNG")); // NOI18N
            jbtProduto.setText("Produtos"); // NOI18N
            jbtProduto.setToolTipText("Indique os produtos que este fornecedor disponibiliza");
            jbtProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jbtProduto.setName("jbtProduto"); // NOI18N
            jbtProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jbtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    jbtProdutoMousePressed(evt);
                }
            });

            javax.swing.GroupLayout jpnBotoesLayout = new javax.swing.GroupLayout(jpnBotoes);
            jpnBotoes.setLayout(jpnBotoesLayout);
            jpnBotoesLayout.setHorizontalGroup(
                jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnBotoesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jbtProduto)
                    .addContainerGap(119, Short.MAX_VALUE))
            );

            jtfRua.setName("jtfRua"); // NOI18N

            jtfccm.setName("jtfccm"); // NOI18N

            jtfContaCorrenteDigito.setName("jtfContaCorrenteDigito"); // NOI18N

        } catch (Exception e) {

        }
        jftCnpj.setName("jftCnpj"); // NOI18N
        jftCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftCnpjFocusLost(evt);
            }
        });

        jlbDias.setText("Dias");

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addComponent(jpnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlb1Banco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlb1RazaoSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb1Site, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb1TempoEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jlb1Codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb1Cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb1Bairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb1Cep, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCadastroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jlb1Rua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addComponent(jlb1Cgc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlb1Cidade, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlb1Numero, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jtfTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlbDias, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                                    .addComponent(jtfSite, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfCgc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jftCnpj))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlb1InscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlb1Ccm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfccm, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(572, 572, 572))
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
                        .addGap(10, 10, 10)
                        .addComponent(jpnDIvisao, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
                    .addComponent(jlb1Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb1RazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb1Cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfccm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb1Ccm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb1InscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jftCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCgc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Cgc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Rua, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb1Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb1Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb1Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb1Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jlb1Site, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDias, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jlb1TempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 170));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        jtfRazaoSocialPesq.setName("jtfRazaoSocialPesq"); // NOI18N

        jLabel34.setText("Código"); // NOI18N

        jtfCodigoPesq.setName("jtfCodigoPesq"); // NOI18N

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
                    .addComponent(jtfCodigoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRazaoSocialPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(612, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodigoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRazaoSocialPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jtbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFornecedorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbFornecedor);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void EscreverMetodosAbstratosTelasInternas(){
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
    
/******************************************************************************* 
 * MÉTODOS PARA ABRIR A TELA DE CONTATO FORNECEDOR
 ******************************************************************************/    
private void btContatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btContatosMousePressed
    if (VerificaSalvo()) {    
        InstaciaTelaContato();
    } else if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(12), "SICON", 0, 3, null) == 0) {               
        if (ComportamentoSalvar()) {
            InstaciaTelaContato();
        }
    }
}//GEN-LAST:event_btContatosMousePressed

private void InstaciaTelaContato(){
    telaContatoFornecedor = new TelaContatoFornecedor(); 
    telaContatoFornecedor.setTipoVisualizacao(1); 
    telaContatoFornecedor.setDesktopPane(TelaPrincipal);
    telaContatoFornecedor.setComportamentoPanel(2);
    telaContatoFornecedor.Selecionar(jtfCodigo.getText());
    telaContatoFornecedor.HabilitaBotoesAncestral();
    telaContatoFornecedor.setComportamento(2);
    telaContatoFornecedor.setCamposFornecedor(IdFornecedor, jtfCodigo.getText(), jtfRazaoSocial.getText());
    EscreverMetodosAbstratosTelasInternas();
    super.CarregarTelaInterna(telaInterna, "Contato do Fornecedor", new Dimension(900,600));        
    CarregarTelaContatoFornecedor(telaInterna);
        try {
            telaInterna.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

   
}

public boolean VerificaSalvo(){
    boolean Salvou = false;
    if (super.Operacao == 1) {
        Salvou = true;
    }
    return Salvou;
}
    
  public void CarregarTelaContatoFornecedor(TelaInterna Frame){
    telaContatoFornecedor.setVisible(true);
    //telaPerfil.setJTextRetorno(jtfPerfil);
    //telaContatoFornecedor.setTelaUsuario(this);
    telaContatoFornecedor.setFrameInterno(Frame);
    Frame.add(telaContatoFornecedor);
    TelaPrincipal.add(Frame);
    Frame.setVisible(true);     
} 

 /******************************************************************************* 
 * MÉTODOS PARA ABRIR A TELA DE PAGAMENTO DO FORNECEDOR
 ******************************************************************************/  

private void jbtPagamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtPagamentoMousePressed
    InstaciaTelaPagamentoFornecedor();
}//GEN-LAST:event_jbtPagamentoMousePressed

private void InstaciaTelaPagamentoFornecedor(){
    telaPagamentoFornecedor = new TelaPagamentoFornecedor();
    telaPagamentoFornecedor.setTipoVisualizacao(1); 
    telaPagamentoFornecedor.setDesktopPane(TelaPrincipal);
    telaPagamentoFornecedor.setComportamentoPanel(2);
    telaPagamentoFornecedor.Selecionar(String.valueOf(IdFornecedor));
    telaPagamentoFornecedor.HabilitaBotoesAncestral();
    telaPagamentoFornecedor.setComportamento(2);    
    EscreverMetodosAbstratosTelasInternas();
    super.CarregarTelaInterna(telaInterna, "Forma de Pagamento do Fornecedor", new Dimension(750, 600));        
    CarregarTelaPagamentoFornecedor(telaInterna);
        try {
            telaInterna.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
  public void CarregarTelaPagamentoFornecedor(TelaInterna Frame){
    telaPagamentoFornecedor.setVisible(true);
    //telaPerfil.setJTextRetorno(jtfPerfil);
    //telaContatoFornecedor.setTelaUsuario(this);
    telaPagamentoFornecedor.setFrameInterno(Frame);
    Frame.add(telaPagamentoFornecedor);
    TelaPrincipal.add(Frame);
    Frame.setVisible(true);     
} 
 
/******************************************************************************* 
 * MÉTODOS PARA ABRIR A TELA DE PRODUTO DO FORNECEDOR
 ******************************************************************************/  
  
private void jbtProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoMousePressed
    InstaciaTelaProdutoFornecedor();
}//GEN-LAST:event_jbtProdutoMousePressed


private void InstaciaTelaProdutoFornecedor(){
    telaFornecedorProduto = new TelaFornecedorProduto();
    telaFornecedorProduto.setTipoVisualizacao(1); 
    telaFornecedorProduto.setComportamentoPanel(2);
    telaFornecedorProduto.setDesktopPane(TelaPrincipal);
    telaFornecedorProduto.Selecionar(IdFornecedor);
    telaFornecedorProduto.setCamposFornecedor(jtfCodigo.getText(), jtfRazaoSocial.getText(), IdFornecedor);
    telaFornecedorProduto.HabilitaBotoesAncestral();
    telaFornecedorProduto.setComportamento(2);       
    EscreverMetodosAbstratosTelasInternas();
    super.CarregarTelaInterna(telaInterna, "Fornecedor do Produto", new Dimension(840, 630));        
    CarregarTelaProdutoFornecedor(telaInterna);
        try {
            telaInterna.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
  public void CarregarTelaProdutoFornecedor(TelaInterna Frame){
    telaFornecedorProduto.setVisible(true);
    //telaPerfil.setJTextRetorno(jtfPerfil);
    //telaContatoFornecedor.setTelaUsuario(this);
    telaFornecedorProduto.setFrameInterno(Frame);
    Frame.add(telaFornecedorProduto);
    TelaPrincipal.add(Frame);
    Frame.setVisible(true);     
} 

 /******************************************************************************* 
 * EVENTO SELECIONAR DA JTABLE
 ******************************************************************************/ 

private void jtbFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFornecedorMousePressed
if ((evt.getClickCount()==1) & (evt.getButton()== MouseEvent.BUTTON1)) {
        if (super.getTipoVisualizacao() == 0) {
            ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbFornecedor.getSelectedRow())));
            super.Operacao = 1;
            super.setLocalizacao(1);
            setComportamento(2);     
            super.setComportamentoPanel(2);
        } else {            
            int Posicao = jtbFornecedor.getSelectedRow();
            if (telaContatoFornecedor != null) {                
                this.telaContatoFornecedor.setCamposFornecedor((Integer)((Object[])ListaFornecedor.get(Posicao))[4], ((Object[])ListaFornecedor.get(Posicao))[0].toString(), ((Object[])ListaFornecedor.get(Posicao))[1].toString());
            } else if (telaPagamentoFornecedor != null) {
                this.telaPagamentoFornecedor.setarCamposFornecedor((Integer)((Object[])ListaFornecedor.get(Posicao))[4], ((Object[])ListaFornecedor.get(Posicao))[0].toString(), ((Object[])ListaFornecedor.get(Posicao))[1].toString());                
            } else if (telaFornecedorProduto != null) {
                this.telaFornecedorProduto.SetarCamposFornecedor(((Object[])ListaFornecedor.get(Posicao))[4].toString(), ((Object[])ListaFornecedor.get(Posicao))[0].toString(), ((Object[])ListaFornecedor.get(Posicao))[1].toString());                                
            } else if (telaPedido != null) {
                this.telaPedido.SetarCamposFornecedor(((Object[])ListaFornecedor.get(Posicao))[4].toString(), ((Object[])ListaFornecedor.get(Posicao))[0].toString(), ((Object[])ListaFornecedor.get(Posicao))[1].toString());                                
            } else if (telaProduto != null) {
                this.telaProduto.SetarCamposFornecedor(((Object[])ListaFornecedor.get(Posicao))[4].toString(), ((Object[])ListaFornecedor.get(Posicao))[0].toString(), ((Object[])ListaFornecedor.get(Posicao))[1].toString());                                
            } else if (telaImportacao != null) {
                this.telaImportacao.setarCampos(((Object[])ListaFornecedor.get(Posicao))[0].toString(), ((Object[])ListaFornecedor.get(Posicao))[1].toString(), ((Object[])ListaFornecedor.get(Posicao))[4].toString());                                
            }
            super.FechaFrameInterno();
            
          }
    }    
}//GEN-LAST:event_jtbFornecedorMousePressed

private void jftCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftCnpjFocusLost
    String CNPJ = jftCnpj.getText().substring(0, 2) + jftCnpj.getText().substring(3, 6) + jftCnpj.getText().substring(7, 10)
                  + jftCnpj.getText().substring(11, 15) + jftCnpj.getText().substring(16, 18);
    if (!(Controller.AoSairCampoCnpj(CNPJ))) {
        JOptionPane.showMessageDialog(null, "CNPJ Inválido");        
        jftCnpj.setValue(null);
    }
}//GEN-LAST:event_jftCnpjFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btContatos;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtPagamento;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JFormattedTextField jftCnpj;
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
    private javax.swing.JLabel jlb1RazaoSocial;
    private javax.swing.JLabel jlb1Rua;
    private javax.swing.JLabel jlb1Site;
    private javax.swing.JLabel jlb1TempoEntrega;
    private javax.swing.JLabel jlbDescBanco;
    private javax.swing.JLabel jlbDias;
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
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCodigoPesq;
    private javax.swing.JTextField jtfContaCorrente;
    private javax.swing.JTextField jtfContaCorrenteDigito;
    private javax.swing.JTextField jtfInscricaoEstadual;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRazaoSocial;
    private javax.swing.JTextField jtfRazaoSocialPesq;
    private javax.swing.JTextField jtfRua;
    private javax.swing.JTextField jtfSite;
    private javax.swing.JTextField jtfTempoEntrega;
    private javax.swing.JTextField jtfccm;
    // End of variables declaration//GEN-END:variables

    @Override
    public void CarregarTela(TelaInterna Frame) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  

}
