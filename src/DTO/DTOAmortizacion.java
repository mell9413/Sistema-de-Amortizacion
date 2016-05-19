
package DTO;

import Modelo.Cliente;
import java.util.LinkedList;

public class DTOAmortizacion {
    
    private int plazo;
    private double interesAnual;
    private float montoPrestamo;
    private String tipoAmortizacion;
    private String moneda;
    private LinkedList<Double> resultadoCuota;
    private LinkedList<Double> resultadoAmortizaciones;
    private LinkedList<Double> resultadoDeuda ;
    private LinkedList<Double> resultadoInteres ;
    protected Cliente cliente;
    
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
        this.interesAnual = interes_anual;
    }
    
    public double GetInteres_anual(){
     return interesAnual;
    }
    
     public void SetMonto_prestamo(float  monto_prestamo){
        this.montoPrestamo = monto_prestamo;
    }
    
    public float GetMonto_prestamo(){
     return montoPrestamo;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
