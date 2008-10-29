/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.dadosbancarios;
import Classes.fornecedor;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaFornecedor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoFornecedor extends DaoAbstractGenerica implements DaoGenericaFornecedor{

    public DaoFornecedor(){
        
    }
    
    @Override
    public boolean Salvar(fornecedor object) {
      boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();  
            // VALIDA SE É NECESSÁRIO GRAVAR OS DADOS BANCARIOS
            if (((fornecedor)object).getdadosbancarios().getContacorrente() != null) {
                manager.persist(((fornecedor)object).getdadosbancarios());
            } else ((fornecedor)object).setdadosbancarios(null);
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
    public boolean Alterar(fornecedor object) {
       boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            // VALIDA SE É NECESSÁRIO GRAVAR OS DADOS BANCARIOS
            if (((fornecedor)object).getdadosbancarios().getContacorrente() != null) {
                manager.merge(((fornecedor)object).getdadosbancarios());
            } else ((fornecedor)object).setdadosbancarios(null);          
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
    public boolean Excluir(fornecedor object) {
         boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            // VALIDA SE É NECESSÁRIO EXCLUIR OS DADOS BANCARIOS
            if (((fornecedor)object).getdadosbancarios() != null) {
                dadosbancarios db = new dadosbancarios();
                db = manager.merge(((fornecedor)object).getdadosbancarios());
                manager.remove(db);
            } else ((fornecedor)object).setdadosbancarios(null);                      
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
        String And = "";
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("RazaoSocial")) {
                Parametros = Parametros + And + "f.razaosocial LIKE '%"+ ListaParametros.get(contador + 1) +"%'";
                And = " And ";
            }else if (ListaParametros.get(contador).contentEquals("codigo")){
                Parametros = Parametros + And + "f.codigo = "+ ListaParametros.get(contador + 1);
                And = " And ";
            }           
            contador = contador + 2;
        }        
        String Ordenacao = " order by f.razaosocial ";
        try {
            ListaResultado = manager.createQuery("Select f.codigo, f.razaosocial, f.cnpj, f.tempoentrega, f.idfornecedor from fornecedor f " + Parametros + Ordenacao).getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaResultado;
    }

    public List PesquisarListaEmail(int id) {
      String Parametros = "";
        //ListaCargo = null;
        List ListaResultado;
        ListaResultado = new ArrayList();
        String Ordenacao = " order by e.email ";
        try {
            ListaResultado = manager.createNativeQuery("select e.email from email e where e.idfornecedor = " + String.valueOf(id) + Ordenacao).getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaResultado;
    }
        
    @Override
    public fornecedor CarregarObjeto(fornecedor object) {
        fornecedor f = new fornecedor();        
        f = manager.find(fornecedor.class, object.getIdfornecedor());  
        manager.clear();
        return f;
    }
    
    public fornecedor CarregarObjetoPeloCodigo(fornecedor object){
        return (fornecedor)manager.createNamedQuery("fornecedor.findByCodigo").setParameter("codigo", object.getCodigo()).getSingleResult();        
    }

}
