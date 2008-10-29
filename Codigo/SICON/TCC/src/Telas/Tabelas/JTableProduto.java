/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jonathan
 */
public class JTableProduto extends AbstractTableModel{
    
    private Vector ListaProduto = new Vector();    
    
    
    public JTableProduto(Vector Dados) {
        ListaProduto = Dados;        
    }

    public int getRowCount() {
        return ListaProduto.size();
    }

    public int getColumnCount() {
        return 5;
    }
    
    public String getColumnName(int col) {
            if (col==0) {
                return "Código";
            } else
            if (col==1) {
                return "Descrição";
            } else
            if (col==2) {
                return "Valor";
            } else 
            if (col==3) {
                return "Estoque mínimo"; 
            } else
            if (col==4) {
                return "Alimentar";
            } else return "";
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0) {
            return ((Vector)ListaProduto.get(rowIndex)).get(1);
        } else
        if (columnIndex==1) { 
            return ((Vector)ListaProduto.get(rowIndex)).get(2);                        
        }
        if (columnIndex==2) {
            return ((Vector)ListaProduto.get(rowIndex)).get(3);
        }
        if (columnIndex==3) {
            return ((Vector)ListaProduto.get(rowIndex)).get(4) + " " + 
                   ((Vector)ListaProduto.get(rowIndex)).get(6) ;
        }  
        if (columnIndex==4) {
            return ((Vector)ListaProduto.get(rowIndex)).get(8);                   
        }                
        else return null;
    }
}
