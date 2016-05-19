package Modelo;

import DTO.DTOAmortizacion;

public class Frances extends Amortizacion {

  public Frances(DTOAmortizacion dtoAmortizacion){
        super( dtoAmortizacion);
    }
    
    public Frances(float montoPrestamo,int plazo,double interesAnual){
        super(montoPrestamo,plazo,interesAnual);    	
    }
    
    @Override
    public void calcularInteresPeriodo() {
	for (int i = 0; i< resultadoDeuda.size()-1 ; i++ ){
            montoInteresPeriodo =  resultadoDeuda.get(i) * (interesAnual * 0.01);
            resultadoInteres.add(montoInteresPeriodo);
        }
    }
    
    @Override
    public void calcularCuota() {
      for (int i = 0; i < plazo ; i++){
        montoCuota =+ (1 + (interesAnual * 0.01)) ;
        montoCuota =+ Math.pow(montoCuota, plazo);
        montoCuota =+  (montoPrestamo * (interesAnual * 0.01)) / (1 - (1 / montoCuota));
        resultadoCuota.add(montoCuota);
      }
    }
    
    @Override
    public void calcularAmortizacion() {
        int temporalPlazo = plazo;
         for (int i =0; i < temporalPlazo ; temporalPlazo--){ 
            montoAmortizacion =+ (1 + (interesAnual * 0.01));
            montoAmortizacion = Math.pow(montoAmortizacion, temporalPlazo);
            montoAmortizacion = montoCuota / montoAmortizacion + 1 - (i)  ;
            resultadoAmortizaciones.add(montoAmortizacion);	
        }
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
}