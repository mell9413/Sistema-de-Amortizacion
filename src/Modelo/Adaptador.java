package Modelo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Adaptador {
    
    private final static Adaptador instancia = new Adaptador();
    
    private Process backEndChuky;    
    private String host;
    private int puerto;
    private Socket socketClientChuky;
    private String resultadoBackEndChuky;
    private String tipoCambio;
    private String fechaActual;

    private Adaptador(){}
    
    public static Adaptador getInstancia(){
        return instancia;
    }
    
    public void runBackEndChucky () throws IOException {        
        String pythonScriptPath = (new File (".")).getCanonicalPath()+"\\src\\Modelo\\BackEndChucky.py";
        String[] cmd = new String[2];
        cmd[0] = "C:\\Python27\\python.exe";
        cmd[1] = pythonScriptPath;    
        backEndChuky= Runtime.getRuntime().exec(cmd);
    }
    
    public void killBackEndChucky (){
        backEndChuky.destroy();
    }
    
    private void coneccionClientServer() throws IOException{
        try{
            host = "localhost";
            puerto = 8666;
            socketClientChuky = new Socket(host,puerto);
            int c;
            InputStream inputSocket = socketClientChuky.getInputStream();
            OutputStream outputSocket = socketClientChuky.getOutputStream();
            String str = "";
            byte buf[] = str.getBytes();
            outputSocket.write(buf);
            resultadoBackEndChuky = "";
            while ((c = inputSocket.read()) != -1) {
              resultadoBackEndChuky += (char) c;
            }            
            socketClientChuky.close();
        }
        catch(Exception e ){
            System.out.println("Error: "+e.getMessage());
            socketClientChuky.close();
            resultadoBackEndChuky = null;
        }
    }
    
    public String getResultadoBackEndChuky() throws IOException {
        coneccionClientServer();
        return resultadoBackEndChuky;
    }
    
    private String obtenerTipoCambio(){
        cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos cliente = new cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos();
        tipoCambio = cliente.getWsIndicadoresEconomicosSoap().obtenerIndicadoresEconomicosXML("317", getFechaActual(), getFechaActual(), "Mell", "N");
        tipoCambio = tipoCambio.substring(196,204);
        return tipoCambio;
    }

    public String getTipoCambio() {
        obtenerTipoCambio();
        return tipoCambio;
    }

    private String getFechaActual() {
        Calendar fecha = new GregorianCalendar();
        String fechaActual = Integer.toString(fecha.get(Calendar.DATE))+"/"+((fecha.get(Calendar.MONTH))+1)+"/"+fecha.get(Calendar.YEAR);
        return fechaActual;
    }
    
    
}
