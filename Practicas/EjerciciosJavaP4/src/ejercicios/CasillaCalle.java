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
public class CasillaCalle extends Casilla {

    int numCasas;

    CasillaCalle(String nombre) {
        super(nombre);
        numCasas = 0;
    }

    /*boolean recibeJugador() {
        System.out.println("Soy una casilla calle y he recibido un jugador");
        return true;
    }*/

    @Override
    boolean recibeJugador() { // reutilizando codigo padre
        boolean respuesta = super.recibeJugador();
        if (respuesta) {
            System.out.println("Y ademas soy una casilla calle");
            return true;
        }

        return false;
    }
    
    void construirCasa() {
        numCasas+=1;
        System.out.println("Hay "+numCasas+" casa(s) construidas.");
    }
}
