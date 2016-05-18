
package Modelo;
import java.io.*;

public class ServerSocket {
    Process pr;
    Runtime rt = Runtime.getRuntime();
    File direccion = new File (".");
    
    public void runBackEndChucky () throws IOException {        
        String pythonScriptPath = direccion.getCanonicalPath()+"\\src\\Modelo\\BackEndChucky.py";
        String[] cmd = new String[2];
        cmd[0] = "C:\\Python27\\python.exe";
        cmd[1] = pythonScriptPath;    
        pr= rt.exec(cmd);
    }
    
    public void killBackEndChucky (){
        pr.destroy();
    }
}
