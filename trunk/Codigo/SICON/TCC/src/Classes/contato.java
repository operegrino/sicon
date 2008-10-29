/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoContato;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Descricao : Classe usada para salvar telefone e email juntos;
 * @author Jonathan
 */
public class contato {

    private telefone Telefone;
    private email Email;
    
    public contato(){
        Telefone = new telefone();
        Email    = new email();
    }
    
    public boolean Gravar(int Operacao, Vector<telefone> ListaTel, ArrayList<Integer> ExcluirTel, Vector<email> ListaEmail, ArrayList<Integer> ExcluirEmail) {
        DaoContato daoContato = new DaoContato();
        if (Operacao == 0) {
            return daoContato.Salvar(ListaTel, ListaEmail);
        } else
            return daoContato.Alterar(ListaTel, ExcluirTel, ListaEmail, ExcluirEmail);        
    }

    public boolean Excluir(Vector<telefone> ListaTel, Vector<email> ListaEmail) {
        DaoContato daoContato = new DaoContato();
        return daoContato.Excluir(ListaTel, ListaEmail);
    }
    
    public boolean ExcluirUnicoTelefone(int Id){
        DaoContato daoContato = new DaoContato();
        telefone Telefone1 = new telefone();
        Telefone1.LerClasseTelefone(Id);
        return daoContato.ExcluirTelefone(Telefone1);                
    }
    
    public boolean ExcluirUnicoEmail(int Id) {
        DaoContato daoContato = new DaoContato(); 
        email Email1 = new email();
        Email1.LerClasseEmail(Id);
        return daoContato.ExcluirEmail(Email1);
    }

    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoContato daoContato = new DaoContato();
        return daoContato.Pesquisar(ListaParametros);     
    }

    public ArrayList RetornaTelefone(int Fornecedor) {
        DaoContato daoContato = new DaoContato();
        return (ArrayList) daoContato.PesquisarTelefone(Fornecedor);
    }
    
    public ArrayList RetornaEmail(int Fornecedor) {
        DaoContato daoContato = new DaoContato();
        return (ArrayList) daoContato.PesquisarEmail(Fornecedor);
    }
 


}
