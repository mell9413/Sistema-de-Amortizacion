/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bitacora;


import DTO.DTOAmortizacion;

/**
 *
 * @author Marianne
 */
public interface iEscritor {
    
    public void crearArchivo();
     public boolean existeArchivo();
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion);
    
    
    
}
