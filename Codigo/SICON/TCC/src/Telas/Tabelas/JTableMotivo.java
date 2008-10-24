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
public class JTableMotivo  extends AbstractTableModel{
    
    private List ListaMotivo;
    
    public JTableMotivo(List Lista){
        ListaMotivo = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaMotivo.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Nome";
        } else return "Baixar";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Object[])ListaMotivo.get(rowIndex))[1]; 
        } else
            return ((Object[])ListaMotivo.get(rowIndex))[2];       
    }
}
