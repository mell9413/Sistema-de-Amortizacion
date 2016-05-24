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
                totalAmortizacion =+ totalAmortizacion + montoAmortizacion;
                resultadoAmortizaciones.add(montoAmortizacion);
            }
            else{
                montoAmortizacion =+ 0;
                resultadoAmortizaciones.add(montoAmortizacion);
            }
           resultadoAmortizaciones.addLast(totalAmortizacion); 
    	}
    }
    
    @Override
    public void calcularInteresPeriodo() {
        for (int i = 0; i < plazo; i++){
            montoInteresPeriodo =+ montoPrestamo * (interesAnual * 0.01);
            totalInteres =+ montoInteresPeriodo + totalInteres;
            resultadoInteres.add(montoInteresPeriodo);
    	}
        resultadoInteres.addLast(totalInteres);
    }
    
    @Override
    public void calcularCuota() {
        for (int i = 1; i <= plazo; i++){
            if (i == plazo){
                montoCuota =+ montoPrestamo + (montoPrestamo * (interesAnual * 0.01));
                totalCuota =+ montoCuota + totalCuota;
                resultadoCuota.add(montoCuota);
            } else{
                montoCuota =+ (montoPrestamo * (interesAnual * 0.01));
                totalCuota =+ montoCuota + totalCuota;
                resultadoCuota.add(montoCuota);
            }
            resultadoCuota.addLast(totalCuota);
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