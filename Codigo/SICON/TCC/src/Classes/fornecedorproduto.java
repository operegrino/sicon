/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoFornecedorProduto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "fornecedorproduto")
@NamedQueries({@NamedQuery(name = "fornecedorproduto.findByIdfornecedorproduto", query = "SELECT f FROM fornecedorproduto f WHERE f.idfornecedorproduto = :idfornecedorproduto"), @NamedQuery(name = "fornecedorproduto.findByCodprodutofornecedor", query = "SELECT f FROM fornecedorproduto f WHERE f.codprodutofornecedor = :codprodutofornecedor"), @NamedQuery(name = "fornecedorproduto.findByTempoentrega", query = "SELECT f FROM fornecedorproduto f WHERE f.tempoentrega = :tempoentrega")})
public class fornecedorproduto implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idfornecedorproduto", nullable = false)
    private Integer idfornecedorproduto;
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idfornecedor", unique = true, referencedColumnName = "idfornecedor", nullable = false)
    private fornecedor Fornecedor;  
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idproduto", unique = true, referencedColumnName = "idproduto", nullable = false)
    private produto Produto;      
    @Column(name = "codprodutofornecedor")
    private String codprodutofornecedor;
    @Column(name = "tempoentrega")
    private Integer tempoentrega;
    @Column(name="preco")
    private BigDecimal preco;

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    @JoinColumn(name = "idtipofornecedor", referencedColumnName = "idtipofornecedor")
    @OneToOne(fetch=FetchType.EAGER)
    private tipofornecedor idtipofornecedor;

    public fornecedorproduto() {
    }

    public fornecedorproduto(Integer idfornecedorproduto) {
        this.idfornecedorproduto = idfornecedorproduto;
    }

    public Integer getIdfornecedorproduto() {
        return idfornecedorproduto;
    }

    public void setIdfornecedorproduto(Integer idfornecedorproduto) {
        this.idfornecedorproduto = idfornecedorproduto;
    }

    public String getCodprodutofornecedor() {
        return codprodutofornecedor;
    }

    public void setCodprodutofornecedor(String codprodutofornecedor) {
        this.codprodutofornecedor = codprodutofornecedor;
    }

    public Integer getTempoentrega() {
        return tempoentrega;
    }

    public void setTempoentrega(Integer tempoentrega) {
        this.tempoentrega = tempoentrega;
    }

    public tipofornecedor getIdtipofornecedor() {
        return idtipofornecedor;
    }

    public void setIdtipofornecedor(tipofornecedor idtipofornecedor) {
        this.idtipofornecedor = idtipofornecedor;
    }
    
    public produto getProduto(){
        return this.Produto;
    }
    
    public void setProduto(produto Prod) {
        this.Produto = Prod;
    }
    
    public fornecedor getFornecedor(){
        return this.Fornecedor;
    }
    
    public void setFornecedor(fornecedor Forn) {
        this.Fornecedor = Forn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfornecedorproduto != null ? idfornecedorproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof fornecedorproduto)) {
            return false;
        }
        fornecedorproduto other = (fornecedorproduto) object;
        if ((this.idfornecedorproduto == null && other.idfornecedorproduto != null) || (this.idfornecedorproduto != null && !this.idfornecedorproduto.equals(other.idfornecedorproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.fornecedorproduto[idfornecedorproduto=" + idfornecedorproduto + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoFornecedorProduto daoFornecedorProduto = new DaoFornecedorProduto();
        if (Operacao == 0) {
            return daoFornecedorProduto.Salvar(this);
        } else
            return daoFornecedorProduto.Alterar(this);
    }
    
    public boolean GravarTodos(ArrayList<fornecedorproduto> Lista, ArrayList ListaExcluir){
        DaoFornecedorProduto daoFornecedorProduto = new DaoFornecedorProduto();        
        return daoFornecedorProduto.SalvarTodos(Lista, ListaExcluir);
    }

    @Override
    public boolean Excluir() {
        DaoFornecedorProduto daoFornecedorProduto = new DaoFornecedorProduto();
        return daoFornecedorProduto.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoFornecedorProduto daoFornecedorProduto = new DaoFornecedorProduto();
        return daoFornecedorProduto.Pesquisar(ListaParametros);   
    }

    @Override
    public void LimparClasse() {
        this.idfornecedorproduto = null;
        this.Fornecedor = null;
        this.Produto = null;
        this.codprodutofornecedor = null;
        this.tempoentrega = null;
        this.idtipofornecedor = null;          
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdfornecedorproduto(Id);
        DaoFornecedorProduto daoFornecedorProduto = new DaoFornecedorProduto();
        try {
            this.CarregarClasse(daoFornecedorProduto.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.idfornecedorproduto = ((fornecedorproduto)object).getIdfornecedorproduto();
        this.Fornecedor = ((fornecedorproduto)object).getFornecedor();
        this.Produto = ((fornecedorproduto)object).getProduto();
        this.codprodutofornecedor = ((fornecedorproduto)object).getCodprodutofornecedor();
        this.tempoentrega = ((fornecedorproduto)object).getTempoentrega();
        this.idtipofornecedor = ((fornecedorproduto)object).getIdtipofornecedor();
    }

}
