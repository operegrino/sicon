/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoPerfil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "perfil")
@NamedQueries({@NamedQuery(name = "perfil.findByIdperfil", query = "SELECT p FROM perfil p WHERE p.idperfil = :idperfil"), @NamedQuery(name = "perfil.findByNome", query = "SELECT p FROM perfil p WHERE p.nome = :nome"), @NamedQuery(name = "perfil.findByAdministrador", query = "SELECT p FROM perfil p WHERE p.administrador = :administrador")})
public class perfil implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idperfil", nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idperfil;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "administrador", nullable = false)
    private boolean administrador;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "perfil")
    private Collection<perfiltela> perfiltelaCollection;

    public perfil() {
    }

    public perfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public perfil(Integer idperfil, String nome, boolean administrador) {
        this.idperfil = idperfil;
        this.nome = nome;
        this.administrador = administrador;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Collection<perfiltela> getPerfiltelaCollection() {
        return perfiltelaCollection;
    }

    public void setPerfiltelaCollection(Collection<perfiltela> perfiltelaCollection) {
        this.perfiltelaCollection = perfiltelaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }
    @PostPersist
    public void AtualizaIdAcesso(){
        //ArrayList<perfiltela> ListaAcesso = new ArrayList<perfiltela>();
        for (Iterator<perfiltela> it = perfiltelaCollection.iterator(); it.hasNext();) {
            perfiltela object = it.next();
            object.setIdperfil(this);
        }
        //this.setPerfiltelaCollection(null);
        //this.setPerfiltelaCollection(perfiltelaCollection);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof perfil)) {
            return false;
        }
        perfil other = (perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.perfil[idperfil=" + idperfil + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoPerfil daoPerfil = new DaoPerfil();
        if (Operacao == 0) {
            return daoPerfil.Salvar(this);
        } else
            return daoPerfil.Alterar(this);        
    }
    
    

    @Override
    public boolean Excluir() {
        DaoPerfil daoPerfil = new DaoPerfil();
        return daoPerfil.Excluir(this);
    }

    @Override
    public ArrayList Pesquisar(ArrayList<String> ListaParametros) {
        DaoPerfil daoPerfil = new DaoPerfil();
        return daoPerfil.Pesquisar(ListaParametros);   
    }

    @Override
    public void LimparClasse() {
        this.setIdperfil(null);
        this.setNome(null);
        this.setAdministrador(false);        
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdperfil(Id);
        DaoPerfil daoPerfil = new DaoPerfil();
        this.CarregarClasse(daoPerfil.CarregarObjeto(this));  
    }

    @Override
    public void CarregarClasse(Object object) {
        this.setIdperfil(((perfil)object).getIdperfil());
        this.setNome(((perfil)object).getNome());
        this.setAdministrador(((perfil)object).getAdministrador());
        this.setPerfiltelaCollection(((perfil)object).getPerfiltelaCollection());
    }

}
