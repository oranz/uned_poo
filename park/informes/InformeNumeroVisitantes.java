/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.informes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import park.entradas.ListaAccesosParque;

/**
 *
 * @author corun
 */
public class InformeNumeroVisitantes {
    
    
    public int getTotalAccesosParqueDia(LocalDate fecha){
        return (int) ListaAccesosParque.getListaAccesosParque().stream()
                .filter(a -> a.getTimestamp().toLocalDate().isEqual(fecha)).count();
    }
    
    public ArrayList<Integer> getTotalAccesosParquePorSemana(int anho){
        LocalDate fechaTemporal = LocalDate.of(anho, 1, 1);
        ArrayList<Integer> semanas = new ArrayList<>();
        for(int i=0; i<=52;i++){
            int sumatorio = 0;
            do{
                sumatorio += getTotalAccesosParqueDia(fechaTemporal);
                fechaTemporal=fechaTemporal.plusDays(1);
            }while(fechaTemporal.getDayOfWeek() != DayOfWeek.MONDAY && fechaTemporal.getYear() != anho+1);
            
            semanas.add(sumatorio); 
        }
        
        return semanas;
    }
    
    public int getTotalAccesosParquePorMes(int anho, int mes){
     
        return (int) ListaAccesosParque.getListaAccesosParque().stream()
                .filter(a -> a.getTimestamp().getYear()==anho)
                .filter(a->a.getTimestamp().getMonthValue()==mes)
                .count();
        
    }
    
    public ArrayList<Integer> getTotalAccesosParquePorMeses(int anho){
        ArrayList<Integer> meses = new ArrayList<>();
        for(int i=1; i<=12;i++){
            int sumatorio = 0;
                sumatorio += getTotalAccesosParquePorMes(anho,i);            
            meses.add(sumatorio); 
        }
        
        return meses;
    }
    
    public int getTotalAccesosParqueAnual(int anho){
        return getTotalAccesosParquePorMeses(anho).stream().mapToInt(i->i).sum();
    }
    
}
