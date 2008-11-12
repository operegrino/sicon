/*
 * TelaPedido.java
 *
 * Created on 21 de Agosto de 2008, 20:14
 */

package Telas.Formulario;

import Classes.itempedido;
import Controller.ControllerPedido;
import Telas.Componentes.TelaInterna;
import Telas.Tabelas.JTableItemPedido;
import Telas.Tabelas.JTablePedido;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author  Jonathan
 */
public class TelaPedido extends TelaAncestral implements InterfacePadraoAcessoOutrasTelas{
    
    private JButton jbtEnviar;
    private JButton jbtBaixar;
    private TelaAvaliacaoPedido telaAvaliacaoPedido;
    private JDesktopPane TelaPrincipal; 
    private boolean HabilitaEnviar;
    private boolean HabilitaBaixar;
    private ControllerPedido Controller;
    private Integer SituacaoPedido;
    private Integer idProduto;
    private ArrayList ListaItens;
    private Vector ListaPedido;
    private TelaFornecedor telaFornecedor;
    private Integer idFornecedor;
    private Integer idPedido;
    private TelaProduto telaProduto;
    private Integer IdItemPedido;
    private JButton jbtArquivo;
    private TelaAvaliacaoPedido telaAvaliacao;

    /** Creates new form BeanForm */
    public TelaPedido() {
        initComponents();
        IniciarTela();
    }
    
    public ArrayList RetornaSelecionado(){
        ArrayList ListaSel = new ArrayList(10);
        for (Iterator<Vector> it = ListaPedido.iterator(); it.hasNext();) {
            Vector vetor = it.next();
            ArrayList Lista = new ArrayList(2);
            if ((Boolean)vetor.get(0)) {
                Lista.add((Integer)vetor.get(1));
                Lista.add((Integer)vetor.get(5));
                ListaSel.add(Lista);
            }            
        }
        return ListaSel;
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Pedido");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1); 
        criarBotaoGerarArquivo();
        criarBotaoEnviar();
        criarBotaoBaixar();       
        Controller = new ControllerPedido();
        SituacaoPedido = 0;
        ListaItens = new ArrayList();
        IdItemPedido = 0;
        idPedido = 0;
    }    
    
