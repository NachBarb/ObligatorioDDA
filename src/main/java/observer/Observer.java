/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

/**
 *
 * @author Martin
 */
public interface Observer {
    
    public enum Eventos{
        LlamadaIniciada,
        LlamadaEnEspera,
        LlamadaAtendida,
        LlamadaFinalizada,
        SectorAtiende,
        SectorFinaliza,
        PuestoLibre
    }
    
    public void update(Observable source, Object event);
}
