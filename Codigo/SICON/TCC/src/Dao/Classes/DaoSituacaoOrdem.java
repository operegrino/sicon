/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.situacaoordem;
import Classes.UsuarioSistema;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 *
 * @author jonathan
 */
public class DaoSituacaoOrdem extends DaoAbstractGenerica{
    
    public DaoSituacaoOrdem(){
        super();
    }
    
    public Vector Pesquisar(ArrayList ListaParametros){
        String Parametros = "";
        String Ordenacao = " order by s.idsituacaoordem";
        String Consulta = "select s.idsituacaoordem, s.descricao from situacaoordem s";
        Vector ListaResultado = new Vector();
        try {
            ListaResultado = (Vector)manager.createQuery(Consulta + Parametros + Ordenacao).getResultList();          
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());               
            e.printStackTrace();                        
        } finally {
            manager.clear();
            return ListaResultado;
        }        
    }

    public situacaoordem CarregarObjeto(situacaoordem object) {
        situacaoordem s = new situacaoordem();        
        s = manager.find(situacaoordem.class, object.getIdsituacaoordem());  
        manager.clear();
        return s;
    }      
}
