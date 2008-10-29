/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.ordemproduto;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class DaoOrdemProduto extends DaoAbstractGenerica{
    
    public DaoOrdemProduto(){
        super();
    }

    public ordemproduto CarregarObjeto(ordemproduto object) {
    ordemproduto o = new ordemproduto();        
    o = manager.find(ordemproduto.class, object.getIdOrdemProduto());  
    manager.clear();
    return o;
    }      
    
    public List RetornarTodos(String idOrdemProducao){
        String Parametros = "";
        //ListaCargo = null;
        List ListaResultado;
        ListaResultado = new ArrayList();    
        String Ordenacao = " order by p.nome, op.idordemproducao ";
        try {
            String Consulta = " select op.idordemproduto, p.idproduto, p.codigo, p.nome, " +
                              "op.quantidade, op.idunidademedida, op.idordemproducao " +                              
                              " from ordemproduto op " +
                              "      inner join produto p      on op.idproduto = p.idproduto " +
                              " where op.idordemproducao = " + idOrdemProducao;                            
            ListaResultado = manager.createNativeQuery(Consulta + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }        
    
}
