/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.usuario;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaUsuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jonathan
> */
public class DaoUsuario extends DaoAbstractGenerica implements DaoGenericaUsuario{

    public DaoUsuario(){
        super();
    }
    
    @Override
    public boolean Salvar(usuario object) {
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
    public boolean Alterar(usuario object) {
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
    public boolean Excluir(usuario object) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
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
        List ListaIds;
        int contador = 0; 
        if (!(ListaParametros.isEmpty())) {
            Parametros = " where ";    
        }        
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("nomeusuario")) {
                Parametros = Parametros + " u.nomeusuario ILIKE '%"+ ListaParametros.get(contador + 1) +"%' and ";
            }
            if (ListaParametros.get(contador).contentEquals("cargo")) {
                Parametros = Parametros + " c.idcargo in (" +ListaParametros.get(contador + 1) + ") and ";
            }
            if (ListaParametros.get(contador).contentEquals("perfil")) {
                Parametros = Parametros + " p.idperfil in (" +ListaParametros.get(contador + 1) + ") and ";
            }
            if (ListaParametros.get(contador).contentEquals("login")) {
                Parametros = Parametros + " u.login LIKE '%"+ ListaParametros.get(contador + 1) +"%' and ";
            }            
            contador =+2;
        }  
        if (!(Parametros.equals(""))) {
            Parametros = Parametros.substring(0, Parametros.length()-4);
        }
        ListaIds = manager.createNativeQuery("SELECT u.nomeusuario, c.descricao, p.nome, u.login, u.idusuario " + 
                                       "FROM   usuario u " +
                                       "INNER JOIN cargo      c ON c.idcargo = u.idcargo " +
                                       "INNER JOIN perfil     p ON p.idperfil = u.idperfil" + Parametros).getResultList();

        manager.clear();    
        return ListaIds;
    }
    
    public usuario CarregaUsuarioSistema(String Login) {
        List ListaUsuario = null;
        usuario Usuario = new usuario();
        try{
            ListaUsuario = manager.createNamedQuery("usuario.findByLogin").setParameter("login", Login).getResultList();        
        } catch (Exception e) {            
            System.out.println(e);            
        }
        if (ListaUsuario.isEmpty()){
            return Usuario;
        } else return (usuario)ListaUsuario.iterator().next();
    }

    @Override
    public usuario CarregarObjeto(usuario object) {
        usuario u = new usuario();
        u = manager.find(usuario.class, object.getIdusuario());
        return u;
    }



}
