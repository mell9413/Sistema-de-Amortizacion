
package Modelo;
import java.io.*;

public class AdaptadorBackEnd {
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
    
    public String getFechaSistema () throws IOException {
        String pythonScriptPath = direccion.getCanonicalPath()+"\\src\\Modelo\\clientSocket.py";
        String[] cmd = new String[2];
        cmd[0] = "C:\\Python27\\python.exe";
        cmd[1] = pythonScriptPath;
        Process process = Runtime.getRuntime().exec(cmd);
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));  
        String line = line = in.readLine()+"\n";  
        return line;
        
    }
}
