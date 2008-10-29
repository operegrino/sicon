/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author Jonathan
 */
public class ConfiguracoesStatic {
    
    private static String remetente;
    private static String senha;
    private static String tituloMensagem;
    private static String textoMensagem;
    private static String CaminhoArquivo;

    public static String getRemetente() {
        return remetente;
    }

    public static void setRemetente(String aRemetente) {
        remetente = aRemetente;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String aSenha) {
        senha = aSenha;
    }

    public static String getTituloMensagem() {
        return tituloMensagem;
    }

    public static void setTituloMensagem(String aTituloMensagem) {
        tituloMensagem = aTituloMensagem;
    }

    public static String getTextoMensagem() {
        return textoMensagem;
    }

    public static void setTextoMensagem(String aTextoMensagem) {
        textoMensagem = aTextoMensagem;
    }

    public static String getCaminhoArquivo() {
        return CaminhoArquivo;
    }

    public static void setCaminhoArquivo(String aCaminhoArquivo) {
        CaminhoArquivo = aCaminhoArquivo;
    }
}
