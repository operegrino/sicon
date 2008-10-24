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
public class JTableFormaPagamento extends AbstractTableModel{
    
    private List ListaFormaPagamento;
    
    public JTableFormaPagamento(List Lista){
        ListaFormaPagamento = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaFormaPagamento.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Descrição";
        } else return "Operação bancária";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Object[])ListaFormaPagamento.get(rowIndex))[1]; 
        } else
            return ((Object[])ListaFormaPagamento.get(rowIndex))[2]; 
            
        
    }
}
