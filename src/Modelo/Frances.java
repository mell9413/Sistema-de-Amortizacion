package Modelo;

import DTO.DTOAmortizacion;

public class Frances extends Amortizacion {

  public Frances(DTOAmortizacion dtoAmortizacion){
        super( dtoAmortizacion);
    }
    
    @Override
    public void calcularInteresPeriodo() {
        double totalInteres=0;
	for (int i = 0; i< resultadoDeuda.size() ; i++ ){
            montoInteresPeriodo =  resultadoDeuda.get(i) * (interesAnual * 0.01);
            totalInteres = montoInteresPeriodo+ totalInteres;
            resultadoInteres.add(montoInteresPeriodo);
        }
        resultadoInteres.add(totalInteres);
    }
    
    @Override
    public void calcularCuota() {
        double totalCuota = 0;
        for (int i = 0; i < plazo ; i++){
          montoCuota =+ (1 + (interesAnual * 0.01)) ;
          montoCuota =+ Math.pow(montoCuota, plazo);
          montoCuota =+  (montoPrestamo * (interesAnual * 0.01)) / (1 - (1 / montoCuota));
          totalCuota += montoCuota;
          resultadoCuota.add(montoCuota);
        }
        resultadoCuota.addLast(totalCuota);
    }
    
    @Override
    public void calcularAmortizacion() {
        int temporalPlazo = plazo;
        double totalAmortizacion=0;
         for (int i =0; i < temporalPlazo ; temporalPlazo--){ 
            montoAmortizacion =+ (1 + (interesAnual * 0.01));
            montoAmortizacion = Math.pow(montoAmortizacion, temporalPlazo);
            montoAmortizacion = montoCuota / montoAmortizacion + 1 - (i)  ;
            totalAmortizacion += montoAmortizacion;
            resultadoAmortizaciones.add(montoAmortizacion);	
        }
          resultadoAmortizaciones.addLast(totalAmortizacion);	
    }
    
    @Override
    public void calcularDeuda() {
        double temporalPrestamo = montoPrestamo;
        resultadoDeuda.add(temporalPrestamo);
        for (int i = 0; i < resultadoAmortizaciones.size()-1 ; i++){ 
            montoDeuda = temporalPrestamo - resultadoAmortizaciones.get(i);
            resultadoDeuda.add(montoDeuda);
            temporalPrestamo = montoDeuda;
        }
        resultadoDeuda.add(montoDeuda-montoDeuda);
    }

    @Override
    public void obtenerResultados() {
        calcularCuota();
        calcularAmortizacion();
        calcularDeuda();
        calcularInteresPeriodo();
    }


}