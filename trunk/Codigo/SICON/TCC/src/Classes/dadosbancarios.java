/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoDadosBancarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "dadosbancarios")
@NamedQueries({@NamedQuery(name = "dadosbancarios.findByIddadosbancarios", query = "SELECT d FROM dadosbancarios d WHERE d.iddadosbancarios = :iddadosbancarios"), @NamedQuery(name = "dadosbancarios.findByAgencia", query = "SELECT d FROM dadosbancarios d WHERE d.agencia = :agencia"), @NamedQuery(name = "dadosbancarios.findByContacorrente", query = "SELECT d FROM dadosbancarios d WHERE d.contacorrente = :contacorrente"), @NamedQuery(name = "dadosbancarios.findByContacorrentedigito", query = "SELECT d FROM dadosbancarios d WHERE d.contacorrentedigito = :contacorrentedigito")})
public class dadosbancarios implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "iddadosbancarios", nullable = false)
    private Integer iddadosbancarios;
    @Column(name = "agencia", nullable = false)
    private String agencia;
    @Column(name = "contacorrente", nullable = false)
    private String contacorrente;
    @Column(name = "contacorrentedigito", nullable = false)
    private String contacorrentedigito;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idbanco", unique = true, referencedColumnName = "idbanco", nullable = false)
    private banco Banco;

    public dadosbancarios() {
    }

    public dadosbancarios(Integer iddadosbancarios) {
        this.iddadosbancarios = iddadosbancarios;
    }

    public dadosbancarios(Integer iddadosbancarios, String agencia, String contacorrente, String contacorrentedigito) {
        this.iddadosbancarios = iddadosbancarios;
        this.agencia = agencia;
        this.contacorrente = contacorrente;
        this.contacorrentedigito = contacorrentedigito;
    }

    public Integer getIddadosbancarios() {
        return iddadosbancarios;
    }

    public void setIddadosbancarios(Integer iddadosbancarios) {
        this.iddadosbancarios = iddadosbancarios;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContacorrente() {
        return contacorrente;
    }

    public void setContacorrente(String contacorrente) {
        this.contacorrente = contacorrente;
    }

    public String getContacorrentedigito() {
        return contacorrentedigito;
    }

    public void setContacorrentedigito(String contacorrentedigito) {
        this.contacorrentedigito = contacorrentedigito;
    }

   /* public Collection<fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }*/
    
    public banco getBanco() {
        return Banco;
    }

    public void setBanco(banco B) {
        this.Banco = B;
    }
    
    //Método usado depois de salvar o dado bancario e for salvar o forncedor
    @PostPersist
    public Integer retornaIDSalvo(){
        return this.getIddadosbancarios();
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddadosbancarios != null ? iddadosbancarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof dadosbancarios)) {
            return false;
        }
        dadosbancarios other = (dadosbancarios) object;
        if ((this.iddadosbancarios == null && other.iddadosbancarios != null) || (this.iddadosbancarios != null && !this.iddadosbancarios.equals(other.iddadosbancarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.dadosbancarios[iddadosbancarios=" + iddadosbancarios + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoDadosBancarios daoDadosBancarios = new DaoDadosBancarios();
        if (Operacao == 0) {
            return daoDadosBancarios.Salvar(this);
        } else
            return daoDadosBancarios.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoDadosBancarios daoDadosBancarios = new DaoDadosBancarios();
        return daoDadosBancarios.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoDadosBancarios daoDadosBancarios = new DaoDadosBancarios();
        return daoDadosBancarios.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIddadosbancarios(null);
        setBanco(null);
        setAgencia(null);
        setContacorrente(null);
        setContacorrentedigito(null);
       // setFornecedorCollection(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIddadosbancarios(Id);
        DaoDadosBancarios daoDadosBancarios = new DaoDadosBancarios();
        try {
            this.CarregarClasse(daoDadosBancarios.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        setIddadosbancarios(((dadosbancarios)object).getIddadosbancarios());
        setBanco(((dadosbancarios)object).getBanco());
        setAgencia(((dadosbancarios)object).getAgencia());
        setContacorrente(((dadosbancarios)object).getContacorrente());
        setContacorrentedigito(((dadosbancarios)object).getContacorrentedigito());
       // setFornecedorCollection(((dadosbancarios)object).getFornecedorCollection());
    }

}
