package Controladores;

import DTO.DTOAmortizacion;
import DTO.DTOCliente;
import Modelo.Adaptador.*;
import Modelo.Amortizacion;
import Modelo.Bitacora.*;
import Modelo.Cliente;
import Modelo.Factorys.*;
import java.util.ArrayList;

public class Controlador implements IControlador{
    
    private FactoryAmortizacion factoryAmortizacion;
    private FactoryCliente factoryCliente;
    private ArrayList factoryIEscritor;
    private ArrayList factoryAdaptador;
                    
    public Controlador(){
        this.factoryAmortizacion = new FactoryConcretoAmortizacion();
        this.factoryCliente = new FactoryConcretoCliente();
        this.factoryIEscritor = new ArrayList();
        this.factoryIEscritor.add(new FactoryConcretoBitacora().crearBitacora("BitacoraCSV"));
        this.factoryIEscritor.add(new FactoryConcretoBitacora().crearBitacora("BitacoraXML"));
        this.factoryAdaptador = new ArrayList();
        this.factoryIEscritor.add(new FactoryConcretoBitacora().crearBitacora("WebServicesClientBCCR"));
        this.factoryIEscritor.add(new FactoryConcretoBitacora().crearBitacora("ClientSocket"));
    }

    @Override
    public void registrarBitacora(DTOAmortizacion dtoAmortizacion) {
        IEscritor elemnt;
        for (Object factoryIEscritor1 : factoryIEscritor) {
            elemnt = (IEscritor) factoryIEscritor1;
            elemnt.escribirMovimiento(dtoAmortizacion);
        }
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
        IAdaptador backEnd= (IAdaptador) factoryAdaptador.get(0);
        return backEnd.obtenerResultado();
    }
    
}
