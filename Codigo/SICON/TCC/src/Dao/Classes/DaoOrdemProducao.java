/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.Funcoes;
import Classes.ordemproducao;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaOrdemProducao;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import Classes.UsuarioSistema;
import Classes.ordemproduto;
import Classes.situacaoordem;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author jonathan
 */
public class DaoOrdemProducao extends DaoAbstractGenerica implements DaoGenericaOrdemProducao{

    private Date DataAntigaProducao;
    public DaoOrdemProducao(){
        super();
        DataAntigaProducao = new Date();
    }
    
    @Override
    public boolean Alterar(ordemproducao object) {
        boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();            
            manager.merge(object);
            manager.flush();
            Alterou = true;
            transacao.commit();
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
    public boolean Salvar(ordemproducao object) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();            
            manager.persist(object);
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
    
    public boolean SalvarOrdemEProduto(ordemproducao object, ArrayList<ordemproduto> ListaNovo, ArrayList<ordemproduto> ListaAlterar, ArrayList<ordemproduto> ListaExcluir) {
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
    
    public void gravarProdutos(ArrayList<ordemproduto> ListaNovo, ArrayList<ordemproduto> ListaAlterar, ArrayList<ordemproduto> ListaExcluir,  ordemproducao Ordem) {
        DaoMovimento daoMovimento = new DaoMovimento();
        for (Iterator<ordemproduto> it = ListaNovo.iterator(); it.hasNext();) {
            ordemproduto object = it.next();               
            daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), object.getProduto().getIdproduto(), object.getQuantidade(), 2, 0);
            object.setOrdemProducao(Ordem);            
            manager.persist(object);                
        }
        for (Iterator<ordemproduto> it = ListaAlterar.iterator(); it.hasNext();) {
            ordemproduto object = it.next();
            //ler o antigo produt para ver se mudou o produto
            ordemproduto objectantigo = new ordemproduto();
            objectantigo.LerClasse(object.getIdOrdemProduto());
            // é necessario ver se a data da ordem mudou tambem, se mudou tem que excluir do saldo com a data antiga
            ordemproducao OrdemAntiga = new ordemproducao();
            OrdemAntiga.LerClasse(Ordem.getIdordemproducao());
            // se mudou o produto então tem que ser retirado da tabela de saldo o produto antigo.
            if (!(object.getProduto().equals(objectantigo.getProduto()))) {                
                //if (!(Ordem.getDataordem().equals(DataAntigaProducao))){
                //    daoMovimento.GravarSaldo(super.manager, DataAntigaProducao, objectantigo.getProduto().getIdproduto(), objectantigo.getQuantidade(), 2, 1);
                //} else {
                    daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), objectantigo.getProduto().getIdproduto(), objectantigo.getQuantidade(), 2, 1);
                //}                
            } else {
                daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), object.getProduto().getIdproduto(), objectantigo.getQuantidade(), 2, 1);                    
            }
            daoMovimento.GravarSaldo(super.manager, Ordem.getDataordem(), object.getProduto().getIdproduto(), object.getQuantidade(), 2, 0);
            object.setOrdemProducao(Ordem);
            manager.merge(object);                
        }
        for (Iterator<ordemproduto> it = ListaExcluir.iterator(); it.hasNext();) {
            ordemproduto object = it.next();
            object = manager.merge(object);                
            manager.remove(object);
        }        
        if (!(Ordem.getDataordem().equals(DataAntigaProducao))){
            AtualizarSaldoComprometido(super.manager, ListaAlterar, Ordem);
        }
        
    }
    
    /*****************************************************************************
     * Atualizar o saldo na tabela de saldo se for mudada 
     * a data da ordem de produção 
    *****************************************************************************/     
    public void AtualizarSaldoComprometido(EntityManager mana, ArrayList ListaAlterados, ordemproducao Ordem){
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
        }*/
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
    }    
    
    public boolean AlterarOrdemEProduto(ordemproducao object, ArrayList<ordemproduto> ListaNovo, ArrayList<ordemproduto> ListaAlterar, ArrayList<ordemproduto> ListaExcluir) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario(); 
            ordemproducao ordemantiga = new ordemproducao();
            ordemantiga.LerClasse(object.getIdordemproducao());
            DataAntigaProducao = ordemantiga.getDataordem();
            manager.merge(object);
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
    
    /* 
     * Objetivo     : Excluir um objeto cargo do banco de dados
     * Data Criação : 08/07/08 
     */    
    @Override
    public boolean Excluir(ordemproducao object) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            object = manager.merge(object);
            manager.remove(object);
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
        String Ordenacao = " order by op.dataordem, idordemproducao ";
        try {
            String Consulta = " select false as selecao, op.idordemproducao, op.dataordem, r.idrefeicao, r.descricao, op.setor, op.motivo, " +
                              " o.idorigemordem, o.descricao, s.idsituacaoordem, s.descricao " +
                              " from ordemproducao op " +
                              "      inner join refeicao r       on  op.idrefeicao = r.idrefeicao " +
                              "      inner join origemordem o    on  op.idorigemordem = o.idorigemordem " +
                              "      inner join situacaoordem s  on   s.idsituacaoordem = op.idsituacaoordem";
                             // "      left  join ordemproduto opt on opt.idordemproducao = op.idordemproducao ";                              
            ListaResultado = manager.createNativeQuery(Consulta + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }

    @Override
    public ordemproducao CarregarObjeto(ordemproducao object) {
        ordemproducao o = new ordemproducao();        
        o = manager.find(ordemproducao.class, object.getIdordemproducao());  
        manager.clear();
        return o;
    }  
    
    public Integer RetornaProximoId(){
        Vector ListaResultado;
        ListaResultado = new Vector();
        Integer id;
        String Consulta = " select (Max(idordemproducao) + 1) as id from ordemproducao ";
        ListaResultado = (Vector) manager.createNativeQuery(Consulta).getSingleResult();
        id = (Integer)ListaResultado.get(0);
        if (id == null) {
            id = 1;
        }
        return id;
    }
}
