/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Factorys;

import DTO.DTOCliente;
import Modelo.Cliente;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mellvin
 */
public class FactoryConcretoCliente extends FactoryCliente{

    @Override
    public Cliente crearCliente(DTOCliente dtoCliente) {
        try {
            Class cliente = Class.forName("Modelo.Cliente");
            Constructor constructor;
            Class[] dto = new Class[1];
            dto[0]= DTOCliente.class;
            constructor = cliente.getConstructor(dto);            
            Cliente clt = (Cliente)constructor.newInstance(dtoCliente);
            return clt;
        } catch (Exception ex) {
            Logger.getLogger(FactoryConcretoAmortizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
