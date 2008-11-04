/*
 * TelaInicio.java
 *
 * Created on 26 de Agosto de 2008, 13:12
 */

package Telas;

import Classes.Configuracoes;
import Classes.UsuarioSistema;
import Classes.logsistema;
import Classes.perfiltela;
import Classes.usuario;
import Dao.Classes.DaoConfiguracoes;
import Telas.Formulario.ButtonTabComponent;
import Telas.Formulario.TelaAncestral;
import Telas.Formulario.TelaAvaliacaoPedido;
import Telas.Formulario.TelaBanco;
import Telas.Formulario.TelaBotao;
import Telas.Formulario.TelaCadastroTela;
import Telas.Formulario.TelaCardapio;
import Telas.Formulario.TelaCargo;
import Telas.Formulario.TelaComposicaoCentesimal;
import Telas.Formulario.TelaConfiguracoes;
import Telas.Formulario.TelaContatoFornecedor;
import Telas.Formulario.TelaMovimentacao;
import Telas.Formulario.TelaFichaTecnica;
import Telas.Formulario.TelaFormaPagamento;
import Telas.Formulario.TelaFornecedor;
import Telas.Formulario.TelaFornecedorProduto;
import Telas.Formulario.TelaImportacao;
import Telas.Formulario.TelaMotivo;
import Telas.Formulario.TelaOrdemProducao;
import Telas.Formulario.TelaPagamentoFornecedor;
import Telas.Formulario.TelaPedido;
import Telas.Formulario.TelaPerfil;
import Telas.Formulario.TelaProduto;
import Telas.Formulario.TelaRefeicao;
import Telas.Formulario.TelaSaldoEstoque;
import Telas.Formulario.TelaUnidadeMedida;
import Telas.Formulario.TelaUsuario;
import java.awt.Component;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author  jonathan
 */
public class TelaInicio extends javax.swing.JFrame {
    
    //controle de log no sistema
    logsistema Log;
    //Controladores da Aba
    public int ContAbas;
    ButtonTabComponent btFecharAba;
    //Array e Vector de Controle das Telas e Acessos
    private ArrayList<usuario> ListaAcesso = new ArrayList<usuario>();
    TelaLogin telaLogin;
    ArrayList<perfiltela> ListaTelaAcesso = new ArrayList<perfiltela>();
    Vector Acesso = new Vector();  
    Vector AcessoBotoes = new Vector();
    final String[] OrdemTelas = {"TelaBanco" , "TelaFormaPagamento", "TelaMotivo", "TelaUnidadeMedida", 
                                 "TelaCardapio", "TelaFichaTecnica", "TelaOrdemProducao", "TelaProduto",
                                 "TelaComposicaoCentesimal", "TelaEstoque", "TelaSaldoEstoque", "TelaContatoFornecedor", 
                                 "TelaFornecedor", "TelaPagamentoFornecedor", "TelaFornecedorProduto", 
                                 "TelaAvaliacaoPedido", "TelaPedido", "TelaImportacao", "TelaBotao", "TelaCargo", 
                                 "TelaPerfil", "TelaCadastroTela", "TelaUsuario" };
    //Controle de Criacao dos Menus
    boolean CriouMenuCadastro = false;
    boolean CriouMenuCardapio = false;
    boolean CriouMenuEstoque = false;    
    boolean CriouMenuFornecedor = false;
    boolean CriouMenuSeguranca = false;
    // JMenus
    JMenu jmnCadastro;
    JMenu jmnCardapio;
    JMenu jmnEstoque;
    JMenu jmnFornecedor;
    JMenu jmnSeguranca;
    // JMenusItem
    JMenuItem jmiBanco;
    JMenuItem jmiFormaPagamento;
    JMenuItem jmiMotivo;
    JMenuItem jmiUnidadeMedida;
    JMenuItem jmiCardapio;
    JMenuItem jmiFichaTecnica;
    JMenuItem jmiOrdemProducao;
    JMenuItem jmiProduto;
    JMenuItem jmiComposicaoCentesimal;
    JMenuItem jmiEstoque;
    JMenuItem jmiSaldoEstoque;
    JMenuItem jmiContatoFornecedor;
    JMenuItem jmiFornecedor;
    JMenuItem jmiPagamentoFornecedor;
    JMenuItem jmiFornecedorProduto;
    JMenuItem jmiAvaliacaoPedido;
    JMenuItem jmiPedido;
    JMenuItem jmiImportacao;
    JMenuItem jmiBotao;
    JMenuItem jmiCargo;
    JMenuItem jmiPerfil;
    JMenuItem jmiCadastroTela;
    JMenuItem jmiUsuario;
    JMenuItem jmiRefeicao;
    JMenuItem jmiConfiguracoes;
    
    //Todas as Telas
    TelaBanco telaBanco;
    TelaFormaPagamento telaFormaPagamento;
    TelaMotivo telaMotivo;
    TelaUnidadeMedida telaUnidadeMedida;
    TelaCardapio telaCardapio;
    TelaFichaTecnica telaFichaTecnica;
    TelaOrdemProducao telaOrdemProducao;
    TelaProduto telaProduto;
    TelaComposicaoCentesimal telaComposicaoCentesimal;
    TelaMovimentacao telaEstoque;
    TelaSaldoEstoque telaSaldoEstoque;
    TelaContatoFornecedor  telaContatoFornecedor;
    TelaFornecedor telaFornecedor; 
    TelaPagamentoFornecedor telaPagamentoFornecedor;
    TelaFornecedorProduto telaFornecedorProduto;
    TelaAvaliacaoPedido telaAvaliacaoPedido;
    TelaPedido telaPedido;
    TelaImportacao telaImportacao;
    TelaBotao  telaBotao;
    TelaCargo telaCargo;
    TelaPerfil telaPerfil;
    TelaCadastroTela telaCadastroTela;
    TelaUsuario  telaUsuario;   
    TelaRefeicao telaRefeicao;
    TelaConfiguracoes telaConfiguracoes;
    
