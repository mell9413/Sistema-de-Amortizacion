/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DTO.*;
import Modelo.*;

/**
 *
 * @author Mellvin
 */
public interface IControlador {
    public void registrarBitacora(DTOAmortizacion dtoAmortizacion);
    public Amortizacion crearAmortizacion(DTOAmortizacion dtoAmortizacion);
    public Cliente crearCliente(DTOCliente dtoCliente);
    public void consultarAmortizacion(DTOAmortizacion dtoAmortizacion,DTOCliente dtoCliente);
    public String obtenerTipoCambio ();
    public String obtenerFechaBackEnd();
    public void cambioMoneda(DTOAmortizacion dtoAmortizacion);
}
