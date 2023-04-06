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
public class Nadador extends Deportista {

    Nadador(String nombre) {
        super(nombre);
    }

    String nadar() {
        return "Estoy nadando.";
    }

    @Override
    public String toString() {
        return super.toString() + ", estoy nadando";
    }

}

