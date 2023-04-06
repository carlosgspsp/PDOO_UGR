/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import GUI.Dado;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class CivitasJuego {

    int indiceJugadorActual;
    ArrayList<Jugador> jugadores;
    Tablero tablero;
    EstadoJuego estado;
    GestorEstados gestor;
    MazoSorpresas mazo;

    public CivitasJuego(ArrayList<String> nombres, boolean debug) {

        jugadores = new ArrayList<>();
        for (int i = 0; i < nombres.size(); i++) {
            jugadores.add(new Jugador(nombres.get(i)));
        }

        gestor = new GestorEstados();
        estado = gestor.estadoInicial();
        Dado.getInstance().setDebug(debug);
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        mazo = new MazoSorpresas(debug);
        tablero = new Tablero(5);
        inicializaTablero(mazo);
        inicializaMazoSorpresas();
    }

   public CivitasJuego(ArrayList<String> nombres) {
        this(nombres, false);
    }

    private void inicializaTablero(MazoSorpresas mazo) {
       
        
        tablero.añadeCasilla(new CasillaCalle( "Doctor Oloritz", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle( "Doctor Marañon", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle( "Doctor Fleming", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle( "Doctor Azpizarte", 100.0f, 50.0f, 50.0f));

        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));

        tablero.añadeCasilla(new CasillaCalle("Gonzalo Gallas", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Pedro Antonio", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Calle Sol", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Calle Pintor Velazquez", 100.0f, 50.0f, 50.0f));

        tablero.añadeCasilla(new Casilla("Parking"));
        
        tablero.añadeCasilla(new CasillaCalle("Calle Colegios", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Calle Caballerizas", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Calle San Juan de Dios", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Gran Capitan", 100.0f, 50.0f, 50.0f));
        
        tablero.añadeCasilla(new CasillaSorpresa("Casilla Sorpresa", mazo));
        
        tablero.añadeCasilla(new CasillaCalle("Calle Gorrion", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Calle Ruiseñor", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Calle Cisne", 100.0f, 50.0f, 50.0f));
        tablero.añadeCasilla(new CasillaCalle("Calle Gaviota", 100.0f, 50.0f, 50.0f));
        
    }

    private void inicializaMazoSorpresas() {
        mazo.alMazo(new SorpresaPagarCobrar("Recibe 500", 500));
        mazo.alMazo(new SorpresaPagarCobrar("Pierde 500", -500));

        mazo.alMazo(new SorpresaPorCasaHotel("Por cada casa u hotel que poseas recibe 100", 100));
        mazo.alMazo(new SorpresaPorCasaHotel("Por cada casa u hotel que poseas pierde 100", 100));
        
        mazo.alMazo(new SorpresaConvertirme("Ahora eres un Jugador Especulador"));
    }

    public Jugador getJugadorActual() {
        return jugadores.get(indiceJugadorActual);
    }

    public int getIndiceJugadorActual() {
        return indiceJugadorActual;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }
    
    

    private void contabilizarPasosPorSalida(Jugador jugadorActual) {
        if (tablero.computarPasoPorSalida()) {
            jugadorActual.pasaPorSalida();
        }

    }

    public void pasarTurno() {
        if (indiceJugadorActual == jugadores.size()-1) {
            indiceJugadorActual = 0;
        } else {
            indiceJugadorActual += 1;
        }
    }

    public void siguientePasoCompletado(OperacionJuego operacion) {
        estado = gestor.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }

    public boolean construirCasa(int ip) {
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }

    public boolean construirHotel(int ip) {
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }

    public boolean finalDelJuego() {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).enBancarrota()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Jugador> ranking() {

        ArrayList<Jugador> aux = new ArrayList<>(jugadores);

        for (int i = 0; i < aux.size(); i++) {
            for (int j = i; j < aux.size(); j++) {
                if (aux.get(i).compareTo(aux.get(j)) < 0) {
                    Jugador jaux = aux.get(i);
                    aux.set(i, aux.get(j));
                    aux.set(j, jaux);
                }
            }

        }
        jugadores = aux;
        return jugadores;
    }
    
    void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida(jugadorActual);
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = this.getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        if (operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        } else if (operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
   public boolean comprar(){
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        CasillaCalle casilla = (CasillaCalle)tablero.getCasilla(numCasillaActual);
        return jugadorActual.comprar(casilla);
    }

}
