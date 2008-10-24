/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoMotivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "motivo")
@NamedQueries({@NamedQuery(name = "motivo.findByIdmotivo", query = "SELECT m FROM motivo m WHERE m.idmotivo = :idmotivo"), @NamedQuery(name = "motivo.findByNome", query = "SELECT m FROM motivo m WHERE m.nome = :nome"), @NamedQuery(name = "motivo.findByBaixar", query = "SELECT m FROM motivo m WHERE m.baixar = :baixar")})
public class motivo implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idmotivo", nullable = false)
    private Integer idmotivo;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "baixar", nullable = false)
    private boolean baixar;

    public motivo() {
    }

    public motivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public motivo(Integer idmotivo, String nome, boolean baixar) {
        this.idmotivo = idmotivo;
        this.nome = nome;
        this.baixar = baixar;
    }

    public Integer getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getBaixar() {
        return baixar;
    }

    public void setBaixar(boolean baixar) {
        this.baixar = baixar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotivo != null ? idmotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof motivo)) {
            return false;
        }
        motivo other = (motivo) object;
        if ((this.idmotivo == null && other.idmotivo != null) || (this.idmotivo != null && !this.idmotivo.equals(other.idmotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.motivo[idmotivo=" + idmotivo + "]";
    }

     @Override
    public boolean Gravar(int Operacao) {
        DaoMotivo daoMotivo = new DaoMotivo();
        if (Operacao == 0) {
            return daoMotivo.Salvar(this);
        } else
            return daoMotivo.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoMotivo daoMotivo = new DaoMotivo();
        return daoMotivo.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoMotivo daoMotivo = new DaoMotivo();
        return daoMotivo.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdmotivo(null);
        setNome(null);
        setBaixar(false);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdmotivo(Id);
        DaoMotivo daoMotivo = new DaoMotivo();
        try {
            this.CarregarClasse(daoMotivo.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIdmotivo(((motivo)object).getIdmotivo());
        this.setNome(((motivo)object).getNome());
        this.setBaixar(((motivo)object).getBaixar());
    }

}
