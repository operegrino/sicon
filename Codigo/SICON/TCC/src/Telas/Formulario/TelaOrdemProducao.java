/*
 * TelaOrdemProducao.java
 *
 * Created on 30 de Setembro de 2008, 23:56
 */

package Telas.Formulario;

import Classes.Funcoes;
import Controller.ControllerOrdemProducao;
import Telas.Tabelas.JTableOrdemProducao;
import Telas.Tabelas.JTableOrdemProduto;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author  Jonathan
 */
public class TelaOrdemProducao extends TelaAncestral implements InterfacePadraoAcessoOutrasTelasPesquisa{

    //Botões
    private JButton jbtExecutar;
    private JButton jbtCancelar;
    private Vector ListaOrdemProducao;
    private Integer idOrdemProducao;
    private Integer idOrdemProduto;
    private Integer idProduto;
    private TelaRefeicao telaRefeicao;
    private TelaProduto telaProduto;
    private ControllerOrdemProducao Controller;
    private Vector ListaUnidade;
    private Vector ListaOrigens;
    private Vector ListaSituacoes;
    private ArrayList ListaProduto;
    private ArrayList ListaProdutoNovo;
    private ArrayList ListaProdutoAlterar;
    private ArrayList ListaProdutoExcluir;
    private Integer idSituacao;
    private Integer idOrigem;
    private Integer Posicao;
    private Integer idProdutoSelCadastro;
    
