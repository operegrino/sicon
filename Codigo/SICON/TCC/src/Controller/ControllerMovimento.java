/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.Funcoes;
import Classes.movimento;
import Classes.operacao;
import Classes.produto;
import Classes.unidademedida;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerMovimento extends ControllerAncestral implements InterfaceControllerPadrao{

    private movimento Movimento;
    private movimento MovimentoAlterado;
    
    public ControllerMovimento(){
        super();
        Movimento = new movimento();
        MovimentoAlterado = new movimento();
    }
    
    public Vector CarregarComboUnidade(){
        unidademedida u =  new unidademedida();
        return  u.PesquisarVector(new ArrayList());
    }
    
    public Vector CarregarComboOperacao(){
        operacao o =  new operacao();
        return (Vector) o.Pesquisar(new ArrayList());        
    }
    
     @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        MovimentoAlterado.LimparClasse();
        CarregarClasse(Objeto);
        return MovimentoAlterado.Gravar(0, null);        
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        Movimento.LerClasse(MovimentoAlterado.getIdmovimento());
        CarregarClasse(Objeto);
        return MovimentoAlterado.Gravar(1, Movimento);  
    }

    @Override
    public boolean EventoExcluir() {
        return MovimentoAlterado.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Movimento.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Movimento.Pesquisar(ListaParametros);
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        //Movimento.setIdmovimento(Integer.parseInt(Objeto.get(0).toString()));    
        produto Prod = new produto();
        Prod.LerClasse(Integer.parseInt(Objeto.get(1).toString()));
        MovimentoAlterado.setProduto(Prod);
        MovimentoAlterado.setQuantidade(new BigDecimal(Objeto.get(2).toString()));
        unidademedida uni = new unidademedida();
        uni.LerClasse(Integer.parseInt(Objeto.get(3).toString()));
        MovimentoAlterado.setUnidadeMedida(uni);
        operacao op = new operacao();
        op.LerClasse(Integer.parseInt(Objeto.get(4).toString()));
        MovimentoAlterado.setOperacao(op);
        MovimentoAlterado.setDatamovimento(Funcoes.FormataDataPadrao(Objeto.get(5).toString()));
        MovimentoAlterado.setMotivooperacao(Objeto.get(6).toString());
    }

    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | idMovimento
     *    1      | idProduto     || ArrayList (idProduto, Codigo, NomeProduto) 
     *    2      | Quantidade
     *    3      | idUnidadeMedida
     *    3      | idOperacao
     *    4      | dataOperacao
     *    5      | MotivoOperacao
     **************************************************************************/
    
    @Override
    public ArrayList<Object> DevolverDadosClasse() {
        ArrayList ArrayTela = new ArrayList();
        ArrayTela.add(Movimento.getIdmovimento().toString());
        ArrayList ArrayProduto = new ArrayList();
        ArrayProduto.add(Movimento.getProduto().getIdproduto());
        ArrayProduto.add(Movimento.getProduto().getCodigo());
        ArrayProduto.add(Movimento.getProduto().getNome());
        ArrayProduto.add(Movimento.getProduto().getEstoqueminimo().toString());
        ArrayTela.add(ArrayProduto);
        ArrayTela.add(Movimento.getQuantidade().toString());
        ArrayTela.add(Movimento.getUnidadeMedida().getIdunidademedida());
        ArrayTela.add(Movimento.getOperacao().getIdoperacao());
        ArrayTela.add(Funcoes.FormataDataPadrao(Movimento.getDatamovimento()));
        ArrayTela.add(Movimento.getMotivooperacao().toString());
        return ArrayTela;
    }

}
