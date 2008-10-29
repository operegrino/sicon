/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableItemPedido extends AbstractTableModel{
    
    private ArrayList<Object> ListaItem = new ArrayList<Object>();

    public JTableItemPedido(ArrayList<Object> Dados) {
        ListaItem = Dados;
    }
    @Override
    public int getRowCount() {
        return ListaItem.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
        return "Produto";
        } else if (col == 1) {
        return "Quantidade";
        } else if (col == 2) {
        return "Unidade";
        } else if (col == 3) {
        return "Preço Unitário";
        } else if (col == 4) {
        return "Preço Total";
        }        
        else return "";
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (columnIndex == 0) {
           return ((ArrayList)ListaItem.get(rowIndex)).get(4).toString();
       } else if (columnIndex == 1) {
           return ((ArrayList)ListaItem.get(rowIndex)).get(0).toString();
       } else if (columnIndex == 2) {
           return ((ArrayList)ListaItem.get(rowIndex)).get(2).toString();
       } else if (columnIndex == 3) {
           return ((ArrayList)ListaItem.get(rowIndex)).get(5).toString();
       } else if (columnIndex == 4) {
           return ((ArrayList)ListaItem.get(rowIndex)).get(6).toString();
       } else 
           return "";
    }

}
