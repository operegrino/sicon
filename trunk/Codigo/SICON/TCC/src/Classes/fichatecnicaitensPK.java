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
 * @author Jonathan
 */
@Embeddable
public class fichatecnicaitensPK implements Serializable {
    @Column(name = "idfichatecnica", nullable = false)
    private int idfichatecnica;
    @Column(name = "idproduto", nullable = false)
    private int idproduto;

    public fichatecnicaitensPK() {
    }

    public fichatecnicaitensPK(int idfichatecnica, int idproduto) {
        this.idfichatecnica = idfichatecnica;
        this.idproduto = idproduto;
    }

    public int getIdfichatecnica() {
        return idfichatecnica;
    }

    public void setIdfichatecnica(int idfichatecnica) {
        this.idfichatecnica = idfichatecnica;
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
        hash += (int) idfichatecnica;
        hash += (int) idproduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof fichatecnicaitensPK)) {
            return false;
        }
        fichatecnicaitensPK other = (fichatecnicaitensPK) object;
        if (this.idfichatecnica != other.idfichatecnica) {
            return false;
        }
        if (this.idproduto != other.idproduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.fichatecnicaitensPK[idfichatecnica=" + idfichatecnica + ", idproduto=" + idproduto + "]";
    }

}
