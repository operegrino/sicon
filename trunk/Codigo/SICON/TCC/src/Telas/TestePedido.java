/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;

import Classes.fornecedor;
import Classes.itempedido;
import Classes.pedido;
import Classes.produto;
import Classes.unidademedida;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class TestePedido {
    
    public TestePedido(){}
    
    public static void main(String[] args) {
        pedido Pedido = new pedido();
        fornecedor forn = new fornecedor();
        forn.LerClasse("15");
        Pedido.setIdfornecedor(forn);
        ArrayList<itempedido> ListaItem = new ArrayList<itempedido>();
        for (int i = 0; i < 2; i++) {
            itempedido item = new itempedido();            
            produto prod = new produto();
            prod.LerClasse(9);
            item.setProduto(prod);
            item.setQuantidade(new BigDecimal(50));
            unidademedida uni = new unidademedida();
            uni.LerClasse(5);
            item.setUnidadeMedida(uni);
            item.setPedido(Pedido);            
            ListaItem.add(item); 
        }
        Pedido.setItens(ListaItem);
        Pedido.Gravar(0);
    }

}
