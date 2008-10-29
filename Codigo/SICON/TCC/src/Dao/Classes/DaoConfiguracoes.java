/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.Configuracoes;
import Classes.UsuarioSistema;
import Dao.Interfaces.DaoAbstractGenerica;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoConfiguracoes extends DaoAbstractGenerica{
    
    public DaoConfiguracoes(){
        super();
    }
    
    public boolean Alterar(Configuracoes object) throws SQLException, Exception{
        boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction();
            transacao.begin();
            super.AtualizaUsuario();            
            manager.merge(object);
            manager.flush();
            Alterou = true;
            transacao.commit();
        /*} catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());              
            System.out.println(e);
            Alterou = false;
            transacao.rollback();      
        } finally {*/
            manager.clear();            
            return Alterou;            
        //}           
    }

    /** 
     * Objetivo     : Salvar um novo objeto cargo no banco de dados
     * Data Criação : 08/07/08 
     */  
   
    public Configuracoes CarregarObjeto(Configuracoes object) {
        Configuracoes b = new Configuracoes();    
        b = (Configuracoes)manager.createQuery("select c from Configuracoes c").getSingleResult();        
        manager.clear();
        return b;
    }    

}
