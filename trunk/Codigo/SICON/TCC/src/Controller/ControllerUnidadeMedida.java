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
    public void CarregarClasse(ArrayList Objeto) {
        UnidadeMedida.setNome(Objeto.get(0).toString());
        if (Integer.parseInt(Objeto.get(1).toString()) == 0) {
            UnidadeMedida.setMiligrama(true);
        } else UnidadeMedida.setMiligrama(false);
        if (Integer.parseInt(Objeto.get(2).toString()) == 0) {
            UnidadeMedida.setgrama(true);
        } else UnidadeMedida.setgrama(false);
        if (Integer.parseInt(Objeto.get(3).toString()) == 0) {
            UnidadeMedida.setQuilograma(true);
        } else UnidadeMedida.setQuilograma(false);
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | nome 
     *    1      | Miligrama
     *    2      | Grama
     *    3      | Quilograma
     **************************************************************************/    

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ListaFormaPagamento = new ArrayList();
        ListaFormaPagamento.add(UnidadeMedida.getNome());
        if (UnidadeMedida.getMiligrama()) {
            ListaFormaPagamento.add(0);
        } else ListaFormaPagamento.add(1);
        if (UnidadeMedida.getgrama()) {
            ListaFormaPagamento.add(0);
        } else ListaFormaPagamento.add(1);
        if (UnidadeMedida.getQuilograma()) {
            ListaFormaPagamento.add(0);
        } else ListaFormaPagamento.add(1);        
        return ListaFormaPagamento;
    }
    

}
