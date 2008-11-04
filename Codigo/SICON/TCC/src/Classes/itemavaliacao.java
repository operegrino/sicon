/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoAvaliacaoPedido;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "itemavaliacao")
@NamedQueries({@NamedQuery(name = "itemavaliacao.findByIditemavaliacao", query = "SELECT i FROM itemavaliacao i WHERE i.iditemavaliacao = :iditemavaliacao"), @NamedQuery(name = "itemavaliacao.findByDataavaliacao", query = "SELECT i FROM itemavaliacao i WHERE i.dataavaliacao = :dataavaliacao")})
public class itemavaliacao implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "iditemavaliacao", nullable = false)
    private Integer iditemavaliacao;
    @Column(name = "dataavaliacao", nullable = false)
    //@Temporal(TemporalType.TIME)
    private Timestamp dataavaliacao;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "iditempedido", referencedColumnName = "iditempedido", nullable = true)
    private itempedido ItemPedido;
    @OneToOne(optional=true, fetch=FetchType.EAGER)
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo", nullable = true)
    private motivo Motivo;    
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idsituacaoitempedido", referencedColumnName = "idsituacaoitempedido", nullable = true)
    private situacaoitempedido SituacaoItem;
    @Column(name="adequado")
    private Boolean adequado;
    
    public itemavaliacao() {
        
    }    

    public itempedido getItemPedido() {
        return ItemPedido;
    }

    public void setItemPedido(itempedido ItemPedido) {
        this.ItemPedido = ItemPedido;
    }

    public Boolean getAdequado() {
        return adequado;
    }

    public void setAdequado(Boolean adequado) {
        this.adequado = adequado;
    }

    public situacaoitempedido getSituacaoItem() {
        return SituacaoItem;
    }

    public void setSituacaoItem(situacaoitempedido SituacaoItem) {
        this.SituacaoItem = SituacaoItem;
    }

    public itemavaliacao(Integer iditemavaliacao) {
        this.iditemavaliacao = iditemavaliacao;
    }

    public itemavaliacao(Integer iditemavaliacao, Timestamp dataavaliacao) {
        this.iditemavaliacao = iditemavaliacao;
        this.dataavaliacao = dataavaliacao;
    }

    public Integer getIditemavaliacao() {
        return iditemavaliacao;
    }

    public void setIditemavaliacao(Integer iditemavaliacao) {
        this.iditemavaliacao = iditemavaliacao;
    }

    public Date getDataavaliacao() {
        return dataavaliacao;
    }

    public void setDataavaliacao(Timestamp dataavaliacao) {
        this.dataavaliacao = dataavaliacao;
    }

    /*public itempedido getIditempedido() {
        return ItemPedido;
    }

    public void setIditempedido(itempedido iditempedido) {
        this.ItemPedido = iditempedido;
    }*/

    public motivo getMotivo() {
        return Motivo;
    }

    public void setMotivo(motivo Motivo) {
        this.Motivo = Motivo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditemavaliacao != null ? iditemavaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof itemavaliacao)) {
            return false;
        }
        itemavaliacao other = (itemavaliacao) object;
        if ((this.iditemavaliacao == null && other.iditemavaliacao != null) || (this.iditemavaliacao != null && !this.iditemavaliacao.equals(other.iditemavaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.itemavaliacao[iditemavaliacao=" + iditemavaliacao + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void GravarTodos(ArrayList lista, Boolean Reenviado) throws SQLException, Exception {
        DaoAvaliacaoPedido daoAvaliacao = new DaoAvaliacaoPedido();
        daoAvaliacao.Gravar(lista, Reenviado);
    }

    @Override
    public boolean Excluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
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
    public void CarregarClasse(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
