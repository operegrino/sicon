/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Dao.Interfaces.DaoGenericaCargo;
import Classes.cargo;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 *
 * @author Jonathan
 */
public class DaoCargo extends DaoAbstractGenerica implements DaoGenericaCargo{
    
    //private EntityManagerFactory factory = null;
    //private EntityManager manager = null;
    //private Object cargo;

	
    public DaoCargo() {

    }

    /* 
     * Objetivo     : Alterar os dados do objeto cargo
     * Data Criação : 08/07/08 
     */        
    public boolean Alterar(cargo object) {
        boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();            
            manager.merge(object);
            manager.flush();
            manager.clear();
            Alterou = true;
            transacao.commit();
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());               
            System.out.println(e);
            Alterou = false;
            transacao.rollback();      
        } finally {
            manager.clear();
            return Alterou;            
        }           
    }

    /* 
     * Objetivo     : Salvar um novo objeto cargo no banco de dados
     * Data Criação : 08/07/08 
     */    
    public boolean Salvar(cargo object) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();            
            manager.persist(object);
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());               
            System.out.println(e);
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }
    }
    
    /* 
     * Objetivo     : Excluir um objeto cargo do banco de dados
     * Data Criação : 08/07/08 
     */    
    public boolean Excluir(cargo object) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            object = manager.merge(object);
            manager.remove(object);
            transacao.commit();
            Excluir = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());               
            e.printStackTrace();
            Excluir = false;
            transacao.rollback();            
        } finally {
            manager.clear();
            return Excluir;
        }  
    }
    
    /* 
     * Objetivo     : Pesquisa os dados com base nos parametros passados
     * Data Criação : 08/07/08 
     */ 
    @Override
    public ArrayList<cargo> Pesquisar(ArrayList<String> ListaParametros) {
        String Parametros = "";
        ArrayList<cargo> ListaCargo = new ArrayList<cargo>();
        //ListaCargo = null;
        List ListaIds;
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("Descricao")) {
                Parametros = Parametros + "c.descricao ILIKE '%"+ ListaParametros.get(contador + 1) +"%'";
            }
            contador = contador + 2;
        }
        ListaIds = manager.createQuery("Select c.idcargo from cargo c " + Parametros).getResultList();
        for (Iterator<String> it = ListaIds.iterator(); it.hasNext();) {
            String elem = String.valueOf(it.next());
            ListaCargo.add((cargo)manager.createNamedQuery("cargo.findByIdcargo").setParameter("idcargo", Integer.parseInt(elem)).getSingleResult());
            
        }
        manager.clear();
        return ListaCargo;
    }

    @Override
    public cargo CarregarObjeto(cargo object) {
        cargo c = new cargo();
        c = manager.find(cargo.class, object.getIdcargo());  
        return c;
    }

}
