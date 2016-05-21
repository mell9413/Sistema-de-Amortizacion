package Modelo;

import DTO.DTOAmortizacion;

public class Americano extends Amortizacion {

    public Americano(DTOAmortizacion dtoAmortizacion){
        super(dtoAmortizacion);
    }

    @Override
    public void calcularDeuda() {
    	for (int i = 1; i <= plazo; i++){
            if (i == plazo){
                montoDeuda =+ 0;
                resultadoDeuda.add(montoDeuda);
            }
            else{
                montoDeuda =+ montoPrestamo;
                resultadoDeuda.add(montoDeuda);
            }
    	}
    }
    
    @Override
    public void calcularAmortizacion() {
    	for (int i = 1; i <= plazo; i++){
            if (i == plazo){
                montoAmortizacion =+ montoPrestamo;
                resultadoAmortizaciones.add(montoAmortizacion);
            }
            else{
                montoAmortizacion =+ 0;
                resultadoAmortizaciones.add(montoAmortizacion);
            }
    	}
    }
    
    @Override
    public void calcularInteresPeriodo() {
        for (int i = 0; i < plazo; i++){
            montoInteresPeriodo =+ montoPrestamo * (interesAnual * 0.01);
            resultadoInteres.add(montoInteresPeriodo);
    	}
    }
    
    @Override
    public void calcularCuota() {
        for (int i = 1; i <= plazo; i++){
            if (i == plazo){
                montoCuota =+ montoPrestamo + (montoPrestamo * (interesAnual * 0.01));
                resultadoCuota.add(montoCuota);
            } else{
                montoCuota =+ (montoPrestamo * (interesAnual * 0.01));
                resultadoCuota.add(montoCuota);
            }
        }
    }

    @Override
    public void obtenerResultados() {
        calcularInteresPeriodo();
        calcularCuota();
        calcularAmortizacion();
        calcularDeuda();
    }
}