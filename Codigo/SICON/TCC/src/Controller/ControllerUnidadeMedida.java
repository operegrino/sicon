/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.unidademedida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerUnidadeMedida extends ControllerAncestral implements InterfaceControllerPadrao {
    
    private unidademedida UnidadeMedida;
    
    public ControllerUnidadeMedida() {
        UnidadeMedida = new unidademedida();
    }

  @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        UnidadeMedida.LimparClasse();
        CarregarClasse(Objeto);
        return UnidadeMedida.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return UnidadeMedida.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return UnidadeMedida.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        UnidadeMedida.LerClasse(id);
        return DevolverDadosClasse();
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return UnidadeMedida.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        UnidadeMedida.setNome(Objeto.get(0).toString());
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | nome 
     **************************************************************************/    

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ListaFormaPagamento = new ArrayList();
        ListaFormaPagamento.add(UnidadeMedida.getNome());
        return ListaFormaPagamento;
    }
    

}
