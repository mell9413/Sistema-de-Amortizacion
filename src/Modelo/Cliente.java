/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import DTO.DTOCliente;
    

public class Cliente {
    
   private String nombre;
   private String primerApellido;
   private String segundoApellido;
   
   public Cliente(DTOCliente dtoCliente){
       this.nombre = dtoCliente.getNombre();
       this.primerApellido = dtoCliente.getPrimerApellido();
       this.segundoApellido = dtoCliente.getSegundoApellido();
   }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
   
   
}
