/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.botao;
import Classes.perfil;
import Classes.perfiltela;
import Classes.tela;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author jonathan
 */
public class ControllerPerfil extends ControllerAncestral implements InterfaceControllerPadrao{

    private perfil Perfil;
    private perfiltela PerfilTela;
    private tela Tela;
    
    public ControllerPerfil(){
        Perfil = new perfil();
        Tela   = new tela();      
    }
    
    @Override
    public boolean EventoSalvar(ArrayList Objeto) {
        Perfil.LimparClasse();
        CarregarClasse(Objeto);
        return Perfil.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Perfil.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return Perfil.Excluir();  
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Perfil.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public ArrayList<Object> EventoPesquisar(ArrayList<String> ListaParametros) {
        return Perfil.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList Objeto) {
        int cont = 0;
        ArrayList<perfiltela> ListaPerfil = new ArrayList<perfiltela>();
        Perfil.setNome((String)Objeto.get(0));
        Perfil.setAdministrador(false);
        Perfil.setPerfiltelaCollection(null);
        for (Iterator<ArrayList> it = ((ArrayList)Objeto.get(2)).iterator(); it.hasNext();) {
            ArrayList object = it.next();   
            for (Iterator<Integer> ite = ((ArrayList)object.get(2)).iterator(); ite.hasNext();) {
                int cont2 = 0;
                Integer IdBotao = ite.next();                  
                perfiltela PT = new perfiltela();
                PT.setIdperfiltela(IdBotao);
                PT.tela = new tela();
                PT.tela.LerClasse(Integer.parseInt((String)object.get(3)));                                  
                PT.Botao = new botao();
                PT.Botao.LerClasse(IdBotao);
                PT.perfil = new perfil();
                PT.perfil = Perfil;
                cont2++; 
                ListaPerfil.add(PT);
            }
                   
        }
        Perfil.setPerfiltelaCollection(ListaPerfil);
        /*Tela.setTitulomenu((String)Objeto.get(2));
        ArrayList<botao> ListaBot = new ArrayList<botao>();        
        while (((ArrayList)Objeto.get(3)).size()  > cont) {
            ListaBot.add(BotaoCarregado(((ArrayList<Object>)((ArrayList)Objeto.get(3)).get(cont))));
            cont++;
        }
        Tela.setbotaoCollection(ListaBot);*/
    }

    @Override
    public ArrayList<Object> DevolverDadosClasse() {
        ArrayList ListaTela = new ArrayList();    
        ListaTela.add(Perfil.getNome());
        ListaTela.add(Perfil.getAdministrador());
        ArrayList TelaAcesso = new ArrayList();
        for (Iterator<perfiltela> it = Perfil.getPerfiltelaCollection().iterator(); it.hasNext();) {
            perfiltela pt = it.next();            
           // pt.tela.LerClasse((Integer)Array.get(2));
          //  pt.Botao.LerClasse((Integer)Array.get(3));
            ArrayList Acesso = new ArrayList();
            Acesso.add(pt.getIdtela().getTitulotela());
            Acesso.add(pt.getbotao().getTitulobotao());  
            Acesso.add(pt.getbotao().getIdbotao());
            Acesso.add(pt.getIdtela().getIdtela().toString());
            TelaAcesso.add(Acesso);
        }
        ListaTela.add(FormatarArray(TelaAcesso));
        /*Collections.sort(TelaAcesso, new Comparator() {  
             public int compare(ArrayList o1, ArrayList o2) {  
                 (String)((ArrayList)o1.get(0)).get(0);  
                 String s2 = (String) o2;  
                 return s1.compareTo(s2);  
             }  
         });          
        
        /*ListaTela.add(Tela.getTitulomenu());
        ArrayList<Object> ListaBot = new ArrayList<Object>();    
        for (botao bot : Tela.getbotaoCollection()) {
            ListaBot.add(CarregaBotao(bot));
        }
        ListaTela.add(ListaBot);
        return ListaTela;*/
        return ListaTela;
    }
    
    private ArrayList FormatarArray(ArrayList Acesso) {
        ArrayList AcessoFormatado = new ArrayList();
        int cont = 0;
        String sTela = (String)((ArrayList)Acesso.get(0)).get(0);
        String sTelaIgual = sTela;
        String Botoes = "";
        ArrayList IdBotInterno = new ArrayList();
        boolean adiconou = false;        
        while (Acesso.size() > cont) {
            Botoes = "";
            sTelaIgual = sTela;
            ArrayList Array = new ArrayList();
            String idTela = "";
            while (sTela.equals(sTelaIgual)) {
                idTela = ((ArrayList)Acesso.get(cont)).get(3).toString();
                Botoes = Botoes + ", " + ((ArrayList)Acesso.get(cont)).get(1).toString();
                Array.add((Integer)((ArrayList)Acesso.get(cont)).get(2));
                cont++;
                if (cont >= Acesso.size()) {
                    sTela = "";
                } else {
                    sTela = ((ArrayList)Acesso.get(cont)).get(0).toString();
                }
            }
            ArrayList TelaBotao = new ArrayList();            
            TelaBotao.add(sTelaIgual);
            TelaBotao.add(Botoes.substring(1, Botoes.length()));
            TelaBotao.add(Array);     
            TelaBotao.add(idTela);
            AcessoFormatado.add(TelaBotao);
        }
        return AcessoFormatado;
    }
    
    /***************************************************
     *   Métodos pertencentes a apenas está Controller
    ****************************************************/
    public ArrayList TelaEscolhida(int idTela) {
    // retorna um arrayList com os botoes da tela passado como parametro(id da tela passado)
    // com o titulo do botão e a descrição;
        Tela.LimparClasse();
        Tela.LerClasse(idTela);
        ArrayList ListaBotao = new ArrayList();
        for (Iterator<botao> it = Tela.getbotaoCollection().iterator(); it.hasNext();) {
            botao Botao = it.next();
            ArrayList Lista = new ArrayList();
            Lista.add(Botao.getTitulobotao());
            Lista.add(Botao.getDescricaobotao());
            Lista.add(Tela.getTitulotela());
            Lista.add(Botao.getIdbotao());
            Lista.add(Tela.getIdtela());
            ListaBotao.add(Lista);            
        }
        return ListaBotao;
    }
}