    /** Creates new form BeanForm */
    public TelaOrdemProducao() {
        initComponents(); 
        IniciarTela();
    }
    

    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Ordem de Produção");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1);    
        ListaOrdemProducao = new Vector();
        idOrdemProducao = 0;
        idProduto = 0;
        idOrdemProduto = 0;
        idOrigem = 1;
        idProdutoSelCadastro = 0;
        idSituacao = 1;
        Controller = new ControllerOrdemProducao();
        ListaUnidade = new Vector();
        ListaOrigens = new Vector();
        ListaSituacoes = new Vector();
        CarregarCombosUnidades();
        ListaProduto = new ArrayList();
        jtbOrdemProducao.setModel(new JTableOrdemProducao(ListaOrdemProducao));
        ListaProdutoNovo = new ArrayList();
        ListaProdutoAlterar = new ArrayList();
        ListaProdutoExcluir = new ArrayList();
        Posicao = -1;
        super.visibilidadeExcluir(false);
        CriarBotoes();
        CarregaListaPesquisaOrigem();
        CarregaListaPesquisaSItuacao();
    }    
    
    private void CriarBotoes(){
        Icon iconeRealizar;
        iconeRealizar = new ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\selecionar.png");                
        jbtExecutar = new JButton("Executar", iconeRealizar);
        jbtExecutar.setToolTipText("Efetuar a baixa do estoque");
        jbtExecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);        
        jbtExecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);        
        super.tbAncestral.add(jbtExecutar);     
        jbtExecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtRealizarMousePressed(evt);
            }
        });        
        Icon iconeCancelar;
        iconeCancelar = new ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png");        
        jbtCancelar = new JButton("Cancelar", iconeCancelar);
        jbtCancelar.setToolTipText("Cancelar uma ordem de produção");
        jbtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);        
        jbtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);        
        super.tbAncestral.add(jbtCancelar);
        jbtCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtCancelarMousePressed(evt);
            }
        });           
    }
    
    
    /* Executar a baixa no estoque referente 
     * a ordem de produção
    */ 
    public void jbtRealizarMousePressed(java.awt.event.MouseEvent evt){
        ArrayList ListaErro = Controller.BaixaOrdem(RetornaIdSelecionados());
        if (ListaErro.isEmpty()){
            Mensagens.ExibirMensagem(16);
        } else {
            String idErro = SeparaProblemas(ListaErro, 1);
            String idRealizada = SeparaProblemas(ListaErro, 2);
            String idCancelada = SeparaProblemas(ListaErro, 3);
            String Mens = "";
            if (!(idErro.equals(""))) {
                Mens = Mens + "As ordens de produção" + idErro + " apresentaram problemas na execução da baixa.";
            }
            if (!(idRealizada.equals(""))) {
                Mens = Mens + "As ordens de produção" + idRealizada + " estão com a situação realizada.";
            }
            if (!(idCancelada.equals(""))) {
                Mens = Mens + "As ordens de produção" + idCancelada + " estão com a situação cancelada.";
            }
            Mensagens.ExibirMensagemPersonalizada(Mens, 1);
        }
        ComportamentoPesquisar();
    } 
    
    public String SeparaProblemas(ArrayList ListaProblemas, int tipoproblema){
        String id = "";
        for (Iterator<ArrayList> it = ListaProblemas.iterator(); it.hasNext();) {
            ArrayList Lista = it.next();
            if ((Integer)Lista.get(1) == tipoproblema) {
                id = id + ", " + Lista.get(0).toString();
            }
        }
        if (id.equals("")){
            return id;
        } else {
            return id.substring(1, id.length());
        }
    }
    
    public ArrayList RetornaIdSelecionados(){
        ArrayList ListaSelecionados = new ArrayList();
        for (Iterator<Vector> it = ListaOrdemProducao.iterator(); it.hasNext();) {
            Vector Lista = it.next();
            if ((Boolean)Lista.get(0) == true ) {
                ListaSelecionados.add((Integer)Lista.get(1));
            }
        }
        return ListaSelecionados;
    }
    /* Alterar a situação da ordem de produção para cancelada,
     * e retirar do saldo os saldos comprometidos
    */
    public void jbtCancelarMousePressed(java.awt.event.MouseEvent evt){
        ArrayList ListaErro = Controller.CancelarOrdem(RetornaIdSelecionados());
        if (ListaErro.isEmpty()){
            Mensagens.ExibirMensagem(16);
        } else {
            String idErro = SeparaProblemas(ListaErro, 1);
            String idCancelada = SeparaProblemas(ListaErro, 3);
            String Mens = "";
            if (!(idErro.equals(""))) {
                Mens = Mens + "As ordens de produção" + idErro + " apresentaram problemas no cancelamento.";
            }
            if (!(idCancelada.equals(""))) {
                Mens = Mens + "As ordens de produção" + idCancelada + " estão com a situação cancelada.";
            }
            Mensagens.ExibirMensagemPersonalizada(Mens, 1);
        }
        ComportamentoPesquisar();        
    }      
    
    public void CarregaListaPesquisaOrigem(){
        ListaOrigens = Controller.EventoRetornaTodasOrigens();
        Vector v = new Vector();  
        v.add("Todas");
        for (Iterator<Object[]> it = ListaOrigens.iterator(); it.hasNext();) {
            Object[] Lista = it.next();
            v.add((String)Lista[1]);            
        }
        jcbOrigem.setModel(new DefaultComboBoxModel(v));        
    }
    
    public void CarregaListaPesquisaSItuacao(){
        ListaSituacoes = Controller.EventoRetornaTodasSituacoes();
        Vector v = new Vector();  
        v.add("Todas");
        for (Iterator<Object[]> it = ListaSituacoes.iterator(); it.hasNext();) {
            Object[] Lista = it.next();
            v.add((String)Lista[1]);            
        }
        jcbSituacao.setModel(new DefaultComboBoxModel(v));
    }    
    
    public void CarregaListasUnidades(){
        ListaUnidade = Controller.EventoRetornaTodasUnidades();
    }    
    
    public void CarregarCombosUnidades(){
        CarregaListasUnidades();
        Vector v = new Vector();
        for (Iterator<Object[]> it = ListaUnidade.iterator(); it.hasNext();) {
            Object[] object = it.next();
            v.add(object[1]);
        }
        jcbUnidade.setModel(new DefaultComboBoxModel(v));
    }   
    
     /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {       
            if (super.getLocalizacao() == 0) { {
                //if (Controller.EventoExcluir(RetornaId(jtbProduto.getSelectedRow()))) {
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
        boolean Gravou =  Gravar();
        if (Gravou) {
            LimparListas();
            AlterarSituacaoProdutos();
            ListaProduto = Controller.RetornaProduto(idOrdemProducao);
            AtualizaListasETabela(ListaProduto);
        } 
        return Gravou;
    }  
    
    private void AlterarSituacaoProdutos(){
        for (Iterator<ArrayList> it = ListaProduto.iterator(); it.hasNext();) {
            ArrayList object = it.next();
            object.set(6, 1);           
        }
    }
    
    
    private boolean Gravar(){
        boolean Gravou = false;
        if (super.VerificaCampos(jpnCadastro,1)) {
          if (!(ListaProduto.isEmpty())) {
                if (super.Operacao == 0) {                                 
                    if (Controller.EventoSalvaOrdemEProducao(TelaParaController(), ListaProdutoNovo, ListaProdutoAlterar, ListaProdutoExcluir)) {                    
                        JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(2), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));             
                        Gravou = true;
                        idOrdemProducao = Controller.retornaIdRecemSalvo();
                    } else
                        JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png")); 
                } else if (super.Operacao == 1) {
                    if (Controller.EventoAlterarOrdemEProduto(TelaParaController(), ListaProdutoNovo, ListaProdutoAlterar, ListaProdutoExcluir)) {                    
                        JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(4), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png")); 
                        Gravou = true;
                    } else 
                        JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(3), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));                      
                    }
          } else Mensagens.ExibirMensagem(15);
       } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png")); 
        return Gravou;        
    } 

    @Override
    protected void ComportamentoNovo() {
        LimparFormulario(jpnCadastro);     
        jcbUnidade.setSelectedIndex(0);        
        SetarComportamentoInicial();
        PermitirEdicaoTela(true);        
        LimparListas();
        ListaProduto.clear();
        jtbOrdemProduto.setModel(new JTableOrdemProduto(ListaProduto));
        edCodigo.setText(String.valueOf(Controller.RetornaProximoId()));
    }
    
    public void LimparListas(){
        ListaProdutoAlterar.clear();
        ListaProdutoExcluir.clear();
        ListaProdutoNovo.clear();
    }
    
    private void zerarIds(){
        idProduto = 0;
        idOrdemProducao = 0;
        idOrigem = 1;
        idSituacao = 1;        
    }
    
    private void SetarComportamentoInicial(){
        zerarIds();
        edDescOrigem.setText("Manual");
        edDescSituacao.setText("Aberto");
    }

    @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = new ArrayList();
        ListaParametros = setParametros();
        ListaOrdemProducao = (Vector) Controller.EventoPesquisar(ListaParametros);
        if (!(ListaOrdemProducao.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbOrdemProducao.setModel(new JTableOrdemProducao(ListaOrdemProducao));
        jtbOrdemProducao.getColumnModel().getColumn(0).setPreferredWidth(10);
        return Achou;
    }        
    
    private Integer RetornaIdUnidade(){
        return (Integer)((Object[])ListaUnidade.get(jcbUnidade.getSelectedIndex()))[0];
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
        jlb1Data = new javax.swing.JLabel();
        jlb2Produto = new javax.swing.JLabel();
        jlbSituacao = new javax.swing.JLabel();
        jlb2Qtde = new javax.swing.JLabel();
        jtfQtde = new javax.swing.JTextField();
        jlb1Setor = new javax.swing.JLabel();
        MaskFormatter Mask = null;
        try{
            Mask = new MaskFormatter("##/##/####");
        } catch (java.text.ParseException ex){}
        jftData = new javax.swing.JFormattedTextField(Mask);
        jtfSetor = new javax.swing.JFormattedTextField();
        jlb1Motivo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaMotivo = new javax.swing.JTextArea();
        jlb0Prod = new javax.swing.JLabel();
        jpnProduto = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbOrdemProduto = new javax.swing.JTable();
        jbtAdicionar = new javax.swing.JButton();
        jlb0Codigo = new javax.swing.JLabel();
        jbtExcluirProduto = new javax.swing.JButton();
        jlbOrigem = new javax.swing.JLabel();
        jlb1Refeicao = new javax.swing.JLabel();
        jtfProduto = new javax.swing.JTextField();
        jbtProduto = new javax.swing.JButton();
        jcbUnidade = new javax.swing.JComboBox();
        jlbUnidade = new javax.swing.JLabel();
        jtfRefeicao = new javax.swing.JTextField();
        jbtRefeicao = new javax.swing.JButton();
        edDescRefeicao = new javax.swing.JTextField();
        edDescOrigem = new javax.swing.JTextField();
        edDescSituacao = new javax.swing.JTextField();
        edCodigo = new javax.swing.JTextField();
        edDescProduto = new javax.swing.JTextField();
        jbtNovoProduto = new javax.swing.JButton();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jcbOrigem = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jtfSetorPesq = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jcbSituacao = new javax.swing.JComboBox();
        MaskFormatter Mask2 = null;
        try{
            Mask2 = new MaskFormatter("##/##/####");
        } catch (java.text.ParseException ex){}
        jftDataPesq = new javax.swing.JFormattedTextField(Mask2);
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtfMotivoPesq = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jtfRefeicaoPesq = new javax.swing.JTextField();
        jbtRefeicaoPesq = new javax.swing.JButton();
        jtfProdutoPesq = new javax.swing.JTextField();
        jbtProdutoPesq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbOrdemProducao = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jlb1Data.setText("* Data"); // NOI18N
        jlb1Data.setName("jlb1Data"); // NOI18N

        jlb2Produto.setText("* Produto"); // NOI18N
        jlb2Produto.setName("jlb2Produto"); // NOI18N

        jlbSituacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbSituacao.setText("Situação"); // NOI18N
        jlbSituacao.setName("jlbSituacao"); // NOI18N

        jlb2Qtde.setText("* Qtde"); // NOI18N
        jlb2Qtde.setName("jlb2Qtde"); // NOI18N

        jtfQtde.setColumns(6);
        jtfQtde.setName("jtfQtde"); // NOI18N

        jlb1Setor.setText("* Setor"); // NOI18N
        jlb1Setor.setName("jlb1Setor"); // NOI18N

        jftData.setName("jftData"); // NOI18N

        jtfSetor.setName("jtfSetor"); // NOI18N

        jlb1Motivo.setText("* Motivo"); // NOI18N
        jlb1Motivo.setName("jlb1Motivo"); // NOI18N

        jtaMotivo.setColumns(20);
        jtaMotivo.setRows(5);
        jtaMotivo.setName("jtaMotivo"); // NOI18N
        jScrollPane2.setViewportView(jtaMotivo);

        jlb0Prod.setText("Itens"); // NOI18N
        jlb0Prod.setName("jlb0Prod"); // NOI18N

        jpnProduto.setBackground(new java.awt.Color(200, 199, 190));
        jpnProduto.setName("jpnProduto"); // NOI18N
        jpnProduto.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jpnProdutoLayout = new javax.swing.GroupLayout(jpnProduto);
        jpnProduto.setLayout(jpnProdutoLayout);
        jpnProdutoLayout.setHorizontalGroup(
            jpnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        jpnProdutoLayout.setVerticalGroup(
            jpnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jtbOrdemProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produto", "Qtde"
            }
        ));
        jtbOrdemProduto.setName("jtbOrdemProduto"); // NOI18N
        jtbOrdemProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbOrdemProdutoMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtbOrdemProduto);

        jbtAdicionar.setText("Adicionar"); // NOI18N
        jbtAdicionar.setName("jbtAdicionar"); // NOI18N
        jbtAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarMousePressed(evt);
            }
        });

        jlb0Codigo.setText("* Código"); // NOI18N
        jlb0Codigo.setName("jlb0Codigo"); // NOI18N

        jbtExcluirProduto.setText("Excluir  "); // NOI18N
        jbtExcluirProduto.setName("jbtExcluirProduto"); // NOI18N
        jbtExcluirProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtExcluirProdutoMousePressed(evt);
            }
        });
        jbtExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirProdutoActionPerformed(evt);
            }
        });

        jlbOrigem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbOrigem.setText("Origem"); // NOI18N
        jlbOrigem.setName("jlbOrigem"); // NOI18N

        jlb1Refeicao.setText("* Refeição"); // NOI18N
        jlb1Refeicao.setName("jlb1Refeicao"); // NOI18N

        jtfProduto.setColumns(6);
        jtfProduto.setName("jtfProduto"); // NOI18N

        jbtProduto.setText("jButton1"); // NOI18N
        jbtProduto.setName("jbtProduto"); // NOI18N
        jbtProduto.setPreferredSize(new java.awt.Dimension(73, 21));
        jbtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtProdutoMousePressed(evt);
            }
        });

        jcbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KG" }));
        jcbUnidade.setName("jcbUnidade"); // NOI18N
        jcbUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUnidadeActionPerformed(evt);
            }
        });

        jlbUnidade.setText("Unidade"); // NOI18N
        jlbUnidade.setName("jlbUnidade"); // NOI18N

        jtfRefeicao.setColumns(6);
        jtfRefeicao.setName("jtfRefeicao"); // NOI18N

        jbtRefeicao.setText("jButton1"); // NOI18N
        jbtRefeicao.setName("jbtRefeicao"); // NOI18N
        jbtRefeicao.setPreferredSize(new java.awt.Dimension(73, 21));
        jbtRefeicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtRefeicaoMousePressed(evt);
            }
        });

        edDescRefeicao.setBackground(new java.awt.Color(204, 204, 204));
        edDescRefeicao.setEditable(false);
        edDescRefeicao.setFont(new java.awt.Font("Arial", 1, 11));
        edDescRefeicao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescRefeicao.setName("edDescRefeicao"); // NOI18N

        edDescOrigem.setBackground(new java.awt.Color(204, 204, 204));
        edDescOrigem.setEditable(false);
        edDescOrigem.setFont(new java.awt.Font("Arial", 1, 11));
        edDescOrigem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescOrigem.setName("edDescOrigem"); // NOI18N

        edDescSituacao.setBackground(new java.awt.Color(204, 204, 204));
        edDescSituacao.setEditable(false);
        edDescSituacao.setFont(new java.awt.Font("Arial", 1, 11));
        edDescSituacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescSituacao.setName("edDescSituacao"); // NOI18N

        edCodigo.setBackground(new java.awt.Color(204, 204, 204));
        edCodigo.setEditable(false);
        edCodigo.setFont(new java.awt.Font("Arial", 1, 11));
        edCodigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edCodigo.setName("edCodigo"); // NOI18N

        edDescProduto.setBackground(new java.awt.Color(204, 204, 204));
        edDescProduto.setEditable(false);
        edDescProduto.setFont(new java.awt.Font("Arial", 1, 11));
        edDescProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescProduto.setName("edDescProduto"); // NOI18N

        jbtNovoProduto.setText("Novo"); // NOI18N
        jbtNovoProduto.setName("jbtNovoProduto"); // NOI18N
        jbtNovoProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtNovoProdutoMousePressed(evt);
            }
        });
        jbtNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb0Codigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb1Data, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb1Refeicao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb1Setor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb1Motivo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb2Produto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb2Qtde, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jftData)
                            .addComponent(edCodigo)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jtfRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edDescSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edDescOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(edDescRefeicao, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addComponent(jtfSetor, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtExcluirProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtNovoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edDescProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jtfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbUnidade)
                        .addGap(1, 1, 1)
                        .addComponent(jcbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(151, 151, 151))
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addComponent(jlb0Prod))
                .addGap(136, 136, 136))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jlb0Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlb1Data, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jftData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edDescOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edDescSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlb1Refeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edDescRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb1Setor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jlb1Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jlb0Prod))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlb2Qtde))
                            .addComponent(jlbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jbtAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtNovoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtExcluirProduto))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jlb2Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 250));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        jLabel12.setText("Origem"); // NOI18N

        jcbOrigem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KG" }));
        jcbOrigem.setName("jcbOrigem"); // NOI18N
        jcbOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOrigemActionPerformed(evt);
            }
        });

        jLabel5.setText(" Produto"); // NOI18N

        jtfSetorPesq.setName("jtfSetorPesq"); // NOI18N

        jLabel17.setText(" Setor"); // NOI18N

        jLabel18.setText(" Situação"); // NOI18N

        jcbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KG" }));
        jcbSituacao.setName("jcbSituacao"); // NOI18N
        jcbSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSituacaoActionPerformed(evt);
            }
        });

        jftDataPesq.setName("jftDataPesq"); // NOI18N

        jLabel16.setText("Refeição"); // NOI18N

        jLabel15.setText(" Data"); // NOI18N

        jtfMotivoPesq.setName("jtfMotivoPesq"); // NOI18N

        jLabel19.setText("Motivo"); // NOI18N

        jtfRefeicaoPesq.setColumns(6);
        jtfRefeicaoPesq.setName("jtfRefeicaoPesq"); // NOI18N

        jbtRefeicaoPesq.setText("jButton1"); // NOI18N
        jbtRefeicaoPesq.setName("jbtRefeicaoPesq"); // NOI18N
        jbtRefeicaoPesq.setPreferredSize(new java.awt.Dimension(73, 21));
        jbtRefeicaoPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtRefeicaoPesqMousePressed(evt);
            }
        });

        jtfProdutoPesq.setColumns(6);
        jtfProdutoPesq.setName("jtfProdutoPesq"); // NOI18N

        jbtProdutoPesq.setText("jButton1"); // NOI18N
        jbtProdutoPesq.setName("jbtProdutoPesq"); // NOI18N
        jbtProdutoPesq.setPreferredSize(new java.awt.Dimension(73, 21));
        jbtProdutoPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtProdutoPesqMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfSetorPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addComponent(jtfMotivoPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
                .addGap(352, 352, 352))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jftDataPesq)
                    .addComponent(jcbSituacao, 0, 86, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtProdutoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jcbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftDataPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfSetorPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfMotivoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jtbOrdemProducao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Nº Ordem de Produção", "Data", "Refeição", "Setor", "Motivo", "Origem", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbOrdemProducao.setName("jtbOrdemProducao"); // NOI18N
        jtbOrdemProducao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbOrdemProducaoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbOrdemProducao);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jtbOrdemProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbOrdemProdutoMousePressed
