package Modelo;

import java.net.*;
import java.io.*;

public class ClientSocket {
    final String HOST = "localhost";
    final int PUERTO=8666;
    Socket socketClient;
    String result ="";

    public void coneccionClientServer() throws IOException{
        try{
            socketClient = new Socket( HOST , PUERTO );
            int c;
            InputStream inputSocket = socketClient.getInputStream();
            OutputStream outputSocket = socketClient.getOutputStream();
            String str = "";
            byte buf[] = str.getBytes();
            outputSocket.write(buf);            
            while ((c = inputSocket.read()) != -1) {
              result += (char) c;
            }            
            socketClient.close();
        }
        catch(Exception e ){
            System.out.println("Error: "+e.getMessage());
            socketClient.close();
        }
    }
    
    public String getResult() {
        return result;
    }
}
