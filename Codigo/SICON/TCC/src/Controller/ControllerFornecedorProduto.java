/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.fornecedor;
import Classes.fornecedorproduto;
import Classes.produto;
import Classes.tipofornecedor;
import Dao.Classes.DaoFornecedorProduto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerFornecedorProduto extends ControllerAncestral implements InterfaceControllerPadrao {

    private fornecedorproduto FornecedorProduto;
    private DaoFornecedorProduto objDao = new DaoFornecedorProduto();
    
    public ControllerFornecedorProduto(){
        FornecedorProduto = new fornecedorproduto();
    }

    public boolean EventoSalvar(String idForn, String cod, BigDecimal preco) throws Exception{ 
        FornecedorProduto = objDao.CarregaObjeto(idForn, cod);
        compoePojoPreco(preco);
        FornecedorProduto.Gravar(1);
        return false;
    }

    /**
     * este método é apenas utilizado para alterar o preço;
     * @param Objeto
     */
    private void compoePojoPreco(BigDecimal preco) {
        FornecedorProduto.setPreco(preco);
    }
    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        return false;
    }
    
    public boolean EventoSalvarTodos(ArrayList<Object> Objeto, ArrayList Excluir) {        
        return FornecedorProduto.GravarTodos(CarregarClasseArray(Objeto), Excluir);
    }

    public boolean EventoAlterarTodos(ArrayList<Object> Objeto, ArrayList Excluir) {
        return FornecedorProduto.GravarTodos(CarregarClasseArray(Objeto), Excluir);
    }
    

    @Override
    public boolean EventoExcluir() {
        return FornecedorProduto.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        FornecedorProduto.LerClasse(id);
        return DevolverDadosClasse();
    }

    public ArrayList<Object> EventoSelecionarTodos(int idFornecedor) {
        /* recebe como parametro o id do fornecedor e retorna todos os fornecedorproduto*/
        ArrayList ListaParametro = new ArrayList();
        ListaParametro.add("fornecedor");
        ListaParametro.add(String.valueOf(idFornecedor));        
        return DevolverTodosDados((Vector)FornecedorProduto.Pesquisar(ListaParametro));
    }
    @Override
    public List EventoPesquisar(ArrayList<String> ListaParametros) {
        return FornecedorProduto.Pesquisar(ListaParametros);
    }

    public ArrayList<fornecedorproduto> CarregarClasseArray(ArrayList<Object> Objeto){
        ArrayList<fornecedorproduto> ListaPrincipal = new ArrayList<fornecedorproduto>();
        int cont = 0;
        while (((ArrayList)Objeto.get(2)).size() > cont) {
            fornecedorproduto ForProd = new fornecedorproduto();
            int id = Integer.parseInt((((ArrayList)((ArrayList)Objeto.get(2)).get(cont)).get(5).toString()));
            if (id != 0) {
                ForProd.setIdfornecedorproduto(id);    
            }
            ArrayList Array = new ArrayList();
            Array = (((ArrayList)((ArrayList)Objeto.get(2)).get(cont)));
            fornecedor For = new fornecedor();
            For.LerClasse(Integer.parseInt(Array.get(0).toString()));
            produto Pro = new produto();
            Pro.LerClasse(Integer.parseInt(Array.get(1).toString()));
            tipofornecedor tipo = new tipofornecedor();
            tipo.LerClasse(Integer.parseInt(Array.get(2).toString()));
            ForProd.setFornecedor(For);
            ForProd.setProduto(Pro);
            ForProd.setIdtipofornecedor(tipo);                 
            ForProd.setCodprodutofornecedor(Array.get(3).toString());            
            ForProd.setTempoentrega(Integer.parseInt(Array.get(4).toString()));            
            ListaPrincipal.add(ForProd);
            cont++;
        }
        return ListaPrincipal;
    }
    
    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /***************************************************************************
     * O Array recebido ou passado para a tela tem o seguinte formato
     * POSIÇÃO   | DADO
     *    0      | idfornecedorproduto -- desabilitado 
     *    1      | FOrnecedor (ArrayList idfornecedor, Para a tela -->codigo, Descricao)
     *    2      | Produto (ArrayList idproduto, idTipoFornecedor, (Para Tela --> codigo, Descricao), CodigoFornecedor, TemperaturaEntrega, idfornecedorproduto)
     **************************************************************************/        

    @Override
    public ArrayList DevolverDadosClasse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ArrayList DevolverTodosDados(Vector Lista){
    ArrayList ListaRetorno = new ArrayList();
    if (!(Lista.isEmpty())) {    
        ArrayList ListProd = new ArrayList();
        ArrayList ListaForn = new ArrayList();
        ListaForn.add(((Vector)Lista.get(0)).get(0));
        ListaForn.add(((Vector)Lista.get(0)).get(10));
        ListaForn.add(((Vector)Lista.get(0)).get(1));
        ListaRetorno.add(ListaForn);
            for (Iterator<Vector> it = Lista.iterator(); it.hasNext();) {
                Vector Objeto = it.next();
                ArrayList ListaProd = new ArrayList();
                ListaProd.add(Objeto.get(1)); // 0 nome fornecedor
                ListaProd.add(Objeto.get(9)); // 1 idtipofornecedor
                ListaProd.add(Objeto.get(8)); // 2 codigo produto
                ListaProd.add(Objeto.get(4)); // 3 codigo fornecedor produto
                ListaProd.add(Objeto.get(5)); // 4 temperatura de entrega
                ListaProd.add(Objeto.get(7)); // 5 idfornecedorproduto
                ListaProd.add(Objeto.get(6)); // 6 descricaoTipoFonrecedor
                ListaProd.add(Objeto.get(2)); // 7 idproduto
                ListaProd.add(Objeto.get(3)); // 8 nome produto
                ListProd.add(ListaProd);
            }
        ListaRetorno.add(ListProd);
        }
    return ListaRetorno;
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
