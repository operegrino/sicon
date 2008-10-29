/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoOrdemProducao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "ordemproducao")
@NamedQueries({@NamedQuery(name = "ordemproducao.findByIdordemproducao", query = "SELECT o FROM ordemproducao o WHERE o.idordemproducao = :idordemproducao"), @NamedQuery(name = "ordemproducao.findByDataordem", query = "SELECT o FROM ordemproducao o WHERE o.dataordem = :dataordem"), @NamedQuery(name = "ordemproducao.findBySetor", query = "SELECT o FROM ordemproducao o WHERE o.setor = :setor"), @NamedQuery(name = "ordemproducao.findByMotivo", query = "SELECT o FROM ordemproducao o WHERE o.motivo = :motivo")})
public class ordemproducao implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idordemproducao", nullable = false)
    private Integer idordemproducao;
    @Column(name = "dataordem", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataordem;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idrefeicao", unique = true, referencedColumnName = "idrefeicao", nullable = false)
    public refeicao Refeicao;    
    @Column(name = "setor", nullable = false)
    private String setor;
    @Column(name = "motivo", nullable = false)
    private String motivo;
    @OneToOne(optional=false, fetch=FetchType.EAGER)    
    @JoinColumn(name = "idorigemordem", referencedColumnName = "idorigemordem")
    private origemordem idorigemordem;
    @OneToOne(optional=false, fetch=FetchType.EAGER)    
    @JoinColumn(name = "idsituacaoordem", referencedColumnName = "idsituacaoordem")
    private situacaoordem idsituacaoordem;

    public ordemproducao() {
    }

    public ordemproducao(Integer idordemproducao) {
        this.idordemproducao = idordemproducao;
    }

    public ordemproducao(Integer idordemproducao, Date dataordem, String setor, String motivo) {
        this.idordemproducao = idordemproducao;
        this.dataordem = dataordem;
        this.setor = setor;
        this.motivo = motivo;
    }

    public Integer getIdordemproducao() {
        return idordemproducao;
    }

    public void setIdordemproducao(Integer idordemproducao) {
        this.idordemproducao = idordemproducao;
    }

    public Date getDataordem() {
        return dataordem;
    }

    public void setDataordem(Date dataordem) {
        this.dataordem = dataordem;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public origemordem getIdorigemordem() {
        return idorigemordem;
    }

    public void setIdorigemordem(origemordem idorigemordem) {
        this.idorigemordem = idorigemordem;
    }

    public situacaoordem getIdsituacaoordem() {
        return idsituacaoordem;
    }

    public void setIdsituacaoordem(situacaoordem idsituacaoordem) {
        this.idsituacaoordem = idsituacaoordem;
    }
    
    public refeicao getRefeicao(){
        return this.Refeicao;
    }
    
    public void setRefeicao(refeicao Ref){
        this.Refeicao = Ref;
    }
    
    @PostPersist
    public Integer RetornaId(){
        return this.idordemproducao;
    }
    
    public Integer RetornaProximoId(){
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        return daoOrdemProducao.RetornaProximoId();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordemproducao != null ? idordemproducao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ordemproducao)) {
            return false;
        }
        ordemproducao other = (ordemproducao) object;
        if ((this.idordemproducao == null && other.idordemproducao != null) || (this.idordemproducao != null && !this.idordemproducao.equals(other.idordemproducao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.ordemproducao[idordemproducao=" + idordemproducao + "]";
    }
    
    @Override
    public boolean Gravar(int Operacao) {
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        if (Operacao == 0) {
            return daoOrdemProducao.Salvar(this);
        } else
            return daoOrdemProducao.Alterar(this);
    }
    
    public boolean GravaOrdemEProduto(int Operacao, ArrayList<ordemproduto> ListaNovo, ArrayList<ordemproduto> ListaAlterar, ArrayList<ordemproduto> ListaExcluir){
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        if (Operacao == 0) {
            return daoOrdemProducao.SalvarOrdemEProduto(this, ListaNovo, ListaAlterar, ListaExcluir);
        } else
            return daoOrdemProducao.AlterarOrdemEProduto(this,  ListaNovo, ListaAlterar, ListaExcluir);        
    }

    @Override
    public boolean Excluir() {
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        return daoOrdemProducao.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        return daoOrdemProducao.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdordemproducao(null);
        setIdorigemordem(null);
        setIdsituacaoordem(null);
        setDataordem(null);
        setRefeicao(null);
        setSetor(null);
        setMotivo(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdordemproducao(Id);
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        try {
            this.CarregarClasse(daoOrdemProducao.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }
    
    public boolean BaixaOrdem() {
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        return daoOrdemProducao.BaixarOrdem(this);
    }
    
    public boolean CancelarOrdem(){
        DaoOrdemProducao daoOrdemProducao = new DaoOrdemProducao();
        return daoOrdemProducao.CancelarOrdem(this);
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        setIdordemproducao(((ordemproducao)object).getIdordemproducao());
        setIdorigemordem(((ordemproducao)object).getIdorigemordem());
        setIdsituacaoordem(((ordemproducao)object).getIdsituacaoordem());
        setDataordem(((ordemproducao)object).getDataordem());
        setRefeicao(((ordemproducao)object).getRefeicao());
        setSetor(((ordemproducao)object).getSetor());
        setMotivo(((ordemproducao)object).getMotivo());
    }
    
    
       

}
