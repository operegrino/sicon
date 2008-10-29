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
public class JTableFormaPagamentoFornecedor extends AbstractTableModel{
    
    private Vector ListaPagamentoFornecedor;
    
    public JTableFormaPagamentoFornecedor(Vector Lista){
        ListaPagamentoFornecedor = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaPagamentoFornecedor.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Fornecedor";
        } else return "Forma";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Vector)ListaPagamentoFornecedor.get(rowIndex)).get(1); 
        } else
            return ((Vector)ListaPagamentoFornecedor.get(rowIndex)).get(3); 
            
        
    }
}
