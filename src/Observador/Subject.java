package Observador;

import DTO.*;
import Modelo.Bitacora.IEscritor;
import java.util.ArrayList;

public class Subject implements ISubject {
    
    private DTOAmortizacion subjectState;

    @Override
    public void AgregarObserver(IEscritor bitacora) {
        observers.add(bitacora);
    }

    @Override
    public void EliminarObserver(IEscritor bitacora) {
        for (IEscritor element: observers){
            if (element.equals(bitacora)){
                observers.remove(element);
            }
        }
    }

    @Override
    public void NotifyAllObservers() {
        for (IEscritor element: observers){
            element.updateEscribirMovimiento();
        }
    }
    @Override
    public DTOAmortizacion getSubjectState() {
        return subjectState;
    }
    @Override
    public void setSubjectState(DTOAmortizacion subjectState) {
        this.subjectState = subjectState;
        NotifyAllObservers();
    }
}
