/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoSituacaoPedido;
import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "situacaopedido")
@NamedQueries({@NamedQuery(name = "situacaopedido.findByIdsituacaopedido", query = "SELECT s FROM situacaopedido s WHERE s.idsituacaopedido = :idsituacaopedido"), @NamedQuery(name = "situacaopedido.findByDescricao", query = "SELECT s FROM situacaopedido s WHERE s.descricao = :descricao")})
public class situacaopedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idsituacaopedido", nullable = false)
    private Integer idsituacaopedido;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public situacaopedido() {
    }

    public situacaopedido(Integer idsituacaopedido) {
        this.idsituacaopedido = idsituacaopedido;
    }

    public situacaopedido(Integer idsituacaopedido, String descricao) {
        this.idsituacaopedido = idsituacaopedido;
        this.descricao = descricao;
    }

    public Integer getIdsituacaopedido() {
        return idsituacaopedido;
    }

    public void setIdsituacaopedido(Integer idsituacaopedido) {
        this.idsituacaopedido = idsituacaopedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsituacaopedido != null ? idsituacaopedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof situacaopedido)) {
            return false;
        }
        situacaopedido other = (situacaopedido) object;
        if ((this.idsituacaopedido == null && other.idsituacaopedido != null) || (this.idsituacaopedido != null && !this.idsituacaopedido.equals(other.idsituacaopedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.situacaopedido[idsituacaopedido=" + idsituacaopedido + "]";
    }
    
    public void LimparClasse() {
        setIdsituacaopedido(null);
        setDescricao(null);
    }

    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdsituacaopedido(Id);
        DaoSituacaoPedido daoSituacaoPedido = new DaoSituacaoPedido();
        try {
            this.CarregarClasse(daoSituacaoPedido.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    public void CarregarClasse(Object object) throws Exception {
        this.setIdsituacaopedido(((situacaopedido)object).getIdsituacaopedido());
        this.setDescricao(((situacaopedido)object).getDescricao());
    }

}
