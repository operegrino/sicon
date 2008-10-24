/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Componentes;

import javax.swing.JCheckBox;

/**
 *
 * @author jonathan
 */
public class JCheckBoxComId extends JCheckBox{
    
    private int Identificacao;
    
    public JCheckBoxComId(){
        
    }
    
    public JCheckBoxComId(int Id) {
        this.Identificacao = Id;
    }

    public int getIdentificacao(){
        return this.Identificacao;
    }
    
    public void setIdentificacao(int Id){
        this.Identificacao = Id;
    }
}
