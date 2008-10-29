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
public class JTableEmail extends AbstractTableModel{
    
    private List ListaEmail;
    
    public JTableEmail(List Lista){
        ListaEmail = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaEmail.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int col) {
            return "Email";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (ListaEmail.get(0) instanceof Object[]){
            return ((Object[])ListaEmail.get(rowIndex))[3];       
        } else                  
            return ((Vector)ListaEmail.get(rowIndex)).get(3);              
    }

}
