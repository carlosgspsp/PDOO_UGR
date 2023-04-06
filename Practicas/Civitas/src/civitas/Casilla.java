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
public class Casilla {

//    private static float FACTORALQUILERCALLE = 1.0f;
//    private static float FACTORALQUILERCASA = 1.0f;
//    private static float FACTORALQUILERHOTEL = 4.0f;

    private String nombre;
   //private float precioCompra, precioEdificar, precioBaseAlquiler;
   //private int numCasas, numHoteles;
   //private TipoCasilla tipo;
   //private MazoSorpresas mazo;
   //private Sorpresa sorpresa;
   //private Jugador propietario;

    /*
    Casilla(TipoCasilla unTipo , String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase) {
        tipo = unTipo;
        nombre = unNombre;
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
        numCasas = 0;
        numHoteles = 0;
    }
     */

 /*
    Casilla() { //He inicializado todos los atributos a 0 o vacios puesto que no hay ninguna condicion especifica que deba cumplir excepto el numero de casas y hoteles iniciales. Añadiendo modificadores se podria especificar, posterior a la creacion del objeto, sus atributos
        this(TipoCasilla.DESCANSO, "", 0.0f, 0.0f, 0.0f);
    }
     */
    Casilla(String nombre) {
       //init();
        this.nombre = nombre;
    }
    
        void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(actual).getNombre() + " ha caido en la casilla " + this.nombre);
    }
    
      public String toString() {
        
        return  "\nNombre: " + nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    boolean igualdadIdentidad(Casilla otraCasilla) {
        return this == otraCasilla;
    }

    boolean igualdadEstado(Casilla otraCasilla) {

        return nombre.equals(otraCasilla.getNombre());

    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos) {
            informe(iactual, todos); 
    }

    /*
    Casilla(TipoCasilla tipo, String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler) {
        init();
        this.tipo = tipo;
        nombre = titulo;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    */

    /*
    Casilla(TipoCasilla tipo, String nombre, MazoSorpresas mazo) {
        init();
        this.tipo = tipo;
        this.nombre = nombre;
        this.mazo = mazo;
    }
    */

    /*private void init() {
        nombre = "";
       
        precioCompra = 0;
        precioEdificar = 0;
        precioBaseAlquiler = 0;
        numCasas = 0;
        numHoteles = 0;
        tipo = null;
        mazo = null;
        sorpresa = null;
        propietario = null;
       
    }*/

   /* void tramitarAlquiler(Jugador jugador) {
        if (tienePropietario()) {
            if (!esEsteElPropietario(jugador)) {
                jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
                propietario.recibe(this.getPrecioAlquilerCompleto());

            }
        }

    }*/

    /*
    int CantidadCasasHoteles() {
        return numHoteles + numCasas;
    }
    */



   /*
    boolean derruirCasas(int n, Jugador jugador) {
        if (esEsteElPropietario(jugador)) {
            if (numCasas >= n) {
                numCasas -= n;
                return true;
            }

        }
        return false;
    }
    */

    /*
    public boolean esEsteElPropietario(Jugador jugador) {
        if (jugador == this.propietario) {
            return true;
        } else {
            return false;
        }
    }
    */

   /*
    public boolean tienePropietario() {
        if (propietario == null) {
            return false;
        } else {
            return true;
        }
    }
    
    */

  

    /*
    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioEdificar() {
        return precioEdificar;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    */
    
    /*
    public float getPrecioAlquilerCompleto() {
        float alquiler;
        alquiler = this.precioBaseAlquiler * FACTORALQUILERCALLE * (1 + this.numCasas * FACTORALQUILERCASA + this.numHoteles * FACTORALQUILERHOTEL);
        return (alquiler);
    }
    */

    /*
    public boolean construirCasa(Jugador jugador) {
        jugador.paga(precioEdificar);
        ++this.numCasas;
        return true;
    }

    public boolean construirHotel(Jugador jugador) {
        jugador.paga(precioEdificar);
        ++this.numHoteles;
        return true;
    }
    
    */


   /* void recibeJugador(int iactual, ArrayList<Jugador> todos) {
        if (this.tipo == TipoCasilla.CALLE) {
            recibeJugador_calle(iactual, todos);
        } else if (this.tipo == TipoCasilla.SORPRESA) {
            recibeJugador_sorpresa(iactual, todos);
        } else if (this.tipo == TipoCasilla.DESCANSO) {
            informe(iactual, todos);
        }
    }*/

    /*void recibeJugador_calle(int iactual, ArrayList<Jugador> todos) {
        informe(iactual, todos);
        Jugador jugador = todos.get(iactual);

        if (!tienePropietario()) {
            jugador.puedeComprarCasilla();
        } else {
            tramitarAlquiler(jugador);
        }
    }*/
    
    /*void recibeJugador_sorpresa(int iactual,ArrayList<Jugador> todos){
        sorpresa = mazo.siguiente();
        informe(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);
    }
    */
    
    /*
    boolean comprar(Jugador jugador){
         propietario = jugador;
         propietario.paga(precioCompra);
         return true;
         
    }

    */
    
    
}
