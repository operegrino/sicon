/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Classes.email;
import Dao.Classes.DaoPedido;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "pedido")
/*@NamedQueries({@NamedQuery(name = "pedido.findByIdpedido", query = "SELECT p FROM pedido p WHERE p.idpedido = :idpedido"), @NamedQuery(name = "pedido.findByFornecedor", query = "SELECT p FROM pedido p WHERE p.idfornecedor = :Fornecedor")})*/
public class pedido implements Serializable, InterfacePadraoClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idpedido", nullable = false)
    private Integer idpedido;
    @OneToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name = "idfornecedor", unique = true, referencedColumnName = "idfornecedor", nullable = false)
    private fornecedor Fornecedor;      
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "idpedido", fetch=FetchType.EAGER)
    private List<itempedido> ListaItemPedido;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "Pedido", fetch=FetchType.EAGER)
    private List<historicopedido> ListaHistorico;
    @Column(name = "dataentrega", nullable = false)
    @Temporal(TemporalType.DATE) 
    private Date dataEntrega;

    public pedido() {
    }

    public pedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public pedido(Integer idpedido, fornecedor idfornecedor) {
        this.idpedido = idpedido;
        this.Fornecedor = idfornecedor;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public fornecedor getFornecedor() {
        return Fornecedor;
    }

    public void setIdfornecedor(fornecedor idfornecedor) {
        this.Fornecedor = idfornecedor;
    }
    
    public List getItens() {
        return ListaItemPedido;
    }

    public void setItens(List Lista) {
        this.ListaItemPedido = Lista;
    }        
    
    public List getHistorico() {
        return ListaHistorico;
    }

    public void setHistorico(List Lista) {
        this.ListaHistorico = Lista;
    }      

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof pedido)) {
            return false;
        }
        pedido other = (pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.pedido[idpedido=" + idpedido + "]";
    }

    @Override
    public boolean Gravar(int Operacao) {
        DaoPedido daoPedido = new DaoPedido();
        if (Operacao == 0) {
            return daoPedido.Salvar(this);
        }
            return daoPedido.Alterar(this);
    }

    @Override
    public boolean Excluir() {
        DaoPedido daoPedido = new DaoPedido();
        return daoPedido.Excluir(this);
    }

    @Override
    public List Pesquisar(ArrayList<String> ListaParametros) {
        DaoPedido daoPedido = new DaoPedido();
        return daoPedido.Pesquisar(ListaParametros);     
    }

    @Override
    public void LimparClasse() {
        setIdpedido(null);
        setIdfornecedor(null);        
        setItens(null);
    }

    @Override
    public void LerClasse(int Id) {
        LimparClasse(); 
        this.setIdpedido(Id);
        DaoPedido daoPedido = new DaoPedido();
        try {
            this.CarregarClasse(daoPedido.CarregarObjeto(this));
        } catch (Exception ex) {
            this.LimparClasse();
        }
    }
    
    public Integer RetornaUltimoId(){
        DaoPedido daoPedido = new DaoPedido();
        return daoPedido.RetornaUltimoId();
    }
    
    public situacaopedido RetornaSituacaoAtual() throws NullPointerException{
        Date datasit = new Date();
        situacaopedido sp = new situacaopedido();
        sp = ((historicopedido)ListaHistorico.get(0)).getIdsituacaopedido();
        datasit = ListaHistorico.get(0).getDatahistoricopedido();
        for (Iterator<historicopedido> it = ListaHistorico.iterator(); it.hasNext();) {
            historicopedido historico = it.next();
            if (datasit.before(historico.getDatahistoricopedido())) { 
                sp = historico.getIdsituacaopedido();                
            }
            
        }
        return sp;
    }
    
    public String GravarArquivoFornecedor() throws Exception{
        ManipulaExcel Excel = new ManipulaExcel();
        DaoPedido daoPedido = new DaoPedido();   
        try {
            return Excel.GerarArquivoFornecedor((Vector)daoPedido.PesquisarEnviarFornecedor(this.getFornecedor().getIdfornecedor().toString(), this.getIdpedido().toString()));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void EnviarEmail() throws AddressException, MessagingException, IOException, Exception{        
        EnviarEmail email = new EnviarEmail();
        ConfiguracoesStatic.setCaminhoArquivo("C:/LP-" + String.valueOf(idpedido) + ".xls");
        email.EnviarEmailFornecedor(ConfiguracoesStatic.getCaminhoArquivo(),(Vector) this.getFornecedor().RetornaEmail());
    }

    @Override
    public void CarregarClasse(Object object) throws Exception {
        this.setIdpedido(((pedido)object).getIdpedido());
        this.setIdfornecedor(((pedido)object).getFornecedor());
        this.setItens(((pedido)object).getItens());
        this.setHistorico(((pedido)object).getHistorico());
        this.setDataEntrega(((pedido)object).getDataEntrega());
    }

}
