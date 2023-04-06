/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class SorpresaPorCasaHotel extends Sorpresa{
    int valor;
    SorpresaPorCasaHotel(String texto, int valor){
        super(texto);
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        Jugador aux = todos.get(actual);
        aux.modificarSaldo(valor * aux.cantidadCasasHoteles());
    }
    
}
