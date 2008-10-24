/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.botao;
import Classes.perfil;
import Classes.perfiltela;
import Classes.tela;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaPerfil;
import java.util.ArrayList;
import java.util.Collection;
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
public class DaoPerfil extends DaoAbstractGenerica implements DaoGenericaPerfil{

    public DaoPerfil(){

    }
    @Override
    public boolean Salvar(perfil object) {
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
            return Gravou;
        }        
    }
    
  /*  public boolean SalvarAcesso(perfil Perfil) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            for (Iterator it = Perfil.getPerfiltelaCollection().iterator(); it.hasNext();) {
                perfiltela object = (perfiltela) it.next();
                object.setIdperfil(Perfil);
                manager.persist(object);               
            }
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            System.out.println(e);
            Gravou = false;
            transaction.rollback();            
        } finally {
          //  FechaGerenciador();
            return Gravou;
        }   
    }*/

    @Override
    public boolean Alterar(perfil object) {
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
    public boolean Excluir(perfil object) {
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
          List ListaIds;
          ArrayList<Object> ListaPerfil = new ArrayList<Object>();
          String Parametros = "";
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("nome")) {
                Parametros = Parametros + "p.nome ILIKE '%"+ ListaParametros.get(contador + 1) +"%'";
            }
            contador =+2;
        }
        javax.persistence.Query query = manager.createNativeQuery("Select p.nome, p.administrador, p.idperfil from perfil p " + Parametros);
        ListaIds = query.getResultList();
        for (Iterator<String> it = ListaIds.iterator(); it.hasNext();) {
            ListaPerfil.add(it.next());
        }
        manager.clear();
        return ListaPerfil;
    }
    
    @Override
    public perfil CarregarObjeto(perfil object) {
        javax.persistence.Query query = manager.createNativeQuery(" select * from perfil p " +
                                                                  " inner join perfiltela pt on p.idperfil = pt.idperfil " +
                                                                  " where p.idperfil = " + object.getIdperfil().toString() + 
                                                                  " order by pt.idtela " );
        List ListaIds;        
        ListaIds = query.getResultList();    
        perfil pf = new perfil();
        boolean setou = false;
        ArrayList perfilte = new ArrayList();
        for (Iterator<Vector> it = ListaIds.iterator(); it.hasNext();) {
            Vector Vetor = it.next();            
            if (!(setou)) {
                pf.setIdperfil((Integer)Vetor.get(0)); 
                pf.setNome(Vetor.get(1).toString());
                pf.setAdministrador(false);                
            }
            ArrayList Array = new ArrayList();
            perfiltela pt = new perfiltela();
            pt.perfil = new perfil();
            pt.Botao = new botao();
            pt.tela = new tela();
            pt.setIdperfiltela((Integer)Vetor.get(3));
            pt.perfil = pf;
            pt.tela.LerClasse((Integer)Vetor.get(5));
            pt.Botao.LerClasse((Integer)Vetor.get(6));
            perfilte.add(pt);
        }
        pf.setPerfiltelaCollection(perfilte);
        return pf;       
        
    }

}
