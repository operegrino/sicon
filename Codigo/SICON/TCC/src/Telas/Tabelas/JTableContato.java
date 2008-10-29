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
public class JTableContato extends AbstractTableModel{
    
    private Vector ListaContato = new Vector();    
    
    
    public JTableContato(Vector Dados) {
        ListaContato = Dados;        
    }

    public int getRowCount() {
        return ListaContato.size();
    }

    public int getColumnCount() {
        return 3;
    }
    
    public String getColumnName(int col) {
            if (col==0) {
                return "Fornecedor";
            } else
            if (col==1) {
                    return "Contato";
            } else
            if (col==2) {
                    return "Tipo";
            } else return ""; 
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0) {
          return ((Vector)ListaContato.get(rowIndex)).get(1);
        } else
        if (columnIndex==1) { 
            if (((Vector)ListaContato.get(rowIndex)).get(2).equals("")){
                return ((Vector)ListaContato.get(rowIndex)).get(3);                        
            } else 
            return ((Vector)ListaContato.get(rowIndex)).get(2) + "-" + 
                   ((Vector)ListaContato.get(rowIndex)).get(3);
        }
        if (columnIndex==2) {
            return ((Vector)ListaContato.get(rowIndex)).get(5);
        }
        else return null;
    }
}
