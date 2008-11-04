/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.Funcoes;
import Telas.Componentes.TelaInterna;
import Telas.Formulario.TelaMotivo;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jonathan
 */
public class ColunaBotao extends AbstractCellEditor
                         implements TableCellEditor, TableCellRenderer,
                                    ActionListener {
    
    private JButton botaoRender;
    private JButton botaoEditor;
    private JButton botaoSelecionado;
    private JPanel tela;
    private JTable table;
    private int Linha;
    protected static final String EDIT = "edit";
    private TelaInterna telaInterna;
    private JDesktopPane TelaPrincipal;
    public String idMotivo;
    public String Descricao;
    public Vector listaAvaliacao;
    public Boolean Origem;
    
    public ColunaBotao(JTable tabela, int Coluna, JPanel tela, JDesktopPane telaPrincipal, Vector lista) {
        
        super();
        listaAvaliacao = lista;
        this.table = tabela;
        this.TelaPrincipal = telaPrincipal;
        this.tela = tela;
        botaoRender = new JButton();
        botaoSelecionado = new JButton();
        Origem = false;
        
        idMotivo = "";
        Descricao = "";

        botaoEditor = new JButton();
        botaoEditor.setFocusPainted(false);
        botaoEditor.addActionListener(this);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(Coluna).setCellRenderer(this);
        columnModel.getColumn(Coluna).setCellEditor(this);
        
        /*//antigo
        this.tela = tela;
        //Criando o botão
        botao = new JButton();
        botao.setActionCommand(EDIT);
        botao.addActionListener(this);     */
    }

public void actionPerformed(ActionEvent e) {
        //if (EDIT.equals(e.getActionCommand())) {
            //The user has clicked the cell, so
            //bring up the dialog.            
            Origem = true;
            EscreverMetodosAbstratosTelasInternas();
             //Make the renderer reappear.

        //}
    }

public void setidBotao(String id, String Descricao){
    /*botaoEditor.setText(id);
    botaoEditor.setToolTipText(Descricao);*/
    botaoRender.setText(id);
    botaoRender.setToolTipText(Descricao);
    botaoEditor.setText(id);
    idMotivo = id;
    this.Descricao = Descricao;
    fireEditingStopped();
}

    //Implement the one CellEditor method that AbstractCellEditor doesn't.
    public Object getCellEditorValue() {
        return botaoEditor.getText();
    }

    //Implement the one method defined by TableCellEditor.
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row,
                                                 int column) {
        Linha = row;
        System.out.println(String.valueOf(row) + String.valueOf(column));
        return botaoEditor;
    }

    public JButton getBotaoSelecionado() {
        return botaoSelecionado;
    }

    public void setBotaoSelecionado(JButton botaoSelecionado) {
        this.botaoSelecionado = botaoSelecionado;
    }
    
   private void EscreverMetodosAbstratosTelasInternas() {
        telaInterna = new TelaInterna(){

            @Override
            public void EventoFechar() {
                
            }

            @Override
            public void EventoAbrir() {
                
            }
        };
        telaInterna.setTitle("Motivo");
        telaInterna.setResizable(true);
        telaInterna.setClosable(true);
        telaInterna.setMaximizable(false);
        telaInterna.setIconifiable(false);
        telaInterna.setSize(700,600);
        telaInterna.setLocation(Funcoes.CentralizarFrame(telaInterna.getSize())); 
        ((TelaMotivo)tela).setFrameInterno(telaInterna);
        telaInterna.add(((JPanel)tela));
        TelaPrincipal.add(telaInterna);
        telaInterna.setVisible(true);           
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        System.out.println("Row : " + String.valueOf(row) + " Col : " + String.valueOf(column) + " Valor : " + ((JButton)value).getText());
        if (hasFocus) {
            //botaoRender.setForeground(table.getForeground());
            //botaoRender.setBackground(UIManager.getColor("Button.background"));
            //botaoRender.setForeground(Color.BLACK);
            //botaoRender.setBackground(Color.WHITE);
            ((JButton) value).setForeground(Color.BLACK);
            ((JButton) value).setBackground(Color.WHITE);
        } else if (isSelected) { 
            //botaoRender.setForeground(table.getSelectionForeground());
            //botaoRender.setBackground(table.getSelectionBackground());
            //botaoRender.setForeground(Color.BLACK);
            //botaoRender.setBackground(Color.WHITE);
            ((JButton) value).setForeground(Color.BLACK);
            ((JButton) value).setBackground(Color.WHITE);
        } else {
            // botaoRender.setForeground(table.getForeground());
            //botaoRender.setBackground(UIManager.getColor("Button.background"));
            ((JButton) value).setForeground(Color.BLACK);
            ((JButton) value).setBackground(Color.WHITE);
        //botaoRender.setForeground(Color.BLACK);
        //botaoRender.setBackground(Color.WHITE);
        }

        if (!((JButton) value).getText().trim().equals("")) {
            ((JButton) value).setText(((JButton) value).getText());
            ((JButton) value).setToolTipText(((JButton) value).getToolTipText());
        } else {
            ((JButton) value).setText("");
            ((JButton) value).setToolTipText("");
        }
        if ((row == Linha) && (Origem)) {
            ((JButton) value).setText(idMotivo);
            ((JButton) value).setToolTipText(Descricao);
            ((JButton)((Vector)listaAvaliacao.get(row)).get(9)).setText(idMotivo);
        }
        return ((JButton) value);
    }

}

