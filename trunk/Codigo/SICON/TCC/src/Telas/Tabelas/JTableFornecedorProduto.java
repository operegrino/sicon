/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableFornecedorProduto extends AbstractTableModel{
    
    private Vector ListaFornecedorProduto;
    
    public JTableFornecedorProduto(Vector Lista){
        ListaFornecedorProduto = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaFornecedorProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Fornecedor";
        } else   
        if (col == 1) {
            return "Produto";
        } else 
        if (col == 2) {
            return "Tipo do Fornecedor";            
        } else 
        if (col == 3) {
            return "Codigo Fornecedor";            
        } else 
        if (col == 4) {
            return "Temperatura de Entrega";
        } else return "";          
    }
    


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Vector)ListaFornecedorProduto.get(rowIndex)).get(1); 
        } else
        if (columnIndex == 1) {            
            return ((Vector)ListaFornecedorProduto.get(rowIndex)).get(3); 
        } else
        if (columnIndex == 2) {            
            return ((Vector)ListaFornecedorProduto.get(rowIndex)).get(6); 
        } else
        if (columnIndex == 3) {            
            return ((Vector)ListaFornecedorProduto.get(rowIndex)).get(4); 
        } else
        if (columnIndex == 4) {            
            return ((Vector)ListaFornecedorProduto.get(rowIndex)).get(5); 
        } return ""; 
            
        
    }
}
