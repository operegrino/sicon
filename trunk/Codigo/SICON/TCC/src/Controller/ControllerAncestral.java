/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.mensagens;

/**
 *
 * @author Jonathan
 */
public class ControllerAncestral {
    
    protected mensagens Mensagens;
    
    public ControllerAncestral(){
        Mensagens = new mensagens();    
    }
    
    public String RetornaMensagem(int Codigo){
        return Mensagens.RetornaMensagem(Codigo);
    }

}