    /** Creates new form TelaInicio */
    public TelaInicio() {
        initComponents();
        Log = new logsistema();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void setTelaLogin(TelaLogin telalog){
        this.telaLogin = telalog;
    }
    
    public int getContAbas(int ContAbas){
        return ContAbas;
    }
        
    private boolean VerificaTelaInstanciada(String TelaTitulo){
        int Cont = 0;
        boolean Achou = false;
        for (Object Comp : jtpTelas.getComponents()) {
             if (Comp instanceof TelaAncestral) {                 
                 if (((TelaAncestral)Comp).getTitulo().equals(TelaTitulo)) {
                    jtpTelas.setSelectedIndex(Cont);
                    Achou = true;
                 }
             Cont++;        
             }
        }
        return Achou;
    }
    
    public void CarregarBotaoAba(){
        btFecharAba = new ButtonTabComponent(jtpTelas,this);
        jtpTelas.setTabComponentAt(ContAbas, btFecharAba);						    
        ContAbas = ContAbas + 1;
           jtpTelas.setSelectedIndex(ContAbas - 1);    
    }  
    
    public void setListaAcesso(ArrayList<usuario> Lista){
        this.ListaAcesso = Lista;
    }
    
    public void DefineAcesso(){
        //Verifica se é necessario carregar Jmenu Cadastro;
        //Caso for administrador carrega todos os formularios
        if (ListaAcesso.get(0).getPerfil().getAdministrador() == true) {
            this.telaLogin.setProgressaoMaximum(23);
            for (int i = 0; i < 25; i++) {         
                this.telaLogin.setProgressao();
                CriaMenuIndicado(i);
            }    
        } else {
            IdentificaAcesso();
            CriarMenus();
        }
        CarregarConfiguracoes();        
    }
    
    public void CarregarConfiguracoes(){
        Configuracoes objConf = new Configuracoes();
        objConf.setIdConfiguracoes(1);
        DaoConfiguracoes daoConf = new DaoConfiguracoes();        
        objConf = daoConf.CarregarObjeto(objConf);
        objConf.setConfiguracoesStatic();
    }
    
    private Vector RetornaVetorBotoesPermitidos(String Tela){
        int cont = 0;
        int contBotoes = 0;
        //AcessoBotoes = (Vector) Acesso.clone();
        Vector BotoesPermitidos = new Vector();
        while (Acesso.size() > cont) {
            if (((Vector)Acesso.get(cont)).get(0).equals(Tela)) {
                while (((Vector)Acesso.get(cont)).size() > contBotoes) {
                    BotoesPermitidos.add(((Vector)Acesso.get(cont)).get(contBotoes));
                    contBotoes++;
                }        
            }
            cont++;
        }
        return BotoesPermitidos;
    } 
    
    private void CriarMenuSeguranca(){
        jmnSeguranca = new JMenu();
        jmnSeguranca.setText("Segurança");
        jmbPrincipal.add(jmnSeguranca);   
        CriouMenuSeguranca = true;
    }
    
    private void CriarMenuCadastro(){
        jmnCadastro = new JMenu();
        jmnCadastro.setText("Cadastro");
        jmbPrincipal.add(jmnCadastro);   
        CriouMenuCadastro = true;
    }
    
    private void CriarMenuCardapio(){
        jmnCardapio = new JMenu();
        jmnCardapio.setText("Cardápio");
        jmbPrincipal.add(jmnCardapio);   
        CriouMenuCardapio = true;
    }
    
    private void CriarMenuEstoque(){
        jmnEstoque = new JMenu();
        jmnEstoque.setText("Estoque");
        jmbPrincipal.add(jmnEstoque);   
        CriouMenuEstoque = true;
    }
    
    private void CriarMenuFornecedor(){
        jmnFornecedor = new JMenu();
        jmnFornecedor.setText("Fornecedor");
        jmbPrincipal.add(jmnFornecedor);   
        CriouMenuFornecedor = true;
    }
    
    private void CriarMenuItemCargo(){
        jmiCargo = new JMenuItem();
        telaCargo = new TelaCargo();
        jmiCargo.setText("Cargo");
        jmnSeguranca.add(jmiCargo);
        jmiCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemCargo(evt);
            }
        });         
    }
    
    private void CliqueItemCargo(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Cargo"))){
            telaCargo = new TelaCargo();
            SetAcessoBotoes("TelaCargo", RetornaVetorBotoesPermitidos("TelaCargo"));
            jtpTelas.add("Cargo", telaCargo);
            CarregarBotaoAba();        
        }
    }

    private void CriarMenuItemBanco(){
        jmiBanco = new JMenuItem();
        jmiBanco.setText("Banco");
        jmnCadastro.add(jmiBanco);
        jmiBanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemBanco(evt);
            }
        });        
    }
    
    private void CliqueItemBanco(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Banco"))){        
            telaBanco = new TelaBanco();     
            SetAcessoBotoes("TelaBanco", RetornaVetorBotoesPermitidos("TelaBanco"));
            jtpTelas.add("Banco", telaBanco);        
            CarregarBotaoAba();    
        }
    }    
    
    private void CriarMenuItemFormaPagamento(){
        jmiFormaPagamento = new JMenuItem();
        jmiFormaPagamento.setText("FormaPagamento");
        jmnCadastro.add(jmiFormaPagamento);
        jmiFormaPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemFormaPagamento(evt);
            }
        });              
    }
    
    private void CliqueItemFormaPagamento(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Forma de Pagamento"))){        
            telaFormaPagamento = new TelaFormaPagamento();
            SetAcessoBotoes("TelaFormaPagamento", RetornaVetorBotoesPermitidos("TelaFormaPagamento"));
            jtpTelas.add("Forma de Pagamento", telaFormaPagamento);
            CarregarBotaoAba();  
        }
    }        
    
    private void CriarMenuItemMotivo(){
        jmiMotivo = new JMenuItem();
        jmiMotivo.setText("Motivo");
        jmnCadastro.add(jmiMotivo);
        jmiMotivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemMotivo(evt);
            }
        });  
    }    
    
    private void CliqueItemMotivo(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Motivo"))){        
            telaMotivo = new TelaMotivo();
            SetAcessoBotoes("TelaMotivo", RetornaVetorBotoesPermitidos("TelaMotivo"));
            jtpTelas.add("Motivo", telaMotivo);
            CarregarBotaoAba();        
        }
    }  
    
    private void CriarMenuItemRefeicao(){
        jmiRefeicao = new JMenuItem();
        jmiRefeicao.setText("Refeição");
        jmnCardapio.add(jmiRefeicao);
        jmiRefeicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemRefeicao(evt);
            }
        });  
    }    
    
    private void CliqueItemRefeicao(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Refeição"))){
            telaRefeicao = new TelaRefeicao();
            SetAcessoBotoes("TelaRefeicao", RetornaVetorBotoesPermitidos("TelaRefeicao"));
            jtpTelas.add("Refeição", telaRefeicao);
            CarregarBotaoAba();        
        }
    }         
    
    private void CriarMenuItemUnidadeMedida(){
        jmiUnidadeMedida = new JMenuItem();
        jmiUnidadeMedida.setText("Unidade de Medida");
        jmnCadastro.add(jmiUnidadeMedida);
        jmiUnidadeMedida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemUnidadeMedida(evt);
            }
        });  
    }
    
    private void CliqueItemUnidadeMedida(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Unidade de Medida"))){
            telaUnidadeMedida = new TelaUnidadeMedida();
            SetAcessoBotoes("TelaUnidadeMedida", RetornaVetorBotoesPermitidos("TelaUnidadeMedida"));
            jtpTelas.add("Unidade de Medida", telaUnidadeMedida);
            CarregarBotaoAba();        
        }
    }           
    
    private void CriarMenuItemCardapio(){
        jmiCardapio = new JMenuItem();
        jmiCardapio.setText("Cardápio");
        jmnCardapio.add(jmiCardapio);
        jmiCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemCardapio(evt);
            }
        });  
    }
    
    private void CliqueItemCardapio(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Cardápio"))){        
            telaCardapio = new TelaCardapio();
            telaCardapio.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaCardapio", RetornaVetorBotoesPermitidos("TelaCardapio"));
            jtpTelas.add("Cardápio", telaCardapio);
            CarregarBotaoAba();        
        }
    }        
    
    private void CriarMenuItemFichaTecnica(){
        jmiFichaTecnica = new JMenuItem();
        jmiFichaTecnica.setText("Ficha Técnica");
        jmnCardapio.add(jmiFichaTecnica);
        jmiFichaTecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemFichaTecnica(evt);
            }
        });  
    }
    
    private void CliqueItemFichaTecnica(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Ficha Técnica"))){
            telaFichaTecnica = new TelaFichaTecnica();
            telaFichaTecnica.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaFichaTecnica", RetornaVetorBotoesPermitidos("TelaFichaTecnica"));
            jtpTelas.add("Ficha Técnica", telaFichaTecnica);
            CarregarBotaoAba();        
        }     
    }         
    
    private void CriarMenuItemOrdemProducao(){
        jmiOrdemProducao = new JMenuItem();
        jmiOrdemProducao.setText("Ordem de Produção");
        jmnCardapio.add(jmiOrdemProducao);
        jmiOrdemProducao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemOrdemProducao(evt);
            }
        });  
    }
    
    private void CliqueItemOrdemProducao(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Ordem de Produção"))){        
            telaOrdemProducao = new TelaOrdemProducao();
            telaOrdemProducao.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaOrdemProducao", RetornaVetorBotoesPermitidos("TelaOrdemProducao"));
            jtpTelas.add("Ordem de Produção", telaOrdemProducao);
            CarregarBotaoAba();        
        }
    }          
    
    private void CriarMenuItemProduto(){
        jmiProduto = new JMenuItem();
        jmiProduto.setText("Produto");
        jmnCardapio.add(jmiProduto);
        jmiProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemProduto(evt);
            }
        });  
    }
    
    private void CliqueItemProduto(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Produto"))){       
            telaProduto = new TelaProduto();
            telaProduto.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaProduto", RetornaVetorBotoesPermitidos("TelaProduto"));
            jtpTelas.add("Produto", telaProduto);
            CarregarBotaoAba();        
        }
    }        
    
    private void CriarMenuItemEstoque(){
        jmiEstoque = new JMenuItem();
        jmiEstoque.setText("Estoque");
        jmnEstoque.add(jmiEstoque);
        jmiEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemEstoque(evt);
            }
        });  
    }
    
    private void CliqueItemEstoque(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Estoque"))){        
            telaEstoque = new TelaMovimentacao();
            telaEstoque.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaEstoque", RetornaVetorBotoesPermitidos("TelaEstoque"));
            jtpTelas.add("Estoque", telaEstoque);
            CarregarBotaoAba();        
        }
    }            
    
    private void CriarMenuItemComposicaoCentesimal(){
        jmiComposicaoCentesimal = new JMenuItem();
        jmiComposicaoCentesimal.setText("Composição Centesimal");
        jmnCardapio.add(jmiComposicaoCentesimal);
        jmiComposicaoCentesimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemComposicaoCentesimal(evt);
            }
        });  
    }
    
    private void CliqueItemComposicaoCentesimal(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Composição Centesimal"))){        
            telaComposicaoCentesimal = new TelaComposicaoCentesimal();
            telaComposicaoCentesimal.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaComposicaoCentesimal", RetornaVetorBotoesPermitidos("TelaComposicaoCentesimal"));
            jtpTelas.add("Composição Centesimal", telaComposicaoCentesimal);
            CarregarBotaoAba();        
        }
    }       
    
    private void CriarMenuItemSaldoEstoque(){
        jmiSaldoEstoque = new JMenuItem();
        jmiSaldoEstoque.setText("Saldo do Estoque");
        jmnEstoque.add(jmiSaldoEstoque);
        jmiSaldoEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemSaldoEstoque(evt);
            }
        });  
    }
    
    private void CliqueItemSaldoEstoque(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Saldo do Estoque"))){
            telaSaldoEstoque = new TelaSaldoEstoque();
            telaSaldoEstoque.TelaPrincipal = jdpTelas;
            SetAcessoBotoes("TelaSaldoEstoque", RetornaVetorBotoesPermitidos("TelaSaldoEstoque"));
            jtpTelas.add("Saldo do Estoque", telaSaldoEstoque);
            CarregarBotaoAba();        
        }
    }         
    
    private void CriarMenuItemContatoFornecedor(){
        jmiContatoFornecedor = new JMenuItem();
        jmiContatoFornecedor.setText("Contato do Fornecedor");
        jmnFornecedor.add(jmiContatoFornecedor);
        jmiContatoFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemContatoFornecedor(evt);
            }
        });  
    }
    
    private void CliqueItemContatoFornecedor(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Contato do Fornecedor"))){        
            telaContatoFornecedor = new TelaContatoFornecedor();
            SetAcessoBotoes("TelaContatoFornecedor", RetornaVetorBotoesPermitidos("TelaContatoFornecedor"));
            telaContatoFornecedor.setDesktopPane(jdpTelas);
            jtpTelas.add("Contato do Fornecedor", telaContatoFornecedor);
            CarregarBotaoAba();        
        }
    }   
    
    private void CriarMenuItemFornecedor(){
        jmiFornecedor = new JMenuItem();
        jmiFornecedor.setText("Fornecedor");        
        jmnFornecedor.add(jmiFornecedor);
        jmiFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemFornecedor(evt);
            }
        });  
    }
    
    private void CliqueItemFornecedor(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Fornecedor"))){        
            telaFornecedor = new TelaFornecedor();
            telaFornecedor.setDesktopPane(jdpTelas);            
            SetAcessoBotoes("TelaFornecedor", RetornaVetorBotoesPermitidos("TelaFornecedor"));
            jtpTelas.add("Fornecedor", telaFornecedor);
            CarregarBotaoAba();        
        }
    }     
    
    private void CriarMenuItemPagamentoFornecedor(){
        jmiPagamentoFornecedor = new JMenuItem();
        jmiPagamentoFornecedor.setText("Pagamento do Fornecedor");
        jmnFornecedor.add(jmiPagamentoFornecedor);
        jmiPagamentoFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemPagamentoFornecedor(evt);
            }
        });  
    }
    
    private void CliqueItemPagamentoFornecedor(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Forma de Pagamento do Fornecedor"))){        
            telaPagamentoFornecedor = new TelaPagamentoFornecedor();
            telaPagamentoFornecedor.setDesktopPane(jdpTelas);        
            SetAcessoBotoes("TelaPagamentoFornecedor", RetornaVetorBotoesPermitidos("TelaPagamentoFornecedor"));
            jtpTelas.add("Forma de Pagamento do Fornecedor", telaPagamentoFornecedor);
            CarregarBotaoAba();   
        }
    }         
    
    private void CriarMenuItemFornecedorProduto(){
        jmiFornecedorProduto = new JMenuItem();
        jmiFornecedorProduto.setText("Fornecedor do Produto");
        jmnFornecedor.add(jmiFornecedorProduto);
        jmiFornecedorProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemFornecedorProduto(evt);
            }
        });  
    }
    
    private void CliqueItemFornecedorProduto(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Fornecedor do Produto"))){        
            telaFornecedorProduto = new TelaFornecedorProduto();
            telaFornecedorProduto.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaFornecedorProduto", RetornaVetorBotoesPermitidos("TelaFornecedorProduto"));
            jtpTelas.add("Fornecedor do Produto", telaFornecedorProduto);
            CarregarBotaoAba();        
        }
    }             
    
    private void CriarMenuItemAvaliacaoPedido(){
        jmiAvaliacaoPedido = new JMenuItem();
        jmiAvaliacaoPedido.setText("Avaliação do Pedido");
        jmnFornecedor.add(jmiAvaliacaoPedido);
        jmiAvaliacaoPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemAvaliacaoPedido(evt);
            }
        });  
    }
    
    private void CliqueItemAvaliacaoPedido(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Avaliação do Pedido"))){        
            telaAvaliacaoPedido = new TelaAvaliacaoPedido();
            telaAvaliacaoPedido.setTelaPrincipal(jdpTelas);
            SetAcessoBotoes("TelaAvaliacaoPedido", RetornaVetorBotoesPermitidos("TelaAvaliacaoPedido"));
            jtpTelas.add("Avaliação do Pedido", telaAvaliacaoPedido);
            CarregarBotaoAba();        
        }
    }               
    
    private void CriarMenuItemPedido(){
        jmiPedido = new JMenuItem();
        jmiPedido.setText("Pedido");
        jmnFornecedor.add(jmiPedido);
        jmiPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemPedido(evt);
            }
        });  
    }
    
    private void CliqueItemPedido(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Pedido"))){        
            telaPedido = new TelaPedido();
            telaPedido.setDesktopPane(jdpTelas);            
            SetAcessoBotoes("TelaPedido", RetornaVetorBotoesPermitidos("TelaPedido"));
            jtpTelas.add("Pedido", telaPedido);
            CarregarBotaoAba();        
        }
    }        
    
    private void CriarMenuItemImportacao(){
        jmiImportacao = new JMenuItem();
        jmiImportacao.setText("Importacao");
        jmnFornecedor.add(jmiImportacao);
        jmiImportacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemImportacao(evt);
            }
        });  
    }
    
    private void CliqueItemImportacao(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Importação"))){        
            telaImportacao = new TelaImportacao();
            SetAcessoBotoes("TelaImportacao", RetornaVetorBotoesPermitidos("TelaImportacao"));
            jtpTelas.add("Importação", telaImportacao);
            CarregarBotaoAba();        
        }
    }        
    
    private void CriarMenuItemBotao(){
        jmiBotao = new JMenuItem();
        jmiBotao.setText("Botao");
        jmnSeguranca.add(jmiBotao);
        jmiBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemBotao(evt);
            }
        });  
    }
    
    private void CliqueItemBotao(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Botão"))){
            telaBotao = new TelaBotao();
            SetAcessoBotoes("TelaBotao", RetornaVetorBotoesPermitidos("TelaBotao"));
            jtpTelas.add("Botão", telaBotao);
            CarregarBotaoAba();    
        }
    }         
    
    private void CriarMenuItemPerfil(){
        jmiPerfil = new JMenuItem();
        jmiPerfil.setText("Perfil");
        jmnSeguranca.add(jmiPerfil);
        jmiPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemPerfil(evt);
            }
        });  
    }
    
    private void CliqueItemPerfil(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Perfil"))){       
            telaPerfil = new TelaPerfil();
            SetAcessoBotoes("TelaPerfil", RetornaVetorBotoesPermitidos("TelaPerfil"));
            telaPerfil.setDesktopPane(jdpTelas);        
            jtpTelas.add("Perfil", telaPerfil);
            CarregarBotaoAba();        
        }
    }             
    
    private void CriarMenuItemCadastroTela(){
        jmiCadastroTela = new JMenuItem();
        jmiCadastroTela.setText("Tela");
        jmnSeguranca.add(jmiCadastroTela);
        jmiCadastroTela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemCadastroTela(evt);
            }
        });  
    }
    
    private void CliqueItemCadastroTela(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Tela"))){        
            telaCadastroTela = new TelaCadastroTela();
            telaCadastroTela.setDesktopPane(jdpTelas);
            SetAcessoBotoes("TelaCadastroTela", RetornaVetorBotoesPermitidos("TelaCadastroTela"));
            jtpTelas.add("Tela", telaCadastroTela);
            CarregarBotaoAba();        
        }
    }           
    
    private void CriarMenuItemUsuario(){
        jmiUsuario = new JMenuItem();
        jmiUsuario.setText("Usuário");
        jmnSeguranca.add(jmiUsuario);
        jmiUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemUsuario(evt);
            }
        });  
    }
    
    private void CliqueItemUsuario(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Usuário"))){        
            telaUsuario = new TelaUsuario();
            SetAcessoBotoes("TelaUsuario", RetornaVetorBotoesPermitidos("TelaUsuario"));
            telaUsuario.setDesktopPane(jdpTelas);
            jtpTelas.add("Usuário", telaUsuario);
            CarregarBotaoAba();    
        }
    }      
    
    private void CriarMenuItemConfiguracoes() {
        jmiConfiguracoes = new JMenuItem();
        jmiConfiguracoes.setText("Configurações");
        jmnSeguranca.add(jmiConfiguracoes);
        jmiConfiguracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CliqueItemConfiguracoes(evt);
            }
        });  
    }   
    
    private void CliqueItemConfiguracoes(java.awt.event.MouseEvent evt){
        if (!(VerificaTelaInstanciada("Configuracoes"))){        
            telaConfiguracoes = new TelaConfiguracoes();
            //SetAcessoBotoes("TelaUsuario", RetornaVetorBotoesPermitidos("TelaUsuario"));
            //telaConfiguracoes.setDesktopPane(jdpTelas);
            jtpTelas.add("Configuracoes", telaConfiguracoes);
            CarregarBotaoAba();    
        }
    }      
    
    
    private void IdentificaAcesso(){ 
        int cont = 0;          
        // é necessario desenvolver o algoritmo para ordenar o arrayList ListaAcesso;
        Vector teste = (Vector) ListaAcesso.get(0).getPerfil().getPerfiltelaCollection();
        String StringTela = ((perfiltela)teste.get(cont)).getIdtela().getNometela();        
        String UltStringTela = StringTela;
        while (teste.size() > cont){  
            Vector telatela = new Vector();
            telatela.add(((perfiltela)teste.get(cont)).getIdtela().getNometela());
            while (StringTela.equals(UltStringTela)) {
                telatela.add(((perfiltela)teste.get(cont)).getbotao().getNomebotao());                
                cont++;
                if (cont == teste.size()){
                    UltStringTela = "";
                } else UltStringTela = ((perfiltela)teste.get(cont)).getIdtela().getNometela();

            }            
            Acesso.add(telatela);            
        }
    }
    
    private void CriarMenus(){        
        int contOrdem = 0;        
        while (OrdemTelas.length > contOrdem) {
            int contTelas = 0;
            while (Acesso.size() > contTelas) { //(((Vector)Acesso.get(contTelas)).size() > contTelas) {                                            
                //Carrega Lista do Menu Cadastro
                if (((Vector)Acesso.get(contTelas)).get(0).equals(OrdemTelas[contOrdem])){
                    CriaMenuIndicado(contOrdem);                         
                }
                contTelas++;
            }
        contOrdem++;   
        }    
    }
        
    private void CriaMenuIndicado(int NumeroMenu){
        switch(NumeroMenu){
            // 0 = tela Banco      
            case 0:
                if (!(CriouMenuCadastro)) { 
                     CriarMenuCadastro();
                }
                CriarMenuItemBanco();                
            break;
            // 1 = tela Forma de Pagamento      
            case 1:
                if (!(CriouMenuCadastro)) { 
                     CriarMenuCadastro();
                }
                CriarMenuItemFormaPagamento();                
            break;
            // 2 = tela Motivo      
            case 2:
                if (!(CriouMenuCadastro)) { 
                     CriarMenuCadastro();
                }
                CriarMenuItemMotivo();                
            break;  
            // 3 = tela Unidade de Medida      
            case 3:
                if (!(CriouMenuCadastro)) { 
                     CriarMenuCadastro();
                }
                CriarMenuItemUnidadeMedida();                                     
            break; 
            // 4 = tela Cardapio      
            case 4:
                if (!(CriouMenuCardapio)) { 
                     CriarMenuCardapio();
                }
                CriarMenuItemCardapio();                
            break;
            // 5 = tela FichaTecnica
            case 5:
                if (!(CriouMenuCardapio)) { 
                     CriarMenuCardapio();
                }
                CriarMenuItemFichaTecnica();                                     
            break;
            // 6 = tela Ordem de Produção
            case 6:
                if (!(CriouMenuCardapio)) { 
                     CriarMenuCardapio();
                }
                CriarMenuItemOrdemProducao();                                     
            break; 
            // 7 = tela Produto 
            case 7:
                if (!(CriouMenuCardapio)) { 
                     CriarMenuCardapio();
                }
                CriarMenuItemProduto();                                     
            break; 
            // 8 = tela Composição Centesimal
            case 8:
                if (!(CriouMenuCardapio)) { 
                     CriarMenuCardapio();
                }
                CriarMenuItemComposicaoCentesimal();                                     
            break;
            // 9 = tela Estoque
            case 9:
                if (!(CriouMenuEstoque)) { 
                     CriarMenuEstoque();
                }
                CriarMenuItemEstoque();                                     
            break; 
            // 10 = tela Saldo Estoque
            case 10:
                if (!(CriouMenuEstoque)) { 
                     CriarMenuEstoque();
                }
                CriarMenuItemSaldoEstoque();                     
            break; 
            // 11 = tela Contato do Fornecedor
            case 11:
                if (!(CriouMenuFornecedor)) { 
                     CriarMenuFornecedor();
                }
                CriarMenuItemContatoFornecedor();                                     
            break; 
            // 12 = tela Fornecedor
            case 12:
                if (!(CriouMenuFornecedor)) { 
                     CriarMenuFornecedor();
                }
                CriarMenuItemFornecedor();                                     
            break; 
            // 13 = tela Pagamento do Fornecedor
            case 13:
                if (!(CriouMenuFornecedor)) { 
                     CriarMenuFornecedor();
                }
                CriarMenuItemPagamentoFornecedor();                                     
            break; 
            // 14 = tela Produto do Fornecedor
            case 14:
                if (!(CriouMenuFornecedor)) { 
                     CriarMenuFornecedor();
                }
                CriarMenuItemFornecedorProduto();                                     
            break; 
            // 15 = tela Avaliacao do Pedido 
            case 15:
                if (!(CriouMenuFornecedor)) { 
                     CriarMenuFornecedor();
                }
                CriarMenuItemAvaliacaoPedido();                     
            break; 
            // 16 = tela Pedido
            case 16:
                if (!(CriouMenuFornecedor)) { 
                     CriarMenuFornecedor();
                }
                CriarMenuItemPedido();                                     
            break; 
            // 17 = tela Importação
            case 17:
                if (!(CriouMenuFornecedor)) { 
                     CriarMenuFornecedor();
                }
                CriarMenuItemImportacao();                                     
            break; 
            // 18 = tela Botão
            case 18:
                if (!(CriouMenuSeguranca)) { 
                     CriarMenuSeguranca();
                }
                CriarMenuItemBotao();                                     
            break; 
            // 19 = tela Cargo
            case 19:
                if (!(CriouMenuSeguranca)) { 
                     CriarMenuSeguranca();
                }
                CriarMenuItemCargo();                     
            break; 
            // 20 = tela Cadastro de Tela
            case 20:
                if (!(CriouMenuSeguranca)) { 
                     CriarMenuSeguranca();
                }
                CriarMenuItemCadastroTela();                                     
            break; 
            // 21 = tela Perfil
            case 21:
                if (!(CriouMenuSeguranca)) { 
                     CriarMenuSeguranca();
                }
                CriarMenuItemPerfil();                                     
            break; 
            // 22 = tela Usuario
            case 22:
                if (!(CriouMenuSeguranca)) { 
                     CriarMenuSeguranca();
                }
                CriarMenuItemUsuario();                                     
            break;
            case 23:
                if (!(CriouMenuCardapio)) { 
                     CriarMenuCardapio();
                }
                CriarMenuItemRefeicao();                                     
            break; 
            case 24:
                if (!(CriouMenuSeguranca)) { 
                     CriarMenuSeguranca();
                }
                CriarMenuItemConfiguracoes();                                     
            break;                 
        }
    }
    
    private void SetAcessoBotoes(String Tela, Vector BotoesPermitidos){
        int cont = 0;
        //Tela Banco
        if (Tela.equals("TelaBanco")) {
            if (BotoesPermitidos.isEmpty()) {
                telaBanco.HabilitaBotoesAncestral();    
            } else {            
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaBanco.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaBanco.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaBanco.setHabilitaPesquisar(true);
                        telaBanco.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaBanco.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaBanco.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaBanco.setComportamento(3);
        } else
        //Refeição
        if (Tela.equals("TelaRefeicao")) {
            if (BotoesPermitidos.isEmpty()) {
                telaRefeicao.HabilitaBotoesAncestral();    
            } else {            
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaRefeicao.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaRefeicao.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaRefeicao.setHabilitaPesquisar(true);
                        telaRefeicao.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaRefeicao.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaRefeicao.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaRefeicao.setComportamento(3);
        } else            
        //Tela Forma Pagamento
        if (Tela.equals("TelaFormaPagamento")) {
            if (BotoesPermitidos.isEmpty()) {
                telaFormaPagamento.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaFormaPagamento.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaFormaPagamento.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaFormaPagamento.setHabilitaPesquisar(true);
                        telaFormaPagamento.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaFormaPagamento.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaFormaPagamento.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaFormaPagamento.setComportamento(3);
        } else
        if (Tela.equals("TelaMotivo")) {
            if (BotoesPermitidos.isEmpty()) {
                telaMotivo.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaMotivo.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaMotivo.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaMotivo.setHabilitaPesquisar(true);
                        telaMotivo.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaMotivo.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaMotivo.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaMotivo.setComportamento(3);
        } else
        if (Tela.equals("TelaUnidadeMedida")) {
            if (BotoesPermitidos.isEmpty()) {
                telaUnidadeMedida.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaUnidadeMedida.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaUnidadeMedida.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaUnidadeMedida.setHabilitaPesquisar(true);
                        telaUnidadeMedida.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaUnidadeMedida.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaUnidadeMedida.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaUnidadeMedida.setComportamento(3);
        } else
        if (Tela.equals("TelaCardapio")) {
            if (BotoesPermitidos.isEmpty()) {
                telaCardapio.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaCardapio.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaCardapio.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaCardapio.setHabilitaPesquisar(true);
                        telaCardapio.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaCardapio.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaCardapio.setHabilitaSalvar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtGerar")){
                        telaCardapio.setHabilitaGerar(true);
                    }
                cont++;
                }
            } telaCardapio.setComportamento(3);
        } else
        if (Tela.equals("TelaFichaTecnica")) {
            if (BotoesPermitidos.isEmpty()) {
                telaFichaTecnica.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaFichaTecnica.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaFichaTecnica.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaFichaTecnica.setHabilitaPesquisar(true);
                        telaFichaTecnica.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaFichaTecnica.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaFichaTecnica.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaFichaTecnica.setComportamento(3);
        } else
        if (Tela.equals("TelaOrdemProducao")) {
            if (BotoesPermitidos.isEmpty()) {
                telaOrdemProducao.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaOrdemProducao.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaOrdemProducao.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaOrdemProducao.setHabilitaPesquisar(true);
                        telaOrdemProducao.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaOrdemProducao.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaOrdemProducao.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaOrdemProducao.setComportamento(3);
        } else
        if (Tela.equals("TelaProduto")) {
            if (BotoesPermitidos.isEmpty()) {
                telaProduto.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaProduto.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaProduto.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaProduto.setHabilitaPesquisar(true);
                        telaProduto.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaProduto.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaProduto.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaProduto.setComportamento(3);
        } else
        if (Tela.equals("TelaComposicaoCentesimal")) {
            if (BotoesPermitidos.isEmpty()) {
                telaComposicaoCentesimal.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaComposicaoCentesimal.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaComposicaoCentesimal.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaComposicaoCentesimal.setHabilitaPesquisar(true);
                        telaComposicaoCentesimal.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaComposicaoCentesimal.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaComposicaoCentesimal.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaComposicaoCentesimal.setComportamento(3);
        } else
        if (Tela.equals("TelaEstoque")) {
            if (BotoesPermitidos.isEmpty()) {
                telaEstoque.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaEstoque.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaEstoque.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaEstoque.setHabilitaPesquisar(true);
                        telaEstoque.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaEstoque.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaEstoque.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaEstoque.setComportamento(3);
        } else
        /*if (Tela.equals("TelaSaldoEstoque")) {
            while (BotoesPermitidos.size() > cont) {
                if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                    telaSaldoEstoque.setHabilitaNovo(true);
                } else 
                if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                    telaBanco.setHabilitaVoltar(true);
                } else
                if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                    telaBanco.setHabilitaPesquisar(true);
                    telaBanco.setHabilitaVoltar(true);
                } else
                if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                    telaBanco.setHabilitaExcluir(true);
                } else
                if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                    telaBanco.setHabilitaSalvar(true);
                }                    
            cont++;
            }
        } else*/
        if (Tela.equals("TelaContatoFornecedor")) {
            if (BotoesPermitidos.isEmpty()) {
                telaContatoFornecedor.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaContatoFornecedor.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaContatoFornecedor.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaContatoFornecedor.setHabilitaPesquisar(true);
                        telaContatoFornecedor.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaContatoFornecedor.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaContatoFornecedor.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaContatoFornecedor.setComportamento(3);
        } else
        if (Tela.equals("TelaFornecedor")) {
            if (BotoesPermitidos.isEmpty()) {
                telaFornecedor.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaFornecedor.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaFornecedor.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaFornecedor.setHabilitaPesquisar(true);
                        telaFornecedor.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaFornecedor.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaFornecedor.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaFornecedor.setComportamento(3);
        } else
        if (Tela.equals("TelaPagamentoFornecedor")) {
            if (BotoesPermitidos.isEmpty()) {
                telaPagamentoFornecedor.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaPagamentoFornecedor.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaPagamentoFornecedor.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaPagamentoFornecedor.setHabilitaPesquisar(true);
                        telaPagamentoFornecedor.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaPagamentoFornecedor.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaPagamentoFornecedor.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaPagamentoFornecedor.setComportamento(3);
        } else
        if (Tela.equals("TelaFornecedorProduto")) {
            if (BotoesPermitidos.isEmpty()) {
                telaFornecedorProduto.HabilitaBotoesAncestral();    
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaFornecedorProduto.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaFornecedorProduto.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaFornecedorProduto.setHabilitaPesquisar(true);
                        telaFornecedorProduto.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaFornecedorProduto.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaFornecedorProduto.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaFornecedorProduto.setComportamento(3);
        } else
        /*if (Tela.equals("TelaAvaliacaoPedido")) {
            while (BotoesPermitidos.size() > cont) {
                if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                    telaAvaliacaoPedido.setHabilitaNovo(true);
                } else 
                if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                    telaAvaliacaoPedido.setHabilitaVoltar(true);
                } else
                if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                    telaAvaliacaoPedido.setHabilitaPesquisar(true);
                    telaAvaliacaoPedido.setHabilitaVoltar(true);
                } else
                if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                    telaAvaliacaoPedido.setHabilitaExcluir(true);
                } else
                if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                    telaAvaliacaoPedido.setHabilitaSalvar(true);
                }                    
            cont++;
            }
        } else*/
        if (Tela.equals("TelaPedido")) {
            if (BotoesPermitidos.isEmpty()) {
                telaPedido.HabilitaBotoesAncestral();                  
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaPedido.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaPedido.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaPedido.setHabilitaPesquisar(true);
                        telaPedido.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaPedido.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaPedido.setHabilitaSalvar(true);
                    }          
                    if (BotoesPermitidos.get(cont).equals("jbtEnviar")){
                        telaPedido.setHabilitaEnviar(true);
                    }
                    if (BotoesPermitidos.get(cont).equals("jbtBaixar")){
                        telaPedido.setHabilitabaixar(true);
                    }
                cont++;
                }
            } telaPedido.setComportamento(3);
        } else
        if (Tela.equals("TelaBotao")) {
            if (BotoesPermitidos.isEmpty()) {
                telaBotao.HabilitaBotoesAncestral();                
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaBotao.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaBotao.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaBotao.setHabilitaPesquisar(true);
                        telaBotao.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaBotao.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaBotao.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaBotao.setComportamento(3);  
        } else
        if (Tela.equals("TelaCargo")) {
            if (BotoesPermitidos.isEmpty()) {
                telaCargo.HabilitaBotoesAncestral();                 
            } else {
                telaCargo.DesabilitaBotoesAncestral();
                while (BotoesPermitidos.size() > cont) {                
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaCargo.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaCargo.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaCargo.setHabilitaPesquisar(true);
                        telaCargo.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaCargo.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaCargo.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaCargo.setComportamento(3);
        } else
        if (Tela.equals("TelaPerfil")) {
            if (BotoesPermitidos.isEmpty()) {
                telaPerfil.HabilitaBotoesAncestral();                  
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaPerfil.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaPerfil.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaPerfil.setHabilitaPesquisar(true);
                        telaPerfil.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaPerfil.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaPerfil.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaPerfil.setComportamento(3);
        } else
        if (Tela.equals("TelaCadastroTela")) {
            if (BotoesPermitidos.isEmpty()) {
                telaCadastroTela.HabilitaBotoesAncestral();                   
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaCadastroTela.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaCadastroTela.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaCadastroTela.setHabilitaPesquisar(true);
                        telaCadastroTela.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaCadastroTela.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaCadastroTela.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaCadastroTela.setComportamento(3);
        } else
        if (Tela.equals("TelaUsuario")) {
            if (BotoesPermitidos.isEmpty()) {
                telaUsuario.HabilitaBotoesAncestral();                  
            } else {                
                while (BotoesPermitidos.size() > cont) {
                    if (BotoesPermitidos.get(cont).equals("jbtNovo")){
                        telaUsuario.setHabilitaNovo(true);
                    } else 
                    if (BotoesPermitidos.get(cont).equals("jbtVoltar")){
                        telaUsuario.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtPesquisar")){
                        telaUsuario.setHabilitaPesquisar(true);
                        telaUsuario.setHabilitaVoltar(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtExcluir")){
                        telaUsuario.setHabilitaExcluir(true);
                    } else
                    if (BotoesPermitidos.get(cont).equals("jbtSalvar")){
                        telaUsuario.setHabilitaSalvar(true);
                    }                    
                cont++;
                }
            } telaUsuario.setComportamento(3);
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

        jdpTelas = new javax.swing.JDesktopPane();
        jtpTelas = new javax.swing.JTabbedPane();
        jmbPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jdpTelas.setPreferredSize(new java.awt.Dimension(800, 800));
        jdpTelas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jdpTelasComponentResized(evt);
            }
        });

        jtpTelas.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jtpTelas.setBounds(0, 0, 900, 450);
        jdpTelas.add(jtpTelas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jdpTelas, java.awt.BorderLayout.CENTER);

        jmbPrincipal.setName("jmbPrincipal"); // NOI18N
        jmbPrincipal.add(jMenu1);

        setJMenuBar(jmbPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jdpTelasComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jdpTelasComponentResized
jtpTelas.setSize(jdpTelas.getSize());
}//GEN-LAST:event_jdpTelasComponentResized

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
   setLogSaida();
   Log.Gravar();
}//GEN-LAST:event_formWindowClosed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
   setLogSaida();
   Log.Gravar();
}//GEN-LAST:event_formWindowClosing

private void setLogSaida(){
    Log.setOperacao("Saida");
    Log.setUsuario(UsuarioSistema.getUsuarioConectado());
    Log.setLogVinculado(UsuarioSistema.getidLogEntrada());
    GregorianCalendar data = new GregorianCalendar();
    Log.setHorario(new Timestamp(data.getTimeInMillis()));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JDesktopPane jdpTelas;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JTabbedPane jtpTelas;
    // End of variables declaration//GEN-END:variables

}
