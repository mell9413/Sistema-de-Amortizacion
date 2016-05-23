package Modelo.Bitacora;

import Data.Lector;
import DTO.DTOAmortizacion;
import java.io.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class BitacoraXML implements IEscritor{
    private static String nombreArchivo;
    
    public BitacoraXML(){
         nombreArchivo = "bitacoraXML.xml";
    }

    @Override
    public void crearArchivo() {         
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();            
            Element rootElement = doc.createElement("Registro");
            doc.appendChild(rootElement);                
            formatearDocumento(doc);
        } catch (Exception ex) {
            Logger.getLogger(BitacoraXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
    private void formatearDocumento(Document doc) throws IOException, TransformerException{
        try {
            TransformerFactory transFact = TransformerFactory.newInstance();
            transFact.setAttribute("indent-number", new Integer(3));
            Transformer trans = transFact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");  //Sangria
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            Source source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(Lector.obtenerRutaCarpeta()+nombreArchivo));
            trans.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(BitacoraXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion) {        
        if (existeArchivo()){
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(Lector.obtenerRutaCarpeta()+nombreArchivo);
                
                Node raiz = doc.getFirstChild();                
                
                Element movimiento = doc.createElement("Movimiento");
                movimiento.setAttribute("Cliente", String.valueOf(dtoAmortizacion.getCliente().getNombre() +" "+dtoAmortizacion.getCliente().getPrimerApellido()+" "+dtoAmortizacion.getCliente().getSegundoApellido()));
                raiz.appendChild(movimiento);
                
                Element montoPrestamo = doc.createElement("MontoPrestamo");
                montoPrestamo.setTextContent(String.valueOf(dtoAmortizacion.GetMonto_prestamo()));
                movimiento.appendChild(montoPrestamo);
                
                Element plazoPrestamo = doc.createElement("PlazoPrestamo");
                plazoPrestamo.setTextContent(String.valueOf(dtoAmortizacion.GetPlazo()));
                movimiento.appendChild(plazoPrestamo);
                
                Element interesPrestamo = doc.createElement("InteresPrestamo");
                interesPrestamo.setTextContent(String.valueOf(dtoAmortizacion.GetInteres_anual()));
                movimiento.appendChild(interesPrestamo);
                
                Element moneda = doc.createElement("MonedaPrestamo");
                moneda.setTextContent(String.valueOf(dtoAmortizacion.GetMoneda()));
                movimiento.appendChild(moneda);
                
                formatearDocumento(doc);
            } catch (Exception ex) {
                Logger.getLogger(BitacoraXML.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
        else{
            crearArchivo();
            escribirMovimiento(dtoAmortizacion);
        }
    }

    @Override
    public boolean existeArchivo() {    
        try {
            String sfichero =  Lector.obtenerRutaCarpeta()+nombreArchivo;
            File fichero = new File(sfichero);           
            if (fichero.exists()){  
                return true ;  
            }
            else{
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(BitacoraXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
}