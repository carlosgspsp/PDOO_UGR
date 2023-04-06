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
public class Tablero {

    ArrayList<Casilla> casillas;
    boolean porSalida;
    int numCasillaCarcel;

    Tablero(int numCasillaCarcel) {
        casillas = new ArrayList<Casilla>();
        casillas.add(new Casilla("Salida"));
        porSalida = false;
        this.numCasillaCarcel = numCasillaCarcel;
    }

    private boolean correcto(int numCasilla) {
        if (casillas != null && numCasilla >= 0 && numCasilla < casillas.size()) {
            return true;
        } else {
            return false;
        }

    }

    boolean computarPasoPorSalida() {
        boolean aux = porSalida;
        porSalida = false;
        return aux;

    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    void añadeCasilla(Casilla casilla) {
        casillas.add(casilla);
    }

    public Casilla getCasilla(int numCasilla) {
        if (correcto(numCasilla)) {
            return casillas.get(numCasilla);
        } else {
            return null;
        }
    }

    int nuevaPosicion(int actual, int tirada) {
        int suma = actual + tirada;
        if (suma >= casillas.size()) {
            porSalida = true;
            return suma % casillas.size();
        } else {
            return suma;
        }
    }

}
