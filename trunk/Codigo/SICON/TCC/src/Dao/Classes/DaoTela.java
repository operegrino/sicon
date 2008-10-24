/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.tela;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaTela;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.management.Query;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jonathan
 */
public class DaoTela extends DaoAbstractGenerica implements DaoGenericaTela{
    private tela Tela;
    
    public DaoTela(){

    }

    @Override
    public boolean Salvar(tela object) {
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

    @Override
    public boolean Alterar(tela object) {
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
            e.printStackTrace();
            Alterou = false;
            transacao.rollback();      
        } finally {
            manager.clear();
            return Alterou;            
        }    
    }

    @Override
    public boolean Excluir(tela object) {
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
    public ArrayList Pesquisar(ArrayList<String> ListaParametros) {
        String Parametros = "";
        ArrayList<tela> ListaTela = new ArrayList<tela>();
        //ListaCargo = null;
        List ListaIds;
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("Descricao")) {
                Parametros = Parametros + "c.descricao LIKE '%"+ ListaParametros.get(contador + 1) +"%'";
            }
            contador =+2;
        }
        ListaIds = manager.createQuery("Select t.idtela from tela t " + Parametros).getResultList();
        for (Iterator<String> it = ListaIds.iterator(); it.hasNext();) {
            String elem = String.valueOf(it.next());
            ListaTela.add((tela)manager.createNamedQuery("tela.findByIdtela").setParameter("idtela", Integer.parseInt(elem)).getSingleResult());
            
        }
        manager.clear();      
        return ListaTela;
    }
    
    public ArrayList<Object> PesquisarTeste(ArrayList<String> ListaParametros) {
        String Parametros = "";
        EntityTransaction transacao = manager.getTransaction();
        ArrayList<Object> ListaTela = new ArrayList<Object>();
        ArrayList<Object> ListaTelaParcial = new ArrayList<Object>();
        Vector ListaParcial = new Vector();
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
            contador =+2;
        }
        transacao.begin();
        javax.persistence.Query query = manager.createNativeQuery("Select t.idTela, t.nometela, t.titulotela, t.titulomenu from tela t " + Parametros);
        ListaIds = query.getResultList();      
        for (Iterator<String> it = ListaIds.iterator(); it.hasNext();) {
            ListaTelaParcial.add(it.next());
            }              
        return ListaTelaParcial;
    }

    @Override
    public tela CarregarObjeto(tela object) {
        tela t = new tela();
        t = manager.find(tela.class, object.getIdtela());        
        return t;
     }

}
