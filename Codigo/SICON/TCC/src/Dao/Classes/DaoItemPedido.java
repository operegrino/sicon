/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.itempedido;
import Dao.Interfaces.DaoAbstractGenerica;

/**
 *
 * @author Jonathan
 */
public class DaoItemPedido extends DaoAbstractGenerica {

    public DaoItemPedido() {
        super();
    }

    public itempedido CarregarObjeto(itempedido object) {
        itempedido ip = new itempedido();        
        ip = manager.find(itempedido.class, object.getIditempedido());  
        manager.clear();
        return ip;
    }    
}
