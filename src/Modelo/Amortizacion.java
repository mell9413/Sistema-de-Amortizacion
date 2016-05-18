package Modelo;

import java.util.*;

public abstract class Amortizacion {
    
    protected float montoPrestamo;
    protected int plazo;
    protected double interesAnual;
    protected double montoAmortizacion;
    protected double montoCuota;
    protected double montoInteresPeriodo;
    protected double montoDeuda;
//    protected Cliente cliente; OJOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!!!!!!!!!!!!!
    protected LinkedList<Double> resultadoCuota  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoAmortizaciones  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoDeuda  = new LinkedList<Double>();
    protected LinkedList<Double> resultadoInteres  = new LinkedList<Double>();

    public abstract void calcularDeuda();
    public abstract void calcularAmortizacion();
    public abstract void calcularInteresPeriodo();
    public abstract void calcularCuota();
    
//    public Amortizacion(DTOAmortizacion dtoAmortizacion) {
//        this.montoPrestamo = dtoAmortizacion.getMontoPrestamo();
//        this.plazo = dtoAmortizacion.getPlazo();
//        this.interesAnual = dtoAmortizacion.getInteresAnual();
//        this.cliente = dtoAmortizacion.getCliente();
//    }
    
    public Amortizacion(float montoPrestamo,int plazo,double interesAnual) {
        this.montoPrestamo = getMontoPrestamo();
        this.plazo = getPlazo();
        this.interesAnual = getInteresAnual();
  //      this.montoAmortizacion = getMontoAmortizacion();
  //  this.montoCuota = getMontoCuota();
   // this.montoDeuda = getMontoDeuda();
   // this.montoInteresPeriodo = getMontoInteresPeriodo();
  //  this.resultadoAmortizaciones = getResultadoAmortizaciones();
  //  this.resultadoCuota = getResultadoCuota();
 //   this.resultadoDeuda = getResultadoDeuda();
 //   this.resultadoInteres = getResultadoInteres();
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
    
    
}