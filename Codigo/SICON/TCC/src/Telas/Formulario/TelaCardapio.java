/*
 * TelaCardapio.java
 *
 * Created on 21 de Agosto de 2008, 20:54
 */

package Telas.Formulario;

import Controller.ControllerCardapio;
import Telas.Formulario.*;
import Telas.Tabelas.JTableCardapio;
import Telas.Tabelas.JTableCardapioFicha;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TelaCardapio extends TelaAncestral implements InterfacePadraoAcessoOutrasTelasPesquisa{
    
    private JButton jbtGerarCardapio;
    private TelaOrdemEPedido telaOrdemEPedido;
    //private JDesktopPane TelaPrincipal;    
    private boolean HabilitaGerar;
    private TelaRefeicao telaRefeicao;
    private TelaFichaTecnica telaFichaTecnica;
    private ArrayList ListaFichaTecnica;
    private Vector ListaCardapio;
    private ControllerCardapio Controller;
    private TelaCardapioGerado telaCardapioGerado;
    
    /** Creates new form BeanForm */
    public TelaCardapio() {
        initComponents();
        IniciarTela();
    }
    
    @Override
    public void IniciarTela() {
        setPanelTela(this.jpnPesquisa, this.jpnCadastro, this.jpnTela);
        super.setTitulo("Cardápio");        
        super.setComportamentoPanel(0);
        super.setComportamentoPanel(1); 
        criarBotaoGerarCardapio();   
        ListaFichaTecnica = new ArrayList();
        ListaCardapio = new Vector();
        Controller = new ControllerCardapio();
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
        //if (super.VerificaCampos(jpnCadastro,1)) {
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
            //} else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(1), "SICON", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png")); 
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
        ListaCardapio = Controller.EventoPesquisarVector(ListaParametros);
        if (!(ListaCardapio.isEmpty())){
            Achou = true;
        } else JOptionPane.showMessageDialog(null, Controller.RetornaMensagem(7), "SICON", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Pesquisar.png"));             
        jtbCardapio.setModel(new JTableCardapio(ListaCardapio)); 
        return Achou;
    }    
    
    public void setHabilitaGerar(boolean acesso) {
        this.HabilitaGerar = acesso;
    }
    
    private void criarBotaoGerarCardapio(){
        jbtGerarCardapio = new JButton("Gerar");
        jbtGerarCardapio.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\Selecionar.png"));
        jbtGerarCardapio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);        
        jbtGerarCardapio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtGerarCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGerarCardapioActionPerformed(evt);
            }

        });        
        super.tbAncestral.add(jbtGerarCardapio);
    }

     private void jbtGerarCardapioActionPerformed(ActionEvent evt) {
         StringBuffer sbProblemas = new StringBuffer();
         ArrayList listaCardapio = new ArrayList(100);
         for (Iterator<Vector> it = ListaCardapio.iterator(); it.hasNext();) {
             Vector vetorCardapio = it.next();
             try {
                 if ((Boolean) vetorCardapio.get(0)) {
                     listaCardapio.add(Controller.GerarCardapio((Integer) vetorCardapio.get(1)));
                 }
             } catch (Exception e) {
                 sbProblemas.append(", " + vetorCardapio.get(1).toString());                 
                 System.out.println(e.getMessage());
                 e.printStackTrace();
             }
         }
         telaCardapioGerado = new TelaCardapioGerado();
         //telaOrdemEPedido.setTipoVisualizacao(1);
         super.CriarTelaInterna(telaCardapioGerado);
         /*JInternalFrame TelaInterna = new JInternalFrame();
         //TelaInterna = super.CarregarTelaInterna("Ordem e Pedido");
         CarregarTela(TelaInterna);
         //super.BloqueiaTela();
             try {
                 TelaInterna.setSelected(true);
                 //telaAuxiliar = new TelaAuxiliar(telaCargo, jtfPesqDescricao2);
             } catch (PropertyVetoException ex) {
                 Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
             }   */             
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
        jtfData = new javax.swing.JFormattedTextField();
        jlb1Data = new javax.swing.JLabel();
        jlb1Refeicao = new javax.swing.JLabel();
        jtfRefeicao = new javax.swing.JTextField();
        jbtRefeicao = new javax.swing.JButton();
        jlb1FichaTecnica = new javax.swing.JLabel();
        jlb1QtdeRefeicao = new javax.swing.JLabel();
        jtfQtdeRefeicoes = new javax.swing.JTextField();
        jbtAdicionar = new javax.swing.JButton();
        jbtExcluirFicha = new javax.swing.JButton();
        jlb1Codigo = new javax.swing.JLabel();
        jpnSepara = new javax.swing.JPanel();
        jlbMEnu = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbCardapioFicha = new javax.swing.JTable();
        jbtFichaTecnica = new javax.swing.JButton();
        jtfFichaTecnica = new javax.swing.JTextField();
        edDescRefeicao = new javax.swing.JTextField();
        jtfIdCardapio = new javax.swing.JTextField();
        edDescFichaTecnica = new javax.swing.JTextField();
        jbtNovoFicha = new javax.swing.JButton();
        jpnPesquisa = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfCodigoPesq = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        MaskFormatter Mask = null;
        try{
            Mask = new MaskFormatter("##/##/####");
        } catch (java.text.ParseException ex){}
        jtfDataPesq = new javax.swing.JFormattedTextField(Mask);
        jtfRefeicaoPesq = new javax.swing.JTextField();
        jbtRefeicaoPesq = new javax.swing.JButton();
        jtfFichaTecnicaPesq = new javax.swing.JTextField();
        jbtFichaTecnicaPesq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCardapio = new javax.swing.JTable();

        jpnTela.setName("jpnTela"); // NOI18N
        jpnTela.setLayout(new java.awt.BorderLayout());

        jpnCadastro.setBackground(new java.awt.Color(243, 243, 243));
        jpnCadastro.setName("jpnCadastro"); // NOI18N

        jtfData.setName("jtfData"); // NOI18N

        jlb1Data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Data.setText("* Data");
        jlb1Data.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlb1Data.setName("jlb1Data"); // NOI18N

        jlb1Refeicao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Refeicao.setText("* Refeição");
        jlb1Refeicao.setName("jlb1Refeicao"); // NOI18N

        jtfRefeicao.setName("jtfRefeicao"); // NOI18N

        jbtRefeicao.setText("jButton1");
        jbtRefeicao.setName("jbtRefeicao"); // NOI18N
        jbtRefeicao.setPreferredSize(new java.awt.Dimension(4, 19));
        jbtRefeicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtRefeicaoMousePressed(evt);
            }
        });

        jlb1FichaTecnica.setText("* Ficha Técnica");
        jlb1FichaTecnica.setName("jlb1FichaTecnica"); // NOI18N

        jlb1QtdeRefeicao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1QtdeRefeicao.setText("* Qtde Refeições");
        jlb1QtdeRefeicao.setName("jlb1QtdeRefeicao"); // NOI18N

        jtfQtdeRefeicoes.setText("300");
        jtfQtdeRefeicoes.setName("jtfQtdeRefeicoes"); // NOI18N
        jtfQtdeRefeicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQtdeRefeicoesActionPerformed(evt);
            }
        });

        jbtAdicionar.setText("Adicionar");
        jbtAdicionar.setName("jbtAdicionar"); // NOI18N
        jbtAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtAdicionarMousePressed(evt);
            }
        });

        jbtExcluirFicha.setText("Excluir");
        jbtExcluirFicha.setName("jbtExcluirFicha"); // NOI18N

        jlb1Codigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb1Codigo.setText("Código");
        jlb1Codigo.setName("jlb1Codigo"); // NOI18N

        jpnSepara.setBackground(new java.awt.Color(0, 0, 0));
        jpnSepara.setName("jpnSepara"); // NOI18N
        jpnSepara.setPreferredSize(new java.awt.Dimension(250, 2));

        javax.swing.GroupLayout jpnSeparaLayout = new javax.swing.GroupLayout(jpnSepara);
        jpnSepara.setLayout(jpnSeparaLayout);
        jpnSeparaLayout.setHorizontalGroup(
            jpnSeparaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        jpnSeparaLayout.setVerticalGroup(
            jpnSeparaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jlbMEnu.setText("Menu");
        jlbMEnu.setName("jlbMEnu"); // NOI18N

        jtbCardapioFicha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Ficha Tecnica"
            }
        ));
        jtbCardapioFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbCardapioFichaMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jtbCardapioFicha);

        jbtFichaTecnica.setText("jButton1");
        jbtFichaTecnica.setName("jbtFichaTecnica"); // NOI18N
        jbtFichaTecnica.setPreferredSize(new java.awt.Dimension(4, 19));
        jbtFichaTecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFichaTecnicaMousePressed(evt);
            }
        });

        jtfFichaTecnica.setName("jtfFichaTecnica"); // NOI18N

        edDescRefeicao.setBackground(new java.awt.Color(204, 204, 204));
        edDescRefeicao.setEditable(false);
        edDescRefeicao.setFont(new java.awt.Font("Arial", 1, 11));
        edDescRefeicao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescRefeicao.setName("edDescRefeicao"); // NOI18N

        jtfIdCardapio.setBackground(new java.awt.Color(204, 204, 204));
        jtfIdCardapio.setEditable(false);
        jtfIdCardapio.setFont(new java.awt.Font("Arial", 1, 11));
        jtfIdCardapio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfIdCardapio.setName("jtfIdCardapio"); // NOI18N

        edDescFichaTecnica.setBackground(new java.awt.Color(204, 204, 204));
        edDescFichaTecnica.setEditable(false);
        edDescFichaTecnica.setFont(new java.awt.Font("Arial", 1, 11));
        edDescFichaTecnica.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edDescFichaTecnica.setName("edDescFichaTecnica"); // NOI18N

        jbtNovoFicha.setText("Novo");
        jbtNovoFicha.setName("jbtNovoFicha"); // NOI18N
        jbtNovoFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtNovoFichaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jpnSepara, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCadastroLayout.createSequentialGroup()
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlb1Data)
                                    .addComponent(jlb1Codigo)
                                    .addComponent(jlb1Refeicao)
                                    .addComponent(jlb1FichaTecnica))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                                        .addComponent(jtfRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(edDescRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jbtExcluirFicha, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jbtNovoFicha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jbtAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                                .addComponent(jtfFichaTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jbtFichaTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(edDescFichaTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfIdCardapio, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jtfData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlb1QtdeRefeicao)
                                        .addGap(7, 7, 7)
                                        .addComponent(jtfQtdeRefeicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jlbMEnu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(484, 484, 484))))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfIdCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb1QtdeRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfQtdeRefeicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addComponent(jlb1Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jlb1Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb1Refeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edDescRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jlbMEnu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnSepara, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFichaTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtFichaTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edDescFichaTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnCadastroLayout.createSequentialGroup()
                                .addComponent(jbtAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtNovoFicha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtExcluirFicha))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnCadastroLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jlb1FichaTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jpnTela.add(jpnCadastro, java.awt.BorderLayout.CENTER);

        jpnPesquisa.setName("jpnPesquisa"); // NOI18N
        jpnPesquisa.setPreferredSize(new java.awt.Dimension(100, 210));
        jpnPesquisa.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Código");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Data");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jtfCodigoPesq.setName("jtfCodigoPesq"); // NOI18N

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Refeição");

        jLabel15.setText("Ficha Técnica");

        jtfDataPesq.setName("jtfDataPesq"); // NOI18N

        jtfRefeicaoPesq.setName("jtfRefeicaoPesq"); // NOI18N

        jbtRefeicaoPesq.setText("jButton1");
        jbtRefeicaoPesq.setName("jbtRefeicaoPesq"); // NOI18N
        jbtRefeicaoPesq.setPreferredSize(new java.awt.Dimension(4, 19));
        jbtRefeicaoPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtRefeicaoPesqMousePressed(evt);
            }
        });

        jtfFichaTecnicaPesq.setName("jtfFichaTecnicaPesq"); // NOI18N

        jbtFichaTecnicaPesq.setText("jButton1");
        jbtFichaTecnicaPesq.setName("jbtFichaTecnicaPesq"); // NOI18N
        jbtFichaTecnicaPesq.setPreferredSize(new java.awt.Dimension(4, 19));
        jbtFichaTecnicaPesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtFichaTecnicaPesqMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDataPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jtfRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfFichaTecnicaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtFichaTecnicaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(776, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCodigoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jtfDataPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtRefeicaoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfFichaTecnicaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtFichaTecnicaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jpnPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jtbCardapio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Refeição", "Data", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbCardapio.setName("jtbCardapio"); // NOI18N
        jtbCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCardapioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCardapio);

        jpnPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpnTela.add(jpnPesquisa, java.awt.BorderLayout.PAGE_START);

        getPanelAncestralCriado().add(jpnTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void jtfQtdeRefeicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQtdeRefeicoesActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtfQtdeRefeicoesActionPerformed

private void jbtRefeicaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRefeicaoMousePressed
    InstaciaTelaRefeicao();
}//GEN-LAST:event_jbtRefeicaoMousePressed

