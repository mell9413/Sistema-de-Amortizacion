/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bitacora;

import DTO.DTOAmortizacion;
import java.io.File;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeArchivo() {
        String sfichero = "C:\\Users\\Marianne\\Downloads\\ya.csv.";
        File fichero = new File(sfichero);
        
        if (fichero.exists()){
            return true ;
            
        }
        else{
            return false;
        }
    }

    @Override
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
