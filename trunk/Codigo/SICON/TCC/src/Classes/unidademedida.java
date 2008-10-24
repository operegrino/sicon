/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoUnidadeMedida;
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
@Table(name = "unidademedida")
@NamedQueries({@NamedQuery(name = "unidademedida.findByIdunidademedida", query = "SELECT u FROM unidademedida u WHERE u.idunidademedida = :idunidademedida"), @NamedQuery(name = "unidademedida.findByNome", query = "SELECT u FROM unidademedida u WHERE u.nome = :nome")})
public class unidademedida implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)    
    @Column(name = "idunidademedida", nullable = false)
    private Integer idunidademedida;
    @Column(name = "nome", nullable = false)
    private String nome;

    public unidademedida() {
    }

    public unidademedida(Integer idunidademedida) {
        this.idunidademedida = idunidademedida;
    }

    public unidademedida(Integer idunidademedida, String nome) {
        this.idunidademedida = idunidademedida;
        this.nome = nome;
    }

    public Integer getIdunidademedida() {
        return idunidademedida;
    }

    public void setIdunidademedida(Integer idunidademedida) {
        this.idunidademedida = idunidademedida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidademedida != null ? idunidademedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof unidademedida)) {
            return false;
        }
        unidademedida other = (unidademedida) object;
        if ((this.idunidademedida == null && other.idunidademedida != null) || (this.idunidademedida != null && !this.idunidademedida.equals(other.idunidademedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.unidademedida[idunidademedida=" + idunidademedida + "]";
    }

     @Override
    public boolean Gravar(int Operacao) {
        DaoUnidadeMedida daoUnidadeMedida = new DaoUnidadeMedida();
        if (Operacao == 0) {
            return daoUnidadeMedida.Salvar(this);
        } else
            return daoUnidadeMedida.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoUnidadeMedida daoUnidadeMedida = new DaoUnidadeMedida();
        return daoUnidadeMedida.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoUnidadeMedida daoUnidadeMedida = new DaoUnidadeMedida();
        return daoUnidadeMedida.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdunidademedida(null);
        setNome(null);        
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdunidademedida(Id);
        DaoUnidadeMedida daoUnidadeMedida = new DaoUnidadeMedida();
        try {
            this.CarregarClasse(daoUnidadeMedida.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIdunidademedida(((unidademedida)object).getIdunidademedida());
        this.setNome(((unidademedida)object).getNome());        
    }

}
