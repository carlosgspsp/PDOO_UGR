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
public class Alquiler {
    String fecha;
    Cliente2 cliente;
    Pelicula pelicula;
    
    Alquiler(String fecha, Pelicula pelicula, Cliente2 cliente){
        this.fecha = fecha;
        this.cliente = cliente;
        this.pelicula = pelicula;
    }
    
    
}
