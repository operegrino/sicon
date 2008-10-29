/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.situacaopedido;
import Dao.Interfaces.DaoAbstractGenerica;

/**
 *
 * @author Jonathan
 */
public class DaoSituacaoPedido extends DaoAbstractGenerica{

    public DaoSituacaoPedido(){
        super();  
    }
    
    public situacaopedido CarregarObjeto(situacaopedido object) {
        situacaopedido s = new situacaopedido();        
        s = manager.find(situacaopedido.class, object.getIdsituacaopedido());  
        manager.clear();
        return s;
    }        
}
