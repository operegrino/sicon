/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.botao;
import Classes.cargo;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaFuncionalidade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;


/**
 *
 * @author Jonathan
 */
public class DaoFuncionalidade extends DaoAbstractGenerica implements DaoGenericaFuncionalidade{
    
    public DaoFuncionalidade(){
    
    }
    
    @Override
    public boolean Salvar(botao object) {
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
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }
    }

    @Override
    public boolean Alterar(botao object) {
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
            Alterou = false;
            transacao.rollback(); 
        } finally {
            return Alterou;            
        }
    }

    @Override
    public boolean Excluir(botao object) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();                        
            object = manager.merge(object);
            manager.remove(object);
            transacao.commit();
            Excluir = true;
        }
        catch (Exception e) {              
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());           
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
        ArrayList<botao> ListaBotao = new ArrayList<botao>();
        List ListaIds;
        int contador = 0;
        try{
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("DescricaoBotao")) {
                Parametros = Parametros + "b.descricaobotao LIKE '%"+ ListaParametros.get(contador + 1) +"%' and ";
            } else
                if (ListaParametros.get(contador).contentEquals("TituloBotao")) {
                Parametros = Parametros + "b.titulobotao LIKE '%"+ ListaParametros.get(contador + 1) +"%' and ";
                } else 
                    if (ListaParametros.get(contador).contentEquals("NomeBotao")) {
                Parametros = Parametros + "b.nomebotao LIKE '%"+ ListaParametros.get(contador + 1) +"%' and ";
                    }       
            contador += 2;
        }
        if (!(Parametros.equals(""))) {
            Parametros = Parametros.substring(0, Parametros.length()-4);
        }
        ListaIds = manager.createQuery("Select b.idbotao from botao b " + Parametros).getResultList();
        for (Iterator<String> it = ListaIds.iterator(); it.hasNext();) {
            String elem = String.valueOf(it.next());
            ListaBotao.add((botao)manager.createNamedQuery("botao.findByIdbotao").setParameter("idbotao", Integer.parseInt(elem)).getSingleResult());
        }
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());    
        } finally {
            manager.clear();
            return ListaBotao;
        }
    }

    @Override
    public botao CarregarObjeto(botao object) {
        botao b = new botao();
        b = manager.find(botao.class, object.getIdbotao());          
        return b;
    }

}
