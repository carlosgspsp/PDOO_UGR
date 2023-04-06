package GUI;

import GUI.Vista;
import civitas.Casilla;
import civitas.CasillaCalle;
import civitas.CivitasJuego;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VistaTextual implements Vista {

    private static String separador = "=====================";

    private Scanner in;

    CivitasJuego juegoModel;

    public VistaTextual(CivitasJuego juegoModel) {
        in = new Scanner(System.in);
        this.juegoModel = juegoModel;
    }

    public void pausa() {
        System.out.print("\nPulsa una tecla");
        in.nextLine();
    }

    int leeEntero(int max, String msg1, String msg2) {
        Boolean ok;
        String cadena;
        int numero = -1;
        do {
            System.out.print(msg1);
            cadena = in.nextLine();
            try {
                numero = Integer.parseInt(cadena);
                ok = true;
            } catch (NumberFormatException e) { // No se ha introducido un entero
                System.out.println(msg2);
                ok = false;
            }
            if (ok && (numero < 0 || numero >= max)) {
                System.out.println(msg2);
                ok = false;
            }
        } while (!ok);

        return numero;
    }

    int menu(String titulo, ArrayList<String> lista) {
        String tab = "  ";
        int opcion;
        System.out.println(titulo);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(tab + i + "-" + lista.get(i));
        }

        opcion = leeEntero(lista.size(),
                "\n" + tab + "Elige una opción: ",
                tab + "Valor erróneo");
        return opcion;
    }

    public void actualiza() {

    if (!juegoModel.finalDelJuego()){
            System.out.println(juegoModel.getJugadorActual().toString());
            int casillaActual = juegoModel.getJugadorActual().getCasillaActual();
            System.out.println(juegoModel.getTablero().getCasilla(casillaActual));
            
        } else{
            ArrayList<Jugador> jugadores = juegoModel.getJugadores();
            
            for (int i = 0; i < jugadores.size(); i++){
                System.out.println("\n"+jugadores.get(i).toString());
            }
        }

    }

    public Respuesta comprar() {

        ArrayList<String> lista = new ArrayList<>();
           lista.add("SI");
           lista.add("NO");
       int respuesta = menu("¿Quieres comprar la calle?",lista);
        
       return  Respuesta.values()[respuesta];
    }
    
    public OperacionInmobiliaria elegirOperacion(){
        ArrayList<String> lista = new ArrayList<>();
           lista.add("Construir Casa");
           lista.add("Construir Hotel");
           lista.add("Terminar");
           
       int respuesta = menu("¿Que gestion inmobiliaria quiere realizar?",lista);
        
       return  OperacionInmobiliaria.values()[respuesta];
    }
    
    public int elegirPropiedad(){
        
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<CasillaCalle> propiedades = juegoModel.getJugadorActual().getPropiedades();
        for (int i = 0; i < propiedades.size(); i++){
            lista.add(propiedades.get(i).getNombre());
        }
       
        
        int respuesta = menu("¿Que propiedad desea gestionar?",lista);
        return respuesta;
        
    }
    
    
    public void mostrarSiguienteOperacion(OperacionJuego operacion){
        System.out.print(operacion.toString());
    }
    
    public void mostrarEventos(){
        while(Diario.getInstance().eventosPendientes()){
            System.out.println(Diario.getInstance().leerEvento());
        }
        
    }
    
    public void mostrarEstado(){
        if (!juegoModel.finalDelJuego()){
            System.out.println("\nINFORMACION DEL JUGADOR ACTUAL:");
            System.out.println(juegoModel.getJugadorActual().toString());
            
            System.out.println("\nINFORMACION DE LA CASILLA ACTUAL:");
            int casillaActual = juegoModel.getJugadorActual().getCasillaActual();
            System.out.println(juegoModel.getTablero().getCasilla(casillaActual));
            
        } else{
            ArrayList<Jugador> jugadores = juegoModel.getJugadores();
            
            for (int i = 0; i < jugadores.size(); i++){
                System.out.println("\n"+jugadores.get(i).toString());
            }
        }
    }
    

}
