/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.informes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import park.entradas.ListaAccesosParque;

/**
 *
 * @author corun
 */
public class InformeNumeroVisitantes {
    
    
    public void generarInformeDiario(LocalDate fecha){
        List entradas;
        int visitantes[];
      
      entradas=Arrays.asList(ListaAccesosParque.getListaAccesosParque().stream()
              .filter(a -> a.getTimestamp().getDayOfMonth() == fecha.getDayOfMonth())
              .map(a->a.getEntrada()).toArray());
      
    }
    
}
