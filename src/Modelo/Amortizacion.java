package Modelo;

import java.util.*;

/**
 * 
 */
public abstract class Amortizacion {

    /**
     * Default constructor
     */
    public Amortizacion() {
    }

    
    public float monto_prestamo;
    public int plazo;
    public double interes_anual;
    public double montoAmortizacion;
    public double montoCuota;
    public double monto_interesPeriodo;
    public double montoDeuda;
    protected LinkedList<Double> resultadoCuota  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoAmortizaciones  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoDeuda  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoInteres  = new LinkedList<Double>();

    public abstract void calcularDeuda();
    public abstract void calcularAmortizacion();
    public abstract void calcularInteresPeriodo();
    public abstract void calcularCuota();
    
    private String obtenerTipoCambio(){       
        Calendar fecha = new GregorianCalendar();
        String fechaActual = Integer.toString(fecha.get(Calendar.DATE))+"/"+((fecha.get(Calendar.MONTH))+1)+"/"+fecha.get(Calendar.YEAR);
        cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos cliente = new cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos();
        String tipoCambio = cliente.getWsIndicadoresEconomicosSoap().obtenerIndicadoresEconomicosXML("317", fechaActual, fechaActual, "Mell", "N");
        tipoCambio = tipoCambio.substring(196,204);
        return tipoCambio;
    }
}