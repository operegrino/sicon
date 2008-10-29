/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.contato;
import Classes.email;
import Classes.fornecedor;

import Classes.telefone;
import Classes.tipotelefone;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class ControllerContato extends ControllerAncestral {

    private contato Contato;
    
    public ControllerContato(){
        Contato = new contato();
    }
    
    public boolean EventoSalvar(Vector<telefone> ListaTel, Vector<email> ListaEmail) {
        return Contato.Gravar(0, this.TelaParaControllerTelefone(ListaTel), null, this.TelaParaControllerEmail(ListaEmail), null);
    }

    public boolean EventoAlterar(Vector<telefone> ListaTel, ArrayList<Integer> ExcluirTel, Vector<email> ListaEmail, ArrayList<Integer> ExcluirEmail) {
        return Contato.Gravar(1, this.TelaParaControllerTelefone(ListaTel), ExcluirTel, this.TelaParaControllerEmail(ListaEmail), ExcluirEmail);        
    }

    public List EventoPesquisar(ArrayList ListaParametros) {
        return Contato.Pesquisar(ListaParametros);
    }

    public ArrayList EventoSairCampoFornecedor(String codigo){
        fornecedor Fornecedor = new fornecedor();
        ArrayList Lista = new ArrayList();
        Fornecedor.LerClasse(codigo);        
        Lista.add(Fornecedor.getIdfornecedor());
        Lista.add(Fornecedor.getCodigo());
        Lista.add(Fornecedor.getRazaosocial());
        return Lista;
    }
    
    public boolean EventoExcluir(Vector ListaTel, Vector ListaEmail) {
        return Contato.Excluir(this.TelaParaControllerTelefone(ListaTel), this.TelaParaControllerEmail(ListaEmail));
    }

    public boolean EventoExcluirUnicoTelefone(int Id){
        return Contato.ExcluirUnicoTelefone(Id);
    }
    
    public boolean EventoExcluirUnicoEmail(int Id) {
       return Contato.ExcluirUnicoEmail(Id);        
    }
    /**************************************************************************
     * RETORNA UM ARRAY COM :
     * 0 : idFornecedor
     * 1 : RazaoSocial
     * 2 : ArrayList(Informações do Telefone)
     * 3 : ArrayList(Informações do Email)
     ***************************************************************************/
    public ArrayList<Object> EventoSelecionar(int id) {
        ArrayList Lista = new ArrayList();
        Lista.add(Contato.RetornaTelefone(id));
        Lista.add(Contato.RetornaEmail(id));
        return Lista;
    }

    public ArrayList ControllerParaTelaTelefone(){
        return new ArrayList();    
    }
    
    /***************************************************************************
     * PASSADO UM ARRAYLIST QUE POSSUI VARIOS ARRAYLIST REFERENTE AO TELEFONE
     * 0     -   idTelefone
     * 1     -   telefone
     * 2     -   ddd
     * 3     -   tipotelefone(id);
     **************************************************************************/
    
    public Vector TelaParaControllerTelefone(Vector Lista) {   
        Vector ListaTelefone = new Vector();
        for (Iterator<Vector> it = Lista.iterator(); it.hasNext();) {
            Vector object = it.next();
            telefone Telefone = new telefone();
            if (Integer.parseInt(object.get(6).toString()) != 0) {
                Telefone.setIdtelefone(Integer.parseInt(object.get(6).toString()));
            }            
            Telefone.setTelefone(object.get(3).toString());
            Telefone.setDdd(object.get(2).toString());
            tipotelefone Tipo = new tipotelefone();
            Tipo.LerClasse(Integer.parseInt(object.get(4).toString()));
            Telefone.setIdtipotelefone(Tipo);
            fornecedor Forne = new fornecedor();
            Forne.LerClasse(Integer.parseInt(object.get(0).toString()));
            Telefone.setFornecedor(Forne);
            ListaTelefone.add(Telefone);
        }
        return ListaTelefone;
    }
    
    public ArrayList ControllerParaTelaEmail(ArrayList<email> ListaE){
        ArrayList ListaEmail = new ArrayList();
        for (Iterator<email> it = ListaE.iterator(); it.hasNext();) {
            email object = it.next();
            ArrayList Lista = new ArrayList();
            Lista.add(object.getIdemail());
            Lista.add(object.getEmail());
            
            ListaEmail.add(Lista);
        }
        return ListaEmail;
    }
    
    public Vector<email> TelaParaControllerEmail(Vector Lista) {
        Vector<email> ListaEmail = new Vector<email>();
        for (Iterator<Vector> it = Lista.iterator(); it.hasNext();) {   
            Vector object = it.next();
            email Ema = new email();
            if ((Integer.parseInt(object.get(6).toString()) != 0)) {
                Ema.setIdemail((Integer.parseInt(object.get(6).toString())));
            }
            Ema.setEmail(object.get(3).toString());
            fornecedor forne = new fornecedor();
            forne.LerClasse(Integer.parseInt(object.get(0).toString()));
            Ema.setFornecedor(forne);
            ListaEmail.add(Ema);
        }     
        return ListaEmail;
    }  
    
    public Vector CarregarComboTipoTelefone(){
        tipotelefone TT = new tipotelefone();
        return TT.RetornarTodos();
    }
}
