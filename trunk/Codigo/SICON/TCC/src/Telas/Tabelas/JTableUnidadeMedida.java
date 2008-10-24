/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableUnidadeMedida extends AbstractTableModel{
    
    private List ListaUnidade;
    
    public JTableUnidadeMedida(List Lista){
        ListaUnidade = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaUnidade.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int col) {
        return "Unidade";
         
                   
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {          
        return ((Object[])ListaUnidade.get(rowIndex))[1]; 
  
    }
}
