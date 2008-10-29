/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoContato;
import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "telefone")
@NamedQueries({@NamedQuery(name = "telefone.findByIdtelefone", query = "SELECT t FROM telefone t WHERE t.idtelefone = :idtelefone"), @NamedQuery(name = "telefone.findByDdd", query = "SELECT t FROM telefone t WHERE t.ddd = :ddd"), @NamedQuery(name = "telefone.findByTelefone", query = "SELECT t FROM telefone t WHERE t.telefone = :telefone")})
public class telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)    
    @Column(name = "idtelefone", nullable = false)
    private Integer idtelefone;
    @Column(name = "ddd", nullable = false)
    private String ddd;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @JoinColumn(name = "idtipotelefone", referencedColumnName = "idtipotelefone")
    @ManyToOne
    private tipotelefone idtipotelefone;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idfornecedor", unique = true, referencedColumnName = "idfornecedor", nullable = false)
    public fornecedor Fornecedor;     

    public telefone() {
    }

    public telefone(Integer idtelefone) {
        this.idtelefone = idtelefone;
    }

    public telefone(Integer idtelefone, String ddd, String telefone) {
        this.idtelefone = idtelefone;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public Integer getIdtelefone() {
        return idtelefone;
    }

    public void setIdtelefone(Integer idtelefone) {
        this.idtelefone = idtelefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public tipotelefone getIdtipotelefone() {
        return idtipotelefone;
    }

    public void setIdtipotelefone(tipotelefone idtipotelefone) {
        this.idtipotelefone = idtipotelefone;
    }
    
    public fornecedor getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(fornecedor For) {
        this.Fornecedor = For;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtelefone != null ? idtelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof telefone)) {
            return false;
        }
        telefone other = (telefone) object;
        if ((this.idtelefone == null && other.idtelefone != null) || (this.idtelefone != null && !this.idtelefone.equals(other.idtelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.telefone[idtelefone=" + idtelefone + "]";
    }

    public void LimparClasse(){
        this.setIdtelefone(null);
        this.setTelefone(null);
        this.setDdd(null);
        this.setIdtipotelefone(null);
    }
    
  public void CarregarClasse(Object object) throws Exception {
      this.setIdtelefone(((telefone)object).getIdtelefone());
      this.setDdd(((telefone)object).getDdd());
      this.setTelefone(((telefone)object).getTelefone());
      this.setIdtipotelefone(((telefone)object).getIdtipotelefone()); 
      this.setFornecedor(((telefone)object).getFornecedor());      
  }   
  
    public void LerClasseTelefone(int Id) {
        this.LimparClasse(); 
        this.setIdtelefone(Id);
        DaoContato daoContato = new DaoContato();
        try {
            this.CarregarClasse(daoContato.CarregarTelefone(this));
        } catch (Exception e) {
            this.LimparClasse();
        } 
    }  
  

}
