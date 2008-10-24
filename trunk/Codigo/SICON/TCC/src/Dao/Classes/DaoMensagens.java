/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.mensagens;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jonathan
 */
public class DaoMensagens {
    
    private EntityManagerFactory factory = null;
    private EntityManager manager = null;
    
    public DaoMensagens(){
        this.factory = Persistence.createEntityManagerFactory("TCC2PU");   
        this.manager = factory.createEntityManager();     
    }
     
     
    public ArrayList<mensagens> CarregarObjeto(int Id) {
        ArrayList<mensagens> ListaObjeto = new ArrayList<mensagens>();
        try{
        ListaObjeto.add((mensagens)manager.createNamedQuery("mensagens.findByIdmensagem").setParameter("idmensagem", Id).getSingleResult());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return ListaObjeto;
    }

}
