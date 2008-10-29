/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoSituacaoOrdem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
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
 * @author jonathan
 */
@Entity
@Table(name = "situacaoordem")
@NamedQueries({@NamedQuery(name = "situacaoordem.findByIdsituacaoordem", query = "SELECT s FROM situacaoordem s WHERE s.idsituacaoordem = :idsituacaoordem"), @NamedQuery(name = "situacaoordem.findByDescricao", query = "SELECT s FROM situacaoordem s WHERE s.descricao = :descricao")})
public class situacaoordem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idsituacaoordem", nullable = false)
    private Integer idsituacaoordem;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public situacaoordem() {
    }

    public situacaoordem(Integer idsituacaoordem) {
        this.idsituacaoordem = idsituacaoordem;
    }

    public situacaoordem(Integer idsituacaoordem, String descricao) {
        this.idsituacaoordem = idsituacaoordem;
        this.descricao = descricao;
    }

    public Integer getIdsituacaoordem() {
        return idsituacaoordem;
    }

    public void setIdsituacaoordem(Integer idsituacaoordem) {
        this.idsituacaoordem = idsituacaoordem;
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
        hash += (idsituacaoordem != null ? idsituacaoordem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof situacaoordem)) {
            return false;
        }
        situacaoordem other = (situacaoordem) object;
        if ((this.idsituacaoordem == null && other.idsituacaoordem != null) || (this.idsituacaoordem != null && !this.idsituacaoordem.equals(other.idsituacaoordem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.situacaoordem[idsituacaoordem=" + idsituacaoordem + "]";
    }
    
    public Vector RetornaTodas(){
        DaoSituacaoOrdem daoSituacaoOrdem = new DaoSituacaoOrdem();  
        return daoSituacaoOrdem.Pesquisar(new ArrayList());
    }
    
    public void LimparClasse() {
        setIdsituacaoordem(null);
        setDescricao(null);        
    }

    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdsituacaoordem(Id);
        DaoSituacaoOrdem daoSituacaoOrdem = new DaoSituacaoOrdem();
        try {
            this.CarregarClasse(daoSituacaoOrdem.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    public void CarregarClasse(Object object) throws Exception {
        setIdsituacaoordem(((situacaoordem)object).getIdsituacaoordem());
        setDescricao(((situacaoordem)object).getDescricao());
    }    

}