private void InstaciaTelaRefeicao(){
    telaRefeicao = new TelaRefeicao(); 
    telaRefeicao.setTipoVisualizacao(1); 
    telaRefeicao.SetTelaCardapio(this);
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

private void jbtFichaTecnicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFichaTecnicaMousePressed
    InstaciaTelaFicha();
}//GEN-LAST:event_jbtFichaTecnicaMousePressed

private void InstaciaTelaFicha(){
    telaFichaTecnica = new TelaFichaTecnica(); 
    telaFichaTecnica.setTipoVisualizacao(1); 
    telaFichaTecnica.setTelaCardapio(this);
    super.TituloTela = "Ficha Técnica";
    telaFichaTecnica.setDesktopPane(super.TelaPrincipal);
    super.CriarTelaInterna(telaFichaTecnica);
}

public void SetarCamposFicha(Integer Id, String Descricao){
    if (super.getLocalizacao() == 1) {
        jtfFichaTecnica.setText(String.valueOf(Id));
        edDescFichaTecnica.setText(Descricao);
    } else jtfFichaTecnicaPesq.setText(String.valueOf(Id));
}

private void jbtAdicionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdicionarMousePressed
    ArrayList Lista = new ArrayList();
    Lista.add(jtfFichaTecnica.getText());
    Lista.add(edDescFichaTecnica.getText());    
    if (jbtAdicionar.getText().equals("Adicionar")) {
        ListaFichaTecnica.add(Lista);
    } else {
        ListaFichaTecnica.set(jtbCardapioFicha.getSelectedRow(), Lista);
    }
    setarTituloAdicionar(0);
    AtualizarJtableFicha();
}//GEN-LAST:event_jbtAdicionarMousePressed

