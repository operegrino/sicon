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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "email")
@NamedQueries({@NamedQuery(name = "email.findByIdemail", query = "SELECT e FROM email e WHERE e.idemail = :idemail"), @NamedQuery(name = "email.findByEmail", query = "SELECT e FROM email e WHERE e.email = :email")})
public class email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idemail", nullable = false)
    private Integer idemail;
    @Column(name = "email", nullable = false)
    private String email;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idfornecedor", unique = true, referencedColumnName = "idfornecedor", nullable = false)
    public fornecedor Fornecedor;    

    public email() {
    }

    public email(Integer idemail) {
        this.idemail = idemail;
    }

    public email(Integer idemail, String email) {
        this.idemail = idemail;
        this.email = email;
    }

    public Integer getIdemail() {
        return idemail;
    }

    public void setIdemail(Integer idemail) {
        this.idemail = idemail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public fornecedor getFornecedor(){
        return this.Fornecedor;
    }
    
    public void setFornecedor(fornecedor Forne) {
        this.Fornecedor = Forne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemail != null ? idemail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof email)) {
            return false;
        }
        email other = (email) object;
        if ((this.idemail == null && other.idemail != null) || (this.idemail != null && !this.idemail.equals(other.idemail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.email[idemail=" + idemail + "]";
    }
    
    public void LimparClasse(){
        this.setIdemail(null);
        this.setFornecedor(null);
        this.setEmail(null);
    }
    
  public void CarregarClasse(Object object) throws Exception {
      this.setIdemail(((email)object).getIdemail());
      this.setEmail(((email)object).getEmail());
      this.setFornecedor(((email)object).getFornecedor());  
  }      
  
    public void LerClasseEmail(int Id) {
        this.LimparClasse(); 
        this.setIdemail(Id);
        DaoContato daoContato = new DaoContato();
        try {
            this.CarregarClasse(daoContato.CarregarEmail(this));
        } catch (Exception ex) {
            this.LimparClasse();
        } 
    }     
 



}
