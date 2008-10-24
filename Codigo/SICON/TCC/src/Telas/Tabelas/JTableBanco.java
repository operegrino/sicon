/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableBanco extends AbstractTableModel{
    
    private List ListaBanco;
    
    public JTableBanco(List Lista){
        ListaBanco = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaBanco.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Código";
        } else return "Nome";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Object[])ListaBanco.get(rowIndex))[0]; 
        } else
            return ((Object[])ListaBanco.get(rowIndex))[1];       
    }


}
