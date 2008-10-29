/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.Funcoes;
import Classes.ordemproducao;
import Classes.ordemproduto;
import Classes.origemordem;
import Classes.produto;
import Classes.refeicao;
import Classes.situacaoordem;
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
public class ControllerOrdemProducao extends ControllerAncestral implements InterfaceControllerPadrao{

    private ordemproducao Ordem;
    private unidademedida Unidade;
    
    public ControllerOrdemProducao(){
        super();
        Ordem = new ordemproducao();
        Unidade = new unidademedida();
    }
    
    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        return false;
    }
    
    /**************************************************************************
     * Efetua a baixa no estoque;
     * Instancia a ordem de produção pela lista dos ids passados como parametro;
     * Retorno : se houve algum problema durante o processo retorna um ArrayList com 
     *           numero da ordem e o codigo do erro
     *           erro 1 : problema gravação;
     *           erro 2 : a ordem está já está realizada;
     *           erro 3 : a ordem está cancelada; 
     *
     *************************************************************************/
    public ArrayList BaixaOrdem(ArrayList ListaBaixar){
        ArrayList ListaRetorno = new ArrayList();
        for (Iterator<Integer> it = ListaBaixar.iterator(); it.hasNext();) {
            Integer idOrdem = it.next();
            ArrayList ListaErro = new ArrayList();
            Ordem.LerClasse(idOrdem);
            if (Ordem.getIdsituacaoordem().getIdsituacaoordem() == 2) {
                ListaErro.add(Ordem.getIdordemproducao());
                ListaErro.add(2);
            } else if (Ordem.getIdsituacaoordem().getIdsituacaoordem() == 3) {
                ListaErro.add(Ordem.getIdordemproducao());
                ListaErro.add(3);
            } else if (!(Ordem.BaixaOrdem())){
                ListaErro.add(Ordem.getIdordemproducao());
                ListaErro.add(1);                    
            }            
            ListaRetorno.add(ListaErro);
        }
        return ListaRetorno;
    }
    
    public ArrayList CancelarOrdem(ArrayList ListaBaixar){
        ArrayList ListaRetorno = new ArrayList();
        for (Iterator<Integer> it = ListaBaixar.iterator(); it.hasNext();) {
            Integer idOrdem = it.next();
            ArrayList ListaErro = new ArrayList();
            Ordem.LerClasse(idOrdem);
            if (Ordem.getIdsituacaoordem().getIdsituacaoordem() == 3) {
                ListaErro.add(Ordem.getIdordemproducao());
                ListaErro.add(3);
            } else if (!(Ordem.CancelarOrdem())){
                ListaErro.add(Ordem.getIdordemproducao());
                ListaErro.add(1);                    
            }            
            ListaRetorno.add(ListaErro);
        }
        return ListaRetorno;
    }    

    public boolean EventoSalvaOrdemEProducao(ArrayList<Object> ListaOrdem, 
                                          ArrayList ListaNovoProduto, 
                                          ArrayList ListaAlterarProduto, 
                                          ArrayList ListaExcluirProduto) {    
        Ordem.LimparClasse();
        CarregarClasse(ListaOrdem);
        return Ordem.GravaOrdemEProduto(0, 
                                      CarregarProdutos(ListaNovoProduto),
                                      CarregarProdutos(ListaAlterarProduto),
                                      CarregarParaExcluir(ListaExcluirProduto));
           
    }
    
    public Integer retornaIdRecemSalvo(){
        return Ordem.RetornaId();
    }
    
    public ArrayList<ordemproduto> CarregarProdutos(ArrayList Lista) {
        ArrayList<ordemproduto> ListaRetorno = new ArrayList<ordemproduto>();
        for (Iterator<ArrayList> it = Lista.iterator(); it.hasNext();) {
            ArrayList lis = it.next();
            ordemproduto opt = new ordemproduto();
            Integer id = Integer.parseInt(lis.get(0).toString());
            if ( id != 0){
                opt.setIdOrdemProduto(id);
            }
            produto pro = new produto();            
            pro.setIdproduto(Integer.parseInt(lis.get(1).toString()));            
            opt.setProduto(pro);
            opt.setQuantidade(new BigDecimal(lis.get(4).toString()));
            unidademedida uni = new unidademedida(Integer.parseInt(lis.get(5).toString()));
            opt.setUnidadeMedida(uni);
            ListaRetorno.add(opt);
        }
        return ListaRetorno;
    }
    
    public ArrayList<ordemproduto> CarregarParaExcluir(ArrayList Lista){
        ArrayList<ordemproduto> ListaRetorno = new ArrayList<ordemproduto>();
        for (Iterator<Integer> it = Lista.iterator(); it.hasNext();) {  
            Integer id = it.next();
            ordemproduto op = new ordemproduto();
            op.LerClasse(id);
            ListaRetorno.add(op);
        }        
        return ListaRetorno;
    }
    
    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean EventoAlterarOrdemEProduto(ArrayList<Object> ListaFicha, 
                                          ArrayList ListaNovoItens, 
                                          ArrayList ListaAlterarItens, 
                                          ArrayList ListaExcluirItens) {    
        CarregarClasse(ListaFicha);
        return Ordem.GravaOrdemEProduto(1, 
                                      CarregarProdutos(ListaNovoItens),
                                      CarregarProdutos(ListaAlterarItens),
                                      CarregarParaExcluir(ListaExcluirItens));
           
    }    

    @Override
    public boolean EventoExcluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Vector EventoRetornaTodasUnidades(){
        return (Vector)Unidade.PesquisarVector(new ArrayList<String>());
    }
    
    public Vector EventoRetornaTodasOrigens(){
        origemordem ori = new origemordem();        
        return ori.RetornaTodas();
    }
    
    public Vector EventoRetornaTodasSituacoes(){
        situacaoordem sit = new situacaoordem();        
        return sit.RetornaTodas();
    }    
    
    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Ordem.LerClasse(id);        
        return DevolverDadosClasseTodos(RetornaProduto(id));
    }

    public ArrayList RetornaProduto(int id){
        ordemproduto opt =  new ordemproduto();
        Vector vec = (Vector)opt.RetornaTodos(String.valueOf(id));
        ArrayList ListaProd = new ArrayList();
        for (Iterator<Vector> it = vec.iterator(); it.hasNext();) {
            ArrayList Lis = new ArrayList();
            Vector v = it.next();
            Lis.add(v.get(0));
            Lis.add(v.get(1));
            Lis.add(v.get(2));
            Lis.add(v.get(3));
            Lis.add(v.get(4));
            Lis.add(v.get(5));
            Lis.add(v.get(6));
            ListaProd.add(Lis);
        }      
        return ListaProd;
    }
    
    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Ordem.Pesquisar(ListaParametros);        
    }

    @Override
    public void CarregarClasse(ArrayList Objeto) {
        Ordem.setDataordem(Funcoes.FormataDataPadrao(Objeto.get(1).toString()));
        refeicao Ref = new refeicao();
        Ref.LerClasse(Integer.parseInt(Objeto.get(2).toString()));
        Ordem.setRefeicao(Ref);
        origemordem ori = new origemordem();
        ori.LerClasse(Integer.parseInt(Objeto.get(3).toString()));
        Ordem.setIdorigemordem(ori);
        situacaoordem sit = new situacaoordem();
        sit.LerClasse(Integer.parseInt(Objeto.get(4).toString()));
        Ordem.setIdsituacaoordem(sit);
        Ordem.setSetor(Objeto.get(5).toString());
        Ordem.setMotivo(Objeto.get(6).toString());        
    }

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList Lista = new ArrayList();
        return Lista;                
    }
    
    public Integer RetornaProximoId(){
        return Ordem.RetornaProximoId();
    }
    
    public ArrayList DevolverDadosClasseTodos(ArrayList ListaProd) {
        ArrayList Lista = new ArrayList();
        Lista.add(Ordem.getIdordemproducao().toString());
        Lista.add(Funcoes.FormataDataPadrao(Ordem.getDataordem()));
        Lista.add(Ordem.getRefeicao().getIdrefeicao().toString());
        Lista.add(Ordem.getRefeicao().getDescricao().toString());
        Lista.add(Ordem.getIdorigemordem().getIdorigemordem().toString());
        Lista.add(Ordem.getIdorigemordem().getDescricao().toString());
        Lista.add(Ordem.getIdsituacaoordem().getIdsituacaoordem().toString());
        Lista.add(Ordem.getIdsituacaoordem().getDescricao().toString());        
        Lista.add(Ordem.getSetor().toString());
        Lista.add(Ordem.getMotivo().toString());
        Lista.add(ListaProd);  
        return Lista;
    }    
  
}
