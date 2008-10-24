/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.botao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableTelaBotao extends AbstractTableModel{
    
    //private Collection ListaTelaBotao = new ArrayList<Object>();
    private ArrayList<Object> ListaTelaBotao = new ArrayList<Object>();

    public JTableTelaBotao(ArrayList<Object> Dados) {
        ListaTelaBotao = Dados;
       // CarregaColecao();
    }
    
    /*public void CarregaColecao() {
        for (Iterator<String> it = ListaTelaBotao.iterator(); it.hasNext();) {
            ListaTela.add(it.next());
            }
    }*/
    @Override
    public int getRowCount() {
        return ListaTelaBotao.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
          return "Titulo";
        } else 
          return "Descrição";
          
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (columnIndex == 0) {
           return (((ArrayList)ListaTelaBotao.get(rowIndex)).get(1));
       } else               
          return (((ArrayList)ListaTelaBotao.get(rowIndex)).get(2));
    }

}
