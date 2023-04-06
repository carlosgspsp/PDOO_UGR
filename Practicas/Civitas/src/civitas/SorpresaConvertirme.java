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
public class SorpresaConvertirme extends Sorpresa{
    
     SorpresaConvertirme(String texto){
        super(texto);
    }

    @Override
     void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
       informe(actual, todos);
        JugadorEspeculador jugador = todos.get(actual).convertir();
       todos.set(actual, jugador);
    }
}
