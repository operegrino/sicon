/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTableOrdemProducao extends AbstractTableModel{
    
    private Vector ListaOrdemProducao = new Vector();

    public JTableOrdemProducao(Vector Dados) {
        ListaOrdemProducao = Dados;
        //InsereCheckBox();
    }

    @Override
    public int getRowCount() {
        return ListaOrdemProducao.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
        return "";
        } else 
        if (col == 1) {
        return "Nº Ordem de Produção";
        } else
        if (col == 2) {
        return "Data";
        } else
        if (col == 3) {
        return "Refeição";
        } else
        if (col == 4) {
        return "Setor";
        } else
        if (col == 5) {
        return "Motivo";
        } else
        if (col == 6) {
        return "Origem";
        } else
        if (col == 7) {
        return "Situação";
        } else return "";
    }    
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        ((Vector)ListaOrdemProducao.get(row)).set(col, value);
        fireTableCellUpdated(row, col);
    }
    

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       if (columnIndex == 0) {
           return Boolean.valueOf(((Vector)ListaOrdemProducao.get(rowIndex)).get(0).toString());
       } else 
       if (columnIndex == 1) {
           return ((Vector)ListaOrdemProducao.get(rowIndex)).get(1).toString();
       } else
       if (columnIndex == 2) {
           return ((Vector)ListaOrdemProducao.get(rowIndex)).get(2).toString();
       } else
       if (columnIndex == 3) {
           return ((Vector)ListaOrdemProducao.get(rowIndex)).get(4).toString();
       } else
       if (columnIndex == 4) {
           return ((Vector)ListaOrdemProducao.get(rowIndex)).get(5).toString();
       } else
       if (columnIndex == 5) {
           return ((Vector)ListaOrdemProducao.get(rowIndex)).get(6).toString();
       } else
       if (columnIndex == 6) {
           return ((Vector)ListaOrdemProducao.get(rowIndex)).get(8).toString();
       } else
       if (columnIndex == 7) {
           return ((Vector)ListaOrdemProducao.get(rowIndex)).get(10).toString();
       } else return "";           
    }    
}