/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.botao;
import Classes.tela;
import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class ControllerTela extends ControllerAncestral implements InterfaceControllerPadrao {
    
    private tela Tela;
    private botao Botao;
    
    public ControllerTela() {
        Tela = new tela(); 
        Botao = new botao();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Tela.LimparClasse();
        CarregarClasse(Objeto);
        return Tela.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Tela.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return Tela.Excluir();  
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Tela.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public ArrayList<Object> EventoPesquisar(ArrayList<String> ListaParametros) {
        return Tela.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        int cont = 0;
        Tela.setNometela((String)Objeto.get(0));
        Tela.setTitulotela((String)Objeto.get(1));
        Tela.setTitulomenu((String)Objeto.get(2));
        ArrayList<botao> ListaBot = new ArrayList<botao>();        
        while (((ArrayList)Objeto.get(3)).size()  > cont) {
            ListaBot.add(BotaoCarregado(((ArrayList<Object>)((ArrayList)Objeto.get(3)).get(cont))));
            cont++;
        }
        Tela.setbotaoCollection(ListaBot);
    }

    @Override
    public ArrayList<Object> DevolverDadosClasse() {
        ArrayList<Object> ListaTela = new ArrayList<Object>();    
        ListaTela.add(Tela.getNometela());
        ListaTela.add(Tela.getTitulotela());        
        ListaTela.add(Tela.getTitulomenu());
        ArrayList<Object> ListaBot = new ArrayList<Object>();    
        for (botao bot : Tela.getbotaoCollection()) {
            ListaBot.add(CarregaBotao(bot));
        }
        ListaTela.add(ListaBot);
        return ListaTela;
    }
    
    public ArrayList<Object> AdicionarBotao(int id){
        Botao.LerClasse(id);
        return CarregaBotao(Botao);
    }
    
    private ArrayList<Object> CarregaBotao(botao Bot){
        ArrayList<Object> ListaBotao = new ArrayList<Object>();
        ListaBotao.add(Bot.getIdbotao());
        ListaBotao.add(Bot.getTitulobotao());
        ListaBotao.add(Bot.getNomebotao());
        ListaBotao.add(Bot.getDescricaobotao());
        return ListaBotao;
    }
    
    private botao BotaoCarregado(ArrayList<Object> ListaBot) {
        botao bot = new botao();
        bot.setIdbotao((Integer)ListaBot.get(0));
        bot.setNomebotao(ListaBot.get(1).toString());
        bot.setTitulobotao(ListaBot.get(2).toString());
        bot.setDescricaobotao(ListaBot.get(3).toString());
        return bot;        
    }
    

}
