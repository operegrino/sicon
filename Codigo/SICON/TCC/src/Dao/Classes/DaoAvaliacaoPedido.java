/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.itemavaliacao;
import Classes.itempedido;
import Classes.motivo;
import Classes.situacaoitempedido;
import Dao.Interfaces.DaoAbstractGenerica;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoAvaliacaoPedido extends DaoAbstractGenerica{
    private DaoMovimento daoMovimento;

    public DaoAvaliacaoPedido() {
            super();
            daoMovimento = new DaoMovimento();
    }

    public void Gravar(itemavaliacao objeto) throws SQLException, Exception {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        super.AtualizaUsuario();
        manager.persist(objeto);
        transaction.commit();
        manager.clear();
    } 
    
    public void Gravar(itemavaliacao objeto, boolean baixado) throws SQLException, Exception {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        super.AtualizaUsuario();
        if (baixado) {
            daoMovimento.GravarSaldo(super.manager, objeto.getItemPedido().getPedido().getDataEntrega(), objeto.getItemPedido().getProduto().getIdproduto(), objeto.getItemPedido().getQuantidade(), 0, 1);           
        } else {
            daoMovimento.GravarSaldo(super.manager, objeto.getItemPedido().getPedido().getDataEntrega(), objeto.getItemPedido().getProduto().getIdproduto(), objeto.getItemPedido().getQuantidade(), 3, 1);            
        }
        manager.persist(objeto);
        transaction.commit();
        manager.clear();
    }       
    
    
    /**
     * Seta os valores do bean de avaliação, maior foco na parte que controla a 
     * situação da avaliação. Podendo ser Aguardando(3), Reenviado(4) e Baixado(5);
     * @param listaAvaliacao
     * @param itemAvaliacao
     */
    public void InstanciaAvaliacao(ArrayList listaAvaliacao, itemavaliacao itemAvaliacao, Boolean Reenviado) {
        Boolean Adeq = (Boolean) listaAvaliacao.get(4);
        int TipoMudanca = (Integer)listaAvaliacao.get(5);
        Boolean Baixar = false;
        situacaoitempedido Sit = new situacaoitempedido();    
        
        if (!listaAvaliacao.get(2).toString().trim().equals("")) {
            motivo Motivo = new motivo();
            Motivo.LerClasse( Integer.parseInt(listaAvaliacao.get(2).toString()));
            itemAvaliacao.setMotivo(Motivo);
            Baixar = Motivo.getBaixar();
        }       
            
        itempedido Item = new itempedido();
        Item.LerClasse((Integer) listaAvaliacao.get(0));
        itemAvaliacao.setItemPedido(Item);
        itemAvaliacao.setDataavaliacao((Timestamp) listaAvaliacao.get(1));
        DaoSituacaoItemPedido objDao = new DaoSituacaoItemPedido();
        
        if (Reenviado) {
            Sit = objDao.LeSituacao(4);
        } else if ((TipoMudanca == 2) || (TipoMudanca == 3)) {
            Sit = objDao.LeSituacao(3); 
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 0, 1);           
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 3, 0);                           
        } else if ((TipoMudanca == 1) || (TipoMudanca == 4)) {
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 3, 1);           
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 0, 0);           
            Sit = objDao.LeSituacao(5); 
        } else if ((Adeq) && (TipoMudanca == 0)) {
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 3, 1);
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 0, 0);            
            //Sit = objDao.LeSituacao(listaAvaliacao.get(3).toString());
            Sit = objDao.LeSituacao(5);
        } else if ((TipoMudanca == 0) && (Baixar)) {
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 3, 1);
            daoMovimento.GravarSaldo(super.manager, itemAvaliacao.getItemPedido().getPedido().getDataEntrega(), Item.getProduto().getIdproduto(), Item.getQuantidade(), 0, 0);            
            Sit = objDao.LeSituacao(5);
        } else if ((TipoMudanca == 0) && (!Baixar)) {
            Sit = objDao.LeSituacao(3);
        } else if ((!Baixar) && (!Reenviado)) {
            Sit = objDao.LeSituacao(3);            
        } else Sit = objDao.LeSituacao(3);
        
        itemAvaliacao.setSituacaoItem(Sit);
        itemAvaliacao.setAdequado(Adeq);
    }    
    
    public void Gravar(ArrayList listaAvaliacao, Boolean Reenviado) throws SQLException, Exception {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        super.AtualizaUsuario();
        for (Iterator<ArrayList> it = listaAvaliacao.iterator(); it.hasNext();) {
            ArrayList lista = it.next();
            itemavaliacao itemAvaliacao = new itemavaliacao();
            InstanciaAvaliacao(lista, itemAvaliacao, Reenviado);
            manager.persist(itemAvaliacao);            
        }
        transaction.commit();
        manager.clear();        
    }
    
    public List Pesquisar(int idPedido) {
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT Case WHEN adequado ISNULL THEN FALSE ");
        sb.append(" ELSE adequado END AS adequado, ");
        sb.append(" CASE WHEN adequado ISNULL THEN FALSE ");
        sb.append(" WHEN adequado THEN FALSE ");
        sb.append(" ELSE TRUE END AS inadequado, ");
        sb.append(" ip.iditempedido, p.codigo,  ");
        sb.append(" p.nome as produto, ip.quantidade, u.nome AS unidademedida, ");
        sb.append(" CASE WHEN ia.idmotivo ISNULL THEN 0 ");       
        sb.append(" ELSE ia.idmotivo END AS motivo, ");
        sb.append(" CASE WHEN si.descricao ISNULL THEN 'Aguardando' ");
        sb.append(" ELSE si.descricao END as situacao ");
        sb.append(" FROM itempedido ip ");
        sb.append(" LEFT  JOIN itemavaliacao       ia ON ia.iditempedido = ip.iditempedido AND ");
        sb.append(" ia.dataavaliacao = (SELECT max(dataavaliacao)");
        sb.append("                     FROM itemavaliacao ");
        sb.append("                     WHERE iditempedido = ip.iditempedido) ");
        sb.append(" LEFT  JOIN situacaoitempedido  si ON ia.idsituacaoitempedido = si.idsituacaoitempedido ");
        sb.append(" LEFT  JOIN motivo               m ON m.idmotivo = ia.idmotivo ");
        sb.append(" INNER JOIN produto              p ON ip.idproduto = p.idproduto ");
        sb.append(" INNER JOIN unidademedida        u ON u.idunidademedida = ip.idunidademedida ");
        sb.append(" WHERE idpedido = ");
        sb.append(String.valueOf(idPedido));
        return manager.createNativeQuery(sb.toString()).getResultList();
    }
            
}
