/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoCargo;
import Dao.Classes.DaoUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "usuario")
@NamedQueries({@NamedQuery(name = "usuario.findByIdusuario", query = "SELECT u FROM usuario u WHERE u.idusuario = :idusuario"), /*@NamedQuery(name = "usuario.findByidperfil", query = "SELECT u FROM usuario u WHERE u.idperfil = :Perfil"), */@NamedQuery(name = "usuario.findByNomeusuario", query = "SELECT u FROM usuario u WHERE u.nomeusuario = :nomeusuario"),
               @NamedQuery(name = "usuario.findByLogin", query = "SELECT u FROM usuario u WHERE u.login = :login")})
public class usuario implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)    
    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idperfil", unique = true, referencedColumnName = "idperfil", nullable = false)
    public perfil Perfil;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idcargo", unique = true, referencedColumnName = "idcargo", nullable = false)
    public cargo Cargo;
    @Column(name = "nomeusuario", nullable = false)
    private String nomeusuario;
    @Column(name = "login", nullable = false)
    private String login;    
    @Column(name = "senha", nullable = false)
    private String senha;  

    public usuario() {
        Perfil = new perfil();
        Cargo = new cargo();
    }

    public usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }
    
    public perfil getPerfil(){
        return this.Perfil;
    }
    public void setPerfil(perfil p){
        this.Perfil = p;
    }
    
    public cargo getCargo(){
        return this.Cargo;
    }
    public void setCargo(cargo c){
        this.Cargo = c;
    }    
    
    @Override
  public boolean Gravar(int Operacao){
        DaoUsuario daoUsuario = new DaoUsuario();
        if (Operacao == 0) {
            return daoUsuario.Salvar(this);
        } else
            return daoUsuario.Alterar(this);
    }
    
    @Override
    public boolean Excluir() {        
        DaoUsuario daoUsuario = new DaoUsuario();
        return daoUsuario.Excluir(this);
    }
    
    @Override
    public ArrayList Pesquisar(ArrayList<String> ListaParametros) {
        DaoUsuario daoUsuario = new DaoUsuario();
        return (ArrayList) daoUsuario.Pesquisar(ListaParametros);         
    }
    
    public List Pesquisar2(ArrayList<String> ListaParametros) {
        DaoUsuario daoUsuario = new DaoUsuario();
        return daoUsuario.Pesquisar(ListaParametros);         
    }    
    
    public void carregarUsuarioSistema(String Login){
        DaoUsuario daoUsuario = new DaoUsuario();
        this.LimparClasse();
        this.CarregarClasse(daoUsuario.CarregaUsuarioSistema(Login));        
        //this.CarregarClasse(daoUsuario.CarregarObjeto(this));        
    }
    
    /* 
     * Objetivo     : Limpar os dados da classe
     * Data Criação : 08/07/08 
     */    
    @Override
    public void LimparClasse() {
        setIdusuario(null);
        Perfil.LimparClasse();
        Cargo.LimparClasse();
        setLogin("");
        setNomeusuario("");
        setSenha(null);
    }
    
    @Override
    public void LerClasse(int Id) {
        LimparClasse();  
        this.setIdusuario(Id);
        DaoUsuario daoUsuario = new DaoUsuario();
        this.CarregarClasse(daoUsuario.CarregarObjeto(this));        
    }    
    
    @Override
    public void CarregarClasse(Object object)  {
        if (!(object.equals(null)) || (!((usuario)object).getIdusuario().equals(null))) {
            this.setIdusuario(((usuario)object).getIdusuario());
            this.setLogin(((usuario)object).getLogin());
            this.setSenha(((usuario)object).getSenha());
            this.setNomeusuario(((usuario)object).getNomeusuario());
            this.setPerfil(((usuario)object).getPerfil());
            this.setCargo(((usuario)object).getCargo());
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof usuario)) {
            return false;
        }
        usuario other = (usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

}
