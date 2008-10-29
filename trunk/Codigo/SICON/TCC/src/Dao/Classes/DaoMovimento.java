/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.Funcoes;
import Classes.movimento;
import Classes.UsuarioSistema;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaMovimento;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Jonathan
 */
public class DaoMovimento extends DaoAbstractGenerica {


    public DaoMovimento(){
        super();
    }
    /* 
     * Objetivo     : Salvar um novo objeto cargo no banco de dados
     * Data Criação : 08/07/08 
     */  
    public boolean Salvar(movimento object) {
        boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();            
            manager.persist(object);
            if (object.getOperacao().getIdoperacao() == 1) {
                GravarSaldo(super.manager, object.getDatamovimento(), (int)object.getProduto().getIdproduto(), object.getQuantidade(), 0, 0);
            } else {
                GravarSaldo(super.manager, object.getDatamovimento(), (int)object.getProduto().getIdproduto(), object.getQuantidade(), 1, 0);
            }        
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
    
    public boolean GravarSaldo(EntityManager Man, Date DataMovimento, int Produto, BigDecimal Valor, int TipoSaldo, int Operacao){
        boolean Gravou = false;     
        try {           
            SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
            String Data = sd.format(DataMovimento);
            Man.createNativeQuery("select gravarsaldo(cast('" + Data + "' as date), " + String.valueOf(Produto) + ", " +
                                                         Valor.toString() + ", " + String.valueOf(TipoSaldo) + ", " +String.valueOf(Operacao) + ")").getSingleResult();
            Gravou = true;
        } catch (Exception e) {
            Logger logger = Logger.getLogger("Usuario : " + String.valueOf(UsuarioSistema.getidLogEntrada()));        
            FileHandler fh = new FileHandler("Exceções do Sistema.txt");   
            logger.addHandler(fh);      
            logger.warning(e.getMessage());              
            System.out.println(e);
            Gravou = false;            
        } finally {
            return Gravou;
        }
    }
    
    public boolean Alterar(movimento object, movimento movAntigo) {
        boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();            
            manager.merge(object);
            if (object.getOperacao().getIdoperacao() == 1) {
                GravarSaldo(super.manager, movAntigo.getDatamovimento(), (int)movAntigo.getProduto().getIdproduto(), movAntigo.getQuantidade(), 0, 1);
                GravarSaldo(super.manager, object.getDatamovimento(), (int)object.getProduto().getIdproduto(), object.getQuantidade(), 0, 0);
            } else {
                GravarSaldo(super.manager, movAntigo.getDatamovimento(), (int)movAntigo.getProduto().getIdproduto(), movAntigo.getQuantidade(), 1, 1);
                GravarSaldo(super.manager, object.getDatamovimento(), (int)object.getProduto().getIdproduto(), object.getQuantidade(), 1, 0);
            }                    
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
     * Objetivo     : Excluir um objeto cargo do banco de dados
     * Data Criação : 08/07/08 
     */    
    public boolean Excluir(movimento object) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            object = manager.merge(object);
            manager.remove(object);
            if (object.getOperacao().getIdoperacao() == 1) {
                GravarSaldo(super.manager, object.getDatamovimento(), (int)object.getProduto().getIdproduto(), object.getQuantidade(), 0, 1);
            } else {
                GravarSaldo(super.manager, object.getDatamovimento(), (int)object.getProduto().getIdproduto(), object.getQuantidade(), 1, 1);
            }              
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
            if (ListaParametros.get(contador).equals("produto")) {
                Parametros = Parametros + And + " p.codigo = '"+ ListaParametros.get(contador + 1) + "' ";
                And = " And ";
            }else if (ListaParametros.get(contador).equals("data")){
                Date dt = Funcoes.FormataDataPadrao(ListaParametros.get(contador + 1));
                SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
                String d = s.format(dt);
                Parametros = Parametros + And + " m.datamovimento = '"+ d + "' ";
                And = " And ";                
            }else if (ListaParametros.get(contador).equals("operacao")){
                Parametros = Parametros + And + " m.idoperacao = "+ ListaParametros.get(contador + 1);
                And = " And ";                
            } else if (ListaParametros.get(contador).equals("Quantidade")){
                Parametros = Parametros + And + " m.quantidade = "+ ListaParametros.get(contador + 1);
                And = " And ";
            } else if (ListaParametros.get(contador).equals("Motivo")){
                Parametros = Parametros + And + " m.motivooperacao like '%"+ ListaParametros.get(contador + 1) + "%' ";
                And = " And ";
            }            
            contador = contador + 2;
        }        
        String Ordenacao = " order by m.idmovimento, m.datamovimento ";
        try {
            ListaResultado = manager.createNativeQuery(" select m.idmovimento, m.idproduto, p.nome, m.quantidade, m.datamovimento, m.idoperacao, o.descricao, m.idunidademedida, u.nome, m.motivooperacao  " +
                                                       " from movimento m " +
                                                       " inner join produto p on m.idproduto = p.idproduto " +
                                                       " inner join operacao o on m.idoperacao = o.idoperacao "  +
                                                       " inner join unidademedida u on m.idunidademedida = u.idunidademedida "+ Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }

    public movimento CarregarObjeto(movimento object) {
        movimento m = new movimento();        
        m = manager.find(movimento.class, object.getIdmovimento());  
        manager.clear();
        return m;
    }

}
