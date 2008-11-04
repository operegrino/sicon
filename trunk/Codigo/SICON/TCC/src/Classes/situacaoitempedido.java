/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "situacaoitempedido")
@NamedQueries({@NamedQuery(name = "situacaoitempedido.findByIdsituacaoitempedido", query = "SELECT s FROM situacaoitempedido s WHERE s.idsituacaoitempedido = :idsituacaoitempedido"), @NamedQuery(name = "situacaoitempedido.findByDescricao", query = "SELECT s FROM situacaoitempedido s WHERE s.descricao = :descricao")})
public class situacaoitempedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idsituacaoitempedido", nullable = false)
    private Integer idsituacaoitempedido;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public situacaoitempedido() {
    }

    public situacaoitempedido(Integer idsituacaoitempedido) {
        this.idsituacaoitempedido = idsituacaoitempedido;
    }

    public situacaoitempedido(Integer idsituacaoitempedido, String descricao) {
        this.idsituacaoitempedido = idsituacaoitempedido;
        this.descricao = descricao;
    }

    public Integer getIdsituacaoitempedido() {
        return idsituacaoitempedido;
    }

    public void setIdsituacaoitempedido(Integer idsituacaoitempedido) {
        this.idsituacaoitempedido = idsituacaoitempedido;
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
        hash += (idsituacaoitempedido != null ? idsituacaoitempedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof situacaoitempedido)) {
            return false;
        }
        situacaoitempedido other = (situacaoitempedido) object;
        if ((this.idsituacaoitempedido == null && other.idsituacaoitempedido != null) || (this.idsituacaoitempedido != null && !this.idsituacaoitempedido.equals(other.idsituacaoitempedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.situacaoitempedido[idsituacaoitempedido=" + idsituacaoitempedido + "]";
    }

}
