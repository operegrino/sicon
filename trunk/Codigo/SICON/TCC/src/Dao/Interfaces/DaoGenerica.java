/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public interface DaoGenerica<T> {
    
    public boolean Salvar(T object);
    
    public boolean Alterar(T object);
    
    public boolean Excluir(T object);
    
    public List Pesquisar(ArrayList<String> ListaParametros);
    
    public T CarregarObjeto(T object);


}
