package Vistas;

import Data.Lector;
import Validaciones.Validar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jdom2.JDOMException;

public class VistaConsola {
    
    Scanner entrada = new Scanner (System.in);
    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public int tipoAmortizacion;
    public String nombreAmortizacion;
    
    public void ingresarNombre(){
        System.out.println(">>> Por favor ingrese unicamente su Nombre:");
        nombre = entrada.nextLine();
        if (Validar.validarLetras(nombre)){
            ingresarPrimerApellido();
        }
        else{
            ingresarNombre();
        }
    }
    
    public void ingresarPrimerApellido(){
        System.out.println(">>> Por favor ingrese unicamente su Primer Apellido:");
        primerApellido = entrada.nextLine();
        if (Validar.validarLetras(primerApellido)){
            ingresarSegundoApellido();
        }
        else{
            ingresarPrimerApellido();
        }
    }
    
    public void ingresarSegundoApellido(){
        System.out.println(">>> Por favor ingrese unicamente su Segundo Apellido:");
        segundoApellido = entrada.nextLine();
        if (!Validar.validarLetras(segundoApellido)){
            ingresarSegundoApellido();
        }
    }
    
    public void ingresarServicio() throws IOException, JDOMException{
        System.out.println(">>> Por favor ingrese el numero correspondiente al Tipo de Amortización deseado:");
        ArrayList tiposAmortizacion = Lector.obtenerTiposAmortizaciones();
        int contador=0;
        for (Object tipo : tiposAmortizacion) {
            System.out.println(">>> " + ((contador++)+1) + ") ---> " + tipo);
        }
        String seleccion = entrada.nextLine();
        if(Validar.validarNumeros(seleccion)){
            tipoAmortizacion = Integer.parseInt(seleccion);
            if (Validar.validarRango(tipoAmortizacion,contador)){
                nombreAmortizacion = tiposAmortizacion.get(tipoAmortizacion-1).toString();
            }
            else{
                System.out.println(">>> El numero ingresado esta fuera del rango de los tipos de Amortizacion disponibles, intente de nuevo");
                ingresarServicio();
            }
        }
        else{
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarServicio();
        }
    }
    
    public void run() throws IOException, JDOMException{
        //while(true){
            System.out.println("***** Sistema de Amortización *****");
            ingresarNombre();
            ingresarServicio();
        //}
    }
}