    public void setTelaAvaliacao(TelaAvaliacaoPedido tela) {
        this.telaAvaliacao = tela;
    }
    /*************************************************************************
     *     MÉTODOS SOBRESCRITO DA ANCESTRAL (EVENTOS DOS BOTÕES)
     ************************************************************************/ 
    @Override
    protected boolean ComportamentoExcluir() {
        boolean Excluiu = false;
        if (JOptionPane.showConfirmDialog(null, Controller.RetornaMensagem(11), "SICON", 0, 3, null) == 0) {  
            if (getLocalizacao() == 0) {                
                StringBuffer PedidoInvalido = new StringBuffer();
                StringBuffer PedidoExcluido = new StringBuffer();
                StringBuffer PedidoProblema = new StringBuffer();
                ArrayList ListaSel = RetornaSelecionado();
                for (Iterator<ArrayList> it = ListaSel.iterator(); it.hasNext();) {
                    ArrayList lista = it.next();
                    Integer id = (Integer)lista.get(0);
                    if ((Integer)lista.get(1) != 1) {
                        PedidoInvalido.append(id.toString());
                        PedidoInvalido.append(", ");
                    } else {
                        if (Controller.EventoExcluir(id)) {
                            PedidoExcluido.append(id.toString());
                            PedidoExcluido.append(", ");
                        } else {
                            PedidoProblema.append(id.toString());
                            PedidoProblema.append(", ");
                        }
                    }
                }
                if (PedidoExcluido.length() > 0) {
                    Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + PedidoExcluido.toString() + "foi(ram) excluído(s) com sucesso", 2);
                }
                if (PedidoInvalido.length() > 0) {
                    Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + PedidoInvalido.toString() + "está(ão) com a situacao diferente de aberta.", 2);
                }
                if (PedidoProblema.length() > 0) {
                    Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + PedidoProblema.toString() + "apresentou(ram) problema(s) na exclusão.", 2);
                }
            } else {
                if (Controller.EventoExcluir()) {
                    if (SituacaoPedido != 1) {
                        Mensagens.ExibirMensagem(17); 
                    } else {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(5), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));     
                    Excluiu = true;
                    this.ComportamentoPesquisar();
                } }
                else {
                    JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(6), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));
                }
            }
        }
        ComportamentoPesquisar();
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
        SelecionarPedido(idPedido);
        return Gravou;        
        }   

    @Override
    protected void ComportamentoNovo() {
        LimparFormulario(jpnCadastro);   
        SituacaoPedido = 1;
        IdItemPedido = 0;
        ListaItens.clear();
        jtfNumPedido.setText(Controller.RetornaUltimoId());
    }

    @Override
    protected boolean ComportamentoPesquisar() {
        boolean Achou = false;
        ArrayList ListaParametros = new ArrayList();
        ListaParametros = setParametros();
        ListaPedido = (Vector)Controller.EventoPesquisar(ListaParametros);
        if (!(ListaPedido.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbPedido.setModel(new JTablePedido(ListaPedido)); 
        return Achou;
    }
    
    
    public void setHabilitaEnviar(boolean acesso){
        this.HabilitaEnviar = acesso;
    }
    
    public void setHabilitabaixar(boolean acesso){
        this.HabilitaBaixar = acesso;
    }
    
    private void criarBotaoEnviar(){
        jbtEnviar = new JButton("Enviar");
        jbtEnviar.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\enviar.png"));
        jbtEnviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);        
        jbtEnviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEnviarActionPerformed(evt);
            }


        });        
        super.tbAncestral.add(jbtEnviar);     
    }   

    private void jbtEnviarActionPerformed(ActionEvent evt) {
        StringBuffer PedidoErrado = new StringBuffer();
        StringBuffer PedidoNaoEncontrado = new StringBuffer();
        StringBuffer PedidoEnviado = new StringBuffer();
        StringBuffer PedidoProblemaEnvio = new StringBuffer();        
        if (getLocalizacao() == 0) {
            ArrayList ListaSel = RetornaSelecionado();
            for (Iterator<ArrayList> it = ListaSel.iterator(); it.hasNext();) {
                ArrayList Lista = it.next();
                Integer id = (Integer)Lista.get(0);
                if ((Integer)Lista.get(1) != 1) {
                    PedidoErrado.append(id.toString());
                    PedidoErrado.append(", ");
                } else {
                    try {                                                                 
                        Controller.EventoEnviar(id);
                        PedidoEnviado.append(id.toString());    
                        PedidoEnviado.append(", ");                   
                    } 
                    catch  (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                        PedidoNaoEncontrado.append(id.toString());
                        PedidoNaoEncontrado.append(", ");
                    }
                    catch  (AddressException e) {
                        System.out.println(e.getMessage());
                        PedidoProblemaEnvio.append(id.toString());
                        PedidoProblemaEnvio.append(", ");                        
                    }
                    catch  (MessagingException e) {
                        System.out.println(e.getMessage());
                        PedidoProblemaEnvio.append(id.toString());
                        PedidoProblemaEnvio.append(", ");   
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                        PedidoProblemaEnvio.append(id.toString());
                        PedidoProblemaEnvio.append(", ");
                    }                        
                }
            }
        } else {
            try {
                Controller.EventoEnviar();    
                PedidoEnviado.append(idPedido.toString());  
            } catch (Exception e) {
                PedidoProblemaEnvio.append(idPedido.toString());
            }
        }   
        if (PedidoEnviado.length() > 0) {
            Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + PedidoEnviado.toString().substring(0, PedidoEnviado.length() - 2) + " foi(ram) enviado(s) com sucesso.", 2);            
        }
        if (PedidoNaoEncontrado.length() > 0) {
            Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + PedidoNaoEncontrado.toString().substring(0, PedidoNaoEncontrado.length() - 2) + " não foi(ram) encontrado(s).", 1);            
        }        
        if (PedidoProblemaEnvio.length() > 0) {
            Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + PedidoProblemaEnvio.toString().substring(0, PedidoProblemaEnvio.length() - 2) + " apresentou(ram) problema(s) durante o processo.", 1);            
        }
        if (PedidoErrado.length() > 0) {
            Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + PedidoErrado.toString().substring(0, PedidoErrado.length() - 2) + " já foi(ram) enviado(s) ao fornecedor", 1);            
        }
    }   
    
    private void criarBotaoGerarArquivo(){
        jbtArquivo = new JButton("Arquivo");
        jbtArquivo.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\enviar.png"));
        jbtArquivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);        
        jbtArquivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtArquivorActionPerformed(evt);
            }


        });        
        super.tbAncestral.add(jbtArquivo);     
    }   

    private void jbtArquivorActionPerformed(ActionEvent evt) {   
        StringBuffer ArquivoGerado = new StringBuffer();
        StringBuffer ArquivoErro = new StringBuffer();        
        if (getLocalizacao() == 0) {
            ArrayList ListaSel = RetornaSelecionado();
            for (Iterator<ArrayList> it = ListaSel.iterator(); it.hasNext();) {
                ArrayList Lista = it.next();
                Integer id = (Integer)Lista.get(0);
                if ((Integer)Lista.get(1) != 1) {
                    ArquivoErro.append(id.toString());
                    ArquivoErro.append(", ");
                } else {
                    try {
                        Controller.EventoCriarArquivo(id); 
                        ArquivoGerado.append(id.toString());
                        ArquivoGerado.append(", ");
                    } catch (Exception e) {
                        ArquivoErro.append(id.toString());
                        ArquivoErro.append(", ");
                    }                        
                }
            }
        } else {
            try {
                Controller.EventoEnviar();    
                ArquivoGerado.append(idPedido.toString());  
            } catch (Exception e) {
                ArquivoErro.append(idPedido.toString());
            }
        }   
        if (ArquivoGerado.length() > 0) {
            Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + ArquivoGerado.toString().substring(0, ArquivoGerado.length() - 2) + " foi(ram) gerado(s) com sucesso.", 2);            
        }
        if (ArquivoErro.length() > 0) {
            Mensagens.ExibirMensagemPersonalizada("O(s) pedido(s) " + ArquivoErro.toString().substring(0, ArquivoErro.length() - 2) + " apresentou(ram) problema(s) durante o processo.", 1);            
        }
    }           
    
    private void criarBotaoBaixar(){
        jbtBaixar = new JButton("Baixar");
        jbtBaixar.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));
        jbtBaixar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);        
        jbtBaixar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtBaixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBaixarActionPerformed(evt);
            }
        });        
        super.tbAncestral.add(jbtBaixar);
    }   

    private void jbtBaixarActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not yet implemented");
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
        jlb0Itens = new javax.swing.JLabel();
        jlb1Fornecedor = new javax.swing.JLabel();
        jlb1Data = new javax.swing.JLabel();
        jtfFornecedor = new javax.swing.JTextField();
        jtfNumPedido = new javax.swing.JTextField();
        jbtFornecedor = new javax.swing.JButton();
        jlb1PedidoNum = new javax.swing.JLabel();
        jpnDivisao = new javax.swing.JPanel();
        jlb2Qtde = new javax.swing.JLabel();
        jtfQtde = new javax.swing.JTextField();
        jlb2Produto = new javax.swing.JLabel();
        jtfProduto = new javax.swing.JTextField();
        jbtProduto = new javax.swing.JButton();
        jtfUnidade = new javax.swing.JTextField();
        jlb2Unidade = new javax.swing.JLabel();
        jbtUnidade = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbItemPedido = new javax.swing.JTable();
        jlb1Situacao = new javax.swing.JLabel();
        jpnBotoes = new javax.swing.JPanel();
        btContatos = new javax.swing.JButton();
        jbtAdicionar = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();
        edDescFornecedor = new javax.swing.JTextField();
        edDescSituacao = new javax.swing.JTextField();
        edDescProduto = new javax.swing.JTextField();
        edDescunidade = new javax.swing.JTextField();
        jbtNovo = new javax.swing.JButton();
        MaskFormatter Mask = null;
        try{
            Mask = new MaskFormatter("##/##/####");
        } catch (java.text.ParseException ex){}
        jtfData = new javax.swing.JFormattedTextField(Mask);
        jpnPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPedido = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jTextField24 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jTextField25 = new javax.swing.JTextField();

        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jlb0Itens.setText("ITENS");
        jlb0Itens.setName("jlb0Itens"); // NOI18N

        jlb1Fornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Fornecedor.setText("* Fornecedor");
        jlb1Fornecedor.setName("jlb1Fornecedor"); // NOI18N

        jlb1Data.setText("* Data");
        jlb1Data.setName("jlb1Data"); // NOI18N

        jtfFornecedor.setName("jtfFornecedor"); // NOI18N

        jtfNumPedido.setName("jtfNumPedido"); // NOI18N

        jbtFornecedor.setText("jButton1");
        jbtFornecedor.setName("jbtFornecedor"); // NOI18N
        jbtFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFornecedorMousePressed(evt);
            }
        });

        jlb1PedidoNum.setText("* Pedido Nº");
        jlb1PedidoNum.setName("jlb1PedidoNum"); // NOI18N

        jpnDivisao.setBackground(new java.awt.Color(204, 204, 204));
        jpnDivisao.setName("jpnDivisao"); // NOI18N
        jpnDivisao.setPreferredSize(new java.awt.Dimension(610, 2));

        javax.swing.GroupLayout jpnDivisaoLayout = new javax.swing.GroupLayout(jpnDivisao);
        jpnDivisao.setLayout(jpnDivisaoLayout);
        jpnDivisaoLayout.setHorizontalGroup(
            jpnDivisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        jpnDivisaoLayout.setVerticalGroup(
            jpnDivisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jlb2Qtde.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb2Qtde.setText("* Qtde");
        jlb2Qtde.setName("jlb2Qtde"); // NOI18N

        jtfQtde.setName("jtfQtde"); // NOI18N

        jlb2Produto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb2Produto.setText("* Produto");
        jlb2Produto.setName("jlb2Produto"); // NOI18N

        jtfProduto.setName("jtfProduto"); // NOI18N

        jbtProduto.setText("jButton1");
        jbtProduto.setName("jbtProduto"); // NOI18N
        jbtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtProdutoMousePressed(evt);
            }
        });

        jtfUnidade.setName("jtfUnidade"); // NOI18N

        jlb2Unidade.setText("* Unidade");
        jlb2Unidade.setName("jlb2Unidade"); // NOI18N

        jbtUnidade.setText("jButton1");
        jbtUnidade.setName("jbtUnidade"); // NOI18N
        jbtUnidade.setPreferredSize(new java.awt.Dimension(73, 19));

        jtbItemPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Produto", "Qtde", "Unidade", "Custo Unit.", "Custo Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtbItemPedido.setName("jtbItemPedido"); // NOI18N
        jtbItemPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbItemPedidoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbItemPedido);

        jlb1Situacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Situacao.setText("Situação");
        jlb1Situacao.setName("jlb1Situacao"); // NOI18N

        jpnBotoes.setBackground(new java.awt.Color(243, 243, 243));
        jpnBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnBotoes.setName("jpnBotoes"); // NOI18N

        btContatos.setText("Avaliação");
        btContatos.setToolTipText("\"Adicione telefones e e-mails do fornecedor\"");
        btContatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btContatos.setIconTextGap(1);
        btContatos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btContatosMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotoesLayout = new javax.swing.GroupLayout(jpnBotoes);
        jpnBotoes.setLayout(jpnBotoesLayout);
        jpnBotoesLayout.setHorizontalGroup(
            jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btContatos, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnBotoesLayout.setVerticalGroup(
            jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
        );

        jbtAdicionar.setText("Adicionar");
        jbtAdicionar.setName("jbtAdicionar"); // NOI18N
        jbtAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarMousePressed(evt);
            }
        });

        jbtExcluir.setText("Excluir");
        jbtExcluir.setName("jbtExcluir"); // NOI18N
        jbtExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtExcluirMousePressed(evt);
            }
        });
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        edDescFornecedor.setBackground(new java.awt.Color(204, 204, 204));
        edDescFornecedor.setEditable(false);
        edDescFornecedor.setFont(new java.awt.Font("Arial", 1, 11));
        edDescFornecedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescFornecedor.setName("edDescFornecedor"); // NOI18N

        edDescSituacao.setBackground(new java.awt.Color(204, 204, 204));
        edDescSituacao.setEditable(false);
        edDescSituacao.setFont(new java.awt.Font("Arial", 1, 11));
        edDescSituacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescSituacao.setName("edDescSituacao"); // NOI18N

        edDescProduto.setBackground(new java.awt.Color(204, 204, 204));
        edDescProduto.setEditable(false);
        edDescProduto.setFont(new java.awt.Font("Arial", 1, 11));
        edDescProduto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescProduto.setName("edDescProduto"); // NOI18N

        edDescunidade.setBackground(new java.awt.Color(204, 204, 204));
        edDescunidade.setEditable(false);
        edDescunidade.setFont(new java.awt.Font("Arial", 1, 11));
        edDescunidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescunidade.setName("edDescProduto"); // NOI18N

        jbtNovo.setText("Novo");
        jbtNovo.setName("jbtNovo"); // NOI18N
        jbtNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtNovoMousePressed(evt);
            }
        });

        jtfData.setName("jtfData"); // NOI18N

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jpnDivisao, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jlb0Itens))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlb2Produto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(jlb2Qtde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb1Fornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb1PedidoNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb1Situacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jpnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfQtde, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jtfNumPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edDescSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                                            .addComponent(edDescProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                            .addGap(17, 17, 17))
                                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jlb1Data)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnCadastroLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jlb2Unidade)
                                        .addGap(1, 1, 1)
                                        .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edDescunidade, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(934, 934, 934))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb1PedidoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlb1Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edDescSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb1Data, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edDescFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlb1Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jlb0Itens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDivisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlb2Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb2Qtde)
                    .addComponent(jtfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb2Unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edDescunidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jbtAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtExcluir))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
            .addComponent(jpnBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.LINE_END);

        jpnPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 250));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jtbPedido.setBackground(new java.awt.Color(243, 243, 243));
        jtbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pedido Num.", "Fornecedor", "Data", "Situacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbPedidoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPedido);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Pedido Nº");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Empresa");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Produto");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Situação");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton6.setText("jButton1");
        jButton6.setPreferredSize(new java.awt.Dimension(73, 19));

        jButton8.setText("jButton1");
        jButton8.setPreferredSize(new java.awt.Dimension(73, 19));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField13)
                    .addComponent(jTextField6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(670, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        jpnPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtExcluirActionPerformed

private void btContatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btContatosMousePressed
         telaAvaliacaoPedido = new TelaAvaliacaoPedido();
         //telaOrdemEPedido.setTipoVisualizacao(1);
         JInternalFrame TelaInterna = new JInternalFrame();
         //TelaInterna = super.CarregarTelaInterna("Avaliação do Pedido");
         CarregarTela(TelaInterna);
         //super.BloqueiaTela();
             try {
                 TelaInterna.setSelected(true);
                 //telaAuxiliar = new TelaAuxiliar(telaCargo, jtfPesqDescricao2);
             } catch (PropertyVetoException ex) {
                 Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
             }       
}//GEN-LAST:event_btContatosMousePressed

private void jbtAdicionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarMousePressed
    ArrayList Lista = new ArrayList();
    Lista.add(jtfQtde.getText()); // Quantidade
    Lista.add(5); // Unidade
    Lista.add("Kilograma");
    Lista.add(idProduto); // codigo Produto
    Lista.add(edDescProduto.getText());
    Lista.add(Controller.RetornaPrecoProduto(idProduto));
    Lista.add(Controller.RetornaPrecoTotal(idProduto, new BigDecimal(jtfQtde.getText())));
    Lista.add(IdItemPedido);
    Lista.add(jtfProduto.getText());
    if (IdItemPedido == 0) {
        ListaItens.add(Lista);
    } else {
        ListaItens.set(jtbItemPedido.getSelectedRow(), Lista);
    }    
    AtualizarTabelaItens();
    jbtAdicionar.setText("Adicionar");
    IdItemPedido = 0;
}//GEN-LAST:event_jbtAdicionarMousePressed

