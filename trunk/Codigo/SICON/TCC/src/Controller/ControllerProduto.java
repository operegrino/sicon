/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.composicaocentesimal;
import Classes.produto;
import Classes.unidademedida;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author jonathan
 */
public class ControllerProduto extends ControllerAncestral implements InterfaceControllerPadrao{

    private produto Produto;
    private unidademedida Unidade;
    
    public ControllerProduto() {
        super();
        Produto = new produto();
        Unidade = new unidademedida();
    }
    
   @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Produto.LimparClasse();
        CarregarClasse(Objeto);
        return Produto.Gravar(0);    
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Produto.Gravar(1);  
    }

    @Override
    public boolean EventoExcluir() {
        return Produto.Excluir();
    }
    
    public boolean EventoExcluir(int Id){
        Produto.LerClasse(Id);
        return Produto.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Produto.LerClasse(id);
        return DevolverDadosClasse();   
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Produto.Pesquisar(ListaParametros);
    }
    
    public Vector EventoRetornaTodasUnidades(){
        return (Vector)Unidade.PesquisarVector(new ArrayList<String>());
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Produto.setCodigo(Objeto.get(1).toString());
        Produto.setNome(Objeto.get(2).toString());
        Produto.setValor(new BigDecimal(Objeto.get(3).toString()));
        Produto.setEstoqueminimo(new BigDecimal(Objeto.get(4).toString()));
        Produto.setQtdeembalagem(new BigDecimal(Objeto.get(5).toString()));
        Produto.setTemperaturaentrega(new BigDecimal(Objeto.get(6).toString()));
        if (Integer.parseInt(Objeto.get(7).toString()) == 0)  {
            Produto.setAlimentar(true);
        } else Produto.setAlimentar(false);   
        composicaocentesimal Composicao = new composicaocentesimal();        
        if (Objeto.get(8) != null) {
        Composicao.LerClasse(Integer.parseInt(Objeto.get(8).toString()));            
        }
        Produto.setIdcomposicaocentesimal(Composicao);
        Unidade.LerClasse(Integer.parseInt(Objeto.get(9).toString()));
        Produto.setUnidadeEmbalagem(Unidade);
        Unidade.LerClasse(Integer.parseInt(Objeto.get(10).toString()));
        Produto.setUnidadeEstoque(Unidade);
    }
    
    public Integer RetornaIdComposicao(){
        return Produto.getIdcomposicaocentesimal().getIdcomposicaocentesimal();
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | idproduto
     *    1      | codigo 
     *    2      | nome
     *    3      | valor
     *    4      | estoqueminimo
     *    5      | qtdeembalagem
     *    6      | temperaturaentrega
     *    7      | alimentar
     *    8      | composicaocentesimal | id apenas
     *    9      | UnidadeEmbalagem id apenas
     *   10      | UnidadeEstoque id apenas
     **************************************************************************/    

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ArrayTela = new ArrayList();
        ArrayTela.add(Produto.getIdproduto());
        ArrayTela.add(Produto.getCodigo());
        ArrayTela.add(Produto.getNome());
        ArrayTela.add(Produto.getValor());
        ArrayTela.add(Produto.getEstoqueminimo());
        ArrayTela.add(Produto.getQtdeembalagem());
        ArrayTela.add(Produto.getTemperaturaentrega());
        if (Produto.getAlimentar() == true) {
            ArrayTela.add(0);
        } else ArrayTela.add(1);        
        ArrayTela.add(Produto.getIdcomposicaocentesimal().getIdcomposicaocentesimal());
        ArrayTela.add(Produto.getUnidadeEmbalagem().getIdunidademedida());
        ArrayTela.add(Produto.getUnidadeEstoque().getIdunidademedida());
        return ArrayTela;
    }

}
