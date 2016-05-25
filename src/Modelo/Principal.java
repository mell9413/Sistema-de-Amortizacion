package Modelo;

import Vistas.*;
import java.io.IOException;
import org.jdom2.JDOMException;


public class Principal {
    
    public static void main(String[] args) throws IOException, JDOMException {
        
        VistaGUI vista = new VistaGUI();
        vista.setVisible(true);
        
//        VistaConsola consola = new VistaConsola();
//        consola.run();
        
    }
}
