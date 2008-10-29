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
 * @author jonathan
 */
public class JTableForma extends AbstractTableModel{
    
    private List ListaForma;
    
    public JTableForma(List Lista){
        ListaForma = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaForma.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int col) {
        return "Forma Pagamento";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {    
        return ((ArrayList)ListaForma.get(rowIndex)).get(1).toString(); 
    }
}
