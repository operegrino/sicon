/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jonathan
 */
public class JTableFornecedor extends AbstractTableModel{

    private List ListaFornecedor;
    
    public JTableFornecedor(List Dados){
        ListaFornecedor = Dados; 
    }

    @Override
    public int getRowCount() {
        return ListaFornecedor.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
          return "Código";
        } else 
        if (col == 1) {
          return "Razão Social";
        } else 
        if (col == 2) {
          return "CPF";  
        } 
        return "Tempo de Entrega";            
    } 

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return ((Object[])ListaFornecedor.get(rowIndex))[0];            
        } else
        if (columnIndex == 1) {
            return ((Object[])ListaFornecedor.get(rowIndex))[1];            
        } else
        if (columnIndex == 2) {
            return ((Object[])ListaFornecedor.get(rowIndex))[2];             
        } else 
        if (columnIndex == 3) {
            return ((Object[])ListaFornecedor.get(rowIndex))[3];      
        } else return "";       
    }

}