private void jbtNovoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNovoMousePressed
    LimparCamposItens();
    IdItemPedido = 0;
    AtualizarTabelaItens();
}//GEN-LAST:event_jbtNovoMousePressed

private void jbtExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExcluirMousePressed
    ListaItens.remove(jtbItemPedido.getSelectedRow());
    AtualizarTabelaItens();
}//GEN-LAST:event_jbtExcluirMousePressed

private void jbtFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFornecedorMousePressed
    InstaciaTelaFornecedor();
}//GEN-LAST:event_jbtFornecedorMousePressed

private void InstaciaTelaFornecedor(){
    telaFornecedor = new TelaFornecedor(); 
    telaFornecedor.setTipoVisualizacao(1); 
    telaFornecedor.setTelaPedido(this);
    super.TituloTela = "Fornecedor";
    telaFornecedor.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaFornecedor);
}

public void SetarCamposFornecedor(String Id, String Codigo, String Descricao){
    if (super.getLocalizacao() == 1) {
        jtfFornecedor.setText(String.valueOf(Codigo));
        edDescFornecedor.setText(Descricao);
        idFornecedor = Integer.parseInt(Id);
    } //else //jtfRefeicaoPesq.setText(String.valueOf(Id));
}

private void jbtProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProdutoMousePressed
    InstaciaTelaProduto();
}//GEN-LAST:event_jbtProdutoMousePressed

