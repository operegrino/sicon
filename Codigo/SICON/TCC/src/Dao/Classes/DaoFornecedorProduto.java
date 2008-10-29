/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.fornecedorproduto;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaFornecedorProduto;
import java.util.ArrayList;
import java.util.List;
import Classes.UsuarioSistema;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoFornecedorProduto extends DaoAbstractGenerica implements DaoGenericaFornecedorProduto{

    public DaoFornecedorProduto(){
        super();
    }
    
    @Override
    public boolean Alterar(fornecedorproduto object) {
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
    public boolean Salvar(fornecedorproduto object) {
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
    
 public boolean SalvarTodos(ArrayList<fornecedorproduto> Lista, ArrayList ListaExcluir) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        super.AtualizaUsuario();  
        transaction.begin();           
        try {
            for (Iterator<fornecedorproduto> it = Lista.iterator(); it.hasNext();) {
                fornecedorproduto object = it.next();
                if ((object.getIdfornecedorproduto() == null) || (object.getIdfornecedorproduto() == 0)) {
                    manager.persist(object);      
                } else 
                    manager.merge(object);         
            }   
            for (Iterator<Integer> it = ListaExcluir.iterator(); it.hasNext();) {
                Integer id = it.next();
                fornecedorproduto f = new fornecedorproduto();
                f.LerClasse(id);
                f = manager.merge(f);
                manager.remove(f);
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
    @Override
    public boolean Excluir(fornecedorproduto object) {
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
 String And = "";
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).equals("fornecedor")) {
                Parametros = Parametros + And + " f.codigo = '"+ ListaParametros.get(contador + 1) + "' ";
                And = " And ";
            }else if (ListaParametros.get(contador).equals("produto")){
                Parametros = Parametros + And + " p.codigo = '"+ ListaParametros.get(contador + 1) + "' ";
                And = " And ";               
            }else if (ListaParametros.get(contador).equals("codigoprodforn")){
                Parametros = Parametros + And + " fp.codprodutofornecedor = '"+ ListaParametros.get(contador + 1)+ "' ";
                And = " And ";                
            } else if (ListaParametros.get(contador).equals("tipo")){
                Parametros = Parametros + And + " tf.idtipofornecedor = "+ ListaParametros.get(contador + 1);
                And = " And ";
            }
            contador = contador + 2;
        }        
        String Ordenacao = " order by f.razaosocial ";
        String Consulta  = "select f.idfornecedor, f.razaosocial, p.idproduto, p.nome, fp.codprodutofornecedor, " +
                                " fp.tempoentrega, tf.descricao, fp.idfornecedorproduto, p.codigo, " +
                                " tf.idtipofornecedor, f.codigo " +
                            " from fornecedor f  " +
                            " inner join fornecedorproduto    fp on  f.idfornecedor     = fp.idfornecedor " +
                            " inner join produto               p on  p.idproduto        = fp.idproduto   " +
                            " inner join tipofornecedor       tf on fp.idtipofornecedor = tf.idtipofornecedor ";
        try {
            ListaResultado = manager.createNativeQuery(Consulta + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }

    @Override
    public fornecedorproduto CarregarObjeto(fornecedorproduto object) {
        fornecedorproduto fp = new fornecedorproduto();        
        fp = manager.find(fornecedorproduto.class, object.getIdfornecedorproduto());  
        manager.clear();
        return fp;
    }


}
