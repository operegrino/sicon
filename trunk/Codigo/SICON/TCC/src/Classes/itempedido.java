/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoItemPedido;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "itempedido")
@NamedQueries({@NamedQuery(name = "itempedido.findByIditempedido", query = "SELECT i FROM itempedido i WHERE i.iditempedido = :iditempedido"), @NamedQuery(name = "itempedido.findByQuantidade", query = "SELECT i FROM itempedido i WHERE i.quantidade = :quantidade")})
public class itempedido implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "iditempedido", nullable = false)
    private Integer iditempedido;
    @Column(name = "quantidade", nullable = false)
    private BigDecimal quantidade;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idunidademedida", unique = true, referencedColumnName = "idunidademedida", nullable = false)    
    private unidademedida UnidadeMedida;       
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idproduto", unique = true, referencedColumnName = "idproduto", nullable = false)
    private produto Produto;
    /*@OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idpedido", unique = true, referencedColumnName = "idpedido", nullable = false)    
    private pedido Pedido;  */
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")      
    @ManyToOne( cascade=CascadeType.ALL)  
    private pedido idpedido;  
    

    public itempedido() {
    }

    public itempedido(Integer iditempedido) {
        this.iditempedido = iditempedido;
    }

    public itempedido(Integer iditempedido, BigDecimal quantidade) {
        this.iditempedido = iditempedido;
        this.quantidade = quantidade;
    }

    public Integer getIditempedido() {
        return iditempedido;
    }

    public void setIditempedido(Integer iditempedido) {
        this.iditempedido = iditempedido;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    
    public unidademedida getUnidadeMedida() {
        return UnidadeMedida;
    }

    public void setUnidadeMedida(unidademedida uni) {
        this.UnidadeMedida = uni;
    }        

    public pedido getPedido() {
        return idpedido;
    }

    public void setPedido(pedido idpedido) {
        this.idpedido = idpedido;
    }
    
    public produto getProduto() {
        return Produto;
    }

    public void setProduto(produto Prod) {
        this.Produto = Prod;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditempedido != null ? iditempedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof itempedido)) {
            return false;
        }
        itempedido other = (itempedido) object;
        if ((this.iditempedido == null && other.iditempedido != null) || (this.iditempedido != null && !this.iditempedido.equals(other.iditempedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.itempedido[iditempedido=" + iditempedido + "]";
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
        setIditempedido(null);
        setPedido(null);
        setProduto(null);
        setQuantidade(null);
        setUnidadeMedida(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIditempedido(Id);
        DaoItemPedido daoItemPedido = new DaoItemPedido();
        try {
            this.CarregarClasse(daoItemPedido.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIditempedido(((itempedido)object).getIditempedido());
        this.setPedido(((itempedido)object).getPedido());
        this.setProduto(((itempedido)object).getProduto());
        this.setQuantidade(((itempedido)object).getQuantidade());
        this.setUnidadeMedida(((itempedido)object).getUnidadeMedida());
    }

}
