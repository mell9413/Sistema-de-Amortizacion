package Modelo;

import DTO.*;

public class Aleman extends Amortizacion {
    
    public Aleman(DTOAmortizacion dtoAmortizacion){
        super(dtoAmortizacion);
    }
    
    @Override
    public void calcularAmortizacion() {
        double totalAmortizacion = 0;
        for (int i = 0; i < plazo; i++ ){
            montoAmortizacion =+ (montoPrestamo / plazo);
            totalAmortizacion += montoAmortizacion;
            resultadoAmortizaciones.add(montoAmortizacion);
        }
        resultadoAmortizaciones.addLast(totalAmortizacion);
    }
    
    @Override
    public void calcularDeuda() {
        int periodoTranscurrido = 0;
        for(int i= 0 ;i <= plazo; i++) {
            montoDeuda =(((montoPrestamo / plazo ) *(plazo - periodoTranscurrido)));
            resultadoDeuda.add(montoDeuda);
            periodoTranscurrido++;
         }
   }
    
    @Override
    public void calcularInteresPeriodo() {
        double totalInteres = 0;
    	for( int i = 0; i < resultadoDeuda.size()-1 ; i++){
            montoInteresPeriodo =+ resultadoDeuda.get(i) * (interesAnual * 0.01);
            totalInteres += montoInteresPeriodo;
            resultadoInteres.add(montoInteresPeriodo);
    	}
        resultadoInteres.addLast(totalInteres);
    }
    
    @Override
    public void calcularCuota() {
        double totalCuota = 0;
        for (int i = 0; i < resultadoInteres.size()-1; i++){
                montoCuota =+ resultadoInteres.get(i) + montoAmortizacion;
                totalCuota += montoCuota;
                resultadoCuota.add(montoCuota);
        }
        resultadoCuota.addLast(totalCuota);
    }

    

    
    @Override
    public void obtenerResultados() {
        calcularAmortizacion();
        calcularDeuda();
        calcularInteresPeriodo();
        calcularCuota();
       
    }

   

    
}