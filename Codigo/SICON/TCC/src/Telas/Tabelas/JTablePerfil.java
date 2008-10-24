/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.perfil;
import Classes.usuario;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTablePerfil extends AbstractTableModel{
    
    private ArrayList<Object> ListaPerfil = new ArrayList<Object>();

    public JTablePerfil(ArrayList<Object> Dados) {
        ListaPerfil = Dados;
    }
    @Override
    public int getRowCount() {
        return ListaPerfil.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
        return "Perfil";
        } else return "Administrador";
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (columnIndex == 0) {
           return ((Vector)ListaPerfil.get(rowIndex)).get(0);
       } else return ((Vector)ListaPerfil.get(rowIndex)).get(1);
    }

}
