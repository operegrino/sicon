/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.Funcoes;
import Dao.Interfaces.DaoAbstractGenerica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class DaoSaldoEstoque extends DaoAbstractGenerica{
    
    public DaoSaldoEstoque(){
        super();
    }
    
    public List Pesquisar(ArrayList ListaParametros){
        //ListaCargo = null;
        List ListaResultado;
        String Data = "";
        String StringProduto = "";
        ListaResultado = new ArrayList();
        int contador = 0;
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).equals("produto")) {
                StringProduto = ListaParametros.get(contador + 1).toString();
            }else if (ListaParametros.get(contador).equals("data")){
                Date dt = Funcoes.FormataDataPadrao(ListaParametros.get(contador + 1).toString());
                SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
                Data = s.format(dt);
            }                
            contador = contador + 2;
        }        
        try {
            String Consulta = "select retornarsaldo(cast('" + Data + "' as date), " + StringProduto + ", 0) as saldoEntradaAcum, " +
                              "retornarsaldo(cast('" + Data + "' as date), " + StringProduto + ", 1) as saldoSaidaAcum, " +
                              "retornarsaldo(cast('" + Data + "' as date), " + StringProduto + ", 2) as saldoAtual, " +
                              "retornarsaldo(cast('" + Data + "' as date), " + StringProduto + ", 3) as saldoComprometido, " +
                              "retornarsaldo(cast('" + Data + "' as date), " + StringProduto + ", 4) as saldoPendente, " +
                              "retornarsaldo(cast('" + Data + "' as date), " + StringProduto + ", 5) as saldoComprometidoFuturo, " +
                              "retornarsaldo(cast('" + Data + "' as date), " + StringProduto + ", 6) as saldoReal ";
            ListaResultado = manager.createNativeQuery(Consulta).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;        
    }

}
