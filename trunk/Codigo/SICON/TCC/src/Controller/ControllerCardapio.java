/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.Funcoes;
import Classes.cardapio;
import Classes.fichatecnica;
import Classes.fichatecnicaitens;
import Classes.refeicao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerCardapio extends ControllerAncestral implements InterfaceControllerPadrao{

    private cardapio Cardapio;
    public ControllerCardapio(){
        super();
        Cardapio = new cardapio();
    }
    
    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Cardapio.LimparClasse();
        CarregarClasse(Objeto);
        return Cardapio.Gravar(0);   
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Cardapio.Gravar(1);  
    }

    @Override
    public boolean EventoExcluir() {
        return Cardapio.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Cardapio.LerClasse(id);
        return DevolverDadosClasse();        
    }

    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return Cardapio.Pesquisar(ListaParametros);
    }
    
    public Vector EventoPesquisarVector(ArrayList<String> ListaParametros) {
        return (Vector)Cardapio.Pesquisar(ListaParametros);
    }    

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Cardapio.setData(new Date(Objeto.get(0).toString()));
        Cardapio.setQtderefeicoes(Integer.parseInt(Objeto.get(1).toString()));
        refeicao Ref = new refeicao();
        Ref.LerClasse(Integer.parseInt(Objeto.get(2).toString()));
        Cardapio.setIdrefeicao(Ref);
        ArrayList<fichatecnica> Lista = new ArrayList<fichatecnica>();
        for (Iterator<ArrayList> it = ((ArrayList)Objeto.get(3)).iterator(); it.hasNext();) {
            ArrayList L = it.next();
            fichatecnica Ficha = new fichatecnica();
            Ficha.LerClasse(Integer.parseInt(L.get(0).toString())); 
            Lista.add(Ficha);
        }
        Cardapio.setListaFichaTecnica(Lista);
    }

    @Override
    public ArrayList DevolverDadosClasse() {
        ArrayList ListaRetorno = new ArrayList();
        ListaRetorno.add(Cardapio.getIdcardapio().toString());
        ListaRetorno.add(Cardapio.getData().toString());
        ListaRetorno.add(String.valueOf(Cardapio.getQtderefeicoes()));
        ListaRetorno.add(Cardapio.getIdrefeicao().getIdrefeicao().toString());
        ListaRetorno.add(Cardapio.getIdrefeicao().getDescricao());
        ArrayList ListaFicha = new ArrayList();
        for (Iterator<fichatecnica> it = Cardapio.getListaFichaTecnica().iterator(); it.hasNext();) {
            fichatecnica ficha = it.next();
            ArrayList Lista = new ArrayList();            
            Lista.add(ficha.getIdfichatecnica());
            Lista.add(ficha.getNomepreparacao());            
            ListaFicha.add(Lista);
        }
        ListaRetorno.add(ListaFicha);
        return ListaRetorno;
                               
    }
    
    /**
     * Faz uma analise se é possivel gerar o cardapio, senão possuir produto no estoque 
     * o sistema gera um pedido e uma ordem de produção, se for possivel gera apenas uma ordem de produção;
     * O calculo está sendo feito em base do peso bruto;
     * @param idCardapio
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList GerarCardapio(int idCardapio) throws Exception{  
        Cardapio.LerClasse(idCardapio);
        boolean geraPedido;
        ArrayList listaProdutosSomados = somaProdutosCardapio();
        ArrayList listaSaldos = RetornaSaldos(listaProdutosSomados);
        ArrayList listaOrdem = new ArrayList(100);
        ArrayList listaProdutosOrdem = new ArrayList();
        ArrayList listaTodosPedidos = new ArrayList(100);
        for (Iterator<ArrayList> it = listaProdutosSomados.iterator(); it.hasNext();) {
            ArrayList listaProduto = it.next();
            for (Iterator<Vector> it2 = listaSaldos.iterator(); it2.hasNext();) {
                Vector vetorSaldo = it2.next();
                BigDecimal qtdePedidoProd = new BigDecimal(0);
                if ((Integer)listaProduto.get(0) == ((Integer)vetorSaldo.get(7))) { 
                    //diminui do saldo o total necessário para gerar o cardapio;
                    BigDecimal saldoMenosNecessario = new BigDecimal(0);
                    saldoMenosNecessario = ((BigDecimal)vetorSaldo.get(6)).subtract((BigDecimal)listaProduto.get(1));
                    //se (saldo - totalnecessario) >= estoque minimo então pode fazer a ordem
                    if (saldoMenosNecessario.compareTo((BigDecimal)listaProduto.get(3)) >= 0) {
                        geraPedido = false;
                    //se (saldo - totalnecessario) < estoque minimo então gera pedido e ordem;
                    } else {
                        qtdePedidoProd = saldoMenosNecessario.subtract((BigDecimal)listaProduto.get(3));
                    }                    
                }
                //gera o array com a ordem    
                // [0-Data da Ordem, 1-[idRefeicao, Descricao da Refeicao], 2-origem da ordem, 
                //  3-situacao, 4-setor, 5-motivo, 6-itens[[idProduto, qtde, unidademedida]]]

                //adiciona os itens da ordem
                ArrayList itens = new ArrayList();   
                itens.add((Integer)listaProduto.get(0));
                itens.add((BigDecimal)listaProduto.get(1));
                itens.add(5);
                listaProdutosOrdem.add(itens);
            }
            
        }
        listaOrdem.add(Cardapio.getData());
        //adiciona refeicao
        ArrayList ls = new ArrayList(2);
        ls.add(Cardapio.getIdrefeicao().getIdrefeicao());
        ls.add(Cardapio.getIdrefeicao().getDescricao());
        listaOrdem.add(ls);
        listaOrdem.add(2);
        listaOrdem.add(1);
        listaOrdem.add("");
        listaOrdem.add("Ordem solicitada para elaboração do cardápio");
        listaOrdem.add(listaProdutosOrdem);
        return new ArrayList();
    }     
    /**
     * Captura do banco de dados todos os saldos dos produtos do cardapio;
     * 
     * @param listaProduto
     * @return array de vector com os saldos 0 = saldo de entrada; 1 = saldo de saida;
     * 2 = saldo atual; 3 = saldo comprometido; 4 = saldo pendente; 5 = saldo comprometido real;
     * 6 = saldo real; 7 = idproduto;;
     */
    public ArrayList RetornaSaldos(ArrayList listaProduto){
        ArrayList listaSaldo = new ArrayList(100);
        ControllerSaldoEstoque controllerSaldo = new ControllerSaldoEstoque();
        for (Iterator<Vector> it = listaProduto.iterator(); it.hasNext();) {
            Vector vt = it.next();
            String data = Funcoes.FormataDataPadrao(Cardapio.getData());
            ArrayList ListaParametroSaldo = new ArrayList();
            ListaParametroSaldo.add("produto");
            ListaParametroSaldo.add(vt.get(0).toString());
            ListaParametroSaldo.add("data");
            ListaParametroSaldo.add(data);
            listaSaldo.add(controllerSaldo.EventoPesquisar(ListaParametroSaldo).add((Integer)vt.get(0)));
        }
        return listaSaldo;
    }
    /**
     * Efetua a soma por produto do cardápio. Soma essa que é por padrão em quilo,
     * convertendo as demais unidades para quilo;
     * @param idCardapio
     * @return ArrayList de arraylist contendo 0 = idProduto; 1 = TotalBruto; 2 = TotalLiquido;
     * 3 = estoqueminimo; 4 = unidade de medida estoque do estoque minimo;
     * @throws java.lang.Exception
     */     
    public ArrayList somaProdutosCardapio() throws Exception{  
        Funcoes funcao = new Funcoes();
        //Carrega os produtos da ficha tecnica
        fichatecnicaitens fti =  new fichatecnicaitens();
        ArrayList listaProdutos = new ArrayList(100);
        ArrayList listaProdutosSomados = new ArrayList(100);
        ArrayList ListaP = new ArrayList();
        ListaP.add("fichatecnica");
        ListaP.add("");
        for (Iterator<fichatecnica> it = Cardapio.getListaFichaTecnica().iterator(); it.hasNext();) {
            fichatecnica ficha = it.next();
            ListaP.set(1, ficha.getIdfichatecnica());
            listaProdutos.add((Vector)fti.Pesquisar(ListaP));
        }
        //faz a soma de todos os produtos iguais; Soma Peso Bruto e Peso Liquido
        for (Iterator<Vector> it = listaProdutos.iterator(); it.hasNext();) {
            Vector vt = it.next();
            for (Iterator<Vector> it2 = listaProdutos.iterator(); it2.hasNext();) {
                Vector vt2 = it2.next();
                ArrayList listaSoma = new ArrayList(3);
                BigDecimal totalBruto = new BigDecimal(0);
                BigDecimal totalLiquido = new BigDecimal(0);
                if ((Integer)vt.get(1) == (Integer)vt2.get(1)) {
                    BigDecimal pesoBruto = new BigDecimal(0);
                    pesoBruto.add(funcao.converterPesoEmKilo((BigDecimal)vt2.get(3), (Integer)vt2.get(8), 3));
                    BigDecimal pesoLiquido = new BigDecimal(0);
                    pesoLiquido.add(funcao.converterPesoEmKilo((BigDecimal)vt2.get(4), (Integer)vt2.get(8), 3));
                    totalBruto.add(pesoBruto);
                    totalLiquido.add(pesoLiquido);                    
                }
                if (!it2.hasNext()) {
                    listaSoma.add((Integer)vt.get(1));
                    listaSoma.add(totalBruto.multiply(new BigDecimal(Cardapio.getQtderefeicoes())));
                    listaSoma.add(totalLiquido.multiply(new BigDecimal(Cardapio.getQtderefeicoes())));
                    listaSoma.add(vt.get(8));
                    listaSoma.add(vt.get(9));
                    listaProdutosSomados.add(listaSoma);
                }
                it2.remove();                
            }
        }
        return listaProdutosSomados;
    }

}
