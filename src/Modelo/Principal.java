package Modelo;

import DTO.*;
import Factory.*;
import Modelo.Bitacora.BitacoraCSV;
import Modelo.Bitacora.BitacoraXML;
import Vistas.VistaGUI;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Principal {
    
    public static void main(String[] args) throws IOException {
//        Adaptador adaptador = Adaptador.getInstancia();
//        adaptador.runBackEndChucky();      
//        System.out.println(adaptador.getResultadoBackEndChuky());
//        adaptador.killBackEndChucky();
//        System.out.println(adaptador.getTipoCambio());
//        System.out.println(adaptador.getResultadoBackEndChuky());
        
//        VistaGUI vista = new VistaGUI();
//        vista.setVisible(true);
        
  /*      DTOCliente dtoCliente = new DTOCliente(); 
        
        Cliente clt = new Cliente(dtoCliente);
        
        DTOAmortizacion dtoAmortizacion = new DTOAmortizacion();
        dtoAmortizacion.SetMonto_prestamo(1000000);
        dtoAmortizacion.SetPlazo(5);
        dtoAmortizacion.SetInteres_anual(15);
        dtoAmortizacion.setCliente(clt);
        
        dtoAmortizacion.SetTipoAmortizacion("Americano");
                
        FactoryAmortizacion factoryAmortizacion = new FactoryConcretoAmortizacion();
        Amortizacion americano1 = factoryAmortizacion.crearAmortizacion(dtoAmortizacion);
        americano1.obtenerResultados();
		
        System.out.println(dtoAmortizacion.GetTipoAmortizacion());
        
        System.out.println(americano1.getResultadoDeuda());
        System.out.println(americano1.getResultadoCuota());
        System.out.println(americano1.getResultadoInteres());
        System.out.println(americano1.getResultadoAmortizaciones());*/
        
        Modelo.Bitacora.BitacoraXML bitacora = new BitacoraXML();
        bitacora.existeArchivo();
        bitacora.crearArchivo();
        
        Modelo.Bitacora.BitacoraCSV bitacora2 = new BitacoraCSV();
        bitacora2.existeArchivo();
    }
}
