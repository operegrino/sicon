/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Controller.InterfaceControllerPadrao;
import Dao.Classes.DaoMovimento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@Table(name = "movimento")
@NamedQueries({@NamedQuery(name = "movimento.findByIdmovimento", query = "SELECT m FROM movimento m WHERE m.idmovimento = :idmovimento"), @NamedQuery(name = "movimento.findByQuantidade", query = "SELECT m FROM movimento m WHERE m.quantidade = :quantidade"), @NamedQuery(name = "movimento.findByMotivooperacao", query = "SELECT m FROM movimento m WHERE m.motivooperacao = :motivooperacao"), @NamedQuery(name = "movimento.findByDatamovimento", query = "SELECT m FROM movimento m WHERE m.datamovimento = :datamovimento")})
public class movimento implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idmovimento", nullable = false)
    private Integer idmovimento;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idproduto", unique = true, referencedColumnName = "idproduto", nullable = false)
    public produto Produto;    
    @Column(name = "quantidade", nullable = false)
    private BigDecimal quantidade;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idunidademedida", unique = true, referencedColumnName = "idunidademedida", nullable = false)
    public unidademedida UnidadeMedida;  
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idoperacao", unique = true, referencedColumnName = "idoperacao", nullable = false)
    public operacao Operacao;     
    @Column(name = "motivooperacao")
    private String motivooperacao;
    @Column(name = "datamovimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datamovimento;

    public movimento() {
    }

    public movimento(Integer idmovimento) {
        this.idmovimento = idmovimento;
    }

    public movimento(Integer idmovimento, BigDecimal quantidade, Date datamovimento) {
        this.idmovimento = idmovimento;
        this.quantidade = quantidade;
        this.datamovimento = datamovimento;
    }

    public Integer getIdmovimento() {
        return idmovimento;
    }

    public void setIdmovimento(Integer idmovimento) {
        this.idmovimento = idmovimento;
    }
    
    public produto getProduto() {
        return Produto;
    }

    public void setProduto(produto Prod) {
        this.Produto = Prod;
    }   
    
    
    public unidademedida getUnidadeMedida() {
        return UnidadeMedida;
    }

    public void setUnidadeMedida(unidademedida Unidade) {
        this.UnidadeMedida = Unidade;
    }        

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getMotivooperacao() {
        return motivooperacao;
    }

    public void setMotivooperacao(String motivooperacao) {
        this.motivooperacao = motivooperacao;
    }

    public Date getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(Date datamovimento) {
        this.datamovimento = datamovimento;
    }

    public operacao getOperacao() {
        return Operacao;
    }

    public void setOperacao(operacao idoperacao) {
        this.Operacao = idoperacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimento != null ? idmovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof movimento)) {
            return false;
        }
        movimento other = (movimento) object;
        if ((this.idmovimento == null && other.idmovimento != null) || (this.idmovimento != null && !this.idmovimento.equals(other.idmovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.movimento[idmovimento=" + idmovimento + "]";
    }
    
    @Override
    public boolean Gravar(int Operacao) {
        DaoMovimento daoMovimento = new DaoMovimento();
        if (Operacao == 0) {
            return daoMovimento.Salvar(this);
        } else
            return daoMovimento.Alterar(this, null);
    }
    
    public boolean Gravar(int Operacao, movimento movAntigo) {
        DaoMovimento daoMovimento = new DaoMovimento();
        if (Operacao == 0) {
            return daoMovimento.Salvar(this);
        } else
            return daoMovimento.Alterar(this, movAntigo);
    }    

    @Override
    public boolean Excluir() {
        DaoMovimento daoMovimento = new DaoMovimento();
        return daoMovimento.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoMovimento daoMovimento = new DaoMovimento();
        return daoMovimento.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdmovimento(null);
        setProduto(null);
        setQuantidade(null);
        setUnidadeMedida(null);
        setOperacao(null);
        setMotivooperacao(null);
        setDatamovimento(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdmovimento(Id);
        DaoMovimento daoMovimento = new DaoMovimento();
        try {
            this.CarregarClasse(daoMovimento.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIdmovimento(((movimento)object).getIdmovimento());
        this.setProduto(((movimento)object).getProduto());
        this.setQuantidade(((movimento)object).getQuantidade());
        this.setUnidadeMedida(((movimento)object).getUnidadeMedida());
        this.setOperacao(((movimento)object).getOperacao());
        this.setMotivooperacao(((movimento)object).getMotivooperacao());
        this.setDatamovimento(((movimento)object).getDatamovimento());
    }

 

}
