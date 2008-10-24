/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoCargo;
import Dao.Classes.DaoFormaPagamento;
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
@Table(name = "formapagamento")
@NamedQueries({@NamedQuery(name = "formapagamento.findByIdformapagamento", query = "SELECT f FROM formapagamento f WHERE f.idformapagamento = :idformapagamento"), @NamedQuery(name = "formapagamento.findByNome", query = "SELECT f FROM formapagamento f WHERE f.nome = :nome"), @NamedQuery(name = "formapagamento.findByOperacaobancaria", query = "SELECT f FROM formapagamento f WHERE f.operacaobancaria = :operacaobancaria")})
public class formapagamento implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idformapagamento", nullable = false)
    private Integer idformapagamento;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "operacaobancaria", nullable = false)
    private boolean operacaobancaria;

    public formapagamento() {
    }

    public formapagamento(Integer idformapagamento) {
        this.idformapagamento = idformapagamento;
    }

    public formapagamento(Integer idformapagamento, String nome, boolean operacaobancaria) {
        this.idformapagamento = idformapagamento;
        this.nome = nome;
        this.operacaobancaria = operacaobancaria;
    }

    public Integer getIdformapagamento() {
        return idformapagamento;
    }

    public void setIdformapagamento(Integer idformapagamento) {
        this.idformapagamento = idformapagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getOperacaobancaria() {
        return operacaobancaria;
    }

    public void setOperacaobancaria(boolean operacaobancaria) {
        this.operacaobancaria = operacaobancaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformapagamento != null ? idformapagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof formapagamento)) {
            return false;
        }
        formapagamento other = (formapagamento) object;
        if ((this.idformapagamento == null && other.idformapagamento != null) || (this.idformapagamento != null && !this.idformapagamento.equals(other.idformapagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.formapagamento[idformapagamento=" + idformapagamento + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoFormaPagamento daoFormaPagamento = new DaoFormaPagamento();
        if (Operacao == 0) {
            return daoFormaPagamento.Salvar(this);
        } else
            return daoFormaPagamento.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoFormaPagamento daoFormaPagamento = new DaoFormaPagamento();
        return daoFormaPagamento.Excluir(this);        
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoFormaPagamento daoFormaPagamento = new DaoFormaPagamento();
        return daoFormaPagamento.Pesquisar(ListaParametros);  
    }

    @Override
    public void LimparClasse() {
        this.setIdformapagamento(null);
        this.setNome(null);
        this.setOperacaobancaria(false);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdformapagamento(Id);
        DaoFormaPagamento daoFormaPagamento = new DaoFormaPagamento();        
        try {
            this.CarregarClasse(daoFormaPagamento.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIdformapagamento(((formapagamento)object).getIdformapagamento());
        this.setNome(((formapagamento)object).getNome());
        this.setOperacaobancaria(((formapagamento)object).getOperacaobancaria());
    }

}
