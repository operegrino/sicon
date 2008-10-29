/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoOperacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
@Table(name = "operacao")
@NamedQueries({@NamedQuery(name = "operacao.findByIdoperacao", query = "SELECT o FROM operacao o WHERE o.idoperacao = :idoperacao"), @NamedQuery(name = "operacao.findByDescricao", query = "SELECT o FROM operacao o WHERE o.descricao = :descricao") /*@NamedQuery(name = "operacao.findByVlFator", query = "SELECT o FROM operacao o WHERE o.vlfator = :vlfator")*/})
public class operacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idoperacao", nullable = false)
    private Integer idoperacao;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "vlfator", nullable = false)
    private int vlfator;

    public operacao() {
    }

    public operacao(Integer idoperacao) {
        this.idoperacao = idoperacao;
    }

    public operacao(Integer idoperacao, String descricao, int vlFator) {
        this.idoperacao = idoperacao;
        this.descricao = descricao;
        this.vlfator = vlFator;
    }

    public Integer getIdoperacao() {
        return idoperacao;
    }

    public void setIdoperacao(Integer idoperacao) {
        this.idoperacao = idoperacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVlFator() {
        return vlfator;
    }

    public void setVlFator(int vlFator) {
        this.vlfator = vlFator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoperacao != null ? idoperacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof operacao)) {
            return false;
        }
        operacao other = (operacao) object;
        if ((this.idoperacao == null && other.idoperacao != null) || (this.idoperacao != null && !this.idoperacao.equals(other.idoperacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.operacao[idoperacao=" + idoperacao + "]";
    }
    
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoOperacao daoOperacao = new DaoOperacao();
        return daoOperacao.Pesquisar(ListaParametros);     
    }

    public void LimparClasse() {
        setIdoperacao(null);
        setDescricao(null);
        setVlFator(0);        
    }

    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdoperacao(Id);
        DaoOperacao daoOperacao = new DaoOperacao();
        try {
            this.CarregarClasse(daoOperacao.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    public void CarregarClasse(Object object) throws Exception {
        this.setIdoperacao(((operacao)object).getIdoperacao());
        this.setDescricao(((operacao)object).getDescricao());
        this.setVlFator(((operacao)object).getVlFator());    
    }    

}
