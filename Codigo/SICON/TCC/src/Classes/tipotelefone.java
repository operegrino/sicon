/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoTipoTelefone;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "tipotelefone")
@NamedQueries({@NamedQuery(name = "tipotelefone.findByIdtipotelefone", query = "SELECT t FROM tipotelefone t WHERE t.idtipotelefone = :idtipotelefone"), @NamedQuery(name = "tipotelefone.findByDescricao", query = "SELECT t FROM tipotelefone t WHERE t.descricao = :descricao")})
public class tipotelefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idtipotelefone", nullable = false)
    private Integer idtipotelefone;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public tipotelefone() {
    }

    public tipotelefone(Integer idtipotelefone) {
        this.idtipotelefone = idtipotelefone;
    }

    public tipotelefone(Integer idtipotelefone, String descricao) {
        this.idtipotelefone = idtipotelefone;
        this.descricao = descricao;
    }

    public void LerClasse(int Id) {
        this.LimparClasse(); 
        this.setIdtipotelefone(Id);
        DaoTipoTelefone daoTipoTelefone = new DaoTipoTelefone();
        try {
            this.CarregarClasse(daoTipoTelefone.CarregarTipoTelefone(this));
        } catch (Exception e) {
            this.LimparClasse();
        } 
    }

    public Integer getIdtipotelefone() {
        return idtipotelefone;
    }

    public void setIdtipotelefone(Integer idtipotelefone) {
        this.idtipotelefone = idtipotelefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*public Collection<telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipotelefone != null ? idtipotelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tipotelefone)) {
            return false;
        }
        tipotelefone other = (tipotelefone) object;
        if ((this.idtipotelefone == null && other.idtipotelefone != null) || (this.idtipotelefone != null && !this.idtipotelefone.equals(other.idtipotelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.tipotelefone[idtipotelefone=" + idtipotelefone + "]";
    }

    
    public void LimparClasse(){
        this.setIdtipotelefone(null);
        this.setDescricao(null);        
    }
    
    public void CarregarClasse(Object object) throws Exception {
        this.setIdtipotelefone(((tipotelefone)object).getIdtipotelefone());
        this.setDescricao(((tipotelefone)object).getDescricao());    
    }   
    
    public Vector RetornarTodos(){
        DaoTipoTelefone daoTipoTelefone = new DaoTipoTelefone();        
        return (Vector) daoTipoTelefone.RetornaTodos();    
    }

}
