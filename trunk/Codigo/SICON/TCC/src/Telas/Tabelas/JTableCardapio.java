/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableCardapio extends AbstractTableModel{
    
    private List ListaCardapio;
    
    public JTableCardapio(List Lista){
        ListaCardapio = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaCardapio.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Código";
        } else
        if (col == 1) {
            return "Refeição";
        } else
        if (col == 2) {
            return "Data";
        } else
        if (col == 3) {
            return "Quantidade";
        } else
            return "";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Vector)ListaCardapio.get(rowIndex)).get(0); 
        } else
        if (columnIndex == 1) {            
            return ((Vector)ListaCardapio.get(rowIndex)).get(1); 
        } else
        if (columnIndex == 2) {            
            return ((Vector)ListaCardapio.get(rowIndex)).get(2); 
        } else
        if (columnIndex == 3) {            
            return ((Vector)ListaCardapio.get(rowIndex)).get(3); 
        } else return "";
                  
    }
}