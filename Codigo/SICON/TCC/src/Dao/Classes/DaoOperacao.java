/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.operacao;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class DaoOperacao extends DaoAbstractGenerica{

    public DaoOperacao(){
        super();
    }

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
            if (ListaParametros.get(contador).contentEquals("descricao")) {
                Parametros = Parametros + "o.descricao LIKE '%"+ ListaParametros.get(contador + 1) +"%'";
            }           
            contador = contador + 2;
        }        
        String Ordenacao = " order by o.descricao ";
        try {
            ListaResultado = manager.createQuery("Select o.idoperacao, o.descricao, o.vlfator from operacao o " + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }
    
   public operacao CarregarObjeto(operacao object) {
        operacao o = new operacao();        
        o = manager.find(operacao.class, object.getIdoperacao());  
        manager.clear();
        return o;
    }    
}
