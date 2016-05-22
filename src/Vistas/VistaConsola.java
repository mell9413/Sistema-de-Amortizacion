package Vistas;

import Data.Lector;
import Validaciones.Validar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jdom2.JDOMException;

public class VistaConsola {
    
    Scanner entrada = new Scanner (System.in);
    String seleccion="";
    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public int tipoAmortizacion;
    public String nombreAmortizacion;
    public int tipoMoneda;
    public String nombreMoneda;
    public double montoPrestamo;
    public int plazo;
    public float interes;
    
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
        seleccion = entrada.nextLine();
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
    
    public void ingresarMoneda() throws IOException, JDOMException{
        System.out.println(">>> Por favor ingrese el numero correspondiente al Tipo de Moneda:");
        ArrayList tiposAmortizacion = Lector.obtenerMonedas();
        int contador=0;
        for (Object tipo : tiposAmortizacion) {
            System.out.println(">>> " + ((contador++)+1) + ") ---> " + tipo);
        }
        seleccion = entrada.nextLine();
        if(Validar.validarNumeros(seleccion)){
            tipoMoneda = Integer.parseInt(seleccion);
            if (Validar.validarRango(tipoMoneda,contador)){
                nombreMoneda = tiposAmortizacion.get(tipoMoneda-1).toString();
            }
            else{
                System.out.println(">>> El numero ingresado esta fuera del rango de los tipos de Monedas disponibles, intente de nuevo");
                ingresarMoneda();
            }
        }
        else{
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarMoneda();
        }
    }
    
    public void ingresarMonto(){
        System.out.println(">>> Por favor ingrese el Monto del Préstamo otorgado:");
        seleccion = entrada.nextLine();
        if(Validar.validarDouble(seleccion)){
            montoPrestamo = Double.parseDouble(seleccion);
        }
        else{
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarMonto();
        }
    }
    
    public void ingresarPlazo(){
        System.out.println(">>> Por favor ingrese el Plazo del Préstamo en años:");
        seleccion = entrada.nextLine();
        if(Validar.validarNumeros(seleccion)){
            plazo = Integer.parseInt(seleccion);
        }
        else{
            System.out.println(">>> Ingrese unicamente números enteros, intente de nuevo");
            ingresarPlazo();
        }
    }
    
    public void ingresarInteres(){
        System.out.println(">>> Por favor ingrese el Interés Anual:");
        seleccion = entrada.nextLine();
        if(Validar.validarDouble(seleccion)){
            interes = Float.parseFloat(seleccion);
        }
        else{
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarInteres();
        }
    }
    
    public void run() throws IOException, JDOMException{
        //while(true){
            System.out.println("***** Sistema de Amortización *****");
            ingresarNombre();
            ingresarServicio();
            ingresarMoneda();
            ingresarMonto();
            ingresarPlazo();
            ingresarInteres();
        //}
    }
}
