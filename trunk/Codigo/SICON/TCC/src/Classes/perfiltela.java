/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

//import Telas.Formulario.telabotao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "perfiltela")
@NamedQueries({@NamedQuery(name = "perfiltela.findByIdperfiltela", query = "SELECT p FROM perfiltela p WHERE p.idperfiltela = :idperfiltela")})
public class perfiltela implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idperfiltela", nullable = false)
    private Integer idperfiltela;
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    @ManyToOne
    public perfil perfil;
    @JoinColumn(name = "idtela", referencedColumnName = "idtela")
    @ManyToOne
    public tela tela;
    @JoinColumn(name = "idbotao", referencedColumnName = "idbotao")
    @OneToOne
    public botao Botao;

    public perfiltela() {
    }

    public perfiltela(Integer idperfiltela) {
        this.idperfiltela = idperfiltela;
    }

    public Integer getIdperfiltela() {
        return idperfiltela;
    }

    public void setIdperfiltela(Integer idperfiltela) {
        this.idperfiltela = idperfiltela;
    }

    public perfil getIdperfil() {
        return perfil;
    }

    public void setIdperfil(perfil idperfil) {
        this.perfil = idperfil;
    }

    public tela getIdtela() {
        return tela;
    }

    public void setIdtela(tela idtela) {
        this.tela = idtela;
    }

    public botao getbotao() {
        return Botao;
    }

    public void setbotao(botao object) {
        this.Botao = object;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfiltela != null ? idperfiltela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof perfiltela)) {
            return false;
        }
        perfiltela other = (perfiltela) object;
        if ((this.idperfiltela == null && other.idperfiltela != null) || (this.idperfiltela != null && !this.idperfiltela.equals(other.idperfiltela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.perfiltela[idperfiltela=" + idperfiltela + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Excluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList Pesquisar(ArrayList<String> ListaParametros) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void LimparClasse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void LerClasse(int Id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void CarregarClasse(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