private void jtbPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPedidoMousePressed
    if ((evt.getClickCount() == 2) && (evt.getButton() == 1)) {
        if (super.getTipoVisualizacao() == 0) {
            idPedido = RetornaId(jtbPedido.getSelectedRow());
            SelecionarPedido(idPedido);
        } else if (telaAvaliacao != null) {
            telaAvaliacao.setarCampos(String.valueOf(RetornaId(jtbPedido.getSelectedRow())),
                    ((Vector) ListaPedido.get(jtbPedido.getSelectedRow())).get(4).toString(),
                    ((Vector) ListaPedido.get(jtbPedido.getSelectedRow())).get(3).toString(),
                    ((Vector) ListaPedido.get(jtbPedido.getSelectedRow())).get(2).toString());
            super.FechaFrameInterno();
        }
    }

}//GEN-LAST:event_jtbPedidoMousePressed

private void SelecionarPedido(Integer id){
    ControllerParaTela(Controller.EventoSelecionar(id));
    super.ComportamentoSelecionar();
}
private void jtbItemPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbItemPedidoMousePressed
    if ((evt.getClickCount() == 2) && (evt.getButton() == 1)) {
        idProduto = (Integer)((ArrayList)ListaItens.get(0)).get(3);
        jtfProduto.setText(((ArrayList)ListaItens.get(0)).get(8).toString());
        edDescProduto.setText(((ArrayList)ListaItens.get(0)).get(4).toString());
        jtfQtde.setText(((ArrayList)ListaItens.get(0)).get(0).toString());
        IdItemPedido = Integer.parseInt(((ArrayList)ListaItens.get(0)).get(7).toString());  
        jbtAdicionar.setText("Salvar");
    }
}//GEN-LAST:event_jtbItemPedidoMousePressed


