package Modelo;

import java.io.IOException;


public class Principal {

	public static void main(String[] args) throws IOException {
            ServerSocket proceso = new ServerSocket();
            ClientSocket cliente = new ClientSocket();
            proceso.runBackEndChucky();            
            cliente.coneccionClientServer();
            System.out.print(cliente.getResult());
            proceso.killBackEndChucky();
	}
}
