/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Formulario;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Jonathan
 */
public interface InterfacePadraoTelaVarias extends InterfacePadraoTela {    
    
    /*Método utilizado para poder abrir uma outra tela a partir da tela que implementar esta interface.
     * É criado na tela em questão um desktopane e então setado com o da tela de inicio(Menus); 
    */
    public void setDesktopPane(JDesktopPane Pane);
    
    /*Quando o usuário selecionar um registro na tela e for necessario carregar uma grid na tela de cadastro,
     * então carregamos um ArrayList na tela com a propriedade que é essa coleção na classe; 
    */ 
    public void SetArraySelecionar();
    
    /*Método necessário para abrir uma outra tela qdo o usuario clicar no botão com 3 pontos; 
    */ 
    public void CarregarTela(JInternalFrame Frame);
    
    public void setComportamentoTable(boolean Comportamento);

}
