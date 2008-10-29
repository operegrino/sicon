/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableFichaTecnicaItens extends AbstractTableModel{
    

    private ArrayList ListaItens = new ArrayList();    
    
    
    public JTableFichaTecnicaItens(ArrayList Dados) {
        ListaItens = Dados;        
    }

    public int getRowCount() {
        return ListaItens.size();
    }

    public int getColumnCount() {
        return 4;
    }
    
    public String getColumnName(int col) {
        if (col == 0) {
            return "Produto";
        } else
        if (col == 1) {
            return "Peso bruto";
        } else
        if (col == 2) {
            return "Peso liquido";
        } else
        if (col == 3) {
            return "Fator de correção";
        } else
            return "";
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((ArrayList)ListaItens.get(rowIndex)).get(2); 
        } else
        if (columnIndex == 1) {            
            return ((ArrayList)ListaItens.get(rowIndex)).get(3); 
        } else
        if (columnIndex == 2) {            
            return ((ArrayList)ListaItens.get(rowIndex)).get(4); 
        } else
        if (columnIndex == 3) {            
            return ((ArrayList)ListaItens.get(rowIndex)).get(5); 
        } else return "";
            
    }
}