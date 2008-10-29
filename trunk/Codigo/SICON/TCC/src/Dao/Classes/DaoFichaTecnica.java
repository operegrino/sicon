/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.fichatecnica;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import Classes.UsuarioSistema;
import Classes.fichatecnicaitens;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class DaoFichaTecnica extends DaoAbstractGenerica{
    
    public DaoFichaTecnica(){
        super();
    }    
    
    public boolean Alterar(fichatecnica object) {
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
    public boolean Salvar(fichatecnica object) {
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
    
    public boolean SalvarFichaEItens(fichatecnica object, ArrayList<fichatecnicaitens> ListaNovo, ArrayList<fichatecnicaitens> ListaAlterar, ArrayList<fichatecnicaitens> ListaExcluir) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();            
            manager.persist(object);
            transaction.commit();
            manager.clear();
            transaction.begin();            
            gravarItens(ListaNovo, ListaAlterar, ListaExcluir, object.RetornaIdFichaTecnica());
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
    
    public void gravarItens(ArrayList<fichatecnicaitens> ListaNovo, ArrayList<fichatecnicaitens> ListaAlterar, ArrayList<fichatecnicaitens> ListaExcluir,  Integer idFicha) {
        for (Iterator<fichatecnicaitens> it = ListaNovo.iterator(); it.hasNext();) {
            fichatecnicaitens object = it.next();
            object.getFichatecnicaitensPK().setIdfichatecnica(idFicha);
            manager.persist(object);                
        }
        for (Iterator<fichatecnicaitens> it = ListaAlterar.iterator(); it.hasNext();) {
            fichatecnicaitens object = it.next();
            manager.merge(object);                
        }
        for (Iterator<fichatecnicaitens> it = ListaExcluir.iterator(); it.hasNext();) {
            fichatecnicaitens object = it.next();
            object = manager.merge(object);                
            manager.remove(object);
        }        
    }
    
    public boolean AlterarFichaEItens(fichatecnica object, ArrayList<fichatecnicaitens> ListaNovo, ArrayList<fichatecnicaitens> ListaAlterar, ArrayList<fichatecnicaitens> ListaExcluir) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();            
            manager.merge(object);
            transaction.commit();
            manager.clear();
            transaction.begin();            
            gravarItens(ListaNovo, ListaAlterar, ListaExcluir, object.RetornaIdFichaTecnica());
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
    public boolean Excluir(fichatecnica object) {
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
    public List Pesquisar(ArrayList<String> ListaParametros) {
        String Parametros = "";
        //ListaCargo = null;
        List ListaResultado;
        ListaResultado = new ArrayList();
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        String And = "";
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("produto")) {
                String Con = " f.idfichatecnica = (select Distinct idfichatecnica from fichatecnicaproduto fp where fp.idfichatecnica = f.idfichatecnica and fp.idproduto = " + ListaParametros.get(contador + 1) + ") ";
                Parametros = Parametros + And + Con;                
                And = " And ";                
            }else if (ListaParametros.get(contador).contentEquals("modopreparo")){
                Parametros = Parametros + And + " f.modopreparo LIKE '%"+ ListaParametros.get(contador + 1) +"%'";  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("nomepreparacao")){
                Parametros = Parametros + And + " f.nomepreparacao LIKE '%"+ ListaParametros.get(contador + 1) +"%'";  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("rendimento")){
                Parametros = Parametros + And + " f.rendimento = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            }            
            contador = contador + 2;
        }        
        String Ordenacao = " order by f.nomepreparacao ";
        try {
            ListaResultado = manager.createQuery("Select f.idfichatecnica, f.nomepreparacao, f.rendimento from fichatecnica f " + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }

    public fichatecnica CarregarObjeto(fichatecnica object) {
        fichatecnica f = new fichatecnica();        
        f = manager.find(fichatecnica.class, object.getIdfichatecnica());  
        manager.clear();
        return f;
    }    

}
