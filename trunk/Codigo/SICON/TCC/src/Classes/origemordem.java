/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoOrigemOrdem;
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
 * @author jonathan
 */
@Entity
@Table(name = "origemordem")
@NamedQueries({@NamedQuery(name = "origemordem.findByIdorigemordem", query = "SELECT o FROM origemordem o WHERE o.idorigemordem = :idorigemordem"), @NamedQuery(name = "origemordem.findByDescricao", query = "SELECT o FROM origemordem o WHERE o.descricao = :descricao")})
public class origemordem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idorigemordem", nullable = false)
    private Integer idorigemordem;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorigemordem")
    private Collection<ordemproducao> ordemproducaoCollection;

    public origemordem() {
    }

    public origemordem(Integer idorigemordem) {
        this.idorigemordem = idorigemordem;
    }

    public origemordem(Integer idorigemordem, String descricao) {
        this.idorigemordem = idorigemordem;
        this.descricao = descricao;
    }

    public Integer getIdorigemordem() {
        return idorigemordem;
    }

    public void setIdorigemordem(Integer idorigemordem) {
        this.idorigemordem = idorigemordem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<ordemproducao> getOrdemproducaoCollection() {
        return ordemproducaoCollection;
    }

    public void setOrdemproducaoCollection(Collection<ordemproducao> ordemproducaoCollection) {
        this.ordemproducaoCollection = ordemproducaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorigemordem != null ? idorigemordem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof origemordem)) {
            return false;
        }
        origemordem other = (origemordem) object;
        if ((this.idorigemordem == null && other.idorigemordem != null) || (this.idorigemordem != null && !this.idorigemordem.equals(other.idorigemordem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.origemordem[idorigemordem=" + idorigemordem + "]";
    }
    
    public void LimparClasse() {
        setIdorigemordem(null);
        setDescricao(null);        
    }

    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdorigemordem(Id);
        DaoOrigemOrdem daoOrigemOrdem = new DaoOrigemOrdem();
        try {
            this.CarregarClasse(daoOrigemOrdem.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }
    
    public Vector RetornaTodas(){
        DaoOrigemOrdem daoOrigem = new DaoOrigemOrdem();
        return daoOrigem.Pesquisar(new ArrayList());
    }

    public void CarregarClasse(Object object) throws Exception {
        setIdorigemordem(((origemordem)object).getIdorigemordem());
        setDescricao(((origemordem)object).getDescricao());
    }        

}
