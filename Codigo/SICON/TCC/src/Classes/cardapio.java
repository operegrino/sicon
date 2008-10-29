/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Controller.InterfaceControllerPadrao;
import Dao.Classes.DaoCardapio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "cardapio")
@NamedQueries({@NamedQuery(name = "cardapio.findByIdcardapio", query = "SELECT c FROM cardapio c WHERE c.idcardapio = :idcardapio"), @NamedQuery(name = "cardapio.findByData", query = "SELECT c FROM cardapio c WHERE c.datacardapio = :datacardapio"), @NamedQuery(name = "cardapio.findByQtderefeicoes", query = "SELECT c FROM cardapio c WHERE c.qtderefeicoes = :qtderefeicoes") /*@NamedQuery(name = "cardapio.findByIdrefeicao", query = "SELECT c FROM cardapio c WHERE c.refeicao = :refeicao")*/})
public class cardapio implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idcardapio", nullable = false)
    private Integer idcardapio;
    @Column(name = "datacardapio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datacardapio;
    @Column(name = "qtderefeicoes", nullable = false)
    private int qtderefeicoes;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idrefeicao", unique = true, referencedColumnName = "idrefeicao", nullable = false)
    private refeicao Refeicao;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(
                name="cardapioficha",
                joinColumns= @JoinColumn(name="idcardapio", referencedColumnName="idcardapio"),
                inverseJoinColumns= @JoinColumn(name="idfichatecnica", referencedColumnName="idfichatecnica")
                )
    private Collection<fichatecnica> ListaFichaTecnica;

    public cardapio() {
    }

    public cardapio(Integer idcardapio) {
        this.idcardapio = idcardapio;
    }

    public cardapio(Integer idcardapio, Date data, int qtderefeicoes, refeicao idrefeicao) {
        this.idcardapio = idcardapio;
        this.datacardapio = data;
        this.qtderefeicoes = qtderefeicoes;
        this.Refeicao = idrefeicao;
    }

    public Integer getIdcardapio() {
        return idcardapio;
    }

    public void setIdcardapio(Integer idcardapio) {
        this.idcardapio = idcardapio;
    }

    public Date getData() {
        return datacardapio;
    }

    public void setData(Date data) {
        this.datacardapio = data;
    }

    public int getQtderefeicoes() {
        return qtderefeicoes;
    }

    public void setQtderefeicoes(int qtderefeicoes) {
        this.qtderefeicoes = qtderefeicoes;
    }

    public refeicao getIdrefeicao() {
        return Refeicao;
    }

    public void setIdrefeicao(refeicao idrefeicao) {
        this.Refeicao = idrefeicao;
    }
    
    public Collection<fichatecnica> getListaFichaTecnica(){
        return ListaFichaTecnica;
    }
    
    public void setListaFichaTecnica(Collection<fichatecnica> Lista) {
        this.ListaFichaTecnica = Lista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcardapio != null ? idcardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof cardapio)) {
            return false;
        }
        cardapio other = (cardapio) object;
        if ((this.idcardapio == null && other.idcardapio != null) || (this.idcardapio != null && !this.idcardapio.equals(other.idcardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.cardapio[idcardapio=" + idcardapio + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoCardapio daoCardapio = new DaoCardapio();
        if (Operacao == 0) {
            return daoCardapio.Salvar(this);
        } else
            return daoCardapio.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoCardapio daoCardapio = new DaoCardapio();
        return daoCardapio.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoCardapio daoCardapio = new DaoCardapio();
        return daoCardapio.Pesquisar(ListaParametros);
    }

    @Override
    public void LimparClasse() {
        this.setIdcardapio(null);
        this.setData(null);
        this.setQtderefeicoes(0);
        this.setIdrefeicao(null);
        this.setListaFichaTecnica(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse();
        this.setIdcardapio(Id);
        DaoCardapio daoCardapio = new DaoCardapio();
        //daoTela.CarregarObjetoTeste(this);
        this.CarregarClasse(daoCardapio.CarregarObjeto(this)); 
    }

    
    public void CarregarClasse(Object object) {
        this.setIdcardapio(((cardapio)object).getIdcardapio());
        this.setData(((cardapio)object).getData());
        this.setQtderefeicoes(((cardapio)object).getQtderefeicoes());
        this.setIdrefeicao(((cardapio)object).getIdrefeicao());
        this.setListaFichaTecnica(((cardapio)object).getListaFichaTecnica());        
    }

}
