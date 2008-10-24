/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.cargo;
import java.util.ArrayList;

/**
 *
 * @author   : jonathan
 * @Objetivo : Controlar as ações da tela.
 */
public class ControllerCargo extends ControllerAncestral implements InterfaceControllerPadrao{
    
    private cargo Cargo;
    
    public ControllerCargo(){
        Cargo = new cargo();        
    }
    
    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto){
        Cargo.LimparClasse();
        CarregarClasse(Objeto);
        return Cargo.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Cargo.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return Cargo.Excluir();    
    }

    @Override
    public ArrayList EventoPesquisar(ArrayList<String> ListaParametros) {
        return Cargo.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) { 
        Cargo.setDescricao((String)Objeto.get(0));
    }

    @Override
    public ArrayList<Object> DevolverDadosClasse() {
        ArrayList<Object> CargoLista = new ArrayList<Object>();
        CargoLista.add(Cargo.getDescricao());
        return CargoLista;
    }
    
    @Override
    public ArrayList<Object> EventoSelecionar(int id){
        Cargo.LerClasse(id);
        return DevolverDadosClasse();
    }


}