private void InstaciaTelaProduto(){
    telaProduto = new TelaProduto(); 
    if (jtfFornecedor.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(null, "Selecione um fornecedor");    
    } else {
        telaProduto.jtfFornecedorPesq.setText(jtfFornecedor.getText());
        telaProduto.jbtFornecedorPesq.setEnabled(false);
        telaProduto.setTipoVisualizacao(1); 
        telaProduto.setTelaPedido(this);
        super.TituloTela = "Produto";
        telaProduto.setDesktopPane(super.TelaPrincipal);
        super.CriarTelaInterna(telaProduto);        
    }
    
}

public void SetarCamposProduto(String Id, String Codigo, String Descricao){
    if (super.getLocalizacao() == 1) {
        jtfProduto.setText(String.valueOf(Codigo));
        edDescProduto.setText(Descricao);
        idProduto = Integer.parseInt(Id);
    } //else //jtfRefeicaoPesq.setText(String.valueOf(Id));
}
private void LimparCamposItens(){
    jtfProduto.setText("");
    edDescProduto.setText("");
    jtfQtde.setText("");
    
}

private void AtualizarTabelaItens(){
    jtbItemPedido.setModel(new JTableItemPedido(ListaItens));;
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btContatos;
    private javax.swing.JTextField edDescFornecedor;
    private javax.swing.JTextField edDescProduto;
    private javax.swing.JTextField edDescSituacao;
    private javax.swing.JTextField edDescunidade;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton jbtAdicionar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtFornecedor;
    private javax.swing.JButton jbtNovo;
    private javax.swing.JButton jbtProduto;
    private javax.swing.JButton jbtUnidade;
    private javax.swing.JLabel jlb0Itens;
    private javax.swing.JLabel jlb1Data;
    private javax.swing.JLabel jlb1Fornecedor;
    private javax.swing.JLabel jlb1PedidoNum;
    private javax.swing.JLabel jlb1Situacao;
    private javax.swing.JLabel jlb2Produto;
    private javax.swing.JLabel jlb2Qtde;
    private javax.swing.JLabel jlb2Unidade;
    private javax.swing.JPanel jpnBotoes;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnDivisao;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbItemPedido;
    private javax.swing.JTable jtbPedido;
    private javax.swing.JFormattedTextField jtfData;
    private javax.swing.JTextField jtfFornecedor;
    private javax.swing.JTextField jtfNumPedido;
    private javax.swing.JTextField jtfProduto;
    private javax.swing.JTextField jtfQtde;
    private javax.swing.JTextField jtfUnidade;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDesktopPane(JDesktopPane Pane) {
        super.TelaPrincipal = Pane;
    }

    @Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public void CarregarTela(JInternalFrame Frame) {
        telaAvaliacaoPedido.setVisible(true);
        //telaContatoFornecedor.setJTextRetorno(jtfTela);
        telaAvaliacaoPedido.setFrameInterno(Frame);
        Frame.add(telaAvaliacaoPedido);
        TelaPrincipal.add(Frame);
        Frame.setVisible(true);        
    }

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
            setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        return new ArrayList();
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Vector)ListaPedido.get(Linha)).get(1).toString());
    }

    @Override
    public void CarregarTela(TelaInterna Frame) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(0);
        Lista.add(jtfData.getText());
        Lista.add(SituacaoPedido);
        Lista.add(jtfFornecedor.getText());
        Lista.add(ListaItens);
        return Lista;
        
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfNumPedido.setText(Objeto.get(0).toString());
        jtfData.setText(Objeto.get(1).toString());
        SituacaoPedido = (Integer)Objeto.get(2);
        edDescSituacao.setText(Objeto.get(3).toString());
        idFornecedor = (Integer)Objeto.get(4);
        jtfFornecedor.setText(Objeto.get(5).toString());
        edDescFornecedor.setText(Objeto.get(6).toString());
        ListaItens = (ArrayList)Objeto.get(7);
        jtbItemPedido.setModel(new JTableItemPedido(ListaItens));
    }

}
