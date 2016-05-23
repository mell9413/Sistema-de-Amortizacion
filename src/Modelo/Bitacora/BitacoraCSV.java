/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bitacora;

import DTO.DTOAmortizacion;
import Data.Lector;
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
    
    private static String nombreArchivo = "bitacoraCSV.csv";
    

    @Override
    public void crearArchivo() {
        if (existeArchivo() == false)
            try {
                FileWriter file = new FileWriter(Lector.obtenerRutaCarpeta()+nombreArchivo,true);
                file.write('\ufeff');
                file.append("Sistema de amortizacion \n");
                file.close();
            } catch (Exception ex) {

            }
    }

    @Override
    public boolean existeArchivo() {
        try {
            File fichero = new File(Lector.obtenerRutaCarpeta()+nombreArchivo);
            if (fichero.exists()){
                return true ;
            }
            else{
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(BitacoraCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion) {
        if (existeArchivo()){
            try {                
                FileWriter file = new FileWriter(Lector.obtenerRutaCarpeta()+nombreArchivo,true);
                file.append("Bitacora de transacciones \n");
                file.append("Tipo de amortizacion:  " + dtoAmortizacion.GetTipoAmortizacion() + "\n");
                file.append("Nombre cliente:  " + dtoAmortizacion.getCliente().getNombre()+" "+dtoAmortizacion.getCliente().getPrimerApellido()+" "+dtoAmortizacion.getCliente().getSegundoApellido()+ "\n");
                file.append("Monto prestamo:  " + String.valueOf(dtoAmortizacion.GetMonto_prestamo())+ "\n");
                file.append("Plazo prestamo:  " + String.valueOf(dtoAmortizacion.GetPlazo())+ "\n");
                file.append("Interes anual:  " + String.valueOf(dtoAmortizacion.GetInteres_anual())+ "\n");
                file.append("Moneda:  " + dtoAmortizacion.GetMoneda()+ "\n");
                file.flush();
                file.close();
            } catch (Exception ex) {
            }
        }
        else{
            crearArchivo();
            escribirMovimiento(dtoAmortizacion);
        }
    }
    
}
