/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Dao.Classes.DaoLogSistema;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "logsistema")
//@NamedQueries({@NamedQuery(name = "logsistema.findByIdlogsistema", query = "SELECT l FROM logsistema l WHERE l.idlogsistema = :idlogsistema"), @NamedQuery(name = "logsistema.findByUsuario", query = "SELECT l FROM logsistema l WHERE l.usuario = :usuario"), @NamedQuery(name = "logsistema.findByHorario", query = "SELECT l FROM logsistema l WHERE l.horario = :horario")})
public class logsistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "idlogsistema", nullable = false)
    private Integer idlogsistema;
    @OneToOne
    @JoinColumn(name = "idusuario", unique = true, referencedColumnName = "idusuario", nullable = false)    
    private usuario Usuario;
    @Column(name = "horario", nullable = false)
    //@Temporal(TemporalType.DATE)
    private Timestamp horario;
    @Column(name = "operacao")
    private String Operacao;
    @Column(name = "logVinculado")
    private int LogVinculado;

    public logsistema() {
    }

    public logsistema(Integer idlogsistema) {
        this.idlogsistema = idlogsistema;
    }

    public logsistema(Integer idlogsistema, usuario usu, Timestamp horario) {
        this.idlogsistema = idlogsistema;
        this.Usuario = usu;
        this.horario = horario;
    }

    public Integer getIdlogsistema() {
        return idlogsistema;
    }

    public void setIdlogsistema(Integer idlogsistema) {
        this.idlogsistema = idlogsistema;
    }

    public usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(usuario usu) {
        this.Usuario = usu;
    }

    public Timestamp getHorario() {
        return horario;
    }

    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }
    
    public void setOperacao(String Op) {
        this.Operacao = Op;
    }
    
    public String getOperacao() {
        return this.Operacao;
    }
    
    public void setLogVinculado(int Log) {
        this.LogVinculado = Log;
    }
    
    public int getLogVinculaod(){
        return this.LogVinculado;
    }
    
    @PostPersist
    public void AtualizaIdAcesso(){
        UsuarioSistema.setUsuarioConectado(this.getUsuario());
        UsuarioSistema.setidLogEntrada(this.getIdlogsistema());
        }

    public boolean Gravar(){
        DaoLogSistema daoLogSistema = new DaoLogSistema();        
            return daoLogSistema.Salvar(this);       
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogsistema != null ? idlogsistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof logsistema)) {
            return false;
        }
        logsistema other = (logsistema) object;
        if ((this.idlogsistema == null && other.idlogsistema != null) || (this.idlogsistema != null && !this.idlogsistema.equals(other.idlogsistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Logsistema[idlogsistema=" + idlogsistema + "]";
    }

}
