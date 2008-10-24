/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jonathan
 * 
 * Classe: ultimousuario
 * 
 * Objetivo : poder carregar para a tabela de auditoria quem é o usuario que está
 * efetuando a operação no banco.
 * toda vez que houver alguma operação de insert/update/delete o sistema antes de
 * efetuar a operação atualiza a tabela ultimousuario, que possui apenas um registro,
 * com o usuario que está logado no sistema, então no momento em que executar a trigger
 * basta pegar desta tabela.
 */
@Entity
@Table(name = "ultimousuario")
public class ultimousuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idultimousuario", nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idultimousuario;    
    @Column(name="usuario", nullable = false)
    private String usuario;
    
    public ultimousuario(){
        
    }
    
    public void setUltimoUsuario(String usu){
        idultimousuario = 1;
        usuario = usu;        
    }    
    
}
    




