/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.Funcoes;
import Classes.pedido;
import Classes.UsuarioSistema;
import Classes.itempedido;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaPedido;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoPedido extends DaoAbstractGenerica implements DaoGenericaPedido {

    private Date DataAntigaPedido;
    
    public DaoPedido(){
        super();
        DataAntigaPedido = new Date();
    }
    
    @Override
    public boolean Alterar(pedido object) {
        boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            pedido antigoPedido = new pedido();
            antigoPedido.LerClasse(object.getIdpedido());
            DataAntigaPedido= antigoPedido.getDataEntrega();
            super.AtualizaUsuario();            
            manager.merge(object);
            manager.flush();
            AlterarSaldoProduto(antigoPedido);
            gravarSaldoProduto(object);
            transacao.commit();
            Alterou = true;            
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());              
            System.out.println(e);
            Alterou = false;
            transacao.rollback();      
        } finally {
            manager.clear();            
            return Alterou;            
        }           
    }

    /* 
     * Objetivo     : Salvar um novo objeto cargo no banco de dados
     * Data Criação : 08/07/08 
     */  
    @Override
    public boolean Salvar(pedido object) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            //super.AtualizaUsuario();            
            manager.persist(object);
            gravarSaldoProduto(object);
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());              
            System.out.println(e.getMessage());
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }
    }    
    
    private void gravarSaldoProduto(pedido Pedido) throws SQLException, Exception{ 
        DaoMovimento daoMovimento = new DaoMovimento();        
        for (Iterator<itempedido> it = Pedido.getItens().iterator(); it.hasNext();) {
            itempedido item = it.next();
            daoMovimento.GravarSaldo(super.manager, Pedido.getDataEntrega(), item.getProduto().getIdproduto(), item.getQuantidade(), 3, 0);
        }
    }
    
    private void AlterarSaldoProduto(pedido antigoPedido){
        DaoMovimento daoMovimento = new DaoMovimento();             
        for (Iterator<itempedido> it = antigoPedido.getItens().iterator(); it.hasNext();) {
            itempedido item = it.next();
            daoMovimento.GravarSaldo(super.manager, antigoPedido.getDataEntrega(), item.getProduto().getIdproduto(), item.getQuantidade(), 3, 1);
        }
    }
    
    public Integer RetornaUltimoId(){
        try{            
             Vector Lista = (Vector)manager.createNativeQuery("select Max(p.idpedido) + 1 from pedido p").getSingleResult();
             return (Integer)Lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public boolean SalvarPedidoEItens(pedido object, ArrayList<itempedido> ListaNovo, ArrayList<itempedido> ListaAlterar, ArrayList<itempedido> ListaExcluir) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();            
            manager.persist(object);
            transaction.commit();
            manager.clear();
            transaction.begin();            
            gravarProdutos(ListaNovo, ListaAlterar, ListaExcluir, object);
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);   
            logger.warning(e.getMessage());              
            System.out.println(e);
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }
    }    
    
    public void gravarProdutos(ArrayList<itempedido> ListaNovo, ArrayList<itempedido> ListaAlterar, ArrayList<itempedido> ListaExcluir,  pedido Pedido) {
        DaoMovimento daoMovimento = new DaoMovimento();
        for (Iterator<itempedido> it = ListaNovo.iterator(); it.hasNext();) {
            itempedido object = it.next();               
            //daoMovimento.GravarSaldo(super.manager, Pedido.getDataPedido(), object.getProduto().getIdproduto(), object.getQuantidade(), 2, 0);
            object.setPedido(Pedido);            
            manager.persist(object);                
        }
        for (Iterator<itempedido> it = ListaAlterar.iterator(); it.hasNext();) {
            itempedido object = it.next();
            //ler o antigo produt para ver se mudou o produto
            //ordemproduto objectantigo = new ordemproduto();
            //objectantigo.LerClasse(object.getIdOrdemProduto());
            // é necessario ver se a data da ordem mudou tambem, se mudou tem que excluir do saldo com a data antiga
            //ordemproducao OrdemAntiga = new ordemproducao();
            //OrdemAntiga.LerClasse(Ordem.getIdordemproducao());
            // se mudou o produto então tem que ser retirado da tabela de saldo o produto antigo.
            //if (!(object.getProduto().equals(objectantigo.getProduto()))) {                
                //if (!(Ordem.getDataordem().equals(DataAntigaProducao))){
                //    daoMovimento.GravarSaldo(super.manager, DataAntigaProducao, objectantigo.getProduto().getIdproduto(), objectantigo.getQuantidade(), 2, 1);
                //} else {
                    //daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), objectantigo.getProduto().getIdproduto(), objectantigo.getQuantidade(), 2, 1);
                //}                
           // } else {
                //daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), object.getProduto().getIdproduto(), objectantigo.getQuantidade(), 2, 1);                    
            //}
            //daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), object.getProduto().getIdproduto(), object.getQuantidade(), 2, 0);
            object.setPedido(Pedido);
            manager.merge(object);                
        }
        for (Iterator<itempedido> it = ListaExcluir.iterator(); it.hasNext();) {
            itempedido object = it.next();
            object = manager.merge(object);                
            manager.remove(object);
        }        
        /*if (!(Ordem.getDataordem().equals(DataAntigaProducao))){
            AtualizarSaldoComprometido(super.manager, ListaAlterar, Ordem);
        }*/
        
    }
    
    /*****************************************************************************
     * Atualizar o saldo na tabela de saldo se for mudada 
     * a data da ordem de produção 
    *****************************************************************************/     
   /*public void AtualizarSaldoComprometido(EntityManager mana, ArrayList ListaAlterados, ordemproducao Ordem){
        DaoMovimento daoMovimento = new DaoMovimento();        
        /*ordemproduto prod = new ordemproduto();
        Vector ListaProdutos = (Vector) prod.RetornaTodos(String.valueOf(Ordem.getIdordemproducao()));
        int Cont = 0;        
        for (Iterator<Vector> it = ListaProdutos.iterator(); it.hasNext();) {
            Vector Lista = it.next();
            int ContAlterado = 0;
            while (ListaAlterados.size() > ContAlterado) {
                ContAlterado++;
                if (((ordemproduto)ListaAlterados.get(ContAlterado)).getIdOrdemProduto() == (Integer)Lista.get(0)){
                    ListaProdutos.remove(Cont);
                }
            }
            Cont++;            
        }
        ordemproduto prod = new ordemproduto();
        Vector ListaProdutos = (Vector) prod.RetornaTodos(String.valueOf(Ordem.getIdordemproducao()));
        for (Iterator<Vector> it = ListaProdutos.iterator(); it.hasNext();) {
            Vector Lista = it.next();
            daoMovimento.GravarSaldo(mana, DataAntigaProducao, (Integer)Lista.get(1), (BigDecimal)Lista.get(4), 2, 1);
            daoMovimento.GravarSaldo(mana, Ordem.getDataordem(), (Integer)Lista.get(1), (BigDecimal)Lista.get(4), 2, 0);
        }
    }
    
    public boolean BaixarOrdem(ordemproducao Ordem){
        boolean Gravou = false;
        DaoMovimento daoMovimento = new DaoMovimento();        
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario(); 
            ordemproduto prod = new ordemproduto();
            Vector ListaProdutos = (Vector) prod.RetornaTodos(String.valueOf(Ordem.getIdordemproducao()));
            for (Iterator<Vector> it = ListaProdutos.iterator(); it.hasNext();) {
                Vector v = it.next();
                prod.LerClasse((Integer)v.get(0));
                daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), prod.getProduto().getIdproduto(), prod.getQuantidade(), 2, 1);
                daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), prod.getProduto().getIdproduto(), prod.getQuantidade(), 1, 0);
            }       
            situacaoordem sit = new situacaoordem();
            sit.LerClasse(2);
            Ordem.setIdsituacaoordem(sit);
            manager.merge(Ordem);  
            manager.flush();            
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);   
            logger.warning(e.getMessage());              
            System.out.println(e);
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }        
    }
    
    public boolean CancelarOrdem(ordemproducao Ordem){
        boolean Gravou = false;
        DaoMovimento daoMovimento = new DaoMovimento();        
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario(); 
            ordemproduto prod = new ordemproduto();
            Vector ListaProdutos = (Vector) prod.RetornaTodos(String.valueOf(Ordem.getIdordemproducao()));
            for (Iterator<Vector> it = ListaProdutos.iterator(); it.hasNext();) {
                Vector v = it.next();
                prod.LerClasse((Integer)v.get(0));                
                if (Ordem.getIdsituacaoordem().getIdsituacaoordem() == 1) {
                    daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), prod.getProduto().getIdproduto(), prod.getQuantidade(), 2, 1);                    
                } else if (Ordem.getIdsituacaoordem().getIdsituacaoordem() == 2) {                    
                    daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), prod.getProduto().getIdproduto(), prod.getQuantidade(), 1, 1);    
                }                            
            }
            situacaoordem sit = new situacaoordem();
            sit.LerClasse(3);
            Ordem.setIdsituacaoordem(sit);
            manager.merge(Ordem);    
            manager.flush();            
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);   
            logger.warning(e.getMessage());              
            System.out.println(e);
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }        
    }    */
    
    public boolean AlterarOrdemEProduto(pedido object, ArrayList<itempedido> ListaNovo, ArrayList<itempedido> ListaAlterar, ArrayList<itempedido> ListaExcluir) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario(); 
            /*pedi ordemantiga = new ordemproducao();
            ordemantiga.LerClasse(object.getIdordemproducao());
            DataAntigaProducao = ordemantiga.getDataordem();
            manager.merge(object);
            transaction.commit();
            manager.clear();
            transaction.begin();            
            gravarProdutos(ListaNovo, ListaAlterar, ListaExcluir, object);*/
            transaction.commit();
            Gravou = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);   
            logger.warning(e.getMessage());              
            System.out.println(e);
            Gravou = false;
            transaction.rollback();            
        } finally {
            manager.clear();
            return Gravou;
        }
    }        
    
    /* 
     * Objetivo     : Excluir um objeto cargo do banco de dados
     * Data Criação : 08/07/08 
     */    
    @Override
    public boolean Excluir(pedido object) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            object = manager.merge(object);
            manager.remove(object);
            AlterarSaldoProduto(object);
            transacao.commit();
            Excluir = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());              
            e.printStackTrace();
            Excluir = false;
            transacao.rollback();            
        } finally {
            manager.clear();
            return Excluir;
        }  
    }
    
    /* 
     * Objetivo     : Pesquisa os dados com base nos parametros passados
     * Data Criação : 08/07/08 
     */ 
    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        String Parametros = "";
        //ListaCargo = null;
        List ListaResultado;
        ListaResultado = new ArrayList();
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            Parametros = " where ";
        }
        String And = "";
        while (ListaParametros.size() > contador) {
            if (ListaParametros.get(contador).contentEquals("produto")) {
                String Con = " opt.idproduto = " + ListaParametros.get(contador + 1) + ") ";
                Parametros = Parametros + And + Con;                
                And = " And ";                
            }else if (ListaParametros.get(contador).contentEquals("data")){
                Date dt = Funcoes.FormataDataPadrao(ListaParametros.get(contador + 1));
                SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
                String d = s.format(dt);
                Parametros = Parametros + And + " op.dataordem = '"+ d + "' ";
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("refeicao")){
                Parametros = Parametros + And + " op.idrefeicao = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("situacao")){
                Parametros = Parametros + And + " op.idsituacaoordem = "+ ListaParametros.get(contador + 1);  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("origem")){
                Parametros = Parametros + And + " op.idorigemordem = "+ ListaParametros.get(contador + 1);  
                And = " And ";                            
            } else if (ListaParametros.get(contador).contentEquals("setor")){
                Parametros = Parametros + And + " op.setor ILIKE '%"+ ListaParametros.get(contador + 1) + "%'";  
                And = " And ";                
            } else if (ListaParametros.get(contador).contentEquals("motivo")){
                Parametros = Parametros + And + " op.motivo ILIKE '%"+ ListaParametros.get(contador + 1) + "%'";  
                And = " And ";                
            }                       
            
            contador = contador + 2;
        }        
        String Ordenacao = " order by p.idpedido";
        try {
            String Consulta = "select false as selecionar, p.idpedido, f.razaosocial, hp.datahistoricopedido, sp.descricao, sp.idsituacaopedido " +             
                " from pedido p " + 
                     " inner join fornecedor f  on      p.idfornecedor     = f.idfornecedor " + 
                     " inner join historicopedido hp on hp.idpedido = p.idpedido " +
                                                      " and hp.datahistoricopedido = (select MAX(datahistoricopedido) " +
                                                                              " from historicopedido " +
                                                                              " where idpedido = hp.idpedido) " +
                     " inner join situacaopedido sp on hp.idsituacaopedido = sp.idsituacaopedido ";                                         
            ListaResultado = manager.createNativeQuery(Consulta + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }
    /**
     * 
     * @param idFornecedor
     * @param idPedido
     * @return Lista com as informações que devem ser enviadas ao fornecedor
     * codigo do produto do fornecedor, nome do produto, quantidade, medida e a data
     */
    public List PesquisarEnviarFornecedor(String idFornecedor, String idPedido) {   
        List ListaResultado;
        ListaResultado = new ArrayList();  
        String Ordenacao = " order by fp.codprodutofornecedor";
        try {
            String Consulta = " select fp.codprodutofornecedor, pr.nome, ip.quantidade, u.nome, p.dataentrega, p.idpedido " +
                                " from pedido p  " +
                                " inner join itempedido ip on p.idpedido = ip.idpedido " +
                                " inner join produto    pr on ip.idproduto = pr.idproduto " +
                                " inner join fornecedorproduto fp on fp.idproduto = pr.idproduto " +
                                " inner join unidademedida u on ip.idunidademedida = u.idunidademedida " + 
                                " where fp.idfornecedor = " + idFornecedor + " and p.idPedido = " + idPedido; 
            ListaResultado = manager.createNativeQuery(Consulta + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }    

    @Override
    public pedido CarregarObjeto(pedido object) {
        pedido o = new pedido();        
        o = manager.find(pedido.class, object.getIdpedido());  
        manager.clear();
        return o;
    }  

}
 