/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.mensagens;
import java.util.ArrayList;

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
    
    public ArrayList RetornaMensagemETipo(int Codigo){
        ArrayList Lista = new ArrayList();
        Mensagens.LerClasse(Codigo);
        Lista.add(Mensagens.getMensagem());
        Lista.add(Mensagens.getTipoMensagem());
        return Lista;
    }

}
