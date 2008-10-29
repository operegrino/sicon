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
public class JTableCardapioFicha extends AbstractTableModel{
    
    private List ListaFicha;
    
    public JTableCardapioFicha(List Lista){
        ListaFicha = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaFicha.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Ficha Técnica";
        } else return "";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((ArrayList)ListaFicha.get(rowIndex)).get(1);
        } else return "";             
    }


}
