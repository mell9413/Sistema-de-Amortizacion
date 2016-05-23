/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bitacora;

import DTO.DTOAmortizacion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marianne
 */
public class BitacoraCSV implements IEscritor{
    
    private static String nombreArchivo;
    
    public BitacoraCSV(){
         nombreArchivo = "bitacoraCSV.csv";
    }

    @Override
    public void crearArchivo() {
        
           String nombreArchivo2 = "C:\\Users\\Marianne\\Downloads\\ya.csv.";
        if (existeArchivo() == false)
         
            try {
             FileWriter file = new FileWriter(nombreArchivo2);   
            //FileWriter file = new FileWriter(BitacoraCSV.nombreArchivo);
            file.write('\ufeff');
            file.append("Sistema de amortizacion \n");
            file.close();
        } catch (IOException ex) {
            
        }
    }

    @Override
    public boolean existeArchivo() {
        String sfichero = "C:\\Users\\Marianne\\Downloads\\ya.csv.";
        File fichero = new File(sfichero);
        
        if (fichero.exists()){
            return true ;
            
        }
        else{
            System.out.println("soy yo");
            return false;
        }
    }

    @Override
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion) {
            String nombreArchivo2 = "C:\\Users\\Marianne\\Downloads\\ya.csv.";

        if (existeArchivo()){
        try {
               FileWriter file = new FileWriter(nombreArchivo2);
            //FileWriter file = new FileWriter(BitacoraCSV.nombreArchivo,true);
             file.append("Bitacora de transacciones \n");
             file.append("Tipo de amortizacion:  " + dtoAmortizacion.GetTipoAmortizacion() + "\n");
             file.append("Nombre cliente:  " + dtoAmortizacion.getCliente()+ "\n");
             file.append("Monto prestamo:  " + String.valueOf(dtoAmortizacion.GetMonto_prestamo())+ "\n");
             file.append("Plazo prestamo:  " + String.valueOf(dtoAmortizacion.GetPlazo())+ "\n");
             file.append("Interes anual:  " + String.valueOf(dtoAmortizacion.GetInteres_anual())+ "\n");
             file.append("Moneda:  " + dtoAmortizacion.GetMoneda()+ "\n");
             file.flush();
             file.close();
             
             
        } catch (IOException ex) {
         
        }
       
    }}
    
}
