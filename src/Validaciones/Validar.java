package Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
    
    public static boolean validarLetras(String palabra){
        Pattern pat = Pattern.compile("([a-z]|[A-Z]|\\\\s)+");
        Matcher mat = pat.matcher(palabra);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean validarNumeros(String dato){
        Pattern pat = Pattern.compile("[0-9]*");
        Matcher mat = pat.matcher(dato);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean validarRango(int seleccion, int largo){
        if(seleccion != 0 && seleccion <=largo){
            return true;
        }
        else{
            return false;
        }
    }
}
