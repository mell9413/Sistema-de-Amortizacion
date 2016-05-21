package Modelo;

import Modelo.*;
import DTO.*;
import Modelo.*;
import Modelo.Adaptador.*;
import Modelo.Bitacora.*;
import Vistas.VistaGUI;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Principal {
    
    public static void main(String[] args) throws IOException {
        IAdaptador adaptador = new ClientSocket();
        System.out.println(adaptador.obtenerResultado());
        IAdaptador adaptador2 = new WebServicesClientBCCR();
        System.out.println(adaptador2.obtenerResultado());
        
//        VistaGUI vista = new VistaGUI();
//        vista.setVisible(true);

//        DTOCliente dtoCliente = new DTOCliente(); 
//        
//        Cliente clt = new Cliente(dtoCliente);
//        
//        DTOAmortizacion dtoAmortizacion = new DTOAmortizacion();
//        dtoAmortizacion.SetMonto_prestamo(1000000);
//        dtoAmortizacion.SetPlazo(5);
//        dtoAmortizacion.SetInteres_anual(15);
//        dtoAmortizacion.setCliente(clt);
//        
//        dtoAmortizacion.SetTipoAmortizacion("Americano");
//                
//        FactoryAmortizacion factoryAmortizacion = new FactoryConcretoAmortizacion();
//        Amortizacion americano1 = factoryAmortizacion.crearAmortizacion(dtoAmortizacion);
//        americano1.obtenerResultados();
//		
//        System.out.println(dtoAmortizacion.GetTipoAmortizacion());
//        
//        System.out.println(americano1.getResultadoDeuda());
//        System.out.println(americano1.getResultadoCuota());
//        System.out.println(americano1.getResultadoInteres());
//        System.out.println(americano1.getResultadoAmortizaciones());

        
        Modelo.Bitacora.BitacoraXML bitacora = new BitacoraXML();
        bitacora.existeArchivo();
        bitacora.crearArchivo();
        
        Modelo.Bitacora.BitacoraCSV bitacora2 = new BitacoraCSV();
        bitacora2.existeArchivo();
    }
}