private void jbtNovoFichaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNovoFichaMousePressed
    LimparCamposFicha();
}//GEN-LAST:event_jbtNovoFichaMousePressed

private void jtbCardapioFichaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCardapioFichaMouseReleased
    if ((evt.getClickCount() == 2) && (evt.getButton() == 1)) {
        jtfFichaTecnica.setText(((Object[])ListaFichaTecnica.get(jtbCardapioFicha.getSelectedRow()))[0].toString());
        edDescFichaTecnica.setText(((Object[])ListaFichaTecnica.get(jtbCardapioFicha.getSelectedRow()))[1].toString());        
    }
}//GEN-LAST:event_jtbCardapioFichaMouseReleased

private void jtbCardapioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCardapioMousePressed
    if ((evt.getClickCount() == 2) && (evt.getButton() == 1)) {
        ControllerParaTela(Controller.EventoSelecionar(RetornaId(jtbCardapio.getSelectedRow())));
        super.ComportamentoSelecionar();
    }
}//GEN-LAST:event_jtbCardapioMousePressed

private void jbtRefeicaoPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRefeicaoPesqMousePressed
    InstaciaTelaRefeicao();
}//GEN-LAST:event_jbtRefeicaoPesqMousePressed

private void jbtFichaTecnicaPesqMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFichaTecnicaPesqMousePressed
    InstaciaTelaFicha();
}//GEN-LAST:event_jbtFichaTecnicaPesqMousePressed

