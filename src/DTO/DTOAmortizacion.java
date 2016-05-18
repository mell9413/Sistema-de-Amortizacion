
package DTO;

import java.util.LinkedList;

public class DTOAmortizacion {
    
    private int plazo;
    private double interes_anual;
    private float monto_prestamo;
    private String tipoAmortizacion;
    private String moneda;
    private LinkedList<Double> resultadoCuota;
    private LinkedList<Double> resultadoAmortizaciones;
    private LinkedList<Double> resultadoDeuda ;
    private LinkedList<Double> resultadoInteres ;
    
        public DTOAmortizacion(){
          
    }

    public LinkedList<Double> getResultadoCuota() {
        return resultadoCuota;
    }

    public void setResultadoCuota(LinkedList<Double> resultadoCuota) {
        this.resultadoCuota = resultadoCuota;
    }

    public LinkedList<Double> getResultadoAmortizaciones() {
        return resultadoAmortizaciones;
    }

    public void setResultadoAmortizaciones(LinkedList<Double> resultadoAmortizaciones) {
        this.resultadoAmortizaciones = resultadoAmortizaciones;
    }

    public LinkedList<Double> getResultadoDeuda() {
        return resultadoDeuda;
    }

    public void setResultadoDeuda(LinkedList<Double> resultadoDeuda) {
        this.resultadoDeuda = resultadoDeuda;
    }

    public LinkedList<Double> getResultadoInteres() {
        return resultadoInteres;
    }

    public void setResultadoInteres(LinkedList<Double> resultadoInteres) {
        this.resultadoInteres = resultadoInteres;
    }
    
    
    public void SetPlazo(int  plazo){
        this.plazo = plazo;
    }
    
    public int GetPlazo(){
     return plazo;
    }
  
     public void SetInteres_anual(double  interes_anual){
        this.interes_anual = interes_anual;
    }
    
    public double GetInteres_anual(){
     return interes_anual;
    }
    
     public void SetMonto_prestamo(float  monto_prestamo){
        this.monto_prestamo = monto_prestamo;
    }
    
    public float GetMonto_prestamo(){
     return monto_prestamo;
    }
    
     public void SetTipoAmortizacion(String tipoAmortizacion){
        this.tipoAmortizacion = tipoAmortizacion;
    }
    
    public String GetTipoAmortizacion(){
     return tipoAmortizacion;
    }
    
      public void SetMoneda(String moneda){
        this.moneda = moneda;
    }
    
    public String GetMoneda(){
     return moneda;
    }
    
}
