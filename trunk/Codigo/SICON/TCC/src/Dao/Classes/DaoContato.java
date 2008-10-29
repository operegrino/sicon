/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao.Classes;

import Classes.UsuarioSistema;
import Classes.email;
import Classes.telefone;
import Dao.Interfaces.DaoAbstractGenerica;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;

/**
 * @Descrição : Está Dao acessa o banco para gravar informações referentes do
 *              telefone e do email; 
 * @author Jonathan
 */
public class DaoContato extends DaoAbstractGenerica{
    
    public DaoContato(){
        super();
    }
    
    public boolean Salvar(Vector<telefone> ListaTelefone, Vector<email> ListaEmail) {
      boolean Gravou = false;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            super.AtualizaUsuario();  
            for (Iterator<email> it = ListaEmail.iterator(); it.hasNext();) {
                email Email = it.next();
                manager.persist(Email);
            }
            for (Iterator<telefone> it = ListaTelefone.iterator(); it.hasNext();) {
                telefone Telefone = it.next();
                manager.persist(Telefone);
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

    public boolean Alterar(Vector<telefone> ListaTelefone,ArrayList<Integer> ExcluirTel, Vector<email> ListaEmail, ArrayList<Integer> ExcluirEmail) {
       boolean Alterou = false;
        EntityTransaction transacao = manager.getTransaction(); 
        try {
            transacao.begin();
            super.AtualizaUsuario();
            for (Iterator<Integer> it = ExcluirEmail.iterator(); it.hasNext();) {
                Integer id = it.next();
                email Email = new email();
                Email.LerClasseEmail(id);
                Email = manager.merge(Email);
                manager.remove(Email);               
            }            
            for (Iterator<Integer> it = ExcluirTel.iterator(); it.hasNext();) {
                Integer id = it.next();
                telefone Telefone = new telefone();
                Telefone.LerClasseTelefone(id);
                Telefone = manager.merge(Telefone);
                manager.remove(Telefone);                 
            }
            for (Iterator<email> it = ListaEmail.iterator(); it.hasNext();) {                
                email Email = it.next();
                if (Email.getIdemail() == null){
                    manager.persist(Email);
                } else {
                manager.merge(Email);
                //manager.flush();
                }
            }
            for (Iterator<telefone> it = ListaTelefone.iterator(); it.hasNext();) {
                telefone Telefone = it.next();
                if (Telefone.getIdtelefone() == null){
                    manager.persist(Telefone);
                } else {
                manager.merge(Telefone);
                //manager.flush();
                }
            }    
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

    public boolean Excluir(Vector<telefone> ListaTelefone, Vector<email> ListaEmail) {
         boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            for (Iterator<email> it = ListaEmail.iterator(); it.hasNext();) {
                email Email = it.next();
                Email = manager.merge(Email);
                manager.remove(Email);
            }
            for (Iterator<telefone> it = ListaTelefone.iterator(); it.hasNext();) {
                telefone Telefone = it.next();
                Telefone = manager.merge(Telefone);
                manager.remove(Telefone);
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
    
    public boolean ExcluirTelefone(telefone Tel) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            Tel = manager.merge(Tel);
            manager.remove(Tel);
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
    
    public boolean ExcluirEmail(email Ema) {
        boolean Excluir = false;
        EntityTransaction transacao = manager.getTransaction();
        try {
            transacao.begin();
            super.AtualizaUsuario();
            Ema = manager.merge(Ema);
            manager.remove(Ema);
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

    public List Pesquisar(ArrayList<String> ListaParametros) {
      String ParametrosTelefone = "";
      String ParametrosEmail    = "";
        //ListaCargo = null;
        List ListaResultado;
        ListaResultado = new ArrayList();
        int contador = 0;
        if (!(ListaParametros.isEmpty())){
            ParametrosTelefone = " where ";
            ParametrosEmail = " where ";            
        }
        boolean AdicionarAnd = false;
        String And = "";
        while (ListaParametros.size() > contador) {                        
            if (ListaParametros.get(contador).contentEquals("fornecedor")) {
                if (AdicionarAnd) {
                    And = " and ";
                }
                ParametrosTelefone = ParametrosTelefone + And + "f.codigo = '"+ ListaParametros.get(contador + 1)+"'";
                ParametrosEmail = ParametrosEmail + And + "f.codigo = '"+ ListaParametros.get(contador + 1)+"'";                
                AdicionarAnd = true;
            } 
            if (ListaParametros.get(contador).contentEquals("telefone")){
                if (AdicionarAnd) {                   
                    And = " and ";
                }                
                ParametrosTelefone = ParametrosTelefone + And + " t.telefone =     '"+ ListaParametros.get(contador + 1)+"'";
                AdicionarAnd = true;
            }   
            if (ListaParametros.get(contador).contentEquals("email")) {
                if (AdicionarAnd) {                    
                    And = " and ";
                }
                ParametrosEmail = ParametrosEmail + And + "e.email ILIKE '%"+ ListaParametros.get(contador + 1) +"%'";                    
                AdicionarAnd = true;
            }           
            contador = contador + 2;
        }        
        String Ordenacao = " order by razaosocial, contato, tipo";
        try {
            String Consulta = " SELECT f.idfornecedor, f.razaosocial, t.ddd, t.telefone as contato, tt.idtipotelefone, tt.descricao as tipo, t.idtelefone as id, f.codigo " +
                              " FROM  fornecedor f " +
                              " INNER JOIN telefone t ON t.idfornecedor = f.idfornecedor " +
                              " INNER JOIN tipotelefone tt ON t.idtipotelefone  = tt.idtipotelefone " +
                              ParametrosTelefone +
                              " UNION " +
                              " SELECT f.idfornecedor, f.razaosocial, '', e.email as contato, 0, 'email' as tipo, e.idemail as id, f.codigo " +
                              " FROM   fornecedor f " +
                              " INNER JOIN email        e  ON f.idfornecedor    = e.idfornecedor " +
                              ParametrosEmail;
            ListaResultado = manager.createNativeQuery(Consulta + Ordenacao).getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListaResultado;
    }

    public List PesquisarTelefone(int idFornecedor) {
        List ListaResultado;
        ListaResultado = new ArrayList();        
        String Consulta =     " SELECT  e.idemail, e.email as contato " +
                              " FROM " +  
                              " email  e " +
                              " order by e.email ";
        try {
            ListaResultado = manager.createQuery(Consulta).getResultList();
        } catch (Exception e) {
            e.printStackTrace();            
        } finally {
            return ListaResultado;
        }
    }
    
    public List PesquisarEmail(int idFornecedor) {
        List ListaResultado;
        ListaResultado = new ArrayList();        
        String Consulta =     " SELECT t.idtelefone, t.ddd, t.telefone as contato , tt.idtipotelefone, tt.descricao as tipo" +
                              " FROM   " +
                              " telefone t INNER JOIN tipotelefone tt ON t.idtipotelefone  = tt.idtipotelefone " +
                              " order by t.telefone ";
        try {
            ListaResultado = manager.createQuery(Consulta).getResultList();
        } catch (Exception e) {
            e.printStackTrace();            
        } finally {
            return ListaResultado;
        }
    }
    
    public telefone CarregarTelefone(telefone object) {
        telefone t = new telefone();        
        t = manager.find(telefone.class, object.getIdtelefone());  
        manager.clear();
        return t;
    }
    
    public email CarregarEmail(email object) {
        email e = new email();        
        e = manager.find(email.class, object.getIdemail());  
        manager.clear();
        return e;
    }
    

}