if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {  
        jbtAdicionar.setText("Salvar");
        Posicao = jtbOrdemProduto.getSelectedRow();
        LimparCamposProduto();
        ListaParaProduto();
    }
}//GEN-LAST:event_jtbOrdemProdutoMousePressed

private void LimparCamposProduto(){
    jtfProduto.setText("");
    edDescProduto.setText("");
    jtfQtde.setText("");
    jcbUnidade.setSelectedIndex(1);
    idProdutoSelCadastro = 0;
    idOrdemProduto = 0;
}

private void ListaParaProduto(){
    int Linha = jtbOrdemProduto.getSelectedRow();
    idOrdemProduto = Integer.parseInt(((ArrayList)ListaProduto.get(Linha)).get(0).toString());
    jtfProduto.setText(((ArrayList)ListaProduto.get(Linha)).get(2).toString());
    edDescProduto.setText(((ArrayList)ListaProduto.get(Linha)).get(3).toString());
    idProduto = Integer.parseInt(((ArrayList)ListaProduto.get(Linha)).get(1).toString());
    idProdutoSelCadastro = Integer.parseInt(((ArrayList)ListaProduto.get(Linha)).get(1).toString());
    jtfQtde.setText(((ArrayList)ListaProduto.get(Linha)).get(4).toString());
    idOrdemProducao = Integer.parseInt((((ArrayList)ListaProduto.get(Linha)).get(6).toString()));     
    jcbUnidade.setSelectedIndex(RetornaIdUnidade());
}

