/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.Funcoes;
import Classes.ManipulaExcel;
import Classes.fornecedor;
import Classes.historicopedido;
import Classes.itempedido;
import Classes.pedido;
import Classes.produto;
import Classes.situacaopedido;
import Classes.unidademedida;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ControllerPedido extends ControllerAncestral implements InterfaceControllerPadrao{
    
    private pedido Pedido;
    
    public ControllerPedido(){
        Pedido = new pedido();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Pedido.LimparClasse();
        CarregarClasse(Objeto);
        return Pedido.Gravar(0);        
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Pedido.Gravar(1);  
    }

    @Override
    public boolean EventoExcluir() {
        return Pedido.Excluir();
    }
    
    public boolean EventoExcluir(Integer id) {
        Pedido.LerClasse(id);
        return Pedido.Excluir();
    }    
    
    public void EventoEnviar() throws Exception{
        //Pedido.EnviarEmail(Pedido.GravarArquivoFornecedor());
    }
    
    public void EventoCriarArquivo(Integer id) throws Exception{
        Pedido.LerClasse(id);   
        Pedido.GravarArquivoFornecedor();
    }
    /**
     * Defini o comportamento do botão Enviar da tela de Pedido
     * @param id
     * @throws java.lang.Exception
     */
    public void EventoEnviar(Integer id) throws Exception{
        Pedido.LerClasse(id);        
        Pedido.EnviarEmail();        
    }    

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Pedido.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Pedido.Pesquisar(ListaParametros);
    }
    
    public String RetornaUltimoId(){
        return String.valueOf(Pedido.RetornaUltimoId());
    }

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        //Pedido.setIdbanco(Integer.parseInt(Objeto.get(0).toString())); 
        ArrayList<historicopedido> ListaHist = new ArrayList<historicopedido>();        
        Pedido.setDataEntrega(Funcoes.FormataDataPadrao(Objeto.get(1).toString()));
        situacaopedido sit = new situacaopedido();
        sit.LerClasse((Integer)Objeto.get(2));  
        situacaopedido sitAtual = new situacaopedido();
        try {
            sitAtual = Pedido.RetornaSituacaoAtual();
        } catch (NullPointerException e) {
            sitAtual = new situacaopedido();
            sitAtual.setIdsituacaopedido(0);
        }        
        if (sitAtual.getIdsituacaopedido() != sit.getIdsituacaopedido()) {
            historicopedido Hist = new historicopedido();
            Calendar Cal = Calendar.getInstance();
            Hist.setDatahistoricopedido(Cal.getTime());
            Hist.setIdsituacaopedido(sit);
            Hist.setIdpedido(Pedido);
            Pedido.setHistorico(new ArrayList());
            Pedido.getHistorico().add(Hist);
        }
        //Pedido.setHistorico(ListaHist);
        fornecedor For = new fornecedor();
        For.LerClasse(Objeto.get(3).toString());
        Pedido.setIdfornecedor(For);        
        ArrayList<itempedido> ListaItens = new ArrayList<itempedido>();
        for (Iterator<ArrayList> it = ((ArrayList)Objeto.get(4)).iterator(); it.hasNext();) {
            ArrayList Lista = it.next();
            itempedido Item = new itempedido();
            Item.setQuantidade(new BigDecimal((String)Lista.get(0)));
            unidademedida uni = new unidademedida();
            uni.LerClasse(Integer.parseInt(Lista.get(1).toString()));
            Item.setUnidadeMedida(uni);
            produto prod = new produto();
            prod.LerClasse((Integer)Lista.get(3));            
            Item.setProduto(prod);
            Item.setPedido(Pedido);
            if (Integer.parseInt(Lista.get(7).toString()) != 0) {
                Item.setIditempedido(Integer.parseInt(Lista.get(7).toString()));
            }
            ListaItens.add(Item);                        
        }        
        Pedido.setItens(ListaItens);
    }
    
    public BigDecimal RetornaPrecoProduto(Integer id){
        produto Prod = new produto();
        Prod.LerClasse(id);
        return Prod.getValor();
    }

    public BigDecimal RetornaPrecoTotal(Integer id, BigDecimal Quantidade){
        produto Prod = new produto();
        Prod.LerClasse(id);
        return Prod.RetornaTotalPreco(Quantidade);        
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
        ArrayTela.add(Pedido.getIdpedido().toString());
        ArrayTela.add(Funcoes.FormataDataPadrao(Pedido.getDataEntrega()));
        situacaopedido sp = new situacaopedido();
        sp = Pedido.RetornaSituacaoAtual();
        ArrayTela.add(sp.getIdsituacaopedido());
        ArrayTela.add(sp.getDescricao());
        ArrayTela.add(Pedido.getFornecedor().getIdfornecedor());
        ArrayTela.add(Pedido.getFornecedor().getCodigo());
        ArrayTela.add(Pedido.getFornecedor().getRazaosocial());
        ArrayList ListaTodosItens = new ArrayList();
        for (Iterator<itempedido> it = Pedido.getItens().iterator(); it.hasNext();) {
            itempedido item = it.next();
            ArrayList ListaItem = new ArrayList();
            ListaItem.add(item.getQuantidade().toString());
            ListaItem.add(item.getUnidadeMedida().getIdunidademedida().toString());
            ListaItem.add(item.getUnidadeMedida().getNome().toString());
            ListaItem.add(item.getProduto().getIdproduto());
            ListaItem.add(item.getProduto().getNome());
            ListaItem.add(item.getProduto().getValor());
            ListaItem.add(item.getProduto().RetornaTotalPreco(item.getQuantidade()));
            ListaItem.add(item.getIditempedido().toString());
            ListaItem.add(item.getProduto().getCodigo());
            ListaTodosItens.add(ListaItem);
        }
        ArrayTela.add(ListaTodosItens);
        return ArrayTela;
    }
}
