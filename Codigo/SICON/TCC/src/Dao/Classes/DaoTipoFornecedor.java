/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.fornecedor;
import Classes.tipofornecedor;
import Dao.Interfaces.DaoAbstractGenerica;

/**
 *
 * @author Jonathan
 */
public class DaoTipoFornecedor extends DaoAbstractGenerica{

    public DaoTipoFornecedor(){
        super();
    }
    
    public tipofornecedor CarregarTipoFornecedor(tipofornecedor object) {
        tipofornecedor tf = new tipofornecedor();        
        tf = manager.find(tipofornecedor.class, object.getIdtipofornecedor());  
        manager.clear();
        return tf;
    }
       
}
