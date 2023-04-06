/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author carlo
 */
public class Persona {
    String nombre;
    
    Persona(String nombre){
        this.nombre = nombre;
    }
    
    String andar(){
        return "Soy "+nombre+" y estoy andando";
    }
    
    @Override
   public String toString(){
        return "Soy una persona y mi nombre es "+nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
