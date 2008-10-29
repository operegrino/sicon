/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.tipotelefone;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class DaoTipoTelefone extends DaoAbstractGenerica {
    
    public DaoTipoTelefone() {
        
    }
       
    public tipotelefone CarregarTipoTelefone(tipotelefone object) {
        tipotelefone tt = new tipotelefone();        
        tt = manager.find(tipotelefone.class, object.getIdtipotelefone());  
        manager.clear();
        return tt;
    }
    
    public List RetornaTodos(){
        List ListaTipo = new ArrayList();
        ListaTipo = manager.createNativeQuery("select * from tipotelefone order by idtipotelefone").getResultList();
        return ListaTipo;
    }

}
