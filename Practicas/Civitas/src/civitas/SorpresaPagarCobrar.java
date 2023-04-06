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
public class SorpresaPagarCobrar extends Sorpresa{
    
    int valor;
    
    SorpresaPagarCobrar(String texto, int valor){
        super(texto);
        this.valor = valor;
    }
    
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor);
    }
    
}