private void LimparCamposFicha(){
    jtfFichaTecnica.setText("");
    edDescFichaTecnica.setText("");
}
private void setarTituloAdicionar(int Tipo){
    if (Tipo == 0) {
        jbtAdicionar.setText("Adicionar");
    } else {
        jbtAdicionar.setText("Salvar");
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edDescFichaTecnica;
    private javax.swing.JTextField edDescRefeicao;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtAdicionar;
    private javax.swing.JButton jbtExcluirFicha;
    private javax.swing.JButton jbtFichaTecnica;
    private javax.swing.JButton jbtFichaTecnicaPesq;
    private javax.swing.JButton jbtNovoFicha;
    private javax.swing.JButton jbtRefeicao;
    private javax.swing.JButton jbtRefeicaoPesq;
    private javax.swing.JLabel jlb1Codigo;
    private javax.swing.JLabel jlb1Data;
    private javax.swing.JLabel jlb1FichaTecnica;
    private javax.swing.JLabel jlb1QtdeRefeicao;
    private javax.swing.JLabel jlb1Refeicao;
    private javax.swing.JLabel jlbMEnu;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnPesquisa;
    private javax.swing.JPanel jpnSepara;
    private javax.swing.JPanel jpnTela;
    private javax.swing.JTable jtbCardapio;
    private javax.swing.JTable jtbCardapioFicha;
    private javax.swing.JFormattedTextField jtfCodigoPesq;
    private javax.swing.JFormattedTextField jtfData;
    private javax.swing.JFormattedTextField jtfDataPesq;
    private javax.swing.JTextField jtfFichaTecnica;
    private javax.swing.JTextField jtfFichaTecnicaPesq;
    private javax.swing.JTextField jtfIdCardapio;
    private javax.swing.JTextField jtfQtdeRefeicoes;
    private javax.swing.JTextField jtfRefeicao;
    private javax.swing.JTextField jtfRefeicaoPesq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDesktopPane(JDesktopPane Pane) {
        super.TelaPrincipal = Pane;
    }

    //@Override
    public void SetArraySelecionar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public void CarregarTela(JInternalFrame Frame) {
        telaOrdemEPedido.setVisible(true);
        //telaContatoFornecedor.setJTextRetorno(jtfTela);
        telaOrdemEPedido.setFrameInterno(Frame);
        Frame.add(telaOrdemEPedido);
        TelaPrincipal.add(Frame);
        Frame.setVisible(true);    
    }

    @Override
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal) {
            setPanelFilha(jpnPesquisa, jpnCadastro, jpnPrincipal);
    }

    @Override
    public ArrayList<String> setParametros() {
        ArrayList ListaParametros = new ArrayList();
        if (!(jtfCodigoPesq.getText().equals(""))){
            ListaParametros.add("cardapio");
            ListaParametros.add(jtfCodigoPesq.getText());
        } 
        if (!(jtfRefeicaoPesq.getText().equals(""))) {
            ListaParametros.add("refeicao");
            ListaParametros.add(jtfRefeicaoPesq.getText());
        }
        if (!(jtfDataPesq.getText().trim().equals("/  /"))){
            ListaParametros.add("data");
            ListaParametros.add(jtfDataPesq.getText());
        }
        if (!(jtfFichaTecnicaPesq.getText().equals(""))) {
            ListaParametros.add("fichatecnica");
            ListaParametros.add(jtfFichaTecnicaPesq.getText());
        } 
        return ListaParametros;
    }

    @Override
    public int RetornaId(int Linha) {
        return Integer.parseInt(((Vector)ListaCardapio.get(Linha)).get(1).toString());
    }

    @Override
    public ArrayList<Object> TelaParaController() {
        ArrayList Lista = new ArrayList();
        Lista.add(jtfData.getText());
        Lista.add(jtfQtdeRefeicoes.getText());
       Lista.add(jtfRefeicao.getText());
        Lista.add(ListaFichaTecnica);
        return Lista;
    }

    @Override
    public void ControllerParaTela(ArrayList<Object> Objeto) {
        jtfIdCardapio.setText(Objeto.get(0).toString());
        jtfData.setText(Objeto.get(1).toString());
        jtfQtdeRefeicoes.setText(Objeto.get(2).toString());
        jtfRefeicao.setText(Objeto.get(3).toString());
        edDescRefeicao.setText(Objeto.get(4).toString());  
        ListaFichaTecnica = ((ArrayList)Objeto.get(5));
        AtualizarJtableFicha();
    }

    public void AtualizarJtableFicha(){
        jtbCardapioFicha.setModel(new JTableCardapioFicha(ListaFichaTecnica));
    }
    @Override
    public void setComponenteTable(boolean Acesso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