private void jbtAdicionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarMousePressed
    AdicionarProduto();
}//GEN-LAST:event_jbtAdicionarMousePressed

private void jbtExcluirProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirProdutoMousePressed
    ExcluirProduto();
}//GEN-LAST:event_jbtExcluirProdutoMousePressed

private void ExcluirProduto(){
    int PosNovo = Funcoes.RetornaPosicaoArray(ListaProdutoNovo, 1, (((ArrayList)ListaProduto.get(jtbOrdemProduto.getSelectedRow())).get(1)));    
    int PosAlterar = Funcoes.RetornaPosicaoArray(ListaProdutoAlterar, 1, (((ArrayList)ListaProduto.get(jtbOrdemProduto.getSelectedRow())).get(1)));    
    if (PosNovo >=0 ){
        ListaProdutoNovo.remove(PosNovo);        
    } else if (PosAlterar >=0) {
        ListaProdutoAlterar.remove(PosAlterar);
        ListaProdutoExcluir.add(Integer.parseInt(((ArrayList)ListaProduto.get(jtbOrdemProduto.getSelectedRow())).get(0).toString()));                 
    } else {
        ListaProdutoExcluir.add(Integer.parseInt(((ArrayList)ListaProduto.get(jtbOrdemProduto.getSelectedRow())).get(0).toString()));                 
    }
    ListaProduto.remove(jtbOrdemProduto.getSelectedRow());         
    jtbOrdemProduto.setModel(new JTableOrdemProduto(ListaProduto));
}


