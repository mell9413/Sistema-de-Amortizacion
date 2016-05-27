package Controladores;

import DTO.DTOAmortizacion;
import DTO.DTOCliente;
import Modelo.Adaptador.*;
import Modelo.Amortizacion;
import Modelo.Bitacora.*;
import Modelo.Cliente;
import Modelo.Factorys.*;
import Observador.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Controlador implements IControlador{
    
    private static IControlador instancia = new Controlador();
    private FactoryAmortizacion factoryAmortizacion;
    private FactoryCliente factoryCliente;
    private ISubject subject;
    private ArrayList factoryAdaptador;
         
    public static IControlador getInstancia(){
        return instancia;
    }
    
    private Controlador(){
        this.factoryAmortizacion = new FactoryConcretoAmortizacion();
        this.factoryCliente = new FactoryConcretoCliente();
        this.subject = new Subject();
        this.factoryAdaptador = new ArrayList();
        this.factoryAdaptador.add(new FactoryConcretoAdaptador().crearAdaptador("WebServicesClientBCCR"));
        this.factoryAdaptador.add(new FactoryConcretoAdaptador().crearAdaptador("ClientSocket"));
        new BitacoraCSV((Subject) subject);
        new BitacoraXML((Subject) subject);
    }

    @Override
    public void registrarBitacora(DTOAmortizacion dtoAmortizacion) {
        subject.setSubjectState(dtoAmortizacion);
    }

    @Override
    public Amortizacion crearAmortizacion(DTOAmortizacion dtoAmortizacion) {
        return factoryAmortizacion.crearAmortizacion(dtoAmortizacion);
    }

    @Override
    public Cliente crearCliente(DTOCliente dtoCliente) {
        return factoryCliente.crearCliente(dtoCliente);
    }

    @Override
    public void consultarAmortizacion(DTOAmortizacion dtoAmortizacion, DTOCliente dtoCliente) {
        Amortizacion amortizacion = crearAmortizacion(dtoAmortizacion);
        Cliente cliente = crearCliente(dtoCliente);
        dtoAmortizacion.setCliente(cliente);
        amortizacion.obtenerResultados();
        dtoAmortizacion.setResultadoAmortizaciones(amortizacion.getResultadoAmortizaciones());
        dtoAmortizacion.setResultadoCuota(amortizacion.getResultadoCuota());
        dtoAmortizacion.setResultadoDeuda(amortizacion.getResultadoDeuda());
        dtoAmortizacion.setResultadoInteres(amortizacion.getResultadoInteres());
        registrarBitacora(dtoAmortizacion);
    }

    @Override
    public String obtenerTipoCambio() {
        IAdaptador webServices= (IAdaptador) factoryAdaptador.get(0);
        return webServices.obtenerResultado();
    }

    @Override
    public String obtenerFechaBackEnd() {
        IAdaptador backEnd= (IAdaptador) factoryAdaptador.get(1);
        return backEnd.obtenerResultado();
    }    

    @Override
    public void cambioMoneda(DTOAmortizacion dtoAmortizacion, double tipoCambio) {
        LinkedList<Double> temporalCouta = new LinkedList<Double>();
        LinkedList<Double> temporalAmortizacion = new LinkedList<Double>();
        LinkedList<Double> temporalDeuda = new LinkedList<Double>();
        LinkedList<Double> temporalInteres = new LinkedList<Double>();
        for(int i = 0; i<=dtoAmortizacion.GetPlazo();i++){
            if(i==dtoAmortizacion.GetPlazo()){
                temporalCouta.addLast(tipoCambio * dtoAmortizacion.getResultadoCuota().getLast());
                temporalAmortizacion.addLast(tipoCambio * dtoAmortizacion.getResultadoAmortizaciones().getLast());
                temporalInteres.addLast(tipoCambio * dtoAmortizacion.getResultadoInteres().getLast());
            }
            else{    
                temporalCouta.add(tipoCambio * dtoAmortizacion.getResultadoCuota().get(i));
                temporalAmortizacion.add(tipoCambio * dtoAmortizacion.getResultadoAmortizaciones().get(i));
                temporalDeuda.add(tipoCambio * dtoAmortizacion.getResultadoDeuda().get(i));
                temporalInteres.add(tipoCambio * dtoAmortizacion.getResultadoInteres().get(i));
            }
        }
        dtoAmortizacion.setResultadoAmortizaciones(temporalAmortizacion);
        dtoAmortizacion.setResultadoCuota(temporalCouta);
        dtoAmortizacion.setResultadoDeuda(temporalDeuda);
        dtoAmortizacion.setResultadoInteres(temporalInteres);
    }
}
