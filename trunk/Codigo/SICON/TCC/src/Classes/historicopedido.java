/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "historicopedido")
@NamedQueries({@NamedQuery(name = "historicopedido.findByIdhistoricopedido", query = "SELECT h FROM historicopedido h WHERE h.idhistoricopedido = :idhistoricopedido"), @NamedQuery(name = "historicopedido.findByDatahistoricopedido", query = "SELECT h FROM historicopedido h WHERE h.datahistoricopedido = :datahistoricopedido")})
public class historicopedido implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idhistoricopedido", nullable = false)
    private Integer idhistoricopedido;
    @Column(name = "datahistoricopedido", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahistoricopedido;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idsituacaopedido", unique = true, referencedColumnName = "idsituacaopedido", nullable = false)
    private situacaopedido Situacaopedido;
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")      
    @ManyToOne( cascade=CascadeType.ALL)  
    private pedido Pedido;      

    public historicopedido() {
    }

    public historicopedido(Integer idhistoricopedido) {
        this.idhistoricopedido = idhistoricopedido;
    }

    public historicopedido(Integer idhistoricopedido, Date datahistoricopedido) {
        this.idhistoricopedido = idhistoricopedido;
        this.datahistoricopedido = datahistoricopedido;
    }

    public Integer getIdhistoricopedido() {
        return idhistoricopedido;
    }

    public void setIdhistoricopedido(Integer idhistoricopedido) {
        this.idhistoricopedido = idhistoricopedido;
    }

    public Date getDatahistoricopedido() {
        return datahistoricopedido;
    }

    public void setDatahistoricopedido(Date datahistoricopedido) {
        this.datahistoricopedido = datahistoricopedido;
    }

    public pedido getPedido() {
        return Pedido;
    }

    public void setIdpedido(pedido idpedido) {
        this.Pedido = idpedido;
    }

    public situacaopedido getIdsituacaopedido() {
        return Situacaopedido;
    }

    public void setIdsituacaopedido(situacaopedido idsituacaopedido) {
        this.Situacaopedido = idsituacaopedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistoricopedido != null ? idhistoricopedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof historicopedido)) {
            return false;
        }
        historicopedido other = (historicopedido) object;
        if ((this.idhistoricopedido == null && other.idhistoricopedido != null) || (this.idhistoricopedido != null && !this.idhistoricopedido.equals(other.idhistoricopedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.historicopedido[idhistoricopedido=" + idhistoricopedido + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Excluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void LimparClasse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void LerClasse(int Id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
