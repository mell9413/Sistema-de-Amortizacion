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
    
}
