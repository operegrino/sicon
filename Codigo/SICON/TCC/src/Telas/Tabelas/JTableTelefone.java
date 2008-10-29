/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jonathan
 */
public class JTableTelefone extends AbstractTableModel{
    
    private List ListaTelefone;
    
    public JTableTelefone(List Lista){
        ListaTelefone = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaTelefone.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "DDD";
        } else if (col == 1) {
            return "Número";
        } else return "Tipo";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (ListaTelefone.get(0) instanceof Object[]){
            if (columnIndex == 0) {            
                return ((Object[])ListaTelefone.get(rowIndex))[1]; 
            } else if (columnIndex == 1) {       
                return ((Object[])ListaTelefone.get(rowIndex))[0];                   
            } else return ((Object[])ListaTelefone.get(rowIndex))[2];       
        } else 
            if (columnIndex == 0) {            
                return ((Vector)ListaTelefone.get(rowIndex)).get(2); 
            } else if (columnIndex == 1) {       
                return ((Vector)ListaTelefone.get(rowIndex)).get(3);                   
            } else return ((Vector)ListaTelefone.get(rowIndex)).get(5);                   
    }

}
