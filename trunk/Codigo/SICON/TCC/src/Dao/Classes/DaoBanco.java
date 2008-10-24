/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.banco;
import Classes.cargo;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaBanco;
import Dao.Interfaces.DaoGenericaCargo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jonathan
 */
public class DaoBanco extends DaoAbstractGenerica implements DaoGenericaBanco{

 public DaoBanco() {

    }

    /* 
     * Objetivo     : Alterar os dados do objeto cargo
     * Data Criação : 08/07/08 
     */  
    @Override
    public boolean Alterar(banco object) {
        boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();            
            manager.merge(object);
            manager.flush();
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
    @Override
    public boolean Salvar(banco object) {
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
    @Override
    public boolean Excluir(banco object) {
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
    public List Pesquisar(ArrayList<String> ListaParametros) {
        String Parametros = "";
        //ListaCargo = null;
        List ListaResultado;
        ListaResultado = new ArrayList();
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("nome")) {
                Parametros = Parametros + "b.nome ILIKE '%"+ ListaParametros.get(contador + 1) +"%'";
            }else if (ListaParametros.get(contador).contentEquals("codigo")){
                Parametros = Parametros + "b.idbanco = '%"+ ListaParametros.get(contador + 1) +"%'";
            }           
            contador = contador + 2;
        }        
        String Ordenacao = " order by b.idbanco ";
        try {
            ListaResultado = manager.createQuery("Select b.idbanco, b.nome from banco b " + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }

    @Override
    public banco CarregarObjeto(banco object) {
        banco b = new banco();        
        b = manager.find(banco.class, object.getIdbanco());  
        manager.clear();
        return b;
    }


}

