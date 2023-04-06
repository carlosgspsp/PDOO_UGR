/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;

/**
 *
 * @author carlo
 */
public class Dado {

    private static Dado instance = new Dado();
    private static int CARAMAYORDADO = 6;
    private static int CARAMENORDADO = 1;
    private static int NUMERODEBUGACTIVADO = 1;

    private Random random;
    int ultimoResultado;
    boolean debug;

    private Dado() {
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }

   static public Dado getInstance() {
        return instance;
    }

    int tirar() {
        if (debug) {
            ultimoResultado = NUMERODEBUGACTIVADO;
            return NUMERODEBUGACTIVADO;
        } else {
            int aux = random.nextInt(CARAMAYORDADO) + CARAMENORDADO;
            ultimoResultado = aux;
            return aux;

        }
    }

    int quienEmpieza(int n) {
        return random.nextInt(n);
    }

    void setDebug(boolean d) {
        debug = d;
        Diario.getInstance().ocurreEvento("El modo debug de Dado se ha puesto en: " + d);
    }

    int getUltimoResultado() {
        return ultimoResultado;
    }

    
}
