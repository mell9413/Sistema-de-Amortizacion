/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bitacora;

import DTO.DTOAmortizacion;

/**
 *
 * @author Marianne
 */
public class BitacoraXML implements iEscritor{
    
    private static String nombreArchivo;
    
    public BitacoraXML(){
         nombreArchivo = "bitacoraXML.xml";
    }

    @Override
    public void crearArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
