/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Componentes;

import Controller.ControllerAncestral;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class MensagensDefinidas {

    private ControllerAncestral Controller;
    
    public MensagensDefinidas(){
        Controller = new ControllerAncestral();
    }
    
    public int ExibirMensagem(int idMensagem){        
        ArrayList Mensagem = new ArrayList();
        Mensagem = Controller.RetornaMensagemETipo(idMensagem);
        int retorno = 0;
        switch ((Integer)Mensagem.get(1)){
            // Error_Message | Mensagem de erro
            case 1:
                JOptionPane.showMessageDialog(null, Mensagem.get(0).toString(), "SICON", JOptionPane.ERROR_MESSAGE, 
                new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));
                break;
            // Information Message | Mensagem de Informação    
            case 2:
                JOptionPane.showMessageDialog(null, Mensagem.get(0).toString(), "SICON", JOptionPane.INFORMATION_MESSAGE, 
                new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\selecionar.png"));
                break;
            // Warnig Message | Mensagem de Aviso
            case 3:
                JOptionPane.showMessageDialog(null, Mensagem.get(0).toString(), "SICON", JOptionPane.WARNING_MESSAGE, null);                
                break;
            //Question Message | Pergunta
            case 4:
                retorno = JOptionPane.showConfirmDialog(null, Mensagem.get(0).toString(), "SICON", 0, JOptionPane.QUESTION_MESSAGE, null);                
                break;
            //Plain Message | Mensagem
            case 5:
                JOptionPane.showMessageDialog(null, Mensagem.get(0).toString(), "SICON", JOptionPane.PLAIN_MESSAGE, null);                                
                break;
            // mensagem personalizada para o envio de email.
            case 6:
                    Object[] options = {"Enviar Arquivo",
                    "Não enviar",
                    "Visualizar"};                
                retorno = JOptionPane.showOptionDialog(null, Mensagem.get(0).toString(), "SICON", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);                                
                break;                
        }
        return retorno;
    }
    
    public int ExibirMensagemPersonalizada(String Mensagem, int tipo){
        int retorno = 0;        
        switch (tipo){
            // Error_Message | Mensagem de erro
            case 1:
                JOptionPane.showMessageDialog(null, Mensagem, "SICON", JOptionPane.ERROR_MESSAGE, 
                new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\delete.png"));
                break;
            // Information Message | Mensagem de Informação    
            case 2:
                JOptionPane.showMessageDialog(null, Mensagem, "SICON", JOptionPane.INFORMATION_MESSAGE, 
                new javax.swing.ImageIcon("C:\\Documents and Settings\\Jonathan\\workspace NetBeans\\TCC\\src\\Icones\\selecionar.png"));
                break;
            // Warnig Message | Mensagem de Aviso
            case 3:
                JOptionPane.showMessageDialog(null, Mensagem, "SICON", JOptionPane.WARNING_MESSAGE, null);                
                break;
            //Question Message | Pergunta
            case 4:
                retorno = JOptionPane.showConfirmDialog(null, Mensagem, "SICON", 0, JOptionPane.QUESTION_MESSAGE, null);                
                break;
            //Plain Message | Mensagem
            case 5:
                JOptionPane.showMessageDialog(null, Mensagem, "SICON", JOptionPane.PLAIN_MESSAGE, null);                
                break;
            }       
        return retorno;
    }
}
