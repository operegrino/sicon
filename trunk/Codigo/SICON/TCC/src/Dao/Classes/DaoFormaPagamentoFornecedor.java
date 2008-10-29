/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.formapagamentofornecedor;
import Dao.Interfaces.DaoAbstractGenerica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import Classes.UsuarioSistema;
import javax.persistence.EntityTransaction;
/**
 *
 * @author jonathan
 */
public class DaoFormaPagamentoFornecedor extends DaoAbstractGenerica {

    public DaoFormaPagamentoFornecedor(){
        super();
    }
    
    public boolean Excluir(String idFormaPagamentoFornecedor) {
        boolean Excluiu = false;
        EntityTransaction transacao = manager.getTransaction();
        try{
            transacao.begin();
            manager.createNativeQuery("Delete from formapagamentofornecedor where idformapagamentofornecedor = " + idFormaPagamentoFornecedor).executeUpdate();
            transacao.commit();
            Excluiu = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());              
            System.out.println(e);            
        } finally {
            return Excluiu;
        }
    }
    
    public Vector Pesquisar(ArrayList<String> ListaParametros){
        String Parametros = "";
        //ListaCargo = null;
        Vector ListaResultado;
        ListaResultado = new Vector();
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        boolean AdicionarAnd = false;
        String And = "";
        while (ListaParametros.size() > contador) {                        
            if (ListaParametros.get(contador).contentEquals("fornecedor")) {   
                Parametros = Parametros + And + "f.codigo = '"+ ListaParametros.get(contador + 1) +"' ";
                And = " and ";
            }else if (ListaParametros.get(contador).contentEquals("forma")){
                Parametros = Parametros + And + "fp.idformapagamento = "+ ListaParametros.get(contador + 1);
                And = " and ";
            }           
            contador = contador + 2;
        }        
        String Consulta = "Select f.idfornecedor, f.razaosocial, fp.idformapagamento, fp.nome, fpf.idformapagamentofornecedor " +
                          "from fornecedor f inner join formapagamentofornecedor fpf on f.idfornecedor = fpf.idfornecedor   " +
                          " inner join formapagamento fp on fpf.idformapagamento = fp.idformapagamento ";
        String Ordenacao = " order by f.razaosocial, fp.nome ";        
        try {
            ListaResultado = (Vector) manager.createNativeQuery(Consulta + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;     
    }
    }
