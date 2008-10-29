/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoProduto;
import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "produto")
@NamedQueries({@NamedQuery(name = "produto.findByIdproduto", query = "SELECT p FROM produto p WHERE p.idproduto = :idproduto"), @NamedQuery(name = "produto.findByCodigo", query = "SELECT p FROM produto p WHERE p.codigo = :codigo"), @NamedQuery(name = "produto.findByNome", query = "SELECT p FROM produto p WHERE p.nome = :nome"), @NamedQuery(name = "produto.findByValor", query = "SELECT p FROM produto p WHERE p.valor = :valor"), @NamedQuery(name = "produto.findByEstoqueminimo", query = "SELECT p FROM produto p WHERE p.estoqueminimo = :estoqueminimo"), @NamedQuery(name = "produto.findByQtdeembalagem", query = "SELECT p FROM produto p WHERE p.qtdeembalagem = :qtdeembalagem"), @NamedQuery(name = "produto.findByTemperaturaentrega", query = "SELECT p FROM produto p WHERE p.temperaturaentrega = :temperaturaentrega"), @NamedQuery(name = "produto.findByAlimentar", query = "SELECT p FROM produto p WHERE p.alimentar = :alimentar")})
public class produto implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idproduto", nullable = false)
    private Integer idproduto;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "estoqueminimo", nullable = false)
    private BigDecimal estoqueminimo;
    @Column(name = "qtdeembalagem")
    private BigDecimal qtdeembalagem;
    @Column(name = "temperaturaentrega", nullable = false)
    private BigDecimal temperaturaentrega;
    @Column(name = "alimentar", nullable = false)
    private boolean alimentar;
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "idcomposicaocentesimal", unique = true, referencedColumnName = "idcomposicaocentesimal", nullable = true)
    private composicaocentesimal idcomposicaocentesimal;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "unidadeembalagem", unique = true, referencedColumnName = "idunidademedida", nullable = true)
    private unidademedida unidadeembalagem;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "unidadeestoque", unique = true, referencedColumnName = "idunidademedida", nullable = false)
    private unidademedida unidadeestoque; 

    public produto() {
    }

    public produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public produto(Integer idproduto, String codigo, String nome, BigDecimal estoqueminimo, BigDecimal temperaturaentrega, boolean alimentar) {
        this.idproduto = idproduto;
        this.codigo = codigo;
        this.nome = nome;
        this.estoqueminimo = estoqueminimo;
        this.temperaturaentrega = temperaturaentrega;
        this.alimentar = alimentar;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getEstoqueminimo() {
        return estoqueminimo;
    }

    public void setEstoqueminimo(BigDecimal estoqueminimo) {
        this.estoqueminimo = estoqueminimo;
    }

    public BigDecimal getQtdeembalagem() {
        return qtdeembalagem;
    }

    public void setQtdeembalagem(BigDecimal qtdeembalagem) {
        this.qtdeembalagem = qtdeembalagem;
    }

    public BigDecimal getTemperaturaentrega() {
        return temperaturaentrega;
    }

    public void setTemperaturaentrega(BigDecimal temperaturaentrega) {
        this.temperaturaentrega = temperaturaentrega;
    }

    public boolean getAlimentar() {
        return alimentar;
    }

    public void setAlimentar(boolean alimentar) {
        this.alimentar = alimentar;
    }

    public composicaocentesimal getIdcomposicaocentesimal() {
        return idcomposicaocentesimal;
    }

    public void setIdcomposicaocentesimal(composicaocentesimal idcomposicaocentesimal) {
        this.idcomposicaocentesimal = idcomposicaocentesimal;
    }
    
    public unidademedida getUnidadeEmbalagem() {
        return unidadeembalagem;
    }

    public void setUnidadeEmbalagem(unidademedida Unidade) {
        this.unidadeembalagem = Unidade;
    }   
    
    public unidademedida getUnidadeEstoque() {
        return unidadeestoque;
    }

    public void setUnidadeEstoque(unidademedida Unidade) {
        this.unidadeestoque = Unidade;
    }        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof produto)) {
            return false;
        }
        produto other = (produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.produto[idproduto=" + idproduto + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoProduto daoProduto = new DaoProduto();
        if (Operacao == 0) {
            return daoProduto.Salvar(this);
        } else
            return daoProduto.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoProduto daoProduto = new DaoProduto();
        return daoProduto.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoProduto daoProduto = new DaoProduto();
        return daoProduto.Pesquisar(ListaParametros);    
    }

    @Override
    public void LimparClasse() {
        idproduto = null;
        codigo = null;
        nome = null;
        valor = null;
        estoqueminimo = null;
        qtdeembalagem = null;
        temperaturaentrega = null;
        alimentar = false;
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdproduto(Id);
        DaoProduto daoProduto = new DaoProduto();
        try {
            this.CarregarClasse(daoProduto.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }
    
    public void LerClasse(String Codigo) {
        LimparClasse(); 
        this.setCodigo(codigo);
        DaoProduto daoProduto = new DaoProduto();
        try {
            this.CarregarClasse(daoProduto.CarregarObjetoCodigo(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }        
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        idproduto = ((produto)object).getIdproduto();
        codigo = ((produto)object).getCodigo();
        nome = ((produto)object).getNome();
        valor = ((produto)object).getValor();
        estoqueminimo = ((produto)object).getEstoqueminimo();
        qtdeembalagem = ((produto)object).getQtdeembalagem();
        temperaturaentrega = ((produto)object).getTemperaturaentrega();
        alimentar = ((produto)object).getAlimentar();
        idcomposicaocentesimal = ((produto)object).getIdcomposicaocentesimal();
        unidadeembalagem = (((produto)object)).getUnidadeEmbalagem();
        unidadeestoque = (((produto)object)).getUnidadeEstoque();
    }
    
    public BigDecimal ConverterPesoEmGramas(){
        if (unidadeembalagem.getgrama()){
            return this.qtdeembalagem;
        } else if (unidadeembalagem.getQuilograma()) {
            return this.qtdeembalagem.multiply(new BigDecimal(1000));
        } else return new BigDecimal(0);
    }
   
    /**
     * @param Quantidade = quantos produtos para fazer o calculo do preço total
     * 
     * @return Valor total;
     */
    public BigDecimal RetornaTotalPreco(BigDecimal Quantidade){
        return Quantidade.multiply(this.getValor());
    }

}
