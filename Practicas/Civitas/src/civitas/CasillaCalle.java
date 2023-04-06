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
public class CasillaCalle extends Casilla {

    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f;
    private static float FACTORJUGADORESPECULADOR = 0.5f;

    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;

    private Jugador propietario;

    CasillaCalle(String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase) {
        super(unNombre);
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
        numCasas = 0;
        numHoteles = 0;
        propietario = null;
    }

    void tramitarAlquiler(Jugador jugador) {
        float alquiler, dineroPagado;
        if (tienePropietario()) {
            if (!esEsteElPropietario(jugador)) {
                    alquiler = this.getPrecioAlquilerCompleto();
                dineroPagado = jugador.pagaAlquiler(alquiler);
                propietario.recibe(dineroPagado);

            }
        }

    }

    int CantidadCasasHoteles() {
        return numHoteles + numCasas;
    }

    boolean derruirCasas(int n, Jugador jugador) {
        if (esEsteElPropietario(jugador)) {
            if (numCasas >= n) {
                numCasas -= n;
                return true;
            }

        }
        return false;
    }

    public boolean esEsteElPropietario(Jugador jugador) {
        if (jugador == this.propietario) {
            return true;
        } else {
            return false;
        }
    }

    public boolean tienePropietario() {
        if (propietario == null) {
            return false;
        } else {
            return true;
        }
    }

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

    public Jugador getPropietario() {
        return propietario;
    }

    public float getPrecioAlquilerCompleto() {
        float alquiler;
        alquiler = this.precioBaseAlquiler * FACTORALQUILERCALLE * (1 + this.numCasas * FACTORALQUILERCASA + this.numHoteles * FACTORALQUILERHOTEL);
        return (alquiler);
    }

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

    boolean comprar(Jugador jugador) {
        propietario = jugador;
        propietario.paga(precioCompra);
        return true;

    }

    void recibeJugador(int iactual, ArrayList<Jugador> todos) {
        informe(iactual, todos);
        Jugador jugador = todos.get(iactual);

        if (!tienePropietario()) {
            jugador.puedeComprarCasilla();
        } else {
            tramitarAlquiler(jugador);
        }
    }

    public String toString() {
        String propietario;
        if (!tienePropietario()) {
            propietario = "Esta casilla no tiene propietario";
        } else {
            propietario = this.propietario.getNombre();
        }

        return super.toString() + "\nPrecio de Compra: " + precioCompra
                + "\nPrecio de Edificar: " + precioEdificar + "\nPrecio Base del Alquiler: "
                + precioBaseAlquiler + "\nNúmero de Casas: " + numCasas + "\nNúmero de Hoteles: " + numHoteles
                + "\nNombre del propietario: " + propietario;
    }

    void actualizaPropietarioPorConversion(Jugador jugador) {
        propietario = jugador;
    }

    boolean igualdadEstado(CasillaCalle otraCasilla) {

        return super.igualdadEstado(otraCasilla)
                && precioCompra == otraCasilla.getPrecioCompra()
                && precioEdificar == otraCasilla.getPrecioEdificar()
                && numCasas == otraCasilla.getNumCasas()
                && numHoteles == otraCasilla.getNumHoteles()
                && this.getPrecioAlquilerCompleto() == otraCasilla.getPrecioAlquilerCompleto();

    }

}
