/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoFormaPagamentoFornecedor;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author jonathan
 */
public class formapagamentofornecedor {

    
    public formapagamentofornecedor(){
        
    }
    
    public boolean Excluir(String idFormaPagamentoFornecedor){
        DaoFormaPagamentoFornecedor daoFormaFornecedor = new DaoFormaPagamentoFornecedor();        
        return daoFormaFornecedor.Excluir(idFormaPagamentoFornecedor);
    }
    
    public Vector Pesquisar(ArrayList<String> ListaParametro){
        DaoFormaPagamentoFornecedor daoFormaFornecedor = new DaoFormaPagamentoFornecedor();
        return daoFormaFornecedor.Pesquisar(ListaParametro);
    }
}
