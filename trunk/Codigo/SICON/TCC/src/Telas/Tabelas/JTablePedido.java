/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTablePedido extends AbstractTableModel{
    
    private Vector ListaPedido = new Vector();

    public JTablePedido(Vector Dados) {
        ListaPedido = Dados;
        //InsereCheckBox();
    }

    @Override
    public int getRowCount() {
        return ListaPedido.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
        return "";
        } else 
        if (col == 1) {
        return "Nº Pedido";
        } else
        if (col == 2) {
        return "Fornecedor";
        } else
        if (col == 3) {
        return "Data";
        } else
        if (col == 4) {
        return "Situacao";
        } else return "";
    }    
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        ((Vector)ListaPedido.get(row)).set(col, value);
        fireTableCellUpdated(row, col);
    }
    

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (columnIndex == 0) {
           return (Boolean)((Vector)ListaPedido.get(rowIndex)).get(0);
       } else 
       if (columnIndex == 1) {
           return ((Vector)ListaPedido.get(rowIndex)).get(1).toString();
       } else
       if (columnIndex == 2) {
           return ((Vector)ListaPedido.get(rowIndex)).get(2).toString();
       } else
       if (columnIndex == 3) {
           return ((Vector)ListaPedido.get(rowIndex)).get(3).toString();
       } else
       if (columnIndex == 4) {
           return ((Vector)ListaPedido.get(rowIndex)).get(4).toString();
       } 
          else return "";        
    }        

}
