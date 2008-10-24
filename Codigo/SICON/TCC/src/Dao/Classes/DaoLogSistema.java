/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.logsistema;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaLogSistema;
import java.util.ArrayList;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jonathan
 */
public class DaoLogSistema extends DaoAbstractGenerica {
    private logsistema Log;
    
    public DaoLogSistema(){
      
    }

    public boolean Salvar(logsistema object) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(object);
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            System.out.println(e);
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }
    }
}
