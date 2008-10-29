/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.formapagamento;
import Classes.formapagamentofornecedor;
import Classes.fornecedor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerFormaPagamentoFornecedor extends ControllerAncestral implements InterfaceControllerPadrao{
    
    private fornecedor Fornecedor;
    private formapagamentofornecedor FormaPagamentoFor;
    
    public ControllerFormaPagamentoFornecedor(){
        Fornecedor = new fornecedor();
        FormaPagamentoFor = new formapagamentofornecedor();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Fornecedor.Gravar(1);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Fornecedor.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        ArrayList<formapagamento> Lista = new ArrayList<formapagamento>();
        Fornecedor.setFormaPagamento(Lista);
        return Fornecedor.Gravar(1);
    }
    
    public boolean EventoExcluirPeloId(String idFormaPagamentoFornecedor) {
        return FormaPagamentoFor.Excluir(idFormaPagamentoFornecedor);
    }    

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Fornecedor.LerClasse(id);
        return this.DevolverDadosClasse();
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Vector EventoPesquisarVector(ArrayList<String> ListaParametros) {
        return FormaPagamentoFor.Pesquisar(ListaParametros); 
    }

    @Override
    public void CarregarClasse(ArrayList Objeto) {
        Fornecedor.LimparClasse();
        Fornecedor.LerClasse(Objeto.get(0).toString());
        Collection<formapagamento> ListaForma = new ArrayList<formapagamento>();
        for (Iterator<ArrayList> it = ((ArrayList)Objeto.get(1)).iterator(); it.hasNext();) {
            ArrayList object = it.next();
            formapagamento Forma = new formapagamento();
            Forma.LerClasse(Integer.parseInt(object.get(0).toString()));
            ListaForma.add(Forma);           
        }
        Fornecedor.setFormaPagamento(ListaForma);
    }
    

    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | idFormaPagamento
     *    1      | nome 
     *    2      | dadosbancarios
     * 
     **************************************************************************/    

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ListaRetorno = new ArrayList();
        ListaRetorno.add(Fornecedor.getCodigo());
        ListaRetorno.add(Fornecedor.getRazaosocial());
        ArrayList Lista = new ArrayList();        
        for (Iterator<formapagamento> it = Fornecedor.getFormaPagamento().iterator(); it.hasNext();) {
            formapagamento forma = it.next();
            ArrayList ListaF = new ArrayList();
            ListaF.add(forma.getIdformapagamento());
            ListaF.add(forma.getNome());
            if (forma.getOperacaobancaria() == true) {
                ListaF.add(0);
            }
                ListaF.add(1);            
            Lista.add(ListaF);
        }
        ListaRetorno.add(Lista);
        return ListaRetorno;        
    }
    


}