private void jbtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirProdutoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtExcluirProdutoActionPerformed

private void jbtProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoMousePressed
InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoMousePressed

private void InstaciaTelaProduto(){
    telaProduto = new TelaProduto(); 
    telaProduto.setTipoVisualizacao(1); 
    telaProduto.setTelaOrdemProducao(this);
    super.TituloTela = "Produto";
    telaProduto.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaProduto);
}

public void SetarCamposProduto(Integer Id, String Codigo, String Descricao){
    if (super.getLocalizacao() == 1){
        jtfProduto.setText(Codigo);
        idProduto = Id;
        edDescProduto.setText(Descricao);
    } else {
       jtfProdutoPesq.setText(Codigo); 
    }
}

private void jcbUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUnidadeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbUnidadeActionPerformed

private void jbtRefeicaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRefeicaoMousePressed
InstaciaTelaRefeicao();
}//GEN-LAST:event_jbtRefeicaoMousePressed

private void InstaciaTelaRefeicao(){
    telaRefeicao = new TelaRefeicao(); 
    telaRefeicao.setTipoVisualizacao(1); 
    telaRefeicao.setTelaOrdemProducao(this);
    super.TituloTela = "Refeição";
    telaRefeicao.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaRefeicao);
}

public void SetarCamposRefeicao(Integer Id, String Descricao){
    if (super.getLocalizacao() == 1) {
        jtfRefeicao.setText(String.valueOf(Id));
        edDescRefeicao.setText(Descricao);
    } else jtfRefeicaoPesq.setText(String.valueOf(Id));
}

