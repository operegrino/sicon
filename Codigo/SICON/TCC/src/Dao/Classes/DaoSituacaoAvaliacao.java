/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Dao.Interfaces.DaoAbstractGenerica;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class DaoSituacaoAvaliacao extends DaoAbstractGenerica{
    
    public DaoSituacaoAvaliacao() {
        super();
    }
    
    public Vector RetornaSituacao() {
        return (Vector) manager.createNativeQuery("select * from situacaoitempedido where idsituacaoitempedido > 2").getResultList();
    }

}
