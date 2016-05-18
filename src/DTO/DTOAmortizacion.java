
package DTO;

public class DTOAmortizacion {
    
    private int plazo;
    private double interes_anual;
    private float monto_prestamo;
    private String tipoAmortizacion;
    private String moneda;
  
    public DTOAmortizacion(){
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
