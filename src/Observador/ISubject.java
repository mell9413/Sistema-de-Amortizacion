package Observador;

import DTO.DTOAmortizacion;
import Modelo.Bitacora.*;
import java.util.ArrayList;

public interface ISubject {
    public ArrayList<IEscritor> observers = new ArrayList<IEscritor>();  
    public abstract void AgregarObserver(IEscritor bitacora);
    public abstract void EliminarObserver(IEscritor bitacora);
    public abstract void NotifyAllObservers();
    public void setSubjectState(DTOAmortizacion subjectState);
    public DTOAmortizacion getSubjectState();
}
