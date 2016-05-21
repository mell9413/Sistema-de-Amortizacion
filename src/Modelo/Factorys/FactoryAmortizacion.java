/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Factorys;

import DTO.DTOAmortizacion;
import Modelo.Amortizacion;

/**
 *
 * @author Marianne
 */
public abstract class FactoryAmortizacion {
    
   public abstract Amortizacion crearAmortizacion(DTOAmortizacion dtoAmortizacion);
    
}
