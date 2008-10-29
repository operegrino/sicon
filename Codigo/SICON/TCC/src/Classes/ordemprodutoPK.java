/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jonathan
 */
@Embeddable
public class ordemprodutoPK implements Serializable {
    @Column(name = "idordemproducao", nullable = false)
    private int idordemproducao;
    @Column(name = "idproduto", nullable = false)
    private int idproduto;

    public ordemprodutoPK() {
    }

    public ordemprodutoPK(int idordemproducao, int idproduto) {
        this.idordemproducao = idordemproducao;
        this.idproduto = idproduto;
    }
    
    public ordemprodutoPK( int idproduto) {
        this.idproduto = idproduto;
    }

    public int getIdordemproducao() {
        return idordemproducao;
    }

    public void setIdordemproducao(int idordemproducao) {
        this.idordemproducao = idordemproducao;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idordemproducao;
        hash += (int) idproduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ordemprodutoPK)) {
            return false;
        }
        ordemprodutoPK other = (ordemprodutoPK) object;
        if (this.idordemproducao != other.idordemproducao) {
            return false;
        }
        if (this.idproduto != other.idproduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.ordemprodutoPK[idordemproducao=" + idordemproducao + ", idproduto=" + idproduto + "]";
    }

}
