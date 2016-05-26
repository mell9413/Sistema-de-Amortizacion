package Modelo.Bitacora;

import DTO.*;
import Observador.*;

public interface IEscritor {
    public void crearArchivo();
    public boolean existeArchivo();
    public void updateEscribirMovimiento();
}