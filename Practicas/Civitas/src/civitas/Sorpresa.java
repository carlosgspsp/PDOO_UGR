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
public abstract class Sorpresa {

    String texto;
    //int valor;
    MazoSorpresas mazo;
    // TipoSorpresa tipo;

    Sorpresa(String texto) {
        this.texto = texto;
        //this.valor = valor;
        //this.tipo = tipo;
    }

    void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento("Se esta aplicando una sorpresa al jugador " + todos.get(actual).getNombre());
    }

    /* void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        switch (tipo) {
            case PAGARCOBRAR:
                aplicarAJugador_pagarCobrar(actual, todos);
                break;
            case PORCASAHOTEL:
                aplicarAJugador_porCasaHotel(actual, todos);
                break;

        }
      }

     */
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);

    public String toString() {
        return texto;
    }

    /*
    void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor);
    }
     */
 /*
    void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        Jugador aux = todos.get(actual);
        aux.modificarSaldo(valor * aux.cantidadCasasHoteles());
    }
     */
}
