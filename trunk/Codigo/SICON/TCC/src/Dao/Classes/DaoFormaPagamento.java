/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.formapagamento;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaFormaPagamento;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoFormaPagamento extends DaoAbstractGenerica implements DaoGenericaFormaPagamento{

    
    public DaoFormaPagamento(){
        
    }
    
    @Override
    public boolean Salvar(formapagamento object) {
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
    public boolean Alterar(formapagamento object) {
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
    public boolean Excluir(formapagamento object) {
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
                Parametros = Parametros + "fm .nome ILIKE '%"+ ListaParametros.get(contador + 1) +"%'";
            }else if (ListaParametros.get(contador).contentEquals("operacaobancaria")){
                if (Integer.parseInt(ListaParametros.get(contador + 1)) == 0) {
                    Parametros = Parametros + "fm.operacaobancaria = false";
                } else Parametros = Parametros + "fm.operacaobancaria = true"; 
            }           
            contador = contador + 2;
        }        
        String Ordenacao = " order by fm.nome ";
        try {
            ListaResultado = manager.createQuery("Select fm.idformapagamento, fm.nome, fm.operacaobancaria from formapagamento fm " + Parametros + Ordenacao).getResultList();          
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
    public formapagamento CarregarObjeto(formapagamento object) {
        formapagamento fm = new formapagamento();
        fm = manager.find(formapagamento.class, object.getIdformapagamento());
        manager.clear();
        return fm;
    }

}
