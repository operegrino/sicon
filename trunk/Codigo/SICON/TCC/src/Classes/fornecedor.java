/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoFornecedor;
import java.io.Serializable;
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
@Table(name = "fornecedor")
@NamedQueries({@NamedQuery(name = "fornecedor.findByIdfornecedor", query = "SELECT f FROM fornecedor f WHERE f.idfornecedor = :idfornecedor"), @NamedQuery(name = "fornecedor.findByCodigo", query = "SELECT f FROM fornecedor f WHERE f.codigo = :codigo"), @NamedQuery(name = "fornecedor.findByRazaosocial", query = "SELECT f FROM fornecedor f WHERE f.razaosocial = :razaosocial"), @NamedQuery(name = "fornecedor.findByCnpj", query = "SELECT f FROM fornecedor f WHERE f.cnpj = :cnpj"), @NamedQuery(name = "fornecedor.findByInscricaoestadual", query = "SELECT f FROM fornecedor f WHERE f.inscricaoestadual = :inscricaoestadual"), @NamedQuery(name = "fornecedor.findByCcm", query = "SELECT f FROM fornecedor f WHERE f.ccm = :ccm"), @NamedQuery(name = "fornecedor.findByCgc", query = "SELECT f FROM fornecedor f WHERE f.cgc = :cgc"), @NamedQuery(name = "fornecedor.findByRua", query = "SELECT f FROM fornecedor f WHERE f.rua = :rua"), @NamedQuery(name = "fornecedor.findByNumero", query = "SELECT f FROM fornecedor f WHERE f.numero = :numero"), @NamedQuery(name = "fornecedor.findByBairro", query = "SELECT f FROM fornecedor f WHERE f.bairro = :bairro"), @NamedQuery(name = "fornecedor.findByCidade", query = "SELECT f FROM fornecedor f WHERE f.cidade = :cidade"), @NamedQuery(name = "fornecedor.findByCep", query = "SELECT f FROM fornecedor f WHERE f.cep = :cep"), @NamedQuery(name = "fornecedor.findBySite", query = "SELECT f FROM fornecedor f WHERE f.site = :site"), @NamedQuery(name = "fornecedor.findByTempoentrega", query = "SELECT f FROM fornecedor f WHERE f.tempoentrega = :tempoentrega")})
public class fornecedor implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idfornecedor", nullable = false)
    private Integer idfornecedor;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "razaosocial", nullable = false)
    private String razaosocial;
    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "inscricaoestadual")
    private String inscricaoestadual;
    @Column(name = "ccm")
    private String ccm;
    @Column(name = "cgc")
    private String cgc;
    @Column(name = "rua", nullable = false)
    private String rua;
    @Column(name = "numero")
    private String numero;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cep")
    private String cep;
    @Column(name = "site")
    private String site;
    @Column(name = "tempoentrega", nullable = false)
    private int tempoentrega;
    @OneToOne(optional=true, fetch=FetchType.EAGER)
    @JoinColumn(name = "iddadosbancarios", unique = true, referencedColumnName = "iddadosbancarios", nullable = true)    
    private dadosbancarios dadosbancarios;

    public fornecedor() {
    }

    public fornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public fornecedor(Integer idfornecedor, String codigo, String razaosocial, String cnpj, String rua, int tempoentrega) {
        this.idfornecedor = idfornecedor;
        this.codigo = codigo;
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
        this.rua = rua;
        this.tempoentrega = tempoentrega;
    }

    public Integer getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getCcm() {
        return ccm;
    }

    public void setCcm(String ccm) {
        this.ccm = ccm;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getTempoentrega() {
        return tempoentrega;
    }

    public void setTempoentrega(int tempoentrega) {
        this.tempoentrega = tempoentrega;
    }

    public dadosbancarios getdadosbancarios() {
        return dadosbancarios;
    }

    public void setdadosbancarios(dadosbancarios iddadosbancarios) {
        this.dadosbancarios = iddadosbancarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfornecedor != null ? idfornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof fornecedor)) {
            return false;
        }
        fornecedor other = (fornecedor) object;
        if ((this.idfornecedor == null && other.idfornecedor != null) || (this.idfornecedor != null && !this.idfornecedor.equals(other.idfornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.fornecedor[idfornecedor=" + idfornecedor + "]";
    }

   @Override
    public boolean Gravar(int Operacao) {
        DaoFornecedor daoFornecedor = new DaoFornecedor();
        if (Operacao == 0) {
            return daoFornecedor.Salvar(this);
        } else
            return daoFornecedor.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoFornecedor daoFornecedor = new DaoFornecedor();
        return daoFornecedor.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoFornecedor daoFornecedor = new DaoFornecedor();
        return daoFornecedor.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdfornecedor(null);
        setCodigo(null);
        setRazaosocial(null);
        setCnpj(null);
        setInscricaoestadual(null);
        setCcm(null);
        setCgc(null);
        setRua(null);
        setNumero(null);        
        setBairro(null);
        setCidade(null);
        setCep(null);
        setSite(null);
        setTempoentrega(0);
        setdadosbancarios(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdfornecedor(Id);
        DaoFornecedor daoFornecedor = new DaoFornecedor();
        try {
            this.CarregarClasse(daoFornecedor.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        setIdfornecedor(((fornecedor)object).getIdfornecedor());
        setCodigo(((fornecedor)object).getCodigo());
        setRazaosocial(((fornecedor)object).getRazaosocial());
        setCnpj(((fornecedor)object).getCnpj());
        setInscricaoestadual(((fornecedor)object).getInscricaoestadual());
        setCcm(((fornecedor)object).getCcm());
        setCgc(((fornecedor)object).getCgc());
        setRua(((fornecedor)object).getRua());
        setNumero(((fornecedor)object).getNumero());        
        setBairro(((fornecedor)object).getBairro());
        setCidade(((fornecedor)object).getCidade());
        setCep(((fornecedor)object).getCep());
        setSite(((fornecedor)object).getSite());
        setTempoentrega(((fornecedor)object).getTempoentrega());
        setdadosbancarios(((fornecedor)object).getdadosbancarios());
    }

}
