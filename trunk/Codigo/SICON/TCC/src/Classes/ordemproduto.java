/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoOrdemProduto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "ordemproduto")
//@NamedQueries({@NamedQuery(name = "ordemproduto.findByIdordemproducao", query = "SELECT o FROM ordemproduto o WHERE o.ordemprodutoPK.idordemproducao = :idordemproducao"), @NamedQuery(name = "ordemproduto.findByIdproduto", query = "SELECT o FROM ordemproduto o WHERE o.ordemprodutoPK.idproduto = :idproduto"), @NamedQuery(name = "ordemproduto.findByQuantidade", query = "SELECT o FROM ordemproduto o WHERE o.quantidade = :quantidade")})
public class ordemproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idordemproduto", nullable = false)
    private Integer IdOrdemProduto;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idordemproducao", unique = true, referencedColumnName = "idordemproducao", nullable = false)
    public ordemproducao OrdemProducao; 
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idproduto", unique = true, referencedColumnName = "idproduto", nullable = false)
    public produto Produto;     
    @Column(name = "quantidade", nullable = false)
    private BigDecimal quantidade;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idunidademedida", unique = true, referencedColumnName = "idunidademedida", nullable = false)
    public unidademedida UnidadeMedida; 
    public ordemproduto() {
    }

    public Integer getIdOrdemProduto() {
        return this.IdOrdemProduto;
    }

    public void setIdOrdemProduto(Integer id) {
        this.IdOrdemProduto = id;
    }
    
    public ordemproducao getOrdemProducao() {
        return this.OrdemProducao;
    }

    public void setProduto(produto Prod) {
        this.Produto = Prod;
    }   
    
    public produto getProduto() {
        return this.Produto;
    }

    public void setOrdemProducao(ordemproducao Ordem) {
        this.OrdemProducao = Ordem;
    }      

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
    
    public unidademedida getUnidadeMedida(){
        return this.UnidadeMedida;
    }
    
    public void setUnidadeMedida(unidademedida Unidade){
        this.UnidadeMedida = Unidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IdOrdemProduto != null ? IdOrdemProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ordemproduto)) {
            return false;
        }
        ordemproduto other = (ordemproduto) object;
        if ((this.IdOrdemProduto == null && other.IdOrdemProduto != null) || (this.IdOrdemProduto != null && !this.IdOrdemProduto.equals(other.IdOrdemProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.ordemproduto[ordemprodutoPK=" + IdOrdemProduto.toString() + "]";
    }
    
    public void LimparClasse() {
        setIdOrdemProduto(null);
        setOrdemProducao(null);
        setProduto(null);
        setQuantidade(null);
        setUnidadeMedida(null);        
    }

    public void LerClasse(Integer id) {
        LimparClasse(); 
        this.setIdOrdemProduto(id);
        DaoOrdemProduto daoOrdemProduto = new DaoOrdemProduto();
        try {
            this.CarregarClasse(daoOrdemProduto.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    public void CarregarClasse(Object object) throws Exception {
        setIdOrdemProduto(((ordemproduto)object).getIdOrdemProduto());
        setOrdemProducao(((ordemproduto)object).getOrdemProducao());
        setProduto(((ordemproduto)object).getProduto());
        setQuantidade(((ordemproduto)object).getQuantidade());
        setUnidadeMedida(((ordemproduto)object).getUnidadeMedida());
    }    
    
    public List RetornaTodos(String idOrdemProducao){
        DaoOrdemProduto daoOrdemProduto = new DaoOrdemProduto();
        return daoOrdemProduto.RetornarTodos(idOrdemProducao);
    }

}
