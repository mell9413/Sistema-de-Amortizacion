/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Factorys;

import Controladores.IControlador;
import DTO.DTOCliente;
import Modelo.Cliente;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mellvin
 */
public class FactoryConcretoControlador implements FactoryControlador{

    @Override
    public IControlador crearControlador() {
        try {
            Class controlador = Class.forName("Controladores.Controlador");
            Constructor constructor;
            constructor = controlador.getConstructor();            
            IControlador control = (IControlador)constructor.newInstance();
            return control;
        } catch (Exception ex) {
            Logger.getLogger(FactoryConcretoAmortizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
