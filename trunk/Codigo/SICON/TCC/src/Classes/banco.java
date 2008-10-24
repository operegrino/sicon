/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoBanco;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "banco")
@NamedQueries({@NamedQuery(name = "banco.findByIdbanco", query = "SELECT b FROM banco b WHERE b.idbanco = :idbanco"), @NamedQuery(name = "banco.findByNome", query = "SELECT b FROM banco b WHERE b.nome = :nome")})
public class banco implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idbanco", nullable = false)
    private Integer idbanco;
    @Column(name = "nome", nullable = false)
    private String nome;

    public banco() {
    }

    public banco(Integer idbanco) {
        this.idbanco = idbanco;
    }

    public banco(Integer idbanco, String nome) {
        this.idbanco = idbanco;
        this.nome = nome;
    }

    public Integer getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Integer idbanco) {
        this.idbanco = idbanco;
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
        hash += (idbanco != null ? idbanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof banco)) {
            return false;
        }
        banco other = (banco) object;
        if ((this.idbanco == null && other.idbanco != null) || (this.idbanco != null && !this.idbanco.equals(other.idbanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.banco[idbanco=" + idbanco + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoBanco daoBanco = new DaoBanco();
        if (Operacao == 0) {
            return daoBanco.Salvar(this);
        } else
            return daoBanco.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoBanco daoBanco = new DaoBanco();
        return daoBanco.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoBanco daoBanco = new DaoBanco();
        return daoBanco.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdbanco(null);
        setNome(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdbanco(Id);
        DaoBanco daoBanco = new DaoBanco();
        try {
            this.CarregarClasse(daoBanco.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIdbanco(((banco)object).getIdbanco());
        this.setNome(((banco)object).getNome());
    }

}
