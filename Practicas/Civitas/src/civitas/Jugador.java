package civitas;

import java.awt.Color;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlo
 */
public class Jugador implements Comparable<Jugador> {

    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    protected static int HotelesMax = 4;
    protected static float PasoPorSalida = 1000.0f;
    private static float SaldoInicial = 100.0f;
    private static int Jugadores = 0;
    private static Color ColorJugador1 = new Color(0, 255, 0);
    private static Color ColorJugador2 = new Color(255, 0, 0);
    private static Color ColorJugador3 = new Color(148, 206, 255);
    private static Color ColorJugador4 = new Color(255, 240, 0);

    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private ArrayList<CasillaCalle> propiedades;
    //private int indiceJugador;
    private Color colorJugador;

    protected Jugador(Jugador otro) {
        this.casillaActual = otro.getCasillaActual();
        this.nombre = otro.getNombre();
        this.puedeComprar = otro.getPuedeComprar();
        this.saldo = otro.getSaldo();
        this.propiedades = otro.getPropiedades();
        this.colorJugador = otro.colorJugador;
        //this.indiceJugador = otro.getIndiceJugador();
    }

    Jugador(String nombre) {
        casillaActual = 0;
        this.nombre = nombre;
        puedeComprar = false;
        saldo = SaldoInicial;
        propiedades = new ArrayList<>();
        //indiceJugador = Jugadores;

        switch (Jugadores) {
            case 0:
                colorJugador = ColorJugador1;
                break;
            case 1:
                colorJugador = ColorJugador2;
                break;
            case 2:
                colorJugador = ColorJugador3;
                break;
            case 3:
                colorJugador = ColorJugador4;
                break;
        }
        Jugadores += 1;
    }

    private static int getCasasMax() {
        return CasasMax;
    }

    public static int getCasasPorHotel() {
        return CasasPorHotel;
    }

    private static int getHotelesMax() {
        return HotelesMax;
    }

    private static float getPremioPasoPorSalida() {
        return PasoPorSalida;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getPuedeComprar() {
        return puedeComprar;
    }

    public float getSaldo() {
        return saldo;
    }

    public ArrayList<CasillaCalle> getPropiedades() {
        return propiedades;
    }

    public Color getColorJugador() {
        return colorJugador;
    }

    public static Color getColorJugador1() {
        return ColorJugador1;
    }

    public static Color getColorJugador2() {
        return ColorJugador2;
    }

    public static Color getColorJugador3() {
        return ColorJugador3;
    }

    public static Color getColorJugador4() {
        return ColorJugador4;
    }
    
    

    /*
     public int getIndiceJugador() {
        return indiceJugador;
    }
    */
    boolean existeLaPropiedad(int ip) {
        if (ip < propiedades.size()) {
            return true;
        } else {
            return false;
        }

    }

    boolean puedeComprarCasilla() {
        puedeComprar = true;
        return puedeComprar;
    }

    float paga(float cantidad) {
         modificarSaldo(cantidad * -1);
         return cantidad;
    }

    float pagaAlquiler(float cantidad) {
        return paga(cantidad);
         
    }

    boolean recibe(float cantidad) {
        return modificarSaldo(cantidad);
    }

    boolean modificarSaldo(float cantidad) {
        saldo += cantidad;
        Diario.getInstance().ocurreEvento("El saldo del jugador " + this.nombre + " ha sido modificado en " + cantidad + ". Ahora su saldo es " + saldo);
        return true;
    }

    int cantidadCasasHoteles() {
        int suma = 0;
        for (int i = 0; i < propiedades.size(); i++) {
            suma += propiedades.get(i).CantidadCasasHoteles();
        }
        return suma;
    }

    boolean moverACasilla(int numCasilla) {
        casillaActual = numCasilla;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " ha sido movido a la casilla " + numCasilla);
        return true;
    }

    private boolean puedoGastar(float precio) {
        return saldo >= precio;
    }

    public boolean tieneAlgoQueGestionar() {
        return propiedades != null;
    }

    boolean pasaPorSalida() {
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " ha pasado por la salida y ha recibido " + PasoPorSalida);
        return true;
    }

    @Override
    public int compareTo(Jugador o) {
        return Float.compare(saldo, o.getSaldo());
    }

    boolean enBancarrota() {
        return saldo < 0;
    }

    private boolean puedoEdificarCasa(CasillaCalle propiedad) {
        if (puedoGastar(propiedad.getPrecioEdificar())) {
            if (propiedad.getNumCasas() < CasasMax) {
                return true;
            }
        }

        return false;
    }

    private boolean puedoEdificarHotel(CasillaCalle propiedad) {
        if (puedoGastar(propiedad.getPrecioEdificar())) {
            if (propiedad.getNumHoteles() < HotelesMax) {
                if (propiedad.getNumCasas() >= CasasPorHotel) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean comprar(CasillaCalle titulo) {
        boolean result = false;
        if (puedeComprar) {
            float precio = titulo.getPrecioCompra();

            if (puedoGastar(precio)) {
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " compra la propiedad " + titulo.getNombre());
                puedeComprar = false;
            } else {
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " no tiene saldo para comprar la propiedad " + titulo.getNombre());
            }

        }
        return result;
    }

    boolean construirCasa(int ip) {
        boolean result = false;

        boolean existe = existeLaPropiedad(ip);
        if (existe) {
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            if (puedoEdificar) {
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " Construye casa en la propiedad " + ip);
            }

        }
        return result;
    }

    boolean construirHotel(int ip) {
        boolean result = false;

        if (existeLaPropiedad(ip)) {
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = this.puedoEdificarHotel(propiedad);
            if (puedoEdificarHotel) {
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " Construye hotel en la propiedad " + ip);
            }
        }
        return result;
    }

    JugadorEspeculador convertir() {
        JugadorEspeculador jugador = new JugadorEspeculador(this);
        return jugador;

    }

    public String toString() {

        String propiedades = "";
        for (int i = 0; i < this.propiedades.size(); i++) {
            propiedades += ("\n\n" + this.propiedades.get(i).toString());
        }
        return "El nombre del jugador es: " + nombre + "\nSu casilla actual es: " + casillaActual
                + "\n¿Puede comprar? " + puedeComprar + "\nSu saldo es: " + saldo
                + "\n Sus propiedades son: " + propiedades;
    }

}
