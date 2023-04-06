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
public class Corredor extends Deportista {
    
    static int IVA = 33;
    
    Corredor(String nombre){
     super(nombre);   
    }
    
    String correr(){
        return "Estoy corriendo.";
    }
    
    @Override
    public String toString(){
        return super.toString()+", estoy corriendo";
    }
   
}
