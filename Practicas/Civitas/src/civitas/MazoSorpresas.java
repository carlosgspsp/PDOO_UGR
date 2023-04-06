/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author carlo
 */
public class MazoSorpresas {

    ArrayList<Sorpresa> sorpresas;
    boolean barajada;
    int usadas;
    boolean debug;

    void init() {
        sorpresas = new ArrayList<Sorpresa>();
        barajada = false;
        usadas = 0;
    }

    MazoSorpresas(boolean d) {
        init();
        debug = d;
        if (debug) {
            Diario.getInstance().ocurreEvento("Modo debug de MazoSorpresas activado.");
        }
    }

    MazoSorpresas() {
        init();
        debug = false;
    }

    void alMazo(Sorpresa s) {
        if (!barajada) {
            sorpresas.add(s);
        }
    }

    Sorpresa siguiente() {
        if (!barajada || usadas == sorpresas.size()) {
            if (!debug) {
                Collections.shuffle(sorpresas);
                barajada = true;
            }
            usadas = 0;
            
        }
        usadas+=1;
        Sorpresa aux = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(aux);
        return aux;
    }
}
