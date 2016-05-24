package Modelo;

import DTO.DTOAmortizacion;
import java.util.*;

public abstract class Amortizacion {
    
    protected float montoPrestamo;
    protected int plazo;
    protected double interesAnual;
    protected double montoAmortizacion;
    protected double montoCuota;
    protected double montoInteresPeriodo;
    protected double montoDeuda;
    protected String moneda;
    protected Cliente cliente;
    protected LinkedList<Double> resultadoCuota  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoAmortizaciones  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoDeuda  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoInteres  = new LinkedList<Double>();
    protected double totalCuota;
    protected double totalAmortizacion;
    protected double totalInteres;

    public abstract void calcularDeuda();
    public abstract void calcularAmortizacion();
    public abstract void calcularInteresPeriodo();
    public abstract void calcularCuota();
    public abstract void obtenerResultados();
   
    public Amortizacion(DTOAmortizacion dtoAmortizacion) {
        this.montoPrestamo = dtoAmortizacion.GetMonto_prestamo();
        this.plazo = dtoAmortizacion.GetPlazo();
        this.interesAnual = dtoAmortizacion.GetInteres_anual();
        this.cliente = dtoAmortizacion.getCliente();
    }

    public float getMontoPrestamo() {
        return montoPrestamo;
    }

    public int getPlazo() {
        return plazo;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public double getMontoAmortizacion() {
        return montoAmortizacion;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public double getMontoInteresPeriodo() {
        return montoInteresPeriodo;
    }

    public double getMontoDeuda() {
        return montoDeuda;
    }

    public LinkedList<Double> getResultadoCuota() {
        return resultadoCuota;
    }

    public LinkedList<Double> getResultadoAmortizaciones() {
        return resultadoAmortizaciones;
    }

    public LinkedList<Double> getResultadoDeuda() {
        return resultadoDeuda;
    }

    public LinkedList<Double> getResultadoInteres() {
        return resultadoInteres;
    }

    public String getMoneda() {
        return moneda;
    }

    public Cliente getCliente() {
        return cliente;
    }

  
}