/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.composicaocentesimal;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class DaoComposicaoCentesimal extends DaoAbstractGenerica{
    
    public DaoComposicaoCentesimal(){
        super();
    }
    
    public composicaocentesimal CarregarObjeto(composicaocentesimal object) {
        composicaocentesimal c = new composicaocentesimal();        
        c = manager.find(composicaocentesimal.class, object.getIdcomposicaocentesimal());  
        manager.clear();
        return c;
    }
    
    public List Pesquisar(ArrayList<String> ListaParametros){
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
            if (ListaParametros.get(contador).contentEquals("valor")) {
                Parametros = Parametros + And + " p.codigo = '"+ ListaParametros.get(contador + 1) + "' ";  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("energia")) {
                Parametros = Parametros + And + " c.energia = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("carboidrato")) {
                Parametros = Parametros + And + " c.carboidrato = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("proteina")) {
                Parametros = Parametros + And + " c.proteina = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("lipideos")) {
                Parametros = Parametros + And + " c.lipideo = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("calcio")) {
                Parametros = Parametros + And + " c.calcio = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("ferro")) {
                Parametros = Parametros + And + " c.ferro = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("vitaminac")) {
                Parametros = Parametros + And + " c.vitaminac = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            }          
            contador = contador + 2;
        }        
        String Ordenacao = " order by codigo";
        try {
            String Consulta = "select p.idproduto, p.nome, c.idcomposicaocentesimal, c.energia, c.carboidrato, " +
                              "       c.proteina, c.lipideo, c.calcio, c.ferro, c.vitaminac  " +
                              "from   produto p  " +
                              "       inner join composicaocentesimal c on p.idcomposicaocentesimal = c.idcomposicaocentesimal ";
   
            ListaResultado = manager.createNativeQuery(Consulta + Ordenacao + Parametros).getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaResultado;        
    }

}
