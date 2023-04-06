/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class EjerciciosJavaP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /*
        Casilla casilla = new Casilla("Salida");
        CasillaCalle casillaCalle = new CasillaCalle("Avenida Madrid");
        
        casilla.recibeJugador();
        casillaCalle.recibeJugador();
        // 1.Puede usarlo porque las clases hijas tienen acceso a los metodos no privados de la clase padre.
        // 2.Ejecuta el de su clase.
        // 3.Ejecuta el de su clase y ese ejecuta el del padre.
        
        //casilla.construirCasa();
        casillaCalle.construirCasa();
        
        ArrayList<Casilla> tablero = new ArrayList<>();
        tablero.add(casilla);
        tablero.add(casillaCalle);
        
       // tablero.get(0).construirCasa(); //No se puede encontrar el metodo
       // tablero.get(1).construirCasa(); //No se puede encontrar el metodo
        ((CasillaCalle)tablero.get(1)).construirCasa();
        */
      
      CasillaCalle casilla1 = new CasillaCalle("Avenida Madrid");
      Casilla casilla2 = casilla1;
      casilla1.recibeJugador();
      casilla2.recibeJugador();
      //Ambas ejecutan el metodo del hijo porque ambas variables referencian a un objeto CasillaCalle y el metodo que van a ejecutar siempre va a corresponder con el del objeto al que referencian
      
      casilla1.construirCasa();
      ((CasillaCalle)casilla2).construirCasa();
      //Hay que hacer casting porque aunque en tiempo de ejecucion el objeto referenciado es CasillCalle, en tiempo de compilacion el objeto sigue siendo Casilla, el cual no tiene ningun metodo construirCasa por lo que da error al compilar.
      
    
     ArrayList<Persona> personas = new ArrayList();
     
    
      Persona persona = new Persona("Juan");
      Deportista deportista = new Deportista("Nacho");
      Corredor corredor = new Corredor("Jose");
      Nadador nadador = new Nadador("Angel");
      
       personas.add(persona);
        personas.add(deportista);
        personas.add(corredor);
      
        System.out.println(((Corredor)personas.get(2)).competicionDeportiva());
        
        System.out.println(persona.toString());
       System.out.println(deportista.toString());
       System.out.println(corredor.toString());
       System.out.println(nadador.toString());

       System.out.println(persona.andar());
       System.out.println(deportista.andar());
       System.out.println(corredor.andar());
       System.out.println(nadador.andar());
  
       System.out.println(deportista.competicionDeportiva());
       System.out.println(corredor.competicionDeportiva());
       System.out.println(nadador.competicionDeportiva());

  
       System.out.println(corredor.correr());
       System.out.println(nadador.nadar());
       
       System.out.println("ESTE ES EL IVA");
       System.out.println(corredor.getIVA());
       
       

      
    }
    
}
