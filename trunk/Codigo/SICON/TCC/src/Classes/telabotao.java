/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Telas.Formulario.*;
import Classes.*;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "telabotao")
@NamedQueries({@NamedQuery(name = "telabotao.findByIdtelabotao", query = "SELECT t FROM telabotao t WHERE t.idtelabotao = :idtelabotao")})
public class telabotao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idtelabotao", nullable = false)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idtelabotao;
    @JoinColumn(name = "idbotao", referencedColumnName = "idbotao")
    @ManyToOne
    private botao idbotao;
    @JoinColumn(name = "idtela", referencedColumnName = "idtela")
    @ManyToOne
    private tela idtela;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelabotao")
    private Collection<perfiltela> perfiltelaCollection;*/

    public telabotao() {
    }

    public telabotao(Integer idtelabotao) {
        this.idtelabotao = idtelabotao;
    }

    public Integer getIdtelabotao() {
        return idtelabotao;
    }

    public void setIdtelabotao(Integer idtelabotao) {
        this.idtelabotao = idtelabotao;
    }

    public botao getIdbotao() {
        return idbotao;
    }

    public void setIdbotao(botao idbotao) {
        this.idbotao = idbotao;
    }

    public tela getIdtela() {
        return idtela;
    }

    public void setIdtela(tela idtela) {
        this.idtela = idtela;
    }

    /*public Collection<perfiltela> getPerfiltelaCollection() {
        return perfiltelaCollection;
    }

    public void setPerfiltelaCollection(Collection<perfiltela> perfiltelaCollection) {
        this.perfiltelaCollection = perfiltelaCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtelabotao != null ? idtelabotao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof telabotao)) {
            return false;
        }
        telabotao other = (telabotao) object;
        if ((this.idtelabotao == null && other.idtelabotao != null) || (this.idtelabotao != null && !this.idtelabotao.equals(other.idtelabotao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.telabotao[idtelabotao=" + idtelabotao + "]";
    }

}
