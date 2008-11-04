/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jonathan
 */
public class JTableAvaliacaoPedido extends AbstractTableModel{
    
    private Vector ListaItensPedido = new Vector();
    private JTable tab = new JTable();

    public JTableAvaliacaoPedido(Vector Dados) {
        ListaItensPedido = Dados;
        
        //InsereCheckBox();
    }
    
    @Override
    public int getRowCount() {
        return ListaItensPedido.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Adequado";
        } else if (col == 1) {
            return "Inadequado";
        } else if (col == 2) {
            return "Situação";
        } else if (col == 3) {
            return "Nº do Item";
        } else if (col == 4) {
            return "Cod. Produto";
        } else if (col == 5) {
            return "Produto";
        } else if (col == 6) {
            return "Qtde";
        } else if (col == 7) {
            return "Unidade";
        } else if (col == 8) {
            return "Motivo";
        } else {
            return "";
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if ((col == 0) || (col == 1)) {
                return true;
        } else {       
        Boolean adequado = (Boolean)((Vector)ListaItensPedido.get(row)).get(0);
        Boolean inadequado = (Boolean)((Vector)ListaItensPedido.get(row)).get(1);
        if ((!adequado) && (!inadequado)){
            return false;
        } else if (adequado) {
            return false;            
        } else if (inadequado) {
            if ((col == 2) || (col == 8)) {
                return true;
            }
        }
        }
        return false;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            ((Vector) ListaItensPedido.get(row)).set(col, value);    
            ((Vector) ListaItensPedido.get(row)).set(1, false);  
            fireTableCellUpdated(row, 1);  
            fireTableCellUpdated(row, col);   
        } else if (col == 1) { 
            ((Vector) ListaItensPedido.get(row)).set(col, value);   
            ((Vector) ListaItensPedido.get(row)).set(0, false); 
            fireTableCellUpdated(row, 0);
            fireTableCellUpdated(row, col);               
        } else if (col == 2) {
            ((Vector) ListaItensPedido.get(row)).set(8, value);
            fireTableCellUpdated(row, col);               
        } else if (col == 8) {
            //((Vector) ListaItensPedido.get(row)).set(col, value);
            //((Vector) ListaItensPedido.get(row)).set(8, ((Vector) ListaItensPedido.get(row)).get(8).toString());*/
            fireTableCellUpdated(row, 9);            
            //fireTableCellUpdated(row, 2);
        }  else {
            ((Vector) ListaItensPedido.get(row)).set(col, value);
            fireTableCellUpdated(row, col);            
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.valueOf(((Vector) ListaItensPedido.get(rowIndex)).get(0).toString());
        } else if (columnIndex == 1) {
            return Boolean.valueOf(((Vector) ListaItensPedido.get(rowIndex)).get(1).toString());
        } else if (columnIndex == 2) {
            return (((Vector) ListaItensPedido.get(rowIndex)).get(8).toString());                
        } else if (columnIndex == 3) {
            return ((Vector) ListaItensPedido.get(rowIndex)).get(2).toString();
        } else if (columnIndex == 4) {
            return ((Vector) ListaItensPedido.get(rowIndex)).get(3).toString();
        } else if (columnIndex == 5) {
            return ((Vector) ListaItensPedido.get(rowIndex)).get(4).toString();
        } else if (columnIndex == 6) {
            return ((Vector) ListaItensPedido.get(rowIndex)).get(5).toString();
        } else if (columnIndex == 7) {
            return ((Vector) ListaItensPedido.get(rowIndex)).get(6).toString();
        } else if (columnIndex == 8) {
            return ((Vector) ListaItensPedido.get(rowIndex)).get(9);/*String id = ((Vector)ListaItensPedido.get(rowIndex)).get(7).toString();
        if (!id.equals("0")) {
        return id;
        } else
        return ""; */
        } else /*if (columnIndex == 8) {
        return ((Vector)ListaItensPedido.get(rowIndex)).get(8);
        } */ {
            return "";
        }
    }
}
