/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DTO.DTOAmortizacion;
import Modelo.*;



/**
 *
 * @author Marianne
 */
public class FactoryConcretoAmortizacion extends FactoryAmortizacion{

    @Override
    public Amortizacion crearAmortizacion(DTOAmortizacion dtoAmortizacion) {
       
        int tipoAmortizacion=0;
        String valor  = dtoAmortizacion.GetTipoAmortizacion();
        if(valor == "ALEMAN"){
            tipoAmortizacion=1;
        }
        if(valor == "FRANCES"){
            tipoAmortizacion=2;
        }
        if(valor == "AMERICANO"){
            tipoAmortizacion=3;
        }
        switch (tipoAmortizacion){
            
            case 1: 
                Amortizacion amortizacionAlemana = new Aleman(dtoAmortizacion);
                return amortizacionAlemana;    
            case 2:
                Amortizacion amortizacionFrancesa = new Frances(dtoAmortizacion);     
                return amortizacionFrancesa;
            case 3:
                Amortizacion amortizacionAmericana = new Americano(dtoAmortizacion);
                return amortizacionAmericana;
        }
        
        return null;
    }
    
}
