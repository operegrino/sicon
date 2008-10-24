/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public interface InterfacePadraoClasse {
    
    public boolean Gravar(int Operacao);
    
    public boolean Excluir();
    
    public List Pesquisar(ArrayList<String> ListaParametros);
    
    public void LimparClasse();
    
    public void LerClasse(int Id);
    
    public void CarregarClasse(Object object) throws Exception;

}
