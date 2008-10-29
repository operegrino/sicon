/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoFichaTecnica;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "fichatecnica")
@NamedQueries({@NamedQuery(name = "fichatecnica.findByIdfichatecnica", query = "SELECT f FROM fichatecnica f WHERE f.idfichatecnica = :idfichatecnica"), @NamedQuery(name = "fichatecnica.findByNomepreparacao", query = "SELECT f FROM fichatecnica f WHERE f.nomepreparacao = :nomepreparacao"), @NamedQuery(name = "fichatecnica.findByModopreparo", query = "SELECT f FROM fichatecnica f WHERE f.modopreparo = :modopreparo"), @NamedQuery(name = "fichatecnica.findByRendimento", query = "SELECT f FROM fichatecnica f WHERE f.rendimento = :rendimento"), @NamedQuery(name = "fichatecnica.findByEnergia", query = "SELECT f FROM fichatecnica f WHERE f.energia = :energia"), @NamedQuery(name = "fichatecnica.findByCarboidrato", query = "SELECT f FROM fichatecnica f WHERE f.carboidrato = :carboidrato"), @NamedQuery(name = "fichatecnica.findByProteina", query = "SELECT f FROM fichatecnica f WHERE f.proteina = :proteina"), @NamedQuery(name = "fichatecnica.findByLipideo", query = "SELECT f FROM fichatecnica f WHERE f.lipideo = :lipideo"), @NamedQuery(name = "fichatecnica.findByCalcio", query = "SELECT f FROM fichatecnica f WHERE f.calcio = :calcio"), @NamedQuery(name = "fichatecnica.findByFerro", query = "SELECT f FROM fichatecnica f WHERE f.ferro = :ferro"), @NamedQuery(name = "fichatecnica.findByVitaminac", query = "SELECT f FROM fichatecnica f WHERE f.vitaminac = :vitaminac"), @NamedQuery(name = "fichatecnica.findByPesocru", query = "SELECT f FROM fichatecnica f WHERE f.pesocru = :pesocru"), @NamedQuery(name = "fichatecnica.findByPesoliquido", query = "SELECT f FROM fichatecnica f WHERE f.pesoliquido = :pesoliquido")})
public class fichatecnica implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idfichatecnica", nullable = false)
    private Integer idfichatecnica;
    @Column(name = "nomepreparacao", nullable = false)
    private String nomepreparacao;
    @Column(name = "modopreparo")
    private String modopreparo;
    @Column(name = "rendimento", nullable = false)
    private BigDecimal rendimento;
    @Column(name = "energia")
    private BigDecimal energia;
    @Column(name = "carboidrato")
    private BigDecimal carboidrato;
    @Column(name = "proteina")
    private BigDecimal proteina;
    @Column(name = "lipideo")
    private BigDecimal lipideo;
    @Column(name = "calcio")
    private BigDecimal calcio;
    @Column(name = "ferro")
    private BigDecimal ferro;
    @Column(name = "vitaminac")
    private BigDecimal vitaminac;
    @Column(name = "pesocru")
    private BigDecimal pesocru;
    @Column(name = "pesoliquido")
    private BigDecimal pesoliquido;
    @Column(name = "precototal")
    private BigDecimal precototal;
    
    public fichatecnica() {
    }

    public fichatecnica(Integer idfichatecnica) {
        this.idfichatecnica = idfichatecnica;
    }

    public fichatecnica(Integer idfichatecnica, String nomepreparacao, BigDecimal rendimento) {
        this.idfichatecnica = idfichatecnica;
        this.nomepreparacao = nomepreparacao;
        this.rendimento = rendimento;
    }

    public Integer getIdfichatecnica() {
        return idfichatecnica;
    }
    
    @PostPersist
    public Integer RetornaIdFichaTecnica(){
        return idfichatecnica;
    }

    public void setIdfichatecnica(Integer idfichatecnica) {
        this.idfichatecnica = idfichatecnica;
    }

    public String getNomepreparacao() {
        return nomepreparacao;
    }

    public void setNomepreparacao(String nomepreparacao) {
        this.nomepreparacao = nomepreparacao;
    }

    public String getModopreparo() {
        return modopreparo;
    }

    public void setModopreparo(String modopreparo) {
        this.modopreparo = modopreparo;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public BigDecimal getEnergia() {
        return energia;
    }

    public void setEnergia(BigDecimal energia) {
        this.energia = energia;
    }

    public BigDecimal getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(BigDecimal carboidrato) {
        this.carboidrato = carboidrato;
    }

    public BigDecimal getProteina() {
        return proteina;
    }

    public void setProteina(BigDecimal proteina) {
        this.proteina = proteina;
    }

    public BigDecimal getLipideo() {
        return lipideo;
    }

    public void setLipideo(BigDecimal lipideo) {
        this.lipideo = lipideo;
    }

    public BigDecimal getCalcio() {
        return calcio;
    }

    public void setCalcio(BigDecimal calcio) {
        this.calcio = calcio;
    }

    public BigDecimal getFerro() {
        return ferro;
    }

    public void setFerro(BigDecimal ferro) {
        this.ferro = ferro;
    }

    public BigDecimal getVitaminac() {
        return vitaminac;
    }

    public void setVitaminac(BigDecimal vitaminac) {
        this.vitaminac = vitaminac;
    }

    public BigDecimal getPesocru() {
        return pesocru;
    }

    public void setPesocru(BigDecimal pesocru) {
        this.pesocru = pesocru;
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        this.pesoliquido = pesoliquido;
    }
    
    public BigDecimal getPrecoTotal() {
        return precototal;
    }

    public void setPrecoTotal(BigDecimal preco) {
        this.precototal = preco;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfichatecnica != null ? idfichatecnica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof fichatecnica)) {
            return false;
        }
        fichatecnica other = (fichatecnica) object;
        if ((this.idfichatecnica == null && other.idfichatecnica != null) || (this.idfichatecnica != null && !this.idfichatecnica.equals(other.idfichatecnica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.fichatecnica[idfichatecnica=" + idfichatecnica + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoFichaTecnica daoFichaTecnica = new DaoFichaTecnica();
        if (Operacao == 0) {
            return daoFichaTecnica.Salvar(this);
        } else
            return daoFichaTecnica.Alterar(this);
    }
    
    public boolean GravaFichaEItens(int Operacao, ArrayList<fichatecnicaitens> ListaNovo, ArrayList<fichatecnicaitens> ListaAlterar, ArrayList<fichatecnicaitens> ListaExcluir){
        DaoFichaTecnica daoFichaTecnica = new DaoFichaTecnica();
        if (Operacao == 0) {
            return daoFichaTecnica.SalvarFichaEItens(this, ListaNovo, ListaAlterar, ListaExcluir);
        } else
            return daoFichaTecnica.AlterarFichaEItens(this,  ListaNovo, ListaAlterar, ListaExcluir);        
    }

    @Override
    public boolean Excluir() {
        DaoFichaTecnica daoFichaTecnica = new DaoFichaTecnica();
        return daoFichaTecnica.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoFichaTecnica daoFichaTecnica = new DaoFichaTecnica();
        return daoFichaTecnica.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdfichatecnica(null);
        setNomepreparacao(null);
        setModopreparo(null);
        setRendimento(null);
        setEnergia(null);
        setCarboidrato(null);
        setProteina(null);
        setLipideo(null);
        setCalcio(null);
        setFerro(null);
        setVitaminac(null);
        setPesocru(null);
        setPesoliquido(null);
        setPrecoTotal(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdfichatecnica(Id);
        DaoFichaTecnica daoFichaTecnica = new DaoFichaTecnica();
        try {
            this.CarregarClasse(daoFichaTecnica.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        setIdfichatecnica(((fichatecnica)object).getIdfichatecnica());
        setNomepreparacao(((fichatecnica)object).getNomepreparacao());
        setModopreparo(((fichatecnica)object).getModopreparo());
        setRendimento(((fichatecnica)object).getRendimento());
        setEnergia(((fichatecnica)object).getEnergia());
        setCarboidrato(((fichatecnica)object).getCarboidrato());
        setProteina(((fichatecnica)object).getProteina());
        setLipideo(((fichatecnica)object).getLipideo());
        setCalcio(((fichatecnica)object).getCalcio());
        setFerro(((fichatecnica)object).getFerro());
        setVitaminac(((fichatecnica)object).getVitaminac());
        setPesocru(((fichatecnica)object).getPesocru());
        setPesoliquido(((fichatecnica)object).getPesoliquido());
        setPrecoTotal(((fichatecnica)object).getPrecoTotal());
    }
    
    public void SomarComposicaoCentesimal(produto Produto, BigDecimal PesoBruto, BigDecimal PesoLiquido) {
        if (this.getIdfichatecnica() == null) {
            ZerarComposicaoCentesimal();
        }
        this.pesocru = this.pesocru.add(PesoBruto);
        this.pesoliquido = this.pesoliquido.add(PesoLiquido);
        this.energia = this.energia.add(Produto.getIdcomposicaocentesimal().getEnergia().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.carboidrato = this.carboidrato.add(Produto.getIdcomposicaocentesimal().getCarboidrato().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.proteina = this.proteina.add(Produto.getIdcomposicaocentesimal().getProteina().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.lipideo = this.lipideo.add(Produto.getIdcomposicaocentesimal().getLipideo().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.calcio = this.calcio.add(Produto.getIdcomposicaocentesimal().getCalcio().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.ferro = this.ferro.add(Produto.getIdcomposicaocentesimal().getFerro().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.vitaminac = this.vitaminac.add(Produto.getIdcomposicaocentesimal().getVitaminac().multiply(PesoLiquido).divide(new BigDecimal(100)));        
        this.precototal = this.precototal.add(Produto.getValor().multiply(PesoBruto).divide(Produto.ConverterPesoEmGramas()));
    }
    
    public void ZerarComposicaoCentesimal(){
        setEnergia(new BigDecimal(0));
        setCarboidrato(new BigDecimal(0));
        setProteina(new BigDecimal(0));
        setLipideo(new BigDecimal(0));
        setCalcio(new BigDecimal(0));
        setFerro(new BigDecimal(0));
        setVitaminac(new BigDecimal(0));
        setPesocru(new BigDecimal(0));
        setPesoliquido(new BigDecimal(0));
        setPrecoTotal(new BigDecimal(0));        
    }
    
    public void DiminuirComposicaoCentesimal(produto Produto, BigDecimal PesoBruto, BigDecimal PesoLiquido){
        this.pesocru = this.pesocru.subtract(PesoBruto);
        this.pesoliquido = this.pesoliquido.subtract(PesoLiquido);
        this.energia = this.energia.subtract(Produto.getIdcomposicaocentesimal().getEnergia().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.carboidrato = this.carboidrato.subtract(Produto.getIdcomposicaocentesimal().getCarboidrato().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.proteina = this.proteina.subtract(Produto.getIdcomposicaocentesimal().getProteina().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.lipideo = this.lipideo.subtract(Produto.getIdcomposicaocentesimal().getLipideo().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.calcio = this.calcio.subtract(Produto.getIdcomposicaocentesimal().getCalcio().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.ferro = this.ferro.subtract(Produto.getIdcomposicaocentesimal().getFerro().multiply(PesoLiquido).divide(new BigDecimal(100)));
        this.vitaminac = this.vitaminac.subtract(Produto.getIdcomposicaocentesimal().getVitaminac().multiply(PesoLiquido).divide(new BigDecimal(100)));        
        this.precototal = this.precototal.subtract(Produto.getValor().multiply(PesoBruto).divide(Produto.ConverterPesoEmGramas()));        
    }

}
