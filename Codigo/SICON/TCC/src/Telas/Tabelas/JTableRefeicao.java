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
public class JTableRefeicao extends AbstractTableModel{
    
    private List ListaRefeicao;
    
    public JTableRefeicao(List Lista){
        ListaRefeicao = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaRefeicao.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Refeição";
        } else return "";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Object[])ListaRefeicao.get(rowIndex))[1]; 
        } else return "";            
    }
}