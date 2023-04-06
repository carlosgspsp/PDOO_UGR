
import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import GUI.VistaTextual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public class JuegoTexto {
    public static void main(String[] args) {
        
        boolean debug = true;
        
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Carlos");
        //nombres.add("Nacho");
        //nombres.add("Suso");
        nombres.add("Jose Manu");
        CivitasJuego juego = new CivitasJuego(nombres, debug);
        VistaTextual vista = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego, vista);
        controlador.juega();
    }
}
