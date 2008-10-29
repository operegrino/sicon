/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.origemordem;
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
public class DaoOrigemOrdem extends DaoAbstractGenerica{
    
    public DaoOrigemOrdem(){
        super();
    }
    
    public Vector Pesquisar(ArrayList ListaParametros){
        String Parametros = "";
        String Ordenacao = " order by o.idorigemordem ";
        String Consulta = "select o.idorigemordem, o.descricao from origemordem o ";
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

    public origemordem CarregarObjeto(origemordem object) {
        origemordem o = new origemordem();        
        o = manager.find(origemordem.class, object.getIdorigemordem());  
        manager.clear();
        return o;
    }      
}
