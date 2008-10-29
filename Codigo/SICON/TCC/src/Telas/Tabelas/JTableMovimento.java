/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.Funcoes;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableMovimento extends AbstractTableModel{
    
    private Vector ListaBanco;
    
    public JTableMovimento(Vector Lista){
        ListaBanco = Lista;        
    }
    
    @Override
    public int getRowCount() {
        return ListaBanco.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "Nº do Movimento";
        } else 
        if (col == 1) {
            return "Data";
        } else
        if (col == 2) {
            return "Produto";
        } else
        if (col == 3) {
            return "Qtde";
        } else
        if (col == 4) {
            return "Operação";
        } else return "Motivo";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {            
            return ((Vector)ListaBanco.get(rowIndex)).get(0); 
        } else
        if (columnIndex == 1) {            
            return Funcoes.FormataDataPadrao((Date)((Vector)ListaBanco.get(rowIndex)).get(4)); 
        } else
        if (columnIndex == 2) {            
            return ((Vector)ListaBanco.get(rowIndex)).get(2); 
        } else
        if (columnIndex == 3) {            
            return (((Vector)ListaBanco.get(rowIndex)).get(3).toString() + " " + ((Vector)ListaBanco.get(rowIndex)).get(8).toString()); 
        } else
        if (columnIndex == 4) {            
            return ((Vector)ListaBanco.get(rowIndex)).get(6); 
        } else return ((Vector)ListaBanco.get(rowIndex)).get(9);
    }
}