/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Factorys;

import Modelo.Adaptador.IAdaptador;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mellvin
 */
public class FactoryConcretoAdaptador extends FactoryAdaptador{

    @Override
    public IAdaptador crearAdaptador(String tipoAdaptador) {
        try {
            Class adaptador = Class.forName("Modelo.Adaptador."+tipoAdaptador);
            Constructor constructor;
            constructor = adaptador.getConstructor();            
            IAdaptador adapter = (IAdaptador)constructor.newInstance();
            return adapter;
        } catch (Exception ex) {
            Logger.getLogger(FactoryConcretoAmortizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}