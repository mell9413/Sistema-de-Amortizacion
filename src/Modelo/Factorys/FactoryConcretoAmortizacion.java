package Modelo.Factorys;

import Modelo.Factorys.FactoryAmortizacion;
import DTO.DTOAmortizacion;
import Modelo.*;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoryConcretoAmortizacion extends FactoryAmortizacion{

    @Override
    public Amortizacion crearAmortizacion(DTOAmortizacion dtoAmortizacion) {
        try {
            Class amortizacion = Class.forName("Modelo." + dtoAmortizacion.GetTipoAmortizacion());
            Constructor constructor;
            Class[] dto = new Class[1];
            dto[0]= DTOAmortizacion.class;
            constructor = amortizacion.getConstructor(dto);            
            Amortizacion tipoAmortizacion = (Amortizacion)constructor.newInstance(dtoAmortizacion);
            return tipoAmortizacion;
        } catch (Exception ex) {
            Logger.getLogger(FactoryConcretoAmortizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
