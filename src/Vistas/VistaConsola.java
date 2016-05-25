package Vistas;

import Controladores.*;
import DTO.*;
import Data.Lector;
import Modelo.Factorys.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jdom2.JDOMException;

public class VistaConsola {
    
    private DTOCliente dtoCliente = new DTOCliente();
    private DTOAmortizacion dtoAmortizacion = new DTOAmortizacion();
    private  FactoryControlador factorycontrol = new FactoryConcretoControlador();
    
    Scanner entrada = new Scanner (System.in);
    String seleccion="";
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int tipoAmortizacion;
    private String nombreAmortizacion;
    private int tipoMoneda;
    private String nombreMoneda;
    private float montoPrestamo;
    private int plazo;
    private float interes;
    
    
    private void ingresarNombre(){
        System.out.println(">>> Por favor ingrese unicamente su Nombre:");
        nombre = entrada.nextLine();
        if (validarLetras(nombre)){
            ingresarPrimerApellido();
        }
        else{
            ingresarNombre();
        }
    }
    
    private void ingresarPrimerApellido(){
        System.out.println(">>> Por favor ingrese unicamente su Primer Apellido:");
        primerApellido = entrada.nextLine();
        if (validarLetras(primerApellido)){
            ingresarSegundoApellido();
        }
        else{
            ingresarPrimerApellido();
        }
    }
    
    private void ingresarSegundoApellido(){
        System.out.println(">>> Por favor ingrese unicamente su Segundo Apellido:");
        segundoApellido = entrada.nextLine();
        if (!validarLetras(segundoApellido)){
            ingresarSegundoApellido();
        }
    }
    
