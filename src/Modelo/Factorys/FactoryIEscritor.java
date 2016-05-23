/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Factorys;

import Modelo.Bitacora.IEscritor;

/**
 *
 * @author Mellvin
 */
public abstract class FactoryIEscritor {
    public abstract IEscritor crearBitacora(String tipoBitacora);
}
