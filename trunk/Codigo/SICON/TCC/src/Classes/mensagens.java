/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "mensagens")
@NamedQueries({@NamedQuery(name = "mensagens.findByIdmensagem", query = "SELECT m FROM mensagens m WHERE m.idmensagem = :idmensagem"), @NamedQuery(name = "mensagens.findByMensagem", query = "SELECT m FROM mensagens m WHERE m.mensagem = :mensagem")})
public class mensagens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idmensagem", nullable = false)
    private Integer idmensagem;
    @Column(name = "mensagem", nullable = false)
    private String mensagem;

    public mensagens() {
    }

    public mensagens(Integer idmensagem) {
        this.idmensagem = idmensagem;
    }

    public mensagens(Integer idmensagem, String mensagem) {
        this.idmensagem = idmensagem;
        this.mensagem = mensagem;
    }

    public Integer getIdmensagem() {
        return idmensagem;
    }

    public void setIdmensagem(Integer idmensagem) {
        this.idmensagem = idmensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String RetornaMensagem(int idMensagem) {
        LerClasse(idMensagem);
        return getMensagem();
    }
    
    public boolean LerClasse(int idMensagem){
        LimparClasse();       
        DaoMensagens daoMensagens = new DaoMensagens();
        return this.CarregarClasse(daoMensagens.CarregarObjeto(idMensagem));         
    }    
    
    private boolean CarregarClasse(ArrayList<mensagens> Objeto)  {
        if (!(Objeto.isEmpty())) {
            this.setIdmensagem(((mensagens)Objeto.get(0)).getIdmensagem()); 
            this.setMensagem(((mensagens)Objeto.get(0)).getMensagem());
            return true;
        } else
            return false;
    }

    private void LimparClasse() {
        setIdmensagem(null);
        setMensagem(null);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensagem != null ? idmensagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof mensagens)) {
            return false;
        }
        mensagens other = (mensagens) object;
        if ((this.idmensagem == null && other.idmensagem != null) || (this.idmensagem != null && !this.idmensagem.equals(other.idmensagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.mensagens[idmensagem=" + idmensagem + "]";
    }

}