    private void ingresarServicio() throws IOException, JDOMException{
        System.out.println(">>> Por favor ingrese el numero correspondiente al Tipo de Amortización deseado:");
        ArrayList tiposAmortizacion = Lector.obtenerTiposAmortizaciones();
        int contador=0;
        for (Object tipo : tiposAmortizacion) {
            System.out.println(">>> " + ((contador++)+1) + ") ---> " + tipo);
        }
        seleccion = entrada.nextLine();
        try{
            if(validarNumeros(seleccion)){
                tipoAmortizacion = Integer.parseInt(seleccion);
                if (validarRango(tipoAmortizacion,contador)){
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
        catch(Exception ex){
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarServicio();
        }
        
    }
    
    private void ingresarMoneda() throws IOException, JDOMException{
        System.out.println(">>> Por favor ingrese el numero correspondiente al Tipo de Moneda en la que desea ver la Tabla:");
        ArrayList tiposAmortizacion = Lector.obtenerMonedas();
        int contador=0;
        for (Object tipo : tiposAmortizacion) {
            System.out.println(">>> " + ((contador++)+1) + ") ---> " + tipo);
        }
        seleccion = entrada.nextLine();
        try{
            if(validarNumeros(seleccion)){
                tipoMoneda = Integer.parseInt(seleccion);
                if (validarRango(tipoMoneda,contador)){
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
        catch(Exception ex){
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarMoneda();
        }

    }
    
    private void ingresarMonto(){
        System.out.println(">>> Por favor ingrese el Monto del Préstamo otorgado:");
        seleccion = entrada.nextLine();
        try{
            if(validarDouble(seleccion)){
                montoPrestamo = (float) Double.parseDouble(seleccion);
            }
            else{
                System.out.println(">>> Ingrese unicamente números, intente de nuevo");
                ingresarMonto();
            }
        }
        catch(Exception ex){
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarMonto();
        }

    }
    
    private void ingresarPlazo(){
        System.out.println(">>> Por favor ingrese el Plazo del Préstamo en años:");
        seleccion = entrada.nextLine();
        try{
            if(validarNumeros(seleccion)){
                plazo = Integer.parseInt(seleccion);
            }
            else{
                System.out.println(">>> Ingrese unicamente números enteros, intente de nuevo");
                ingresarPlazo();
            }
        }
        catch(Exception ex){
            System.out.println(">>> Ingrese unicamente números enteros, intente de nuevo");
            ingresarPlazo();
        }
        
    }
    
    private void ingresarInteres(){
        System.out.println(">>> Por favor ingrese el Interés Anual:");
        seleccion = entrada.nextLine();
        try{
            if(validarDouble(seleccion)){
                interes = Float.parseFloat(seleccion);
            }
            else{
                System.out.println(">>> Ingrese unicamente números, intente de nuevo");
                ingresarInteres();
            }
        }
        catch(Exception ex){
            System.out.println(">>> Ingrese unicamente números, intente de nuevo");
            ingresarInteres();
        }
        
    }
    
    private void enviarDatos(){
        dtoCliente.setNombre(nombre);
        dtoCliente.setPrimerApellido(primerApellido);
        dtoCliente.setSegundoApellido(segundoApellido);
        
        dtoAmortizacion.SetInteres_anual(interes);
        dtoAmortizacion.SetMonto_prestamo(montoPrestamo);
        dtoAmortizacion.SetPlazo(plazo);
        dtoAmortizacion.SetTipoAmortizacion(nombreAmortizacion);
        dtoAmortizacion.SetMoneda(nombreMoneda);        
    }
    
    private void mostrarResultados(){
        IControlador control = factorycontrol.crearControlador();
        control.consultarAmortizacion(dtoAmortizacion, dtoCliente);
        System.out.println("***** ***** ***** ***** *****");
        System.out.println("Tipo de cambio compra BCCR: "+control.obtenerTipoCambio());
        System.out.println("Datos de la consulta");
        System.out.println("Cliente: "+dtoAmortizacion.getCliente().getNombre()+" "+dtoAmortizacion.getCliente().getPrimerApellido()+" "+dtoAmortizacion.getCliente().getSegundoApellido());
        System.out.println("Monto del préstamo otorgado: "+dtoAmortizacion.GetMonto_prestamo()+" colones");
        System.out.println("Plazo del préstamo: "+dtoAmortizacion.GetPlazo()+" años");
        System.out.println("Interés anual: "+dtoAmortizacion.GetInteres_anual()+" %");
        System.out.println("Sistema de amortización: "+dtoAmortizacion.GetTipoAmortizacion()+"\n");
        System.out.println("Tabla de Amortización\n");
        System.out.println("Período\t\tDeuda inicial\t\tIntereses\t\tAmortización\t\tCuota\n");
        DecimalFormat decimales = new DecimalFormat("0.00");
        for (int i=0; i < dtoAmortizacion.GetPlazo(); i++){
            System.out.println((i+1)+"\t\t"+decimales.format(dtoAmortizacion.getResultadoDeuda().get(i))+"\t\t"+decimales.format(dtoAmortizacion.getResultadoInteres().get(i))+"\t\t"+decimales.format(dtoAmortizacion.getResultadoAmortizaciones().get(i))+"\t\t"+decimales.format(dtoAmortizacion.getResultadoCuota().get(i))); 
        }
        System.out.println("Total\t\t\t\t\t"+decimales.format(dtoAmortizacion.getResultadoInteres().getLast())+"\t\t"+decimales.format(dtoAmortizacion.getResultadoAmortizaciones().getLast())+"\t\t"+decimales.format(dtoAmortizacion.getResultadoCuota().getLast()));
        System.out.println(control.obtenerFechaBackEnd());
    }
    
    public void run() throws IOException, JDOMException{
        while(true){
            System.out.println("***** Sistema de Amortización *****");
            ingresarNombre();
            ingresarServicio();
            ingresarMoneda();
            ingresarMonto();
            ingresarPlazo();
            ingresarInteres();
            enviarDatos();
            mostrarResultados();
            entrada.nextLine();
        }
    }
    
    private boolean validarLetras(String palabra){
        Pattern pat = Pattern.compile("([a-z]|[A-Z]|\\\\s)+");
        Matcher mat = pat.matcher(palabra);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validarNumeros(String dato){
        Pattern pat = Pattern.compile("[0-9]*");
        Matcher mat = pat.matcher(dato);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validarDouble(String dato){
        Pattern pat = Pattern.compile("([0-9]*|[.]|\\\\s)+");
        Matcher mat = pat.matcher(dato);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validarRango(int seleccion, int largo){
        if(seleccion != 0 && seleccion <=largo){
            return true;
        }
        else{
            return false;
        }
    }
}
