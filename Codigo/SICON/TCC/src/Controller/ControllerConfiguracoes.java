/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.Configuracoes;
import Classes.ConfiguracoesStatic;
import Dao.Classes.DaoConfiguracoes;
import Telas.Formulario.TelaConfiguracoes;
import java.sql.SQLException;

/**
 *
 * @author Jonathan
 */
public class ControllerConfiguracoes {
    
    private Configuracoes objConf;
    public ControllerConfiguracoes(){
        objConf = new Configuracoes();
    }
    
    public void ComporConfiguracoes(TelaConfiguracoes objForm){
        objConf.setRemetente(objForm.getRemetente());
        objConf.setSenha(objForm.getSenha());
        objConf.setTituloMensagem(objForm.getTituloMensagem());
        objConf.setTextoMensagem(objForm.getTextoMensagem());
        objConf.setIdConfiguracoes(1);
    }
    
    public void RestaurarConfiguracoes()throws SQLException, Exception{
        objConf.setIdConfiguracoes(1);
        objConf.setRemetente("");
        objConf.setSenha("");
        objConf.setTituloMensagem(Configuracoes.getTituloMensagemDefault());
        objConf.setTextoMensagem(Configuracoes.getTextoMensagemDefault());
        DaoConfiguracoes ConfDao = new DaoConfiguracoes();
        ConfDao.Alterar(objConf);
        objConf.setConfiguracoesStatic();
    }
    
    public void SalvarAlteracoes(TelaConfiguracoes objForm) throws SQLException, Exception{
        DaoConfiguracoes ConfDao = new DaoConfiguracoes();
        ComporConfiguracoes(objForm);
        objConf.ValidaAlteracoes();
        ConfDao.Alterar(objConf);
        objConf.setConfiguracoesStatic();
    }

    public void ComporConfiguracoesForm(TelaConfiguracoes objForm){
        CarregarConfiguracoes();        
        objForm.setRemetente(objConf.getRemetente());
        objForm.setSenha(objConf.getSenha());
        objForm.setTituloMensagem(objConf.getTituloMensagem());
        objForm.setTextoMensagem(objConf.getTextoMensagem());
    }
    
    public void CarregarConfiguracoes(){
        DaoConfiguracoes daoConf = new DaoConfiguracoes();
        objConf.setIdConfiguracoes(1);
        objConf = daoConf.CarregarObjeto(objConf);
    }
}
