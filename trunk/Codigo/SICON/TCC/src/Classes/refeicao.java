/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoRefeicao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "refeicao")
@NamedQueries({@NamedQuery(name = "refeicao.findByIdrefeicao", query = "SELECT r FROM refeicao r WHERE r.idrefeicao = :idrefeicao"), @NamedQuery(name = "refeicao.findByDescricao", query = "SELECT r FROM refeicao r WHERE r.descricao = :descricao")})
public class refeicao implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idrefeicao", nullable = false)
    private Integer idrefeicao;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public refeicao() {
    }

    public refeicao(Integer idrefeicao) {
        this.idrefeicao = idrefeicao;
    }

    public refeicao(Integer idrefeicao, String descricao) {
        this.idrefeicao = idrefeicao;
        this.descricao = descricao;
    }

    public Integer getIdrefeicao() {
        return idrefeicao;
    }

    public void setIdrefeicao(Integer idrefeicao) {
        this.idrefeicao = idrefeicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrefeicao != null ? idrefeicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof refeicao)) {
            return false;
        }
        refeicao other = (refeicao) object;
        if ((this.idrefeicao == null && other.idrefeicao != null) || (this.idrefeicao != null && !this.idrefeicao.equals(other.idrefeicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.refeicao[idrefeicao=" + idrefeicao + "]";
    }
    
    @Override
    public boolean Gravar(int Operacao) {
        DaoRefeicao daoRefeicao = new DaoRefeicao();
        if (Operacao == 0) {
            return daoRefeicao.Salvar(this);
        } else
            return daoRefeicao.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoRefeicao daoRefeicao = new DaoRefeicao();
        return daoRefeicao.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoRefeicao daoRefeicao = new DaoRefeicao();
        return daoRefeicao.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdrefeicao(null);
        setDescricao(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdrefeicao(Id);
        DaoRefeicao daoRefeicao = new DaoRefeicao();
        try {
            this.CarregarClasse(daoRefeicao.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIdrefeicao(((refeicao)object).getIdrefeicao());
        this.setDescricao(((refeicao)object).getDescricao());
    }    

}
