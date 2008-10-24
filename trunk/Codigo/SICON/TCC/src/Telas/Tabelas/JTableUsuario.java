/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableUsuario extends AbstractTableModel{

    private List ListaUsuario;
    
    public JTableUsuario(List Dados){
        ListaUsuario = Dados; 
        if (ListaUsuario.isEmpty()) {
            CarregaDefault();
        }
    }
    
    private void CarregaDefault(){
        for (int cont = 0; cont<4; cont++){
            Vector Vazio = new Vector();
            for (int contVe = 0; contVe<4; contVe++){
              Vazio.add("");
            }
            ListaUsuario.add(Vazio);
        }
    }
    @Override
    public int getRowCount() {
        return ListaUsuario.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    public String getColumnName(int col) {
        if (col == 0) {
          return "Usuário";
        } else 
        if (col == 1) {
          return "Cargo";
        } else 
        if (col == 2) {
          return "Perfil";  
        } 
        return "Login";            
    } 

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return ((Vector)ListaUsuario.get(rowIndex)).get(0);            
        } else
        if (columnIndex == 1) {
            return ((Vector)ListaUsuario.get(rowIndex)).get(1);        
        } else
        if (columnIndex == 2) {
            return ((Vector)ListaUsuario.get(rowIndex)).get(2);        
        } else 
        if (columnIndex == 3) {
            return ((Vector)ListaUsuario.get(rowIndex)).get(3);  
        } else return "";       
    }

}
