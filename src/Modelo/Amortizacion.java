package Modelo;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Amortizacion {
    public String obtenerTipoCambio() throws IOException{
        try{
            Document doc = Jsoup.connect("http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/cuadros/frmvercatcuadro.aspx?CodCuadro=400").get();
            Element table = doc.getElementById("theTable400");
            Elements tds = table.getElementsByTag("td");
            //System.out.println(tds.get(66).text());
            return tds.get(66).text();
        }
        catch (Exception e ) {
           return "Fallo en la conexión";
        }
    }
}
