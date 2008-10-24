/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public interface InterfaceControllerPadrao {
    
    public boolean EventoSalvar(ArrayList<Object> Objeto);
    
    public boolean EventoAlterar(ArrayList<Object> Objeto);
    
    public boolean EventoExcluir();
    
    public ArrayList<Object> EventoSelecionar(int id);
    
    public List EventoPesquisar(ArrayList<String> ListaParametros);
    
    public void CarregarClasse(ArrayList<Object> Objeto);
    
    public ArrayList DevolverDadosClasse();

}
