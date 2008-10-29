/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.cardapio;
import Classes.fichatecnica;
import Classes.refeicao;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerCardapio extends ControllerAncestral implements InterfaceControllerPadrao{

    private cardapio Cardapio;
    public ControllerCardapio(){
        super();
        Cardapio = new cardapio();
    }
    
    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Cardapio.LimparClasse();
        CarregarClasse(Objeto);
        return Cardapio.Gravar(0);   
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Cardapio.Gravar(1);  
    }

    @Override
    public boolean EventoExcluir() {
        return Cardapio.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Cardapio.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Cardapio.Pesquisar(ListaParametros);
    }
    
    public Vector EventoPesquisarVector(ArrayList<String> ListaParametros) {
        return (Vector)Cardapio.Pesquisar(ListaParametros);
    }    

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Cardapio.setData(new Date(Objeto.get(0).toString()));
        Cardapio.setQtderefeicoes(Integer.parseInt(Objeto.get(1).toString()));
        refeicao Ref = new refeicao();
        Ref.LerClasse(Integer.parseInt(Objeto.get(2).toString()));
        Cardapio.setIdrefeicao(Ref);
        ArrayList<fichatecnica> Lista = new ArrayList<fichatecnica>();
        for (Iterator<ArrayList> it = ((ArrayList)Objeto.get(3)).iterator(); it.hasNext();) {
            ArrayList L = it.next();
            fichatecnica Ficha = new fichatecnica();
            Ficha.LerClasse(Integer.parseInt(L.get(0).toString())); 
            Lista.add(Ficha);
        }
        Cardapio.setListaFichaTecnica(Lista);
    }

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ListaRetorno = new ArrayList();
        ListaRetorno.add(Cardapio.getIdcardapio().toString());
        ListaRetorno.add(Cardapio.getData().toString());
        ListaRetorno.add(String.valueOf(Cardapio.getQtderefeicoes()));
        ListaRetorno.add(Cardapio.getIdrefeicao().getIdrefeicao().toString());
        ListaRetorno.add(Cardapio.getIdrefeicao().getDescricao());
        ArrayList ListaFicha = new ArrayList();
        for (Iterator<fichatecnica> it = Cardapio.getListaFichaTecnica().iterator(); it.hasNext();) {
            fichatecnica ficha = it.next();
            ArrayList Lista = new ArrayList();            
            Lista.add(ficha.getIdfichatecnica());
            Lista.add(ficha.getNomepreparacao());            
            ListaFicha.add(Lista);
        }
        ListaRetorno.add(ListaFicha);
        return ListaRetorno;
                               
    }

}
