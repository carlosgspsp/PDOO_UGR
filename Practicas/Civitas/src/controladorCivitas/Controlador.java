/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorCivitas;

import civitas.CivitasJuego;
import civitas.GestionInmobiliaria;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import GUI.Vista;
import GUI.VistaTextual;

/**
 *
 * @author carlo
 */
public class Controlador {

    Vista vista;
    CivitasJuego juego;

    public Controlador(CivitasJuego juego, Vista vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void juega() {

        boolean fin = false;
        while (!fin) {
            vista.mostrarEstado();
            vista.pausa();
            OperacionJuego op = juego.siguientePaso();
            vista.mostrarSiguienteOperacion(op);
            if (op != OperacionJuego.PASAR_TURNO) {
                vista.mostrarEventos();
            }
            fin = juego.finalDelJuego();
            if (!fin) {
                if (op == OperacionJuego.COMPRAR) {
                    Respuesta respuesta = vista.comprar();

                    if (respuesta == Respuesta.SI) {
                        juego.comprar();
                    }
                    juego.siguientePasoCompletado(op);
                } else if (op == OperacionJuego.GESTIONAR) {
                    OperacionInmobiliaria opi = vista.elegirOperacion();

                    if (opi != OperacionInmobiliaria.TERMINAR) {
                        if (juego.getJugadorActual().tieneAlgoQueGestionar()) {
                            int propiedad = vista.elegirPropiedad();
                            GestionInmobiliaria gestion = new GestionInmobiliaria(opi, propiedad);

                            if (opi == OperacionInmobiliaria.CONSTRUIR_CASA) {
                                juego.construirCasa(propiedad);
                            } else if (opi == OperacionInmobiliaria.CONSTRUIR_HOTEL) {
                                juego.construirHotel(propiedad);
                            }
                        }

                    } else {
                        juego.siguientePasoCompletado(op);
                    }
                }

            } else {
                juego.ranking();
                vista.mostrarEstado();
            }

        }
    }

}
