/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.botao;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class ControllerBotao extends ControllerAncestral implements InterfaceControllerPadrao{

    private botao Botao; 
    
    public ControllerBotao(){
        Botao = new botao();   
    }
    
    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Botao.LimparClasse();
        CarregarClasse(Objeto);
        return Botao.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Botao.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return Botao.Excluir();  
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Botao.LerClasse(id);
        return DevolverDadosClasse();
    }

    @Override
    public ArrayList EventoPesquisar(ArrayList<String> ListaParametros) {
        return Botao.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Botao.setTitulobotao((String)Objeto.get(0));
        Botao.setNomebotao((String)Objeto.get(1));
        Botao.setDescricaobotao((String)Objeto.get(2));        
    }

    @Override
    public ArrayList<Object> DevolverDadosClasse() {
        ArrayList<Object> BotaoLista = new ArrayList<Object>();
        BotaoLista.add(Botao.getTitulobotao());
        BotaoLista.add(Botao.getNomebotao());        
        BotaoLista.add(Botao.getDescricaobotao());
        return BotaoLista;
    }

}
