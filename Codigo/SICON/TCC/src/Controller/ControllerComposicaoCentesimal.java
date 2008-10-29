/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.composicaocentesimal;
import Classes.produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerComposicaoCentesimal extends ControllerAncestral implements InterfaceControllerPadrao{
    
    private produto Produto;
    
    public ControllerComposicaoCentesimal(){
        super();
        Produto = new produto();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
         return false;
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Produto.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        composicaocentesimal C = new composicaocentesimal();
        C.setIdcomposicaocentesimal(Produto.getIdcomposicaocentesimal().getIdcomposicaocentesimal());
        Produto.setIdcomposicaocentesimal(C);
        return Produto.Gravar(1);
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Produto.LerClasse(id);
        return DevolverDadosClasse();
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        composicaocentesimal C = new composicaocentesimal();        
        return C.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        composicaocentesimal Comp = new composicaocentesimal();
        Produto.LerClasse(Integer.valueOf(Objeto.get(0).toString()));
        Comp.setIdcomposicaocentesimal(Produto.getIdcomposicaocentesimal().getIdcomposicaocentesimal());
        Comp.setEnergia(new BigDecimal(Objeto.get(1).toString()));
        Comp.setCarboidrato(new BigDecimal(Objeto.get(2).toString()));
        Comp.setProteina(new BigDecimal(Objeto.get(3).toString()));
        Comp.setLipideo(new BigDecimal(Objeto.get(4).toString()));
        Comp.setCalcio(new BigDecimal(Objeto.get(5).toString()));
        Comp.setFerro(new BigDecimal(Objeto.get(6).toString()));
        Comp.setVitaminac(new BigDecimal(Objeto.get(7).toString()));
        Produto.setIdcomposicaocentesimal(Comp);
    }

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList Lista = new ArrayList();
        Lista.add(Produto.getIdproduto());
        Lista.add(Produto.getNome());
        Lista.add(Produto.getIdcomposicaocentesimal().getEnergia());
        Lista.add(Produto.getIdcomposicaocentesimal().getCarboidrato());
        Lista.add(Produto.getIdcomposicaocentesimal().getProteina());
        Lista.add(Produto.getIdcomposicaocentesimal().getLipideo());
        Lista.add(Produto.getIdcomposicaocentesimal().getCalcio());
        Lista.add(Produto.getIdcomposicaocentesimal().getFerro());
        Lista.add(Produto.getIdcomposicaocentesimal().getVitaminac());
        return Lista;
    }
    
    
    
    

}
