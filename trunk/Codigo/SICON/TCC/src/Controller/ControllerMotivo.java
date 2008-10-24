/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.motivo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerMotivo extends ControllerAncestral implements InterfaceControllerPadrao {
    
    private motivo Motivo;
    
    public ControllerMotivo() {
        Motivo = new motivo();
    }

  @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Motivo.LimparClasse();
        CarregarClasse(Objeto);
        return Motivo.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Motivo.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return Motivo.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Motivo.LerClasse(id);
        return DevolverDadosClasse();
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Motivo.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Motivo.setNome(Objeto.get(0).toString());
        if ((Objeto.get(1).equals("0"))) {
            Motivo.setBaixar(true);
        } else Motivo.setBaixar(false);
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | nome 
     *    1      | Baixar
     **************************************************************************/    

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ListaFormaPagamento = new ArrayList();
        ListaFormaPagamento.add(Motivo.getNome());
        if (Motivo.getBaixar()) {
            ListaFormaPagamento.add("0");
        } else ListaFormaPagamento.add("1");
        return ListaFormaPagamento;
    }
    

}
