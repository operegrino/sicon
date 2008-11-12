/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.ConfiguracoesStatic;
import Classes.EnviarEmail;
import Classes.ManipulaExcel;
import Classes.itemavaliacao;
import Classes.itempedido;
import Classes.motivo;
import Classes.pedido;
import Classes.situacaoitempedido;
import Classes.unidademedida;
import Dao.Classes.DaoAvaliacaoPedido;
import Dao.Classes.DaoMotivo;
import Dao.Classes.DaoSituacaoAvaliacao;
import Dao.Classes.DaoSituacaoItemPedido;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;

/**
 *
 * @author Jonathan
 */
public class ControllerAvaliacaoPedido {

    private unidademedida Unidade;
    private itemavaliacao itemAvaliacao;

    public ControllerAvaliacaoPedido() {
        Unidade = new unidademedida();
        itemAvaliacao = new itemavaliacao();
    }

    public void EventoEnviar(Integer id) throws AddressException, MessagingException, IOException, Exception{
        EnviarEmail email = new EnviarEmail();        
        pedido Pedido = new pedido();
        Pedido.LerClasse(id);
        Pedido.EnviarEmail();        
    }
    
    /**
     * verifica se o motivo indicado é para baixar
     * @return boolea inidcando se baixa ou não
     */
    public boolean VerificaMotivoBaixa(int idMotivo) {
        motivo Motivo = new motivo();
        Motivo.LerClasse(idMotivo);
        return Motivo.getBaixar();
    } 
    
    public List Pesquisa(int idPedido) {
        DaoAvaliacaoPedido daoAvaliacao = new DaoAvaliacaoPedido();
        return daoAvaliacao.Pesquisar(idPedido);
    }
    
    public Vector RetornaUnidades(){
            return (Vector)Unidade.PesquisarVector(new ArrayList<String>());
    }
    
    public Vector RetornaSituacaoAvaliacao() {
        DaoSituacaoAvaliacao objDao = new DaoSituacaoAvaliacao();
        return objDao.RetornaSituacao();
    }
    
    public void GravarAvaliacao(ArrayList listaItens, Boolean Reenviado) throws SQLException, Exception {
        itemAvaliacao.GravarTodos(listaItens, Reenviado);
    }    
    
    public List RetornaMotivoAvaliacao(String ids) {
        DaoMotivo objDao = new DaoMotivo();
        return objDao.PesquisarExistentesAvaliacao(ids);
    }
    
    public void GerarArquivo(Vector Lista) throws Exception {
        ManipulaExcel excel = new ManipulaExcel();
        excel.GerarArquivoFornecedor(Lista);
    }
    
    public void CancelarItem(Vector linhaItem) throws SQLException, Exception {
        boolean isBaixado = false;
        itemavaliacao item = new itemavaliacao();
        itempedido ItemPedido = new itempedido();
        ItemPedido.LerClasse((Integer)linhaItem.get(2));
        item.setItemPedido(ItemPedido);
        GregorianCalendar data = new GregorianCalendar();
        item.setDataavaliacao(new Timestamp(data.getTimeInMillis()));        
        String id = ((JButton)linhaItem.get(9)).getText();
        if (!id.equals("")) {
            motivo Motivo = new motivo();
            Motivo.LerClasse(Integer.parseInt(id));
            isBaixado = Motivo.getBaixar();
            item.setMotivo(Motivo);    
        }        
        situacaoitempedido situacao = new situacaoitempedido();
        DaoSituacaoItemPedido objDao = new DaoSituacaoItemPedido();
        situacao = objDao.LeSituacao(6);
        item.setSituacaoItem(situacao);
        item.setAdequado((Boolean)linhaItem.get(0));
        DaoAvaliacaoPedido daoAvaliacao = new DaoAvaliacaoPedido();
        daoAvaliacao.Gravar(item, isBaixado);
    }

}
