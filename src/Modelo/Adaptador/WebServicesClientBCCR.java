package Modelo.Adaptador;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class WebServicesClientBCCR implements IAdaptador{

    private String tipoCambio;
    private String fechaActual;
    
    @Override
    public void conectarseServidor() {
        try {
            cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos cliente = new cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos();
            tipoCambio = cliente.getWsIndicadoresEconomicosSoap().obtenerIndicadoresEconomicosXML("317", getFechaActual(), getFechaActual(), "Mell", "N");
            tipoCambio = tipoCambio.substring(196,204);
        }
        catch(Exception ex){
            tipoCambio = "No se ha podido conectar con el servidor";
        }
        
    }

    @Override
    public String obtenerResultado() {
        conectarseServidor();
        return tipoCambio;
    }
    
    private String getFechaActual() {
        Calendar fecha = new GregorianCalendar();
        String fechaActual = Integer.toString(fecha.get(Calendar.DATE))+"/"+((fecha.get(Calendar.MONTH))+1)+"/"+fecha.get(Calendar.YEAR);
        return fechaActual;
    }
}
