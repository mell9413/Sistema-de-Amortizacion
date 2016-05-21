/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bitacora;

import DTO.DTOAmortizacion;



import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
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
    
    private static String nombreArchivo;
    
    public BitacoraXML(){
         nombreArchivo = "bitacoraXML.xml";
    }

    public void crearArchivo() {
        
       if (existeArchivo() == false){
           
            try {
 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                
                Document document = implementation.createDocument(null, "documento", null);
                document.setXmlVersion("1.0");
                
                Element raiz = document.getDocumentElement();
                
                Element nodoNombreCampo = document.createElement("ElementoHijoDeLaRaíz"); //creamos un nuevo elemento
                Text nodoValorCampo = document.createTextNode("contenido del elemento hijo"); //Ingresamos la info				
                nodoNombreCampo.appendChild(nodoValorCampo); 						
                raiz.appendChild(nodoNombreCampo); //pegamos el elemento a la raiz "Documento"
		
                Source source = new DOMSource(document);
                StreamResult result = new StreamResult(new File("C:\\Users\\Marianne\\Downloads\\archivo.xml"));
               // Result result = new StreamResult(new java.io.File("resultado.xml"));  
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
	//http://www.lawebdelprogramador.com/codigo/Java/3202-Como-crear-un-archivo-XML-con-Java.html
		
           
       } catch(Exception e) {
       
       
       }
        
    }
    }
         
        
    
   
 
    public void escribirMovimiento(DTOAmortizacion dtoAmortizacion) {
        
        
        
	}

    @Override
    public boolean existeArchivo() {
        //C:\Users\Marianne\Downloads
        String sfichero = "C:\\Users\\Marianne\\Downloads\\bitacoraXML.xml.";
        File fichero = new File(sfichero);
        
        if (fichero.exists()){
            return true ;
            
        }
        else{
            return false;
        }
    }

}
