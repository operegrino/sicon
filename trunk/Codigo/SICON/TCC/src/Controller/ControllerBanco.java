/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.banco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerBanco extends ControllerAncestral implements InterfaceControllerPadrao{

    private banco Banco;
    
    public ControllerBanco(){
        Banco = new banco();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Banco.LimparClasse();
        CarregarClasse(Objeto);
        return Banco.Gravar(0);        
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Banco.Gravar(1);  
    }

    @Override
    public boolean EventoExcluir() {
        return Banco.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Banco.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Banco.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Banco.setIdbanco(Integer.parseInt(Objeto.get(0).toString()));    
        Banco.setNome(Objeto.get(1).toString());
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
        ArrayTela.add(Banco.getIdbanco().toString());
        ArrayTela.add(Banco.getNome());
        return ArrayTela;
    }
}
