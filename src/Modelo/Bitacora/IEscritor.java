package Modelo.Bitacora;

import DTO.*;

public interface IEscritor {
    
    public void crearArchivo();
    public boolean existeArchivo();
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion); 
}
