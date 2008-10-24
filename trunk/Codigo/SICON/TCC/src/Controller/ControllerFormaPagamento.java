/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.formapagamento;
import Classes.perfil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerFormaPagamento extends ControllerAncestral implements InterfaceControllerPadrao{

    private formapagamento FormaPagamento;
    
    public ControllerFormaPagamento() {
        FormaPagamento = new formapagamento();
    }
    
    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        FormaPagamento.LimparClasse();
        CarregarClasse(Objeto);
        return FormaPagamento.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return FormaPagamento.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return FormaPagamento.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        FormaPagamento.LerClasse(id);
        return DevolverDadosClasse();
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return FormaPagamento.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        FormaPagamento.setNome(Objeto.get(0).toString());
        if ((Objeto.get(1).equals("0"))) {
            FormaPagamento.setOperacaobancaria(true);
        } else FormaPagamento.setOperacaobancaria(false);
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | nome 
     *    1      | OperacaoBancaria
     **************************************************************************/    

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ListaFormaPagamento = new ArrayList();
        ListaFormaPagamento.add(FormaPagamento.getNome());
        if (FormaPagamento.getOperacaobancaria()) {
            ListaFormaPagamento.add("0");
        } else ListaFormaPagamento.add("1");
        return ListaFormaPagamento;
    }

}
