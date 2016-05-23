/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bitacora;
import Data.Lector;
import DTO.DTOAmortizacion;



import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import static org.jdom2.filter.Filters.document;
 
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Marianne
 */
public class BitacoraXML implements IEscritor{
    //https://blogdeaitor.wordpress.com/2012/10/18/xml_java/
    private static String nombreArchivo;
    
    public BitacoraXML(){
         nombreArchivo = "bitacoraXML.xml";
    }

    
    
    
    public void crearArchivo() {
        
       if (existeArchivo() == false){
         try {
               
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
             
                Element rootElement = doc.createElement("Registro");
                doc.appendChild(rootElement);
                formatearDocumento(doc);
	        
           
       } catch(Exception e) {}
        
    }
    }
         
        private void formatearDocumento(Document doc){
               try{
                  
                   TransformerFactory transFact = TransformerFactory.newInstance();
                   transFact.setAttribute("indent-number", new Integer(3));
                   Transformer trans = transFact.newTransformer();
     
                  trans.setOutputProperty(OutputKeys.INDENT, "yes");  //Sangria
                  trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                  Source source = new DOMSource(doc);
                  
                  //StreamResult result = new StreamResult (new java.io.File(this.nombreArchivo));
                  StreamResult result = new StreamResult(new File("C:\\Users\\Marianne\\Desktop\\Sistema-de-Amortizacion\\src\\Data\\bitacoraXML.xml."));
                   
                  trans.transform(source, result);
                 
               } catch (Exception e){}
        }
        
        
        
 
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion) {
        
        if (existeArchivo()){
            
            try {
                
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(BitacoraXML.nombreArchivo);
    
                Element rootElement = doc.getDocumentElement();
                Element tagRaiz = (Element) rootElement.getElementsByTagName("Registro").item(0); 
                
                Element TipoAmortizacion = doc.createElement("Tipo Amortizacion");
                TipoAmortizacion.setTextContent(dtoAmortizacion.GetTipoAmortizacion());
                rootElement.appendChild(TipoAmortizacion);
    
                //AQUI SOLO DEVUELVE EL OBJETO
                Element nombre = doc.createElement("Nombre Cliente");
                nombre.setTextContent(String.valueOf(dtoAmortizacion.getCliente()));
                rootElement.appendChild(nombre);
                
                Element montoPrestamo = doc.createElement("Monto Prestamo");
                rootElement.setTextContent(String.valueOf(dtoAmortizacion.GetMonto_prestamo()));
                rootElement.appendChild(montoPrestamo);
                
                Element plazoPrestamo = doc.createElement("Plazo Prestamo");
                rootElement.setTextContent(String.valueOf(dtoAmortizacion.GetPlazo()));
                rootElement.appendChild(plazoPrestamo);
                
                Element interesPrestamo = doc.createElement("Interes Prestamo");
                rootElement.setTextContent(String.valueOf(dtoAmortizacion.GetInteres_anual()));
                rootElement.appendChild(interesPrestamo);
                
                Element moneda = doc.createElement("Moneda Prestamo");
                rootElement.setTextContent(String.valueOf(dtoAmortizacion.GetMoneda()));
                rootElement.appendChild(moneda);
               
                tagRaiz.appendChild(rootElement); //Envia el nodo
                formatearDocumento(doc);
           
            
            }catch(Exception e){}
       
        }
        
	}
        

  

    @Override
    public boolean existeArchivo() {
     
         String sfichero =  "C:\\Users\\Marianne\\Desktop\\Sistema-de-Amortizacion\\src\\Data\\bitacoraXML.xml.";
         File fichero = new File(sfichero);
       
        if (fichero.exists()){
            
            System.out.println("claro");
            return true ;
            
            
        }
        else{
            System.out.println("no");
            return false;
        }
    }

   
}
