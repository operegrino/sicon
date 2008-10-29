/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoTipoFornecedor;
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
@Table(name = "tipofornecedor")
@NamedQueries({@NamedQuery(name = "tipofornecedor.findByIdtipofornecedor", query = "SELECT t FROM tipofornecedor t WHERE t.idtipofornecedor = :idtipofornecedor"), @NamedQuery(name = "tipofornecedor.findByDescricao", query = "SELECT t FROM tipofornecedor t WHERE t.descricao = :descricao")})
public class tipofornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idtipofornecedor", nullable = false)
    private Integer idtipofornecedor;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipofornecedor")
    private Collection<fornecedorproduto> fornecedorprodutoCollection;

    public tipofornecedor() {
    }

    public tipofornecedor(Integer idtipofornecedor) {
        this.idtipofornecedor = idtipofornecedor;
    }

    public tipofornecedor(Integer idtipofornecedor, String descricao) {
        this.idtipofornecedor = idtipofornecedor;
        this.descricao = descricao;
    }

    public Integer getIdtipofornecedor() {
        return idtipofornecedor;
    }

    public void setIdtipofornecedor(Integer idtipofornecedor) {
        this.idtipofornecedor = idtipofornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<fornecedorproduto> getFornecedorprodutoCollection() {
        return fornecedorprodutoCollection;
    }

    public void setFornecedorprodutoCollection(Collection<fornecedorproduto> fornecedorprodutoCollection) {
        this.fornecedorprodutoCollection = fornecedorprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipofornecedor != null ? idtipofornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tipofornecedor)) {
            return false;
        }
        tipofornecedor other = (tipofornecedor) object;
        if ((this.idtipofornecedor == null && other.idtipofornecedor != null) || (this.idtipofornecedor != null && !this.idtipofornecedor.equals(other.idtipofornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.tipofornecedor[idtipofornecedor=" + idtipofornecedor + "]";
    }
    
    public void LimparClasse(){
        idtipofornecedor = null;
        descricao = null;
    }
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdtipofornecedor(Id);
        DaoTipoFornecedor daoTipoFornecedor = new DaoTipoFornecedor();
        try {
            this.CarregarClasse(daoTipoFornecedor.CarregarTipoFornecedor(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    public void CarregarClasse(Object object) throws Exception {
        this.setIdtipofornecedor(((tipofornecedor)object).getIdtipofornecedor());
        this.setDescricao(((tipofornecedor)object).getDescricao());   
    }    

}
