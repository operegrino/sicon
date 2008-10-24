/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoFuncionalidade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "botao")
@NamedQueries({@NamedQuery(name = "botao.findByIdbotao", query = "SELECT b FROM botao b WHERE b.idbotao = :idbotao"), @NamedQuery(name = "botao.findByTitulobotao", query = "SELECT b FROM botao b WHERE b.titulobotao = :titulobotao"), @NamedQuery(name = "botao.findByNomebotao", query = "SELECT b FROM botao b WHERE b.nomebotao = :nomebotao")})
public class botao implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idbotao", nullable = false)
    private Integer idbotao;
    @Column(name = "titulobotao")
    private String titulobotao;
    @Column(name = "nomebotao", nullable = false)
    private String nomebotao;
    @Column(name = "descricaobotao", nullable = true)
    private String descricaobotao;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idbotao")
    private Collection<telabotao> telabotaoCollection;*/

    public botao() {
    }

    public botao(Integer idbotao) {
        this.idbotao = idbotao;
    }

    public botao(Integer idbotao, String nomebotao) {
        this.idbotao = idbotao;
        this.nomebotao = nomebotao;
    }

    public Integer getIdbotao() {
        return idbotao;
    }

    public void setIdbotao(Integer idbotao) {
        this.idbotao = idbotao;
    }

    public String getTitulobotao() {
        return titulobotao;
    }

    public void setTitulobotao(String titulobotao) {
        this.titulobotao = titulobotao;
    }

    public String getNomebotao() {
        return nomebotao;
    }

    public void setNomebotao(String nomebotao) {
        this.nomebotao = nomebotao;
    }

    /*public Collection<telabotao> getTelabotaoCollection() {
        return telabotaoCollection;
    }

    public void setTelabotaoCollection(Collection<telabotao> telabotaoCollection) {
        this.telabotaoCollection = telabotaoCollection;
    }*/
    
    public void setDescricaobotao(String descricaobotao) {
        this.descricaobotao = descricaobotao;
    }

    public String getDescricaobotao() {
        return this.descricaobotao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbotao != null ? idbotao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof botao)) {
            return false;
        }
        botao other = (botao) object;
        if ((this.idbotao == null && other.idbotao != null) || (this.idbotao != null && !this.idbotao.equals(other.idbotao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.botao[idbotao=" + idbotao + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoFuncionalidade daoFuncionalidade = new DaoFuncionalidade();
        if (Operacao == 0) {
            return daoFuncionalidade.Salvar(this);
        } else
            return daoFuncionalidade.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoFuncionalidade daoFuncionalidade = new DaoFuncionalidade();
        return daoFuncionalidade.Excluir(this);
    }

    @Override
    public ArrayList Pesquisar(ArrayList<String> ListaParametros) {
        DaoFuncionalidade daoFuncionalidade = new DaoFuncionalidade();
        return daoFuncionalidade.Pesquisar(ListaParametros); 
    }

    @Override
    public void LimparClasse() {
        this.setIdbotao(null);
        this.setTitulobotao(null);
        this.setNomebotao(null);
        this.setDescricaobotao(null);        
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse();  
        this.setIdbotao(Id);
        DaoFuncionalidade daoFuncionalidade = new DaoFuncionalidade();
        this.CarregarClasse(daoFuncionalidade.CarregarObjeto(this));

    }

    @Override
    public void CarregarClasse(Object object){     
        this.setIdbotao(((botao)object).getIdbotao());
        this.setTitulobotao(((botao)object).getTitulobotao());
        this.setNomebotao(((botao)object).getNomebotao());
        this.setDescricaobotao(((botao)object).getDescricaobotao());
    }

}
