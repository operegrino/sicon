/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Telas.Formulario.TelaCargo;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Jonathan
 */
public class Funcoes {
    
    public Funcoes() {
        
    }
    /*
     * Centralizar o frame em questão na tela;
     */
    public static Point CentralizarFrame(Dimension Dim){       
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int iLargura       = ((tela.width / 2));
        int iLarguraForm   = (Dim.getSize().width/2);
        int x              = iLargura - iLarguraForm;
        int iAltura  = ((tela.height / 2) - (Dim.getSize().height/2)) - 40; 
         Point ptRetorno;
         return ptRetorno = new Point(x, iAltura);             
    }
    
    public static String CharToString(char[] charconverter){
        String sRetorno = "";
        int cont = 0;
        while (charconverter.length > cont)  {
            sRetorno = sRetorno + charconverter[cont];
            cont++;
        }
        return sRetorno;
    }
}
