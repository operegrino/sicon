/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.tela;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jonathan
 */
public class JTableTela extends AbstractTableModel{
    
    private ArrayList<Object> ListaTela = new ArrayList<Object>();

    public JTableTela(ArrayList<Object> Dados) {
        ListaTela = Dados;
    }
    @Override
    public int getRowCount() {
        return ListaTela.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
          return "Titulo";
        } else 
        if (col == 1) {
          return "Nome";
        } else 
        return "Nome do Menu";          
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (columnIndex == 0) {
           return ((Vector)ListaTela.get(rowIndex)).get(0);
       } else        
       if (columnIndex == 1) {
          return ((Vector)ListaTela.get(rowIndex)).get(1);
       } else
       if (columnIndex == 2) {
          return ((Vector)ListaTela.get(rowIndex)).get(2);
       } else return "";
    }

}
