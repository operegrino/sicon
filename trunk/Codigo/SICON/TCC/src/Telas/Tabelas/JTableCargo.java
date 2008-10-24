package Telas.Tabelas;

/**
 * @objetivo : Criar uma tabela personalizada para a tela de cargo;
 * 
 * @data     : 09/07/08
 */




import Classes.cargo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 * @Objetivo Criar uma Classe padrão para ser criada as tabelas
 *           das telas
 * @
 * @author Jonathan
 */
public class JTableCargo extends AbstractTableModel{
    

    private ArrayList<cargo> ListaCargo = new ArrayList();    
    
    
    public JTableCargo(ArrayList<cargo> Dados) {
        ListaCargo = Dados;        
    }

    public int getRowCount() {
        return ListaCargo.size();
    }

    public int getColumnCount() {
        return 1;
    }
    
    public String getColumnName(int col) {
            return "Descrição";
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((cargo)ListaCargo.get(rowIndex)).getDescricao(); 
    }
            
}









