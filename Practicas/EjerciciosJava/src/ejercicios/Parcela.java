/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author carlo
 */
public class Parcela {
    
    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f;
    
    
    private String nombre;
    private float precioCompra, precioEdificar, precioAlquilerBase;
    private int numCasas, numHoteles;

    Parcela(String nombre, float precio_compra, float precio_edificar, float precio_alquiler_base) {
        this.nombre = nombre;
        precioCompra = precio_compra;
        precioEdificar = precio_edificar;
        precioAlquilerBase = precio_alquiler_base;
        numCasas = 0;
        numHoteles = 0;
    }
    
    Parcela() { //He inicializado todos los atributos a 0 o vacios puesto que no hay ninguna condicion especifica que deba cumplir excepto el numero de casas y hoteles iniciales. Añadiendo modificadores se podria especificar, posterior a la creacion del objeto, sus atributos
        this.nombre = "";
        precioCompra = 0;
        precioEdificar = 0;
        precioAlquilerBase = 0;
        numCasas = 0;
        numHoteles = 0;
    }

    public String getNombre() {
        return nombre;
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

    public float getAlquilerCompleto() {
        float alquiler;
        alquiler = this.precioAlquilerBase * FACTORALQUILERCALLE * (1 + this.numCasas * FACTORALQUILERCASA + this.numHoteles * FACTORALQUILERHOTEL);
        //alquiler = this.precioAlquilerBase * (1 + this.numCasas + this.numHoteles * 4.0f);
        return (alquiler);
    }

    public boolean construirCasa() {
        ++this.numCasas;
        return true;
    }

    public boolean construirHotel() {
        ++this.numHoteles;
        return true;
    }

    boolean igualdadIdentidad(Parcela otraParcela) {
        return this == otraParcela;
    }

    boolean igualdadEstado(Parcela otraParcela) {
     
             return nombre.equals(otraParcela.getNombre())
                && precioCompra == otraParcela.getPrecioCompra()
                && precioEdificar == otraParcela.getPrecioEdificar()
                && numCasas == otraParcela.getNumCasas()
                && numHoteles == otraParcela.getNumHoteles()
                && this.getAlquilerCompleto() == otraParcela.getAlquilerCompleto();
             
         
  
}

}
