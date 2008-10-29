/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Dao.Classes.DaoSaldoEstoque;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerSaldoEstoque extends ControllerAncestral {
    
    private DaoSaldoEstoque DaoSaldo;
    public ControllerSaldoEstoque(){
        super();
        DaoSaldo = new DaoSaldoEstoque();
    }
    
    public Vector EventoPesquisar(ArrayList ListaParametros) {
        Vector Lista = new Vector();    
        Lista = (Vector) DaoSaldo.Pesquisar(ListaParametros);
        return Lista;        
    }

}
