import Modelo.Amortizacion;
import java.util.*;

public class Frances extends Amortizacion {

 
    
    public Frances() {
    	
    }
    

 
	
	   public void calcularInteresPeriodo() {
		  
		  for (int i = 0; i< resultadoDeuda.size()-1 ; i++ ){
			  monto_interesPeriodo =  resultadoDeuda.get(i) * (interes_anual * 0.01);
			  resultadoInteres.add(monto_interesPeriodo);
			}
			 System.out.print( resultadoInteres + "hola");
	   }
		
	   

	@Override
	public void calcularCuota() {
	  for (int i = 0; i < plazo ; i++){
		montoCuota =+ (1 + (interes_anual * 0.01)) ;
    	montoCuota =+ Math.pow(montoCuota, plazo);
		montoCuota =+  (monto_prestamo * (interes_anual * 0.01)) / (1 - (1 / montoCuota));
		resultadoCuota.add(montoCuota);
	  }
	}
	
	
	  public void calcularAmortizacion() {
		int temporalPlazo = plazo;
		 for (int i =0; i < temporalPlazo ; temporalPlazo--){ 
			 montoAmortizacion =+ (1 + (interes_anual * 0.01));
			 montoAmortizacion = Math.pow(montoAmortizacion, temporalPlazo);
			 montoAmortizacion = montoCuota / montoAmortizacion + 1 - (i)  ;
			 resultadoAmortizaciones.add(montoAmortizacion);	
		  	}
	  }

	  
	   public void calcularDeuda() {
	    double temporalPrestamo = monto_prestamo;
	    resultadoDeuda.add(temporalPrestamo);
	     for (int i = 0; i < resultadoAmortizaciones.size()-1 ; i++){ 
	    	montoDeuda = temporalPrestamo - resultadoAmortizaciones.get(i);
	    	resultadoDeuda.add(montoDeuda);
	    	temporalPrestamo = montoDeuda;
		}
	     resultadoDeuda.add(montoDeuda-montoDeuda);
	   }

	
	    
	


}