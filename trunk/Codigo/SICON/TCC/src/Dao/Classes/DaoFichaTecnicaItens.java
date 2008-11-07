/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.fichatecnicaitens;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaFichaTecnicaItens;
import java.util.ArrayList;
import javax.persistence.EntityTransaction;
import Classes.UsuarioSistema;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
/**
 *
 * @author Jonathan
 */
public class DaoFichaTecnicaItens extends DaoAbstractGenerica {
    
    public DaoFichaTecnicaItens(){
        super();
    }

    public boolean Alterar(ArrayList<fichatecnicaitens> object) {
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
    public boolean Salvar(ArrayList<fichatecnicaitens> ListaNovo, ArrayList<fichatecnicaitens> ListaAlterar, ArrayList<fichatecnicaitens> ListaExcluir) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {            
            transaction.begin();
            super.AtualizaUsuario();            
            for (Iterator<fichatecnicaitens> it = ListaNovo.iterator(); it.hasNext();) {
                fichatecnicaitens object = it.next();
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
    public boolean Excluir(fichatecnicaitens object) {
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
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("fichatecnica")) {
                Parametros = Parametros + "f.idfichatecnica = "+ String.valueOf(ListaParametros.get(contador + 1));
            }       
            contador = contador + 2;
        }        
        String Ordenacao = " order by p.nome ";
        try {
            ListaResultado = manager.createNativeQuery("Select f.idfichatecnica, f.idproduto, p.nome, f.pesobruto, f.pesoliquido, f.fatorcorrecao, p.codigo, 1 as IndicacaoExistente, p.estoqueminimo, p.unidadeestoque from fichatecnicaitens f inner join produto p on f.idproduto = p.idproduto " + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }

    public fichatecnicaitens CarregarObjeto(fichatecnicaitens object) {
        fichatecnicaitens f = new fichatecnicaitens();        
        f = manager.find(fichatecnicaitens.class, object.getFichatecnicaitensPK());  
        manager.clear();
        return f;
    }    
}