private void jbtNovoProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNovoProdutoMousePressed
    LimparCamposProduto();
    idProduto = 0;
}//GEN-LAST:event_jbtNovoProdutoMousePressed

private void jbtNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoProdutoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtNovoProdutoActionPerformed

private void jcbOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOrigemActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbOrigemActionPerformed

private void jcbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSituacaoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jcbSituacaoActionPerformed

private void jbtRefeicaoPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRefeicaoPesqMousePressed
    InstaciaTelaRefeicao();
}//GEN-LAST:event_jbtRefeicaoPesqMousePressed

private void jbtProdutoPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoPesqMousePressed
    InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoPesqMousePressed

private void jtbOrdemProducaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbOrdemProducaoMousePressed
    if ((evt.getClickCount()==2) & (evt.getButton()== MouseEvent.BUTTON1)) {
            if (super.getTipoVisualizacao() == 0) {
                LimparFormulario(jpnCadastro);
                ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbOrdemProducao.getSelectedRow())));
                super.ComportamentoSelecionar();
            }
        }     
}//GEN-LAST:event_jtbOrdemProducaoMousePressed

private void AdicionarProduto() {
    //if (super.VerificaCampos(jpnCadastro, 2)) {
    /* 0 = idOrdemProduto;
     * 1 = idProduto;
     * 2 = codigoproduto
     * 3 = descricao produto
     * 4 = quantidade produto
     * 5 = idunidademedida
     * 6 = idordemproducao
     */
        ArrayList Lista = new ArrayList();
           Lista.add(idOrdemProduto);
           Lista.add(idProduto);
           Lista.add(jtfProduto.getText());
           Lista.add(edDescProduto.getText());
           Lista.add(jtfQtde.getText());
           Lista.add(RetornaIdUnidade()); 
           Lista.add(idOrdemProducao);      
        if (Posicao >= 0){      
           if (idOrdemProduto != 0) {
               int Pos = Funcoes.RetornaPosicaoArray(ListaProdutoAlterar, 0, idOrdemProduto);
               if (Pos >= 0) {
                   ListaProdutoAlterar.set(Pos,Lista);
               } else {
                   ListaProdutoAlterar.add(Lista);    
               }               
               ListaProduto.set(Posicao, Lista);
           } else {
               Integer Pos = Funcoes.RetornaPosicaoArray(ListaProdutoNovo, 1, idProdutoSelCadastro);
               ListaProdutoNovo.set(Pos, Lista);
               ListaProduto.set(Posicao, Lista);    
           }                                   
        } else {
           ListaProdutoNovo.add(Lista);           
           ListaProduto.add(Lista);
        }
           idProduto = 0;
           Posicao = -1;
           idOrdemProduto = 0;
           idProdutoSelCadastro = 0;
           jbtAdicionar.setText("Adicionar");
           jtbOrdemProduto.setModel(new JTableOrdemProduto(ListaProduto));
    //}
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edCodigo;
    private javax.swing.JTextField edDescOrigem;
    private javax.swing.JTextField edDescProduto;
    private javax.swing.JTextField edDescRefeicao;
    private javax.swing.JTextField edDescSituacao;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtAdicionar;
    private javax.swing.JButton jbtExcluirProduto;
    private javax.swing.JButton jbtNovoProduto;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JButton jbtProdutoPesq;
    private javax.swing.JButton jbtRefeicao;
    private javax.swing.JButton jbtRefeicaoPesq;
    private javax.swing.JComboBox jcbOrigem;
    private javax.swing.JComboBox jcbSituacao;
    private javax.swing.JComboBox jcbUnidade;
    private javax.swing.JFormattedTextField jftData;
    private javax.swing.JFormattedTextField jftDataPesq;
    private javax.swing.JLabel jlb0Codigo;
    private javax.swing.JLabel jlb0Prod;
    private javax.swing.JLabel jlb1Data;
    private javax.swing.JLabel jlb1Motivo;
    private javax.swing.JLabel jlb1Refeicao;
    private javax.swing.JLabel jlb1Setor;
    private javax.swing.JLabel jlb2Produto;
    private javax.swing.JLabel jlb2Qtde;
    private javax.swing.JLabel jlbOrigem;
    private javax.swing.JLabel jlbSituacao;
    private javax.swing.JLabel jlbUnidade;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnProduto;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTextArea jtaMotivo;
    private javax.swing.JTable jtbOrdemProducao;
    private javax.swing.JTable jtbOrdemProduto;
    private javax.swing.JFormattedTextField jtfMotivoPesq;
    private javax.swing.JTextField jtfProduto;
    private javax.swing.JTextField jtfProdutoPesq;
    private javax.swing.JTextField jtfQtde;
    private javax.swing.JTextField jtfRefeicao;
    private javax.swing.JTextField jtfRefeicaoPesq;
    private javax.swing.JFormattedTextField jtfSetor;
    private javax.swing.JFormattedTextField jtfSetorPesq;
    // End of variables declaration//GEN-END:variables

   @Override
    public void setDesktopPane(JDesktopPane Pane) {
        super.setDesktopPane(Pane);
    }

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
            setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        ArrayList<String> ListaParametros = new ArrayList<String>();
        if (!(jtfProdutoPesq.getText().equals(""))){
            ListaParametros.add("produto");
            ListaParametros.add(jtfProdutoPesq.getText());            
        }
        if (!(jtfRefeicaoPesq.getText().equals(""))){
            ListaParametros.add("refeicao");
            ListaParametros.add(jtfRefeicaoPesq.getText());            
        }        
        if (jcbOrigem.getSelectedIndex() != 0){
            ListaParametros.add("origem");
            ListaParametros.add(((Object[])ListaOrigens.get(jcbOrigem.getSelectedIndex() - 1))[0].toString());            
        }
        if (jcbSituacao.getSelectedIndex() != 0){
            ListaParametros.add("situacao");
            ListaParametros.add(((Object[])ListaSituacoes.get(jcbSituacao.getSelectedIndex() - 1))[0].toString());            
        }
        if (!(jftDataPesq.getText().trim().equals("/  /"))){
            ListaParametros.add("data");
            ListaParametros.add(jftDataPesq.getText());
        }   
        if (!(jtfSetorPesq.getText().equals(""))){
            ListaParametros.add("setor");
            ListaParametros.add(jtfSetorPesq.getText());            
        }    
        if (!(jtfMotivoPesq.getText().equals(""))){
            ListaParametros.add("motivo");
            ListaParametros.add(jtfMotivoPesq.getText());            
        }    
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Vector)ListaOrdemProducao.get(Linha)).get(1).toString());
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add("");
        Lista.add(jftData.getText());
        Lista.add(jtfRefeicao.getText()); 
        Lista.add(idOrigem);
        Lista.add(idSituacao);
        Lista.add(jtfSetor.getText());
        Lista.add(jtaMotivo.getText());
        return Lista;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        idOrdemProducao = Integer.parseInt(Objeto.get(0).toString());
        edCodigo.setText(Objeto.get(0).toString());
        jftData.setText(Objeto.get(1).toString());
        jtfRefeicao.setText(Objeto.get(2).toString());
        edDescRefeicao.setText(Objeto.get(3).toString());
        idOrigem = Integer.parseInt(Objeto.get(4).toString());
        edDescOrigem.setText(Objeto.get(5).toString());
        idSituacao = Integer.parseInt(Objeto.get(6).toString());
        edDescSituacao.setText(Objeto.get(7).toString());
        jtfSetor.setText(Objeto.get(8).toString());
        jtaMotivo.setText(Objeto.get(9).toString());  
        AtualizaListasETabela((ArrayList)Objeto.get(10));
        if (idSituacao != 1) {
            PermitirEdicaoTela(false);
        } else PermitirEdicaoTela(true);
    }
    
    public void PermitirEdicaoTela(boolean Permissao){
        for (Component obj: jpnCadastro.getComponents()){
            if (obj instanceof JTable) {
                ((JTable)obj).setEnabled(Permissao);
            } else if (obj instanceof JTextArea) {
                ((JTextArea)obj).setEnabled(Permissao);
            } else obj.setEnabled(Permissao);
        }
    }

    public void AtualizaListasETabela(ArrayList Lista){
        LimparListas();
        ListaProduto = Lista;
        jtbOrdemProduto.setModel(new JTableOrdemProduto(ListaProduto));        
    }
    
    @Override
    public void setComponenteTable(boolean Acesso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
}




