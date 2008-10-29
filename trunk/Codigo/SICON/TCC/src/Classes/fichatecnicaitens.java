/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoFichaTecnicaItens;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "fichatecnicaitens")
@NamedQueries({@NamedQuery(name = "fichatecnicaitens.findByIdfichatecnica", query = "SELECT f FROM fichatecnicaitens f WHERE f.fichatecnicaitensPK.idfichatecnica = :idfichatecnica"), @NamedQuery(name = "fichatecnicaitens.findByIdproduto", query = "SELECT f FROM fichatecnicaitens f WHERE f.fichatecnicaitensPK.idproduto = :idproduto"), @NamedQuery(name = "fichatecnicaitens.findByPesobruto", query = "SELECT f FROM fichatecnicaitens f WHERE f.pesobruto = :pesobruto"), @NamedQuery(name = "fichatecnicaitens.findByPesoliquido", query = "SELECT f FROM fichatecnicaitens f WHERE f.pesoliquido = :pesoliquido"), @NamedQuery(name = "fichatecnicaitens.findByFatorcorrecao", query = "SELECT f FROM fichatecnicaitens f WHERE f.fatorcorrecao = :fatorcorrecao")})
public class fichatecnicaitens implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected fichatecnicaitensPK fichatecnicaitensPK;
    @Column(name = "pesobruto")
    private BigDecimal pesobruto;
    @Column(name = "pesoliquido")
    private BigDecimal pesoliquido;
    @Column(name = "fatorcorrecao")
    private Integer fatorcorrecao;

    public fichatecnicaitens() {
    }

    public fichatecnicaitens(fichatecnicaitensPK fichatecnicaitensPK) {
        this.fichatecnicaitensPK = fichatecnicaitensPK;
    }

    public fichatecnicaitens(int idfichatecnica, int idproduto) {
        this.fichatecnicaitensPK = new fichatecnicaitensPK(idfichatecnica, idproduto);
    }

    public fichatecnicaitensPK getFichatecnicaitensPK() {
        return fichatecnicaitensPK;
    }

    public void setFichatecnicaitensPK(fichatecnicaitensPK fichatecnicaitensPK) {
        this.fichatecnicaitensPK = fichatecnicaitensPK;
    }

    public BigDecimal getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(BigDecimal pesobruto) {
        this.pesobruto = pesobruto;
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public Integer getFatorcorrecao() {
        return fatorcorrecao;
    }

    public void setFatorcorrecao(Integer fatorcorrecao) {
        this.fatorcorrecao = fatorcorrecao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichatecnicaitensPK != null ? fichatecnicaitensPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof fichatecnicaitens)) {
            return false;
        }
        fichatecnicaitens other = (fichatecnicaitens) object;
        if ((this.fichatecnicaitensPK == null && other.fichatecnicaitensPK != null) || (this.fichatecnicaitensPK != null && !this.fichatecnicaitensPK.equals(other.fichatecnicaitensPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.fichatecnicaitens[fichatecnicaitensPK=" + fichatecnicaitensPK + "]";
    }
    
    public void LimparClasse(){
        setFichatecnicaitensPK(null);
        setPesobruto(null);
        setPesoliquido(null);
        setFatorcorrecao(null);
    }
    
    public void LerClasse(int IdFicha, int IdProduto) {
       // LimparClasse(); 
        this.setFichatecnicaitensPK(new fichatecnicaitensPK(IdFicha, IdProduto));
        DaoFichaTecnicaItens daoFichaTecnica = new DaoFichaTecnicaItens();
        try {
            this.CarregarClasse(daoFichaTecnica.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }    
    }
    
    public List Pesquisar(ArrayList<String> ListaParametros){
        DaoFichaTecnicaItens daoFichaTecnica = new DaoFichaTecnicaItens();
        return daoFichaTecnica.Pesquisar(ListaParametros);
    }
    public void CarregarClasse(Object object) throws Exception {
        setPesobruto(((fichatecnicaitens)object).getPesobruto());
        setPesoliquido(((fichatecnicaitens)object).getPesoliquido());
        setFatorcorrecao(((fichatecnicaitens)object).getFatorcorrecao());
    }    
}
