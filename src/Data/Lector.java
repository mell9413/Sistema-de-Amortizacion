package Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


public class Lector {
    
    public static String obtenerRutaCarpeta() throws IOException{
        String ruta = (new File (".")).getCanonicalPath()+"\\src\\Data\\";
        return ruta;
    }
    
    public static ArrayList obtenerTiposAmortizaciones() throws IOException, JDOMException{
        ArrayList tiposAmortizacion = new ArrayList();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( obtenerRutaCarpeta()+"tiposAmortizacion.xml" );
        Document document = (Document) builder.build( xmlFile );
        Element rootNode = document.getRootElement();
        List list = rootNode.getChildren( "row" );
        for ( int i = 0; i < list.size(); i++ ){
            Element tabla = (Element) list.get(i);
            tiposAmortizacion.add(tabla.getChildTextTrim("Nombre"));
        }
        return tiposAmortizacion;
    }
    
    public static ArrayList obtenerMonedas() throws IOException, JDOMException{
        ArrayList tiposAmortizacion = new ArrayList();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( obtenerRutaCarpeta()+"tiposMonedas.xml" );
        Document document = (Document) builder.build( xmlFile );
        Element rootNode = document.getRootElement();
        List list = rootNode.getChildren( "row" );
        for ( int i = 0; i < list.size(); i++ ){
            Element tabla = (Element) list.get(i);
            tiposAmortizacion.add(tabla.getChildTextTrim("Nombre"));
        }
        return tiposAmortizacion;
    }
}
