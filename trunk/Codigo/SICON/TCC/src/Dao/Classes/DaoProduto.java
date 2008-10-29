/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.produto;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaProduto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import Classes.UsuarioSistema;
import Classes.fornecedorproduto;
import java.util.Iterator;

/**
 *
 * @author jonathan
 */
public class DaoProduto extends DaoAbstractGenerica implements DaoGenericaProduto {

    
    public DaoProduto(){
        super();
    }
    
    @Override
    public boolean Salvar(produto object) {
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
    public boolean Alterar(produto object) {
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
    public boolean Excluir(produto object) {
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
        String And = "";        
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("produto")) {
                Parametros = Parametros + And + " p.codigo = '"+ ListaParametros.get(contador + 1) + "' ";                
                And = " And ";                
            }else if (ListaParametros.get(contador).contentEquals("descricao")){
                Parametros = Parametros + And + " p.nome ILIKE '%"+ ListaParametros.get(contador + 1) +"%'";  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("valor")) {
                Parametros = Parametros + And + " p.valor = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("estoque")) {
                Parametros = Parametros + And + " p.estoque = "+ ListaParametros.get(contador + 1); 
                And = " And ";                
            }  else if (ListaParametros.get(contador).contentEquals("alimentar")) {
                Parametros = Parametros + And + " p.alimentar = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            }  else if (ListaParametros.get(contador).contentEquals("fornecedor")) {
                Parametros = Parametros + And + " p.idproduto in (select idproduto from fornecedorproduto fp " +
                                                "inner joint fornecedor f on f.idfornecedor = fp.idfornecedor where f.codigo = '"+ ListaParametros.get(contador + 1) + "')";  
                And = " And ";                
            }   
            
            contador = contador + 2;
        }        
        String Ordenacao = " order by codigo";
        try {
            String Consulta = "SELECT p.idproduto, p.codigo, p.nome, p.valor, p.estoqueminimo, p.unidadeestoque, ues.nome, " + 
                                    " p.unidadeembalagem, p.alimentar " +
                              "from produto p  " +
                                  " left join composicaocentesimal c  on  p.idcomposicaocentesimal =   c.idcomposicaocentesimal " +
                                  " left join unidademedida       ue  on  p.unidadeembalagem     =  ue.idunidademedida " +
                                  " left join unidademedida       ues on  p.unidadeestoque       = ues.idunidademedida  ";
            ListaResultado = manager.createNativeQuery(Consulta + Ordenacao).getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaResultado;
    }

    @Override
    public produto CarregarObjeto(produto object) {
        produto p = new produto();
        p = manager.find(produto.class, object.getIdproduto());  
        return p;
    }
    
    public produto CarregarObjetoCodigo(produto object){
        return (produto)manager.createNamedQuery("produto.findByCodigo").setParameter("codigo", object.getCodigo()).getSingleResult();                
    }
    

}
