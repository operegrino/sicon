/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "configuracoes")
public class Configuracoes implements Serializable {

    public static String getTituloMensagemDefault() {
        return TituloMensagemDefault;
    }

    public static void setTituloMensagemDefault(String aTituloMensagemDefault) {
        TituloMensagemDefault = aTituloMensagemDefault;
    }

    public static String getTextoMensagemDefault() {
        return TextoMensagemDefault;
    }

    public static void setTextoMensagemDefault(String aTextoMensagemDefault) {
        TextoMensagemDefault = aTextoMensagemDefault;
    }
   
    @Id
    @Column(name = "idconfiguracoes", nullable = false)
    private Integer idConfiguracoes;
    @Column(name = "remetente", nullable = true)
    private String Remetente;
    @Column(name = "senha", nullable = true)
    private String Senha;
    @Column(name = "titulomensagem", nullable = true)
    private String TituloMensagem;
    @Column(name = "textomensagem", nullable = true)
    private String TextoMensagem;
    
    private static String TituloMensagemDefault = "Solicitação de Compra";
    private static String TextoMensagemDefault = "Segue anexo uma planilha com os produtos dos quais necessito. " +
                                                 "Solicito que retorne uma lista(em excel) com os produtos " +
                                                 "disponiveis juntamente com seu preço.";
    

    public String getRemetente() {
        return Remetente;
    }

    public void setRemetente(String aRemetente) {
        Remetente = aRemetente;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String aSenha) {
        Senha = aSenha;
    }

    public String getTituloMensagem() {
        return TituloMensagem;
    }

    public void setTituloMensagem(String aTituloMensagem) {
        TituloMensagem = aTituloMensagem;
    }

    public String getTextoMensagem() {
        return TextoMensagem;
    }

    public void setTextoMensagem(String aTextoMensagem) {
        TextoMensagem = aTextoMensagem;
    }

    public Integer getIdConfiguracoes() {
        return idConfiguracoes;
    }

    public void setIdConfiguracoes(Integer idConfiguracoes) {
        this.idConfiguracoes = idConfiguracoes;
    }
    
    public void setConfiguracoesStatic(){
        ConfiguracoesStatic.setRemetente(this.Remetente);
        ConfiguracoesStatic.setSenha(this.getSenha());
        ConfiguracoesStatic.setTituloMensagem(this.getTituloMensagem());
        ConfiguracoesStatic.setTextoMensagem(this.getTextoMensagem());
    }
    
    public void ValidaAlteracoes(){
        if (this.getTextoMensagem().equals("")) {
            this.setTextoMensagem(getTextoMensagemDefault());            
        }
        if (this.getTituloMensagem().equals("")) {
            this.setTituloMensagem(getTituloMensagemDefault());
        }
    }

}
