/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class UsuarioSistema {
    
    private usuario Usuario;
    private logsistema Log;
    
    private static usuario UsuarioConectado;
    private static int IdLogEntrada;
    
    public UsuarioSistema(){  
        Usuario = new usuario();    
        Log = new logsistema();
    }
    
    public static usuario getUsuarioConectado(){
        return UsuarioSistema.UsuarioConectado;
    }
    
    public static void setUsuarioConectado(usuario Usu){
        UsuarioSistema.UsuarioConectado = Usu;
    }
    
    public static int getidLogEntrada(){
        return UsuarioSistema.IdLogEntrada;
    }
    
    public static void setidLogEntrada(int idLog){
        UsuarioSistema.IdLogEntrada = idLog;
    }
    /*public static String getLogin(){
        return UsuarioSistema.Usuario.getLogin();
    }*/
    
    public usuario getUsuario(){
        return this.Usuario;
    }
    
    
    
    /*public static void setLogin(String Log){
        UsuarioSistema.Login = Log;
    }*/
    
    public boolean CarregarUsuario(String Login){
        this.Usuario.carregarUsuarioSistema(Login);
        if (this.Usuario.getIdusuario() == null) {// .getIdusuario().equals(null) || (this.Usuario.getNomeusuario().equals(null))){
            return false;
        } else return true;
    }
    
    
}
