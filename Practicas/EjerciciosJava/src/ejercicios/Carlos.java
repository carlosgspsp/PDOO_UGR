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



public class Carlos {
    
    private static String GARCIA = "García";
    
    private String Segura;
    
    Carlos(String e){
        Segura = e;
        
    }
            
   public void Mostrar(){
        System.out.println(Carlos.getGARCIA()+" "+this.Segura);
    }

    public static String getGARCIA() {
        return GARCIA;
    }
    
   
}
