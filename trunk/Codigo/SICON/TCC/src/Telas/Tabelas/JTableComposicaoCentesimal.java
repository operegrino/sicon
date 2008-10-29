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
public class JTableComposicaoCentesimal extends AbstractTableModel{
    
    private Vector ListaComposicao = new Vector();    
    
    
    public JTableComposicaoCentesimal(Vector Dados) {
        ListaComposicao = Dados;        
    }

    public int getRowCount() {
        return ListaComposicao.size();
    }

    public int getColumnCount() {
        return 8;
    }
    
    public String getColumnName(int col) {
            if (col==0) {
                return "Produto";
            } else
            if (col==1) {
                return "Energia";
            } else
            if (col==2) {
                return "Carboidrato"; 
            } else            
            if (col==3) {
                return "Proteína";
            } else
            if (col==4) {
                return "Lipídeo";
            } else
            if (col==5) {
                return "Calcio";
            } else
            if (col==6) {
                return "Ferro";
            } else
            if (col==7) {
                return "Vitamina C";
            } else  return "";               
                
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0) {
            return ((Vector)ListaComposicao.get(rowIndex)).get(1);
        } else
        if (columnIndex==1) { 
            return ((Vector)ListaComposicao.get(rowIndex)).get(3);
        } else
        if (columnIndex==2) {
            return ((Vector)ListaComposicao.get(rowIndex)).get(4);
        } else
        if (columnIndex==3) {
            return ((Vector)ListaComposicao.get(rowIndex)).get(5);
        } else
        if (columnIndex==4) {
            return ((Vector)ListaComposicao.get(rowIndex)).get(6);
        } else
        if (columnIndex==5) {
            return ((Vector)ListaComposicao.get(rowIndex)).get(7);
        } else
        if (columnIndex==6) {
            return ((Vector)ListaComposicao.get(rowIndex)).get(8);
        } else
        if (columnIndex==7) {
            return ((Vector)ListaComposicao.get(rowIndex)).get(9);
        } else return null;
    }
}
