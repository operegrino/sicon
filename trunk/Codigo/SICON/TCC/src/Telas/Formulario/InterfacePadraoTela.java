/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Formulario;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Jonathan
 */
public interface InterfacePadraoTela {
    
    public void IniciarTela();
    
    public void setPanelTela(JPanel jpnPesquisa, JPanel jpnCadastro, JPanel jpnPrincipal);
    
    public ArrayList<String> setParametros();
    
    public ArrayList<Object> TelaParaController();
    
    public void ControllerParaTela(ArrayList<Object> Objeto);
    
    public int RetornaId(int Linha);
    
}
