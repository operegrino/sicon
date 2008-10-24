/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.cargo;
import Classes.perfil;
import Classes.usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class ControllerUsuario extends ControllerAncestral implements InterfaceControllerPadrao {
    
    private usuario Usuario;
    
    public ControllerUsuario(){
        Usuario = new usuario();
    }

    @Override
    public boolean EventoSalvar(ArrayList<Object> Objeto) {
        Usuario.LimparClasse();
        CarregarClasse(Objeto);
        return Usuario.Gravar(0);
    }

    @Override
    public boolean EventoAlterar(ArrayList<Object> Objeto) {
        CarregarClasse(Objeto);
        return Usuario.Gravar(1);
    }

    @Override
    public boolean EventoExcluir() {
        return Usuario.Excluir();
    }

    @Override
    public ArrayList<Object> EventoSelecionar(int id) {
        Usuario.LerClasse(id);
        return DevolverDadosClasse(); 
    }

    @Override
    public ArrayList EventoPesquisar(ArrayList<String> ListaParametros) {
        return Usuario.Pesquisar(ListaParametros);
    }
    
    public List EventoPesquisar2(ArrayList<String> ListaParametros) {
        return Usuario.Pesquisar2(ListaParametros);
    }    
    

    @Override
    public void CarregarClasse(ArrayList<Object> Objeto) {
        Usuario.setNomeusuario((String)Objeto.get(0));
        Usuario.Perfil.LerClasse(Integer.parseInt((String)Objeto.get(1)));
        Usuario.Cargo.LerClasse(Integer.parseInt((String)Objeto.get(2)));
        Usuario.setLogin((String)Objeto.get(3));
        Usuario.setSenha((String)Objeto.get(4));        
    }

    @Override
    public ArrayList<Object> DevolverDadosClasse() {
        ArrayList Lista = new ArrayList<Object>();
        Lista.add(Usuario.getNomeusuario());
        Lista.add(((perfil)Usuario.getPerfil()).getIdperfil());
        Lista.add(((cargo)Usuario.getCargo()).getIdcargo());
        Lista.add(Usuario.getLogin());
        Lista.add(Usuario.getSenha());
        return Lista;
    }
    
    public String RetornaDescricaoPerfil(int Id){
        Usuario.Perfil.LerClasse(Id);
        return Usuario.Perfil.getNome();
    }

    public String RetornaDescricaoCargo(int Id) {
        String Retorno;
        Usuario.Cargo.LerClasse(Id);
        Retorno = Usuario.Cargo.getDescricao();        
        return Retorno;
    }
}
