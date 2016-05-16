
import Modelo.Amortizacion;
import java.util.*;

/**
 * 
 */
public class Americano extends Amortizacion {


    public Americano() {
    }

    public void calcularDeuda() {
    	for (int i = 1; i <= plazo; i++){
    		
    		if (i == plazo){
    			montoDeuda =+ 0;
    			resultadoDeuda.add(montoDeuda);
    		}else{
    			montoDeuda =+ monto_prestamo;
    			resultadoDeuda.add(montoDeuda);
    		}
    	}
	}

    
    public void calcularAmortizacion() {
    	for (int i = 1; i <= plazo; i++){
    		
    		if (i == plazo){
    			montoAmortizacion =+ monto_prestamo;
    			resultadoAmortizaciones.add(montoAmortizacion);
    		}else{
    			montoAmortizacion =+ 0;
    			resultadoAmortizaciones.add(montoAmortizacion);
    		}
    	}
    	
	}
    
  
    public void calcularInteresPeriodo() {
    	
    	for (int i = 0; i < plazo; i++){
    		 monto_interesPeriodo =+ monto_prestamo * (interes_anual * 0.01);
    		 resultadoInteres.add(monto_interesPeriodo);
    	}
	}

 
	@Override
	public void calcularCuota() {
		for (int i = 1; i <= plazo; i++){
			
			if (i == plazo){
				montoCuota =+ monto_prestamo + (monto_prestamo * (interes_anual * 0.01));
				resultadoCuota.add(montoCuota);
			} else{
				montoCuota =+ (monto_prestamo * (interes_anual * 0.01));
				resultadoCuota.add(montoCuota);
			}
		}
	
	}
		
	

}