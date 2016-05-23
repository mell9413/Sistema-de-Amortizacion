package Modelo;

import Modelo.*;
import DTO.*;
import Data.Lector;
import Modelo.*;
import Modelo.Adaptador.*;
import Modelo.Bitacora.*;
import Modelo.Factorys.*;
import Validaciones.Validar;
import Vistas.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.jdom2.JDOMException;


public class Principal {
    
    public static void main(String[] args) throws IOException, JDOMException {
//        IAdaptador adaptador = new ClientSocket();
//        System.out.println(adaptador.obtenerResultado());
//        IAdaptador adaptador2 = new WebServicesClientBCCR();
//        System.out.println(adaptador2.obtenerResultado());
//        
//        VistaGUI vista = new VistaGUI();
//        vista.setVisible(true);

        DTOCliente dtoCliente = new DTOCliente(); 
//        
        Cliente clt = new Cliente(dtoCliente);
        
//        
        DTOAmortizacion dtoAmortizacion = new DTOAmortizacion();
        dtoAmortizacion.SetMonto_prestamo(1000000);
        dtoAmortizacion.SetPlazo(5);
        dtoAmortizacion.SetInteres_anual(15);
        dtoAmortizacion.setCliente(clt);
        
        dtoAmortizacion.SetTipoAmortizacion("Americano");
                
        FactoryAmortizacion factoryAmortizacion = new FactoryConcretoAmortizacion();
        Amortizacion americano1 = factoryAmortizacion.crearAmortizacion(dtoAmortizacion);
        americano1.obtenerResultados();
//		
//        System.out.println(dtoAmortizacion.GetTipoAmortizacion());
//        
//        System.out.println(americano1.getResultadoDeuda());
//        System.out.println(americano1.getResultadoCuota());
//        System.out.println(americano1.getResultadoInteres());
//        System.out.println(americano1.getResultadoAmortizaciones());

        
        IEscritor bitacora = new BitacoraCSV();
        bitacora.crearArchivo();
        bitacora.escribirMovimiento(dtoAmortizacion);
//        
//        IEscritor bitacora2 = new BitacoraCSV();
//        bitacora2.existeArchivo();
        
     //   VistaConsola consola = new VistaConsola();
     //   consola.run();
    }
}
