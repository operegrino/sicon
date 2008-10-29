/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.refeicao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerRefeicao extends ControllerAncestral implements InterfaceControllerPadrao{
  
    private refeicao Refeicao;
    
    public ControllerRefeicao(){
        Refeicao = new refeicao();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Refeicao.LimparClasse();
        CarregarClasse(Objeto);
        return Refeicao.Gravar(0);        
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Refeicao.Gravar(1);  
    }

    @Override
    public boolean EventoExcluir() {
        return Refeicao.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Refeicao.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Refeicao.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
            
        Refeicao.setDescricao(Objeto.get(0).toString());
    }

    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | idBanco
     *    1      | nome 
     * 
     **************************************************************************/
    
    @Override
    public ArrayList<Object> DevolverDadosClasse() {
        ArrayList ArrayTela = new ArrayList();
        ArrayTela.add(Refeicao.getIdrefeicao().toString());
        ArrayTela.add(Refeicao.getDescricao());
        return ArrayTela;
    }
    
}
