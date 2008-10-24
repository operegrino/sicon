/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import Dao.Classes.DaoCargo;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "cargo")
@NamedQueries({@NamedQuery(name = "cargo.findByIdcargo", query = "SELECT c FROM cargo c WHERE c.idcargo = :idcargo"),
               @NamedQuery(name = "cargo.findByDescricao", query = "SELECT c.descricao FROM cargo c WHERE c.descricao like:descricao")})
public class cargo implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idcargo", nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idcargo;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    

    public cargo() {
    }

    public cargo(Integer idcargo) {
        this.idcargo = idcargo;
    }

    public cargo(Integer idcargo, String descricao) {
        this.idcargo = idcargo;
        this.descricao = descricao;
    }

    public Integer getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Integer idcargo) {
        this.idcargo = idcargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public boolean Gravar(int Operacao) {
        DaoCargo daoCargo = new DaoCargo();
        if (Operacao == 0) {
            return daoCargo.Salvar(this);
        } else
            return daoCargo.Alterar(this);
    }
    
    @Override
    public boolean Excluir() {        
        DaoCargo daoCargo = new DaoCargo();
        return daoCargo.Excluir(this);
    }
    
    @Override
    public ArrayList Pesquisar(ArrayList<String> ListaParametros) {
        DaoCargo daoCargo = new DaoCargo();
        return daoCargo.Pesquisar(ListaParametros);         
    }
    
    /* 
     * Objetivo     : Limpar os dados da classe
     * Data Criação : 08/07/08 
     */    
    @Override
    public void LimparClasse() {
        setIdcargo(null);
        setDescricao(null);
    }
    
    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdcargo(Id);
        DaoCargo daoCargo = new DaoCargo();
        try {
            this.CarregarClasse(daoCargo.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
        
    }
    
    @Override
    public void CarregarClasse(Object object) throws Exception{
        this.setIdcargo(((cargo)object).getIdcargo());
        this.setDescricao(((cargo)object).getDescricao());
    }

    /*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargo != null ? idcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadeCargo)) {
            return false;
        }
        EntidadeCargo other = (EntidadeCargo) object;
        if ((this.idcargo == null && other.idcargo != null) || (this.idcargo != null && !this.idcargo.equals(other.idcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tsgcargo[idcargo=" + idcargo + "]";
    }
    */
    
    
}
