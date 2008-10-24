/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.motivo;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaMotivo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoMotivo extends DaoAbstractGenerica implements DaoGenericaMotivo{

    
    public DaoMotivo() {
        
    }
    
   @Override
   public boolean Salvar(motivo object) {
    boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();            
            manager.persist(object);
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            System.out.println(e);
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());               
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }
    }

    @Override
    public boolean Alterar(motivo object) {
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

    @Override
    public boolean Excluir(motivo object) {
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
                Parametros = Parametros + "m.nome ILIKE '%"+ ListaParametros.get(contador + 1) +"%'";
            }else if (ListaParametros.get(contador).contentEquals("baixar")){
                if (Integer.parseInt(ListaParametros.get(contador + 1)) == 0) {
                    Parametros = Parametros + "m.baixar = true";
                } else Parametros = Parametros + "m.baixar = false"; 
            }           
            contador = contador + 2;
        }        
        String Ordenacao = " order by m.nome ";
        try {
            ListaResultado = manager.createQuery("Select m.idmotivo, m.nome, m.baixar from motivo m " + Parametros + Ordenacao).getResultList();          
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());               
            e.printStackTrace();                        
        } finally {
            manager.clear();
            return ListaResultado;
        }
    }

    @Override
    public motivo CarregarObjeto(motivo object) {
        motivo m = new motivo();
        m = manager.find(motivo.class, object.getIdmotivo());
        manager.clear();
        return m;
    }

}
