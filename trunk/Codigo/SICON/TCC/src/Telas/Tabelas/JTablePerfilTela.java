/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Tabelas;

import Classes.botao;
import Classes.perfiltela;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class JTablePerfilTela extends AbstractTableModel{
    

    private ArrayList<perfiltela> ListaRecebe = new ArrayList<perfiltela>();    
    private ArrayList<Object> ListaDados = new ArrayList<Object>();    
    
    public JTablePerfilTela(ArrayList<perfiltela> Dados) {
        ListaRecebe = Dados;  
        CarregaFormaVisualizacao();
    }
    
    public void CarregaFormaVisualizacao(){
        String Tela = "";
        String TelaProxima ="";
        String Botoes = "";
        int cont = 0;
        int contVetor = 0;
        //int contFinal = 0;
        while (ListaRecebe.size() > cont) {
            Tela = ((ListaRecebe.get(cont)).getIdtela().getTitulotela());
            TelaProxima =  (ListaRecebe.get(cont)).getIdtela().getTitulotela();
            Botoes = "";
            while (Tela.equals(TelaProxima)) {
                Botoes = Botoes + ", " + (ListaRecebe.get(cont)).getbotao().getTitulobotao();
                cont = cont + 1;
                if (cont == ListaRecebe.size()) {
                   TelaProxima = "";       
                } else {
                   TelaProxima = (ListaRecebe.get(cont)).getIdtela().getTitulotela(); 
                }
                //Tela = (((perfiltela)ListaRecebe.get(cont)).getIdtela().getTitulotela());
            }
            Vector ListaAtualizada = new Vector();
            ListaAtualizada.clear();
            if (cont > 0) {
              ListaAtualizada.insertElementAt((ListaRecebe.get(cont - 1)).getIdtela().getTitulotela(),0);
            } else ListaAtualizada.insertElementAt((ListaRecebe.get(cont)).getIdtela().getTitulotela(),0);
            ListaAtualizada.insertElementAt(Botoes.substring(2), 1);
            ListaDados.add(ListaAtualizada);
            contVetor = contVetor + 2;
        }
        
    }

    public int getRowCount() {
        return ListaDados.size();
    }

    public int getColumnCount() {
        return 2;
    }
    
    public String getColumnName(int col) {
            if (col==0) {
                return "Tela";
            } else
            if (col==1) {
                    return "Botões";
            } else return "";        
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0) {
          return ((Vector)ListaDados.get(rowIndex)).get(0);
        } else
        if (columnIndex==1) {    
            return ((Vector)ListaDados.get(rowIndex)).get(1);
        } else return null;
    }
}
