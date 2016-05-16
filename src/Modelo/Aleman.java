
import Modelo.Amortizacion;
import java.util.*;

/**
 * 
 */
public class Aleman extends Amortizacion {


    public Aleman() {
 
    }
    




	public void calcularAmortizacion() {
		for (int i = 0; i < plazo; i++ ){
    	montoAmortizacion =+ (monto_prestamo / plazo);
		getAmortizacion().add(montoAmortizacion);
    }
	}
	

	   public void calcularDeuda() {
	   	int periodoTranscurrido = 0;
	   	for(int i= 0 ;i <= plazo; i++) {
	   		   montoDeuda =(((monto_prestamo / plazo ) *(plazo - periodoTranscurrido)));
	   		   getDeudas().add(montoDeuda);
	   		   periodoTranscurrido++;
	   	  
	   		}
	   }
	
	   
	   
	  
    public void calcularInteresPeriodo() {
    	
    	for( int i = 0; i < getDeudas().size() ; i++){
    		
    		monto_interesPeriodo =+ getDeudas().get(i) * (interes_anual * 0.01);
    		getInteresPeriodo().add(monto_interesPeriodo);
    	}
    }
    

    

	@Override
	public void calcularCuota() {
		for (int i = 0; i < getInteresPeriodo().size(); i++){
			if (getInteresPeriodo().get(i) > 0){ //Aqui hay que ver esta validacion
			montoCuota =+ getInteresPeriodo().get(i) + montoAmortizacion;
			getCuotas().add(montoCuota);
		}
		}
	}




	public LinkedList<Double> getDeudas() {
		return resultadoDeuda;
	}




	public void setDeudas(LinkedList<Double> deudas) {
		this.resultadoDeuda = deudas;
	}




	public LinkedList<Double> getCuotas() {
		return resultadoCuota;
	}




	public void setCuotas(LinkedList<Double> cuotas) {
		this.resultadoCuota = cuotas;
	}




	public LinkedList<Double> getInteresPeriodo() {
		return resultadoInteres;
	}




	public void setInteresPeriodo(LinkedList<Double> interesPeriodo) {
		this.resultadoInteres = interesPeriodo;
	}




	public LinkedList<Double> getAmortizacion() {
		return resultadoAmortizaciones;
	}




	public void setAmortizacion(LinkedList<Double> amortizacion) {
		this.resultadoAmortizaciones = amortizacion;
	}
    	
    

 
}