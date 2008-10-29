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
public class JTableOrdemProduto extends AbstractTableModel{
    
    private ArrayList<Object> ListaOrdemProduto = new ArrayList<Object>();

    public JTableOrdemProduto(ArrayList<Object> Dados) {
        ListaOrdemProduto = Dados;
    }
    @Override
    public int getRowCount() {
        return ListaOrdemProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
        return "Produto";
        } else return "Quantidade";
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (columnIndex == 0) {
           return ((ArrayList)ListaOrdemProduto.get(rowIndex)).get(3).toString();
       } else return ((ArrayList)ListaOrdemProduto.get(rowIndex)).get(4).toString();
    }

}
