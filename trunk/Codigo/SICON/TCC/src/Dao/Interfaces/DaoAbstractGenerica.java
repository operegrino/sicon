/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Interfaces;

import Classes.UsuarioSistema;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import Classes.ultimousuario;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author Jonathan
 */
public abstract class DaoAbstractGenerica {
    
    protected EntityManager manager = null;
    protected EntityManagerFactory factory = null;
    private ultimousuario UltimoUsuario;
    //private UsuarioSistema usuarioSistema;
    
    public DaoAbstractGenerica(){
        this.factory = Persistence.createEntityManagerFactory("TCC2PU");   
        this.manager = factory.createEntityManager();
    }
    
    public void AtualizaUsuario(){
        CarregaUsuario();
        manager.merge(UltimoUsuario);                
    }
    
    public void CarregaUsuario(){
        UltimoUsuario = new ultimousuario();
        UltimoUsuario.setUltimoUsuario(UsuarioSistema.getUsuarioConectado().getLogin());
    }


}
