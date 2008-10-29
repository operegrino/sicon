/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoComposicaoCentesimal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
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
 * @author jonathan
 */
@Entity
@Table(name = "composicaocentesimal")
@NamedQueries({@NamedQuery(name = "composicaocentesimal.findByIdcomposicaocentesimal", query = "SELECT c FROM composicaocentesimal c WHERE c.idcomposicaocentesimal = :idcomposicaocentesimal"), @NamedQuery(name = "composicaocentesimal.findByEnergia", query = "SELECT c FROM composicaocentesimal c WHERE c.energia = :energia"), @NamedQuery(name = "composicaocentesimal.findByCarboidrato", query = "SELECT c FROM composicaocentesimal c WHERE c.carboidrato = :carboidrato"), @NamedQuery(name = "composicaocentesimal.findByProteina", query = "SELECT c FROM composicaocentesimal c WHERE c.proteina = :proteina"), @NamedQuery(name = "composicaocentesimal.findByLipideo", query = "SELECT c FROM composicaocentesimal c WHERE c.lipideo = :lipideo"), @NamedQuery(name = "composicaocentesimal.findByCalcio", query = "SELECT c FROM composicaocentesimal c WHERE c.calcio = :calcio"), @NamedQuery(name = "composicaocentesimal.findByFerro", query = "SELECT c FROM composicaocentesimal c WHERE c.ferro = :ferro"), @NamedQuery(name = "composicaocentesimal.findByVitaminac", query = "SELECT c FROM composicaocentesimal c WHERE c.vitaminac = :vitaminac")})
public class composicaocentesimal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idcomposicaocentesimal", nullable = true)
    private Integer idcomposicaocentesimal;
    @Column(name = "energia")
    private BigDecimal energia;
    @Column(name = "carboidrato")
    private BigDecimal carboidrato;
    @Column(name = "proteina")
    private BigDecimal proteina;
    @Column(name = "lipideo")
    private BigDecimal lipideo;
    @Column(name = "calcio")
    private BigDecimal calcio;
    @Column(name = "ferro")
    private BigDecimal ferro;
    @Column(name = "vitaminac")
    private BigDecimal vitaminac;
    /*@OneToMany(mappedBy = "idcomposicaocentesimal")
    private Collection<produto> produtoCollection;*/

    public composicaocentesimal() {
    }

    public composicaocentesimal(Integer idcomposicaocentesimal) {
        this.idcomposicaocentesimal = idcomposicaocentesimal;
    }

    public Integer getIdcomposicaocentesimal() {
        return idcomposicaocentesimal;
    }

    public void setIdcomposicaocentesimal(Integer idcomposicaocentesimal) {
        this.idcomposicaocentesimal = idcomposicaocentesimal;
    }

    public BigDecimal getEnergia() {
        return energia;
    }

    public void setEnergia(BigDecimal energia) {
        this.energia = energia;
    }

    public BigDecimal getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(BigDecimal carboidrato) {
        this.carboidrato = carboidrato;
    }

    public BigDecimal getProteina() {
        return proteina;
    }

    public void setProteina(BigDecimal proteina) {
        this.proteina = proteina;
    }

    public BigDecimal getLipideo() {
        return lipideo;
    }

    public void setLipideo(BigDecimal lipideo) {
        this.lipideo = lipideo;
    }

    public BigDecimal getCalcio() {
        return calcio;
    }

    public void setCalcio(BigDecimal calcio) {
        this.calcio = calcio;
    }

    public BigDecimal getFerro() {
        return ferro;
    }

    public void setFerro(BigDecimal ferro) {
        this.ferro = ferro;
    }

    public BigDecimal getVitaminac() {
        return vitaminac;
    }

    public void setVitaminac(BigDecimal vitaminac) {
        this.vitaminac = vitaminac;
    }

    /*public Collection<produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomposicaocentesimal != null ? idcomposicaocentesimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof composicaocentesimal)) {
            return false;
        }
        composicaocentesimal other = (composicaocentesimal) object;
        if ((this.idcomposicaocentesimal == null && other.idcomposicaocentesimal != null) || (this.idcomposicaocentesimal != null && !this.idcomposicaocentesimal.equals(other.idcomposicaocentesimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.composicaocentesimal[idcomposicaocentesimal=" + idcomposicaocentesimal + "]";
    }
    
    public void LimparClasse(){
        idcomposicaocentesimal = null;
        energia = null;
        carboidrato = null;
        proteina = null;
        lipideo = null;
        calcio = null;
        ferro = null;
        vitaminac = null;
    }
    
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdcomposicaocentesimal(Id);
        DaoComposicaoCentesimal daoComposicao = new DaoComposicaoCentesimal();
        try {
            this.CarregarClasse(daoComposicao.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }        
    }

    public void CarregarClasse(Object object) throws Exception {
        idcomposicaocentesimal = ((composicaocentesimal)object).getIdcomposicaocentesimal();
        energia = ((composicaocentesimal)object).getEnergia();
        carboidrato = ((composicaocentesimal)object).getCarboidrato();
        proteina = ((composicaocentesimal)object).getProteina();
        lipideo = ((composicaocentesimal)object).getLipideo();
        calcio = ((composicaocentesimal)object).getCalcio();
        ferro = ((composicaocentesimal)object).getFerro();
        vitaminac = ((composicaocentesimal)object).getVitaminac();
    }    
    
    public List Pesquisar(ArrayList<String> ListaParametro) {
        DaoComposicaoCentesimal DaoComposicao = new DaoComposicaoCentesimal();
        return DaoComposicao.Pesquisar(ListaParametro);
    }

}
