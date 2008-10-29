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
public class JTableFichaTecnica extends AbstractTableModel{
    

    private Vector ListaFicha = new Vector();    
    
    
    public JTableFichaTecnica(Vector Dados) {
        ListaFicha = Dados;        
    }

    public int getRowCount() {
        return ListaFicha.size();
    }

    public int getColumnCount() {
        return 2;
    }
    
    public String getColumnName(int col) {
        if (col == 0) {
            return "Ficha técnia";
        } else
        if (col == 1) {
            return "Rendimento";
        } else
            return "";
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Object[])ListaFicha.get(rowIndex))[1]; 
        } else
        if (columnIndex == 1) {            
            return ((Object[])ListaFicha.get(rowIndex))[2]; 
        } else return "";
            
    }
}