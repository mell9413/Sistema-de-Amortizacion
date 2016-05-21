package Modelo;

import DTO.*;

public class Aleman extends Amortizacion {
    
    public Aleman(DTOAmortizacion dtoAmortizacion){
        super(dtoAmortizacion);
    }
    
    @Override
    public void calcularAmortizacion() {
        for (int i = 0; i < plazo; i++ ){
            montoAmortizacion =+ (montoPrestamo / plazo);
            resultadoAmortizaciones.add(montoAmortizacion);
        }
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
    	for( int i = 0; i < resultadoDeuda.size()-1 ; i++){
            montoInteresPeriodo =+ resultadoDeuda.get(i) * (interesAnual * 0.01);
            resultadoInteres.add(montoInteresPeriodo);
    	}
    }
    
    @Override
    public void calcularCuota() {
        for (int i = 0; i < resultadoInteres.size(); i++){
            if (resultadoInteres.get(i) > 0){ //Aqui hay que ver esta validacion
                montoCuota =+ resultadoInteres.get(i) + montoAmortizacion;
                resultadoCuota.add(montoCuota);
            }
        }
    }

    @Override
    public void obtenerResultados() {
        calcularAmortizacion();
        calcularDeuda();
        calcularInteresPeriodo();
        calcularCuota();
    }
}