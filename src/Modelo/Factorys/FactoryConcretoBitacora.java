/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Factorys;

import Modelo.Bitacora.IEscritor;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mellvin
 */
public class FactoryConcretoBitacora extends FactoryIEscritor{

    @Override
    public IEscritor crearBitacora(String tipoBitacora) {
        try {
            Class bitacora = Class.forName("Modelo.Bitacora."+tipoBitacora);
            Constructor constructor;
            constructor = bitacora.getConstructor();            
            IEscritor bit = (IEscritor)constructor.newInstance();
            return bit;
        } catch (Exception ex) {
            Logger.getLogger(FactoryConcretoAmortizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
