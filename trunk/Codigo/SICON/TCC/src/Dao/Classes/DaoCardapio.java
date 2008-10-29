/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.Funcoes;
import Classes.cardapio;
import Dao.Interfaces.DaoAbstractGenerica;
import Dao.Interfaces.DaoGenericaCardapio;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import Classes.UsuarioSistema;
import Classes.tela;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class DaoCardapio extends DaoAbstractGenerica implements DaoGenericaCardapio{
    
    public DaoCardapio(){
        super();
    }

   @Override
    public boolean Salvar(cardapio object) {
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

    @Override
    public boolean Alterar(cardapio object) {
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
            e.printStackTrace();
            Alterou = false;
            transacao.rollback();      
        } finally {
            manager.clear();
            return Alterou;            
        }    
    }

    @Override
    public boolean Excluir(cardapio object) {
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
            if (ListaParametros.get(contador).equals("cardapio")) {
                Parametros = Parametros + And + " c.idcardapio = "+ ListaParametros.get(contador + 1);
                And = " And ";
            }else if (ListaParametros.get(contador).equals("data")){
                Date dt = Funcoes.FormataDataPadrao(ListaParametros.get(contador + 1));
                SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
                String d = s.format(dt);
                Parametros = Parametros + And + " c.datacardapio = '"+ d + "' ";
                And = " And ";                
            }else if (ListaParametros.get(contador).equals("fichatecnica")) {
                String Ficha = " (select Distinct idcardapio from cardapioficha cf where cf.idcardapio = c.idcardapio and cf.idfichatecnica = "+ ListaParametros.get(contador + 1) + ") ";
                Parametros = Parametros + And + " c.idcardapio = " + Ficha;
                And = " And ";
            }           
            contador = contador + 2;
        }        
        String Ordenacao = " order by c.datacardapio, r.descricao ";
        try {
            ListaResultado = manager.createNativeQuery("Select c.idcardapio, r.descricao, c.qtderefeicoes, c.datacardapio  from cardapio c inner join refeicao r on c.idrefeicao = r.idrefeicao " + Parametros + Ordenacao).getResultList();            
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListaResultado;
    }
    


    @Override
    public cardapio CarregarObjeto(cardapio object) {
        cardapio c = new cardapio();
        c = manager.find(cardapio.class, object.getIdcardapio());        
        return c;
     }    
    

}
