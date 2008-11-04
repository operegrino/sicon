/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.situacaoitempedido;
import Dao.Interfaces.DaoAbstractGenerica;

/**
 *
 * @author Jonathan
 */
public class DaoSituacaoItemPedido extends DaoAbstractGenerica {
    
    public DaoSituacaoItemPedido() {
        super();
    }
    
    public situacaoitempedido LeSituacao(int id) {
        return manager.find(situacaoitempedido.class, id);
    }
    
    public situacaoitempedido LeSituacao(String nome) {
        return (situacaoitempedido) manager.createNamedQuery("situacaoitempedido.findByDescricao").setParameter("descricao", nome).getSingleResult();
    }

}
