package Modelo;

import Vistas.VistaGUI;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Principal {

    private String obtenerTipoCambio(){       
        Calendar fecha = new GregorianCalendar();
        String fechaActual = Integer.toString(fecha.get(Calendar.DATE))+"/"+((fecha.get(Calendar.MONTH))+1)+"/"+fecha.get(Calendar.YEAR);
        cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos cliente = new cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos();
        String tipoCambio = cliente.getWsIndicadoresEconomicosSoap().obtenerIndicadoresEconomicosXML("317", fechaActual, fechaActual, "Mell", "N");
        tipoCambio = tipoCambio.substring(196,204);
        return tipoCambio;
    }
    
    public static void main(String[] args) throws IOException {
//        ServerSocket proceso = new ServerSocket();
//        ClientSocket cliente = new ClientSocket();
//        proceso.runBackEndChucky();            
//        cliente.coneccionClientServer();
//        System.out.print(cliente.getResult());
//        proceso.killBackEndChucky();
   
        Amortizacion alemana1 = new Aleman(1000000,5,15);

        alemana1.calcularAmortizacion();
        alemana1.calcularDeuda();
        alemana1.calcularInteresPeriodo();
        alemana1.calcularCuota();

        Amortizacion  frances1 = new Frances(1000000,5,15);
        frances1.calcularCuota();
        frances1.calcularAmortizacion();
        frances1.calcularDeuda();
        frances1.calcularInteresPeriodo();

        Amortizacion  americano1 = new Americano (1000000,5,15);
        americano1.calcularInteresPeriodo();
        americano1.calcularCuota();
        americano1.calcularAmortizacion();
        americano1.calcularDeuda();
		
        System.out.println("ALEMANA");
        System.out.println(alemana1.getResultadoDeuda());
        System.out.println(alemana1.getResultadoCuota());
        System.out.println(alemana1.getResultadoInteres());
        System.out.println(alemana1.getResultadoAmortizaciones());
        
        System.out.println("Frances");
        System.out.println(frances1.getResultadoDeuda());
        System.out.println(frances1.getResultadoCuota());
        System.out.println(frances1.getResultadoInteres());
        System.out.println(frances1.getResultadoAmortizaciones());
        
        System.out.println("AMERICANA");
        System.out.println(americano1.getResultadoDeuda());
        System.out.println(americano1.getResultadoCuota());
        System.out.println(americano1.getResultadoInteres());
        System.out.println(americano1.getResultadoAmortizaciones());
        
        VistaGUI vista = new VistaGUI();
        vista.setVisible(true);
    }
}
