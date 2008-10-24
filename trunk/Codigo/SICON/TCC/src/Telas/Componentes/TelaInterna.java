/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas.Componentes;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Jonathan
 */
public abstract class TelaInterna extends JInternalFrame {
    
    public TelaInterna(){
        this.CarregarEventos();        
    }

    public abstract void EventoFechar();
    
    public abstract void EventoAbrir();
            
    private void CarregarEventos(){
        this.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                EventoFechar();
              }

            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                 EventoAbrir();
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                EventoFechar();
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {

            }

        
        });                    
    }
}
