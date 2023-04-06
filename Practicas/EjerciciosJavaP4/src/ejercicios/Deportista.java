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
public class Deportista extends Persona {
    
    static int IVA = 21;
    float horasEntrenamiento;
    
    Deportista(String nombre){
        super(nombre);
        horasEntrenamiento = 0;
    }
    
    String competicionDeportiva(){
        return "Estoy compitiendo";
    }
    
    @Override
   public String toString(){
        return super.toString()+", hago deporte y entreno "+horasEntrenamiento+" horas";
    }

    public float getHorasEntrenamiento() {
        return horasEntrenamiento;
    }

    public static int getIVA() {
        return IVA;
    }
   
   
}
