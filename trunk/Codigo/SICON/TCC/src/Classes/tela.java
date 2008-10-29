/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoTela;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "tela")
@NamedQueries({@NamedQuery(name = "tela.findByIdtela", query = "SELECT t FROM tela t WHERE t.idtela = :idtela"), @NamedQuery(name = "tela.findByTitulotela", query = "SELECT t FROM tela t WHERE t.titulotela = :titulotela"), @NamedQuery(name = "tela.findByNometela", query = "SELECT t FROM tela t WHERE t.nometela = :nometela"), @NamedQuery(name = "tela.findByTitulomenu", query = "SELECT t FROM tela t WHERE t.titulomenu = :titulomenu")})
public class tela implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idtela", nullable = false)
    private Integer idtela;
    @Column(name = "titulotela")
    private String titulotela;
    @Column(name = "nometela", nullable = false)
    private String nometela;
    @Column(name = "titulomenu")
    private String titulomenu;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(
                name="telabotao",
                joinColumns= @JoinColumn(name="idtela", referencedColumnName="idtela"),
                inverseJoinColumns= @JoinColumn(name="idbotao", referencedColumnName="idbotao")
                )
    private Collection<botao> botaoCollection;

    public tela() {
    }

    public tela(Integer idtela) {
        this.idtela = idtela;
    }

    public tela(Integer idtela, String nometela) {
        this.idtela = idtela;
        this.nometela = nometela;
    }

    public Integer getIdtela() {
        return idtela;
    }

    public void setIdtela(Integer idtela) {
        this.idtela = idtela;
    }

    public String getTitulotela() {
        return titulotela;
    }

    public void setTitulotela(String titulotela) {
        this.titulotela = titulotela;
    }

    public String getNometela() {
        return nometela;
    }

    public void setNometela(String nometela) {
        this.nometela = nometela;
    }

    public String getTitulomenu() {
        return titulomenu;
    }

    public void setTitulomenu(String titulomenu) {
        this.titulomenu = titulomenu;
    }

    public Collection<botao> getbotaoCollection() {
        return botaoCollection;
    }

    public void setbotaoCollection(Collection<botao> botaoCollection) {
        this.botaoCollection = botaoCollection;
    }

   /* public Collection<perfiltela> getPerfiltelaCollection() {
        return perfiltelaCollection;
    }

    public void setPerfiltelaCollection(Collection<perfiltela> perfiltelaCollection) {
        this.perfiltelaCollection = perfiltelaCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtela != null ? idtela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tela)) {
            return false;
        }
        tela other = (tela) object;
        if ((this.idtela == null && other.idtela != null) || (this.idtela != null && !this.idtela.equals(other.idtela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.tela[idtela=" + idtela + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoTela daoTela = new DaoTela();
        if (Operacao == 0) {
            return daoTela.Salvar(this);
        } else
            return daoTela.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoTela daoTela = new DaoTela();
        return daoTela.Excluir(this);
    }

    @Override
    public ArrayList Pesquisar(ArrayList<String> ListaParametros) {
        DaoTela daoTela = new DaoTela();
        return daoTela.PesquisarTeste(ListaParametros);
    }

    @Override
    public void LimparClasse() {
        this.setIdtela(null);
        this.setNometela(null);
        this.setTitulotela(null);
        this.setTitulomenu(null);
        this.setbotaoCollection(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse();
        this.setIdtela(Id);
        DaoTela daoTela = new DaoTela();
        //daoTela.CarregarObjetoTeste(this);
        this.CarregarClasse(daoTela.CarregarObjeto(this)); 
    }

    
    public void CarregarClasse(Object object) {
        this.setIdtela(((tela)object).getIdtela());         
        this.setNometela(((tela)object).getNometela());
        this.setTitulotela(((tela)object).getTitulotela());
        this.setTitulomenu(((tela)object).getTitulomenu());
        this.setbotaoCollection(((tela)object).getbotaoCollection());
    }

}
