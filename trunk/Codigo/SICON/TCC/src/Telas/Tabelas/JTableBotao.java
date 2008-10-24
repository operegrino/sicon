/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.botao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableBotao extends AbstractTableModel{
    

    private ArrayList<botao> ListaBotao = new ArrayList();    
    
    
    public JTableBotao(ArrayList<botao> Dados) {
        ListaBotao = Dados;        
    }

    public int getRowCount() {
        return ListaBotao.size();
    }

    public int getColumnCount() {
        return 3;
    }
    
    public String getColumnName(int col) {
            if (col==0) {
                return "Titulo";
            } else
            if (col==1) {
                    return "Nome";
            } else
            if (col==2) {
                    return "Descrição";
            } else return "";        
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0) {
          return ((botao)ListaBotao.get(rowIndex)).getTitulobotao();
        } else
        if (columnIndex==1) {    
            return ((botao)ListaBotao.get(rowIndex)).getNomebotao();
        }
        if (columnIndex==2) {
        return ((botao)ListaBotao.get(rowIndex)).getDescricaobotao();
        }
        else return null;
    }
}
