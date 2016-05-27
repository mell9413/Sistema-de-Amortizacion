package Modelo.Adaptador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientSocket implements IAdaptador {
    
    private Process backEndChuky;    
    private String host;
    private int puerto;
    private Socket socketClientChuky;
    private String resultadoBackEndChuky;

    @Override
    public void conectarseServidor() {
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
            resultadoBackEndChuky = "No se ha podido conectar con el servidor";
        }
    }

    @Override
    public String obtenerResultado() {
        try {
            runBackEndChucky ();
            conectarseServidor();
            killBackEndChucky ();
            return resultadoBackEndChuky;
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void runBackEndChucky () throws IOException {        
        String pythonScriptPath = (new File (".")).getCanonicalPath()+"\\src\\Modelo\\BackEndChucky.py";
        String[] cmd = new String[2];
        cmd[0] = "C:\\Python27\\python.exe";
        cmd[1] = pythonScriptPath;    
        backEndChuky= Runtime.getRuntime().exec(cmd);
    }
    
    private void killBackEndChucky (){
        backEndChuky.destroy();
    }
}
